public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object object){
        Node node = new Node(object);
        node.setNextPtr(head);
        node.setBackPtr(null);
        head = node;

        if(isEmpty()){
            tail = node;
        }else{
            node.getNextPtr().setBackPtr(node);
        }

        size++;
    }

    //Stack method implementation on LinkedList
    //Same as basic add method
    public void push(Object object){
        Node node = new Node(object);
        node.setNextPtr(head);
        node.setBackPtr(null);
        head = node;

        if(isEmpty()){
            tail = node;
        }else{
            node.getNextPtr().setBackPtr(node);
        }

        size++;
    }

    //Removing from the front
    public Object pop(){
        Node temp = head;
        head = head.getNextPtr();
        if(head != null){head.setBackPtr(null);}

        size--;
        return temp.get();
    }

    //Queue method implementation
    public void enqueue(Object object){

        Node node = new Node(object);
        Node oldTail = tail;

        tail = node;
        tail.setBackPtr(oldTail);

        if(!isEmpty()){
            oldTail.setNextPtr(tail);
        }
        else {
            head = tail;
        }

        size++;
    }

    //Same as pop
    public Object dequeue(){
        Node temp = head;
        head = head.getNextPtr();
        if(head != null){head.setBackPtr(null);}

        size--;
        return temp.get();
    }

    //Removing from back
    public Object rmBack(){
        Node temp = tail;
        tail = tail.getBackPtr();
        if(tail != null){tail.setNextPtr(null);}

        size--;
        return temp.get();
    }

    public LinkedList copyOf() {
        LinkedList list = new LinkedList();

        Node currentNode = tail;

        while (currentNode != null){
            list.add(currentNode.get());
            currentNode = currentNode.getBackPtr();
        }

        return list;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object getHead() {
        return head.get();
    }

    public Object getTail() {
        return tail.get();
    }


    public Node getHeadNode(){
        return head;
    }

    public Node getTailNode(){
        return tail;
    }

    public Object getNext(Node node){
        return node.getNextPtr().get();
    }

    public Object getBack(Node node){
        return node.getBackPtr().get();
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNextPtr();
        }

        return current.get();
    }

    public int size() {
        return size;
    }

    private static class Node {

        private Node next;
        private Object data;
        private Node back;

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

        public Node getBackPtr() {
            return back;
        }

        public void setBackPtr(Node back) {
            this.back = back;
        }
    }


}
