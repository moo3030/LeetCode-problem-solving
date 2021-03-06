package Easy.Stacks_and_Queues;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
import java.util.Stack;

public class Valid_Parentheses {

    public static boolean isClosing(char c1, char c2){
        return (c1 == ']' && c2 == '[') || (c1 == '}' && c2 == '{') || (c1 == ')' && c2 == '(');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c =='(' || c == '{')
                stack.push(c);
            else if(!stack.isEmpty() && isClosing(c, stack.peek()))
                stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
