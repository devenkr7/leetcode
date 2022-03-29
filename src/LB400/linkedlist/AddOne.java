package LB400.linkedlist;

//https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
public class AddOne {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, null)));
        ListNode res = addOne(head);
        ListNode.printLL(res);
    }

    public static ListNode addOne(ListNode head) {
        //first reverse the linked-list
        ListNode newH = reverse(head);
        ListNode h = newH;
        boolean carry = false;
        int digit = h.val+1;
        while(h != null){
            if(carry){
                digit = h.val+1;
            }
            if(digit == 10){
                h.val = 0;
                carry = true;
            } else {
                h.val = digit;
                carry = false;
                break;
            }
            h = h.next;
        }
        //re reverse the Linked list
        ListNode res = reverse(newH);
        // to handle 99, 999, 999, .. cases
        if(carry) {
            ListNode newRes = new ListNode(1);
            newRes.next = res;
            return newRes;
        }
        return res;
    }

    public static ListNode reverse(ListNode h){
        ListNode curr = h;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
