package com.company.filtrowanie;

import java.util.List;

import static java.util.Arrays.asList;

public class Podsumowanie {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    /**
     * 1.Znajdz wszystkie transakcje z roku 2011 i posortuj je rosnąco wg wartosci.  Solution -> {@link #topic_1()}}.
     * 2.Wymien miasta w których pracują poszczególni handlarze.  Solution -> {@link #topic_1()}}.
     * 3.Znajdz wszystkich handlarzy z cambridge i posortuj ich wg imienia.  Solution -> {@link #topic_1()}}.
     * 4.Zwroc łańcuch znakow zawierajacy wszystkie imiona handlarzy posoftowane alfabetycznie.  Solution -> {@link #topic_1()}}.
     * 5.Czy ktorykolwiek z handlarzy pracuje w milanie ?  Solution -> {@link #topic_1()}}.
     * 6.Wypisz wartosci wszystkich tansakcji wykonywanych przez hanlarzy pracujacych w cambrige Solution -> {@link #topic_1()}}.
     * 7.Jaka jest najwyzsza wartosc sposrod wszystkich transakcji Solution -> {@link #topic_1()}}.
     * 8.Znajdz transakcje o najnizszej wartosci Solution -> {@link #topic_1()}}.
     *
     * @param args
     */

    public static void main(String[] args) {

    }

}
