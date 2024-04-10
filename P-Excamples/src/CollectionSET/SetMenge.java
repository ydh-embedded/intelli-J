package CollectionSET;

import java.util.*;

public class SetMenge {

    public static void main(String[] args) {
        mUniqueWords("Ich bin ein List of");
        mPlayLotto(11);
    }

    public static void mUniqueWords(String element) {
        Set<String> sUniqueWords = new HashSet<>(Arrays.asList(element.split(" ")));
        System.out.println("Unique Words: " + sUniqueWords);
        sUniqueWords.remove("ein");
        System.out.println("Unique Words after removing 'ein': " + sUniqueWords);
    }

    public static void mPlayLotto(int n) {
        var vGenerator = new Random();
        Set<Integer> iRandomNumbers = new HashSet<>();
        while (iRandomNumbers.size() < n) {
            int number = vGenerator.nextInt(50) + 1;
            iRandomNumbers.add(number);
        }
        System.out.println("Lotto Numbers: " + iRandomNumbers);
    }
}