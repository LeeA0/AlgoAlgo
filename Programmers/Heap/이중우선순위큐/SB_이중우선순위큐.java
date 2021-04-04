package com.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		int[] answer = solution(operations);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
		//1.최댓값 pque, 최솟값 pque 생성
		PriorityQueue<Integer> maxpque = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minpque = new PriorityQueue<>();
		
		//삽입한 수 count
		int insertCnt = 0;
		
		//2. operations 수행
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			String operation = st.nextToken(); //I, D
			int num = Integer.parseInt(st.nextToken()); //숫자
			
			switch (operation) {
			case "I": //삽입
				maxpque.add(num);
				minpque.add(num);
				insertCnt++;
				break;

			case "D": //삭제
				//3. 두 que size 합이 insertion 횟수보다 클때 연산수행
				if(maxpque.size()+minpque.size() > insertCnt) {
					if(num == 1) { //최댓값 삭제
						maxpque.poll();
					}else if(num == -1) { //최솟값 삭제
						minpque.poll();
					}
				}
				break;
			}
			
			if(maxpque.size()+minpque.size() == insertCnt) {
				//두 큐의 합이 삽입한 개수랑 같으면 큐는 비어있어야함
				while(!maxpque.isEmpty()) {
					maxpque.poll();
					minpque.poll();
				}
				insertCnt = 0;
			}
		}
		
		//4. 사이즈합이  insertions 보다 크면
		if(maxpque.size()+minpque.size() > insertCnt) {
			answer[0] = maxpque.poll();
			answer[1] = minpque.poll();
		}
		
		return answer;
	}

}
