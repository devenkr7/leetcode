package LB400.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#
public class RemoveDupesFromUnsortedLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(1,
                new ListNode(3, new ListNode(5,
                        new ListNode(5, null)))));
        ListNode res = removeDupesFromUnsortedLL(head);
        ListNode.printLL(res);
    }

    private static ListNode removeDupesFromUnsortedLL(ListNode head) {
        /**
         * Using set in case of deleting dupes elements other than 1st occurrence
         */
        Set<Integer> set = new HashSet<>();
        ListNode t = head;
        ListNode prev = null;
        while(t != null) {
            if(set.contains(t.val)){
                //re-occurrence of same data
                prev.next = t.next;
                t = null;
            } else {
                set.add(t.val);
                prev = t;
            }
            t = prev.next;
        }
        return head;
    }
}
