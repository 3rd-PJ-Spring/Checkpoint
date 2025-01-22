## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐻‍❄️ThoI-i's footprint</b></summary>
<details>
		<summary><b>ㅤ25/01/23/목:</b></summary>	
		ㅤㅤㅤ내용
</details>
<details>
		<summary><b>ㅤ25/01/22/수:</b></summary>	
		ㅤㅤㅤ내용
</details>
<details>
		<summary><b>ㅤ25/01/21/화:</b></summary>	
		ㅤㅤㅤ내용
</details>
<details>
		<summary><b>ㅤ25/01/20/월:</b></summary>	
		ㅤㅤㅤ내용
</details>
<details>
		<summary><b>ㅤ25/01/17/금: GitHub 브랜치 로컬에서 삭제 방법</b></summary>	
		ㅤㅤㅤ<h3>GitHub 브랜치 로컬에서 삭제 방법</h3>

<b>1. 로컬의 GitHub 브랜치 이력이 남은 경우(GitHub에 없는 로컬 브랜치 삭제) + fetch O</b><br>
`git fetch --prune`<br>
<b>2. 로컬의 GitHub 브랜치 이력이 남은 경우(GitHub에 없는 로컬 브랜치 삭제) + fetch X</b><br>
`git remote prune origin`<br>
<b>3. 로컬의 특정 원격 브랜치만 삭제가 필요한 경우</b><br>
`git branch -dr origin/<브랜치명>`<br>

</details>
<details>
		<summary><b>ㅤ25/01/16/목:⭐⭐ 대상의 추상화: 제네릭 타입 파라미터＜T＞ 와일드카드＜?＞[상한/하한 제한 + Class 타입 변수와 클래스 객체] | Iterator와 for-each</b></summary>

| **구분**                  | **제네릭 타입 파라미터 `<T>`**                     | **와일드카드 `<?>`**                            |
|--------------------------|--------------------------------------------------|-----------------------------------------------|
| **주된 목적**             | 새로운 타입 매개변수 선언<br>(메서드나 클래스에서 타입을 정의) | 이미 정의된 타입을 느슨하게 받아들임                 |
| **쓰기 작업**             | 타입 매개변수에 따라 추가 가능                           | 쓰기 작업은 불가능<br>(컴파일러가 타입을 알 수 없기 때문) |
| **읽기 작업**             | 타입 매개변수를 통해 읽을 수 있음                        | `Object`로 업 캐스팅되어 읽기 가능                  |
| **읽기 작업만 필요할 때**   | 가능하지만 불필요하게 복잡할 수 있음                      | 적합: 단순하고 직관적인 코드 작성 가능                |
| **타입 범위 제한 (`extends`, `super`)** | 직접 작성해야 함                                   | 상/하한 제한<br>(`? extends T`, `? super T`)로 타입 제어 가능 |
| **특정 타입이 명확히 정해져 있을 때** | 적합: 타입을 명확히 선언하고, 쓰기/읽기 작업 모두 가능        | 부적합: 타입이 불명확해 쓰기 작업에 제한됨              |
| **타입이 다양한 리스트를 처리할 때**   | 부적합: 매번 타입을 선언해야 함                          | 적합: 타입에 관계없이 읽기 작업만 수행 가능             |

<h3>상한 제한(Upper Bound Wildcard) (? extends T) : T와 T의 하위 클래스만 허용</h3>

<b>이 메서드는 `Number`와 그 하위 타입(`List<Integer>`,`List<Double>`)만 받을 수 있음</b>

```java
public void printNumbers(List<? extends Number> numbers) { // ?는 Number이다
    for (Number num : numbers) {
        System.out.println(num);
    }
}
```
<h3>하한 제한(Lower Bound Wildcard) (? super T) : T와 T 의 상위 클래스만 허용</h3>

<b>이 메서드는 `Integer`와 그 상위 타입(`List<Number>`, `List<Object>`)만 받을 수 있음</b>

```java
public void addNumbers(List<? super Integer> list) { // Interger의 부모는 ?이다. 
    list.add(42);
    list.add(99);
}
```
<h3>상한 제한 / 하한 제한</h3>

| **구분**              | **상한 제한 (`? extends T`)**   | **하한 제한 (`? super T`)**                    |
|----------------------|-----------------------------|--------------------------------------------|
| **허용 범위**          | `T`와 `T`의 하위 클래스만 허용        | `T`와 `T`의 상위 클래스만 허용                       |
| **주요 사용 사례**      | **읽기 전용**으로 처리 시            | **쓰기 작업** 중심으로 처리 시                        |
| **읽기 작업**          | 가능: 타입 안정성을 유지하며 읽기 가능      | 제한적: 항상 `Object` 타입으로 반환 → 다운 캐스팅으로 필요타입 축출 |
| **쓰기 작업**          | 불가능: 삽입 작업은 허용되지 않음         | 가능: 타입 안정성을 유지하며 데이터 추가 가능                 |
| **사용 가능한 키워드**   | `? extends T` (T와 그 하위 클래스) | `? super T` (T와 그 상위 클래스)                  |

```java
public void printSpecificType(List<? extends Number> list, Class<?> type) { 
// List<? extends Number> list : 상한 제한 와일드카드가 사용된 리스트
// Class<?> type : 클래스 객체 변수 ex) Integer.class
    for (Number num : list) { // iter 반복문
        if (type.isInstance(num)) { // 클래스 객체가 일치하면
            System.out.println("Filtered: " + num); // 출력해라
        }
    }
}

List<Number> numbers = List.of(1, 2.5, 3, 4.2);
printSpecificType(numbers, Integer.class);
```
```java
// 출력 결과
Filtered: 1
Filtered: 3
```
<h3>Class<?> 타입 변수와 클레스 객체</h3>

| **구분**              | **설명**                                                                                      | **추가 설명**                                                                                                     |
|-----------------------|----------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| **Class<?> 타입 변수** | 클래스 객체를 저장하는 변수 타입.                                                             | - `Class<?>` 타입은 클래스 객체를 다루기 위한 Java에서 제공하는 기본 클래스.<br>- 특정 클래스의 메타데이터를 저장. |
| **클래스 객체**        | 특정 클래스의 정보를 담고 있는 Java 객체.                                                      | - 클래스 객체는 `Class` 클래스의 인스턴스.<br>- 클래스 이름, 메서드, 필드, 상속 계층, 인터페이스 구현 정보 등 포함.|
| **주요 기능**          | 클래스 정보를 동적으로 분석하거나 실행 시에 타입 확인 및 작업 수행 가능.                                      | - 리플렉션 API를 통해 클래스 구조에 대한 상세 작업 가능.<br>- 부모 클래스 및 인터페이스 구현 정보도 확인 가능.   |
| **사용 예시**          | `Class<?> clazz = Integer.class;` → Integer 클래스의 클래스 객체 저장.                          | - 메서드 호출: `clazz.getName()`, `clazz.getSuperclass()`, `clazz.getInterfaces()`.<br>- 객체 타입 비교: `clazz.isInstance(obj)`.|

