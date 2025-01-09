## ✏️ Daily Study
### [↩ Go Back Main README](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐻‍❄️ThoI-i's footprint</b></summary>
	<details>
		<summary><b>ㅤ25/01/23/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/22/수:</b></span></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/21/화:</b></span></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/20/월:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/17/금:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/16/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/15/수:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/14/화:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/13/월:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/10/금:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/09/목: 동작의 추상화 | 인터페이스 + List 인터페이스</b></summary>

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