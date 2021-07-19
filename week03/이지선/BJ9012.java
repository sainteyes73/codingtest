package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) throws Exception{
        //(((는 넣고 ) 나오면 빼고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            if(dfs(str)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }

    static boolean dfs(String[] str) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<str.length; i++) {
            if(str[i].equals("(")) {
                stack.push(str[i]);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
