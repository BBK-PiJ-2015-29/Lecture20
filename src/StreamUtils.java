package src;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by ocouls01 on 07/12/2015.
 */
public class StreamUtils {
    //Ex 10
    public static List<Double> randomNumberList(long size) {
        return Stream.iterate((Double)Math.random(),n -> (Double)Math.random()).limit(size).collect(Collectors.toList());
    }

    public static List<Integer> orderedNumberList(int start, int increment, long size) {
        return Stream.iterate(start, n -> n + increment).limit(size).collect(Collectors.toList());
    }
}
