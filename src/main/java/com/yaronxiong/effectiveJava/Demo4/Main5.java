package com.yaronxiong.effectiveJava.Demo4;

public class Main5 {
    public static void main(String[] args) {
        Main5 main = new Main5();
        int sum = main.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}});
        System.out.println(sum);
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            count = count + Math.min(Math.abs(points[i - 1][0] - points[i][0]),Math.abs(points[i - 1][1] - points[i][1])) + Math.abs(Math.abs(points[i - 1][0] - points[i][0])-Math.abs(points[i - 1][1] - points[i][1]));
        }
        Thread thread = new Thread();
        thread.start();
        return count;
    }
}
