package com.lxy.leetcode;

/**
 * 3.无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * 滑动窗口，双指针。移动右指针，有新的元素进入窗口时，判断是否移动左指针
 * 
 * @author lixiaoyu
 *
 */
public class Code3 {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = 0;
        int start = 0;
        for (int i=0;i<arr.length;i++) {
        	if(start == i) {
        		len = Math.max(len, i-start+1);
        		continue;
        	}
        	
        	int t = start;
        	while (t<i) {
        		if(arr[t] == arr[i]) {
        			start = t+1;
        			len = Math.max(len, i-start+1);
        			break;
        		}
        		t++;
        	}
        	len = Math.max(len, i-start+1);
        }
        
        return len;
    }
}
