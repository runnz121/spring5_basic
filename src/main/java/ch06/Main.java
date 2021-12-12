package ch06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppCtx.class);

		Client client1 = ctx.getBean("client", Client.class);
		Client client2 = ctx.getBean("client", Client.class);
		if (client1 == client2)
			System.out.println("its same");
		else
			System.out.println("not same");

		Client client = ctx.getBean(Client.class);
		client.send();
		ctx.close();


	}
}
