import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordLadder {

    private static ArrayList<String> dictionary;

    public static void main(String[] args) throws Exception{

        Scanner dict = new Scanner(new File("dictionary.txt"));
        Scanner input = new Scanner(new File("input.txt"));

        dictionary = new ArrayList<>();
        while (dict.hasNext()){
            dictionary.add(dict.nextLine());
        }
        Collections.sort(dictionary);


        while(input.hasNext()){
            String[] words = input.nextLine().split(" ");
            wordLadder(words);
        }
    }

    public static boolean wordLadder(String[] words){
        String start = words[0];
        String end = words[1];
        if(!dictionary.contains(start)){
            return false;
        }

        


    }

}
