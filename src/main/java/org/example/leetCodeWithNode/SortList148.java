package org.example.leetCodeWithNode;

import java.util.Arrays;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int arr[]=new int[len];
        temp =head;
        len=0;
        while(temp!=null){
            arr[len]=temp.val;
            len++;
            temp=temp.next;
        }
        Arrays.sort(arr);
        temp =head;
        len=0;
        while(temp!=null){
            temp.val=arr[len];
            len++;
            temp=temp.next;
        }
        return head;


    }

        public ListNode sortList5(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return merge(left, right);
        }

        private ListNode getMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode mid = slow.next;
            slow.next = null;
            return mid;
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }

            return dummy.next;
        }

    public ListNode sortList2(ListNode head) {
        return sortList(head, null);
    }

    ListNode sortList(ListNode p, ListNode q) {
        if (p == null || p == q) {
            return p;
        }
        boolean sorted = true;
        ListNode curr = p;
        while (curr.next != null && curr != q) {
            if (curr.val > curr.next.val) {
                sorted = false;
                break;
            }
            curr = curr.next;
        }
        if (sorted) {
            return p;
        }
        ListNode pre = p;
        ListNode head = p;
        curr = pre.next;
        while (curr != null && curr != q) {
            ListNode next = curr.next;
            if (curr.val < p.val) {
                pre.next = next;
                curr.next = head;
                head = curr;
            } else {
                pre = curr;
            }
            curr = next;
        }
        p.next = sortList(p.next, q);
        return sortList(head, p);
    }
    public ListNode sortList3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int max = 0;
        int maxNeg = 0;

        while(temp != null) {
            if(temp.val >= 0) {
                if(temp.val > max) {
                    max = temp.val;
                }
            } else {
                if(temp.val*-1 > maxNeg) {
                    maxNeg = temp.val*-1;
                }
            }
            temp = temp.next;
        }

        int[] arrNeg = new int[maxNeg+1];
        int[] arr = new int[max+1];

        ListNode insert = head;

        while(insert != null) {
            if(insert.val >= 0) {
                arr[insert.val]++;
            } else {
                arrNeg[insert.val*-1]++;
            }
            insert = insert.next;
        }

        ListNode sorted = head;

        for(int i=arrNeg.length-1; i > 0; i--) {
            while(arrNeg[i] > 0) {
                sorted.val = i*-1;
                sorted = sorted.next;
                arrNeg[i]--;
            }
        }

        for(int j=0; j < arr.length; j++) {
            while(arr[j] > 0) {
                sorted.val = j;
                sorted = sorted.next;
                arr[j]--;
            }
        }

        return head;
    }
    public ListNode sortList4(ListNode head) {
        ListNode curr = head;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(curr != null){
            if(curr.val > max){
                max = curr.val;
            }
            if(curr.val < min){
                min = curr.val;
            }
            curr = curr.next;
        }
        int size = max - min + 1;
        int[] a = new int[size];
        curr = head;
        while(curr != null){
            a[curr.val - min]++;
            curr = curr.next;
        }
        curr = head;
        int i = 0;
        while(curr != null){
            while(a[i] == 0){
                i++;
            }
            curr.val = i + min;
            a[i]--;
            curr = curr.next;
        }
        return head;
    }

}
