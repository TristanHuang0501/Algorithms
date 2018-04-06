import java.util.ArrayList;
/*
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null) return null;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if(rows <= 0 || cols <=0) return null;
        
        int start = 0;  //每一行起点的位置：(1,1), (2,2), (3,3), ...
        ArrayList<Integer> result = new ArrayList<>(rows*cols);
        while((rows > start * 2) && (cols > start * 2)){
            append2Result(result, matrix, rows, cols, start);
            start ++;
        }
        return result;
    }
    
    private void append2Result(ArrayList<Integer> result, int[][] matrix, int rows, int cols, int start){
        int endX = cols-1-start;
        int endY = rows-1-start;
        
        for(int i = start; i <= endX; i++){
            result.add(matrix[start][i]);
        }
        
        if(endY > start){
            for(int i = start + 1; i <= endY; i++){
                result.add(matrix[i][endX]);
            }
        }
        
        if(endY > start && endX > start){
            for(int i = endX - 1; i >= start; i--){
                result.add(matrix[endY][i]);
            }
        }
        
        if(endX > start && endY > start + 1){
            for(int i = endY - 1; i > start; i--){
                result.add(matrix[i][start]);
            }
        }
    }
}