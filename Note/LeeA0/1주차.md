# 1주차 (2021.02.23~2021.03.02)

### 2021-02-23

- [BOJ 1049 기타줄](https://www.acmicpc.net/problem/1049) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Math/1049_기타줄/AY_1049_기타줄.java)

  - 처음부터 어렵게 생각해서 시간을 허비했다. (DP)

    -> 너무 어렵게 생각하지말고 문제의 근본을 볼 필요가 있다.

### 2021-02-24

- [BOJ 1057 토너먼트](https://www.acmicpc.net/problem/1057) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Math/1057_토너먼트/AY_1057_토너먼트.java)

  - 홀수인지 체크하지 않고도 +1을 해준 후 나누기 2를 해주면 올림한 값을 얻을 수 있다.

- [BOJ 1002 터렛](https://www.acmicpc.net/problem/1002) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Math/1002_터렛/AY_1002_터렛.java)

  - 위치 개수가 무한대일 때(두 터렛의 위치가 완벽하게 겹치고, 거리가 같을 때) -1을 출력한다는 점을 놓쳤다.

    -> 문제를 꼼꼼히 읽자

### 2021-02-25

- [Programmers 다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/Programmers/Stack&Queue/다리를지나는트럭/AY_다리를지나는트럭.java)

  - 로직을 머리 속으로 세우고 짜려하다보니 잘못 작성한 부분도 있었고, 시간도 더 걸린 것 같다.

    -> 종이에 꼼꼼히 적은 후 코드를 작성하자

  - HashMap을 이용해서(시간을 key, 무게를 value) 작성한 코드도 있었는데 인상깊었다.

### 2021-02-26

- [BOJ 11403 경로찾기](https://www.acmicpc.net/problem/11403) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Floyd-Warshall/11403_경로찾기/AY_11403_경로찾기.java)

  - 플로이드 와샬의 기초문제였음에도 불구하고 플로이드 와샬 알고리즘 자체를 까먹어서 푸는데 어려움이 있었던 것같다.

    -> 매주 반복하자

### 2021-02-27

- [BOJ 1015 수열정렬](https://www.acmicpc.net/problem/1015) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Sort/1015_수열정렬/AY_1015_수열정렬.java)
  - P배열을 만들 때 Priority Queue를 이용해서 정렬할 필요없이 배열의 인덱스를 이용해 직접 넣는 방법이 있었다. 다음에도 비슷한 문제를 접하면 이 방식을 써야겠다.

### 2021-02-28

- [BOJ 1011 Fly me to the Alpha Centauri](https://www.acmicpc.net/problem/1011) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/BOJ/Math/1011_FlymetotheAlphaCentauri/AY_1011_FlymetotheAlphaCentauri.java)
  
- 규칙찾는게 어려운 문제였다. 해결 방법을 찾고서도 어림짐작해서 시간복잡도를 생각한 뒤 안될 것 같다고 뒤로 미뤄두어서 시간이 더욱 지체되었다. 
  
  -> 시간복잡도를 제대로 계산하자
  
  - sqrt의 존재를 잊고 있었다가 다 푼 후 다른 코드를 참고하면서 깨달았다. 반복적으로 사용하면서 기억할 필요가 있겠다고 생각했다.

### 2021-03-01

- [Programmers 주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/Programmers/Stack&Queue/주식가격/AY_주식가격.java)

  - 너무 테스트케이스에만 의존했다. 주어진 테스트 케이스의 경우 1씩 증가하고, 1씩 감소하지만, [2, 2, 1, 2, 2]와 같이 스택에서 한 번에 여러 개가 빠져나가는 경우의 수를 고려하지 못했다.

    -> 제출하기 전 테스트케이스를 잘 생각해보자