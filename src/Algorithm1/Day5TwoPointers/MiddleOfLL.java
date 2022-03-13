package Algorithm1.Day5TwoPointers;

//https://leetcode.com/problems/middle-of-the-linked-list/
class Node {
    int val;
    Node next;
    Node() {};
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}
public class MiddleOfLL {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node middleNode = middleNode(head);
        System.out.println(middleNode.val);
    }

    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        if(head.next==null) return head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

