package org.example.task2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3a(int k, int n) {
        List<Integer> ans = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        combin(k, n, 1, ans, res);
        return res;

    }

    public static void combin(int k, int n, int index, List<Integer> ans, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList(ans));
            return;
        }
        for (int i = index; i < 10; i++) {
            ans.add(i);
            combin(k - 1, n - i, i + 1, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3b(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 0 || n == 0) return res;
        dfs(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int start, int k, int n) {
        if (k == 0) {
            if (n == 0) res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(res, list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3c(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }

    List<List<Integer>> list;

    public List<List<Integer>> combinationSum3d(int k, int n) {
        this.list = new ArrayList<>();
        if (k <= 0 || n < 1 || n > 45) return list;

        backtrack(new ArrayList<>(), k, n, n);
        return list;
    }

    private void backtrack(List<Integer> sublist, int k, int start, int sum) {
        if (sum < 0) return;
        if (sum == 0) {
            if (sublist.size() == k) {
                list.add(new ArrayList<>(sublist));
            }
            return;
        }

        for (int i = Math.min(9, start); i > 0; i--) {
            sublist.add(i);
            backtrack(sublist, k, i - 1, sum - i);
            sublist.remove(sublist.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3e(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(result, new ArrayList<>(), nums, n, k, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remaining, int size,
                           int start) {
        if (tempList.size() > size)
            return;
        if (remaining < 0)
            return;
        if (tempList.size() == size && remaining == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remaining - nums[i], size, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3f(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combi(res, new ArrayList<>(), 1, 0, k, n);
        return res;
    }

    public void combi(List<List<Integer>> res, List<Integer> ds, int num, int sum, int k, int n) {
        if (k == 0 && n == sum) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = num; i <= 9; i++) {
            sum += i;
            ds.add(i);
            combi(res, ds, i + 1, sum, k - 1, n);
            sum -= i;
            ds.remove(ds.size() - 1);
        }
    }

    //    /**
//     * Backtracking
//     *
//     * Time complexity = InternalNodes in the RecursionTree   +   K * LeafNodes in RecursionTree
//     *                 = (C(9,0) + C(9,1) + ... + C(9,K-1))   +   K * C(9,K)
//     * In our solution, the worst case will happen when k = 8. Then Total Time Complexity = O(574) which is O(1)
//     *
//     * Space Complexity = O(k) -> Depth of Recursion tree + Size of TempList
//     *
//     * K = Input size of each combination.
//     */
    class Solution {
        public List<List<Integer>> combinationSum3g(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();

            if (k <= 0 || k > 9 || n <= 0 || n > 45 || (k == 1 && n > 9) || (k == 9 && n != 45) || (n < k * (k + 1) / 2)) {
                return result;
            }
            if (k == 1) {
                result.add(List.of(n));
                return result;
            }
            if (k == 9) {
                result.add(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
                return result;
            }

            combinationSum3(1, k, n, new ArrayList<>(), result);
            return result;
        }

        private void combinationSum3(int start, int k, int n, List<Integer> tempList, List<List<Integer>> result) {
            if (k == 0) {
                if (n == 0) {
                    result.add(new ArrayList<>(tempList));
                }
                return;
            }

            for (int i = start; i <= 9; i++) {
                if (i > n) {
                    break;
                }
                tempList.add(i);
                combinationSum3(i + 1, k - 1, n - i, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}