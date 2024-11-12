package dynamic_programming;

import java.util.Arrays;

/*
 * 24.11.12.화 15:08-15:11
 * 동적계획법 - 피보나치 수열
 * 상태 정의 > 종료 조건 > 점화식을 기준으로 코드를 구현했더니
 * 이전보다는 잘 짜여진 것 같다. 
 * 하지만 수식에 대한 점화식은 내가 이미 외운 수식이라 다른 규칙이 있는 수식을 구하라고 하면
 * 쉽지 않을 것 같긴 하다.
 * 
 * */
public class step01_practice1 {
	
	private static int[] mem = new int[101];
	
	public static void main(String[] args) {
		
		Arrays.fill(mem, -1);
		
		System.out.println(fibonacci(4));

	}

	private static int fibonacci(int i) {
		
		if(mem[i] != -1) return mem[i];
		if(i == 0 || i == 1) return i;
		
		return mem[i] = fibonacci(i-1) + fibonacci(i-2);
	}

}
