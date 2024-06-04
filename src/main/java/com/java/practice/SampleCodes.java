package com.java.practice;

import org.spark_project.guava.collect.Lists;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleCodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("swapCharacters ------------>"+ swapCharacters("Praveen"));
		System.out.println("lengthOfLastWord ---------->" +lengthOfLastWord("Praveen Devika"));
		int [] twoSum=twoSums(new int[] {2,7,11,15},18); 
		System.out.println("twoSums ---------->" + twoSum[0] + twoSum[1]);


		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 99);
		map.put("B", 67);
		map.put("C", 65);
		map.put("D", 65);

		System.out.println(sortedMap(map));

	}

	public static Map<String, Integer> sortedMap(Map<String, Integer> hm) {
		Stream<Map.Entry<String,Integer>> sorted =
				hm.entrySet().stream()
						.sorted(Map.Entry.comparingByValue());

		hm.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);

		return hm;
	}
	
	public static String swapCharacters(String str) {
		String swapped ="";
		for(int i=0; i<str.length();i++) {
			final char temp = str.charAt(str.length()-i-1);



			Character.isLetter(temp);
			swapped+=temp;					
		}
		
		return swapped;
	}
	
	public static int lengthOfLastWord(String s) {
		String[] str = s.split(" ");
		return str[str.length-1].length();
	}
	
	public static int[] twoSums(int[] nums, int target) {
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		//int[] ret = new int[2];
		for(int i=0; i<nums.length; i++) {
			int diff = target -nums[i];
			if(hm.containsKey(diff)) {
				 //ret[0]= hm.get(diff);
				 //ret[1] = i;
				 //return ret;
				 return new int[] {hm.get(diff),i};
			}
			hm.put(nums[i], i);
		}
		
		return null;
		
	}

}
