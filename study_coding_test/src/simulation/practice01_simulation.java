package simulation;

import java.util.ArrayList;
import java.util.Scanner;

// 문제 - 백준 톱니바퀴 (14892번)
class Main{
	public int solution(ArrayList<Integer>[] wheels, int k, Rotation[] wheelRotation) {
		int answer = 0; // 점수
		
		for(int t = 0; t < k; t++) { // k: 회전 횟수
			int num = wheelRotation[t].wheelNum - 1;
			int dir = wheelRotation[t].wheelDir; 
			
			// 0 : N, 1 : S , 시계 : 1, 반시계 : -1
			// 4개의 톱니바퀴가 연결되어 있음 
			// 1번 바퀴 [2] - 2번 [6], 2번 [2] - 3번 [6], 3번 [2] - 4번 [6]
			// 극이 같으면 본인만 회전
			// 극이 다르면 상대가 나와 다른 방향으로 회전 > 상대의 상대 ... 회전
			
			int rotateDir[] = new int[4];
			rotateDir[num] = dir; // 회전 방향 저장 (기본으로 다 0으로 저장되어 있음)
			
			// 왼쪽으로 전파 (왼쪽의 인덱스 2의 값과 본인(인덱스 6)과 비교후, 다를 경우만 방향 반대
			for(int i = num - 1; i >= 0; i++) {
				if (wheels[i].get(2) != wheels[i + 1].get(6)) {
					rotateDir[i] = - rotateDir[i + 1];
				}
				else break;
			}
			
			// 오른쪽으로 전파 (오른쪽 인덱스 6의 값과 본인(인덱스 2)과 비교후, 다를 경우만 방향 반대
			for (int i = num + 1; i < 4; i++) {
				if (wheels[i - 1].get(2) != wheels[i].get(6)) {
					rotateDir[i] = - rotateDir[i - 1];
				}
				else break;
			}
			
			for (int i = 0; i < 4; i++) {
				if (rotateDir[i] == 0) continue; // 회전 x
				else if (rotateDir[i] == 1) { // 시계
					int temp = wheels[i].remove(7);
					wheels[i].add(0, temp);
				}
				else if (rotateDir[i] == -1) { // 반시계
					int temp = wheels[i].remove(0);
					wheels[i].add(7, temp);
				}
			}
				
		}
		
		// 점수 계산
		// 각 톱니바퀴의 인덱스 0이 S이면 1,2,4,8
		if (wheels[0].get(0) == 1) answer += 1;
		if (wheels[1].get(0) == 1) answer += 2;
		if (wheels[2].get(0) == 1) answer += 4;
		if (wheels[3].get(0) == 1) answer += 8;
		
		return answer;
	}
}

class Rotation{
	int wheelNum;
	int wheelDir;
	
	public Rotation(int wheelNum, int wheelDir) {
		this.wheelNum = wheelNum;
		this.wheelDir = wheelDir;
	}
}
public class practice01_simulation {

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		ArrayList<Integer>[] wheels = new ArrayList[4]; // 4개의 톱니바퀴
		
		for (int i = 0; i < 4; i++) {
			wheels[i] = new ArrayList<>(); // add 하기 전에 필수!!
			for(int j = 0; j < 8; j++) {
				int num = kb.nextInt();
				wheels[i].add(num);
			}
		}
		
		int k = kb.nextInt();
		
		Rotation[] wheelRotation = new Rotation[k]; // 톱니바퀴의 회전
		
		for(int i = 0; i < k; i++) {
			int num = kb.nextInt();
			int dir = kb.nextInt();
			wheelRotation[i]= new Rotation(num, dir);
		}
		
		System.out.println(T.solution(wheels, k, wheelRotation));
	}

}
