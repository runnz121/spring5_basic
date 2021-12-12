package ch07;

import org.springframework.context.annotation.Bean;

public class AppCtxWithCache1 {


	@Bean
	public CacheAspect cacheAspect(){
		return new CacheAspect();
	}

	@Bean
	public ExeTimeAspect exeTimeAspect(){
		return new ExeTimeAspect();
	}

	@Bean
	public Calculator calculator(){
		return new RecCalculator();
	}
}
