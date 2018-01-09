package com.alogrithm.tire;

public class Tire {

	private TireNode root;

	public Tire(TireNode root) {
		this.root = new TireNode();
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		char[] chas = word.toCharArray();
		TireNode node = root;
		int index = 0;
		for (int i = 0; i < chas.length; i++) {
			index = chas[i] - 'a';
			if (node.map[index] == null) {
				node.map[index] = new TireNode();
			}
			node = node.map[index];
			node.path++;

		}
		node.end++;
	}

	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		char[] chas = word.toCharArray();
		TireNode node = root;
		int index = 0;
		for (int i = 0; i < chas.length; i++) {
			index = chas[i] - 'a';
			if (node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		return node.end != 0;

	}

	public void delete(String word) {
		if (search(word)) {
			char[] chas = word.toCharArray();
			TireNode node = root;
			int index = 0;
			for (int i = 0; i < chas.length; i++) {
				index = chas[i] - 'a';
				if (node.map[index].path-- == 1) {
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}

}
