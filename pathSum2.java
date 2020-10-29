/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();
        
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> pathSoFar = new ArrayList();
        
        helper(root,sum,0,pathSoFar,finalList);
        
        return finalList;
    }
    
    public void helper(TreeNode root, int sum,int currSum,List<Integer> pathSoFar,List<List<Integer>> finalList){
        if (root == null)
            return;
        
        currSum = currSum + root.val;
        if(root.left==null && root.right==null && sum == currSum){
            List<Integer> temp = new ArrayList<Integer>(pathSoFar);
            temp.add(root.val);
            finalList.add(temp);           
        }
        pathSoFar.add(root.val);
        helper(root.left,sum,currSum,pathSoFar,finalList);     
        helper(root.right,sum,currSum,pathSoFar,finalList);
        pathSoFar.remove(pathSoFar.size()-1);
        
    }
} 