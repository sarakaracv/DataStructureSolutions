package org.example.leetCodeWithNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode node= new ListNode();
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode ptr3 = new ListNode( 0 );
        ListNode dummy = ptr3;

        int carry = 0;
        while (ptr1 != null || ptr2 != null) {
            int val1 = ptr1 == null ? 0 : ptr1.val;
            ptr1 = ptr1 == null ? null : ptr1.next;
            int val2 = ptr2 == null ? 0 : ptr2.val;
            ptr2 = ptr2 == null ? null : ptr2.next;

            ptr3.next = new ListNode( 0 );
            ptr3 = ptr3.next;
            carry += val1 + val2;
            ptr3.val = carry % 10;
            carry /= 10;
        }
        if (carry > 0) {
            ptr3.next = new ListNode( carry );
        }

        return dummy.next;
    }
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);

        while(ln1 != null || ln2 != null || carry != 0) {
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            node = node.next = new ListNode(remainder);
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode res = new ListNode(0);
        res.next=new ListNode(0);
        ListNode p = res.next;
        while (l1 != null || l2 != null) {
            int val = flag + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            flag = val / 10;
            val %= 10;
            p.next = new ListNode(val);
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag != 0) {
            p.next = new ListNode(flag);
        }
        return res.next.next;
    }
    public ListNode addTwoNumbers5(ListNode l1, ListNode l2) {
        int sign=0, sum=0;
        ListNode index1=l1, index2=l2, newHead=new ListNode(-1), node= newHead;
        newHead.next=null;
        while(l1!=null || l2!=null){
            sum=sign;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            if(sum >= 10){
                sum=sum%10;
                sign=1;
            }else sign=0;
            node.next=new ListNode(sum);
            node=node.next;
        }
        if(sign!=0) {
            node.next=new ListNode(sign);
        }
        return newHead.next;
    }
    public ListNode addTwoNumbers6(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;  //moving to next pointer
            prev = cur;   //making next pointer the current pointer
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }public ListNode addTwoNumbers7(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> l1c = new ArrayList<>();
        List<Integer> l2c = new ArrayList<>();
        addIntoList(l1c, l1);
        addIntoList(l2c, l2);

        StringBuilder sb = new StringBuilder(l1c.size());
        for (int i = l1c.size() - 1; i >= 0; i--) {
            sb.append(l1c.get(i));
        }

        StringBuilder sb1 = new StringBuilder(l2c.size());
        for (int i = l2c.size() - 1; i >= 0; i--) {
            sb1.append(l2c.get(i));
        }

        long result = Long.valueOf(sb.toString()) + Long.valueOf(sb1.toString());

        char[] chars = new StringBuilder(String.valueOf(result)).reverse().toString().toCharArray();

        ListNode root = new ListNode(Integer.valueOf(String.valueOf(chars[0])));
        ListNode node = root;
        for (int i = 1; i < chars.length; i++) {
            node.next = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            node = node.next;
        }
        return root;
    }


    void addIntoList(List<Integer> list, ListNode node) {
        if (node != null) {
            list.add(node.val);
            addIntoList(list, node.next);
        }
    }
    public ListNode addTwoNumbers8(ListNode l1, ListNode l2) {
        //get the two number in string format ListNode l1 and l2
        String n1 = "" + l1.val;
        while(l1.next != null){
            n1 = n1 + l1.next.val;
            l1 = l1.next;
        }

        String n2 = "" + l2.val;
        while(l2.next != null){
            n2 = n2 + l2.next.val;
            l2 = l2.next;
        }

        //n1, n2 are two strings; but append "0" to the shorter one so
        //n1 and n2 are now for example: "3425", "5500"
        int len1 = n1.length();
        int len2 = n2.length();
        int len = len1;
        if(len2 < len1){
            int gap = len1 - len2;
            String zeros = String.format("%0" + gap + "d", 0);
            n2 = n2 + zeros;
        }
        if(len1 < len2){
            len = len2;
            int gap = len2 - len1;
            String zeros = String.format("%0" + gap + "d", 0);
            n1 = n1 + zeros;
        }

        //now add two numbers digit by digit
        int carryover = 0;
        String sumString = "";
        for(int i = 0; i < len; i++){
            int num1 = Character.getNumericValue(n1.charAt(i));
            int num2 = Character.getNumericValue(n2.charAt(i));
            int sum = num1 + num2 + carryover;
            carryover = 0;
            if(sum >= 10){
                sum = sum % 10;
                carryover = 1;
            }
            sumString = sumString + sum;
        }
        //append the final carryover if there is
        if(carryover == 1){
            sumString = sumString + "1";
        }

        //now the sum of two number is ready but it's a string, so make it
        //as a list
        ListNode [] nodeArray = new ListNode[sumString.length()];
        for(int i = 0; i < sumString.length(); i++){
            int value = Character.getNumericValue(sumString.charAt(i));
            ListNode node = new ListNode(value);
            nodeArray[i] = node;
        }

        for(int i = 0; i < nodeArray.length-1; i++){
            nodeArray[i].next = nodeArray[i+1];
        }

        //
        return nodeArray[0];
    }
    public static ListNode addTwoNumbers9(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode result = first;
        int carry = 0;
        while(true){
            int val1 = l1 == null?0:l1.val;
            int val2 = l2 == null?0:l2.val;
            int add = val1 + val2 + carry;
            carry = 0;
            if(add > 9)
                carry = add/10;
            first.val = add%10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

            if(l1 != null||l2 != null || carry > 0)
                first.next = new ListNode(0);
            else
                break;
            first = first.next;

        }

        return result;
    }
    public ListNode addTwoNumbers10(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null ) return l2;
        if (l2 == null ) return l1;
        ListNode head=null, prev=null;
        int carryOver = 0;
        int singleDigit = 0;
        boolean continues = true;
        do {
            int val1=0, val2=0;
            if (l1 != null) val1 = l1.val;
            if (l2 != null) val2 = l2.val;
            int res = val1 + val2 + carryOver;
            singleDigit = getSingleDigit ( res );
            carryOver = res / 10;
            ListNode n = new ListNode(singleDigit);
            if ( head == null )
                head = n;
            else
                prev.next = n;
            prev = n;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 == null && l2 == null) continues = false;
        } while (continues);
        if (carryOver>0) {
            ListNode n = new ListNode(carryOver);
            prev.next = n;
        }
        return head;
    }
    public int getSingleDigit ( int res) {
        if (res >= 10)
            return res % 10;
        else
            return res;
    }
    public ListNode addTwoNumbers11(ListNode n1, ListNode n2) {
        int add=0;
        ListNode n3=null;
        ListNode head=null;
        while(n1!=null||n2!=null){
            if(n1!=null){
                add+=n1.val;
                n1=n1.next;
            }
            if(n2!=null){
                add+=n2.val;
                n2=n2.next;
            }
            if(n3==null) {
                n3=new ListNode(add%10);
                head=n3;
            }else{
                n3.next=new ListNode(add%10);
                n3=n3.next;
            }
            add/=10;
        }
        if(add!=0){n3.next=new ListNode(add);}
        return head;
    }
    public ListNode addTwoNumbers12(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int listNodeSum = l1.val+l2.val;

        ListNode currentNode = new ListNode((listNodeSum) % 10);

        if ((listNodeSum) >= 10) {
            if (l2.next == null) {
                l2.next = new ListNode(1);
            } else {
                l2.next.val += 1;
            }
        }
        currentNode.next = addTwoNumbers12(l1.next, l2.next);
        return (currentNode);
    }
    public ListNode addTwoNumbers13(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l1;
        if(l2 == null)
            return l2;
        ListNode  res = new ListNode(0);
        ListNode nextPnt = res;
        int carry =0;

        while(l1!=null || l2!=null || carry !=0){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }

            res.next = new ListNode(carry %10);
            carry /= 10;
            res = res.next;
        }

        return nextPnt.next;
    }
    public ListNode addTwoNumbers14(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        int dozen = 0;

        while (l1 != null || l2 != null) {
            int pointerValue1 = (l1 == null) ? 0 : l1.val;
            int pointerValue2 = (l2 == null) ? 0 : l2.val;

            int sum = pointerValue1 + pointerValue2 + dozen;
            dozen = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (dozen > 0) {
                currentNode.next = new ListNode(dozen);
            }


        }
        return result.next;
    }
    public ListNode addTwoNumbers15(ListNode l1, ListNode l2) {
        ListNode head = null;
        // Reference of head which is null at this point
        ListNode temp = null;
        // Carry
        int carry = 0;
        // Loop for the two lists
        while (l1 != null || l2 != null) {
            // At the start of each iteration, we should add carry from the last iteration
            int sum = carry;
            // Since the lengths of the lists may be unequal, we are checking if the
            // current node is null for one of the lists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // At this point, we will add the total sum % 10 to the new node
            // in the resultant list
            ListNode node = new ListNode(sum % 10);
            // Carry to be added in the next iteration
            carry = sum / 10;
            // If this is the first node or head
            if (temp == null) {
                temp = head = node;
            }
            // For any other node
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head;

    }
    public ListNode addTwoNumbers16(ListNode l1, ListNode l2) {
        List<Integer> arrList1 = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>();
        while(l1 != null){
            arrList1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            arrList2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> totalList = null;
        if(arrList1.size() >= arrList2.size()) {
            totalList = this.fillTotal(arrList1, arrList2);
        } else if(arrList1.size() < arrList2.size()){
            totalList = this.fillTotal(arrList2, arrList1);
        }
        ListNode nodeTotal = null;
        ListNode temp = null;
        for(int i = 0; i < totalList.size(); i++){
            int value = totalList.get(i);
            ListNode newNode = new ListNode(value);
            if(nodeTotal == null) {
                nodeTotal = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        return nodeTotal;
    }

    private List<Integer> fillTotal(List<Integer> arrMax, List<Integer> arrMinor){
        int put = 0;
        int take = 0;
        int totalSum = 0;
        List<Integer> totalArr = new ArrayList<>();
        for(int i = 0; i < arrMax.size(); i++) {
            if(i < arrMinor.size()) {
                totalSum = arrMax.get(i) + arrMinor.get(i);
            } else {
                totalSum = arrMax.get(i);
            }
            if(totalSum > 9){
                put = (totalSum + take) % 10;
                take = (totalSum + take) / 10;
            } else {
                put = totalSum + take;
                if(put > 9) {
                    put = put % 10;
                    take = (put == 0) ? 1 : put / 10;
                } else {
                    take = 0;
                }
            }
            totalArr.add(put);
        }
        if(take > 0) {
            totalArr.add(take);
        }
        return totalArr;
    }
    public ListNode addTwoNumbers17(ListNode l1, ListNode l2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int prevwasmorethan10 = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int ansnum = num1 + num2;
            if (ansnum >= 10) {
                ans.add((ansnum + prevwasmorethan10) % 10);
                prevwasmorethan10 = 1;
            } else if (ansnum + prevwasmorethan10 >= 10) {
                ans.add(0);
                prevwasmorethan10 = 1;
            } else {
                ans.add(ansnum + prevwasmorethan10);
                prevwasmorethan10 = 0;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (prevwasmorethan10 == 1) {
            ans.add(1);
        }
        Collections.reverse(ans);
        ListNode nextnode = null;
        ListNode node = null;
        for (int each : ans) {
            node = new ListNode(each, nextnode);
            nextnode = node;
        }
        return node;
    }
    public ListNode addTwoNumbers18(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(l1!=null || l2!= null || carry!=0){
            int x = (l1!=null) ? l1.val:0;
            int y= (l2!=null) ? l2.val:0;
            int sum = carry+x+y;
            carry = sum/10;        // dividing sum by 10 storing carry which gives left digit 12/10 = 1
            curr.next = new ListNode(sum%10);   // storing modulo which gives right digit 12%10=2
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

        }
        // while doing modulo we are storing right side of digit at the end 0 will be stored
        return dummyHead.next;      // 0 this 0 is ommitted that's why dummy head. next' 3 2 3 1 2
    }

    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers19(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
    public ListNode addTwoNumbers20(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;

    }
    public ListNode addTwoNumbers21(ListNode l1, ListNode l2) {
        // Initialize a new ListNode to store the result
        ListNode result = new ListNode(0);
        ListNode current = result;

        // Initialize a carry variable to store any carry over from adding digits
        int carry = 0;

        // Loop through both input lists, adding the digits and updating the carry
        // as needed
        while (l1 != null || l2 != null) {
            // Extract the digits from each ListNode and add them together,
            // taking the carry into account
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            // Set the carry to the value of the tens digit in the sum
            // (i.e. the digit that will be carried over to the next addition)
            carry = sum / 10;

            // Append the ones digit in the sum (i.e. the digit that will be
            // stored in the current ListNode) to the result list
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next ListNode in each input list
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there is still a carry left over, append it to the result list
        if (carry > 0) current.next = new ListNode(carry);

        // Return the result, starting from the second node (the first node
        // was just a placeholder and its value is not important)
        return result.next;
    }
    public ListNode addTwoNumbers22(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return calculate(l1, l2, 0);
    }

    ListNode calculate(ListNode l1, ListNode l2, int carry)
    {
        if(l1==null&&l2==null&&carry==0) return null;
        if(l1==null&&l2==null&&carry!=0) return new ListNode(1);
        int temp=(l1==null? 0: l1.val)+ (l2==null? 0: l2.val)+ carry;
        ListNode result=new ListNode(temp%10);
        result.next=calculate(l1==null? null: l1.next, l2==null? null: l2.next, temp/10);
        return result;
    }
    public ListNode addTwoNumbers23(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode p=l1,q=l2,curr=dummy;

        while(p!=null || q!=null){
            int x= p!=null ?p.val:0;
            int y=  q!=null ?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null)p=p.next;
            if(q!=null)q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;

    }

    public ListNode addTwoNumbers24(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int listNodeSum = l1.val+l2.val;

        ListNode currentNode = new ListNode((listNodeSum) % 10);

        if ((listNodeSum) >= 10) {
            if (l2.next == null) {
                l2.next = new ListNode(1);
            } else {
                l2.next.val += 1;
            }
        }
        currentNode.next = addTwoNumbers24(l1.next, l2.next);
        return (currentNode);
    }

    public ListNode addTwoNumbers25(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode p=l1,q=l2,curr=dummy;
        int carry=0;
        while(p!=null ||q!=null)
        {
            int x=p!=null?p.val:0;
            int y=q!=null?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0)
        {
            curr.next=new ListNode(carry);
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers26(ListNode l1, ListNode l2) {
        ListNode sums = new ListNode();
        ListNode temp = new ListNode();
        sums.next = temp;
        int carry = 0;
        do {
            int t = 0;
            if(l1 != null)
                t += l1.val;
            if(l2 != null)
                t += l2.val;
            t += carry;
            carry = t/10;
            t = t%10;
            temp.next = new ListNode(t);
            temp = temp.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        } while(l1 != null || l2 != null);
        if(carry != 0) {
            temp.next = new ListNode(carry);
        }
        sums.next = sums.next.next;
        sums = sums.next;
        return sums;
    }
    public ListNode addTwoNumbers27(ListNode l1, ListNode l2) {
        String sb1 = join(l1);
        String sb2 = join(l2);

        java.math.BigInteger ln1 = new java.math.BigInteger(sb1);
        java.math.BigInteger ln2 = new java.math.BigInteger(sb2);

        ln1 = ln1.add(ln2);
        String tot = ln1.toString();

        ListNode root = new ListNode();
        ListNode iter = root;
        for (int i=tot.length()-1; i>=0; i--) {
            iter.val = Integer.parseInt(""+ tot.charAt(i));
            if ( i > 0) {
                iter.next = new ListNode();
                iter = iter.next;
            } else {
                iter.next = null;
            }
        }
        return root;
    }
    private String join( ListNode l1) {
        if (l1.next == null) {
            return "" + l1.val;
        }
        return join(l1.next) + l1.val;
    }
}
