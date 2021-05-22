package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10, -10);

        // build stream and then reduce
        // with lambda expression
//        list.stream()
//                .reduce(0, (i1,i2) -> i1 + i2);

        // build stream and then reduce
        // with method reference
        // returns an integer
//        Integer red =
//        list.stream()
//                .reduce(0, Integer::sum);

        Optional<Integer> red =
                list.stream()
                        .reduce(Integer::max);

        System.out.println("red = " + red);
    }
}
