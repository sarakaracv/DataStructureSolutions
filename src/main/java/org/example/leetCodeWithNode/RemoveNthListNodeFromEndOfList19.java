package org.example.leetCodeWithNode;

public class RemoveNthListNodeFromEndOfList19 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int num2 = 2;
//      ListNode ListNode= new ListNode();
//      ListNode.add(1);
//      ListNode.add(2);
//      ListNode.add(3);
//      ListNode.add(4);
//      ListNode.add(5);
//      ListNode.printListNode();
//
//       // ListNode.next.next.next.next.next= ListNode.next.next;
//        System.out.println(removeNthFromEnd1(ListNode,num2));
//
//    }
//
//    public static ListNode removeNthFromEnd1(ListNode head, int n) {
//        ListNode ListNode = new ListNode(0);
//        ListNode left = ListNode, right = ListNode;
//        left.next = head;
//        for (int i = 0; i < n+1; i++) {
//            right= right.next;
//        }
//        while (right!=null){
//            left=left.next;
//            right= right.next;
//        }
//        left.next= left.next.next;
//        return ListNode.next;
//    }
//    public ListNode removeNthFromEnd2(ListNode head, int n) {
//
//        ListNode first = new ListNode();
//        first.next = head;
//        ListNode second = first;
//        ListNode dummyHead = first;
//
//
//        for(int i = 0; i <= n;i++ ){
//            second = second.next;
//        }
//
//        while( second != null ){
//            second = second.next;
//            first = first.next;
//        }
//
//        // now our first pointer is just before the ListNode to be deleted
//        first.next = first.next.next;
//
//        return dummyHead.next;
//
//    }
//    int size(ListNode head){
//        int count=0;
//        ListNode temp = head;
//        while(temp!=null){
//            count++;
//            temp=temp.next;
//        }
//        return count;
//    }
//    public ListNode removeNthFromEnd3(ListNode head, int n) {
//
//        if(head.next==null || head== null){
//            return null;
//        }
//        ListNode temp = head.next;
//        ListNode prev=head;
//        int size = size(head);
//        if(n==1){
//            ListNode p=head;
//            ListNode t= head.next;
//            while(t.next!=null){
//                t=t.next;
//                p=p.next;
//            }
//            p.next=null;
//            return head;
//        }
//        if(size==n){
//            return temp;
//        }
//
//        for(int i=1;i<=(size-n)-1;i++){
//            temp=temp.next;
//            prev=prev.next;
//        }
//
//        ListNode store = temp.next;
//        temp.next=null;
//        prev.next = store;
//        return head;
//
//    }
//    public ListNode removeNthFromEnd4(ListNode head, int n) {
//        int length = 0;
//        ListNode pointer = head;
//        while (pointer != null) {
//            length += 1;
//            pointer = pointer.next;
//        }
//
//        if (length == 1 && n == 1) {
//            return null;
//        }
//
//        int indexBeforeDeleteListNode = length - n - 1;
//
//        if (indexBeforeDeleteListNode < 0) {
//            head = head.next;
//            return head;
//        }
//
//        pointer = head;
//
//        for (int i = 0; i < indexBeforeDeleteListNode; i++) {
//            pointer = pointer.next;
//        }
//
//        if (pointer.next.next == null) {
//            pointer.next = null;
//        } else {
//            pointer.next = pointer.next.next;
//        }
//
//        return head;
//    }
//    public ListNode removeNthFromEnd5(ListNode head, int n) {
//        List<ListNode> list = new ArrayList<>();
//        ListNode currentListNode = head;
//        while (currentListNode != null) {
//            list.add(currentListNode);
//            currentListNode = currentListNode.next;
//        }
//
//        list.remove(list.size() - n);
//
//        ListNode dummyHead = new ListNode(-1);
//        currentListNode = dummyHead;
//        for(ListNode ListNode : list) {
//            currentListNode.next = ListNode;
//            currentListNode = currentListNode.next;
//        }
//
//        currentListNode.next = null;
//
//        return dummyHead.next;
//    }
//
//    public ListNode removeNthFromEnd6(ListNode head, int n) {
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode temp = head;
//        int i=1,size = 1;
//        while(temp.next!=null){
//            temp = temp.next;
//            size++;
//        }
//        if(size == n){
//            return head.next;
//        }
//        else{
//            if(fast.next == null){
//                return head.next;
//            }
//            while(fast.next != null&&i<size-n){
//                fast = fast.next;
//                i++;
//            }
//       /* while(fast.next!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }*/
//            if(fast.next!= null){
//                fast.next= fast.next.next;
//            }
//            return head;
//        }
//    }

    }
}
