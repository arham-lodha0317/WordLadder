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

        while(input.hasNext()) {
            String[] words = input.nextLine().split(" ");
            HashSet<String> used = new HashSet<>();
            LinkedList queue = new LinkedList();

            String start = words[0];
            String end = words[1];

            if (!dictionary.contains(end) && !dictionary.contains(start)) {
                System.out.println("There is no Word Ladder between " + start + " and " + end);
            }
            else {
                queue.enqueue(new LinkedList());
                ((LinkedList) queue.getHead()).push(start);
                used.add(start);
                boolean found = false;

                if (start.equals(end)) {
                    System.out.println(start + " " + end);
                } else {
                    while (!queue.isEmpty() && !found) {

                        LinkedList currentStack = (LinkedList) queue.dequeue();
                        String currentWord = (String) currentStack.getHead();

                        if (currentWord.equals(end)) {
                            while (!currentStack.isEmpty()) {
                                System.out.print(currentStack.rmBack() + " ");
                            }

                            System.out.println();

                            found = true;

                        }
                        else {
                            for (String s :
                                    dictionary) {

                                if (s.length() == currentWord.length() && !used.contains(s) && compareStrings(currentWord, s) == 1) {

                                    used.add(s);

                                    LinkedList stack = currentStack.copyOf();

                                    stack.push(s);

                                    queue.enqueue(stack);

                                }
                            }
                        }

                    }

                }

                if (queue.isEmpty()) {
                    System.out.println("There is no Word Ladder between " + start + " and " + end);
                }
            }
        }

    }

    public static int compareStrings(String s1 , String s2){
        int diff = 0;
        for (int i = 0; i < s2.length(); i++) {

            if(!s1.substring(i, i+1).equals(s2.substring(i, i+1))){
                diff++;
            }

        }

        return diff;
    }

}
