package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC  = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
//			int smX = 0;
//			int smY = 0;
//			int bigX = 0;
//			int bigY = 0;
			int smR = 0;
			int bigR = 0;
			
			if(r1 < r2) {
//				smX = x1;
//				smY = y1;
//				bigX = x2;
//				bigY = y2;
				smR = r1;
				bigR = r2;
			}else {
//				smX = x2;
//				smY = y2;
//				bigX = x1;
//				bigY = y1;
				smR = r2;
				bigR = r1;
				
			}
			double centerDistance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1 - y2), 2));
			// 중심점이 같을 때
			if(centerDistance == 0) {
				// 반지름 길이도 같다면
				if(r1 == r2) {
//					System.out.println(-1);
					sb.append(-1);
				// 반지름 길이가 다르다면
				}else {
//					System.out.println(0);
					sb.append(0);
				}
			// 중심점이 다를 때
			}else {
				if(bigR < centerDistance + smR && bigR > centerDistance - smR) {
//					System.out.println(2);
					sb.append(2);
				}else if(bigR == centerDistance + smR || bigR == centerDistance - smR) {
//					System.out.println(1);
					sb.append(1);
				}else {
//					System.out.println(0);
					sb.append(0);
				}
			}
			sb.append("\n");
//			// 중심점사이의 거리가 반지름의 합보다 클때
//			if((r1 + r2) < Math.sqrt(Math.pow(xDistance,2) +  Math.pow(yDistance, 2))) {
//				System.out.println(0);
//			// 중심점사이의 거리가 반지름의 합과 같을때
//			}else if(Math.sqrt(Math.pow(xDistance,2) +  Math.pow(yDistance, 2)) == (r1+r2)) {
//				System.out.println(
//			// 중심점사이의 거리가 반지름의 합과 같을때
//			}else {
//				System.out.println(-1);
//			}
		}
		System.out.print(sb);
	}
}
