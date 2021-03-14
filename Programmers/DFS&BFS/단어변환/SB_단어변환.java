package com.programmers;

public class Programmers_�ܾȯ {
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
		visited = new boolean[words.length]; //�湮üũ
		
		dfs(begin, target, answer, words); //ó���� 0���� ����
		
		return answer;
	}

	private static void dfs(String now, String target, int cnt, String[] words) {
		if(now.equals(target)) { //��������
			answer = cnt;
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(!visited[i] && checkDiff(now, words[i])) { //�����湮�������鼭 1�������̸�
				visited[i] = true;
				dfs(words[i], target, cnt+1, words);
				visited[i] = false;
			}
		}
	}

	private static boolean checkDiff(String now, String next) {
		int diffcount = 0;
	
		for (int i = 0; i < now.length(); i++) {
			if(now.charAt(i) != next.charAt(i)) { //�ٸ���
				diffcount++;
			}
		}
        
        //�Ѱ��� �ٸ��� true, �ƴϸ� false
		return diffcount==1? true : false;
	}
}


