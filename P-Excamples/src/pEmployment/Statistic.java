package pEmployment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Statistic {
    private static TreeMap<Object, Object> countByChar;

    public static void main(String[] args) {

        mGenerateWordStatistics();
//        mSortKeyList();
    }

    public static void mGenerateWordStatistics(){
            String text = "Das ist das Haus vom Nikolaus. Freibier für alle. ";
            Map<Character , Integer> countByChar = new TreeMap<>();
            for (char c : text.toCharArray()){
                int count = countByChar.getOrDefault( c , 0);
                count++;
                countByChar.put(c,count);
            }

            for (char c : countByChar.keySet()){
                System.out.printf("%c : %02d\n" , c , countByChar.get(c));
            }

            List<Entry<Character, Integer>> lKeyList = new ArrayList<>(countByChar.entrySet());
                lKeyList.sort((e1,e2) -> e2.getValue() - e1.getValue());

            for (Entry e : lKeyList){
                System.out.println(e);
            }
    }

    public static void mGroupElements(){
        List<String> vNames = List.of("alice", "bob", "anton", "billy", "berta", "charlie");
        Map<Character, List<String>> vNamesByChar = new TreeMap<>();
            for (String name : vNames){
                char key = name.length() > 0 ? name.charAt(0) : ' ' ;
                List<String> value = vNamesByChar.getOrDefault(key, new ArrayList<>());
                    value.addLast(name);
                    vNamesByChar.put(key,value);
            }
                System.out.println("vNamesByChar");

            vNamesByChar.compute('a' , (key, value) -> { value.addLast("test");
            return value;
            });


    }

//    public static void mSortKeyList(){
//
//        List<Entry<Character, Integer>> lPairs = new ArrayList<>(countByChar.entrySet());
//        lPairs.sort((e1,e2) -> e2.getValue() - e1.getValue());
//        System.out.println(lPairs);
//
//    }





}
