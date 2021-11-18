package ch02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		//이 객체는 자바 설정에서 정보를 읽어옴
		AnnotationConfigApplicationContext ctx =
			//AppContext.class 생성자를 파라미터로 전달 -> 여기서 @Bean으로 설정한 정보를 읽어와
			//Gretter 객체를 생성하고 초기화한다
			new AnnotationConfigApplicationContext(AppContext.class);
		//getBean 메서드는 빈 객체를 검색할 떄 사용
		//첫번째 인자는 빈 객체 이름, 두 번쨰 인자는 검색할 빈 객체 타입
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
