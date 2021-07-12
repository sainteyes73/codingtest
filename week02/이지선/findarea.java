package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class findarea {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int area;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        //(N, M)
        N = Integer.parseInt(str[0]); //5
        M = Integer.parseInt(str[1]); //7
        K = Integer.parseInt(str[2]);
        map = new int[N][M];
        visited = new boolean[N][M];
        //(y, x) map 만들기
        for(int k=0; k<K; k++) {
            String[] str2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(str2[0]);
            int y1 = Integer.parseInt(str2[1]);
            int x2 = Integer.parseInt(str2[2]);
            int y2 = Integer.parseInt(str2[3]);
            for (int i=x1; i<x2; i++) {
                for (int j=y1; j<y2; j++){
                    map[j][i] = 1;
                }
            }
        }
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++){
                if(check(j, i)) {
                    count ++;
                    queue.add(area);
                    area = 0;
                }
            }
        }
        System.out.println(count);
        int range = queue.size();
        for(int i= 0; i<range; i++) {
            System.out.print(queue.poll()+" ");
        }
    }

    static boolean check(int x, int y){
        if(x<0 || x>=M || y<0 || y>=N) {
            return false;
        }
        if(!visited[y][x] && map[y][x] == 0) {
            visited[y][x] = true;
            area++;
            check(x+1,y);
            check(x,y+1);
            check(x,y-1);
            check(x-1,y);
            return true;
        }
        return false;
    }
}
