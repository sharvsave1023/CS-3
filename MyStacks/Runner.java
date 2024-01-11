import java.util.*;
public class Runner {
    public static void main(String[] args) {
        StackProbs methods = new StackProbs();

        System.out.println(methods.doubleUp(makeStack(new int[] { 1, 3, 5, 0, -1 })));
        System.out.println(methods.posAndNeg(makeStack(new int[] { 2, 9, -4, 3, -1, 0, -6 })));
        System.out.println(methods.shiftByN(makeStack(new int[] {7, 23, -7, 0, 22, -8, 4, 5}), 3));
        
        System.out.println(methods.reverseVowels("Hello how are you"));

        System.out.println(methods.bracketBalance("(([()])))"));
        System.out.println(methods.bracketBalance("([()[]()])()"));
    }

    public static Stack<Integer> makeStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums)
        stack.push(num);
        return
        stack;
    }
}
