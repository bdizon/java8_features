package com.company;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class FirstPredicate {

    public static void main(String[] args) {
	// write your code here
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        // filter Stream using a predicate
        Predicate<String> p1 = s -> s.length() > 3;

        // chain predicate with boolean operation
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        //print out each element
//        stream.filter(p1).forEach(s -> System.out.println(s));
//        stream.filter(p2).forEach(s -> System.out.println(s));
        stream.filter(p2.or(p3)).forEach(s -> System.out.println(s));
    }
}
