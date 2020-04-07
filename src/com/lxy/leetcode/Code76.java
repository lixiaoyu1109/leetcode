package com.lxy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76.最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 
 * 1 滑动窗口，双指针，右指针往前找，当char[right] == char[left] 移动左指针,直到找到在目标字串的中字符，并且该字符数不超过目标串中字符出现的数
 * 2 确认是否存在覆盖字串，然后继续移动right指针
 * 
 * @author lixiaoyu
 *
 */
public class Code76 {
    public String minWindow(String s, String t) {
    	// t字符出现次数
    	Map<Character, Integer> baseMap = new HashMap<>();
    	Map<Character, Integer> runMap = new HashMap<>();
    	for(int i=0;i<t.length();i++) {
    		if (baseMap.get(t.charAt(i)) == null) {
    			baseMap.put(t.charAt(i), 1);
    		} else {
    			baseMap.put(t.charAt(i), baseMap.get(t.charAt(i)) + 1);
    		}
    		runMap.put(t.charAt(i), 0);
    	}
    	
    	int len = s.length() + 1;
    	String minStr = "";
    	int right = 0;
    	int left = 0;
         // 初始化left right
    	for(int i=0;i<s.length();i++) {
    		if(baseMap.get(s.charAt(i)) != null) {
    			left = i;
    			right = i;
                break;
    		}
    	}
    	while (right < s.length()){
    		Integer rightCount = runMap.get(s.charAt(right));
    		if (rightCount == null) {
    			right++;
    			continue;
    		} else {
    			if (rightCount == 0) {
    				runMap.put(s.charAt(right), 1);
    			} else {
    				while (left <= right) {
	    				Integer leftCount = runMap.get(s.charAt(left));
	    				// 如果没有找到包含字符，左标前移
	    				if (leftCount == null) {
	    					left++;
	    					continue;
	    				}
	    				
	    				if (leftCount > baseMap.get(s.charAt(left))) {
	    					runMap.put(s.charAt(left), leftCount-1);
	    					left++;
	    					continue;
	    				}
	    				
    					if (s.charAt(left) != s.charAt(right)) {
    						runMap.put(s.charAt(right), runMap.get(s.charAt(right))+1);
    						break;
    					}
    					
	    				if (leftCount >= baseMap.get(s.charAt(left))) {
	    					runMap.put(s.charAt(left), leftCount-1);
	    					left++;
	    				} else {
	    					runMap.put(s.charAt(right), runMap.get(s.charAt(right))+1);
	    					break;
	    				}
    				}
    			}
    			
    			if (len == s.length() + 1) {
    				boolean hasMinStr = true;
    				for (Character c : runMap.keySet()) {
    					if(runMap.get(c) < baseMap.get(c)) {
    						hasMinStr = false;
                            break;
    					}
    				}
    				if (hasMinStr) {
	    				minStr = s.substring(left, right+1);
	    				len = Math.min(len, minStr.length());
    				}
    			} else {
    				if(len >= right+1 - left) {
	    				minStr = s.substring(left, right+1);
	    				len = Math.min(len, minStr.length());
    				}
    			}
    			right++;
    		}
    	}
        return minStr;
    }
}
