package com.linkedlist.geeksforgeeks;

public class SingleLinkedList {

    public Node head;

    public SingleLinkedList(Node head){
        this.head = head;
    }

    public void addFront(Node node){
        node.next = head;
        head = node;
    }

    public void addLast(Node node){
        if(head == null)
            head = node;

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;

    }

    public void addAfter(Node prev, int data){
        Node newNode = new Node(data);

        if( prev == null){
            System.out.println("Previous node cant be null");
            return;
        }

        Node temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
    }

    public void print(){
        Node node = head;

        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void delete(int data) {
        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;
        while(curr.data != data && curr != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }

    public void deleteAtPosition(int k){
        if(head == null){
            return;
        }

        if(k==0){
            head = head.next;
            return;
        }
        int n = 1;
        Node curr = head.next;
        Node prev = head;

        while(n != k && curr != null){
            prev = curr;
            curr = curr.next;
            n++;
        }

        if(curr == null )
            return;

        prev.next = curr.next;

    }

    public int length(){

        int n=0;
        Node curr = head;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        return n;
    }

    public int lengthRecursive(Node head){

        if(head == null){
            return 0;
        }
        return 1 + lengthRecursive(head.next);
    }

    public void swapNodes(int d1, int d2) {

        if( d1 == d2)
            return;

        Node curr = head;
        Node prev = null;

        Node prev1 = null;
        Node curr1 = null;
        Node prev2 = null;
        Node curr2 = null;

        while( curr != null) {

            if(curr.data == d1) {
                prev1 = prev;
                curr1 = curr;
            }
            if(curr.data == d2){
                prev2 = prev;
                curr2 = curr;
            }
            prev = curr;
            curr= curr.next;
        }

        if(curr1 == null || curr2 == null)
            return;
        // If d1 is not head of linked list
        if(prev1 != null)
            prev1.next = curr2;
        else // make d2 the new head
            head = curr2;

        // If d2 is not head of linked list
        if(prev2 != null)
            prev2.next = curr1;
        else // make d1 the new head
            head= curr1;

        // Swap next pointers
        Node temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;
    }

    //Reversing linked lint using iterative way
    public void reverse(){
        Node cur = head;
        Node prev = null;
        Node temp= null;

        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
    }

    // TODO reverse linked list recursively
    public void reverseRecursive(Node node){
        if(node == null)
            return;

        Node node1 = node;
        Node rest = node1.next;

        //list has only one node
        if(rest == null) {
            head = node1;
            return;
        }

        reverseRecursive(rest);

        node1.next.next = node1;
        node1.next = null;

    }

    public static void main(String[] args) {
        Node node = new Node(2);
        SingleLinkedList list = new SingleLinkedList(node);
        list.print();

        Node first = new Node(1);
        list.addFront(first);
        list.print();
        System.out.println("length : " + list.length());

        Node last = new Node(3);
        list.addLast(last);
        list.print();

        list.print();

        list.addAfter(node, 4);
        list.print();
        System.out.println("length : " + list.length());

        SingleLinkedList list2 = new SingleLinkedList(new Node(6));
        Node node1 = new Node(5);
        list2.addFront(node1);
        list2.addLast(new Node(7));
        list2.addLast(new Node(8));
        list2.print();
        list2.reverseRecursive(node1);
        list2.print();



    }
}
