package programmers;

import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

class Word {
    String word;
    int count;
}
public class changeword {
    //작은수 찾기
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        int count = 0;
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        boolean[] visited = new boolean[words.length];
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        if(list.contains(target)) {
            dfs(words, begin, target,visited, count);
        }
        System.out.println("answer" + answer);

    }
    static boolean onedif(String word1, String word2) {
        String[] w1 = word1.split("");
        String[] w2 = word2.split("");
        int count = 0;
        for(int i=0; i<w1.length; i++) {
            if(!w1[i].equals(w2[i])) {
                count++;
            }
        }
        if (count ==1) return true;
        return false;
    }
    static void dfs(String[] words, String begin, String target, boolean[] visited, int count) {
        Queue<Word> pq = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        if(begin.equals(target)) {
            if(answer>= count) answer = count;
            return;
        }

        for(int i=0; i< words.length; i++) {
            if(!visited[i] && onedif(words[i], begin)){
                visited[i] = true;
                dfs(words, words[i], target, visited, count+1);
                visited[i] = false;
//                System.out.println("i: "+ i+"count" + count);
            }
        }
    }
}
