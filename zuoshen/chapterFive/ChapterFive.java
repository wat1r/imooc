package zuoshen.chapter5;

public class ChapterFive {

	public static void main(String[] args) {

		// String str1 = "1232";
		// String str2 = "3112";
		// System.out.println(isDeformation(str1, str2));

		String str = "A-1CD2E--33";
		System.out.println(numSum(str));

	}

	/**
	 * 判断两个字符串是否互为变形词 P242
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isDeformation(String str1, String str2) {

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < chas1.length; i++) {
			map[chas1[i]]++;
		}
		for (int i = 0; i < chas2.length; i++) {
			if (map[chas2[i]]-- == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 字符串中数字子串的求和 P243
	 * 
	 * @param str
	 * @return
	 */
	public static int numSum(String str) {

		if (str == null) {
			return 0;
		}
		char[] cha = str.toCharArray();
		int num = 0;
		int res = 0;
		boolean posi = true;
		int cur = 0;
		for (int i = 0; i < cha.length; i++) {
			cur = cha[i] - '0';
			if (cur < 0 || cur > 9) {//此处一开始写成了'0' '9'
				res += num;
				num = 0;
				if (cha[i] == '-') {
					if (i - 1 > -1 && cha[i - 1] == '-') {
						posi = !posi;
					} else {
						posi = false;
					}
				} else {
					posi = true;
				}

			} else {
				num = num * 10 + (posi ? cur : -cur);
			}
		}
		res += num;
		return res;
	}

}
