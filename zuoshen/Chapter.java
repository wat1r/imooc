package com.alogrithm.review;

public class Chapter {

	public static void main(String[] args) {
		Chapter chapter = new Chapter();

		// String str = "()()((())";
		// chapter.isValid(str);

		// String str = "()(())";
		// chapter.maxLength(str);

		// String str = "aaABCDEcBCg";
		// chapter.pointNewChar(str, 4);

		// int n = 123455321;
		// chapter.isPalindrome(n);
		// String str = "abcb";
		// char[] chas = str.toCharArray();
		// chapter.isUnique1(chas);
		
		String[] strs= {"1","A","B","D","2","E","1"};
		chapter.minDistance(strs, "1", "2");
		
		
		

	}

	public int minDistance(String[] strs, String str1, String str2) {
		if (str1 == null || str2 == null) {
			return -1;
		}

		if (str1.equals(str2)) {
			return 0;
		}

		int last1 = -1, last2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(str1)) {
				min = Math.min(min, last2 == -1 ? min : i - last2);
				last1 = i;
			}
			if (strs[i].equals(str2)) {
				min = Math.min(min, last1 == -1 ? min : i - last1);
				last2 = i;
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;

	}

	public int getIndex(String[] strs, String str) {

		int left = 0;
		int right = strs.length - 1;
		int res = -1;
		int i = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				right = mid - 1;
			} else if (strs[mid] != null) {
				if (strs[mid].compareTo(str) < 0) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				i = mid;
				while (strs[i] == null && --i >= left)
					;
				if (i <= left || strs[i].compareTo(str) < 0) {
					left = mid + 1;
				} else {
					res = strs[i].equals(str) ? i : res;
					right = i - 1;
				}

			}

		}

		return res;

	}

	public boolean isUnique1(char[] chas) {

		if (chas == null) {
			return true;
		}

		boolean[] map = new boolean[256];
		for (int i = 0; i < chas.length; i++) {
			if (map[chas[i]]) {
				return false;
			}
			map[chas[i]] = true;
		}

		return true;

	}

	public boolean isPalindrome(int n) {
		if (n == Integer.MIN_VALUE) {
			return false;
		}

		n = Math.abs(n);
		int help = 1;
		while (n / help >= 10) {
			help *= 10;
		}
		while (n != 0) {
			if (n / help != n % 10) {
				return false;
			}
			n = (n % help) / 10;
			help /= 100;
		}
		return true;
	}

	public String pointNewChar(String s, int k) {

		if (s == null || "".equals(s) || k < 0 || k >= s.length()) {
			return "";
		}
		char[] chas = s.toCharArray();
		int uNum = 0;

		for (int i = k - 1; i >= 0; i--) {
			if (!isUpper(chas[i])) {
				break;
			}
			uNum++;
		}

		if ((uNum & 1) == 1) {
			return s.substring(k - 1, k + 1);
		}

		if (isUpper(chas[k])) {
			return s.substring(k, k + 2);
		}
		return String.valueOf(chas[k]);
	}

	private boolean isUpper(char c) {
		if (c >= 65 && c <= 96) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isValid(String str) {

		if (str == null || str.equals("")) {
			return false;
		}

		char[] chas = str.toCharArray();
		int status = 0;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != '(' && chas[i] != ')') {
				return false;
			}
			if (chas[i] == ')' && --status < 0) {
				return false;
			}
			if (chas[i] == '(') {
				status++;
			}
		}

		return status == 0;

	}

	public int maxLength(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < dp.length; i++) {
			if (chas[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chas[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}

}
