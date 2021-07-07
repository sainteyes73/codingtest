package programmers;

public class targetnumber {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int answer;
        answer = bfs(numbers, target, 0, 0);
        System.out.println("answer" + answer);

    }
    static int bfs (int[] numbers, int target,  int sum, int count) {
        System.out.println("sum" + sum);
        int answer01 = 0;
        int answer02 = 0;
        if(numbers.length == count) {
            if(sum == target) {
                return 1;
            } return 0;
        }
        answer01 = bfs(numbers, target, sum + numbers[count], count+1);
        answer02 += bfs(numbers, target, sum - numbers[count], count+1);
        return answer01 + answer02;
    }
}
