package src;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ocouls01 on 07/12/2015.
 */
public class Main {


    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.launch();

    }

    public void launch() {
        List<String> words = Arrays.asList("hi", "hello", "bye", "hola", "adios", "salut",
                "au revoir", "ciao", "arrivederci");

        //Ex2
        words.stream().forEach(s -> System.out.println(s));


        //Ex 3
       // List<String> excitingWords = StringUtils.transformedList(words,s -> s + "!");
        List<String> excitingWords = words.stream().map(s -> s + "!").collect(Collectors.toList());

        System.out.println(excitingWords);


        List<String> eyeWords = words.stream().map(s -> s.replace("i", "eye")).collect(Collectors.toList());

        System.out.println(eyeWords);

        List<String> upperCaseWords = words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(upperCaseWords);


        //Ex4
        List<String> shortWords = words.stream().filter(s -> {
            return s.length() < 4;
        }).collect(Collectors.toList());

        System.out.println(shortWords);

        List<String> wordsWithB = words.stream().filter(s -> s.contains("b")).collect(Collectors.toList());

        System.out.println(wordsWithB);

        List<String> evenLengthWords = words.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.toList());

        System.out.println(evenLengthWords);

        //ex 5
        Stream<String> myStream = words.stream().map(s -> s.toUpperCase());

        try {
            String ex5Word = words.stream().map(s -> s.toUpperCase()).filter(s -> s.length() < 4)
                    .filter(s -> s.contains("E")).findFirst().get().toString();
            System.out.println(ex5Word);
        } catch (NoSuchElementException ex) {
            System.out.println("No such Element");
        }

       //Ex 7

        String ex7Word = words.stream().reduce("", (s1,s2) -> s1 + s2.toUpperCase());

        System.out.println(ex7Word);

        //Ex 8

        String ex8Word = words.stream().map(String::toUpperCase).reduce("", (s1,s2) -> s1 + s2);

        System.out.println(ex8Word);

        //Ex 9
        String ex9Word = words.stream().collect(Collectors.joining(", "));

        System.out.println(ex9Word);


        //Ex 10
        List<Double> doubleList = StreamUtils.randomNumberList(10);
        doubleList.stream().forEach(d -> System.out.println(d));

        //Ex 11
        List<Integer> integerList = StreamUtils.orderedNumberList(0, 13, 12);
        System.out.println(integerList);

    }


}