<h3>⭐️클래스 메서드와 인스턴스 메서드 비교</h3>

| **종류**       | **메서드**              | **설명**                                                        | **예시**                        | **예시 설명**                                                                                  |
|----------------|----------------------|------------------------------------------------------------------|---------------------------------|-----------------------------------------------------------------------------------------------|
| **클래스 메서드** | **`.class`**         | 특정 래퍼 클래스를 `클래스 객체(Class Object)`로 변환             | `Integer.class`                | `Integer` 클래스의 클래스 객체 생성                                                            |
| **인스턴스 메서드** | **`.isInstance`**    | 클래스 객체끼리 비교하여 해당 객체가 지정된 클래스의 인스턴스인지 판별 | `Integer.class.isInstance(obj)` | `obj`가 `Integer` 클래스의 인스턴스인지 `true/false`로 반환                                     |
| **인스턴스 메서드** | **`.getSuperclass`** | 해당 클래스의 부모 클래스 객체를 반환                               | `Integer.class.getSuperclass()` | `Integer` 클래스의 부모 클래스(`Number`)의 클래스 객체 반환                                     |
| **인스턴스 메서드** | **`.getInterfaces`** | 해당 클래스가 구현한 모든 인터페이스의 클래스 객체 목록을 배열로 반환   | `ArrayList.class.getInterfaces()` | `ArrayList`가 구현한 인터페이스 목록(`List`, `RandomAccess`, `Serializable` 등)을 반환          |

<h3>기본 자료형과 래퍼 클래스의 관계</h3>

| **기본 자료형** | **래퍼 클래스**    |
|----------------|------------------|
| `int`          | `Integer`       |
| `double`       | `Double`        |
| `float`        | `Float`         |
| `long`         | `Long`          |
| `short`        | `Short`         |
| `byte`         | `Byte`          |
| `char`         | `Character`     |
| `boolean`      | `Boolean`       |



<h3>Int, String이 혼합된 List를 분리하기(Row Type)</h3>

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> mixedList = new ArrayList<>(); // String과 Integer 타입이 섞인 리스트
        mixedList.add("Hello");
        mixedList.add(42);
        mixedList.add("World");
        mixedList.add(99);

        printMixedList(mixedList); // 와일드카드의 List 값들을 출력
 }

// For-each 방식
public static void printMixedList(List<?> list) {
    // for-each 반복문으로 변경
    for (Object element : list) { // IntelliJ의 iter 템플릿 자동완성 사용
        if (element instanceof String) {
            System.out.println("String: " + element);
        } else if (element instanceof Integer) {
            System.out.println("Integer: " + element);
        } else {
            System.out.println("Unknown Type: " + element);
        }
    }
}


// Iterator 방식
public static void printMixedList(List<?> list) { 
        Iterator<?> iterator = list.iterator(); // 타입이 와일드카드<?>로 된 List 생성
                                                        // 와일드카드<?>로 된 리스트는 읽기(get, iterator.next)는 가능하지만 쓰기(삽입)은 불가능
        while (iterator.hasNext()) { // .hasNext 반복자에 값이 있으면 true / 값이 없으면 false로 반환
            Object element = iterator.next();   // .next()는 현재 포인터의 요소를 반환하고 다음 포인터로 이동시킴
							   // 컴파일러는 안정성을 위해 모든 요소 Object 타입으로 강제 반환
            if (element instanceof String) {     // instanceof : element가 String 타입이냐? → True/False 반환
                System.out.println("String: " + element);
            } else if (element instanceof Integer) {
                System.out.println("Integer: " + element);
            } else {
                System.out.println("Unknown Type: " + element);
            }
        }
    }
}
```

<h3>Iterator와 for-each</h3>

| **구분**            | **Iterator**                                                                 | **for-each**                                                                             |
|---------------------|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| **사용 목적**        | 컬렉션(리스트, 셋 등)의 요소를 순차적으로 접근하며, **요소 삭제**와 같은 추가 작업 가능.                | 간결하게 컬렉션이나 배열의 모든 요소를 순회. **요소 삭제 불가.**                                     |
| **구문**            | `Iterator<String> it = list.iterator();`<br>`while (it.hasNext()) {}`      | `for (String element : list) {}`                                                       |
| **코드 가독성**      | 상대적으로 복잡: **명시적으로 Iterator 생성** 및 `hasNext`, `next` 호출 필요.   | 간단하고 직관적: 추가적인 작업 없이 바로 컬렉션의 요소를 순회 가능.                                    |
| **요소 삭제 여부**    | 가능: `it.remove()`로 요소 삭제 가능.                                         | 불가능: 요소 삭제와 같은 작업은 지원되지 않음.                                                       |
| **컬렉션 타입**       | **모든 컬렉션에 사용 가능** (리스트, 셋, 맵 등).                                   | **Iterable을 구현한 컬렉션 및 배열만 사용 가능.**                                                     |
| **내부 동작**         | **Iterator 객체를 명시적으로 사용**하여 요소에 접근.                            | **컴파일러가 Iterator로 변환**하여 내부적으로 처리함.                                                |
| **장점**            | - 요소를 순회하면서 삭제 또는 수정 작업 가능.<br>- 컬렉션 외에도 다양한 데이터 구조에 사용 가능. | - 코드가 간결하고 직관적.<br>- 컬렉션이나 배열을 단순히 순회하는 데 적합.                                       |
| **단점**            | - 코드가 상대적으로 길고 복잡.<br>- 단순히 순회만 할 경우 과잉 설계일 수 있음.       | - 삭제 작업이나 Iterator의 세부 동작을 수행할 수 없음.<br>- 특정 조건에 따라 순회를 중단하기 어려움.                      |


```java
package chap2_7.lambda;

@FunctionalInterface // ⭐람다 표기법 O: 추상 메서드가 단 1개인 메서드(오버라이딩할 메서드)
public interface GenericPredicate<T> {
    boolean test(T t);
}
```
```java
package chap2_7.lambda;

