package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_여행경로_dfs_linkedlist_second {
    static boolean[] visited;
   static LinkedList<AirportWithIdx> travelList;
   static LinkedList<AirportWithIdx> answerList;
	public static String[] solution(String[][] tickets) {
       String[] answer = new String[tickets.length + 1];
       visited = new boolean[tickets.length];
       travelList = new LinkedList<AirportWithIdx>();
       answerList = new LinkedList<AirportWithIdx>();
       
       letsTravel(tickets, "ICN");
       answer[0] = "ICN";
       for (int i = 1; i < answer.length; i++) {
       	answer[i] = answerList.get(i-1).Airport;
		}
       return answer;
   }
	static class AirportWithIdx implements Comparable<AirportWithIdx>{
		String Airport;
		int idx;
		public AirportWithIdx(String Airport, int idx) {
			this.Airport = Airport;
			this.idx = idx;
		}
		@Override
		public int compareTo(AirportWithIdx o) {
			return this.Airport.compareTo(o.Airport);
		}
	}
	private static void letsTravel(String[][] tickets, String departure) {
		// 혹시 모든 곳을 여행했다면,
		if(travelList.size() == tickets.length) {

			for (int i = 0; i < travelList.size(); i++) {
				answerList.add(travelList.get(i));
			}
			return;
		}
		PriorityQueue<AirportWithIdx> que = new PriorityQueue<AirportWithIdx>();
		for (int i = 0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(departure)) {
				que.add(new AirportWithIdx(tickets[i][1], i));
			}
		}
		while(!que.isEmpty()) {
			AirportWithIdx tmp = que.poll();
			visited[tmp.idx] = true;
			travelList.add(tmp);
			letsTravel(tickets, tmp.Airport);
			visited[tmp.idx] = false;
           travelList.remove(travelList.size()-1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] answer = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			answer[i][0] = st.nextToken();
			answer[i][1] = st.nextToken();
		}
		String[] tmp = solution(answer);
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i] + " ");
		}
	}
}
