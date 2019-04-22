package com.linkedlist.geeksforgeeks;

public class MergeSortedLists {


    // Without recursion
    public static Node mergeIterative(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node node = dummy;

        while (true){
            if(head1 == null) {
                node.next = head2;
                break;
            }
            if(head2 == null) {
                node.next = head1;
                break;
            }

            if(head1.data < head2.data){
                node.next = head1;
                head1 = head1.next;
            }else{
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        return dummy.next;

    }
    // With recursion
    public static Node merge(Node head1, Node head2) {
        if(head1 == null && head2 == null)
            return null;

        if(head1 == null)
            return head2;

        if(head2 == null)
            return head1;

        Node head;

        if(head1.data > head2.data){
            head = head2;
            head.next = merge(head1, head2.next);
        }else{
            head = head1;
            head.next = merge(head1.next, head2);
        }

        return head;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMiddle(head);
        Node nextMid = mid.next;
        mid.next = null;

        Node left = mergeSort(head);

        Node right = mergeSort(nextMid);



        return merge(left, right);
    }

    public static Node getMiddle(Node head){
        if(head == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);


        SingleLinkedList list2 = new SingleLinkedList(MergeSortedLists.mergeIterative(head1, head2));
        list2.print();
        System.out.println(MergeSortedLists.getMiddle(list2.head).data);

       /* SingleLinkedList list = new SingleLinkedList(MergeSortedLists.merge(head1, head2));
        list.print();*/

       Node headA = new Node(40);
       headA.next = new Node(20);
       headA.next.next = new Node(60);
       headA.next.next.next = new Node(10);
       headA.next.next.next.next = new Node(50);
       headA.next.next.next.next.next = new Node(30);

       SingleLinkedList list3 = new SingleLinkedList(MergeSortedLists.mergeSort(headA));
       list3.print();
    }
}
