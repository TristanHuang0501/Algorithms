import java.util.Arrays;

public class Solution {
    public int movingCount(int threshold, int rows, int cols){
        //参数校验
        if (threshold < 0 || rows < 1 || cols < 1)
            return 0;

        boolean[] visited = new boolean[rows*cols];
        Arrays.fill(visited, false);

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    /**
     * 回溯搜索算法
     *
     * @param rows       行数
     * @param cols       列数
     * @param row        出发点 x = 0
     * @param col        出发点 y = 0
     * @param visited    访问标记数组
     * @return
     */
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;

        if(checked(threshold, rows, cols, row, col, visited)){
            visited[row * cols+col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col-1, visited)
                    + movingCountCore(threshold, rows, cols, row+1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }

    /**
     * 用来check是否可以进入坐标为（row, col）的方格，而getDigitSum()用来得到一个数字的数位之和
     * check的条件有三个：
     *      1. 该点是否有意义
     *      2. 该点数位和是否满足阈值条件
     *      3. 该点是否已经被访问过
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private boolean checked(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row)+getDigitSum(col) <= threshold
                && !visited[row * cols + col])
            return true;

        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
