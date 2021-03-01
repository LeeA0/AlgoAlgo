package final_algo.programmers;

public class Programmers_주식가격 {
	class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];
			for (int i = 0; i < prices.length; i++) {
				//초기화
				int second = 0;
				//이중 for문 - 앞의 index부터 배열의 끝까지 값을 비교.
				for (int j = i; j < prices.length; j++) {
					second++;
					//만약 현재 비교값과 다음 비교값을 비교했을때 지금의 비교값이 크다면
					if (prices[i] > prices[j]) {
						// 지금까지 카운트 한 second를 같은 index의 answer에 넣어주고 break
						// 배열이라 -1
						answer[i] = second - 1;
						break;
					} else {
						// 현재 비교값이 계속 앞의 값보다 작을 경우 해당 index부터 배열 끝까지 count후 해당 값을 answer에 넣기.
						// 배열이라 -1
						answer[i] = second - 1;
					}
				}
				//초기화
				second = 0;
			}
			return answer;
		}
	}
}
