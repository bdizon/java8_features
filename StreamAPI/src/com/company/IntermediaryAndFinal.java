package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
/*
    To show the difference between intermediary and final operations
 */
public class IntermediaryAndFinal {

    public static void main(String[] args) {
        // write your code here
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        // filter Stream using a predicate
        Predicate<String> p1 = s -> s.length() > 3;

        // chain predicate with boolean operation
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        // should print nothing and list.size() = 0 bc peek and filter are intermediary operations
//        stream.peek(System.out::println).filter(p2.or(p3)).peek(list::add);

        /* forEach is a final operation, it'll trigger the processing of data
        that the stream is connected to in one pass */
        stream.peek(System.out::println).filter(p2.or(p3)).forEach(list::add);

        System.out.println("Done!");
        System.out.println("Size of list: " + list.size());
    }

}
