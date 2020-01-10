package com.accompnay.Demo4;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();
        int sum = main.game(new int[]{2,2,3},new int[]{2,3,4});
        System.out.println(sum);
    }
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if(guess[i]==answer[i]){
                count++;
            }
        }
        return count;
    }
}
