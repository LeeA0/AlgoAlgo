package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_다리를지나는트럭 {
	// 다리에 올라가 있는 트럭의 정보를 저장하는 객체
	static class TruckOnBridge {
		int startTime;
		int weight;

		public TruckOnBridge(int startTime, int weight) {
			this.startTime = startTime;
			this.weight = weight;
		}
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		// 모든 트럭이 다리를 건너는 시간
		int answer = 0;
		// 다리 위 트럭 무게의 합
		int bridgeCapacity = 0;
		// 다리위에 있는 트럭들을 저장할 Queue
		Queue<TruckOnBridge> queue = new LinkedList<TruckOnBridge>();

		// 몇번째 인덱스의 트럭이 다리에 진입할 차례인지 기억하는 변수
		int truckIdx = 0;
		// 몇개의 트럭이 다리를 통과하였는지 기억하는 변수
		int pollCnt = 0;
		// 모든 트럭이 다리를 통과하기 전까지 반복
		while (pollCnt!= truck_weights.length) {
			// 먼저 다리에서 빠져나올 타이밍의 트럭을 추려낸다
			// 1초에 1만큼 움직이므로,
			// answer(현재 경과 시간) - startTime(다리 진입 시간) 이  다리 길이와 같다면 나올 타이밍 
			if(!queue.isEmpty() && answer - queue.peek().startTime == bridge_length) {
				// 다리위 트럭 무게의 합에서 나온 트럭의 무게만큼 빼준다.
				bridgeCapacity -= queue.poll().weight;
				// 빠져나온 트럭 cnt를 증가시킨다.
				pollCnt++;
			}
			
			// 아직 다리를 자나지 않은 트럭이 있으면서,
			// 다리에 트럭이 올라가 있지 않거나, 다음 트럭이 올라가도 다리가 하중을 견딜 수 있다면
			// 트럭을 다리에 올린다.
			if (truckIdx < truck_weights.length && (queue.isEmpty() || (bridgeCapacity + truck_weights[truckIdx] <= weight))) {
				queue.offer(new TruckOnBridge(answer, truck_weights[truckIdx]));
				// 다리 위 트럭 무게의 합에 현재 진입한 트럭의 무게를 더해준다.
				bridgeCapacity += truck_weights[truckIdx++];
			}
			
			// 시간 증가
			answer++;
		}

		return answer;
	}
}
