package java8.models;

public class Employee {
    public int eno;
    public String ename;

    public Employee(int eno, String ename) {
        this.eno = eno;
        this.ename = ename;
    }

    public String toString() {
        return eno + ":" + ename;
    }
}
