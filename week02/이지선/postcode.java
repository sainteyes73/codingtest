package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class postcode {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int area = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N;i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 단지수와 단지내 영역구하기
        int count=0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<N;i++) {
            for(int j=0; j<N; j++) {
                if(check(i, j)) {
                    count ++;
                    queue.add(area);
                    area = 0;
                }

            }
        }
        System.out.println(count);
        int range = queue.size();
        for (int i=0; i<range; i++) {
            System.out.println(queue.poll());
        }
    }

    static boolean check(int x, int y) {
        if(x<0 || x>=N || y<0 || y>=N) {
            return false;
        }
        if(!visited[x][y] && map[x][y]==1) {
            visited[x][y] = true;
            area ++ ;
            check(x+1, y);
            check(x-1, y);
            check(x, y+1);
            check(x, y-1);
            return true;
        }
        return false;
    }
}
