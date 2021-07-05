# MVVMTest

- 디자인 패턴 : MVVM 

## Android 코딩 규칙

사용 언어 - Kotlin

#### 띄어쓰기 및 코드 정리

- Ctrl + Alt + L + K 를 누르면 Android Studio에서 공백정리 해준다.
- 키워드, 연산자와 다른 코드 사이에 공백이 있어야 한다
- 한 줄에 25자가 넘지 않도록 한다. (한 눈에 보기 쉽게 한다.)
- 접근이 길어질 때는 .앞읖 기준으로 줄을 바꾼다

```kotlin
var a=0 //BAD
var a = 0 //GOOD

~~builder.checker(~~~~~~~~~~~).finish(~~~~~~) //BAD

~~builder
  .checker(~~~~~~~~~~~)
  .finish(~~~~~~) //GOOD
```
#### 명명

- 변수와 함수는 카멜 케이스를 사용
- 클래스나 파일은 파스칼 케이스를 사용한다.
