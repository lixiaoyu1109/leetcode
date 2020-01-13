package com.lxy.leetcode;

/**
 * 75.颜色分类
 * 
 * @author lixiaoyu
 *
 */
public class Code75 {
    public void sortColors(int[] nums) {
    	int left = 0;
    	int right = nums.length -1;
    	int cur = 0;
    	while(cur <= right) {
    		if (nums[cur] == 0) {
    			int temp = nums[left];
    			nums[left] = 0;
    			nums[cur] = temp;
    			left++;
    			cur++;
    		} else if (nums[cur] == 2) {
    			int temp = nums[right];
    			nums[right] = 2;
    			nums[cur] = temp;
    			right--;
    		} else {
    			cur++;
    		}
    	}
    }
}
