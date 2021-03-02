# Queue

## 조사이유

queue를 쓰던 어느날, java에서는 왜 Queue를 LinkedList로 구현하는지 궁금해졌다.

예전에 deque를 써 본적이있는데 이것 역시 LinkedList로 구현을 했다..

Stack은 stack 그대로 쓰는데... 왜?! 왤까?!왜 new Queue는 안될까?! 왜 전부 LinkedList인걸까?! ArrayList는 안되는건가??!

그래서 조사했다!!!!!!!!

## 조사내용

![img](https://blog.kakaocdn.net/dn/AGpq3/btqI07wkE1A/yX10IjGgt6N3G6rkT1Ievk/img.png)

java API문서를 보면 구조가 이렇다.

Iterable을 구체화한게 Collecitons이고, 이를 구체화한 것이 List, Queue, Set이다.

하지만 Map은 mapping이 collections라 보기 힘들고, collections또한 mapping이라고 보기 힘들어 Collections Interface를 상속하지않는다.(자세한 건 아래 출처를 참조)

## Iterable [Interface]

왜 Collections의 상위에 Iterable이 있을까?

class들은 모두 객체 형태로, 내부구현 또한 대부분 Object[]배열 형태가 아니라 각각의 객체를 갖고 움직인다. 그래서 객체의 데이터를 모두 순회하려면 사용자들의 각각의 데이터 순회 방법을 알거나 데이터를 하나씩 꺼내와야한다.

하지만 Iterable인터페이스를 사용하는 모든 클래스들은 for-each를 이용해 이를 편리하게 할 수있다.

## List [Interface]

List Interface는 대표적인 선형 자료구조로 주로 순서가 있는 데이터를 목록으로 이용할 수 있도록 만들어진 인터페이스다. 

이를 구현한 클래스로는 ArrayList, LinkedList, Vector(+Vector를 상속받은 Stack)이 있다.

## ArrayList [Class]

- Object[] 배열을 사용하면서 내부 구현을 통해 동적으로 관리
- 배열을 생성하여 사용하기 때문에 **요소 접근에는 탁월**
- 중간 요소의 **삽입, 삭제가 일어나는 경우** 그 뒤의 요소들을 한 칸씩 밀거나 당겨야해서 **비효율적**

## LinkedList [Class]

- 데이터와 주소로 이루어진 클래스(Node)를 만들어 서로 연결하는 방식
- **요소를 검색해야할 경우** 처음 노드부터 찾으려는 노드가 나올 떄까지 연결된 노드를 모두 방문해야해서 **비효율적**

- **해당 노드를 삭제, 삽입해야하는 경우** 노드의 링크를 끊거나 연결해주면 되어 **효율적**

## Queue [Interface]

- 순서가 있는 데이터를 기반으로 '선입선출'을 위해 만들어진 인터페이스

- 이를 상속하고 있는 Deque라는 Interface도 있다.

  |       Queue       |       Deque       |
  | :---------------: | :---------------: |
  | 단방향 삽입, 삭제 | 양방향 삽입, 삭제 |

  ![img](https://blog.kakaocdn.net/dn/cfpfoQ/btqI66JL8WF/YgwfZ2O1HRhm67NK3CovEk/img.png)

- Queue / Deque Interface를 구현하는 클래스

  - **LinkedList** -> 사실 상 3가지 용도(List, Deque, Queue)
  - ArrayDeque
  - PriorityQueue

- LinkedList와 ArrayDeque의 차이점?

  - LinkedList와 ArrayList의 차이점과 같다.

## 자료구조 선택 로드맵

![img](https://blog.kakaocdn.net/dn/bIvfpY/btqI7ysSAlg/opwhvycjl6rAYfClVZNeOk/img.png)

#### 출처

https://st-lab.tistory.com/142



----------------------------------------------------

http://hochulshin.com/java-linkedlist/