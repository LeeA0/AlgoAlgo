package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 종류별로 아이템을 저장할 수 있는 Hash맵 생성
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        /*
         * 아이템명, 종류
         */
        
        for (int i = 0; i < clothes.length; i++) {
			// 해당 종류의 옷이 존재한다면
			if(map.get(clothes[i][1]) != null) {
				map.get(clothes[i][1]).add(clothes[i][0]);			
			}else {
				ArrayList<String> tmp = new ArrayList<>();
				tmp.add(clothes[i][0]);
				map.put(clothes[i][1], tmp);
			}
			
			
		}
//        System.out.println(map.keySet());
//        String[] tmpKeyArr = (String[]) map.keySet().toArray();
//        for (int i = 0; i < tmpKeyArr.length; i++) {
//			answer *= Math.pow(2, map.get(tmpKeyArr[i]).size());
//		}

        for(Object key : map.keySet()) {
        	System.out.println(key + " " + map.get(key).size());
//        	answer += Math.pow(2, map.get(key).size()) - 1;
        	answer *= (map.get(key).size() + 1);
        }
        
        return answer - 1;
    }
}
