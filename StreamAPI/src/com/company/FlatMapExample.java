package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/* */
public class FlatMapExample {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        System.out.println(list);

        Function<List<?>, Integer> size = List::size;
        //transfer list into a stream
        Function<List<Integer>, Stream<Integer>> flatMapper =
                l -> l.stream();
        // build a stream on this list
        // prints the size for each list in the list of lists
//        list.stream()
//                .map(l -> l.size())
//                .forEach(System.out::println);

        // return a stream of streams
        list.stream()
                .map(flatMapper)
                .forEach(System.out::println);

        // flatten stream of streams into one stream
        // print out each integer held in each of the streams
        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);

    }
}