import chap1_6.modi.pac1.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterApple { // 여러 객체가 필터링 가능토록 제네릭 사용
    public static <T> List<T> filter(List<T> list, GenericPredicate<T> p) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }
}
```
```java
public class Main {

    public static void main(String[] args) {
        // 숫자목록에서 짝수 필터링
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> filterNumbers = filter(numbers, n -> n % 2 == 0); // 람다 표기법
        System.out.println("filterNumbers = " + filterNumbers);
        // 출력: filterNumbers = [2, 4, 6]

        // 3글자 이상인 문자열만 필터링
        List<String> foods = List.of("짜장면", "우동", "김", "탕수육"); // 람다 표기법
        List<String> filterFoods = filter(foods, f -> f.length() == 3);
        System.out.println("filterFoods = " + filterFoods);
        // 출력: filterFoods = [짜장면, 탕수육]
    }
}
```
</details>
<details>
		<summary><b>ㅤ25/01/15/수: GitHub push 실수 시 | ⭐⭐ 대상의 추상화: 제네릭 타입 파라미터＜T＞와 Row 타입 </b></summary>
<h2>⭐GitHub push 실수 시(이전 버전으로 변경 | 커밋 로그 삭제 방법)</h2>

<h3>⭐개인 브랜치 푸시한 커밋 수정</h3>

<b>1. git revert #XXXX(커밋 해시): 변경 로그를 남김</b><br>
`git switch 개인 브랜치` → `git revert #XXXX(커밋 해시: 변경 원하는 버전)` → `git push origin 개인 브랜치`

<b>2. git reset --hard #XXXX(커밋 해시): 변경 로그 삭제**※ Main 브랜치에 PR→Merge되기 전이라면 git reset --hard 언제든 OK(**단, 작업한 파일이 혼자만 쓰는 경우)</b><br>
`git switch 개인 브랜치` → `git reset --hard #XXXX(커밋 해시: 변경 원하는 버전)` → `git push --force origin 개인 브랜치`

<h3>⭐⭐Main 브랜치에 머지된 커밋 수정(개인 브랜치 PR → Main 브랜치 Merge 후 수정 필요)</h3>
<h4>0.main 브랜치 push 금지 설정 해제 </h4>

<b>1. git revert #XXXX(커밋 해시): 변경 로그를 남김</b><br>
`git switch main` → `git revert #XXXX(커밋 해시: 변경 원하는 버전)` → `git push origin main`

<b>2. git reset --hard #XXXX(커밋 해시): 변경 로그 삭제 (⭐⭐⭐강사님 왈: 없다고 생각하세요)</b><br>
`git switch main` → `git reset --hard #XXXX(커밋 해시: 변경 원하는 버전)` → `git push --force origin main`

<h2>⭐⭐ 대상의 추상화: 제네릭 타입 파라미터<T>와 와일드카드<?>, Row 타입 </h2>

<h3>Generic(제네릭): 일반화 ~ 특정 타입에 의존X, 다양한 타입에 대해 동작하도록 설계</h3>

| **구분**               | **설명**                                                  | **예시**                                                                                |
|------------------------|-----------------------------------------------------------|---------------------------------------------------------------------------------------|
| **일반 타입**           | **구체적으로 정의된 고정된 타입**.<br>객체나 변수의 자료형을 명확히 지정. | `String`, `Integer`, `Apple`<br>`public String name;`, `public int value;`           |
| **제네릭 타입 매개변수** | **선언 시 사용되는 타입 매개변수**.<br>추상화 및 설계에 사용.         | `<T>`, `<E>`<br>`GenericPredicate<T>`                                                |
| **제네릭 타입**         | 제네릭이 적용된 **실제 타입**.<br>매개변수가 대체된 결과값.         | `String`, `Integer`, `Apple`<br>`GenericPredicate<String>`, `GenericPredicate<Apple>` |


<h3>`GenericPredicate<T>`, `GenericPredicate<Apple>`, `GenericPredicate (Row Tpye)` 비교</h3>

| **구분**             |`GenericPredicate<T>`                                                   |`GenericPredicate<Apple>`                          | `GenericPredicate (Raw Type)`                     |
|----------------------|---------------------------------------------------------------------------|----------------------------------------------------|--------------------------------------------------|
| **제네릭 타입 선언**  | 제네릭 타입 `T`가 선언됨<br>타입을 전달받아야 함                                            | 제네릭 타입이 `Apple`로 고정                        | 제네릭 타입 없이 사용<br>(Raw Type)                |
| **타입 지정**         | 동적으로 설정 가능                                                                | `Apple` 타입으로 고정                               | 타입 지정하지 않고 사용                            |
| **타입 지정 필요 여부** | `GenericPredicate<Apple>`,<br>`GenericPredicate<String>` 등<br>명시적으로 타입을 지정해야 함 | `GenericPredicate<Apple>`로 타입이 고정<br>다른 객체를 사용할 수 없음 | 타입 지정하지 않고<br>간단히 사용 가능           |
| **타입 안전성**       | 타입이 명확히 지정<br>**컴파일 시 타입 체크 가능**                                          | 컴파일 시 타입 체크<br>(안전)                       | 타입 정보가 없어<br>**컴파일 시 타입 체크 불가**   |
| **유연성**            | 다양한 객체에 동작 가능                                                             | 특정 타입 (`Apple`)에 맞게 설계                     | 타입 제한이 없으나,<br>**런타임 에러 발생 가능**   |

<h3>Raw 타입</h3>
<b>제네릭 도입되기 전(Java 5 이전) 사용 방식 → 타입 안정성 없이 사용(String, int, 객체 한 리스트에 추가 가능)</b>
<b>제네릭 도입 후 레거시 코드/API와 호환성 유지를 위해 Raw 타입 허용</b>

<h4>🚨 문제점</h4>
<b>타입 안정성 부족: 컴파일 시 타입 체크X | 잘못된 타입 포함될 가능성 有</b><br>
<b>런타임 오류 발생 가능성↑: 잘못된 타입을 캐스팅 시 ClassCastingException 발생</b>
</details>
<details>
		<summary><b>ㅤ25/01/14/화: 클래스/메서드와 생성자 | ⭐객체와 인스턴스 | ② 내부(중첩)/익명 클래스+람다 표기법</b></summary>	
<h3>클래스(설계도)와 메서드[동작(로직)] 생성자(객체 생성, 필드 초기화)</h3>

