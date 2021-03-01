package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*Silver 1*/
//12668KB	104ms
public class BOJ_9205_맥주마시면서걸어가기_Queue {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int T, N;
	static Point point[];
	static String emotion;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			point = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			System.out.println(solution());
		}
	}
	static String solution() {
		boolean check = false;
		boolean visited[] = new boolean[N+2];
		Queue<Point> que = new LinkedList<>();
		que.add(point[0]);
		visited[0] = true;
		while(!que.isEmpty()) {
			Point curr = que.poll();
			if (curr.equals(point[N+1])) {
				check = true;
			}
			for (int i = 0; i < N+2; i++) {
				if (!visited[i] && getdist(curr, point[i])<=1000) {
					visited[i] = true;
					que.offer(point[i]);
				}
			}
		}
		if(check) {
			emotion = "happy";
		}else {
			emotion = "sad";
		}
		return emotion;
	}
	
	static int getdist(Point point1, Point point2) {
		return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
	}
}
