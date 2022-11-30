import java.util.*;

public class LC_2296_DesignaTextEditor_2 {
    
    Stack<Character> stack1;
    Stack<Character> stack2;
    
    public LC_2296_DesignaTextEditor_2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void addText(String text) {
        char[] arr = text.toCharArray();
        for (char c : arr) 
            stack1.push(c);
    }
    
    public int deleteText(int k) {
        int count = 0;
        for (int i = 0; i<k ;i++) {
            if (stack1.empty()) 
                break;
            stack1.pop();
            count++;
        }
        
        return count;
    }
    
    public String cursorLeft(int k) {
        
        for (int i = 0; i<k; i++) {    
            if (stack1.empty())
                break;   
            stack2.push(stack1.pop());
        }
        
        return this.getLeftString(stack1);
    }
    
    public String cursorRight(int k) {
        
        for (int i = 0; i<k; i++) {    
            if (stack2.empty())
                break;   
            stack1.push(stack2.pop());
        }
        
        return this.getLeftString(stack1);
    }
    
    private String getLeftString(Stack<Character> stack) {
        
        Stack<Character> tmp = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i<10; i++) {
            if (stack.empty())
                break;
            tmp.push(stack.peek());
            sb.append(stack.pop());
        }
        
        while (!tmp.empty())
            stack.push(tmp.pop());
            
        return sb.reverse().toString();
        
    }

}
