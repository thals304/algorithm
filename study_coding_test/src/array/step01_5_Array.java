package array;

import java.util.Scanner;
/*
 * 문제
 * 자연수 n이 입력되면 1부터 n까지 소수의 개수를 출력하는 프로그램을 작성하시오.
 * 만약 20이 입력되면 1부터 20까지 소수는 2,3,5,7,11,13,17,19 총 8개입니다.
 * 제한시간은 1초입니다.
 * 
 * 입력
 * 첫 줄에 자연수의 개수 n이 주어짐
 * 
 * 출력
 * 첫 줄에 소수의 개수를 출력함
 * 
 * */
/*
 * 나의 풀이
 * 1부터 입력한 숫자까지 for문 돌면서 소수인 경우의 개수를 카운트 하면 되는데..
 * 소수란, 1과 자기 자신 외에 나누어지지 않는 숫자 > 일단 2 제외 홀수이면서 3, 5, 7 로 나누어지지 않는 값
 * 근데 1초 안에 개수를 알아내야 한다라.. 
 * 
 * "에라토스테네스 체" : 배열을 0으로 전부 초기화시키고 소수인 것을 발견하면 카운트 해주고 본인의 배수들을 
 * 다 1로 체크해 걸러내는 것
 * */
class Main5{
	public int solution(int n) {
		int answer = 0; 
		
		int[] ch = new int[n + 1]; // 인덱스는 0부터 시작하므로 n번 인덱스까지 만들어야함
		
		for(int i = 2; i <= n ; i++) {
			if (ch[i] == 0) {
				answer++;
				for (int j = i; j <= n; j = j + i) { // i의 배수인 인덱스
					ch[j] = 1;
				}
			}
		}
		
		return answer;
	}
}
public class step01_5_Array {

	public static void main(String[] args) {
		Main5 T = new Main5();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		System.out.println(T.solution(n));
		

	}

}
