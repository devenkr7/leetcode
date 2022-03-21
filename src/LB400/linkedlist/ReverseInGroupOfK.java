package LB400.linkedlist;

public class ReverseInGroupOfK {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                        new ListNode(3, new ListNode(4,
                        new ListNode(5, null)))));
        ListNode res = reverseInK(head, 3);
        ListNode.printLL(res);
    }

    public static ListNode reverseInK(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        int size = 0;
        while(curr != null && size<k){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size++;
        }
        if(curr != null)
            head.next = reverseInK(curr,k);
        return prev;
    }
}
