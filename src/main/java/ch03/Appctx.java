package ch03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appctx {

	//각 @Bean 어노테이션마다 한개의 객체를 생성한다
	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}

	//memberDao가 생성한 객체를 memberregisterservice 생성자를 통해 주입
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	//set메소드를 통해 의존 객체 주입
	@Bean
	public ChangePasswordService changePwdSvc(){
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
