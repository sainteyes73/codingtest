import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cleaner {
    static int[][] map;
    static int move[][] = {{-1,0}, {0, 1}, {1,0}, {0,-1}}; //북 동 남 서
    static int answer = 0;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
//        System.out.println("N"+N +"M" +M);
        String[] str2 = br.readLine().split(" ");
        int r = Integer.parseInt(str2[0]);
        int c = Integer.parseInt(str2[1]);
        int d = Integer.parseInt(str2[2]);

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            String[] str3 = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str3[j]);

            }
        }
        clean(r, c, d);
        System.out.println(answer);

    }
    static void clean (int row, int col, int direct) {
        //청소를 한경우 0에서 2로 변경

        if(map[row][col] == 0) {
            map[row][col] =2;
            answer ++;
        }

        for( int i=0; i<4; i++){
            if(check(row, col, turn(direct))) {

                row = row + move[turn(direct)][0];
                col = col + move[turn(direct)][1];
                clean(row, col, turn(direct));
                return;
            }
            direct = turn(direct);
        }

        if(back(row, col, direct)) {
            int backdirect = (direct + 2) % 4;
            row = row + move[backdirect][0];
            col = col + move[backdirect][1];
            clean(row, col, direct);
        } else return;
    }
    // 북이면 남쪽으로 0이면 2로
    static boolean back(int row, int col, int direct) {
        direct = (direct + 2) % 4;
        row = row + move[direct][0];
        col = col + move[direct][1];
        return map[row][col] != 1;
    }

    static boolean check (int row, int col, int direct) {
        row = row + move[direct][0];
        col = col + move[direct][1];
        return map[row][col] == 0;
    }
    //북 >> 서 0이면 3
    static Integer turn (int arrow){
        arrow = (arrow + 3) %4;
        return arrow;
    }
}
/*
9 7
6 2 1
  0 1 2 3 4 5 6
0 1 1 1 1 1 1 1
1 1 2 1 0 1 0 1
2 1 2 1 0 0 0 1
3 1 2 1 0 1 0 1
4 1 2 1 1 1 1 1
5 1 2 2 2 2 2 1
6 1 2 2 1 1 2 1
7 1 2 2 2 2 2 1
8 1 1 1 1 1 1 1
>> 13
6 6
2 1 3
1 1 1 1 1 1
1 0 0 0 0 1
1 0 1 1 1 1
1 0 1 1 1 1
1 0 1 1 1 1
1 1 1 1 1 1
>>7

 */
