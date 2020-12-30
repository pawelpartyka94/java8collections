package com.company.redukowanie_podmusowanie;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

public class Reducing {

    /**
     * 1.Policz wszystkie dania na liście.  Solution -> {@link #topic_1()}}.
     * 2.Wyszukaj danie o minimalnej i maksymalnej wartości kalorii. Solution -> {@link #topic_2()}}.
     * 3.Policz sume wszystkich kalorii we wszystkich daniach. Solution -> {@link #topic_3()}}.
     * 4.Policz srednią wartość kalorii. Solution -> {@link #topic_4()}}.
     * 5.Policz max i min. liczbe kalorii za pomocą modulu podsumowania Solution -> {@link #topic_5()}}.
     * 6.Polacz nazwy wszystkich dan i oddziel je ,. Solution -> {@link #topic_6()}}.
     * 7.Policz wszystkie kalorie za pomoca redukcji. Solution -> {@link #topic_7()}}.
     * 8.Pogrupuj dania na podstawie typu. Solution -> {@link #topic_8()}}.
     * 9.Pogrupuj dania na podstawie typu ENUM LOW MID i FAT gdzie kalo to 400, 600, 900. Solution -> {@link #topic_9()}}.
     * 10. Pogrupuj dania względem typu ale filtrując tylko te, które mają kalo miniżej 500. Solution -> {@link #topic_10()}}.
     * 11. Pogrupuj dania względem typu i zrób mapping na nazwę dania. Solution -> {@link #topic_11()}}.
     * 12. Pogrupuj dania względem typu i zmapuj znaczniki każdego dnia z mapy. Solution -> {@link #topic_12()}}.
     * 13. Pogrupuj dania względem typu wielopoziomowo Map<Dish.Type, Map<CaloricalDiet, List<Dish>>> Solution -> {@link #topic_13()}}.
     * 14. Pogrupuj dania względem typu i oblicz ile ich jest w danym typie. Solution -> {@link #topic_14()}}.
     * 15. Pogrupuj dania względem typu i zwróć po 1 które ma najwięcej kalo. Solution -> {@link #topic_15()}}.
     * 16. Wykonaj krok jak poniżej tylko pozbyj się Optionala poprzez collectionAndThen Solution -> {@link #topic_16()}}.
     * 17. Zpartycjonuj dania po tym czy sa wegetarianskie -> {@link #topic_17()}}.
     * 18. Zpartycjonuj dania po tym czy sa wegetarianskie i pogrupuj po ich typie -> {@link #topic_18()}}.
     *
     * @param args
     */

    static void main(String[] args) {

    }

    public static void topic_1() {

        long howManyDishes = Dish.menu.stream().collect(Collectors.counting());
        //or
        long howManyDishes2 = Dish.menu.stream().count();

    }

    public static void topic_2() {

        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);

        Dish.menu.stream().collect(maxBy(dishCaloriesComparator));
        //or
        Dish.menu.stream().max(dishCaloriesComparator);
    }

    public static void topic_3() {

        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        //or
        int totalCalories2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    }

    public static void topic_4() {

        final Double collect = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    public static void topic_5() {

        final IntSummaryStatistics collect = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        collect.getMax();
    }

    public static void topic_6() {

        final String collect = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
    }

    public static void topic_7() {

        final Integer collect = Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        //or
        final Integer reduce = Dish.menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        //or
        final Integer reduce2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

    }

    public static void topic_8() {

        final Map<Dish.Type, List<Dish>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType));

    }

    enum CaloricalDiet {FAT, MID, LOW}

    public static void topic_9() {

        Dish.menu.stream().collect(groupingBy(a -> {
            if (a.getCalories() <= 400) return CaloricalDiet.LOW;
            else if (a.getCalories() > 400 && a.getCalories() < 600) return CaloricalDiet.MID;
            else return CaloricalDiet.FAT;
        }));
    }

    public static void topic_10() {

        final Map<Dish.Type, List<Dish>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType, filtering(b -> b.getCalories() > 500, toList())));
    }

    public static void topic_11() {

        final Map<Dish.Type, List<String>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    public static void topic_12() {

        final Map<Dish.Type, Set<String>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType, flatMapping(a -> Dish.dishTags.get(a.getName()).stream(), toSet())));

    }

    public static void topic_13() {

        final Map<Dish.Type, Map<CaloricalDiet, List<Dish>>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(a -> {
                    if (a.getCalories() <= 400) return CaloricalDiet.LOW;
                    else if (a.getCalories() > 400 && a.getCalories() < 700) return CaloricalDiet.MID;
                    else return CaloricalDiet.FAT;
                })));

    }

    public static void topic_14() {

        final Map<Dish.Type, Long> collect = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));

    }

    public static void topic_15() {

        final Map<Dish.Type, Optional<Dish>> collect = Dish.menu.stream().collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

    }

    public static void topic_16() {

        final Map<Dish.Type, Dish> collect = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

    }

    public static void topic_17() {

        final Map<Boolean, List<Dish>> collect = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    public static void topic_18() {

        final Map<Boolean, Map<Dish.Type, List<Dish>>> collect = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

    }

}
