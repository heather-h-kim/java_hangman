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

       

        String word = pickRandomWord(words);
        int numOfCharacters = word.length();
        
        char[] placeholder = new char[numOfCharacters];
        for(int i = 0; i < numOfCharacters; i++){
            placeholder[i] = '_';
        }
        
        char [] misses = new char[6];

        int missedTries = 0;

        while( missedTries < 6){

        System.out.println(gallows[missedTries]);    
        System.out.print("Word: ");
        printPlaceholder(placeholder);
        System.out.println("\n");
        System.out.print("Miss: ");
        printMiss(misses);
        System.out.println("\n");
        System.out.print("Guess: ");
        char guess = scan.next().charAt(0);

        boolean isContain = checkMatch(word, guess);


        if(isContain){
            Integer[] indexArray = findMatch(word, guess);
            System.out.println(Arrays.toString(indexArray));
            updatePlaceholder(indexArray, placeholder, guess);

        }else{
            misses[missedTries] = guess;
            missedTries++;

            
        }
    }

    if(missedTries == 6){
        System.out.println(gallows[missedTries]);  
        System.out.println("RIP");
        System.out.println("The word was: " + word );
    }
        


    }

    public static char pickGuess(char guess){
        char createdGuess = guess;
        return createdGuess;
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

    public static boolean checkMatch(String word, char guess){
        String guessString = String.valueOf(guess);
        boolean isContain = word.contains(guessString);
        return isContain;
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

    public static void printMiss(char[] misses ){
        for(int i = 0; i < misses.length; i++){
            System.out.print(misses[i]);
        }
       

       
    }

    

    



}





