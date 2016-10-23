import java.util.*;

/**
 * Created by Acer on 17.10.2016.
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <E> int indexOf(List<? extends E> source, E e) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(e)) return i;
        }
        return -1;
    }

    public static <E> List limit(List<? extends E> source, int size) {
        return new ArrayList<E>(source.subList(0, size));

    }

    public static <E> void add(List<? super E> destination, E e) {
        destination.add(e);
    }

    public static <E extends Comparable> void removeAll(List<? super E> removeFrom, List<? extends E> c2) {
        Set<? super E> set = new TreeSet<>(c2);
        Iterator<? super E> iterator = removeFrom.iterator();
        while (iterator.hasNext()) {
            if (c2.contains(iterator.next()))
                iterator.remove();
        }
    }

    //true если первый лист содержит все элементы второго
    public static <E> boolean containsAll(List<? extends E> list, List<? extends E> subList) {
        Set<? super E> subListSet = new TreeSet(list);
        for (Object o : subList) {
            if (!subListSet.contains(o)) return false;
        }
        return true;
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <E> boolean containsAny(List<? extends E> c1, List<? extends E> c2) {
        Set<? extends E> c1Set = new TreeSet(c1);
        for (Object o : c2) {
            if (c1Set.contains(o)) return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <E extends Comparable<? super E>> List range(List<? extends E> list, E min, E max) {
        List<E> rangeList = new ArrayList<>();
        for (E e : list) {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0)
                rangeList.add(e);
        }
        return rangeList;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <E> List range(List<? extends E> list, E min, E max, Comparator comparator) {
        List<E> rangeList = new ArrayList<>();
        for (E e : list) {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0)
                rangeList.add(e);
        }
        return rangeList;
    }
}


