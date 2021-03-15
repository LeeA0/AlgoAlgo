package com.programmers;
import java.util.*;

public class Programmers_���� {

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
            if(hm.containsKey(category)){ //�̹� ������
                hm.put(category, hm.get(category)+1);
            }else{
                hm.put(category, 1);
            }
        }//�� �ǻ��� ī�װ� ���� �Է�
        
        //�� �����鿡 ���ؼ� 
        //�ϳ��� ��� ����(������ ������ŭ), �������� ����(+1)
        //����� �� �����ֱ�
        for(String s : hm.keySet()){
            answer *= hm.get(s)+1;
        }
        
      //���� �ϳ��� ���Դ� ���� ���� ������ -1
        return answer-1;
    }
}
