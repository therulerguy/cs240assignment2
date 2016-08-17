/**
 * Created by jwang on 7/13/16.
 */
public class NodeStack implements Stack {

    private Node top;
    private int size;

    public NodeStack() {
        this.top = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    public String top(){
        return top.getValue();
    }

    public void push (String value){
        if(isEmpty()){
            top = new Node(value, null);
        } else {
            Node temp = new Node(value, top);
            top = temp;
        }
        size++;
    }

    public String pop(){
        if(isEmpty()){
            return "";
        }

        Node temp = top;

        if(size == 1){
            top = null;
        } else {
            top = temp.getNext();
        }
        size--;
        return temp.getValue();
    }
}