| **구분**       | **클래스**                     | **메서드**                        | **생성자**                                      |
|----------------|--------------------------------|------------------------------------|------------------------------------------------|
| **매개변수**   | **사용 불가**                  | **사용 가능**                     | **사용 가능**                                  |
| **사용 목적**  | 객체의 설계도 제공              | 객체의 동작(로직)을 정의           | **객체 생성 및 필드 초기화**                   |
| **예시**       | `public class ApplePredicate {}` | `public boolean test(Apple apple) {}` | `public ApplePredicate(String color) {}`        |


<h3>⭐객체와 인스턴스</h3>

| **구분**       | **클래스 / 인터페이스 / 추상화 (설계도)**        | **객체 (`new 키워드`)**                   | **인스턴스 (결과물)**                  |
|--------------|--------------------------------------------------|-----------------------------------------|----------------------------------------|
| **필드 / 메서드** | 정의만 존재 (설계도 상태, 필드/메서드 정의)       | 값이 미입력된 상태 (null, 0, false)      | 모든 필드 값이 할당됨, 메서드 실행 가능 |
| **메모리**      | 미생성                                            | 생성                                    | 값 입력                                |

<h3>⭐ 내부(중첩)/익명 클래스</h3>

|                 | 인터페이스 (Interface)                                | 내부 클래스 (Inner)                                   | 익명 클래스 (Anonymous)               |
|-----------------|-------------------------------------------------------|-------------------------------------------------------|----------------------------------|
| **재사용**      | O                                                     | 클래스 내부에서 재사용                                | 1회용                              |
| **구현 여부**   | 인터페이스(설계도) + 실체 클래스(구현체) + 동작 클래스(Main) | 인터페이스(설계도) + 동작 클래스(Main)               | 동작 클래스(Main) + 동작 클래스(Main - 축약) |

<h3>⭐ 내부(중첩) 클래스 ~ Inner(Nested)</h3>

① 역할(Responsibilitiy) 분리 필요 시 → 한 클래스 내 관련 로직을 내부 클래스로 모아둠<br>
② 여러 메서드가 결과 값을 공유하는 경우(캡슐화 1) → 물건 구매-할인 적용-포인트 적립-현재 포인트 조회<br>
③ 개인/중요 정보 외부에서 접근/변경 방지(캡슐화 2) → 내부 클래스에서 private 선언<br>
④ 디자인 패턴(Iterator, Builder) 활용<br>
```java
package chap2_7.lambda;

public interface ApplePredicate { // 사과를 전달받아 특정 조건에 의해 사과를 필터링
    boolean test(Apple apple);
}
```
```java
public class Main { // 외부 클래스

    private static class AppleGreenOrRed implements ApplePredicate { // 내부 클래스
        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == RED || apple.getColor() == GREEN;
            //                          ┗> 하단 이미지 참고         ┗> 하단 이미지 참고
            // Alt + Enter: Add on-demand static import for 'chap2_7.lambda.Color' 적용함
        }
    }

    public static void main(String[] args) { // main 메소드
        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );
        List<Apple> applesGorR = filterApples(appleBasket, new AppleGreenOrRed());
        System.out.println("applesGorR = " + applesGorR);
    }
}
```
<img src="https://github.com/3rd-PJ-Spring/Checkpoint/blob/main/img/ThoI-i/250114(%ED%99%94)/%237_ThoI-i_BE_%EA%B0%9D%EC%B2%B4%EC%99%80%20%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4%20%20%E2%91%A1%20%EB%82%B4%EB%B6%80(%EC%A4%91%EC%B2%A9)%EC%9D%B5%EB%AA%85%20%ED%81%B4%EB%9E%98%EC%8A%A4%2B%EB%9E%8C%EB%8B%A4%20%ED%91%9C%EA%B8%B0%EB%B2%95.png" alt="Add on-demand static import for">
<h3>익명 클래스(Anonymous)</h3>
인터페이스/추상 클래스(또는 일반 클래스)를 구현/상속 → 메서드 오버라이드 → 인스턴스 생성

```java
package chap2_7.lambda;

public interface ApplePredicate { // 사과를 전달받아 특정 조건에 의해 사과를 필터링
    boolean test(Apple apple);
}
```
```java
public class Main {
    
    public static void main(String[] args) { // main 메소드
        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );
        
        List<Apple> weightGT150 = filterApples(appleBasket, new ApplePredicate() { // 익명 클래스
            @Override                     // 익명 클래스를 구현/상속 <┘           ┖> class 내부 내용
            public boolean test(Apple apple) {
                return apple.getWeight() >= 150;
            }
        });
        
        System.out.println("weightGT150 = " + weightGT150);
    }
}
```
<h3>람다 표기법(익명 클래스)</h3>

<b>@FunctionalInterface ⭐추상 메서드가 단 1개인 메서드 = 오버라이딩할 메서드 1개</b><br>
└> **람다 표기법을 쓸 수 있다!**
```java
List<Apple> weightGT150 = filterApples(appleBasket, new ApplePredicate() { // 익명 클래스
            @Override                     // 익명 클래스를 구현/상속 <┘           ┖> class 내부 내용
            public boolean test(Apple apple) {
                return apple.getWeight() >= 150;
            }
        });
```
                            // 파라미터 <┒
① 객체 생성 생략 가능 [ new ___(){} ] → () -> {}<br>
```java                         
List<Apple> weightGT150 = filterApples(appleBasket, (apple) -> { // 람다 표현식 ① 
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() >= 150;
            }
        });
```
② 메서드 명 생략 가능 [ @Override public ____() ]<br>
```java
List<Apple> weightGT150 = filterApples(appleBasket, (apple) -> { // 람다 표현식 ②
                apple.getWeight() >= 150
        });
```
③ **코드 1줄** 중괄호{}, return 생략 가능 → 단일 표현식<br>
```java
List<Apple> weightGT150 = filterApples(appleBasket, (apple) -> apple.getWeight() >= 150);  // 람다 표현식 ③
```
</details>
<details>
		<summary><b>ㅤ25/01/13/월: ⭐⭐️① 동작의 추상화 분석 + 복수 메서드(조건) + 스트림 API + 데이터 재활용(서버)과 SQL</b></summary>
