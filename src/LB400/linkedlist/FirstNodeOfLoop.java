package LB400.linkedlist;

//https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
public class FirstNodeOfLoop {

    public static void main(String[] args) {

        ListNode head = new ListNode(50);
        head.next = new ListNode(20);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(10);

        head.next.next.next.next.next = head;

        ListNode res = firstNodeOfLoop(head);
        if(res == null) {
            System.out.println("No loop present");
        } else {
            System.out.println("loop starting at " + res.val);
        }
    }

    public static ListNode firstNodeOfLoop(ListNode head){
        boolean loop = false;
        if(head == null || head.next == null) {
            return null;
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
        if(!loop) return null;

        //to handle circular LL
        if(prev.next == head){
            prev.next=null;
            return head;
        }

        ListNode start = head;
        while(start.next != fast.next) {
            start = start.next;
            fast = fast.next;
        }
        return fast.next;
    }
}
