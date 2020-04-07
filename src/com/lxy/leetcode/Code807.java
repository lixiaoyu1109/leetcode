package com.lxy.leetcode;

/**
 * 807. 保持城市天际线
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * 
 * @author lixiaoyu
 *
 */
public class Code807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
    	int lenRow = grid.length;
    	int lenCol = grid[0].length;
    	int[] rowSkyline = new int[lenRow];
    	int[] colSkyline = new int[lenCol];
    	
    	for (int i=0;i<lenRow;i++) {
    		for (int j=0;j<lenCol;j++) {
    			rowSkyline[i] = Math.max(rowSkyline[i], grid[i][j]);
    			colSkyline[j] = Math.max(colSkyline[j], grid[i][j]);
    		}
    	}
    	
    	int maxIncValue = 0;
    	for (int i=0;i<lenRow;i++) {
    		for (int j=0;j<lenCol;j++) {
    			maxIncValue += Math.min(rowSkyline[i], colSkyline[j]) - grid[i][j];
    		}
    	}
    	
    	return maxIncValue;
    }
    
    public static void main(String[] args) {
    	int[][] grid = new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    	System.out.println(new Code807().maxIncreaseKeepingSkyline(grid));
	}
}