package de.excample;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListExcamples {
    public static void main(String @NotNull [] args) {

//        if (args.length < 1) {
//            System.out.print("Zu wenig Argumente");
//            return;
//        }

//        addAndRemoveElements();
//        mProcessElements();
//        mAddAndRemoveElements();
//        mProcessElementsIteration();
        m

    }

    public static void mAddAndRemoveElements() {
        List<String> names = new ArrayList<String>();            // erzeuge eine Instanz mit der Variable names
        // wir erzeugen hier eine List!!! aus der ArrayList!!!
        //  das funktioniert weil alle methoden die im List steht stehen auch im nachfahren arraylist
        names.addFirst("Bob");    // index 0
        names.add(1, "der Baumeister");
        names.add("Alice");         // index 2
        names.add(3, "im Wonderland");
        names.add(4, "Charlie");
        names.addLast("Brown");
        System.out.printf("Names: %s\n", names);


        names.remove(1);
        names.remove(2);
        names.remove("Brown");
        System.out.printf("Names: %s\n", names);

        names.removeIf(namen -> namen.length() > 0 && namen.charAt(0) == 'A');  //Lambda anonyme funktion namen ist der Parameter

        System.out.printf("Names: %s\n", names);

        List<String> range = names.subList(0, 0);   //Die SubList schreibt immer auf das Original!
        range.add("Beginner");
        System.out.printf("Names: %s\n", names);


    }

    public static void mProcessElements() {
        List<Integer> primes = new ArrayList<Integer>(List.of(3, 5, 7, 11));
        for (int i : primes) {
            System.out.printf("%02d", i);

        }
        System.out.println();

    }


    public static void mProcessElementsIteration() {

        List<Integer> primes = new ArrayList<Integer>(List.of(3, 5, 7, 11));
        for (int i : primes) {
            System.out.printf("%02d", i);   //souf
        }
        System.out.println();


        Iterator<Integer> iterator1 = primes.iterator();
        while (iterator1.hasNext()) {
            int i = iterator1.next();
            System.out.printf("%02d", i);
        }
        System.out.println();       //sout


        Iterator<Integer> iterator2 = primes.iterator();
        while (iterator2.hasNext()) {
            int p = iterator2.next();
            if (p > 5) {
                iterator2.remove();
            }
            System.out.printf("Ergebniss nach Filter: %s ", primes);
        }
    }

    public static void mProcessSubElementsIteration() {
        Iterator<Integer> iterator3 = primes.iterator();

        while (iterator3.hasNext()) {
            int p = iterator3.next();
            if (p > 5) {
                iterator3.remove();
            }
            System.out.printf("Ergebniss nach Filter: %s ", primes);
        }
    }

    public static void mSortElements(){

            List<String> names = new ArrayList<>(List.of("bob", "alice", "Charlie", "Elon"));
            //names.sort((first , second) -> first.compareToIgnoreCase(second)); alte Schreibweise
            names.sort(String::compareToIgnoreCase);
            System.out.println("sortierte Namensliste: " + names);

        }

    public static void mSortElementsLength() {

            List<String> names = new ArrayList<>(List.of("bob", "alice", "Charlie", "Elon"));
            //names.sort((first , second) -> first.length() - second.length()); alte Schreibweise
            names.sort(Comparator.comparingInt(String::length));
            System.out.println("sortierte Namensliste nach NamensLänge: " + names);
        }
    }