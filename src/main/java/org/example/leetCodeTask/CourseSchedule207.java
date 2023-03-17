package org.example.leetCodeTask;

import java.util.*;

public class CourseSchedule207 {
    //graph question
    public static void main(String[] args) {

    }
    Set<Integer> set = new HashSet();
    public boolean canFinish1(int n, int[][] prerequisites) {
        int [] count = new int[n];
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        for(int k = 0; k < n; k++) {
            prereqs[k] = new ArrayList();
        }
        for(int [] temp : prerequisites) {
            int a = temp[0];
            int b = temp[1];
            count[a]++;
            prereqs[b].add(a);
        }


        for(int k = 0; k < count.length; k++) {
            if(!set.contains(k)) {
                if(count[k] == 0) {
                    n = DFS(count, prereqs, k, n);
                }
            }
        }
        return n == 0 ?  true : false;
    }

    public int DFS(int [] count, ArrayList<Integer>[] prereqs, int currentClass, int n)
    {
        set.add(currentClass);
        n--;
        if(prereqs[currentClass].size() == 0)
        {
            return n;
        }
        for(int neighbor : prereqs[currentClass])
        {
            count[neighbor]--;
            if(count[neighbor] == 0)
            {
                if(!set.contains(neighbor))
                {
                    n = DFS(count, prereqs, neighbor, n);
                }
            }
        }
        return n;
    }
        public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] degree= new int[numCourses];
        List<List<Integer>> list= new ArrayList<>(numCourses);
        for (int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());

        }
        for (int [] pair: prerequisites){
            int course=pair[0];
            int preq=pair[1];
            degree[course]++;
            list.get(preq).add(course);
        }
        Queue<Integer> queue= new LinkedList<>();
        for (int i=0; i<numCourses;i++){
            if (degree[i]==0){
                queue.offer(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int course=queue.poll();
            count++;
            for (int neighbor: list.get(course)){
                if (--degree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }

        return count==numCourses;
        }
    }
