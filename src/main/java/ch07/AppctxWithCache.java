package ch07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch07.CacheAspect;
import ch07.ExeTimeAspect;
import ch07.Calculator;
import ch07.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppctxWithCache {

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
