## **1. \*Stack을 사용하는데 Stack overflow error가 나지않는 사용 범위에 대한 파악이 필요하다 느낌**



#### **1-1. JVM은 각 쓰레드의 각 스택에게 메모리를 할당해준다.** **Stack overflow error는 여기서 사용 가능한 메모리가 더이상 없다는 뜻.**

[출처 : hashcode.co.kr/questions/611/%EC%8A%A4%ED%83%9D-%EC%98%A4%EB%B2%84%ED%94%8C%EB%A1%9C%EC%9A%B0-%EC%97%90%EB%9F%AC%EA%B0%80-%EC%9D%BC%EC%9C%BC%ED%82%A4%EB%8A%94-%EB%AC%B8%EC%A0%9C%EA%B0%80-%EB%AD%94%EA%B0%80%EC%9A%94](https://hashcode.co.kr/questions/611/스택-오버플로우-에러가-일으키는-문제가-뭔가요)

[
스택 오버플로우 에러가 일으키는 문제가 뭔가요?스택오버플로우에러에 대한 정보를 아무리 찾아도 명확한 답이 없어요. 자바 문서를 보면 java.lang.StackOverflowError 에러는 "응용프로그램에서 재귀를 돌때 재귀의 깊이가 너무 깊어져서 스택 오버hashcode.co.kr](https://hashcode.co.kr/questions/611/스택-오버플로우-에러가-일으키는-문제가-뭔가요)

일반적으로 언제 SOF가 발생하는지 알아보기 위해, 간단한 메서드를 통하여 알아보았다.
정말 간단한 메서드도 20398번을 초과하면 SOF가 발생하므로,

알고리즘을 풀때 재귀적으로 메서드를 호출할 때, 여러 복잡한 공간을 사용한다면, 더욱더 한계치가 낮아진다고 생각해야할 것 같다.

```
package basic;

public class StackOverFlowCheck {
	public static void main(String[] args) {
		howDeepCanYouDig(0);
	}
	
	private static void howDeepCanYouDig(int input) {
		// intput이 12500 + 6250 + 1562 + 48 + 24 + 12 + 2 를 초과하게 되면 SOF발생
        if(input == 12500 + 6250 + 1562 + 48 + 24 + 12 + 2) {
			System.out.println("end");
			return;
		}
        
//      FOR문을 추가하니, input이 12500 + 1563 을 초과하게 되면 SOF발생
//		if(input == 12500 + 1563) {
//			System.out.println("end");
//			return;
//		}
//		for (int i = 0; i < 2; i++) {
//			
//		}
		howDeepCanYouDig(input+1);
	}
}
```

#### **1-2. Stack 클래스는 스택 메모리 구조를 표현하기 위해, Vector 클래스의 메소드를 5개만 상속받아 사용한다.**

empty, peek(), pop(), push(),
int search(객체) : 해당 스택에서 전달된 객체가 존재하는 위치의 인덱스를 반환함. 제일 상단의 요소부터 1부터 시작함.

###  **2. \**Queue\**를 사용하는데도 \**공간적으로 어느정도까지 사용할 수 있나\** 알아볼 필요성을 느낌**



## **3. 코드에서는 객체(Stock으로 명명)를 이용하여 주식 정보를 저장하였는데, 배열을 이용한다면 어떤 장점과 손해가 있는지  **

## 4. 객체는 new 객체(인자1, 인자2 ..) 와 같이 생성자를 이용할 수 있는데, 배열도 생성자를 이용할 수 있는지? -> 프로그래머스 전반적으로 디버깅을 진행할 때 배열을 인자값으로 자주 넣어주는데, 직접 넣어주는 방법 



## **5. Math 관련 메서드  **

## **6. BufferedReader 이해하기**

![img](1%EC%A3%BC%EC%B0%A8_note.assets/img.png)


BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

io에 있어서 가장 기본이 되는 System 클래스에서 선언된 **System.in 객체 인스턴스**를
매개변수로 해서 문자인코딩을 처리해주는 **InputStreamReader 객체 인스턴스**를 생성하고
그와 동시에 **Buffer 필터를 씌워주기 위해 인스턴스에 BufferedReader 클래스의 필터기능**
을 덧씌워준 최종 객체 인스턴스 br 객체가 생성되는 것입니다.**
**[출처 : https://empireks.tistory.com/29](https://empireks.tistory.com/29)

## ** 7. Boundary Value Check**