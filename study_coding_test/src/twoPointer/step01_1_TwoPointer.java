package twoPointer;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제
 * 두 배열 합치기
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요
 * 
 * 입력
 *  첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

	두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
	
	세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
	
	네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
	
	각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
	
	출력
	오름차순으로 정렬된 배열을 출력합니다.
	
 * */

/*
 * 내 풀이 (함수를 모르면 풀기 쉽지 않음 & 문제 의도가 함수 사용이 아닐 수도)
 * 
 * 배열로 한다고 하면, 배열의 크기는 두 배열의 크기 N + M
 * -> 오름차순으로 된 배열을 합치는 방법 (함수) : Arrays.sort() -> 이걸 물어보는 문제가 아님
 * 
 * 투포인터로 O(n)으로 코드 짜기
 * 투 포인터란? 특정 조건을 만족하는 부분 구간'**을 효율적으로 탐색하는 알고리즘(정렬되어 있을 때 주로 사용)
 * 두 배열 a, b가 있고 크기가 각각 n, m이라고 할 때 
 * p1 = 0, p2 = 0으로 a[p1], b[p2]는 포인터 값을 말함 (단, p1 < n, p2 < m)
 * a[p1], b[p2]을 비교해 작은 값을 answer 어레이 리스트에 넣고, 작은 값의 p를 1 증가!!
 * 
 * */
/*class Main{
	public int[] solution(int num1, int[] arr1, int num2 ,int[] arr2) {
		// 오름차순으로 된 배열을 합친다
		int[] answer = new int[num1 + num2];
		
		for (int i = 0; i < num1; i++) {
			answer[i] = arr1[i];
		}
		
		int j = 0;
		for (int i = num1; i < answer.length ; i++) {
			answer[i] = arr2[j];
			j++;
		}
		
		Arrays.sort(answer);
		
		return answer;
	}
}
*/

class Main{
	public ArrayList<Integer> solution(int n, int[] a, int m ,int[] b) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		int p1 = 0, p2  = 0;
		
		// 조건 p1 < n && p2 < m 으로 둘 중 하나라도 n, m과 같거나 커지면 한 쪽의 배열이 끝났음을 의미
		while(p1 < n && p2 < m) {
			if (a[p1] < b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
			
		}
		
		while(p1 < n) answer.add(a[p1++]); // p1이 남아있다는 의미
		while(p2 < m) answer.add(b[p2++]); // p2가 남아있다는 의미
			
		return answer;
	}
}


public class step01_1_TwoPointer {

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = kb.nextInt();
		}
		
		int m = kb.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, a, m, b)) {
			System.out.println(x+ " ");
		}
		
		
	}

}
