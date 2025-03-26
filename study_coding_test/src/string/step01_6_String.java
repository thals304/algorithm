package string;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 문제
 * 소문자로 된 한 개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 * 
 * 입력
 * 첫 줄에 문자열이 입력됨
 * 
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력함
 * */

/*
 * 내 풀이
 * 일단 문자열을 문자 하나씩 어레이리스트에 넣고 삽입정렬의 방법처럼 본인보다 앞에 있는 문자열과 비교해서 
 * 같으면 삭제, 같은게 없으면 그대로 두기를 해주면 되지 않을까?
 * 어레이리스트의 contains를 사용해서 이전 값들이랑 중복되는 값이 있는지 없는지 확인 가능할거 같은데..
 * */
class Main6{
	public String solution(String str) {
		String answer = "";
		
		for(int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i) + " "+ i + str.indexOf(str.charAt(i))); // str.indexOf(str.charAt(i)는 본인보다 앞에 있는 중복 문자의 인덱스 값이 출력됨
			if(str.indexOf(str.charAt(i)) != i) {
				answer += str.charAt(i);
			}
		}
		
		/*
		 ArrayList<Character> arr = new ArrayList<Character>();
		
		for(char x : str.toCharArray()) {
			if(!arr.contains(x)) arr.add(x);
		}
		
		for(char x : arr) {
			answer += x;
		}*/
		
		
		return answer;
		
	}
}

public class step01_6_String {

	public static void main(String[] args) {
		Main6 T = new Main6();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();
		System.out.println(T.solution(str));
	}

}
