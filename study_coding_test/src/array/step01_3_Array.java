package array;

import java.util.Scanner;

/*
 * 문제
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 해서
 * A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우 D를
 * 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
 * 두 사람의 각 회의 가위,바위, 보 정보가 주어지면 각 회를 누가 이겼는지
 * 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫 번째 줄에 게임 횟수인 자연수 N
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보 N개
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보 N개
 * 
 * 출력
 * 각 회를 누가 이겼는지 출력
 * 
 * */
/*
 * 내 풀이
 * A, B가 낸 가위바위보 N개를 각각 배열에 담아
 * solution 메서드로 보낸 후, for문을 돌면서
 * answer 배열에 이기거나 비겼을 경우의 정보 담아서
 * return 하면 될 듯 
 * 
 * */
class Main3 {
	public String[] solution(int n, int[] a, int[] b) {
		String[] answer = new String[n];
		
		// 가위:1, 바위:2, 보: 3
		// A가 이길 경우 > (1,3) || (2,1) || (3:2)
		// 비길 경우 > (1,1) || (2,2) || (3,3)
		// A가 질 경우 > (1,2) || (2,3) || (3,1)
		for(int i = 0; i < answer.length; i++) {
			if ((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2)) {
				answer[i] = "A";
			}
			else if (a[i] == b[i]) {
				answer[i] = "D";
			}
			else {
				answer[i] = "B";
			}
		}
		
		return answer;
	}
}
public class step01_3_Array {

	public static void main(String[] args) {
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = kb.nextInt();
		}
		
		for(int i = 0; i < b.length; i++) {
			b[i] = kb.nextInt();
		}
		
		for(String x : T.solution(n, a, b)) {
			System.out.print(x);
		}
	}

}
