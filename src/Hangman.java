import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    static void main(String[] args){
        hangman();
    }

    static void hangman(){
        String word = "pizza";

        Scanner s = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        setWordState(wordState, word.length());
        int wrongGuesses = 0;

        welcomeMessage();

        while(wrongGuesses < 6) {

            IO.println(getHangmanArt(wrongGuesses));

            printWordState(wordState);
            char letter = guessLetter(s);
            if (word.indexOf(letter) >= 0) {
                IO.println("correct!\n");
                for (int i = 0; i < word.length(); i++) {
                    if (letter == word.charAt(i)) {
                        wordState.set(i, letter);
                    }
                }
                if(!wordState.contains('_')){
                    IO.println(getHangmanArt(wrongGuesses));
                    IO.println("YOU WIN");
                    IO.println("The word was: " + word);
                    break;
                }
            }
            else {
                IO.println("Wrong guess!\n");
                wrongGuesses++;
            }
        }

        if(wrongGuesses >= 6){
            IO.println(getHangmanArt(wrongGuesses));
            IO.println("GAME OVER!");
            IO.println("The word was: " + word);
        }



        s.close();
    }

    static void setWordState(ArrayList<Character> wordState, int wordLength){
        for(int i = 0; i < wordLength; i++){
            wordState.add('_');
        }
    }

    static void welcomeMessage(){
        IO.println("************************");
        IO.println("Welcome to Java Hangman!");
        IO.println("************************");


    }

    static String getHangmanArt(int wrongGuesses){
        return switch(wrongGuesses){
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                       o
                      
                      
                      """;
            case 2 -> """
                       o
                       |
                      
                      """;
            case 3 -> """
                       o
                      /|
                      
                      """;
            case 4 -> """
                       o
                      /|\\
                      
                      """;
            case 5 -> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> "";
        };
    }

    static void printWordState(ArrayList<Character> wordState){
        IO.print("Word: ");
        for(char c: wordState){
            IO.print(c + " ");
        }
        IO.println();
    }


    public static char guessLetter(Scanner s){
        String input = "";
        char c = '&';
        while(input.length() != 1 && !Character.isLetter(c)){
            IO.println("Guess a letter: ");
            input = s.next();
            if(input.length() == 1){
                c = input.toLowerCase().charAt(0);
                if(!Character.isLetter(c)){
                    IO.println("please enter a letter of the alphabet.");
                }
            }else{
                IO.println("please enter one letter.");
            }

        }
        return c;

    }
}
