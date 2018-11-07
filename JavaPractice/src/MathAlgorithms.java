
public class MathAlgorithms {

	public static void main(String[] args) {
		//check isNumPrime method
		int primeCheck = 611951;
		boolean isPrime = isNumPrime(primeCheck);
		System.out.println("Checking isNumPrime for " + primeCheck + ":  " + isPrime);
		int factorialCheck = 20;
		long myFactorial = factorial(factorialCheck);
		String longFactorial = bigFactorial(factorialCheck);
		System.out.println("Checking factorial for " + factorialCheck + ": " + myFactorial);
		System.out.println("Checking bigFactorial for " + factorialCheck + ": " + longFactorial);
		int fibTest = 10;
		long myFib = fibonacci(fibTest);
		System.out.println("Checking fibonacci term " + fibTest + ":  " + myFib);
	
	
	}
	
	public static boolean isNumPrime(int number) {
		if (number <= 1) {
			return false;
		}
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= number; i = i + 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long factorial(int number) {
		if (number <= 1) {
			return 1;
		}		
		return number * factorial(number - 1);
	}
	
	public static String bigFactorial(int number) {
		int[] result = new int[100];
		result[0] = 1;
		int resultSize = 1;
		
		for (int x = 1; x <= number; x++) {
			resultSize = multiply(result, resultSize, x);
		}
		
		StringBuilder answer = new StringBuilder();
		for (int i = resultSize-1; i >=0; i--) {
			answer.append(Integer.toString(result[i]));
		}
		return answer.toString();
	}
	
	private static int multiply(int[] result, int resultSize, int num) {
		int carryover = 0;
		for (int i = 0; i < resultSize; i++) {
			int product = num * result[i] + carryover;
			result[i] = product % 10;
			carryover = product / 10;
		}
		while (carryover > 0) {
			result[resultSize] = carryover % 10;
			carryover = carryover / 10;
			resultSize++;
		}
		
		return resultSize;
	}
	
	public static long fibonacci(int n) {
		long[] fib = new long[n+1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];
	}
	
	public static int[] polynomialMultiply(int[] a, int[] b, int n) {
		int[] product = new int[2*n - 1];
		for(int i = 0; i < product.length; i++) {
			product[i] = 0;
		}
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				product[j + k] = product[j + k] + (a[j] * b[k]);
			}
		}
		return product;
	}
}
	


