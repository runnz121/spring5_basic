package ch06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {

	@Bean
	@Scope("singleton")
	public Client client() {
		Client client = new Client();
		client.sethost("host");
		return client;
	}

	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("singleton")
	public Client2 client2(){
		Client2 client2 = new Client2();
		client2.setHost("host");
		return client2;
	}
}
