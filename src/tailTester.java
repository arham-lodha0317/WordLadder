
public class tailTester {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add("Hello");
        list.add("World");

        System.out.println(list.getTail());
        System.out.println(list.getBack(list.getTailNode()));

        System.out.println(list.pop());
        System.out.println(list.pop());

        System.out.println("Queue tester");

        list.enqueue("Hello");
        list.enqueue("World");

        System.out.println(list.dequeue());
        System.out.println(list.dequeue());

        System.out.println("RmBack tester");

        list.enqueue("Hello");
        list.enqueue("World");

        LinkedList copyOfList = list.copyOf();

        System.out.println(copyOfList.rmBack());
        System.out.println(copyOfList.rmBack());

    }
}
