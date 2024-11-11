package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * [ 기능 개발 ]
 * 
 * */
public class step02_basic {

	public static void main(String[] args) {
		
		int[] progresses = {95,90,99,80,99};
		int[] speeds = {1,1,1,1,1};
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			q.add(i); // progresses, speeds 배열이 순서대로 참조할 수 있도록 큐에 인덱스 넣기
		}
		
		
		int days = 0; // 현재 시간을 나타냄
		int count = 0; // 동시 완료되는 작업 수
		
		List<Integer> result = new ArrayList<>(); // 동시 완료되는 작업 수 개수 저장 리스트
		
		while(!q.isEmpty()) {
			int index = q.poll(); // index번째 작업 검사
			int expiration = (int)Math.ceil((double)((100 - progresses[index]) / speeds[index])); // 작업해야하는 일수
			
			if (expiration > days) { // 현재 시간과 진행된 시간 비교
				if (days != 0) { // 첫 번째 작업이 아니라면, 이전 작업 그룹에서 days 기준으로 완료된 작업 수(count)를 result에 추가
					result.add(count);
					count = 0;
				}
				days = expiration;
			}
			count++;
		}
		
		result.add(count); // 마지막 작업 그룹의 count 값을 result에 추가
		
		System.out.println(result);
		
		
		

	}

}
