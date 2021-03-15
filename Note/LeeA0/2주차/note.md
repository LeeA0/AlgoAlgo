# JAVA Stream(프로그래머스 문제 한정)

## 조사이유

프로그래머스에서 hash관련 문제를 풀다보면 다른사람 코드에서 항상 나오는 것이있다.

그것은 바로 'stream'!!

jpa를 이용해서 개발을 할 때에도 자주 보이던 그 stream..

알면 엄청 편리할 것같은데 모르니까 눈에 밟히기만 하던 그 stream에 대해 조사해보았다..!

## 조사 내용

### Stream이란??

- 간단하게 말하면, 데이터의 흐름
- 배열 또는 Collection에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있게 해주는 것

- 람다를 이용해 코드의 양을 줄이고 간결하게 표현할 수 있음
- 병렬처리가 가능

### 코드 분석

stream을 전부 조사하기에는 양이 방대하여 해당 코드를 토대로 분석해보겠습니다

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public class Music implements Comparable<Music>{

    private int played;
    private int id;
    private String genre;

    public Music(String genre, int played, int id) {
      this.genre = genre; 
      this.played = played;
      this.id = id;
    }

    @Override
    public int compareTo(Music other) {
      if(this.played == other.played) return this.id - other.id;
      return other.played - this.played;
    }

    public String getGenre() {return genre;}
  }

  public int[] solution(String[] genres, int[] plays) {
    return IntStream.range(0, genres.length) 				// -- 1
    .mapToObj(i -> new Music(genres[i], plays[i], i))		// -- 2
    .collect(Collectors.groupingBy(Music::getGenre))		// -- 3
    .entrySet().stream()									// -- 4
    .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))// -- 5
    .flatMap(x->x.getValue().stream().sorted().limit(2))	// -- 6
    .mapToInt(x->x.id).toArray();							// -- 7
  }

  private int sum(List<Music> value) {
    int answer = 0;
    for (Music music : value) {
      answer+=music.played;
    }
    return answer;
  }
}
```

#### 1. `IntStream.range(0, genres.length) `

- 기본타입형 Stream

  - 제네릭을 사용하지 않고 직접적으로 해당 타입을 다룰 수 있는 스트림
  - IntStream, LongStream, DoubleStream이 있다.

- range vs rangeClosed

  - 0~n까지 해당 범위의 숫자를 발생 

  - range: 두 번째 인자인 종료 지점을 포함하지 않음

  - rangeClosed: 두 번째 인자인 종료 지점을 포함

  - 예시

    ```java
    IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
    LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
    ```

=> 0부터 (장르의 길이-1)까지의 숫자를 연속적으로 생성

#### 2. `.mapToObj(i -> new Music(genres[i], plays[i], i))`

- mapToObj
  - Stream 내 요소들을 하나씩 특정값으로 변환, 이때 값을 변환하기 위한 람다를 인자로 받음

=> 앞서 생성한 숫자들을 인덱스로 music객체 Stream으로 변환

#### 3. `.collect(Collectors.groupingBy(Music::getGenre))`

- Collectors.groupingBy()

  - 특정 조건으로 요소들을 그룹

  - 예시

    ```java
    // 같은 수량인 Product를 그룹으로 묶음
    Map<Integer, List<Product>> collectorMapOfLists =
     productList.stream()
      .collect(Collectors.groupingBy(Product::getAmount));
    //////////결과//////////
    {23=[Product{amount=23, name='potatoes'}, 
         Product{amount=23, name='bread'}], 
     13=[Product{amount=13, name='lemon'}, 
         Product{amount=13, name='sugar'}], 
     14=[Product{amount=14, name='orange'}]}
    ```

=> 장르가 같은 Music을 그룹으로 묶음 (Map타입으로 반환)

#### 4. `.entrySet().stream()`

- entrySet()
  - Set형태로 반환
  - map에서 key와 value의 값이 모두 필요한 경우 사용

=> key(장르)와 value(Music객체)의 값을 스트림 형태로 변환

#### 5. ` .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))`

a, b는 장르라는 키를 가지고, Music리스트를 값으로 가진 map

=> 장르의 총 음원 재생량이 큰 순으로 정렬

#### 6. `.flatMap(x->x.getValue().stream().sorted().limit(2))`

- flatMap()

  - 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어주는 역할

  - 새로운 스트림을 생성해서 리턴하는 람다를 인자로 받음

  - 예시

    ```java
    List<List<String>> list = 
      Arrays.asList(Arrays.asList("a"), 
                    Arrays.asList("b"));
    // [[a], [b]]
    
    /////// flatMap()을 사용 ///////
    List<String> flatList = 
      list.stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toList());
    // [a, b]
    ```

=> 장르라는 키를 가진 map의 값인 Music list를 Stream으로 만들고 해당 객체의 compareTo함수에 맞게 정렬한 후 상위 2개만 자름

#### 7. `.mapToInt(x->x.id).toArray();`

=> 해당 객체의 id값을 뽑아서 배열로 변경

### 출처

- [JavaStream 총정리](https://futurecreator.github.io/2018/08/26/java-8-streams/)