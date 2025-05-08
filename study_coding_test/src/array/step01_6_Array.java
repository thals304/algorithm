package array;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 
 * 그 소수를 출력하는 프로그램을 작성하시오.
 * 예로 들어 32를 뒤집으면 23, 23은 소수이다. 그러면 23을 출력한다.
 * 단 910을 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 * */
/*
 * 내 풀이
 * 1. for문을 돌면서 각 인덱스의 값을 reverse하기
 * 2. 해당 숫자가 소수인지 확인 
 * 3. 소수이면 어레이리스트에 넣기
 * 
 * 해당 값이 소수인지 확인하는 방법 -> 소수 : 1과 자기 자신으로만 나누어 떨어지는 수 (1은 소수가 아님)
 * */
class Main6{
	public boolean isPrime(int num) { // 소수인지 확인하는 함수
		
		if (num == 1) return false;
		for(int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		// 숫자 뒤집는 방법
		for(int i = 0; i < n; i++) {
			int tmp = arr[i];
			int res = 0;
			while(tmp > 0) {
				int t = tmp % 10;
				res = res * 10 + t;
				tmp = tmp / 10;
			}
			
			if (isPrime(res)) {
				answer.add(res);
			}
		}
		
		return answer;
	}
}
public class step01_6_Array {

	public static void main(String[] args) {
		Main6 T = new Main6();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		
		for (int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}
