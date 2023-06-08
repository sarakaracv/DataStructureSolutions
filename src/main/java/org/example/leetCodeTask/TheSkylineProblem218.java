package org.example.leetCodeTask;

import java.util.*;

public class TheSkylineProblem218 {
    public static void main(String[] args) {

    }
        public List<List<Integer>> getSkyline1(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            List<int[]> height = new ArrayList<>();
            for (int[] building : buildings) {
                // Add left endpoint with negative height
                height.add(new int[]{building[0], -building[2]});
                // Add right endpoint with positive height
                height.add(new int[]{building[1], building[2]});
            }
            // Sort height array by x-coordinate, then by height if x-coordinates are equal
            Collections.sort(height, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            maxHeap.offer(0);
            int prevMaxHeight = 0;
            for (int[] h : height) {
                if (h[1] < 0) {
                    // Add left endpoint to max heap
                    maxHeap.offer(-h[1]);
                } else {
                    // Remove right endpoint from max heap
                    maxHeap.remove(h[1]);
                }
                int currentMaxHeight = maxHeap.peek();
                if (prevMaxHeight != currentMaxHeight) {
                    result.add(Arrays.asList(h[0], currentMaxHeight));
                    prevMaxHeight = currentMaxHeight;
                }
            }
            return result;
        }
    public List<List<Integer>> getSkyline2(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0, n = buildings.length;
        while (i < n || !pq.isEmpty()) {
            int x = pq.isEmpty() ? buildings[i][0] : pq.peek()[0];
            if (i >= n || buildings[i][0] > x) {
                while (!pq.isEmpty() && pq.peek()[0] <= x) {
                    pq.poll();
                }
            } else {
                x = buildings[i][0];
                while (i < n && buildings[i][0] == x) {
                    pq.offer(new int[]{buildings[i][1], buildings[i][2]});
                    i++;
                }
            }
            int h = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != h) {
                res.add(Arrays.asList(x, h));
            }
        }
        return res;
    }



    }
