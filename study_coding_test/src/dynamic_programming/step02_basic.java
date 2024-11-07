package dynamic_programming;

import java.util.Arrays;

/* 
 * [ 피보나치 수 ]
 * 피보나치에서 2이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하는 함수를 완성하시오 
 * 	- 조건
 * 		- n은 2이상 100,000 이하의 자연수
 * 
 * */
public class step02_basic {
	private static long[] mem = new long[100001];
	
	private static long fibonacci(int n) {
		
		if (n == 0 || n == 1) return n;
		if (mem[n] != -1) return mem[n];
		
		return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
	}
	
	
	public static void main(String[] args){
		Arrays.fill(mem, -1);
		
		int n = 200; 
		for (int i = 2; i <= n; i++) {
			System.out.println(i + "의 결과값 : " + fibonacci(i));
			System.out.println();
		}
	}
}
