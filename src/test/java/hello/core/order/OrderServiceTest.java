package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

//
//    MemberService memberService = new MemberServiceImpl(null);
//    OrderService orderService = new OrderServiceImpl(null,null);
//
//    @Test
//    void createOrder() {
//
//        Long memberId = 1L;
//        Member member = new Member(memberId, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(memberId, "itemA", 10000);
//        assertThat(order.getDiscountPrice()).isEqualTo(1000);
//    }

    @Test
    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl(); // 필드 주입하면 임의로 new하는 경우는 의존성 주입이 되지 않는다.
        /**
         *  순수한 자바 코드로 테스트하는 경우에 의존성 주입이 되지 않는다.
         * @SpringBootTest 를 써서 스프링 컨테이너를 모두 띄우고 등록된 빈을 불러와야 한다.
         * */
//
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        orderService.setDiscountPolicy(new FixDiscountPolicy());

//        orderService.createOrder(1L, "itemA", 10000);
    }
}
