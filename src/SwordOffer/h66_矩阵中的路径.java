package com.tristan.tcp;

import java.util.Arrays;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *     a b c e
 *     s f c s
 *     a d e e
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * =================
 * 分析：
 * =================
 *  这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。
 *  由于回朔法的递归特性，路径可以被看成一个栈。
 *  
 *  当在矩阵中定位了路径中前 n 个字符的位置之后，在与第 n 个字符对应的格子的周围都没有找到第 n+1 个字符，
 *  这个时候只要在路径上回到第 n-1 个字符，重新定位第 n 个字符。
 *
 *  由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。
 *
 *  当矩阵中坐标为（row,col）的格子和路径字符串中下标为 pathLength 的字符一样时，
 *  从4个相邻的格子： 
 *    (row,col-1),(row-1,col),
 *    (row,col+1),(row+1,col) 
 *  中去定位路径字符串中下标为 pathLength+1 的字符。
 *
 *  如果 4 个相邻的格子都没有匹配字符串中下标为 pathLength+1 的字符，
 *  表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不正确，
 *  我们需要回到前一个字符 (pathLength-1)，然后重新定位。
 *
 *  一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 */
public class Test {
    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否找到
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //参数校验
        if (matrix == null || rows < 1 || cols < 1
                || str == null || str.length < 1
                || matrix.length != rows * cols)
            return false;

        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);

        //当前搜索的str中的字符的位置
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited))
                    return true;
            }
        }

        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       行数
     * @param cols       列数
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param str        要搜索的字符串
     * @param pathLength 正在搜索中的str字符的序号
     * @param visited    访问标记数组
     * @return
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        //如果已经全部搜索完则返回
        if (pathLength == str.length)
            return true;

        boolean hasPath = false;

        //判断位置是否合法
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]){
            pathLength++;
            visited[row * cols + col] = true;

            //按左上右下的顺序进行回溯
            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row-1, col, str,pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);

            //如果基于该点没找到下面的，就把状态还原回去
            if (!hasPath){
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
