# 3주차 (2021.03.09~2021.03.15)

### 2021-03-09

- [Programmers_단어변환](https://programmers.co.kr/learn/courses/30/lessons/43163) 

  - BFS - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/Programmers/DFS&BFS/단어변환/AY_단어변환_using_bfs.java)

    - 초기에 방문 체크때문에 고민을 많이했는데, 먼저 도착하는 것이 최단 경로라는 것을 깨닫고 이를 적용하였다.

  - DFS - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/Programmers/DFS&BFS/단어변환/AY_단어변환_using_dfs.java)

    - bfs로직을 가지고 dfs로 변경하려다보니 생각보다 더욱 많이 꼬였다. 차라리 처음부터 다시 짜는게 더 빨랐을 것 같다.

    - 백준에서는 잘만쓰던 전역변수를 프로그래머스에서 쓰려니 어색했고, 이로 인해 변수 초기값 실수가 있었다.

      -> 더욱 집중하자..!

### 2021-03-10

- [Programmers_여행경로](https://programmers.co.kr/learn/courses/30/lessons/43164) - [📄이동](https://github.com/LeeA0/AlgoAlgo/blob/main/Programmers/DFS&BFS/여행경로/AY_여행경로.java)

  - 집중을 잘 못해서, 방문처리를 해야한다고 생각해놓고 방문처리를 안해줘서 틀렸고, 그 다음은 true로 반환한하고 false로 반환하는 어처구니없는 실수를 했다.

    -> 생각했던 로직을 꼼꼼히 적어두고 로직대로 짜면 이런 실수가 일어나지않을 것같다.