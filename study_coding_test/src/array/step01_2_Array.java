package array;

import java.util.Scanner;

/*
 * 문제
 * 선생님이 N명의 학생을 일렬로 세웠습니다.
 * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 
 * 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을
 * 작성하시오.
 * (어떤 학생이 자기 앞에 서 있는 학생들보다 크면, 그 학생은 보이고,
 * 작거나 같으면 보이지 않음)
 * 
 * 입력
 * 첫 줄에 정수 N 입력됨
 * 그 다음 줄에 N명의 학생의 키가 앞에서부터 순서대로 주어짐
 * 
 * 출력
 * 선생님이 볼 수 있는 최대 학생 수
 * 
 * */
/*
 * 내 풀이 (insertion sort를 이용함)
 * 입력한 학생의 키를 배열에 저장해서 solution에 N과 함께 보내기
 * 이중 배열을 사용해서 본인보다 앞에 있는 n명의 학생들보다 키가 커야
 * 선생님이 보이는 것이므로 cnt를 사용해 인덱스 수와 비교해서 같을 경우
 * 선생님이 보이는 것, 같지 않으면 선생님이 보이지 않는 것 
 * (단, 맨 앞에 서있는 애는 무조건 선생님이 보임)
 * 
 * 더 간단한 방법
 * 단순 max값을 std[0]으로 한 후 for문의 i 시작을 1부터 해서
 * 크면 answer ++; 해서 최대값을 사용해서
 * 어차피 앞에 숫자보다 크다는 전제가 이미 깔린 것을 이용 
 * */
class Main2{
	public int solution(int N, int[] std) {
		
		int answer = 1;
		
		for(int i = 1; i < N; i++) {
			int cnt = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(std[i] > std[j]) {
					cnt++;
				}
			}
			if(cnt == i) {
				answer ++;
			}
		}
		
		/*
		int max = std[0];
		for (int  i = 1; i < N; i++) {
			if(std[i] > max) {
				answer ++;
				max = std[i];
			}
		}
		*/
		
		return answer;
	}
}

public class step01_2_Array {

	public static void main(String[] args) {
		
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		int[] std = new int[N];
		
		for(int i = 0; i < std.length; i++) {
			std[i] = kb.nextInt();
		}

		System.out.println(T.solution(N, std));
	}

}