<h3>① 인터페이스(메서드 형식(규격)을 설계/생성해서 필요한 기능을 바로바로 넣을 수 있게 만듬</h3>

```java
public interface ApplePredicate {
    boolean test(Apple apple);
}
```
<h3>② FilterApple 클래스에서 ApplePredicate a 파라미터를 통해서 1개의 조건(메서드)</h3>

```java
public class FilterApple {
    public static List<Apple> filterApples(List<Apple> basket, ApplePredicate a) {
        // ⓐ 필터링된 사과들만 담을 새 바구니 생성
        List<Apple> filteredBasketA = new ArrayList<>();

        // ⓑ 반복문과 조건문을 통해 특정 조건의 사과를 필터링
        for (Apple apple : basket) {
            if (a.test(apple)) { // ⓒ-1 a.test(apple)가 참이면
                filteredBasketA.add(apple); // ⓒ-2 apple 정보를 filteredBasket 배열에 추가함
            }
        }
        return filteredBasketA; // ⓓ 반복문 종료 후 filteredBasketA 배열을 반환함
    }
}         
```
<h3>③ 만약 파라미터 수 = 조건(메서드) 수 = 새 배열 수 = 필터링 수 = 조건에 맞게 반환해야한다면?</h3>
<h4>⭐️⭐️1개의 메서드 = 1개의 결과값을 반환</h4>

```java
public class FilterApple {      // 필터링할 사과 객체들이 담긴 리스트 <┐            ┌>조건을 정의하는 객체
    public static Map<String, List<Apple>> filterApples(List<Apple> basket, ApplePredicate a, ApplePredicate b, ApplePredicate c, ApplePredicate d) {
              // 메서드 반환 타입 Map<String, List<Apple>> → 복수의 조건 결과를 한 번에 반환하기 위해
        // Key(String): BasketA, BasketB  <┘ 	      ┗> Value: List<Apple>: 특정 조건에 맞는 사과 리스트

        List<Apple> filteredBasketA = new ArrayList<>(); // 각 조건에 맞는 사과를 담을 리스트 생성
        List<Apple> filteredBasketB = new ArrayList<>();
        List<Apple> filteredBasketC = new ArrayList<>();
        List<Apple> filteredBasketD = new ArrayList<>();

        for (Apple apple : basket) {         // List<Apple> basket 전체 사과 리스트를 하나씩 검사해서
            if (a.test(apple)) {             // 조건에 부합하는 리스트에 넣음
                filteredBasketA.add(apple);
            } else if (b.test(apple)) {
                filteredBasketB.add(apple);
            } else if (c.test(apple)) {
                filteredBasketC.add(apple);
            } else if (d.test(apple)) {
                filteredBasketD.add(apple);
            }
        }

        Map<String, List<Apple>> result = new HashMap<>(); // HashMap을 통해 Key 명을 지칭 |  Value에 필터된 리스트들을 저장함
        result.put("BasketA", filteredBasketA);                           // Key값을 호출하면 Value에 저장된 값을 호출할 수 있으며,
        result.put("BasketB", filteredBasketB);
        result.put("BasketC", filteredBasketC);
        result.put("BasketD", filteredBasketD);

        return result;                                    // 복수의 조건 결과 한 번에 반환(result)
    }
}
```
```java
🚨 만약 3개의 조건(a, b, c)만 쓰고 d를 쓰지 않는다면?
❌ 메모리 낭비 / 코드 가독성↓ / 유지보수 힘듬
```
<h3>④ 조건을 동적으로 생성(조건의 갯수만큼 배열, 필터링하여 반환함)</h3>

```java
public class FilterApple {                               // 필터링할 사과 객체들이 담긴 리스트 <┐
    public static Map<String, List<Apple>> filterApples(List<Apple> basket, List<ApplePredicate> predicates) {
        Map<String, List<Apple>> result = new HashMap<>();

        // 조건별 리스트 생성    ┏> 조건의 개수만큼 새 리스트 생성
        for (int i = 0; i < predicates.size(); i++) {
            result.put("Basket" + (char) ('A' + i), new ArrayList<>());
        }

        // 조건별로 사과 분류
        for (Apple apple : basket) {
            for (int i = 0; i < predicates.size(); i++) {
                if (predicates.get(i).test(apple)) {
                    result.get("Basket" + (char) ('A' + i)).add(apple); // 형 변환(Casting) ↓↓↓↓
                    break;
                }
            }
        }
        return result;
    }
}
```
```java
char 문자('A')는 유니코드(아스키코드) 숫자로 표현함
'A' = 65
('A' + 1) = int 66 [묵시적 형 변환(Up Casting)]
char   int

(char) ('A' + 1) = B [명시적 형 변환(Down Casting)] 
(char) (int 66) = B
```
<h3>⭐ List 인터페이스 메서드</h3>

| **기능**                   | **메서드 코드**                                                              | **예시**                                                                |
|---------------------------|-------------------------------------------------------------------------|-----------------------------------------------------------------------|
| **① 추가**                | `.add`, `.add(index, element)`                                          | `list.add("Apple")`, `list.add(1, "Banana")`                          |
| **② 조회**                | `.get(index)`                                                           | `list.get(0)`                                                         |
| **③ 수정**                | `.set(index, element)`                                                  | `list.set(1, "Orange")`                                               |
| **④ 삭제**                | `.remove(index)`, `.remove(element)`                                    | `list.remove(0)`, `list.remove("Apple")`                              |
| **⑤ 요소 확인 (true/false)** | `.contains(element)`                                                    | `list.contains("Apple")`                                              |
| **⑥ 크기 확인**            | `.size()`                                                               | `list.size()`                                                         |
| **⑦ 초기화**               | `.clear()`                                                              | `list.clear()`                                                        |
| **⑧ 공백 확인 (true/false)** | `.isEmpty()`                                                            | `list.isEmpty()`                                                      |
| **⑨ 정렬**                | `.sort(list)`**(오름차순)**<br/>`.sort(list, reverseOrder())`**(내림차순)** | `Collections.sort(list)`<br/>`list.sort(Comparator.reverseOrder())` |

<h3>⑤ 스트림 API 사용(JAVA 8↑): 가독성↑</h3>

```java
import java.util.*;
import java.util.stream.Collectors;

public class FilterApple {                                                         
    public static Map<String, List<Apple>> filterApples(List<Apple> basket, List<ApplePredicate> predicates) {
        Map<String, List<Apple>> result = new HashMap<>();

        // 조건별로 리스트 생성
        for (int i = 0; i < predicates.size(); i++) {
            String key = "Basket" + (char) ('A' + i);
            result.put(key, basket.stream()
                                  .filter(predicates.get(i)::test)
                                  .collect(Collectors.toList()));
        }
        return result;
    }
}
```
```java
🚨 중복 조건도 다시 검사(데이터 재활용 불가X)
❌ → 반복 횟수↑
```
<h3>⑥ AND/OR 조건을 활용한 데이터 재사용</h3>

```java
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterApple {

    public static Map<String, Long> filterAndCountApples(List<Apple> basket, List<Predicate<Apple>> conditions) {
        Map<String, List<Apple>> intermediateResults = new HashMap<>();
        Map<String, Long> counts = new HashMap<>();

        // 조건별로 결과 저장
        for (int i = 0; i < conditions.size(); i++) {
            String conditionKey = "Condition" + (i + 1);
            List<Apple> filtered = basket.stream()
                                         .filter(conditions.get(i))
                                         .collect(Collectors.toList());
            intermediateResults.put(conditionKey, filtered);
            counts.put(conditionKey, (long) filtered.size()); // 각 조건의 개수 저장
        }

        // 교집합 계산 (AND 조건)
        for (int i = 0; i < conditions.size(); i++) {
            for (int j = i + 1; j < conditions.size(); j++) {
                String intersectionKey = "Intersection" + (i + 1) + "&" + (j + 1);
                List<Apple> intersection = intermediateResults.get("Condition" + (i + 1)).stream()
                                                              .filter(conditions.get(j))
                                                              .collect(Collectors.toList());
                counts.put(intersectionKey, (long) intersection.size()); // 교집합 개수 저장
            }
        }

        return counts;
    }
}
```
```java
✅ 장점
ⓐ 네트워크 부하 감소↓: 데이터 재활용
ⓑ 유연한 조합: 조건 추가/변경 용이
ⓒ 데이터 캐싱:  SQL 부담↓ 감소

❌ 단점
ⓐ 메모리 사용량 증가
ⓑ 데이터 동기화 문제: SQL에서 데이터가 실시간 변화 반영 힘듬
```
<h3>✨요약</h3>

| 항목               | 서버 처리(데이터 재사용)              | SQL 처리                      | 서버 + SQL 결합              |
|--------------------|-----------------------------|------------------------------|-----------------------------|
| **장점**           | 동적/복잡한 조건 추가 가능, 재사용 + 캐싱 가능 | 대규모 데이터 계산 처리, 데이터베이스의 인덱스 최적화 기능 활용 | 성능 최적화, 유연성, 네트워크 부하 감소 |
| **데이터 수**      | 1만 건 이하 ↓                   | 100만 건 이상 ↑              | 중간 규모 (1만 ~ 100만 건)  |
| **데이터 용량**    | 수 MB ~ 500MB                | 5GB 이상 ↑                   | 500MB ~ 5GB                |
| **데이터 수정**    | 조회만                         | 실시간 반영 O                 | 조회 + 최소 수정             |
| **조건 조합**      | 동적 조합 용이                    | 고정된 조건에 적합             | 동적 조합 + SQL 필터링        |
| **실시간성**       | 낮음                          | 높음                         | SQL 최신 데이터 + 서버 조합   |
| **캐싱 활용**      | 가능 (메모리 캐싱)                 | 어려움                        | SQL + 캐싱으로 결합          |
| **적합한 경우**    | 소규모 데이터, 자주 바뀌는 조건          | 대규모 데이터, 실시간 데이터     | 균형 잡힌 처리, 실무 적합     |

</details>
	<details>
		<summary><b>ㅤ25/01/10/금: ① 동작(기능/메서드)의 추상화</b></summary>	
<h3>ApplePredicate 인터페이스, AppleWeightPredicate/AppleSomething 클래스 추가</h3>

```java
package chap2_7.lambda;

public interface ApplePredicate { // 사과를 전달받아 특정 조건에 의해 사과를 필터링
    boolean test(Apple apple);
}
```
```java
package chap2_7.lambda;

import chap1_6.modi.pac1.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// 사과를 여러가지 방법으로 필터링
public class FilterApple {
    public static List<Apple> filterApples(List<Apple> basket, ApplePredicate a) {
        // 1. 필터링된 사과들만 담을 새 바구니 생성
        List<Apple> filteredBasket = new ArrayList<>();

        // 2. 반복문과 조건문을 통해 특정 조건의 사과를 필터링
        for (Apple apple : basket) {
            if (a.test(apple)) {
                filteredBasket.add(apple);
            }
        }
        return filteredBasket;
    }
}
```
```java
package chap2_7.lambda;

public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() >= 150;
    }
}
```
```java
package chap2_7.lambda;

public class AppleSomething implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.RED && apple.getWeight() < 150;
    }
}
```
```java
package chap2_7.lambda;

import java.util.List;

import static chap2_7.lambda.Color.*;
import static chap2_7.lambda.FilterApple.*;
import static chap2_7.lambda.MappingApple.*;

public class Main {

    public static void main(String[] args) {
        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        // 무게가 150 이상인 사과를 필터링
        List<Apple> weightGT150 = filterApples(appleBasket, new AppleWeightPredicate());
        System.out.println("weightGT150 = " + weightGT150);

        // 빨강색이면서 무게가 150 미만인 사과를 필터링
        List<Apple> applesSomethings = filterApples(appleBasket, new AppleSomething());
        System.out.println("applesSomethings = " + applesSomethings);
    }
}
```

</details>
	<details>
		<summary><b>ㅤ25/01/09/목: 동작의 추상화 | ⓞ List 인터페이스</b></summary>

```java
// 실행 순서
1. Apple 클래스 → 생성자로 Apple(무게, 색상)의 Apple 타입 생성
2. Main 클래스 → List<Apple> appleBasket = List.of(....)
                 ㄴ List 인터페이스 + Apple 타입의 appleBasket 객체 생성
3-1. FilterApple 클래스 → List<Apple> filterGreenApples(List<Apple> basket) {
   ㄴ List 인터페이스 + Apple 타입의 filterGreenApples 매서드 + List 인터페이스 + Apple 타입의 basket를 매개변수로 받음
3-2. for (Apple apple : basket) {
     if (apple.getColor() == Color.GREEN) {
         greenBasket.add(apple);
      }
        }
    ㄴ 녹색 사과만 넣을 Basket 배열 생성 
    + iter 배열 전용 반복문으로 초록색이면 greenBaket.add(apple)
    greenBasket를 return ※return으로 지역변수 생존시킴
4. Main 클래스 → List<Apple> greenApples = filterGreenApples(appleBasket);
					        System.out.println("greenApples = " + greenApples);
     ㄴ List 인터페이스 Apple 타입 greenApples 객체에 
           filterGreenApples 초록 사과만 필터링하는 매서드에 appleBasket 필터링할 데이터를 넣음
     System.out.println("greenApples = " + greenApples);
     ㄴ초록 사과만 들어있는 배열을 출력함
```
```java
package chap2_7.lambda;

import java.util.Objects;

public class Apple {

    private int weight; // 무게
    private Color color; // 색상

    public Apple() {
    }

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return weight == apple.weight && color == apple.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }
}
```
```java
package chap2_7.lambda;

public enum Color {
    RED, GREEN, YELLOW
}
```
```java
package chap2_7.lambda;

import chap1_6.modi.pac1.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
// import static chap2_7.lambda.Color.*;

// 사과를 여러가지 방법으로 필터링
public class FilterApple {

    public static List<Apple> filterGreenApples(List<Apple> basket) {
        // 1. 녹색 사과들만 담을 새 바구니 생성
        List<Apple> greenBasket = new ArrayList<>();

        // 2. 반복문과 조건문을 통해 녹색 사과를 필터링
        for (Apple apple : basket) {
            if (apple.getColor() == Color.GREEN) {
//          if (apple.getColor() == GREEN) {
// ALT+ENTER: Add on-demand static import for 'chap2_7.lambda.Color'
                greenBasket.add(apple);
            }
        }
        return greenBasket;
    }
	}
```
```java
package chap2_7.lambda;

import java.util.List;

import static chap2_7.lambda.Color.*;
import static chap2_7.lambda.FilterApple.*;
import static chap2_7.lambda.MappingApple.*;

public class Main {

    public static void main(String[] args) {
        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        List<Apple> greenApples = filterGreenApples(appleBasket);
        System.out.println("greenApples = " + greenApples);
```
```java
// 출력 결과
greenApples = [Apple{weight=80, color=GREEN}, Apple{weight=155, color=GREEN}, Apple{weight=200, color=GREEN}]
```


</details>
	<details>
		<summary><b>ㅤ25/01/08/수: 인터페이스(Interface), 내부 클래스(Inner), 익명 클래스(Anonymous)</b></summary>

|                 | 인터페이스 (Interface)                                | 내부 클래스 (Inner)                                   | 익명 클래스 (Anonymous)               |
|-----------------|-------------------------------------------------------|-------------------------------------------------------|----------------------------------|
| **재사용**      | O                                                     | 클래스 내부에서 재사용                                | 1회용                              |
| **구현 여부**   | 인터페이스(설계도) + 실체 클래스(구현체) + 동작 클래스(Main) | 인터페이스(설계도) + 동작 클래스(Main)               | 동작 클래스(Main) + 동작 클래스(Main - 축약) |

<h3>⭐️ 내부(중첩) 클래스 ~ Inner(Nested)</h3>
**① 역할(Responsibilitiy) 분리 필요 시**
→ 한 클래스 내 관련 로직을 내부 클래스로 모아둠<br>
**② 여러 메서드가 결과 값을 공유하는 경우(캡슐화 1)**
→ 물건 구매-할인 적용-포인트 적립-현재 포인트 조회<br>
**③ 개인/중요 정보 외부에서 접근/변경 방지(캡슐화 2)**
→ 내부 클래스에서 private 선언<br>
**④ 디자인 패턴(Iterator, Builder) 활용**

<h3>⭐️ 익명 클래스(Anonymous)</h3>
**단, 한 번 결과값을 보고 재사용하지 않는 경우** <br>
인터페이스/추상 클래스(또는 일반 클래스)를 구현/상속 → 메서드 오버라이드 → 인스턴스 생성
<details>
		    <summary><b>ㅤㅤ인터페이스(Interface): 재사용 多</b></summary>

```java
package chap2_6.inner;

public interface Calculator {

    int operate(int n1, int n2); // 두개의 정수를 가지고 연산
}
```
```java
package chap2_6.inner;

public class AddCalculator implements Calculator {
    @Override
    public int operate(int n1, int n2) {
        return n1 + n2;
    }
}
```
```java
package chap2_6.inner;

public class Main {
    public static void main(String[] args) {
        Calculator addCal = new AddCalculator();
        int result1 = addCal.operate(50, 30);
        System.out.println("result1 = " + result1);
        }
    }
```
</details>
<details>
		<summary><b>ㅤㅤ내부 클래스(Inner Class)</b></summary>	

```java
// 재활용하지 X 클래스 (해당 클래스 내부에서만 쓸 거 같다)
private static class
```
```java
package chap2_6.inner;

public interface Calculator {

    int operate(int n1, int n2); // 두개의 정수를 가지고 연산
}
```
```java
package chap2_6.inner;

public class Main {

    private static class SubCalculator implements Calculator {
        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
public static void main(String[] args) {
        
        SubCalculator subCal = new SubCalculator();
	        int result2 = subCal.operate(100, 25);
	        System.out.println("result2 = " + result2);
    }
```
</details>
<details>
		<summary><b>ㅤㅤ익명 클래스 (Anonymous class)</b></summary>

```java
// 내부 클래스에서 단, 1번만 쓸거다.

Calculator multiCal = class MultiCalculator implements Calculator{}
↓
Calculator multiCal = (class MultiCalculator) implements Calculator{}
↓
Calculator multiCal = implements Calculator {}
↓
Calculator multiCal = new Calculator() {}
            implements를 대체 <<┘       ┖>> class를 의미
```
```java
package chap2_6.inner;
	public class Main {
	   public static void main(String[] args) {     
	          
	          Calculator multiCal =  new Calculator() {
            // 클래스 블록 내부
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
           int result3 = multiCal.operate(6, 11);
		       System.out.println("result3 = " + result3);
     }
}
```
</details>
</details>
	<details>
		<summary><b>ㅤ25/01/07/화: 파일 입출력[(바이트 기반 스트림/텍스트 기반 스트림], 객체 파일 입출력</b></summary>	

| 출력 (Output)                                  | 입력 (Input)                                  |
|-----------------------------------------------|----------------------------------------------|
| Save: 저장할 정보 전송                         | Load: 저장된 데이터 읽기                     |
| FileOutputStream                               | FileInputStream                              |
| Writer                                        | Reader                                       |

|             | FileInputStream                                    | Reader                                  |
|-------------|-----------------------------------------------|----------------------------------------------|
| **타입**    | 바이트 기반 스트림                             | 텍스트 기반 스트림                            |
| **입력 방식** | 한 글자씩                                    | 한 라인씩 (BufferedReader - `readLine()`)   |

<details>
		<summary><b>ㅤㅤ객체 파일 입출력</b></summary>
<details>
		<summary><b>ㅤㅤㅤ객체 보조 스트림 (implements Serializable)</b></summary>	
		ㅤㅤㅤㅤㅤ<b>객체→스트림 통과(개념 필요)를 위해 직렬화[Serializable(저장 시)]</b>

```java
List<Snack> snackList = List.of(
...
        );

        ┌>>> 직렬화 O
// List<Snack>
┕>>> 직렬화 X

public class Snack implements Serializable
```
```java
package chap2_5.fileio.objstream;

import chap2_5.fileio.FileExample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class SaveSnack {

  public static void main(String[] args) {

    // 과자 객체 전부 세이브파일로 저장
    List<Snack> snackList = List.of(
            new Snack("콘칲", 1970, 1500, Snack.Taste.GOOD)
            , new Snack("오징어집", 1985, 1800, Snack.Taste.GOOD)
            , new Snack("사브레", 1980, 3000, Snack.Taste.BAD)
    );

    try (FileOutputStream fos = new FileOutputStream(FileExample.ROOT_PATH + "/snack.sav")) {
      // 객체를 바이트로 변환해주는 보조 스트림
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      // 객체가 스트림을 통과하려면 직렬화라는 개념이 필요함
      oos.writeObject(snackList);
      System.out.println("객체 저장 성공!");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
```
```java
package chap2_5.fileio.objstream;

import java.io.Serializable;
import java.util.Objects;

// Snack이 스트림을 통과할 수 있도록 직렬화 명시
public class Snack implements Serializable {

  public enum Taste {
    GOOD, BAD
  }

  private String snackName;
  private int year; // 출시년도
  private int price; // 가격
  private Taste taste; // 맛

  public Snack() {
  }

  public Snack(String snackName, int year, int price, Taste taste) {
    this.snackName = snackName;
    this.year = year;
    this.price = price;
    this.taste = taste;
  }

  public String getSnackName() {
    return snackName;
  }

  public void setSnackName(String snackName) {
    this.snackName = snackName;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Taste getTaste() {
    return taste;
  }

  public void setTaste(Taste taste) {
    this.taste = taste;
  }

  @Override
  public String toString() {
    return "Snack{" +
            "snackName='" + snackName + '\'' +
            ", year=" + year +
            ", price=" + price +
            ", taste=" + taste +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Snack snack = (Snack) o;
    return year == snack.year && price == snack.price && Objects.equals(snackName, snack.snackName) && taste == snack.taste;
  }

  @Override
  public int hashCode() {
    return Objects.hash(snackName, year, price, taste);
  }
}
```
</details>
<details>
		<summary><b>ㅤㅤㅤ역직렬화 (Deserialize) ~ 역직렬화 보조스트림 (ObjectInputStream)</b></summary>
<h3>Q: 아래 구문이 왜 필요해?</h3>

```java
List<Snack> snackList = (List<Snack>) ois.readObject();
```
```java
// ↓
    public final Object readObject()
        throws IOException, ClassNotFoundException {
        return readObject(Object.class);
    }
    
// readObject(); 메서드는 직렬화한 객체가 아닌 Object 객체로 가져옴
// Object → 사용자가 생성한 List<Snack>로 다운캐스팅 진행 → 역직렬화 완료(객체화)
```
```java
package chap2_5.fileio.objstream;

import chap2_5.fileio.FileExample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadSnack {

  public static void main(String[] args) {

    try (FileInputStream fis = new FileInputStream(FileExample.ROOT_PATH + "/snack.sav")) {
      // 저장된 객체를 불러온 후 역직렬화
      ObjectInputStream ois = new ObjectInputStream(fis);

      List<Snack> snackList = (List<Snack>) ois.readObject();

      for (Snack snack : snackList) {
        System.out.println(snack);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
```
</details>
</details>
</details>
<details>
		<summary><b>ㅤ25/01/06/월: 문서 작성 / FileOutputStream, FileInputStream</b></summary>	
		   ㅤㅤㅤㅤ<b>README / Notion 회의록 작성, GitHub 연결</b>
    <details>
		<summary><b>ㅤㅤㅤFileOutputStream: 바이트 기반 스트림 이미지 / 영상 / 소스코드 파일 저장</b></summary>
```java
public class FileOutputExample {
    public static void main(String[] args) {
        try {// 바이트 기반 출력 스트림 : 파일을 내보낸다 - Save기능
            FileOutputStream fos = new FileOutputStream(FileExample.ROOT_PATH + "/pet.txt"
                    fos.write(new byte[]{97, 99, 101});
        } catch (Exception e) {
            System.out.println("해당 경로를 찾을 수 없습니다.");
        }
    }
}
```

</details>
      <details>
		    <summary><b>ㅤㅤㅤFileOutputStream: 파일 읽기 | try ~ with ~ resource : 메모리 누수 코드 자동 클로징</b></summary>

```java
public class FileInputExample {
  public static void main(String[] args) {
    // try ~ with ~ resource : 메모리 누수가 있을 수 있는 코드를 자동 해제
    try (FileInputStream fis = new FileInputStream(FileExample.ROOT_PATH + "/pet.txt")) {
      int data = 0;
      while ((data = fis.read()) != -1) {
        System.out.write(data);  // 아스키 코드를 문자로 출력
      }
      System.out.flush();          // 출력 버퍼 비우기
    } catch (Exception e) {
      System.out.println("파일 로드에 실패했습니다");
    }
  }
}
```

</details>
     <details>
		    <summary><b>ㅤㅤㅤFileOutputStream: 파일 읽기 | finally (레거시) : 메모리 누수 방지 클로징 코드</b></summary>

```java
public class FileInputExample {
  public static void main(String[] args) {
    FileinputStream fis = null;
    try {
      fis = new FileInputStream(FileExample.ROOT_PATH + "/pet.txt"
      int data = 0;
      while ((data = fis.read()) != -1) {
        System.out.write(data);  // 아스키 코드를 문자로 출력
      }
      System.out.flush();          // 출력 버퍼 비우기
    } catch (Exception e) {
      System.out.println("파일 로드에 실패했습니다");
    } finally {  // 예외에 관계없이 실행할 코드
      try {  // 메모리 해제 - 누수 방지
        if (fis != null) fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
```
</details>
    </details>
        </details>