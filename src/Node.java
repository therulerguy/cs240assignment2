/**
 * Created by jwang on 7/14/16.
 */
public class Node {

    private String value;
    private Node next;

    public Node (String value, Node next){
        this.value = value;
        this.next = next;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String s){
        value = s;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }
}
