package final_algo.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Programmers_베스트앨범 {

	static class Solution {
		public static ArrayList<Integer> solution(String[] genres, int[] plays) {
			ArrayList<Integer> bestAlbum = new ArrayList<>();
			HashMap<String, Integer> totalGenreMap = new HashMap<>();

			for (int i = 0; i < genres.length; i++) {
				totalGenreMap.put(genres[i], (totalGenreMap.getOrDefault(genres[i], 0)) + plays[i]);
			}

			// 1. 속한 노래가 많이 재생된 장르를 먼저 수록
			// 각 장르를 list에 넣어서 노래가 많이 재생된 순으로 정렬
			ArrayList<String> sortGenre = new ArrayList<>(totalGenreMap.keySet());
			Collections.sort(sortGenre, (o1, o2) -> totalGenreMap.get(o2).compareTo(totalGenreMap.get(o1)));

			// 2. 장르 내에서 많이 재생된 노래를 먼저 수록
			for (int i = 0; i < sortGenre.size(); i++) {
				int max = Integer.MIN_VALUE;
				int first = 0, second = 0;
				String genreTitle = sortGenre.get(i);
				// genreTitle과 이름이 같은 장르를 가져온다.
				for (int j = 0; j < genres.length; j++) {
					// 가져온 장르들 끼리의 재생횟수를 비교하여 높은 순서대로 bestAlbum에 넣는다.
					if (genres[j].equals(genreTitle)) {
						if (plays[j] > max) {
							max = plays[j];
							first = j;

						}
					}
				}
				max = Integer.MIN_VALUE;
				for (int j = 0; j < genres.length; j++) {
					if (genres[j].equals(genreTitle)) {
						if (first != j && plays[j] > max) {
							max = plays[j];
							second = j;
						}
					}
				}

				bestAlbum.add(first);
				if (max != Integer.MIN_VALUE)
					bestAlbum.add(second);

			}
			return bestAlbum;
		}

		public static void main(String[] args) {
			String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
			int[] plays = new int[] { 500, 600, 150, 800, 2500 };
			System.out.println(solution(genres, plays));
		}
	}
}
