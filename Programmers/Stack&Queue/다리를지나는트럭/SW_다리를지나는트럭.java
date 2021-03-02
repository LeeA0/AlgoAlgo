package final_algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_다리를지나는트럭 {
	class Solution {
		class Truck {
			int weight;
			int time;

			public Truck(int weight, int time) {
				this.weight = weight;
				this.time = time;
			}
		}
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			int time = 0;
			int totalWeight = 0;
			Queue<Truck> bridge = new LinkedList<Truck>();
			Queue<Truck> truckList = new LinkedList<Truck>();
			for (int i = 0; i < truck_weights.length; i++) truckList.offer(new Truck(truck_weights[i], 0));
			while (!bridge.isEmpty() || !truckList.isEmpty()) {
				time++;
				if (!bridge.isEmpty()) {
					if (time - bridge.peek().time >= bridge_length) {
						totalWeight -= bridge.peek().weight;
						bridge.remove();
					}
				}
				if (!truckList.isEmpty()) {
					if (totalWeight + truckList.peek().weight <= weight) {
						Truck truck = truckList.poll();
						totalWeight += truck.weight;
						bridge.offer(new Truck(truck.weight, time));
					}
				}
			}
			return time;
		}
	}
}
