/**
 * Created by Acer on 19.10.2016.
 */
public class Person implements Comparable<Person> {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    @Override
    public boolean equals(Object person) {
        return this.name.equals(((Person) person).getName());
    }


    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
