package com.programmers;

public class Programmers_단어변환 {
	static int answer;
	static boolean[] visited;
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		int answer = solution(begin, target, words);
		System.out.println(answer);
	}

	private static int solution(String begin, String target, String[] words) {
		answer = 0;
		visited = new boolean[words.length]; //방문체크
		
		dfs(begin, target, answer, words); //처음에 0으로 시작
		
		return answer;
	}

	private static void dfs(String now, String target, int cnt, String[] words) {
		if(now.equals(target)) { //같아지면
			answer = cnt;
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(!visited[i] && checkDiff(now, words[i])) { //아직방문안했으면서 1개차이이면
				visited[i] = true;
				dfs(words[i], target, cnt+1, words);
				visited[i] = false;
			}
		}
	}

	private static boolean checkDiff(String now, String next) {
		int diffcount = 0;
	
		for (int i = 0; i < now.length(); i++) {
			if(now.charAt(i) != next.charAt(i)) { //다르면
				diffcount++;
			}
		}
        
        //한개만 다르면 true, 아니면 false
		return diffcount==1? true : false;
	}
}


