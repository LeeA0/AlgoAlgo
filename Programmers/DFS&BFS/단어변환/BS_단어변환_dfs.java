package programmers;

public class Programmers_단어변환_dfs {
	static int answer;
	static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
    	answer = Integer.MAX_VALUE;
        /*
         * begin은 출발단어, target은 목적단어
         */
    	// words 단어길이 만큼을 가지는 방문배열 
        visited = new boolean[words.length];
        letsFix(words, begin, target, 0);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

	private void letsFix(String[] words, String begin, String target, int depth) {
		// 혹시 target 문자열에 도달했다면
		if(begin.equals(target)) {
			// 혹시 도달한 depth가 최소라면 answer 갱신
			if(depth < answer) {
				answer = depth;
			}
			return;
		}
		// depth가 문자열 길이를 넘는다면 
		if(depth > begin.length()) {
			return;
		}
		for (int i = 0; i < words.length; i++) {
			int tmpCnt = 0;
			for (int j = 0; j < begin.length(); j++) {
				if(tmpCnt > 1) break;
				if(begin.charAt(j) != words[i].charAt(j)) {
					tmpCnt++;
				}
			}
			if(tmpCnt == 1) {
				if(visited[i]) continue;
				visited[i] = true;
				letsFix(words, words[i], target, depth+1);
				visited[i] = false;
			}
		}
		 
	}
}
