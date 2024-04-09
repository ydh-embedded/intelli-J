package hangman.hangman.src;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static String word = "";
    public static Scanner fileScanner;
    public static List<String> words = new ArrayList<>();
    public static StringBuilder guess = new StringBuilder();
    public static String[] hangman = new String[]{};
    public static String[] fullHangman = new String[]{
            " ___________\n",
            " |/        |\n",
            " |      (o _ o)\n",
            " |       / | \\\n",
            " |         |\n",
            " |        / \\\n",
            "/ \\"
    };

    public static void main(String[] args) throws IOException {
        displayWelcomeLogo();

        getData();
        chooseRandomWord();
        createGuess();
        drawHangman();
        printGuess();
        runGame();
    }

    public static void getData() throws IOException {
        File wordsList = new File("../res/words.txt");
        fileScanner = new Scanner(wordsList, StandardCharsets.UTF_8);
        while (fileScanner.hasNextLine()) {
            words.add(fileScanner.nextLine());
        }
    }

    public static void chooseRandomWord() {
        int index = (int) (Math.random() * words.size());
        word = words.get(index);
    }

    public static void createGuess() {
        guess.append("?".repeat(word.length()));
    }

    public static void printGuess() {
        String out = String.join(" ", guess.toString().split(""));
        System.out.printf("Guess: %s\n\n", out);
    }

    public static void drawHangman() {
        System.out.printf("%s\n\n", String.join("", hangman));
    }

    public static void modifyHangman(int miss) {
        switch (miss) {
            case 1 -> hangman = new String[]{
                    " \n",
                    " |\n",
                    " |\n",
                    "/ \\"};
            case 2 -> hangman = new String[]{
                    " \n",
                    " |/\n",
                    " |\n",
                    " |\n",
                    " |\n",
                    " |\n",
                    "/ \\"
            };
            default -> hangman[miss - 3] = fullHangman[miss - 3];
        }
    }

    public static boolean checkAnswer(String ans) {
        return word.toLowerCase().contains(ans);
    }

    public static String getAnswer() {
        Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.print("Guess a letter: ");
        return input.nextLine().toLowerCase();
    }

    public static void showLetters(String ans) {
        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == ans.charAt(0)) {
                guess.replace(i, i + 1, String.valueOf(word.charAt(i)));
            }
        }
    }

    public static void runGame() {
        int miss = 0;
        while (true) {
            String ans;
            do {
                ans = getAnswer();
            } while (ans.length() != 1);
            boolean isCorrect = checkAnswer(ans);
            if (isCorrect) {
                showLetters(ans);
            } else {
                miss++;
                modifyHangman(miss);
            }
            drawHangman();
            printGuess();
            if (miss == 8) {
                System.out.printf("You didn't guess the word: %s\n", word);
                System.out.println("Loser!\n");
                return;
            }
            if (guess.toString().equals(word)) {
                System.out.println("You won!");
                System.out.println("You may now fart on the Princess' balls ;)\n");
                return;
            }
        }

    }

    public static void displayWelcomeLogo() throws IOException {
        int lineWidth = 100;
        int paddingSize = (130 - lineWidth) / 2;
        String border = "*".repeat(lineWidth);
        System.out.println(" ".repeat(paddingSize) + border);
        File hangman = new File("../res/hangman.txt");
        fileScanner = new Scanner(hangman, StandardCharsets.UTF_8);

        while (fileScanner.hasNextLine()) {
            printLine(paddingSize, lineWidth, fileScanner.nextLine());
        }

        System.out.println(" ".repeat(paddingSize) + border);
    }

    public static void printLine(int paddingSize, int lineWidth, String text) {
        int textWidth;
        textWidth = text.length();
        int leftPad = 2;
        int rightPad = (textWidth & 1) == 1 ? 1 : 2;
        System.out.println(" ".repeat(paddingSize) +
                "*" +
                " ".repeat((lineWidth - textWidth - leftPad) / 2) +
                text +
                " ".repeat((lineWidth - textWidth - rightPad) / 2) +
                "*");
    }
}
