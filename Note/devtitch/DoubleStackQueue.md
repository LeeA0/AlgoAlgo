## Stack으로 Queue 구현하기



>  Stack으로 Queue를 구현하기 위해서는 Stack이 **2개** 필요함

>  add(), peek(), poll() 함수화 하여 구현



#### Why?

스택에서 pop 연산은 원소 재정렬이 필요하지 않기 때문에 pop 과정에서 수행속도의 이점
--> 배열로 Queue 자료구조를 구현했을 때 속도적 이점 기대
     큐가 메모리 접근 시간이 느린 반면 더블 스택으로 구현하면 빠르다고 함
그러나 Java에서는 Queue를 LinkedList로 구현하기 때문에 수행속도적 이점보다는 공간복잡성이 줄어드는 이점
--> 메모리 접근시간 단축




- Stack 1 : add() 할 때만 사용 
- Stack 2 : peek(), poll() 할 때 사용



1. Add() (Enque)

   : Stack 1 에다가 넣음

![image-20210302202101598](https://user-images.githubusercontent.com/72197311/109657114-7a35cb00-7ba8-11eb-8505-7b577e3f6a42.png)



2. Poll() (Deque)

   1) Stack 2가 비어있는지 체크 후 

   ​	2-1) 비어 있으면 Stack1의 모든 원소를 2로 옮기고 pop 한다

   ​	2-2) 비어 있지 않으면 Stack 2에서 pop한다.

   

![image-20210302202519317](https://user-images.githubusercontent.com/72197311/109657154-86218d00-7ba8-11eb-8172-de4e988ff0b4.png)



3. Size() 
   : 두 스택의 size의 합을 return



``` java
import java.util.Stack;

public class Queue<T> {
  Stack<T> stack1 = new Stack<>();
  Stack<T> stack2 = new Stack<>();

  private void moveIfAbsent() {
    if (stack2.size() == 0)
      while (stack1.size() != 0)
        stack2.add(stack1.pop());
  }

  public void add(T t) {
    stack1.add(t);
  }

  public T peek() {
    moveIfAbsent();
    return stack2.peek();
  }

  public T poll() {
    moveIfAbsent();
    return stack2.pop();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }
```



[관련 영상](https://www.youtube.com/watch?v=t45d7CgDaDM)

