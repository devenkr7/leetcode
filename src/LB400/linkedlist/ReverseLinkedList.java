package LB400.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2,
                        new ListNode(3, new ListNode(4,
                        new ListNode(5, null)))));

        recursiveReverse(head);
        ListNode.printLL(h);

    }

    private static ListNode iterativeReverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode h = new ListNode();
    private static void recursiveReverse(ListNode head) {
        if(head.next == null){
            h = head;
            return;
        }
        recursiveReverse(head.next);
        ListNode k = head.next;
        k.next = head;
        head.next = null;
    }

    private static void printLL(ListNode head) {
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
