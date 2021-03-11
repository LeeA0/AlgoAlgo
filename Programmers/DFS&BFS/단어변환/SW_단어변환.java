package final_algo.programmers;

public class Programmers_단어변환 {

	static int answer = Integer.MAX_VALUE;

	/**
	 * 문제 solution
	 * @param begin 문제에서 요구하는 첫 단어
	 * @param target 목표하고자 하는 단어
	 * @param words 바꿀 수 있는 단어 리스트
	 * @return
	 */
	public static int solution(String begin, String target, String[] words) {
		boolean flag[] = new boolean[words.length];
		dfs(begin, target, words, flag, 0);
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	/**
	 * 재귀함수
	 * @param begin 최초단어 및 words에서 바껴서 들어오는 단어
	 * @param target 목표 단어
	 * @param words 단어 리스트
	 * @param flag 방문 여부
	 * @param count 횟수 count
	 */
	public static void dfs(String begin, String target, String[] words, boolean[] flag, int count) {
		if (begin.equals(target)) {
			answer = Math.min(answer, count);
		}

		for (int i = 0; i < words.length; i++) {
			if (!flag[i] && check(begin, words[i])) {
				flag[i] = true;
				dfs(words[i], target, words, flag, count + 1);
				flag[i] = false;
			}
		}
	}

	/**
	 * 단어의 차이가 하나만 차이가 나는지 확인
	 * @param begin 비교하고자 하는 단어
	 * @param word words리스트의 해당 index의 단어
	 * @return 단어가 하나만 차이가 난다면 true 아니면 false
	 */
	public static boolean check(String begin, String word) {
		int count = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i))
				count++;
		}
		return count == 1 ? true : false;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

}
