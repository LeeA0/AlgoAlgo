### **1. HashMap이란?** 

![img](https://blog.kakaocdn.net/dn/yuxlo/btqZrgqYahQ/mbNvzvf8BjSTFkwruf7sXk/img.png)

HashMap은 Map인터페이스의 해시 테이블 기반으로 구현한다. 



기본 형태는 HashMap은 **<Key, Value>** 형태를 가진다. 



여기서 Key는 이 Map의 중심이 되는 key 유형을 의미하고 Value의 경우 매핑되는 값의 유형을 의미한다.



\- 이 구현은 모든 선택적 작업을 제공하고 null value값과 null key값을 허용한다. 

\- 이 클래스는 순서를 보장하지 않는다.

\- 시간이 지나도 일정하게 유지된다는 보장이 없다.

\- key값을 중복이 불가능하고 value는 중복이 가능하다. value에 null값도 사용 가능하다.

\- **multi thread**에서 동시에 HashMap을 건드려 Key-Value값을 사용하면 문제가 될 수 있다. **multi thread**에서는 HashTable을 쓴다.

\- HashMap 클래스는 HashTable을 동기화 하지 않고 null값을 허용한단 점을 제외하면 거의 동일하다.



------

### **2. 생성자 요약**

![img](https://blog.kakaocdn.net/dn/6dNCD/btqZFtIMhkb/M6POpyjprphgt2UEipxBLK/img.png)

| 생성자                                         | 설명                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| HashMap( )                                     | - HashMap 객체를 생성 ex) HashMap<String , Integer> map = new HashMap<String , Integer>();    Map<String, Integer> map = new HashMap<String, integer>(); |
| HashMap(int initialCapacity)                   | 지정된 값을 초기 용량으로 하는 HashMap객체를 생성한다.       |
| HashMap(int initialCapacity, float loadFactor) | 지정된 값을 초기 용량과 부하 계수의 HashMap객체를 생성한다.  |
| HashMap(Map<? extends K, ? extends V> m        | 지정딘 것과 동일한 매핑을 이용하여 Map을 생성한다.           |

------

### **3. Method 상세보기**

| **size**                                                     |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/br7agc/btqZtzX6SwP/IImcWiYhdb4YsnqD5RRyTk/img.png) |
| 이 map의 key-value 수를 반환한다. return : 이 맵에있는 키-값 매핑의 수 |

| **isEmpty**                                                  |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/rUBEU/btqZBeMnmn3/02uHj9Z7ojcJ6mSOkmytA0/img.png) |
| - HashMap이 비어있는지 확인한다. return : true 이 map에 키-값 매핑이없는 경우 |

| **get**                                                      |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/RLWSn/btqZEBmKLLe/cUHVtkbykwJLDQsJpuJ5Hk/img.png) |
| - 지정된 Key 의 값을 반환한다.  return : 지정된 키가 매핑되는 값 또는 null, 맵에 키에 대한 매핑이없는 경우 |

| **containKey**                                               |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/wjsX7/btqZIAm7uCq/F24ySaovA9ETfwVzoengxk/img.png) |
| - HashMap에 지정된 키(Key)가 포함되어 있는지 알려준다.  return : true 이 Map에 지정된 key에 대한 매핑이 포함되어 있는 경우 |

| **put**                                                      |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/befCXt/btqZBdtdVhK/qXpv3mvsqEOKRNAqOG3bQ1/img.png) |
| - HashMap에 키와 값을 저장. return : 이전 value값에 연결된 key를 저장, null 매핑이 없는 경우 |

| **putAll**                                                   |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/cujjC7/btqZvNPnV8c/sXfbuJNO2Jx8qnDZKP4Qk1/img.png) |
| - Map에 해당하는 모든 요소를 HashMap에 저장한다.  return : NullPointerException - 지정된 Map이 null인 경우 |

| **remove**                                                   |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/tSQmG/btqZyv8JZcH/84ok6P0TWLjPjQzQXN1Gk0/img.png) |
| - HashMap에서 지정된 키로 지정된 값을 제거한다.              |

| **clear**                                                    |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/mL5yV/btqZyuB0CHj/AUmJkQ9ZvhPWryRfyc3C5K/img.png) |
| - HashMap에 저장된 모든 객체를 제거한다.                     |

| **containValue**                                             |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/wcKEx/btqZBeyS13j/XCq13Vvu9WhfWBlv5nmKt1/img.png) |
| - HashMap에 지정된 값(Value)가 포함되어 있는지 알려준다.     |

| **keySet**                                                   |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/bhk5NZ/btqZIyW8g8F/jzR3t7GhVQhPsNtosxTAl0/img.png) |
| - HashMap에 저장된 모든 키가 저장된 Set을 반환한다.  ex) map.put("A", 1);   map.put("B", 2);   map.put("C", 3);   Set keyset = map.keySet();   System.out.println("Key set values are" + keyset);   (result) Key set values are [A,B,C] |

| **values**                                                   |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/dAwY8x/btqZFtWnqiP/BoKVr5PUTYkBduyscS8iZ1/img.png) |
| - HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다.         |

| **entrySet**                                                 |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/btejnW/btqZEBAjru1/n6FgeKKEQEverOQfbJZBt1/img.png) |
| - HashMap에 저장된 Key - Value갑슬 엔트리(키와 값을 결합)의 형태로 Set에 저장하여 반환 ex) map.put("A", 1);   map.put("B", 2);   map.put("C", 3);   Set set = map.entrySet();   System.out.println("set values are" + set);   (result) set values : [A=1,B=2,C=3] |

| **computeIfAbsent**                                          |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/SDQZ2/btqZGmCEeNo/t0Me9yTR2on7yLilSfW1y0/img.png) |
| 지정된 키가 아직 값과 연결되지 않았거나에 매핑 null되지 않은 경우 지정된 매핑 함수를 사용하여 해당 값을 compute하고 이map에 null을 입력합니다 . |

| **computeIfPresent**                                         |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/bnCPd9/btqZFtWnuc7/UDeWrgHZT1JWDOL93nR1k1/img.png) |
| 지정된 키의 값이 있고 null이 아닌 경우 키와 현재 매핑 된 값이 주어지면 새 매핑을 compute합니다. |

| **compute**                                                  |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/bkJ5NM/btqZBdtdWQj/JbXk15wovq1tLmMWv0B42K/img.png) |
| 지정된 키 및 현재 매핑 된 값 (또는 null현재 매핑이없는 경우)에 대한 매핑 compute을 시도합니다 . |

| **merge**                                                    |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/DJQ9P/btqZvNBNDqf/1fdNole9Kwrf0UXWa5Ete0/img.png) |
| 지정된 키가 아직 값과 연결되어 있지 않거나 null과 연결되어있는 경우 해당 키를 지정된 null이 아닌 값과 연결 |

| **clone**                                                    |
| ------------------------------------------------------------ |
| ![img](https://blog.kakaocdn.net/dn/Pxm9I/btqZtzKxuUu/4wEk1NlbtpZpLP6XHNKbtK/img.png) |
| 이 HashMap인스턴스 의 얕은 복사본을 반환 합니다. 키와 값 자체는 복제되지 않습니다. |



------

### **참고**

[ [Java] HashMap 함수 제대로 알고 사용하기](https://vaert.tistory.com/107)