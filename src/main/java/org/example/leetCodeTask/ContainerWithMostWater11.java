package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {

    }
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int shorter = Math.min(height[i], height[j]);
            max = Math.max(max, shorter * (j - i));
            if (shorter == height[i]) {
                i ++;
            } else {
                j --;
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        int leftLineIndex = 0;
        int rightLineIndex = height.length - 1;
        int heightOfLeftLine = height[leftLineIndex];
        int heightOfRightLine = height[rightLineIndex];
        int maxArea = 0;

        while (leftLineIndex < rightLineIndex) {
            if (heightOfLeftLine < heightOfRightLine) {
                maxArea = Math.max(maxArea, (rightLineIndex - leftLineIndex) * heightOfLeftLine);
                while (leftLineIndex < rightLineIndex && height[leftLineIndex] <= heightOfLeftLine) {
                    leftLineIndex++;
                }
                heightOfLeftLine = height[leftLineIndex];
            } else {
                maxArea = Math.max(maxArea, (rightLineIndex - leftLineIndex) * heightOfRightLine);
                while (leftLineIndex < rightLineIndex && height[rightLineIndex] <= heightOfRightLine) {
                    rightLineIndex--;
                }
                heightOfRightLine = height[rightLineIndex];
            }
        }

        return maxArea;
    }
    public int maxArea3(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            if(height[i] <= height[j]){
                ans = Math.max(height[i]*(j-i), ans);
                i++;
            } else {
                ans = Math.max(height[j]*(j-i), ans);
                j--;
            }
        }
        return ans;
    }
    public int maxArea4(int[] height) {
        var max = 0;
        var left = 0;
        var right = height.length - 1;
        while(left < right) {
            var currentVolume = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, currentVolume);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    public int maxArea5(int[] height){
        int left = 0;
        int right = height.length - 1;
        int areaMax = 0;

        while(left < right)
        {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);

            int area = minHeight * width;
            areaMax = Math.max(areaMax, area);

            if(height[left] <= height[right]) left++;

            else right--;

        }
        return areaMax;
    }
    public int maxArea6(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            ans = Math.max(ans, (Math.min(height[i], height[j])*(j-i)));
            if(height[i] <= height[j]){
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
    public int maxArea7(int[] height) {
        int maxi=-1;
        int i=0,j=height.length-1;
        while(i<j){
            maxi=Math.max(maxi,((j-i)*Math.min(height[i],height[j])));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxi;
    }
    public int maxArea8(int[] height) {
        int max = -1;
        int i = 0 , j = height.length -1 ;
        while(i < j)
        {
            max = Math.max((j-i)*Math.min(height[i], height[j]), max);
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
         return max;
    }
    public int maxArea9(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r){
            int min = Math.min(height[l], height[r]);
            int area = min * (r - l);
            ans = Math.max(area, ans);
            if (min == height[l]) l++; // if (height[l] < height[r]) l++;
            else if (min == height[r]) r--;
        }
        return ans;
    }
    public int maxArea10(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxStorage = 0;
        while(l < r){
            int tempStorage = (height[l] < height[r] ? height[l] : height[r]) * (r - l);
            if(tempStorage > maxStorage)
                maxStorage = tempStorage;
            if(height[l] < height[r]) l++;
            else r--;
        }
        return maxStorage;
    }
    public int maxArea11(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        for(int i = 0; i < height.length; i++) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            res = Math.max(res, width * currentHeight);

            if(height[left] < height[right]) {
                left++;
            }
            else{
                right--;
            }
        }

        return res;
    }
    public int maxArea12(int[] height) {
        int cap=0;
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int hei=Math.min(height[i],height[j]);
        //         int wid=j-i;
        //         int temp=hei*wid;
        //         cap=Math.max(cap,temp);
        //     }
        // }
        int i=0;
        int j=height.length-1;
        while(i<j){
            int hei=Math.min(height[i],height[j]);
            int wid=j-i;
            int temp=hei*wid;
            System.out.println(j);
            cap=Math.max(cap,temp);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return cap;
    }
    //find container with most water
    //solution: have two pointers start at either end
    //move whichever pointer is the lower amongst the two endpoints
    //recalculate for the volume

    public int maxArea13(int[] height) {
        int i = 0;
        int j = height.length - 1;
        long maxVal = (j-i)*Math.min(height[i], height[j]);
        while(i < j) {

            System.out.println("Eval when i: " + i + " and j: " + j);
            maxVal = Math.max(maxVal, (j-i)*Math.min(height[i], height[j]));

            if(height[i] > height[j]) { // height of j is smaller, change j
                j--;
            }
            else if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
                i++;
            }

        }

        return (int)maxVal;
    }
    public int maxArea14(int[] height) {
        TreeMap<Integer, Integer> fromIndex = indexFromBeginning(height);
        TreeMap<Integer, Integer> toIndex = indexToEnd(height);
        int maxArea = 0;
        for (int i = 1; i <= fromIndex.lastKey(); i++) {
            Map.Entry<Integer, Integer> fromEntry = fromIndex.ceilingEntry(i);
            Map.Entry<Integer, Integer> toEntry = toIndex.ceilingEntry(i);
            if (fromEntry == null || toEntry == null) {
                break;
            }
            int from = fromEntry.getValue();
            int to = toEntry.getValue();

            int area = (to - from) * i;
            if (area > maxArea) {
                maxArea = area;
            }

        }
        return maxArea;
    }

    /**
     * @return A TreeMap with key = height and value = index which responds to: which is the first index with height >= x?
     */
    private TreeMap<Integer, Integer> indexFromBeginning(int[] height) {
        TreeMap<Integer, Integer> response = new TreeMap<>();
        int max = -1;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > max) {
                max = height[i];
                response.put(max, i);
            }
        }
        return response;
    }

    /**
     * @return A TreeMap with key = height and value = index which responds to: which is the last index with height >= x?
     */
    private TreeMap<Integer, Integer> indexToEnd(int[] height) {
        TreeMap<Integer, Integer> response = new TreeMap<>();
        int max = 0;
        for (int i = height.length - 1; i >= 1; i--) {
            if (height[i] > max) {
                max = height[i];
                response.put(max, i);
            }
        }
        return response;
    }
    public int maxArea15(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length-1;

        while(start<end) {
            int area = Math.min(height[start], height[end])*(end-start);
            if(area > max) max=area;
            System.out.println(start + " " + end);

            if(height[start]<height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
    public int maxArea16(int[] height) {
        int left = 0;
        int right=height.length-1;
        int max = -1;
        while(left<right){
            int high=right-left;
            max = Math.max(max,Math.min(height[left],height[right])*high);
            System.out.println(max);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
    public int maxArea17(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int lh=height[l];
            int rh=height[r];
            int min_h=Math.min(lh,rh);
            max=Math.max(max,min_h*(r-l));
            if(lh<rh){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
    public int maxArea18(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            if(height[i] <= height[j]){
                ans = Math.max(height[i]*(j-i), ans);
                i++;
            } else {
                ans = Math.max(height[j]*(j-i), ans);
                j--;
            }
        }
        return ans;
    }
    public int maxArea19(int[] height) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if (height.length == 2)
        {
            return Math.min(height[0], height[1]);
        }
        int i = 0, j = height.length - 1;
        int maxArea = 1;
        int currArea = 1;

        while (i < j)
        {
            currArea = Math.min(height[i], height[j]) * (j - i);
            if(currArea > maxArea)
            {
                maxArea = currArea;
                currArea = 1;
            }
            if (height[i] <= height[j])
            {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
    public int maxArea20(int[] height) {
        int[][] heightIndex = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            heightIndex[i][0] = height[i];
            heightIndex[i][1] = i;
        }
        Arrays.sort(heightIndex, (a, b) -> b[0] - a[0]);
        int left = height.length, right = -1, minHeight = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < height.length; i++) {
            if (heightIndex[i][1] < left || heightIndex[i][1] > right) {
                left = Math.min(left, heightIndex[i][1]);
                right = Math.max(right, heightIndex[i][1]);
                minHeight = Math.min(minHeight, heightIndex[i][0]);
            }
            max = Math.max(max, minHeight * (right - left));
        }
        return max;
    }
    public int maxArea21(int[] height) {
        int max=0;
        int i=0;
        int j= height.length-1;
        while(i<j){
            int p = Math.min(height[i],height[j]);
            int pro = p*(j-i);
            System.out.println(pro);
            if(max<pro) {
                max = pro;
            }
            if(height[i]>height[j]){
                j--;
            }
            else if(height[i]<height[j]){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        return max;
    }
    public int maxArea22(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int low,high;
        int n = arr.length;
        int distance = 0;
        low = 0;
        high = n-1;
        distance = high;

        while(low < high){
            if(arr[low]<=arr[high]){
                max = Math.max(max,arr[low]*(high-low));
                low++;
            }else{
                max = Math.max(max,arr[high]*(high-low));
                high--;
            }
            System.out.println("Low: "+low+" high: "+high+" max: "+max);
        }

        return max;

    }
    public int maxArea23(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n-1;

        int trappedWater[] = new int[n];
        int max = 0;

        for(int i=0; i<n; i++) {
            trappedWater[i] = Math.min(height[left], height[right]) * (right-left);

            if(height[left] < height[right]) {
                left++;
            }else if(height[right] < height[left]) {
                right--;
            }else {
                left++;
            }
        }

        for(int i=0; i<trappedWater.length; i++) {
            if(trappedWater[i] > max) {
                max = trappedWater[i];
            }
        }

        return max;
    }
}
