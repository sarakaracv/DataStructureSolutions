package org.example;

public class ListNodeTraning {
//    class ListNode{
//
//        public int item;
//
//        public ListNode next;
//
//    };
//
//
//    ListNode l; /* declaration of a "reference to" a ListNode*/
//
//
//    ListNode l1 = new ListNode();
//
//    ListNode l2 = new ListNode();
//
//    ListNode l3 = new ListNode();
//
//
//    l1.item = 1;
//
//    l2.item = 2;
//
//    l3.item = 3;
//
//    //To fill in the pointers between them and link them together:
//
//    l1.next = l2;
//
//    l2.next = l3;
//
//    l3.next = null;
//
//    //Basic Operations on list nodes: - define constructors for it:
//
//    ListNode (int obj)
//
//    {
//
//        item = obj;
//
//        next = null;
//
//    }
//
//    ListNode (int obj, ListNode n)
//
//    {
//
//        item = obj;
//
//        next = n;
//
//    }
//
//  //  Java will no longer allow "new ListNode()", unless we define a 0-arg constructor.
//
// //   We can build the previous list by:
//
//    ListNode l1 = new ListNode (1, new ListNode(2, new ListNode(3)));
//
//   // We can obtain the element on the position n in the list:
//
//    public ListNode ptrTo(int position)
//
//    {
//
//        if(position < 1) return null;
//
//        if(position == 1) return this;
//
//        if(next == null) return null;
//
//        return next.ptrTo(position-1);
//
//    }
//
//
//    Let's write two more methods, search, which looks for an element in the list and insertAt, which inserts an element into a given position.
//
//    public boolean search (int element)
//
//    {
//
//        ListNode curr = this;
//
//        while (curr!=null){
//
//            if(curr.item == element)return true;
//
//            curr = curr.next;
//
//        }
//
//        return false;
//
//    }
//
//    Does this always work? What happens in the following scenario?
//
//    ListNode lst1 = new ListNode (1, new ListNode(2));
//
//    lst1.next.next = lst1;
//
//lst1.search(4);
//
//    How can we fix this problem?
//
//    public void insertAt(int position, int element)
//
//    {
//
//        if(position ==1){// what to do here?}
//
//else if(position ==2)
//
//                next = new ListNode(element, next);
//
//            else
//
//                next.insertAt(position-1, element);
//
//        }
//
//        We can not insert (or delete) from the front of the list, because all we have is the "this" pointer to the first node.
//
//            Another problem: how can we represent an empty list? A simple answer would be that an empty list should be represented by null, e.g.:
//
//        ListNode anEmptyList = null;
//
//        What if we call:
//
//        anEmptyList.search(4);
//
//        anEmptyList.ptrTo(3);
//
//        Both calls would fail, because there is no object to receive those methods.
//
//        What can be done? Introduce a new data type List
//
//        class List{
//
//            private ListNode head;
//
//            public List(){head = null;}
//
//            public void insertFront (int obj)
//
//            {
//
//                head = new ListNode(onj, head);
//
//            }
//
//// other methods to be declared
//
//            public boolean isEmpty(){...}
//
//            public Object removeFront() {...}
//
//            public Object removeBack(){...}
//
//            public void insertBack(Object value){...}
//
//            public ListNode nth(int i){...}
//
//            public void insertAfter(ListNode node, Object value){...}
//
//        }
//
//        public class ListNode{
//
//            public Object item;
//
//            public ListNode next;
//
//            public ListNode(Object value){item = value;}
//
//        }
//
//        (Rewrite the methods defined above for the new class List.)
//
//        Please notice that I changed the type of the item field from int to Object to be able to accomodate any type of data in this field.
//
//            Now I'm going to try to convince you that data structures should be encapsulated so they can be accessed only through well-defined interfaces. Data structures treated this way are called ABSTRACT DATA TYPES. If you don't do this way, you will bankrupt the company you work for. Data encapsulation makes a big difference to the number of bugs and the ease of maintenance of large software programs.
//
//        To motivate ADTs, listen a story about Doofie the Lazy Programmer. So, Doofie applies for a job as a linked list enginner at a Sunnyvale startup called CyberTrendy Webscapes Inc. Like all Silicon Valley startups, Cybertrendy is desperate for any flesh can hack, so they hire Doofie. Doofie, now a programmer at a Silicon VAlley startup implemented a linked list like the one I gave it to you above. He also wrote the code that uses linked lists. One day, Doofie needed to write code that would splice a node out of the middle of a list. It would only take a few lines, and he didn't foresee ever needing to use the splice operation anywhere else. Being lazy, Doofie didn't feel like adding a splice() method to the List class. Instead, he just did the work directly:
//
//    public class ListMangler {
//
//[lotsa code]
//
//        ListNode node = list.nth(k);
//
//        /* Gosh, I am sooooooooooooooooooo tired. */
//
//        node.next = node.next.next;
//
//[lotsa more code]
//
//    }
//
//        Two years later, CyberTrendy has fallen behind their competitor, Alta Lista, in the heated linked list market. In an effort to regain their former lead, they put crack programmer Genie Yess on the job. Genie decides to replace CyberTrendy's old lists with leading-edge doubly-linked technology. Two years later, another programmer, Genie Yess, decides to improve the speed of their list data structure. After careful thought, she decides to reprogram the List class so that it uses doubly-linked lists internally. A "previous" field is added to ListNode, and the List methods are rewritten.
//
//        public class List {
//
//            public ListNode head;
//
//            public List() {
//
//                head = new ListNode(null);
//
//                head.next = head;
//
//                head.previous = head;
//
//            }
//
//[Same methods as before, rewritten.]
//
//        }
//
//        public class ListNode{
//
//            public Object item;
//
//            public ListNode next;
//
//            public ListNode previous;
//
//            public ListNode(Object value){
//
//                item = value;
//
//            }
}
