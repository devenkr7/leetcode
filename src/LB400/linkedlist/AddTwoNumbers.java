package LB400.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode first = new ListNode(9, new ListNode(9, null));
        ListNode second = new ListNode(9, new ListNode(9,
                new ListNode(9, null)));

        ListNode.printLL(addTwoLists(first, second));
    }

    public static ListNode addTwoLists(ListNode first, ListNode second){

        //first reverse the linked-list
        ListNode revFirst = reverse(first);
        ListNode revSecond = reverse(second);

        ListNode realResult = null;
        ListNode result = null;
        int carry = 0;

        while(revFirst != null && revSecond != null){

            int digit = revFirst.val + revSecond.val + carry;
            if(result==null){
                result = new ListNode(digit%10);
                realResult = result;
            } else {
                result.next = new ListNode(digit%10);
                result = result.next;
            }

            if(digit > 9){
                carry = 1;
            } else {
                carry = 0;
            }
            revFirst = revFirst.next;
            revSecond = revSecond.next;
        }

        //for one of the remaining list
        if(revFirst != null || revSecond != null){
            while(revFirst != null) {
                if(carry==1){
                    int sum = carry + revFirst.val;
                    if(sum > 9){
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result.next = new ListNode(sum%10);
                    result = result.next;
                } else {
                    result.next = new ListNode(revFirst.val);
                    result = result.next;
                }
                revFirst = revFirst.next;
            }
            while(revSecond != null) {
                if(carry==1){
                    int sum = carry + revSecond.val;
                    if(sum > 9){
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result.next = new ListNode(sum%10);
                    result = result.next;
                } else {
                    result.next = new ListNode(revSecond.val);
                    result = result.next;
                }
                revSecond = revSecond.next;
            }
        }

        //if carry still==1
        if(carry==1){
            result.next = new ListNode(1);
            result.next=null;
        }

        //reverse the result Linked list

        return reverse(realResult);
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
