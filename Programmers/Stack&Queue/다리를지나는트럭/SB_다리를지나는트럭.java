package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_�ٸ���������Ʈ�� {
	static class Truck {
		int tWeight;
		int startTime;

		public Truck(int tWeigth, int cnt) {
			this.tWeight = tWeigth;
			this.startTime = cnt;
		}
	}

	public static void main(String[] args) {
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int ans = solution(100, 100, truck_weights);
		System.out.println(ans);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		// que�� ���� ó�� �� Ʈ���� �־��ֱ� ������ 1�ʺ��� ����
		int answer = 1;
		Queue<Truck> bridge = new LinkedList<>(); //���� �ٸ� �������� �ִ� Ʈ����Ȳ que 
		int tIndex = 0; // Ʈ�� �ε���

		bridge.add(new Truck(truck_weights[tIndex], answer)); //ù��° Ʈ���� ���Կ� ���Խð�
		int sum = truck_weights[tIndex]; //���� �ٸ��� Ʈ���� ���� ��
		tIndex++;
		
		while (!bridge.isEmpty()) {
			answer++; // answer�� ��ġ�� �� �Ʒ����� ���� �÷������ ���� �ذ�?!
			
			if (bridge.peek().startTime + bridge_length == answer) {
				// �Ǿ��� Ʈ���� ����������
				sum -= bridge.peek().tWeight; //sum���� ���ְ�
				bridge.poll(); //�ٸ����� Ż��
			}

			if ((tIndex < truck_weights.length) && sum + truck_weights[tIndex] <= weight) {
				// ���ο� Ʈ���� ���͵� ��ƿ �� ������
				bridge.add(new Truck(truck_weights[tIndex], answer)); //�ٸ��� �־��ְ� 
				sum += truck_weights[tIndex]; //�հ� �����ְ�
				tIndex++; //���� Ʈ������ �ε��� ����
			}

		}

		return answer;
	}
}
