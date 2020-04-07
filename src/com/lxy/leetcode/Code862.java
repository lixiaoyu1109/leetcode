package com.lxy.leetcode;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 862.和至少为 K 的最短子数组
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 * 
 * @author lixiaoyu
 *
 */
public class Code862 {
    public int shortestSubarray(int[] A, int K) {
    	long[] p = new long[A.length+1];
    	for (int i=0;i<A.length;i++) {
    		p[i+1] = p[i] + (long) A[i];
    	}
    	
    	int len = A.length + 1;
    	Deque<Integer> monoq = new LinkedList<>();
    	for (int y = 0; y < p.length; ++y) {
            while (!monoq.isEmpty() && p[y] <= p[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && p[y] >= p[monoq.getFirst()] + K)
            	len = Math.min(len, y - monoq.removeFirst());

            monoq.addLast(y);
        }
    	return len == (p.length + 1) ? -1 : len;
    }
}
