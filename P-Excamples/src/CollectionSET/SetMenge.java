package CollectionSET;

import java.util.*;

public class SetMenge {

    public static void main(String[] args) {


        Set<String> sUniqueWords = new HashSet<>(List.of("a" + "b" + "Change" + "sie" + "du"));
        System.out.println(sUniqueWords);
        sUniqueWords.remove("du");
    }

    public static List<Integer> playLotto(int n) {
        var vGenerator = new Random();
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < n) {
            int number = vGenerator.nextInt(1, 50);
            randomNumbers.add(number);
        }
    }
}
