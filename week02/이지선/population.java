package coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class State {
    int x;
    int y;

    public State(int i, int j) {
        this.y = j;
        this.x = i;
    }

}

public class population {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static int[][] move = {{0,1}, {-1, 0}, {0,-1}, {1,0}};
    static int[][] visited;
    static int num;
    static int count = 1;
    static Queue<State> position = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N= Integer.parseInt(str[0]);
        L= Integer.parseInt(str[1]);
        R= Integer.parseInt(str[2]);
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] str1 = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str1[j]);
            }
        }

        int answer = 0;
        while(true) {
            visited = new int[N][N];
            int moving = 0;
            count = 1;

            //인구 이동 그룹(count) 확인 및 위치 저장
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j] == 0) {
//                        System.out.println(i + "j: " + j);
                        check(i, j);
                        int size = position.size();
//                        System.out.println("size" + size);
                        if(size>1) {
                            moving ++;
//                            System.out.println("map change");
                            int change = Math.abs(num/size);
//                            System.out.println("change" + change);
                            for(int k=0; k<size; k++) {
                                State state = new State(-1, -1);
                                state = position.poll();
//                                System.out.println("y: " + state.y + "x" + state.x);
                                map[state.y][state.x] = change;
                            }
                        }
                        count ++;
//                        System.out.println("count" + count);
                    }
                }
            }
            //while 문 벗어나기

            if(moving == 0) {
                break;
            }
            answer ++;
//
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("================");
        }
        System.out.println(answer);

    }


    static boolean range(int x, int y, int popul) {
        if(x<0 || x>=N || y<0 || y>= N ) {
            return false;
        }
        int a = Math.abs(popul - map[y][x]);
        return (L <= a && a<= R);
    }
    static void check(int x, int y) {
        if(x<0 || x>=N || y<0 || y>= N || visited[y][x] != 0) {
            return;
        }
        //초기화
        num = 0;
        Queue<State> queue = new LinkedList<>();
        position.clear();

        queue.add(new State(x, y));
        position.add(new State(x, y));
        num += map[y][x];
        visited[y][x] = count;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            int nx = state.x;
            int ny = state.y;
            for(int i=0; i<4; i++) {
                int ay = ny + move[i][0];
                int ax = nx + move[i][1];
                if(range(ax, ay, map[ny][nx]) && visited[ay][ax] == 0){
//                    System.out.println("Ax" + ax + "ay: " +ay);
                    queue.add(new State(ax, ay));
                    num += map[ay][ax];
                    visited[ay][ax] = count;
//                    System.out.println("num" + num);
                    position.add(new State(ax, ay));
                }
            }
        }
    }
}
/*
2 10 20
0 30
50 10
3
 */