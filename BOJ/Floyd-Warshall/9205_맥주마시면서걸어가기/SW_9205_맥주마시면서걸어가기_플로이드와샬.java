package final_algo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*Silver 1*/
//15968KB	184ms
public class BOJ_9205_맥주마시면서걸어가기_플로이드와샬 {

	static int T, N;
	static boolean map[][];
	static LinkedList<int[]> point;
	static String emotion;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			point  = new LinkedList<int[]>();
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				point.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			System.out.println(solution());
		}
	}
	static String solution() {
		map = new boolean[N+2][N+2];
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				if(i!=j && getdist(point.get(i), point.get(j))<=1000) map[i][j]= true;
			}
		}
		
		for (int k = 0; k < N+2; k++) {
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}
		
		if(map[0][N+1]) {
			emotion = "happy";
		}else {
			emotion = "sad";
		}
		return emotion;
	}
	
	static int getdist(int[] point1, int []point2) {
		return Math.abs(point1[0]- point2[0]) + Math.abs(point1[1]- point2[1]);
	}
}
