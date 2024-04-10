package CollectionSET;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        mAddAndRemovelements();
        mTreeSet();
        mKeepElementsSorted();
    }

    public static void mAddAndRemovelements(){
        Set<String> words =new HashSet<>();
        words.add("i life ");
        words.addAll(Set.of("in" , "a" , "small", "city"));
        System.out.println(words);
    }

    /**
     * @
     */
    public static void mTreeSet(){
        Set<String> sMyFriends = new TreeSet<>(Set.of("alice" , "Bob" , "charlie"));
        Set<String> sHisFriends = new TreeSet<>(Set.of("damian" , "Bob" , "charlie"));
        Set<String> sCommonFriends = new TreeSet<>(sMyFriends);
        sCommonFriends.retainAll(sHisFriends);
        System.out.println(sCommonFriends);


    }


    public static void mKeepElementsSorted(){
        Set<cEmployee> employees = new TreeSet<>();

        employees.add  (new cEmployee("Max"  , "M01", false));
        employees.add  (new cEmployee("Alice", "A01", false));
        employees.add  (new cEmployee("Bea"  , "M41", false));

        System.out.println("Mitarbeiter: " + employees);

        Set<ExamResult> results = new TreeSet<>((first, second) -> (int) (first.score() - second.score() ));

        results.add(new ExamResult("1Z0-811", 50.5));
        results.add(new ExamResult("1Z0-811", 5.5));
        results.add(new ExamResult("1Z0-811", 21.5));
        results.add(new ExamResult("1Z0-811", 74.3));
        System.out.println(results);

        /*
         *  die TreeSet Methode wird dieselbe punktzahl nicht hinzufügen
         *  TreeSet verwendet nur die "ComparTo" Methode
         */
        var result01 = new ExamResult("MD-102", 55.5);
        var result02 = new ExamResult("MD-102", 55.5);
        var result03 = new ExamResult("BD-102", 55.5);
        var result04 = new ExamResult("CD-102", 55.5);

        System.out.println(result01.equals(result02)); //
        System.out.println(result02.equals(result03)); //
        System.out.println(result03.equals(result04)); //
    }


    record cEmployee (String name, String id , boolean isLeader) implements Comparable<cEmployee>{
        @Override
        public int compareTo(cEmployee o) {
            return this.id().compareTo(o.id());
        }
    }

    record ExamResult(String examCode, double score) {
        public double score() {
            return score;
        }
    }







}