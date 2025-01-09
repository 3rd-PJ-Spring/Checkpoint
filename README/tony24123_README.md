## ✏️ Daily Study
### [↩ Go Back Main READMD](https://github.com/3rd-PJ-Spring/Checkpoint?tab=readme-ov-file#%EF%B8%8F-daily-study)
<details>
  <summary><b>🐢tony24123's footprint</b></summary>
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
		<summary><b>ㅤ25/01/09/목:</b></summary>	
		ㅤㅤㅤ내용
	</details>
	<details>
		<summary><b>ㅤ25/01/08/수:의존성 주입, 스프링 빈 관리</b></summary>	
		ㅤㅤㅤ<h3> 의존성 주입 </h3>
             의존성 주입: 객체 간의 의존성을 관리할 수 있는 설계 패턴<br> 
             객체는 필요한 의존성을 외부에서 주입받음.<br>
             -> 결합도는 낮추고 , 코드의 재사용성과 유지보수가 높아짐<br>
             크게 생성자 주입, 세터 주입, 필드 주입 3가지 방법 사용 가능<br>
             <h4>생성자 주입</h4>
             - 3가지 방법 중에 가장 좋은 방법<br>
             - 모든 의존성을 주입받아야 하므로 객체가 일관되게 생성된다.<br>
             - 애플리케이션 시작 시점에 문제 발견이 가능하다.<br>              
             <h4>세터 주입 </h4>
             - 세터 주입을 사용하면 유지보수측면에서 생성자 주입보다 어려울 수 있다.<br>
             - NULL체크도 해줘야한다.<br>
             - 중간에 객체가 변경될 수 있다.<br>
             - 런타임 시점까지 문제 발생이 되지않아서 애플리케이션 실행이 예기치 않게 실패할 수 있다.<br>
             <h4>필드 주입</h4>
             - 테스트와 유지보수 특면에서 어려운 점이 많아 비추천<br>
              <h3>스프링 빈 관리</h3>
             - 스프링이 대신해서 관리를 해줌 <br>
              <h4>자바 클래스 방식</h4>
              ex)@Configuration //스프링이 클래스를 관리<br>
                 @ Bean //어떤 객체를 관리할지 메서드로 설정<br>
              <h4>애너테이션 방식</h4>
              <h4>`@Component`</h4>
              - 가장 일반적인 스프링 빈을 정의하는 애너테이션<br>
              - 주로 특수한 역할이 없는 일반적인 빈에 사용된다.<br>
              <h4>`@Service`</h4>
              - 비즈니스 로직을 담고 있는 서비스 클래스에 사용<br>
              - `@Service` 애너테이션을 통해 해당 클래스가 서비스 계층을 담당함을 명시적 나타낸다.<br>
              <h4>`@Repository`</h4>              
              - 데이터 접근 계층(DAO) 클래스에 사용<br>
              -  데이터베이스와의 통신을 담당하는 클래스를 나타내며, 데이터 접근 예외를 처리.<br>         
              <h4>`@Controller`</h4>              
              - 애플리케이션에서 컨트롤러 역할을 하는 클래스에 사용<br>
              - 웹 요청을 처리하고, 모델 데이터를 뷰로 전달하는 역할.<br>
              <h4>@Autowired</h4>
              의존성 주입을 수행하기 위한 애너테이션<br>
              <h4>@Qualifier</h4>
              @Autowired와 함께 사용하여, 같은 타입의 빈이 여러 개 있을 때 어떤 빈을 주입할지 명시적으로 지정하는 방법             
      </details>
      <details>
          <summary><b>ㅤ25/01/07/화: 프로젝트 방향성 회의</b></summary>	
          ㅤㅤㅤ<h3>프로젝트 진행 방향 결정</h3>
               <h4>회의 내용</h4>
               <h4>문제 상황</h4> 
                1.개발 능력 향상을 위해 추가 공부가 필요하다 판단됨<br>
                2.프로젝트 분량 조절에 아쉬움이 각자 남을수있음<br>
               <h4>회의 결과</h4>
                개인 공부에 더 집중하기로 결정<br>
                ->향후 프로젝트들에 있어 가장 큰 도움이 될이라 판단<br>              
                체계적인 관리를 위해 루틴을 정함<br>  
                -> 매일 오후 5시 공부 내용 푸쉬<br>  
                <h3>나의 공부 방향</h3>
                <h4>백엔드(자바,스프링,데이터베이스)에 집중해보고 싶음</h4>
                <h4>쇼핑몰 기본적인 로직 구현해보기 </h4>
                ex)상품 등록 , 상품 담기 , 상품 조회 , 상품 삭제 , 로그인 기능
      </details>
      <details>
          <summary><b>ㅤ25/01/06/월: </b></summary>	
          ㅤㅤㅤ내용
      </details>
</details>
