package org.example.groupweeks.task29;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class queueColl {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue= new MyQueue();
        myQueue.enqueue(2);
        myQueue.enqueue(5);
        myQueue.PrintQueue();
        System.out.println();
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        //System.out.println(myQueue.dequeue());
        Queue<Integer> que= new LinkedList<>();
        que.add(1);
        que.add(3);
        System.out.println(que.remove());
        TreeMap<Integer, String> maps= new TreeMap<>();
        maps.put(0, "sara");
        maps.put(1, "sara");
        maps.put(2, "sara");
        System.out.println(maps);



    }


}
