package org.example.leetCodeWithNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> list= new ArrayList<>();
        if (root==null)return list;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        boolean leftToright=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> subList= new ArrayList<>();
            while (size-->0){
                TreeNode node=q.poll();
                if (leftToright) subList.add(node.val);
                else subList.add(0, node.val);
                if (node.left!=null)q.offer(node.left);
                if (node.right!=null)q.offer(node.right);
            }
            leftToright=false;
            list.add(subList);
        }
        return list;
    }


        public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isReverse = false;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                Deque<Integer> levelNodes = new LinkedList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (isReverse) {
                        levelNodes.offerFirst(node.val);
                    } else {
                        levelNodes.offerLast(node.val);
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(new ArrayList<>(levelNodes));
                isReverse = !isReverse;
            }

            return result;
        }
    }

