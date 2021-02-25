package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_다리를지나는트럭 {
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
		// que에 먼저 처음 들어갈 트럭을 넣어주기 때문에 1초부터 시작
		int answer = 1;
		Queue<Truck> bridge = new LinkedList<>(); //현재 다리 지나가고 있는 트럭현황 que 
		int tIndex = 0; // 트럭 인덱스

		bridge.add(new Truck(truck_weights[tIndex], answer)); //첫번째 트럭의 무게와 진입시간
		int sum = truck_weights[tIndex]; //현재 다리위 트럭의 무게 합
		tIndex++;
		
		while (!bridge.isEmpty()) {
			answer++; // answer의 위치를 맨 아래에서 위로 올려줬더니 시초 해결?!
			
			if (bridge.peek().startTime + bridge_length == answer) {
				// 맨앞의 트럭이 도착했으면
				sum -= bridge.peek().tWeight; //sum에서 빼주고
				bridge.poll(); //다리에서 탈출
			}

			if ((tIndex < truck_weights.length) && sum + truck_weights[tIndex] <= weight) {
				// 새로운 트럭이 들어와도 버틸 수 있으면
				bridge.add(new Truck(truck_weights[tIndex], answer)); //다리에 넣어주고 
				sum += truck_weights[tIndex]; //합계 더해주고
				tIndex++; //다음 트럭으로 인덱스 증가
			}

		}

		return answer;
	}
}
