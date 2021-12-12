package ch07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppCtxWithCache1.class);

		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(7);
		cal.factorial(7);
		cal.factorial(6);
		cal.factorial(5);
		ctx.close();
	}
}
