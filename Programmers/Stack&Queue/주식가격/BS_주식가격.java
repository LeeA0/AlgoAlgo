package programmers;

import java.util.Stack;

public class Programmers_주식가격 {
	// 해당 주식의 가격과 시간을 객체로 표현
	static class Stock {
		int time;
		int price;

		public Stock(int time, int price) {
			this.time = time;
			this.price = price;
		}
	}

	public int[] solution(int[] prices) {
		// 0초부터 입력되어야할거같다
		int[] answer = new int[prices.length];
		Stack<Stock> stack = new Stack<>();
		int nowTime = 0;
		for (int i = 0; i < prices.length - 1; ++i) {
			// 현재 주식 가격이 stack 최상단에 있는 주식의 가격보다 적을때까지 pop 실행
			// 단, stack이 비어있는 경우 종료,
			// pop이 진행될 경우, answer배열에 nowTime(현재시간)에서 pop한 객체의 시간을 뺀 값을 넣어준다.(유지시간) 
			while (!stack.isEmpty() && stack.peek().price > prices[i]) {
				int poppedStockTime = stack.pop().time;
				answer[poppedStockTime] = nowTime - poppedStockTime;
			}
			// stack이 비어있거나, stack의 최상단의 가격이 현재 들어온 주식보다 작거나 같아졌다면
			// 현재 주식을 stack에 넣는다. (넣은 시간은 nowTime을 넣어준다)
			stack.push(new Stock(nowTime, prices[i]));
			// nowTime 증가.
			nowTime++;
		}
		// 마지막 주식은 값을 유지하지 않기에 0을 넣어준다.
		answer[prices.length-1] = 0;
		// 값을 계속 유지하고 있던 나머지 주식 객체들에 대해 (현재시간 - 주식입력시간)을 해줌으로서
		// 값이 얼마나 유지되었는지 기록한다
		while(!stack.isEmpty()) {
			int poppedStockTime = stack.pop().time;
			answer[poppedStockTime] = nowTime - poppedStockTime;
		}
		return answer;
	}
}
