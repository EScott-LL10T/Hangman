import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){
        hangman();
    }

    public static void hangman(){
        String word = "pizza";

        Scanner s = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        setWordState(wordState, word.length());
        int wrongGuesses = 0;
        welcomeMessage();

        s.close();
    }

    public static void setWordState(ArrayList<Character> wordState, int wordLength){
        for(int i = 0; i < wordLength; i++){
            wordState.add('_');
        }
    }

    public static void welcomeMessage(){
        IO.println("************************");
        IO.println("Welcome to Java Hangman!");
        IO.println("************************");
    }
}
