package array;

import java.util.Scanner;
/*
 * 문제
 * 피보나치 수열의 값을 구하시오
 * 
 * 입력
 * 3이상의 n값
 * 
 * 출력
 * 1 1 2 3 5 8 ....
 * 
 * */
/*
 * 내 풀이
 * 재귀로 풀었음 n이 1이나 2인 경우는 값을 1 리턴하고
 * 그렇지 않는 경우는 재귀로 n - 1 n - 2의 값을 더하도록  
 * 
 * */
class Main4{
	public int solution(int n) {
		int answer = 0;
		
		if (n == 1 || n == 2) return 1;
		else answer = solution(n - 1) + solution(n - 2);
		
		/* 방법 2 
		int[] answer2 = new int[n];
		answer2[0] = 1;
		answer2[1] = 2;
		
		for(int i = 2; i < n; i++) {
			answer2[i] = answer2[i - 1] + answer2[i - 2];
		}
		*/
		
		/* 방법 3
		int a = 1, b = 1, c;
		System.out.println(a+ " " + b + " ");
		for(int i = 2; i < n; i++) {
			c = a + b;
			System.out.println(c + " ");
			a = b;
			b = c;
		}
		*/
		
		return answer;
	}
}
public class step01_4_Array {

	public static void main(String[] args) {
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(T.solution(n));
	}

}
