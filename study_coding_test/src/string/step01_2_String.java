package string;

/*
 * 문제
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로
 * 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하시오
 * 
 * 입력
 * 첫 줄에는 문자열 입력
 * 문자열은 영어 알파벳으로 구성되어 있음
 * 
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열 출력
 * */

/*
 * 내 풀이 (틀린 것)
 * 결론적으로 문자열을 문자 하나씩 substring으로 잘라서
 * 대문자/소문자인지 확인 후 문자를 소문자/대문자로 교환
 * 
 * 고민 > 문자열의 대소문자 변환은 toUpperCase(), toLowerCase()인데
 * 한 문자가 대문자인지 소문자인지를 확인하는 방법에서는 어떤 것을 이용하지?
 * 일단, 문자열의 문자 1개.equals(문자열의 문자 1개를 소문자로 변환) 한 것과 같을 경우
 * 문자열의 문자 1개가 소문자인 것 / 같이 않으면 대문자인 것으로 판단 가능할 것 같음
 * -> 근데 StyDY를 입력했을 때, studytudyudydyy 로 출력이 됨
 * -> substring(i)은 자르는 것이긴 한데 i부터 문자열 끝까지를 출력하는 것임
 * */
import java.util.Scanner;

class Main2 {
	public String solution(String str) {
		String answer = "";
		
		// 방법 1 문자 어레이로 변환 후 대소문자 확인 가능
		for(char x : str.toCharArray()) {
			if (Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			}
			else{
				answer += Character.toLowerCase(x);
			}
		}
		
		// 방법 2 아스키 코드 (대문자 : 65 ~ 90, 소문자 : 97 ~ 122)
		for (char x : str.toCharArray()) {
			if (x >= 65 && x <= 90) {
				answer += (char)(x + 32);
			}
			else {
				answer += (char)(x - 32);
			}
		}
		 
		return answer;
	}
}
public class step01_2_String {

	public static void main(String[] args) {
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in); 
		
		String str = kb.next();
		
		System.out.println(T.solution(str));

	}

}
