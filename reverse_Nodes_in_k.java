package DAY 2;

public class reverse_Nodes_in_k-Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check =head;
        int count=0;
        while(check!=null && count<k){
            check=check.next;
            count++;
        }
        if(count!=k) return head;
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        count=0;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            ListNode restHead=reverseKGroup(next,k);
            head.next=restHead;
        }
        return prev;
    }
}

