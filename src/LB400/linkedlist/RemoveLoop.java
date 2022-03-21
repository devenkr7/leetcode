package LB400.linkedlist;

public class RemoveLoop {

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
        l5.next = l1;
        removeLoop(l1);
        ListNode.printLL(l1);
    }

    public static void removeLoop(ListNode head){
        boolean loop = false;
        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                loop = true;
                break;
            }
        }
        if(!loop) return;

        //to handle circular LL
        if(prev.next == head){
            prev.next=null;
            return;
        }

        ListNode start = head;
        while(start.next != fast.next) {
            start = start.next;
            fast = fast.next;
        }
        fast.next = null;
    }
}
