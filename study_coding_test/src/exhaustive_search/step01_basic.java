package exhaustive_search;
import java.util.Arrays;

/*
 * 완전 탐색
 * 시간 복잡도를 고려 하는 것이 중요 > 상태 개수인 탐색 공간에 비례 
 * 깊이 우선 탐색(DFS) > 재귀로
 * 너비 우선 탐색(BFS) > 큐로
 * */
/*
 * [ 모의고사 ]
 * 수포자 3명이 1번부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자: 1,2,3,4,5,1,2,3,4,5..
 * 2번 수포자: 2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5..
 * 3번 수포자: 3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5..
 * 1번 문제부터 마지막 문제까지 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 
 * 출력하는 함수를 작성해주세요 
 * */
public class step01_basic {

	public static void main(String[] args) {
		
			int[] solutions = {1, 2, 3, 4, 5};
			
			int[] answer = {};
			
			int[] student1 = new int[solutions.length];
			int[] student2 = new int[solutions.length];
			int[] student3 = new int[solutions.length];
			
			for (int i = 0; i < student1.length; i++) {
				student1[i] = (i % 5) + 1;
			}
			
			for (int i = 0; i < student2.length; i++) {
				if (i % 2 == 0) {
					student2[i] = 2;
				} 
				else {
					student2[i] = i % 8;
					if (student2[i] == 5) {
						student2[i] = 4;
					}
					else if (student2[i] == 7) {
						student2[i] = 5;
					}
				}
			}
			
			for (int i = 0; i < student3.length; i++) {
				if (i % 10 == 0 || i % 10 == 1) {
					student3[i] = 3;
				}
				else if (i % 10 == 2 || i % 10 == 3) {
					student3[i] = 1;
				}
				else if (i % 10 == 4 || i % 10 == 5) {
					student3[i] = 2;
				}
				else if (i % 10 == 6 || i % 10 == 7) {
					student3[i] = 4;
				}
				else if (i % 10 == 8 || i % 10 == 9) {
					student3[i] = 5;
				}
			}
			
			int cnt1 = 0;
			int cnt2 = 0;
			int cnt3 = 0;
			
			for (int j = 0; j < student1.length; j++) {
				if (student1[j] == solutions[j]) {
					cnt1 ++;
				}
			}
			
			for (int j = 0; j < student2.length; j++) {
				if (student2[j] == solutions[j]) {
					cnt2 ++;
				}
			}
			
			for (int j = 0; j < student3.length; j++) {
				if (student3[j] == solutions[j]) {
					cnt3 ++;
				}
			}
			
			int maxScore = Math.max(cnt1, Math.max(cnt2, cnt3));
			
			int count = 0;
			if (cnt1 == maxScore) count++;
			if (cnt2 == maxScore) count++;
			if (cnt3 == maxScore) count++;
			
			answer = new int[count];
			int idx = 0;
			// 가장 많은 문제를 푼 사람 배열에 저장
	        if (cnt1 == maxScore) answer[idx++] = 1;
	        if (cnt2 == maxScore) answer[idx++] = 2;
	        if (cnt3 == maxScore) answer[idx++] = 3;
	        
	        System.out.println(Arrays.toString(answer));

	}

}
