package Test;


import java.util.*;

/**
 * Created by Tristan on 2018/3/26.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        int count = scanner.nextInt();
        int[] goals = new int[nums];
        for (int i = 0; i < nums; i++) {
            goals[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++) {
            String temp = scanner.nextLine();
            String[] temps = temp.split(" ");
            int a = Integer.parseInt(temps[1]);
            int b = Integer.parseInt(temps[2]);
            switch (temps[0]){
                case "Q":
                    query(goals, a, b);
                    break;
                case "U":
                    update(goals, a, b);
            }
        }
    }

    private static void update(int[] goals, int a, int b) {
        goals[a-1] = b;
    }

    private static void query(int[] goals, int a, int b) {
        int[] temps = Arrays.copyOfRange(goals, a-1, b);
        Arrays.sort(temps);
        System.out.println(temps[temps.length-1]);
    }

}
