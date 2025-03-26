package string;

import java.util.Scanner;
/*
 * 문제
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수 문자는 자기 자리에 그대로 있는
 * 문자열을 만들어 자기 자리에 있는 그대로 문자열을 만들어 출력하는 프로그램을 작성하세요.
 * (둘 다 알파벳인 경우만 뒤집기)
 * 
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어짐
 * 
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열 출력
 * */
/*
 * 내 풀이
 * 사실 저번 step01_4에서 다뤘던 거 같은데 풀이가 기억에 나지 않는다.
 * 문자열을 문자 배열로 만들어서 배열 처음 인덱스부터 알파벳인지 조건문으로 확인해서 
 * 씽으로 마주보는 문자가 서로 알파벳이면 위치 바꾸고, 그렇지 않으면 그대로 두기
 * 
 * */
class Main5{
	public String solution(String str) {
		String answer = "";
		
		char[] ch = str.toCharArray();
		
		int lt = 0; // 첫번째 문자
		int rt = ch.length - 1; // 마지막 문자
		while(lt < rt) {
			if(!Character.isAlphabetic(ch[lt])) { // 특수문자인 경우
				lt ++; 
			}
			else if(!Character.isAlphabetic(ch[rt])) { // 특수문자인 경우
				rt --;
			}
			else { // 둘다 알파벳인 경우 위치 바꾸기
				char tmp = ch[lt];
				ch[lt] = ch[rt];
				ch[rt] = tmp;
				lt ++;
				rt --;
				
			}
			
		}
		
		// Char -> String 으로 변환
		answer = String.valueOf(ch);
		
		return answer;
	}
}
public class step01_5_String {

	public static void main(String[] args) {
		Main5 T = new Main5();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.println(T.solution(str));
		

	}

}
