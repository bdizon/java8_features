package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Integer.*;
import java.io.IOException;
import java.util.Optional;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        CollectorsExample.class.getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines();
                ) {
                    stream.map(line -> {
                        String[] s = line.split(" ");
                        Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                        persons.add(p);
                        return p;
                    })
                            .forEach(System.out::println);


        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Stream<Person> stream = persons.stream();

        // get youngest person older than 20
        Optional<Person> opt =
            persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        System.out.println(opt);

        // get oldest person
        // STREAM CANNOT BE REUSED
        // does not store data so its light weight
        Optional<Person> opt2 =
                persons.stream().max(Comparator.comparing(Person::getAge));

        System.out.println(opt2);

        // collect streams on person
        // build hashmap of people grouped by age
        Map<Integer, List<Person>> map =
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge
                        )
                );

        System.out.println("map: " + map);

        // using downstream collector
        Map<Integer, Long> map2 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.counting()
                                )
                        );

        System.out.println("map2: " + map2);

        // using downstream collector get names
        Map<Integer, List<String>> map3 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList()
                                        )
                                )
                        );

        System.out.println("map3: " + map3);

        // using downstream collector get names
        // alphabetical order
        Map<Integer, Set<String>> map4 =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toCollection(TreeSet::new)
                                        )
                                )
                        );

        System.out.println("map4: " + map3);
    }
}
