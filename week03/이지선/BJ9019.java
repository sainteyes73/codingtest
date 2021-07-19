package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Visit {
    int start;
    int end;
    String dep;

    public Visit(int start, int end, String dep) {
        this.start = start;
        this.end = end;
        this.dep = dep;
    }
}

public class BJ9019 {
    static int A;
    static int B;
    static String[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        arr = new String[N];
        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            list [i][0] =  Integer.parseInt(str[0]);
            list [i][1] = Integer.parseInt(str[1]);
        }

        for(int i=0; i<N; i++){
            bfs(i, list[i][0], list[i][1], "");
            System.out.println(arr[i]);
        }


    }
    static void bfs(int index, int start, int end, String depth) {
        Queue<Visit> queue = new LinkedList<>();
        queue.offer(new Visit(start, end, depth));
        boolean[] visited = new boolean[10001];
        while(!queue.isEmpty()) {
            Visit visit = queue.poll();
            if(visit.start ==visit.end) {
                arr[index] = visit.dep;
                break;
            }
            int val = 0;
            val = DD(visit.start);
            if(!visited[val]) {
                visited[val] = true;
                String dep = visit.dep + 'D';
//                System.out.println("D: " + val + "dep: " + dep);
                queue.offer(new Visit(val, end, dep));
            }
            val = SS(visit.start);
            if(!visited[val]) {
                visited[val] = true;
                String dep = visit.dep + 'S';
//                System.out.println("S: " + val + "dep: " + dep);
                queue.offer(new Visit(val, end, dep));
            }
            val = LL(visit.start);
            if(!visited[val]) {
                visited[val] = true;
                String dep = visit.dep + 'L';
//                System.out.println("L: " + val + "dep: " + dep);
                queue.offer(new Visit(val, end, dep));
            }
            val = RR(visit.start);
            if(!visited[val]) {
                visited[val] = true;
                String dep = visit.dep + 'R';
//                System.out.println("R: " + val + "dep: " + dep);
                queue.offer(new Visit(val, end, dep));
            }
        }

    }
    static int DD(int start) {
        int Dn = start * 2;
        if(Dn >= 10000) return (Dn%10000);
        return Dn;
    }

    static int SS(int start) {
        if(start == 0) return 9999;
        return start-1;
    }

    static int LL(int start) {
        int[] arr = new int [4];
        arr[0] = start % 10; //1의 자리수
        arr[1] = (start % 100)/10;
        arr[2] = (start % 1000)/100;
        arr[3] = (start % 10000)/1000;
        return (((arr[2] * 10) + arr[1])*10 + arr[0])*10 + arr[3];
    }
    static int RR(int start) {
        int[] arr = new int [4];
        arr[0] = start % 10; //1의 자리수
        arr[1] = (start % 100)/10;
        arr[2] = (start % 1000)/100;
        arr[3] = (start % 10000)/1000;
        return (((arr[0] * 10) + arr[3])*10 + arr[2])*10 + arr[1];
    }
}
