import org.w3c.dom.Node;

import java.util.LinkedList;

public class LinkedListStarter {

    public static void main(String args[]) {

        LinkedList myLinkedList = new LinkedList();

        myLinkedList.addAtBeginning("Youtube");
        myLinkedList.addAtBeginning("Google");
        myLinkedList.addAtBeginning("Github");


        System.out.println(myLinkedList.toString());

        myLinkedList.insertAt(1, "Facebook");

        myLinkedList.addCom();

        System.out.println(myLinkedList.toString());


    }

     static class LinkedList {

        private Node head;
        private int size;


        public LinkedList(){
            this.head = null;
            this.size = 0;
        }

        // add a new node at the beginning of the list
        public void addAtBeginning(String value){
            Node newNode = new Node(value);

            newNode.setNextNode(this.head);
            this.head=newNode;

            this.size++;
        }

        // remove first node of the list
        public void removeFirstNode(){
            if (this.head!=null) {
                this.head = this.head.getNextNode();
                this.size--;
            }
        }



        public void insertAt(int index, String val)
        {
            if(index == 0)
                addAtBeginning(val);
            int count = 0;
            Node temp = head;
            Node prev = head;
            if (count != index)
                do
                {
                    prev = temp;
                    temp = temp.next;
                    count++;
                }
                while (count != index);
            Node newNode = new Node(val ,null);
            prev.next = newNode;
            newNode.next = temp;
        }

        public void addCom()
        {
            Node temp = head;
            if (temp != null)
                do
                {
                    temp.item = temp.item + ".com";
                    temp = temp.next;
                }
                while (temp != null);
        }

        public int getSize() {
            return this.size;
        }


        @Override
        public String toString(){
            String str = "";
            Node curr = this.head;
            while(curr != null){
                str += " -> " + curr.getData();
                curr = curr.getNextNode();
            }
            return str;
        }

    }
    public static class Node {
        private String item;
        private Node next;

        public Node(String data, Node nextNode) {
            this.item = data;
            this.next = nextNode;
        }

        public Node(String data) {
            this(data, null);
        }

        public String getData() {
            return item;
        }

        public Node getNextNode() {
            return next;
        }

        public void setData(String data) {
            this.item = data;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        @Override
        public String toString() {
            return ""+this.item;
        }

    }

}
