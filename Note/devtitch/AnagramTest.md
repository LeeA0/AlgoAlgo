## 두 개의 문자열이 서로 치환인지 알아내기 (feat. 애너그램)



> **어구전철**(語句轉綴) 또는 **애너그램**(anagram)은 단어나 문장을 구성하고 있는 문자의 순서를 바꾸어 다른 단어나 문장을 만드는 놀이이다. 
> ex ) 나가 -> 가나, 국왕->왕국
> 		stressed -> desserts



ABC -> ACB, BAC, BCA, CAB, CBA



### 방법 1) 두개의 문자열 sorting하여 비교

```java
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("ABC", "BCA"));
		System.out.println(isAnagram("ABBC", "ADDC"));
	}
	
	private static String sort(String s) {
		//문자열을 정렬하는 함수
		char[] word = s.toCharArray();
		Arrays.sort(word);
		
		return new String(word); //정렬된 배열을 문자열로 반환
	}
	
	private static boolean isAnagram(String source, String target) {
		//두개의 문자열이 서로 치환인지
		if(source.length() != target.length()) return false;
		
		return sort(source).equals(sort(target));
	}
}
```



### 방법 2) 가지고 있는 문자의 종류, 개수 count

문자열이 ASCII 128개로 구성되어있다고 했을 때

```java
import java.util.Arrays;

public class Anagram_2 {

	public static void main(String[] args) {
		System.out.println(isAnagram("ABC", "BCA"));
		System.out.println(isAnagram("ABBC", "ADDC"));
	}
	
	private static boolean isAnagram(String source, String target) {
		//두개의 문자열이 서로 치환인지
		if(source.length() != target.length()) return false;
		
		//길이가 같으면 문자 담을 배열 생성
		int[] ascii = new int[128];
		
		//단어에 포함된 알파벳 개수 count
		for (int i = 0; i < source.length(); i++) {
			ascii[source.charAt(i)]++;
		}
		
		//단어에 포함된 알파벳 개수 빼기
		for (int i = 0; i < target.length(); i++) {
			ascii[target.charAt(i)]--;
			
			//0보다 작아지면(source에 없는 문자일 경우) false
			if(ascii[target.charAt(i)] < 0) return false;
		}
		
		return true;
	}
}
```