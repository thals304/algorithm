package stack;

import java.util.Scanner;
import java.util.Stack;

/*
 * 문제
 * 올바른 괄호
 * 괄호가 입력되면 올바른 괄호이면 "YES", 올바르지 않으면 "NO"를 출력함
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아님
 * 
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됨
 * 
 * 출력
 * 첫 번째 줄에 YES, NO 출력함
 * */

/*
 * 내 풀이
 * 스택 자료구조를 사용해 본적이 없어서 배열/리스트로 풀려고 했으나 쉽지 않음
 * 
 * 정답 풀이 (hint!)
 * Stack을 사용해서 push, pop, isEmpty 사용해서 풀어야함
 * */
class Main {
	public String solution(String str) {
		String answer = "YES";
		
		Stack<Character> stack = new Stack<>();
		
		for(char x : str.toCharArray()) { // 문자 배열 생성
			if (x == '(') stack.push(x);
			else {
				if (stack.isEmpty()) { // ')'인데 스택이 비어있으면 NO
					return "NO";
				}
				stack.pop();
			}
		}
		if(!stack.isEmpty()) return "NO"; // 수행을 다 끝냈는데 스택에 여전히 '('가 있으면 NO
		
		
		return answer;
		
	}
}
public class step01_1_stack {

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.next();
		
		T.solution(str);
		
		System.out.println(T.solution(str));
	}

}
