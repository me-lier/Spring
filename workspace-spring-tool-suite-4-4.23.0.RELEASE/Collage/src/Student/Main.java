package Student;

import java.util.*;

public class Main {
	static boolean parenthesis(String s) {
		Stack<Character> stack=new Stack<>();
		int idx=0;
		for(char ch: s.toCharArray()) {
			if(ch=='(' || ch=='{' || ch=='[') {
				stack.push(ch);
			}else if(ch==')'|| ch=='}' || ch==']') {
				if(stack.isEmpty() || !Missingpair(stack.pop(),ch)) {
					return false;
				}
				idx++;
			}
		}
		System.out.println(idx);
		return stack.isEmpty();
		
	}
	
	static boolean Missingpair(char open, char last) {
		if((open=='{' && last=='}') || (open=='(' && last==')') || (open=='[' && last==']')){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		System.out.print("Enter the Parenthesis:- ");
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		if(parenthesis(s)) {
			System.out.println("yes");
		}else {
			System.out.println("No");
		}
		sc.close();
		
	}

}