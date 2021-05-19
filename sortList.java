/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
    }
    public ListNode merge(ListNode n1,ListNode n2) {
        ListNode list=new ListNode();
        ListNode pt=list;
        while (n1!=null && n2!=null) {
            if (n1.val<n2.val) {
                pt.next=n1;
                n1=n1.next;
                pt=pt.next;
            } else {
                pt.next=n2;
                n2=n2.next;
                pt=pt.next;
            }
        }
        pt.next=(n1==null)?n2:n1;
        return list.next;
    }
    public ListNode findMid(ListNode head) {
        ListNode midPrev=null;
        while (head!=null && head.next!=null) {
            midPrev=(midPrev==null) ? head: midPrev.next;
            head=head.next.next;
        }
        ListNode mid=midPrev.next;
        midPrev.next=null;
        return mid;
    }
}
