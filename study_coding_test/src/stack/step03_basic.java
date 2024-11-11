package stack;

import java.util.Stack;
/*
 * [ 괄호 회전하기 ]
 * (),[],{}는 모두 올바른 괄호 문자열입니다.
 * 대괄호, 중괄호, 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
 * 이 s를 왼쪽으로 x칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 출력하는 함수를 완성해주세요.
 * 
 * */
public class step03_basic {
	
	// 괄호들의 짝이 맞는지 확인
	private static boolean isCorrect(char[] str,int offset) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length; i++) {
			char c = str[(offset + i) % str.length]; // offset = 0 > 그대로, offset = 1 > 한 칸 회전...
			switch(c) {
			case '(' -> stack.push(')');
			case '{' -> stack.push('}');
			case '[' -> stack.push(']');
			case ')' ,'}',']' -> { // 닫힌 괄호와 스택 맨 위에 있는 괄호가 짝이 될 수 있는지 확인
				if (stack.isEmpty()) return false; 
				if (stack.pop() != c) return false;
			}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "[](){}";
		
		char[] str = s.toCharArray();
		
		int cnt = 0;
		// offset이 0부터 s.length()까지 반복되므로 문자열을 회전시켜 검사
		for (int offset = 0; offset < str.length; offset++) {
			if(isCorrect(str, offset)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
