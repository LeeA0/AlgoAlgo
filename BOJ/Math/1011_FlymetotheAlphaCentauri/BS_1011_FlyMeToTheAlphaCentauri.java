package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 공간이동 장치 설명
 * 1. 이동 거리를 급격하게 늘릴 경우 기계에 심각한 결함이 발생.
 * 2. if 이전 광년 == k , 올해는 k-1, k, k+1 만큼 이동 가능
 * 3. 처음 작동 시킬 경우, -1과 0은 의미가 없으므로 1 만큼 이동,
 * 		이후의 시점부터 0,1,2 광년을, 이후 2광년을 선택한다면 1,2,3 광년을 다음으로 선택할 수 있다.
 * 4. 시작과 끝의 이동거리는 1이어야만 한다.
 * 5. 최소한의 작동횟수로 이동. 
 * 
 * T(테스트케이스 개수)
 * 현재위치 x, 목표위치 y
 * 
 * 0 3
 * 1 2 3
 * 1 1 1
 * 3-0 == 3
 * 
 * 1 5
 * 2 4 5
 * 1 2 1
 * 5-1 == 4
 * 
 * 45 50
 * 46 48 49 50
 * 1  2  1  1/
 * 50-45 == 5
 * 
 * 3
 * 1 1 1
 * 
 * 4
 * 1 2 1
 * 
 * 5
 * 1 2 1 1
 * 
 * 6
 * 1 2 2 1
 * 
 * 7
 * 1 2 2 1 1
 * 
 * 8
 * 1 2 2 2 1
 * 
 * 9
 * 1 2 3 2 1
 * 
 * 10
 * 1 2 3 2 1 1
 * 
 * 11
 * 1 2 3 2 2 1
 * 
 * 12
 * 1 2 3 3 2 1
 * 
 * 13
 * 1 2 3 3 2 1 1
 * 
 * 14
 * 1 2 3 3 2 2 1
 * 
 * 15
 * 1 2 3 3 3 2 1
 * 
 * 16
 * 1 2 3 4 3 2 1
 */

public class BOJ_1011_FlyMeToTheAlphaCentauri {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			long tmp = end - start;
//			System.out.println(tmp);
			long cutSmall = (long) Math.floor(Math.sqrt(tmp));
			long original = (long)Math.sqrt(tmp);
//			System.out.println(cutSmall + " " + original);
			if(cutSmall * cutSmall == tmp ) {
				sb.append(cutSmall * 2 - 1).append("\n");
			}else {
				if(tmp <= cutSmall * cutSmall + cutSmall) {
					sb.append(cutSmall * 2).append("\n");
				}else {
					sb.append(cutSmall * 2 + 1).append("\n");
				}
			}
		}
		System.out.println(sb);
		
	}
}