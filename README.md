1월 18일 수요일 - 스프링 핵심 원리(2/8) - 기본편 객체 지향 원리 적용
- 새로운 할인 정책 개발과 테스트 - 새로운 할인 정책 요구에 따라서 DiscountPolicy라는 인터페이스를 구현한 새로운 할인 정책 클래스 RateDiscountPolicy 를 만든다.
  RateDiscountPolicy는 고객 등급(Enum)이 VIP인 경우(Grade.VIP) 물건 가격의 10%를 할인해준다.

(테스트 코드를 작성할 때는 되는 케이스와 되지 않는 케이스 모두 작성하는 것을 권장한다.)

- 새로운 할인 정책 적용과 문제점 - 새롭게 만든 할인 정책을 적용하기 위해서는 OrderServiceImpl에서 기존에 존재하던 FixDiscountPolicy를 RateDiscountPolicy로 수정해야 한다.
  → OCP(개방 폐쇄 원칙 Open Closed Principal) 원칙에 위반

기능을 확장하거나 변경하면 코드에 영향을 끼치게 된다.

또한 OrderServiceImpl이 FixDiscountPolicy라는 구체적인 클래스에 의존하고 있다 이것은 DIP(의존성 역전의 원칙)를 위배하게 된다.

→ 구현체는 추상화에 의존해야 하지만 OrderServiceImpl이라는 구현체가 구체적인 클래스에 의존하고 있는 상황

OrderServiceImpl에 있는

private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); 를

private DiscountPolicy discountPolicy; 로 수정한다.

그러면 OrderServiceImpl이 DiscountPolicy라는 인터페이스에만 의존한 상태가 된다. 하지만 구체적인 값이 존재하지 않으므로 오류가 난다.

=> 이 부분에서 의존성 주입이 생겨난다.

관심사의 분리 → AppConfig에서
public MemberService memberService(){
return new MemberServiceImpl(new MemoryMemberRepository());}




public OrderService orderService() {
return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());}


이렇게 설정을 해주면 memberService() 메서드나 , orderService() 메서드를 호출했을때 그 구현체 MemberServiceImpl이

생성된다.



public MemberServiceImpl(MemberRepository memberRepository) {
this.memberRepository = memberRepository;}


위에서 보면 MemberServiceImpl 생성자는 MemberRepository를 파라미터로 받고 그 값을 클래스의 멤버변수에 집어넣어준다. 즉 memberRepository 자리에 어떤 값이 들어오던 자유롭게 바꿀 수 있다는 뜻이다.

