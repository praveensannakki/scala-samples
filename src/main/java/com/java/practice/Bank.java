/**
 * 
 */
package com.java.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author praveensannakki
 *
 */
public class Bank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] initial = new int[] {1000, 1500};
		
		String [] events = new String[] {
				"withdraw 1613327630 2 480", 
				"withdraw 1613327644 2 800", 
				"withdraw 1614105244 1 100", 
				"deposit 1614108844 2 200",
				"withdraw 1614108845 2 150" };
		
		int [] result = balance(initial,events);
		
		for(int i=0; i<result.length; i++) {
			System.out.println("Balance of " + (i+1)  +"=" + result[i]);
		}
	
				

	}

	public static int[] balance(int[] balances, String[] requests) {

		HashMap<Integer, Integer> bal = new HashMap<>();
		for (int i = 0; i < balances.length; i++) {
			bal.put(i+1, balances[i]);
		}
		
		for (Map.Entry<Integer, Integer> entry : bal.entrySet()) {
			System.out.println("Initial " + entry.getKey() + " " + entry.getValue());
		}
		

		List<String> list = Arrays.asList(requests);
		
		HashSet<String> hs = new HashSet<>(list);
		
		list.forEach(value -> { hs.add(value); });
		
		hs.forEach(value -> {System.out.println(value);});

//		HashSet<Integer> hs = new HashSet<>();
//		for (int i = 0; i < balances.length; i++) {
//			hs.add(i+1);
//		}

		for (int i = 0; i < list.size(); i++) {
			String[] reqArr = list.get(i).split(" ");
			String event = reqArr[0].trim();
			int ts = Integer.parseInt(reqArr[1]);
			int holderId = Integer.parseInt(reqArr[2]);
			int amount = Integer.parseInt(reqArr[3]);

			System.out.println(event + " " + ts + " " + holderId + " " + amount);
			
			if (!bal.containsKey(holderId)) {
				return new int[] { -(i + 1) };
			}
			
			if ("withdraw".equals(event)) {
				System.out.println("withdraw" + requests[0]);
				if (amount > bal.get(holderId)) {
					return new int[] { -(i + 1) };
				}
				bal.put(holderId, bal.get(holderId) - amount);
				if (ts + 86400 <= ts) {
					bal.put(holderId, bal.get(holderId) + (int) (amount * 0.02));
				}
			} else if ("deposit".equals(event)) {
				System.out.println("deposit" + requests[0]);
				bal.put(holderId, bal.get(holderId) + amount);
			}
		}

		int[] ret = new int[balances.length];
		// for(int i=0; i<ret.length; i++){
		// ret[i] = bal.get(i);
		// }

		int i = 0;
		for (Map.Entry<Integer, Integer> entry : bal.entrySet()) {
			ret[i++] = entry.getValue();
		}
		
		bal.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		bal.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

		return ret;

	}

}
