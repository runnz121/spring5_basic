package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {
	public static void main(String[] args) throws IOException {
		BufferedReader reader =
			new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("명령어를 입력하세요");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			if (command.startsWith("new")) {
				proccessNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
		}
		printHelp();
	}

	private static Assembler assembler = new Assembler();

	private static void proccessNewCommand(String[] arg){
		if (arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmaPassword(arg[4]);

		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호가 일치하지 않습니다 \n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("register complete \n");
		} catch (DuplicateMemberException ex) {
			System.out.println("Email already exist");
		}
	}

	private static void processChangeCommand(String[] arg){
		if(arg.length != 4){
			printHelp();
			return;
		}
		ChangePasswordService changePasswordService =
			assembler.getPwdSvc();
		try {
			changePasswordService.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다");
		} catch (MemberNotFoundException ex) {
			System.out.println("존재하지 않은 이메일 \n");
		} catch (WrongIdPasswordException ex) {
			System.out.println("email,and password not match \n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("Wrong command check command below");
		System.out.println("how to use command");
		System.out.println("new : check email, password check");
		System.out.println("change : change email current change pass");
		System.out.println();
	}
}
