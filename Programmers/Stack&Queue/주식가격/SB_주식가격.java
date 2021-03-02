package com.programmers;

import java.util.Arrays;

public class SB_주식가격 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		int[] answer = solution(prices);
		System.out.println(Arrays.toString(answer));
	}
	
	  public static int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i=0; i<prices.length-1; i++){
	            for(int j=i+1; j<prices.length; j++){
	                answer[i]++;
	                if(prices[i] > prices[j]){ // 가격이 떨어지면
	                    break;
	                }
	            }
	        }
	        
	        return answer;
	    }

}
