/**
 * 算法岗：
 *
 * 将一个圆分为N个扇形，使用M个颜色对这些扇形进行填充，相邻扇形的颜色不能相同，问：有多少种填充方式
 * 
 * 用贪婪法直接做：
 * 
 * 假设现在有n个扇形得到的方案数是a_n
 *
 * 1)现在如果第一个和第n-1个扇形是相同颜色的，那么方案数是 (m-1)*a_n-2;
 * 2)现在如果第一个和第n-1个扇形是相同颜色的，那么方案数是 (m-1)*a_n-2;
 *
 * 另一种思路：http://blog.csdn.net/u014744127/article/details/79431847
 */

public class Solution{
	public static void main(String... args){
		
	}	
}