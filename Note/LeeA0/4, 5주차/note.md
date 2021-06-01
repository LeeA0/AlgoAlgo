# GCD(최대공약수 구하기)

## 유클리드 호제법

- 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다. 

- 예시) 

  ![\left(1071,1029\right)=\left(1029,42\right)=\left(42,21\right)=\left(21,0\right)=21](https://wikimedia.org/api/rest_v1/media/math/render/svg/28a78ff05151f0e27020eab4713cbe6878d8ed65)

  

## While문을 이용한 방법

```java
// 숫자가 큰 게 large, 작은게 small
public long getGCD(long large, long small){
    while(small>0){
        long temp = large;
        large = small;
        small = temp%small;
    }

    return small;
}
```

- 시간복잡도 : O(n)

## 재귀를 이용한 방법

```java
// 숫자가 큰 게 large, 작은게 small
public long getGCD(long large, long small){
    if(large%small==0){
        return small;
    }

    return getGCD(small,large%small);
}
```

- 시간복잡도 : O(log N)

## BigInteger를 이용한 방법

```java
// 숫자 크기 상관 없음
public long getGCD(long v1, long v2){
	return BigInteger.valueOf(v1).gcd(BigInteger.valueOf(v2)).longValue();
}
```

### BigInteger

- 자바에서 사용하는 무한대 정수

- 문자열을 이용해서 만들 수 있다.

  ```java
   BigInteger a = new BigInteger("9223372036854775807");
  ```

- +, -, *, /, += 와 같은 연산자를 지원하지 않는다.

  - 대신 메소드를 지원한다.

    ```java
    int a = 100;
    int b = 10;
    BigInteger c;
    
    // BigInteger.valueOf(a) : int형인 a를 BigInteger로 변형
    
    // 더하기, c = 110
    c =  BigInteger.valueOf(a).add(BigInteger.valueOf(b)); 
    // 빼기, c = 90
    c =  BigInteger.valueOf(a).subtract(BigInteger.valueOf(b)); 
    // 곱하기, c = 1000
    c =  BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)); 
    // 나누기, c = 10
    c =  BigInteger.valueOf(a).divide(BigInteger.valueOf(b)); 
    
    ```

[참고] BigInteger 문서 :

 https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html