package src;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by ocouls01 on 07/12/2015.
 */
//Changed to be generic
public class StringUtils {
    public static <S> S betterElement(S t1, S t2, TwoElementPredicate<S> tester) {
        if (tester.isBetter(t1, t2)) {
            return t1;
        } else return t2;
    }

    public static <T> List<T> allMatches(List<T> inputList, Predicate<T> function) {
        List<T> output = new ArrayList<T>();
        for (T t : inputList) {
            if (function.test(t)) {
                output.add(t);
            }
        }
        return output;
    }

    public static <T> List<T> transformedList(List<T> inputList, Function<T, T> transform) {
        return inputList.stream().map((t) -> transform.apply(t)).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(StringUtils.betterElement("Ollie", "Sarah", (a, b) -> a.charAt(0) > b.charAt(0)));
        List<String> myList = new ArrayList<String>();

        myList.add("John");
        myList.add("Paul");
        myList.add("Ringo");
        myList.add("George");
        myList.add("Keith");
        myList.add("Pete");
        myList.add("Roger");
        myList.add("Jim");
        myList.add("Mick");
        myList.add("Kurt");
        myList.add("Dave");

        System.out.println("Matched List - Names longer than 5");
        System.out.println(StringUtils.allMatches(myList, s -> s.length() > 5));


        System.out.println("Matched List - Names containing i");
        System.out.println(StringUtils.allMatches(myList, s -> s.contains("i")));

        System.out.println("Matched List - Names shorter than 4");
        System.out.println(StringUtils.allMatches(myList, s -> s.length() < 4));

        System.out.println("Matched list - names with only 1 vowel");
        System.out.println(StringUtils.allMatches(myList, s -> {
            return (s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o")
                    && !s.contains("u")) || (!s.contains("a") && s.contains("e") && !s.contains("i") && !s.contains("o")
                    && !s.contains("u")) || (!s.contains("a") && !s.contains("e") && s.contains("i") && !s.contains("o")
                    && !s.contains("u")) || (!s.contains("a") && !s.contains("e") && !s.contains("i") && s.contains("o")
                    && !s.contains("u")) || (!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o")
                    && s.contains("u"));

        }));

        List<Integer> intList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            intList.add((int) (Math.random() * 10));
        }

        System.out.println("Transformed list - ");
        System.out.println(StringUtils.transformedList(intList, a -> a * a));
    }

}