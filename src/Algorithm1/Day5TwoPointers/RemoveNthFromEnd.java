package Algorithm1.Day5TwoPointers;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Node1 {
    int val;
    Node1 next;
    Node1() {};
    Node1(int val) { this.val = val; }
    Node1(int val, Node1 next) { this.val = val; this.next = next; }
}

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        Node1 head = new Node1(1, new Node1(2, new Node1(3, new Node1(4, new Node1(5, null)))));
        removeNthFromEnd(head, 2);
        while(head != null){
            System.out.println(head.val);
            head=  head.next;
        }
    }

    public static Node1 removeNthFromEnd(Node1 head, int n) {
        if(head.next == null) return null;
        Node1 fast = head;
        Node1 slow = head;
        //moving fast pointer first by n forward
        while(n!=0){
            fast = fast.next;
            n--;
        }
        //first element removal case
        if(fast==null) {
            return head.next;
        }
        //now move slow and fast by 1 step each until fast reaches last element
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //now next element of slow will be the target element
        slow.next = slow.next.next;
        return head;
    }

}
