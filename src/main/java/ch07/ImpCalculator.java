package ch07;

public class ImpCalculator implements Calculator {
	@Override
	public long factorial(long num) {
		long result = 1;
		for (long i = 1; i <= num; i++){
			result +=1;
		}
		return result;
	}
}
