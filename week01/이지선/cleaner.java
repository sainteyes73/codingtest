import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cleaner {
    static int[][] map;
    static int move[][] = {{0,-1}, {1, 0}, {0,1}, {-1,0}};
    static int back[][] = {{1,0}, {0, 1}, {-1,0}, {0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
//        System.out.println("N"+N +"M" +M);
        String[] str2 = br.readLine().split(" ");
        int r = Integer.parseInt(str2[0]);
        int c = Integer.parseInt(str2[1]);
        int d = Integer.parseInt(str2[2]);

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] str3 = br.readLine().split(" ");

            for(int j=0; j<M; j++) {
//                System.out.println(str3[j]);
                map[i][j] = Integer.parseInt(str3[j]);

            }
        }
        clean(r, c, d);
        System.out.println(answer);
        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void clean (int row, int col, int direct) {
        //청소를 한경우 0에서 2로 변경
        if(map[row][col] == 0) {
            map[row][col] =2;
            answer ++;
        }

        for( int i=0; i<4; i++){
            if(check(row, col, direct)) {
                row = row + move[direct][0];
                col = col + move[direct][1];
                clean(row, col, turn(direct));
                return;
            }
            direct = turn(direct);
        }
        if(back(row, col, direct)) {
            row = row + back[direct][0];
            col = col + back[direct][1];
            clean(row, col, direct);
        } else return;
    }

    static boolean back(int row, int col, int direct) {
        row = row + back[direct][0];
        col = col + back[direct][1];
        return map[row][col] != 1;
    }

    static boolean check (int row, int col, int direct) {
        row = row + move[direct][0];
        col = col + move[direct][1];
        return map[row][col] == 0;
    }

    static Integer turn (int arrow){
        arrow = arrow + 1;
        if(arrow>3) return 0;
        return arrow;
    }
}

