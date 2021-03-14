package com.programmers;
import java.util.*;

public class Programmers_위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};		
		int ans = solution(clothes);
		System.out.println(ans);
	}

	public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String category = clothes[i][1];
            if(hm.containsKey(category)){ //이미 있으면
                hm.put(category, hm.get(category)+1);
            }else{
                hm.put(category, 1);
            }
        }//각 의상의 카테고리 개수 입력
        
        //각 종류들에 대해서 
        //하나를 골라서 선택(종류의 개수만큼), 선택하지 않음(+1)
        //경우의 수 곱해주기
        for(String s : hm.keySet()){
            answer *= hm.get(s)+1;
        }
        
      //옷을 하나도 안입는 경우는 없기 때문에 -1
        return answer-1;
    }
}
