package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_단어변환_bfs {
	static int answer;
	static boolean[] visited;
	// 단어와, 얼마만큼 파고 들었는지 확인하는 배열
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
    	// words 방문 배열 생성, 물론 길이는 words의 length 만큼
    	boolean[] visited = new boolean[words.length];
    	// words 탐색할 노트를 저장하는 que 생성
    	Queue<WordDepth> que = new LinkedList<>();
    	que.offer(new WordDepth(begin, 1));
    	// que가 비지 않는 경우 반복
    	a:while(!que.isEmpty()) {
    		// 탐색을 진행할 노트 꺼내기
    		WordDepth wd = que.poll();
    		// words의 길이만큼 탐색해서 하나만 다른 것 찾기
    		for (int i = 0; i < words.length; i++) {
    			// 지금 보고 있는 문자열이 몇 글자가 다른지 확인하기 위한 변수
    			int tmpCnt = 0;
    			// 비교대상 문자열과 words의 해당 요소를 char단위로 비교
				for (int j = 0; j < wd.word.length(); j++) {
					// 혹시 두글자 이상 차이나면 연결고리가 무의미해지므로 break
					if(tmpCnt > 1) break;
					// 다른 문자를 찾는다면 tmpCnt 증가
					if(wd.word.charAt(j) != words[i].charAt(j)) {
						tmpCnt++;
					}
				}
				// 혹시 하나만 다르다면
				if(tmpCnt == 1) {
					// 이미 방문했다면 스킵
					if(visited[i]) continue;
					// 방문처리
					visited[i] = true;
					// 혹시 비교대상문자열과 target이 일치하는 순간이라면 최단 거리로 찾은것 이므로,
					// 해당 타이밍의 depth를 answer에 저장한다.
					if(words[i].equals(target)) {
						answer = wd.depth;
						break a;
					}
					// 아직 target에 도달하지 못했다면, 깊이를 1 늘리고, 1차이나는 배열과 비교하기위해 노드를 추가한다.
					que.offer(new WordDepth(words[i], wd.depth+1));
				}
			}
    		
    	}
    	// 혹시 answer가 전혀 변하지 않았다면(begin이 target까지 가는것에 실패했다면) 0 출력
    	if(answer == Integer.MAX_VALUE) answer = 0;
    	
    	return answer;
    }
}
