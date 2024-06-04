/**
 * 
 */
package com.java.practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author praveensannakki
 *
 */
public class KClosestDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		int[][] res = findClosestDistance(points, 2);
		
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i][0] + " " +res[i][1]);
		}

	}

	private static int[][] findClosestDistance(int[][] points, int k) {

		int[][] ret = new int[k][2];

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < points.length; i++) {
			list.add(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
		}

		Collections.sort(list);

		list.forEach(x -> System.out.println(x));

		int distK = list.get(k - 1);

		System.out.println("distK " + distK);
		
		int t = 0;
        for (int i = 0; i < points.length; ++i) {
        	int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        	if (dist <= distK)
                ret[t++] = points[i];

        }
        
		return ret;
	}

}
