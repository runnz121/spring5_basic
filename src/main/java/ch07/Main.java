package ch07;

public class Main {

	public static void main(String[] args) {
		ExeTimeCal cal1 = new ExeTimeCal(new ImpCalculator());
		System.out.println(cal1.factorial(20));

		ExeTimeCal cal2 = new ExeTimeCal(new RecCalculator());
		System.out.println(cal2.factorial(20));
	}
}
