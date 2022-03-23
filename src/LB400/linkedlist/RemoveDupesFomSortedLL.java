package LB400.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDupesFomSortedLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1,
                new ListNode(3, new ListNode(5,
                        new ListNode(5, null)))));

        ListNode res = removeDuplicates(head);
        ListNode.printLL(res);
    }

    private static ListNode removeDuplicates(ListNode head) {
        if(head ==null) return null;
        ListNode temp = head;
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
