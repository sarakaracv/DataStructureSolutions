package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII210 {
    public static void main(String[] args) {

    }
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<List<Integer>> adjList = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] pair : prerequisites) {
                int course = pair[0];
                int prereq = pair[1];
                inDegree[course]++;
                adjList.get(prereq).add(course);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] order = new int[numCourses];
            int index = 0;
            while (!queue.isEmpty()) {
                int course = queue.poll();
                order[index++] = course;
                for (int neighbor : adjList.get(course)) {
                    if (--inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            return index == numCourses ? order : new int[0];
        }
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        ArrayList < ArrayList < Integer >>adj=new ArrayList<>();

        for(int i=0;i<=numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        Queue<Integer>q=new LinkedList<>();
        int indegree[]=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for(int e:adj.get(i)){
                indegree[e]++;
            }
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int ans[]=new int[numCourses];
        int i=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans[i++]=node;

            for(int e:adj.get(node)){
                indegree[e]--;
                if(indegree[e]==0) q.add(e);
            }
        }
        if(i==numCourses) return ans;
        int arr[]={};
        return arr;
    }
    }
