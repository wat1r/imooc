package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompanyTest {

	public static void main(String[] args) {
		CompanyTest cb = new CompanyTest();
		cb.countScanner();
	}

	public void countScanner() {

		System.out.println("输入：");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.next();
			int res = count(str);
			System.out.println("res:" + res);
		}
		sc.close();
	}

	public int count(String str) {

		char[] chas = str.toCharArray();
		Set set = new HashSet<>();
		for (int i = 0; i < chas.length; i++) {
			set.add(chas[i]);
		}
		int size = set.size();
		if (size == 2) {
			return 2;
		} else if (size == 1) {
			return 1;
		} else {
			return 0;
		}

	}
}
