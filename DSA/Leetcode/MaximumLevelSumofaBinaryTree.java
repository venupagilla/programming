import java.util.LinkedList;
import java.util.Queue;
class  MaximumLevelSumofaBinaryTree{
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public int maxLevelSum(TreeNode root) {
    if (root == null) return 0;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    int maxSum = Integer.MIN_VALUE;
    int maxLevel = 1;
    int currentLevel = 1;
    
    while (!queue.isEmpty()) {
        int levelSum = 0;
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            levelSum += node.val;
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        if (levelSum > maxSum) {
            maxSum = levelSum;
            maxLevel = currentLevel;
        }
        
        currentLevel++;
    }
    
    return maxLevel;
}

}