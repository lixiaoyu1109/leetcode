package com.lxy.leetcode;

/**
 * lcp3.机器人大冒险
 * 
 * @author lixiaoyu
 *
 */
public class CodeLCP3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
    	char[] chars = command.toCharArray();
    	int[][] trace = new int[chars.length][2];
    	int px = 0;
    	int py = 0;
    	for (int i=0;i<chars.length;i++) {
    		if (chars[i] == 'U') {
    			trace[i][0] = px;
    			trace[i][1] = ++py;
    		} else {
    			trace[i][0] = ++px;
    			trace[i][1] = py;
    		}
    	}
    	
        if (!isInTrace(trace, x, y, px, py)){
        	return false;
        }
    	
        for (int i=0;i<obstacles.length;i++) {
        	if (obstacles[i][0] > x || obstacles[i][1] > y) {
        		continue;
        	}
        	
        	if (isInTrace(trace, obstacles[i][0], obstacles[i][1], px, py)) {
        		return false;
        	}
        }
        
    	return true;
    }
    
    private boolean isInTrace(int[][] trace, int x, int y, int px, int py) {
    	int k1 = x/px;
    	int k2 = y/py;
    	if(k1-k2 > 1 || k2-k1 > 1) {
    		return false;
    	}
    	int k = Math.min(k1, k2);
    	int px0 = x-px*k;
    	int py0 = y-py*k;
    	if (px0 == 0 && py0 == 0) {
    		return true;
    	}
    	for (int i=0;i<trace.length;i++) {
    		if (trace[i][0] == px0 && trace[i][1] == py0) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	int[][] obstacles = {{7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}};
    	System.out.println(new CodeLCP3().robot("URRURRR", obstacles , 4915, 1966));
	}
}
