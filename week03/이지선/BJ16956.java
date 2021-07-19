package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BJ16956 {
    static int R;
    static int C;
    static char[][] map;
    static int[][] move = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    static boolean check = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        map = new char[R][C];
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<R; i++) {
            String str2 = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str2.charAt(j);
                if(map[i][j] == 'W') {
                    queue.add(new Point(j, i));
                }
            }
        }


        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = point.x + move[i][0];
                int ny = point.y + move[i][1];
                dfs(nx, ny);
            }
            if(check == true) break;
        }
        if(!check) {
            System.out.println(1);
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else System.out.println(0);


    }
    static void dfs(int x, int y) {
        if(x<0 || x>=C || y<0 || y>= R) {
            return;
        }
        if(map[y][x]== 'S') {
            check = true;
            return;
        } else if(map[y][x] == '.') {
            map[y][x]  = 'D';
        }

    }
}
