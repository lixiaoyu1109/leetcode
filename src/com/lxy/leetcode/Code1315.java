package com.lxy.leetcode;

/**
 * 1513.祖父节点值为偶数的节点和
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * 递归节点
 * 
 * @author lixiaoyu
 *
 */
public class Code1315 {

	public int sumEvenGrandparent(TreeNode root) {
		return sum(root.left, root.val) + sum(root.right, root.val);
	}

	private int sum(TreeNode node, int parentValue) {
		if (node == null) {
			return 0;
		}

		if (parentValue % 2 == 0) {
			return (node.left == null ? 0 : node.left.val) + (node.right == null ? 0 : node.right.val)
					+ sum(node.left, node.val) + sum(node.right, node.val);
		} else {
			return sum(node.left, node.val) + sum(node.right, node.val);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
