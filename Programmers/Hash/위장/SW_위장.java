package final_algo.programmers;

import java.util.HashMap;

public class Programmers_위장 {

	class Solution {
	    public int solution(String[][] clothes) {
	    	//곱셈을 위해 answer을 1로 초기화
	        int answer = 1;
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        for (int i = 0; i < clothes.length; i++) {
	        	//동일 종류의 의상이 1개일경우
				if (map.get(clothes[i][1]) == null) {
					map.put(clothes[i][1], 1);
					//동일한 종류의 의상이 있을 경우 count
				} else {
					map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
				}
			}
	        //경우의 수
	        for (String key : map.keySet()) {
				answer *= (map.get(key) + 1);
			}
	        
	        return answer -1;
	    }
	}
}
