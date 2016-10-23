import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Acer on 18.10.2016.
 */
public class CollectionUtilsTest {
    @Test
    public void testAddAll() {
        List<Integer> source = Arrays.asList(2, 2, 3, 4, 5);
        List<Number> destination = new ArrayList<>(Arrays.asList(1, 2));
        CollectionUtils.<Number>addAll(source, destination);
        assertEquals(7, destination.size());
    }

    @Test
    public void testNewArrayLis() {
        List list = CollectionUtils.<Number>newArrayList();
        list.add(4);
        list.add(2.1);
        assertTrue(Integer.class == list.get(0).getClass() && Double.class == list.get(1).getClass());
    }

    @Test
    public void testIndexOf() {
        assertEquals(3, CollectionUtils.indexOf(Arrays.asList(2, 3, 5.1, 7), (Number) 7));
    }

    @Test
    public void testIndexOfByPerson() {
        assertEquals(2, CollectionUtils.<Person>indexOf(Arrays.asList(
                new Worker("B", 0), new Worker("A", 0), new Worker("C", 0)), new Person("C")));
    }

    @Test
    public void testIndexOfNotExisted() {
        assertEquals(-1, CollectionUtils.indexOf(Arrays.asList(1, 4), 2));
    }

    @Test
    public void testLimit() {
        List<Number> list = CollectionUtils.<Number>limit(Arrays.asList(1, 2, 3, 4), 2);
        list.add(1.2);
        assertEquals(Arrays.asList(1, 2, 1.2), list);
    }

    @Test
    public void testLimitByPerson() {
        List<Person> list = CollectionUtils.<Person>limit(
                Arrays.asList(new Worker("W", 2), new Worker("A", 2), new Worker("S", 2)), 2);
        assertEquals(Arrays.asList(new Person("W"), new Person("A")), list);
    }

    @Test
    public void testAddElementToList() {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("X"), new Person("Y")));
        Worker worker = new Worker("A", 2);
        CollectionUtils.add(persons, worker);
        assertEquals(worker, persons.get(2));
    }

    @Test
    public void testRemoveAll() {
        List<Person> listPersons = new ArrayList<>(Arrays.asList(new Person("A"), new Person("B"), new Person("D")));
        List<Worker> listWorkers = Arrays.asList(new Worker("A", 3), new Worker("F", 4));
        List<Person> listResponse = Arrays.asList(new Person("B"), new Person("D"));
        CollectionUtils.<Person>removeAll(listPersons, listWorkers);
        assertEquals(listResponse, listPersons);
    }

    @Test
    public void testContainsAllTrue() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> subList = Arrays.asList(1, 2, 3);
        assertTrue(CollectionUtils.<Integer>containsAll(list, subList));
    }

    @Test
    public void testContainsAllFalse() {
        List<Number> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> subList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertFalse(CollectionUtils.<Number>containsAll(list, subList));
    }

    @Test
    public void testContainAllByPersonTrue() {
        List<Person> list = Arrays.asList(new Person("A"), new Person("B"), new Person("C"));
        List<Worker> subList = Arrays.asList(new Worker("A", 1), new Worker("B", 2), new Worker("C", 3));
        assertTrue(CollectionUtils.<Person>containsAll(list, subList));
    }

    @Test
    public void testContainAllByPersonFalse() {
        List<Person> list = Arrays.asList(new Person("C"), new Person("B"), new Person("C"));
        List<Worker> subList = Arrays.asList(new Worker("A", 1), new Worker("B", 2), new Worker("C", 3));
        assertFalse(CollectionUtils.<Person>containsAll(list, subList));
    }

    @Test
    public void testContainsAny() {
        List<Person> list1 = Arrays.asList(new Person("A"), new Person("B"));
        List<Worker> list2 = Arrays.asList(new Worker("D", 0), new Worker("B", 0), new Worker("T", 0));
        assertTrue(CollectionUtils.containsAny(list1, list2));
    }

    @Test
    public void testRangeClassMustImplementsComparable() {
        List rangeList = CollectionUtils.<Person>range(
                Arrays.asList(new Worker("B", 2), new Worker("A", 2), new Worker("E", 2)),
                new Person("A"),
                new Person("D"));
        assertEquals(Arrays.asList(new Person("B"), new Person("A")), rangeList);
    }

    @Test
    public void testRangeWithComparator() {
        List rangeList = CollectionUtils.<Person>range(
                Arrays.asList(new Worker("F", 2), new Worker("A", 2), new Worker("E", 2), new Worker("B", 2)),
                new Person("A"),
                new Person("D"),
                (o1, o2) -> ((Person) o1).compareTo((Person) o2));
        assertEquals(Arrays.asList(new Person("A"), new Person("B")), rangeList);
    }

    @Test
    public void testRemoveAll2() {
        List<Person> persons = new ArrayList(Arrays.asList(new Person("W"), new Person("A"), new Person("D")));
        List<NiceWorker> niceWorkers = Arrays.asList(new NiceWorker("W", 3, false), new NiceWorker("A", 2, true));
        List<Worker> response = Arrays.asList(new NiceWorker("D", 3, true));
        CollectionUtils.<Worker>removeAll(persons, niceWorkers);
        assertEquals(response, persons);
    }
}
