import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Number[] array = new Number[0];

        ArrayWrapper a = new ArrayWrapper(array);
        a.add(6);
        a.add(5);
        a.add(3);
        a.add(13);
        a.add(8);
        a.add(2);
        Number o = 21;
        MyComparator comparator = new MyComparator();
        a.sort(comparator);
        System.out.println(a.max(comparator));
        System.out.println(a.min(comparator));
        System.out.println(a.avg());
        a.print();
    }
}
