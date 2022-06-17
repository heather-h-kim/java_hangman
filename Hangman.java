import java.util.Scanner;

public class Hangman {
    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        System.out.println(gallows[0]);
        String word = pickRandomWord(words);
        int numOfCharacters = word.length();
        System.out.println(word);
        System.out.println(numOfCharacters);
        System.out.print("Word: ");
        for (int i = 0; i < numOfCharacters; i++){
            System.out.print("_ ");
        }
        System.out.println("\n");
        System.out.print("Miss: ");
        System.out.println("\n");
        System.out.print("Guess: ");
        char guess = scan.next().charAt(0);
        int matchingIndex = findMatch(word, guess);
        System.out.println(matchingIndex);

        
       
        







    }

    public static String pickRandomWord(String[] words){
        int numOfWords = words.length;
        double randomNum = Math.random() * numOfWords;
        int randomInt = (int) randomNum;
        return words[randomInt];
    }

    public static int findMatch(String word, char guess){
        int index = 0;
        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == guess){
                index = i;
            }
        }
        return index;
    }

}





