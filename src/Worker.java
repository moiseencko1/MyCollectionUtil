/**
 * Created by Acer on 19.10.2016.
 */
public class Worker extends Person {
    private final int salary;

    public Worker(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
