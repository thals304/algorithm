package dynamic_programming;

import java.util.Arrays;

// 동적 프로그래밍 - 피보나치 수열
/*
 * [ 동적프로그래밍의 핵심 - 메모이제이션 ]
 * 
 * - 한 번 풀었던 문제에 대한 답을 저장해 놓았다가 해당 부분 문제를 다시 풀 일이 생기면 재사용 하는 것
 * - 재귀 구현 후 메모리제이션
 * 	- 문제에서 제시된 범위에 따라 메모이제이션 배열 선언과 초기화
 *  - 재귀의 종료 조건에 메모이제리션 조건 추가
 * 	- 부분 문제에 대한 답을 구한 후 메모이제이션 배열에 기록
 * 
 * */


public class step01_basic {
	private static int calls = 0; // 호출 횟수를 카운트 하기 위함
	private static final long[] mem = new long[101]; // 메모이제이션 배열
	
	private static long fibonacci(int n) {
		calls ++;
		
		if (mem[n] != -1) return mem[n]; // 이미 계산된 결과를 재사용
		if (n == 0 || n == 1) return n;
		
		return mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Arrays.fill(mem, -1); // 배열 초기화
		
		System.out.println(fibonacci(10));
		System.out.println("호출수"+ calls);
	}

}
