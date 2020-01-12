package com.lxy.leetcode;

/**
 * 1302.层数最深叶子节点的和
 * 深度优先遍历(dfs,栈)与广度优先遍历（bfs,队列）
 * 深度：前序 （root-left-right）,中序（left-root-right）,后序(left-right-root)
 * 
 * @author lixiaoyu
 *
 */
public class Code1302 {
	
    public int deepestLeavesSum(TreeNode root) {
    	// 记录层级与和
    	int[] record = new int[] {0, 0};
    	findLeaves(root, record, 0);
    	return record[1];
    }
    
    private void findLeaves(TreeNode node, int[] record, int level) {
    	if (node.left == null && node.right == null) {
    		if(level > record[0]) {
    			record[0] = level;
    			record[1] = node.val;
    		} else if (level == record[0]) {
    			record[1] = node.val + record[1];
    		}
    		return;
    	}
    	
    	if (node.left != null) {
    		findLeaves(node.left, record, level+1);
    	}
    	
    	if (node.right != null) {
    		findLeaves(node.right, record, level+1);
    	}
    }
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}

