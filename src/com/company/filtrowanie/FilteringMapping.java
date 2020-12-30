package com.company.filtrowanie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class FilteringMapping {

    /**
     * 1.Stwórz strumień i wypisz jego elementy, ale bez duplikatów.  Solution -> {@link #topic_1()}}.
     * 2.Pobierz 2 dania w kolejnosci od najbardziej kalorucznego.  Solution -> {@link #topic_2()}}.TODO
     * 3.Wyciągnij nazwy dań i rozłóż je splitem i wyświetl unikalne litery.  Solution -> {@link #topic_3()}}.
     * 4.Wyciągnij nazwy dań i rozłóż je splitem i wyświetl unikalne litery.  Solution -> {@link #topic_4()}}.
     * 5.Sprawdź czy jest jakieś danie + 1k kalo.  Solution -> {@link #topic_5()}}.
     * 6.Znajdź jakiekolwiek danie wegetariańskie.  Solution -> {@link #topic_6()}}.
     * 7.Znajdź jakiekolwiek danie wegetariańskie i jeśli znajdziesz to je wyświetl.  Solution -> {@link #topic_7()}}.
     * 8.Znajdź pierwsze danie wegetariańskie.  Solution -> {@link #topic_8()}}.
     * 9.Zrób sumę za pomocą redukcji z wartością początkową i bez niej.  Solution -> {@link #topic_9()}}.
     *
     * @param args
     */

    static void main(String[] args) {

    }

    public static void topic_1() {

        final List<Integer> collect = Stream.of(1, 2, 3, 1, 1, 3, 2, 5).distinct().collect(toList());

    }

    public static void topic_2() {

    }

    public static void topic_3() {

        Dish.menu.stream()
                .map(Dish::getName)
                .map(a -> a.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
    }


}
