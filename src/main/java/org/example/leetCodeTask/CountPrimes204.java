package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.BitSet;

public class CountPrimes204 {
        public int countPrimes1(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }

            return count;
        }

    public int countPrimes2(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] arr = new boolean[n];
        int count = n / 2;
        for(int i = 3; i * i < n; i += 2) {
            if (!arr[i]) {
                for (int j = i * i; j < n; j += i * 2) {
                    if (!arr[j]) {
                        arr[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public int countPrimes3(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] f = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
    public int countPrimes4(int n) {
        if(n < 3) return 0;
        boolean[] arr = new boolean[n>>1];
        int count = n>>1;
        for (int i = 3; i*i <n; i += 2) {
            if (!arr[i>>1]) {
                for (int j = i*i; j < n; j += i<<1) {
                    if (!arr[j>>1]) {
                        count--;
                        arr[j>>1] = true;
                    }
                }
            }
        }
        return count;
    }
    public int countPrimes5(int n) {
        if (n <= 0 || n == 1 || n == 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }

        BitSet set = new BitSet();
        n = n - 1;
        int s = (int)Math.sqrt(n);
        int ctr = n;
        for (int p = 2; p <= s; p ++) {
            if (!set.get(p)) {
                for (int q = 2; (p * q) <= n; q ++) {
                    if (!set.get(p * q)) {
                        ctr --;
                        set.set(p * q);
                    }
                }
            }
        }
        return ctr - 1;
    }

}
