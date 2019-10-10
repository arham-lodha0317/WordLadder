public class LinkedList {
    private Node head;
    private Node tail;
    private int count;

    public LinkedList(){
        head = null;
        count = 0;
    }

    public void add(Object object){
        Node node = new Node(object);
        node.setNextPtr(head);
        head = node;
        count++;
    }

    public Object rmFront(){
        Node front = head;
        head = front.getNextPtr();
        count--;
        return front.get();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Object getHead() {
        return head.get();
    }

    public Object get(int index){
        if(index < 0 || index >= count){
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNextPtr();
        }

        return current.get();
    }

    public int size() {
        return count;
    }

    public Object rmQueue(){
        Node current  = head;
        for (int i = 0; i < count - 2; i++) {
            current = current.getNextPtr();
        }
        Node temp = current.getNextPtr();
        current.setNextPtr(null);
        count--;
        return temp;
    }

    private class Node {

        private Node next;
        private Object data;

        public Node(){
            next = null;
            data = null;
        }

        public Node(Object object){
            next = null;
            data = object;
        }


        public Object get(){
            return data;
        }

        public void set(Object data){
            this.data = data;
        }

        public Node getNextPtr() {
            return next;
        }

        public void setNextPtr(Node next) {
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }

    }



}
