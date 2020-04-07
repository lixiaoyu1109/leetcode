package com.lxy.leetcode;

/**
 * 75.颜色分类 
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * 双指针，一趟常数空间排序
 * 
 * @author lixiaoyu
 *
 */
public class Code75 {
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int cur = 0;
		while (cur <= right) {
			if (nums[cur] == 0) {
				int temp = nums[left];
				nums[left] = 0;
				nums[cur] = temp;
				left++;
				cur++;
				continue;
			} else if (nums[cur] == 2) {
				int temp = nums[right];
				nums[right] = 2;
				nums[cur] = temp;
				right--;
				continue;
			} else {
				cur++;
				continue;
			}
		}
	}
}
