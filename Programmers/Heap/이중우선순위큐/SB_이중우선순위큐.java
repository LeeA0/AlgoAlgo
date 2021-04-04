package com.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_���߿켱����ť {

	public static void main(String[] args) {
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		int[] answer = solution(operations);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
		//1.�ִ� pque, �ּڰ� pque ����
		PriorityQueue<Integer> maxpque = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minpque = new PriorityQueue<>();
		
		//������ �� count
		int insertCnt = 0;
		
		//2. operations ����
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			String operation = st.nextToken(); //I, D
			int num = Integer.parseInt(st.nextToken()); //����
			
			switch (operation) {
			case "I": //����
				maxpque.add(num);
				minpque.add(num);
				insertCnt++;
				break;

			case "D": //����
				//3. �� que size ���� insertion Ƚ������ Ŭ�� �������
				if(maxpque.size()+minpque.size() > insertCnt) {
					if(num == 1) { //�ִ� ����
						maxpque.poll();
					}else if(num == -1) { //�ּڰ� ����
						minpque.poll();
					}
				}
				break;
			}
			
			if(maxpque.size()+minpque.size() == insertCnt) {
				//�� ť�� ���� ������ ������ ������ ť�� ����־����
				while(!maxpque.isEmpty()) {
					maxpque.poll();
					minpque.poll();
				}
				insertCnt = 0;
			}
		}
		
		//4. ����������  insertions ���� ũ��
		if(maxpque.size()+minpque.size() > insertCnt) {
			answer[0] = maxpque.poll();
			answer[1] = minpque.poll();
		}
		
		return answer;
	}

}
