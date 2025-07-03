package java8.practice;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryManagementSystem {
    // Nested classes for data structure
    public static class Author {
        private final String id;
        private final String name;
        private final LocalDate birthDate;
        private final List<String> genres;

        public Author(String id, String name, LocalDate birthDate, List<String> genres) {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
            this.genres = new CopyOnWriteArrayList<>(genres);
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public List<String> getGenres() {
            return genres;
        }
    }

    public static class Book {
        private final String isbn;
        private final String title;
        private final Author author;
        private final int publicationYear;
        private final String genre;
        private final double rating;
        private final int copiesAvailable;

        public Book(String isbn, String title, Author author, int publicationYear,
                    String genre, double rating, int copiesAvailable) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.publicationYear = publicationYear;
            this.genre = genre;
            this.rating = rating;
            this.copiesAvailable = copiesAvailable;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public Author getAuthor() {
            return author;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        public String getGenre() {
            return genre;
        }

        public double getRating() {
            return rating;
        }

        public int getCopiesAvailable() {
            return copiesAvailable;
        }
    }

    public static class BorrowingRecord {
        private final String bookIsbn;
        private final String userId;
        private final LocalDate borrowDate;
        private final LocalDate dueDate;
        private volatile boolean returned;

        public BorrowingRecord(String bookIsbn, String userId, LocalDate borrowDate,
                               LocalDate dueDate) {
            this.bookIsbn = bookIsbn;
            this.userId = userId;
            this.borrowDate = borrowDate;
            this.dueDate = dueDate;
            this.returned = false;
        }

        public String getBookIsbn() {
            return bookIsbn;
        }

        public String getUserId() {
            return userId;
        }

        public LocalDate getBorrowDate() {
            return borrowDate;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public boolean isReturned() {
            return returned;
        }

        public void setReturned(boolean returned) {
            this.returned = returned;
        }
    }

    // Concurrent collections for thread-safety
    private final ConcurrentHashMap<String, Author> authors = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<BorrowingRecord> borrowingRecords = new CopyOnWriteArrayList<>();

    // Functional interfaces
    @FunctionalInterface
    interface BookFilter {
        boolean test(Book book);
    }

    @FunctionalInterface
    interface BookTransformer {
        Book apply(Book book, int copies);
    }

    // Constructor with mock data
    public LibraryManagementSystem() {
        initializeMockData();
    }

    private void initializeMockData() {
        // Create authors
        List<Author> authorList = Stream.of(
            new Author("A1", "John Smith", LocalDate.of(1970, 5, 15),
                Arrays.asList("Fiction", "Mystery")),
            new Author("A2", "Jane Doe", LocalDate.of(1980, 8, 22),
                Arrays.asList("Science Fiction", "Fantasy")),
            new Author("A3", "Bob Johnson", LocalDate.of(1965, 3, 10),
                Arrays.asList("Non-fiction", "History")),
            new Author("A4", "Alice Brown", LocalDate.of(1975, 11, 30),
                Arrays.asList("Romance", "Drama"))
        ).collect(Collectors.toList());

        authorList.forEach(author -> authors.put(author.getId(), author));

        // Create books
        List<Book> bookList = Arrays.asList(
            new Book("ISBN1", "The Mystery", authors.get("A1"), 2010, "Mystery", 4.5, 5),
            new Book("ISBN2", "Space Odyssey", authors.get("A2"), 2015, "Science Fiction", 4.8, 3),
            new Book("ISBN3", "World History", authors.get("A3"), 2008, "History", 4.2, 7),
            new Book("ISBN4", "Love Story", authors.get("A4"), 2012, "Romance", 4.0, 4),
            new Book("ISBN5", "Dark Secrets", authors.get("A1"), 2018, "Mystery", 4.7, 2),
            new Book("ISBN6", "Galactic Wars", authors.get("A2"), 2020, "Science Fiction", 4.9, 6)
        );

        bookList.forEach(book -> books.put(book.getIsbn(), book));

        // Create borrowing records
        borrowingRecords.addAll(Arrays.asList(
            new BorrowingRecord("ISBN1", "U1", LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(4)),
            new BorrowingRecord("ISBN2", "U2", LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(9)),
            new BorrowingRecord("ISBN3", "U3", LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(1))
        ));
    }

    // Stream operations with lambdas
    public List<Book> findBooksByGenre(String genre) {
        return books.values().stream()
            .filter(book -> book.getGenre().equalsIgnoreCase(genre))
            .sorted(Comparator.comparing(Book::getRating).reversed())
            .collect(Collectors.toList());
    }

    // Using Optional
    public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    // Method references and functional interfaces
    public List<String> getBookTitlesByAuthor(String authorId) {
        return books.values().stream()
            .filter(book -> book.getAuthor().getId().equals(authorId))
            .map(Book::getTitle)
            .collect(Collectors.toList());
    }

    // Complex stream operation with multiple transformations
    public Map<String, Double> getAverageRatingByGenre() {
        return books.values().stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.averagingDouble(Book::getRating)
            ));
    }

    // Concurrent processing
    public void updateBookCopies(String isbn, int newCopies) {
        findBookByIsbn(isbn).ifPresent(book -> {
            BookTransformer transformer = (b, copies) ->
                new Book(b.getIsbn(), b.getTitle(), b.getAuthor(),
                    b.getPublicationYear(), b.getGenre(),
                    b.getRating(), copies);

            books.computeIfPresent(isbn, (key, oldBook) ->
                transformer.apply(oldBook, newCopies));
        });
    }

    // Predicate composition
    public List<Book> findBooksByCustomFilter(BookFilter filter) {
        return books.values().stream()
            .filter(filter::test)
            .collect(Collectors.toList());
    }

    // Combining multiple conditions
    public List<Book> findAvailableBooksByYearAndRating(int year, double minRating) {
        BookFilter complexFilter = book ->
            book.getPublicationYear() >= year &&
                book.getRating() >= minRating &&
                book.getCopiesAvailable() > 0;

        return findBooksByCustomFilter(complexFilter);
    }

    // Processing borrowing records with streams
    public List<BorrowingRecord> getOverdueRecords() {
        return borrowingRecords.stream()
            .filter(record -> !record.isReturned())
            .filter(record -> record.getDueDate().isBefore(LocalDate.now()))
            .sorted(Comparator.comparing(BorrowingRecord::getDueDate))
            .collect(Collectors.toList());
    }

    // Concurrent modification of borrowing records
    public void returnBook(String isbn, String userId) {
        borrowingRecords.stream()
            .filter(record -> record.getBookIsbn().equals(isbn))
            .filter(record -> record.getUserId().equals(userId))
            .filter(record -> !record.isReturned())
            .findFirst()
            .ifPresent(record -> record.setReturned(true));
    }

    // Complex aggregation
    public Map<Author, Long> getBookCountByAuthor() {
        return books.values().stream()
            .collect(Collectors.groupingBy(
                Book::getAuthor,
                Collectors.counting()
            ));
    }

    // Using BiFunction for complex transformations
    public List<Book> transformBooks(BiFunction<Book, Author, Book> transformer) {
        return books.values().stream()
            .map(book -> transformer.apply(book, book.getAuthor()))
            .collect(Collectors.toList());
    }

    // Example usage
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Example 1: Find books by genre
        System.out.println("Mystery Books:");
        library.findBooksByGenre("Mystery")
            .forEach(book -> System.out.println(book.getTitle() + " - " + book.getRating()));

        // Example 2: Get average rating by genre
        System.out.println("\nAverage Rating by Genre:");
        library.getAverageRatingByGenre()
            .forEach((genre, avg) -> System.out.println(genre + ": " + avg));

        // Example 3: Find overdue records
        System.out.println("\nOverdue Records:");
        library.getOverdueRecords()
            .forEach(record -> System.out.println(
                "Book: " + record.getBookIsbn() + ", Due: " + record.getDueDate()));

        // Example 4: Custom filter
        BookFilter highRatedRecent = book ->
            book.getRating() > 4.5 && book.getPublicationYear() > 2015;
        System.out.println("\nHigh Rated Recent Books:");
        library.findBooksByCustomFilter(highRatedRecent)
            .forEach(book -> System.out.println(book.getTitle()));
    }
}