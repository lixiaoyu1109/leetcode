package com.lxy.leetcode;

/**
 * 316.去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 
 * 从左遍历字串，找到左边最小的字符，或者出现一次的字符
 * 然后递归往下找
 * 
 * @author lixiaoyu
 *
 */
public class Code316 {
    public String removeDuplicateLetters(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        int minIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(minIndex)) {
                minIndex = i;
            }
            if (--charCount[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(minIndex) + removeDuplicateLetters(
                s.substring(minIndex + 1).replaceAll("" + s.charAt(minIndex), ""));
    }
	
	public static void main(String[] args) {
		System.out.println(new Code316().removeDuplicateLetters("bcabc"));
	}
}
