package org.example.leetCodeWithNode;

import java.util.HashMap;

public class LRUCache2 {
    public HashMap<Integer,DLinkedNode> cache;
    private int capacity;
    private int size;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache2(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size =0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null)
            return -1;
        else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        //that key does not exist in cache
        if(node==null){
            DLinkedNode temp = new DLinkedNode();
            temp.key = key;
            temp.value = value;
            addNode(temp);
            cache.put(key, temp);
            size++;

            if(size > capacity){
                DLinkedNode poped = popTail();
                cache.remove(poped.key);
                size--;
            }
        }
        else{
            node.value = value;
            moveToHead(node);
        }
    }

    class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode prev;
        private DLinkedNode next;

        private DLinkedNode(){
            this.key = 0;
            this.value = 0;
            this.prev= null;
            this.next =null;
        }

    }

    //new nodes are always added at the start of the list
    private void addNode(DLinkedNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev= node;
        head.next = node;

    }

    private DLinkedNode removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    //Whenever any node is accessed in the database, then it is moved tohead
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    //least recently used element will be present at the tail of the list
    private DLinkedNode popTail(){
        DLinkedNode prev = tail.prev;
        return removeNode(prev);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/*
class Node{//DLL
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;//stores each node metatdata reff w.r.t to key
    public int count, capacity;
    public Node head, tail;

    public LRUCache(int capacity) { //all nodes are inserded b/w head and tail node

        this.capacity= capacity;
        count= 0;

        map= new Node[10_000+1];//no of nodes //metadata w.r.t. to key

        head= new Node(0,0);
        tail= new Node(0,0);

        head.next= tail;
        tail.prev= head;

        head.prev= null;
        tail.next= null;
    }

    public void deleteNode(Node node){ // deleting the node in LRU cache
        node.prev.next= node.next;
        node.next.prev= node.prev;

        return;
    }

    public void addToHead(Node node){// adding the node in front of head i.e;in LRU cache
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;

        head.next= node;

        return;
    }

    public int get(int key) { // O(1)

        if( map[key] != null ){ //if node is present in LRU cache

            Node node= map[key];//getting the node metadata

            int nodeVal= node.value;

            deleteNode(node);//deleting the node from dll //O(1)

            addToHead(node);//adding to the front of head //now visited //O(1)

            return nodeVal;//returning the value of the node w.r.t to key
        }
        else
            return -1;//node not present
    }

    public void put(int key, int value) { // O(1)

        if(map[key] != null){//node already exists in LRU cache

            Node node= map[key]; //getting the node metadata

            node.value= value;//changing the node value to the current value

            deleteNode(node);//deleting the node  //O(1)

            addToHead(node);//adding node in front of head  //O(1)

        } else {//node dosent  exists in LRU cache

            Node node= new Node(key,value);

            map[key]= node;

            if(count < capacity){ //Case 1 //space availabe
                count++;
                addToHead(node);
            }
            else {//case 2 //space not availabe (capacity full)

                //deleting the least recently used node, making 1 sapce availabele
                map[tail.prev.key]= null;
                deleteNode(tail.prev);

                //adding the node in front of head
                addToHead(node);
            }
        }

        return;
    }
 */

