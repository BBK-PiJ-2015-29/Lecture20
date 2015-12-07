package src;

import java.util.function.*;
import java.util.stream.*;
public class Factorials {
	public static final int LIMIT = 100;
	
	public static void main(String[] args) {
		System.out.println(timer(25, Factorials::factorialRecursive));
		System.out.println(timer(25, Factorials::factorialIterative));
		System.out.println(timer(25, Factorials::factorial));
		
		
	}
	
	public static long factorialRecursive(int n) {
		if(n > LIMIT) throw new IllegalArgumentException(n + " is out of range.");
		return (1 > n) ? 1 : n * factorialRecursive(n-1);
		
		
	}
	
	public static long factorialIterative(int n) {
		if(n > LIMIT) throw new IllegalArgumentException(n + " is out of range.");
		long total = 1;
		for (int current = 2; current <= n; current++) {
			total = total * current;
		}
		return total;
	}
	
	public static long factorial(int n) {
		if(n > LIMIT) throw new IllegalArgumentException(n + " is out of range.");
		
		// With reduce, 'a' is the result of the function each time and the preceeding 
		// '1' is the initial value of 'a'. 'b' is the value taken from 
		// the stream each time.
		return LongStream.rangeClosed(2, n).reduce(1, (a,b) -> a*b);
	}
	
	public static long timer(int i, IntFunction<Long> aMethod) {
		long result = aMethod.apply(i);
		
		return result;
	}

}