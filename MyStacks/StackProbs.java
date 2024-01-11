import java.util.*;

public class StackProbs{

    public Stack<Integer> doubleUp(Stack<Integer> stack){
        Stack<Integer> temp1 = new Stack<>();
        while (!stack.isEmpty()) {
            temp1.push(stack.peek());
            temp1.push(stack.pop());
        }

        Stack<Integer> temp2 = new Stack<>();
        while (!temp1.isEmpty()) {
            temp2.push(temp1.pop());
        }
        return temp2;
    }

    public Stack<Integer> posAndNeg(Stack<Integer> stack){
        Stack<Integer> positive = new Stack<>();
        Stack<Integer> negative = new Stack<>();

        while(stack.isEmpty() == false){
            if(stack.peek() < 0)
                negative.push(stack.pop());
            else
                positive.push(stack.pop());
        }
        while(positive.isEmpty() == false){
            negative.push(positive.pop());
        }
        return negative;
    }

    public Stack<Integer> shiftByN(Stack<Integer> stack, int n){
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> revAndComp = new Stack<>();
        while (stack.size() != n)
            tempStack.push(stack.pop());

        while (tempStack.isEmpty() == false)
            revAndComp.push(tempStack.pop());

        while (stack.isEmpty() == false)
            tempStack.push(stack.pop());

        while (tempStack.isEmpty() == false)
            revAndComp.push(tempStack.pop());

        return revAndComp;

    }

    public String reverseVowels(String str){
        Stack<Character> vowels = new Stack<>();
        Stack<Character> string = new Stack<>();
        String s = "";
        for(int i = 0; i < str.length(); i++){
            if (isAVowel(str.charAt(i))) {
                vowels.push(str.charAt(i));
            }
            string.push(str.charAt(i));
        }

        Stack<Character> temp = new Stack<>();
        while (string.isEmpty() == false)
            temp.push(string.pop());

        while (temp.isEmpty() == false){
            if(isAVowel(temp.peek()) == true){
                s += vowels.pop();
                temp.pop();
            } 
            else{
                s += temp.pop();
            }
        }
        return s;
    }

    private boolean isAVowel(Character ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean bracketBalance(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } 
            
            else if(!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '('|| s.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

}