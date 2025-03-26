package string;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요
 * 
 * 입력
 * 첫 줄에 자연수 N이 주어짐
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어짐 
 *(단어는 영어 알파벳으로 구성)
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집에서 출력
 * 
 * */
/*
 * 내 풀이
 * String[]에 담겨 있는 문자열을 또 다시 for문을 사용해서 
 * 거꾸로 문자열.length()-1 부터 0까지 새로운 문자열 배열에 
 * 넣으려고 했는데 null로 나오네...
 * > tmp를 사용해서 arr[0]의 charAt(length - 1..0)까지 
 * 저장한 후 answer[0]에 tmp를 넣으니 해결
 * 아니면 substring을 사용해서 거꾸로 출력이 불가능 한가?
 * */
class Main4 {
	public String[] solution(int n, String[] arr) {
		String[] answer = new String[n];
		
		for(int i = 0; i < answer.length; i++) {
			String tmp = "";
			for(int j = arr[i].length() - 1; j >= 0; j--) {
				tmp += arr[i].charAt(j);
			}
			answer[i] = tmp;
		}
		
		/*
		// 방법 2 SringBuilder 객체 사용
		ArrayList<String> answer1 = new ArrayList<>();
		for(String x : arr) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer1.add(tmp);
		}
		*/
		
		ArrayList<String> answer1 = new ArrayList<>();
		for(String x : arr) {
			char[] s = x.toCharArray(); // 문자 배열화
			int lt = 0; 
			int rt = x.length() - 1; // 문자열의 맨 마지막 문자 인덱스 번호
			
			while(lt < rt) {
				char tmp = s[rt];
				s[rt] = s[lt];
				s[lt] = tmp;
				lt ++;
				rt --;
			}
			String tmp = String.valueOf(s); // 다시 문자열으로 변환
			answer1.add(tmp);
			
		}
		
		
		return answer;
	}
}
public class step01_4_String {

	public static void main(String[] args) {
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		String[] arr = new String[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = kb.next();
		}
		
		for(String x : T.solution(n, arr)) {
			System.out.println(x);
		}

	}

}
