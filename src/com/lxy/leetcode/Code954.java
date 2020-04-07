package com.lxy.leetcode;

import java.util.Arrays;

/**
 * leetcode-945 数组最小的增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * 
 * 先排序，后遍历比较.
 * 当A[i] <= A[i-1] 时，需要将A[i]加到A[i] = A[i-1] + 1，计数count
 * 时间复杂度 排序 O(NlogN)
 * 
 * @author lixiaoyu
 *
 */
public class Code954 {
    public int minIncrementForUnique(int[] A) {
    	Arrays.sort(A);
    	int count = 0;
    	for(int i=1;i<A.length;i++) {
    		if(A[i] <= A[i-1]) {
    			count += A[i-1] - A[i] + 1;
    			A[i] = A[i-1] + 1;
    		}
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {3,2,1,2,1,7};
		System.out.println(new Code954().minIncrementForUnique(nums));
	}
}
