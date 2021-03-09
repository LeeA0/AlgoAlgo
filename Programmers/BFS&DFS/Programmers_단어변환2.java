package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_단어변환2 {
	static int answer;
	static boolean[] visited;
    static class WordDepth{
    	String word;
    	int depth;
    	public WordDepth(String word, int depth) {
    		this.word = word;
    		this.depth = depth;
    	}
    }
	public int solution(String begin, String target, String[] words) {
    	answer = Integer.MAX_VALUE;
    	
    	boolean[] visited = new boolean[words.length];
    	
    	Queue<WordDepth> que = new LinkedList<>();
    	que.offer(new WordDepth(begin, 1));
    	
    	a:while(!que.isEmpty()) {
    		WordDepth wd = que.poll();
    		for (int i = 0; i < words.length; i++) {
    			int tmpCnt = 0;
				for (int j = 0; j < wd.word.length(); j++) {
					if(tmpCnt > 1) break;
					if(wd.word.charAt(j) != words[i].charAt(j)) {
						tmpCnt++;
					}
				}
				if(tmpCnt == 1) {
					if(visited[i]) continue;
					visited[i] = true;
					if(words[i].equals(target)) {
						answer = wd.depth;
						break a;
					}
					que.offer(new WordDepth(words[i], wd.depth+1));
				}
			}
    		
    	}
    	
    	if(answer == Integer.MAX_VALUE) answer = 0;
    	
    	return answer;
    }
}
