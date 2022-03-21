package LB400.linkedlist;

public class DetectLoop {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5,null);
        ListNode l4 = new ListNode(4,null);
        ListNode l3 = new ListNode(3,null);
        ListNode l2 = new ListNode(2,null);
        ListNode l1 = new ListNode(1,null);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;
        boolean loop = detectLoop(l1);
        System.out.println(loop);
    }

    public static boolean detectLoop(ListNode head){
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
