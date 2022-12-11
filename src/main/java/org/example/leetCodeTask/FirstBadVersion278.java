package org.example.leetCodeTask;

public class FirstBadVersion278 {
    public static void main(String[] args) {
    int n=5; int bad=4;
    FirstBadVersion278 first= new FirstBadVersion278();
        System.out.println(first.firstBadVersionLeft1(4));
    }

    boolean isBadVersion(int version) {
        return false;
    }
    public int firstBadVersionLeft1(int n) {
        int i = 1;
        while (i < n) {
            int mid = i + (n - i) / 2;
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    public int firstBadVersion2(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int i = 1;
        int j = n;
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (!isBadVersion(mid)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return j + 1;
    }
    public int firstBadVersion3(int n) {
        int start = 1, end = n;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(isBadVersion(mid) == false) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    public int firstBadVersion4(int n) {
        if (n == 1) return 1;
        int l = 1;
        int r = n;
        int earliestBadVersion = n;

        while (r >= l) {
            int i = l + (r - l) / 2;
            if (isBadVersion(i)) {
                earliestBadVersion = i;
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return earliestBadVersion;
    }
    public int firstBadVersion5(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int firstBadVersion6(int n) {
        int left = 0;
        int right = n;

        while(right >= left){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid) == true){
                right = mid - 1;
                if(isBadVersion(mid - 1) == false){
                    return mid;
                }
            }
            else{
                left = mid + 1;
            }
        }
        return 0;
    }
    public int firstBadVersion7(int n) {
        int start = 1;
        int end = n;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}
