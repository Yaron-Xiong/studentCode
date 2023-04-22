package com.accompnay.TopicAlgorithms.leetcode.weekly.w431;

public class L3 {
	public static void main(String[] args) {
		L3 l3 = new L3();
		System.out.println(l3.addMinimum("cba"));
	}
	public int addMinimum(String word) {
		int aNum = 0;
		int bNum = 0;
		int cNum = 0;
		int res = 0;
		for (int i = 0; i < word.length(); i++) {
			if (i != 0 && word.charAt(i) - word.charAt(i - 1) <= 0) {
				//开始计算 与还原
				int max = aNum;
				max = Math.max(max, bNum);
				max = Math.max(max, cNum);
				res += (max - aNum) + (max - bNum) + (max - cNum);
				aNum = 0;
				bNum = 0;
				cNum = 0;
			}
			if (word.charAt(i) == 'a') {
				aNum++;
			} else if (word.charAt(i) == 'b') {
				bNum++;
			} else {
				cNum++;
			}
		}
		if (aNum> 0 || bNum>0 || cNum> 0){
			//开始计算 与还原
			int max = aNum;
			max = Math.max(max, bNum);
			max = Math.max(max, cNum);
			res += (max - aNum) + (max - bNum) + (max - cNum);
		}
		return res;
	}
}
