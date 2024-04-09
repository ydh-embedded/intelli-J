package CollectionSET;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {
    public static void main(String[] args) {
        mAddAndRemovelemts();
    }

    public static void mAddAndRemovelemts(){
        Set<String> words =new HashSet<>();
        words.add("i life ");
        words.addAll(Set.of("in" , "a" , "small", "city"));
        System.out.println(words);
    }










}
