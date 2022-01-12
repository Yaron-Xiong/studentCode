package com.accompnay.TopicAlgorithms.Stormzhang.uf;

public class UF {
	private int[] parent;
	private int[] size;
	private int count;

	public UF(int n) {
		parent = new int[n];
		size = new int[n];
		count = n;
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		//平衡优化
		if (size[p] > size[q]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		} else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		count--;
	}

	public int find(int p) {
		while (parent[p] != p) {
			//缩短链路
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}

	public int count() {
		return count;
	}
}
