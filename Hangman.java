import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

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
        char[] placeholder = new char[numOfCharacters];
        for(int i = 0; i < numOfCharacters; i++){
            placeholder[i] = '_';
        }
        System.out.print("Word: ");
        printPlaceholder(placeholder);
        System.out.println("\n");
        System.out.print("Miss: ");
        System.out.println("\n");
        System.out.print("Guess: ");
        char guess = scan.next().charAt(0);
        Integer[] indexArray = findMatch(word, guess);
        System.out.println(Arrays.toString(indexArray));

        for(int i = 0; i < indexArray.length; i++){
            for(int j = 0; j < numOfCharacters; j++){
                if(j == indexArray[i]){
                    System.out.print(word.charAt(indexArray[i]));
                }
            }
        }

        System.out.println("\n");

        updatePlaceholder(indexArray, placeholder, guess);
        printPlaceholder(placeholder);



        

        
       
        







    }

    public static String pickRandomWord(String[] words){
        int numOfWords = words.length;
        double randomNum = Math.random() * numOfWords;
        int randomInt = (int) randomNum;
        return words[randomInt];
    }

    public static void printPlaceholder(char[] placeholder){
        for (int i = 0; i < placeholder.length; i++){
            System.out.print(placeholder[i] + " ");
        }
    }

    public static Integer[] findMatch(String word, char guess){
        int index = word.indexOf(guess);
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        while(index >= 0){
           indexes.add(index);
           index = word.indexOf(guess, index + 1);
        }
        Integer[] indexArray = indexes.toArray(new Integer[indexes.size()]);
        return indexArray;
    }

    public static void updatePlaceholder(Integer[] indexArray, char[] placeholder, char guess){
        for(int i = 0; i < indexArray.length; i++){
            placeholder[indexArray[i]] = guess;
        }
    }



}





