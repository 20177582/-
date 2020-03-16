import java.util.Scanner;
public class first {
    static int[][] maze;
    //迷宫矩阵
    static int n;
    //矩阵大小
    static int min;
    //最短步长

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        min = n * n;
        maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        recursion(1, 1, 0);
        //起始点为（1,1），初始步长为0
        if (min == n * n) {
            System.out.println("No solution");
        } else {
            System.out.println(min);
        }
    }

    public static void recursion(int x, int y, int count) {
        if (x==n-2&&y==n-2)
            //跳出条件，走到该点为终点
        {
            min = Math.min(count, min);
        } else {
            maze[x][y] = 1;
            //走过的位置不能重复走，故而走过就为1
            if (y < n - 1 && maze[x][y + 1] == 0) {
                recursion(x, y + 1, count + 1);
                //向右走
            }
            if (x < n - 1 && maze[x + 1][y] == 0) {
                recursion(x + 1, y, count + 1);
                //向下走
            }
            if (x > 1 && maze[x - 1][y] == 0) {
                recursion(x - 1, y, count + 1);
                //向上走
            }
            if (y > 1 && maze[x][y - 1] == 0) {
                recursion(x, y - 1, count + 1);
                //向左走
            }
            //回溯，恢复原来的状态
            maze[x][y] = 0;
        }
    }
}
