import javax.swing.*;
import java.io.File;
import java.util.*;

public class WordLadder {

    private static HashSet<String> dictionary;
    public static void main(String[] args) throws Exception{

        Scanner dict = new Scanner(new File("dictionary.txt"));
        Scanner input = new Scanner(new File("input.txt"));

        dictionary = new HashSet<>();
        while (dict.hasNext()){
            dictionary.add(dict.nextLine());
        }


        while(input.hasNext()){
            String[] words = input.nextLine().split(" ");
            HashSet<String> used = new HashSet<>();
            LinkedList wordLadders = new LinkedList();

            String start = words[0];
            String end = words[1];
            if(!dictionary.contains(start) || !dictionary.contains(end)){
                System.out.println("There is no Word Ladder between " + start + " and " + end);
            }

            wordLadders.add(new LinkedList());
            ((LinkedList) wordLadders.getHead()).add(start);
            used.add(start);

            for (String s: dictionary) {

                if(s.length() == start.length() && !used.contains(s)){
                    int diff = 0;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != ((String) ((LinkedList) wordLadders.getHead()).getHead()).charAt(i)) {
                            diff++;
                        }

                    }

                    if(diff == 1){
                        used.add(s);
                        LinkedList stack = new LinkedList();
                        for (int i = 0; i < ((LinkedList) wordLadders.getHead()).size(); i++) {
                            stack.add(((LinkedList) wordLadders.getHead()).rmFront());
                        }
                        wordLadders.rmQueue();
                        stack.add(s);
                        wordLadders.add(stack);
                        if(s.equals(end)){
                            for (int i = stack.size()-1; i <= 0; i++) {
                                System.out.println((String)stack.get(i));
                            }
                            break;
                        }
                    }
                }
            }

            if(wordLadders.isEmpty()){
                System.out.println("There is no Word Ladder between " + start + " and " + end);
            }

        }
    }

}
