package LB400.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class MoveLastElementToFront {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5, null)))));
        ListNode res = solution(head);
        ListNode.printLL(res);
    }

    private static ListNode solution(ListNode head) {

        if(head.next==null) return head;
        ListNode last = head;
        ListNode secondLast = null;

        //reaching last node
        while(last.next!=null) {
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = head;
        return last;
    }
}
