package string;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출해 그 순서대로 자연수를 만들기
 * 만약 "tge0a1h205er"에서 숫자만 추출하면 0,1,2,0,5이고 이것을 자연수를 만들면 1205가 됨
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않음
 * 
 * 입력
 * 첫 줄에 섞인 문자열 주어짐
 * 
 * 출력
 * 첫 줄에 자연수 출력
 * */
/*
 * 내 풀이
 * 1. 일단 문자열에서 숫자만 걸러내기 : Character.isDigit()
 * 2. 걸러낸 숫자 중에 첫 시작이 0이 아닌 곳 부터 끝까지 출력 : 0이 아닌 숫자가 처음으로 나오는 index 구하기
 * 
 * 다른 풀이
 * 아스키 코드를 사용한 계산으로 
 * int answer = 0;
 * for(char x : s.toCharArray()){
 * 	 if (x >=48 && x <= 57) answer = answer * 10 + (x-48);
 * }
 * 
 * -> 내 풀이로 정답은 맞췄지만 효율적으로 중복을 최소화하고 간단한 코드를 작성 할 수 있도록 학습 필요
 * */
class Main9 {
	public String solution(String str) {
		String answer = "";
		
		ArrayList<Character> arr = new ArrayList<>();
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x)) { // 문자 중 숫자인 것만 어레이에 넣기
				arr.add(x);
			}
		}
		
		int start_idx = -1;
		for (char x : arr) {
			if (x != '0') {// 0이 아닌 값을 만나면 해당 인덱스를 저장해서 break
				start_idx = arr.indexOf(x);
				break;
			}
			else continue;
		}
		
		for (int i = start_idx; i < arr.size(); i++) {
			answer += arr.get(i);
		}
		
		return answer;
	}
}
public class step01_9_String {

	public static void main(String[] args) {
		Main9 T = new Main9();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.next();
		
		System.out.println(T.solution(str));
		
	}

}
