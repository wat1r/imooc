package zuoshen.chapter5;

public class ChapterFive {

	public static void main(String[] args) {
		ChapterFive cf = new ChapterFive();

		// String str1 = "1232";
		// String str2 = "3112";
		// System.out.println(isDeformation(str1, str2));

		// String str = "A-1CD2E--33";
		// System.out.println(numSum(str));

		// String str = "A00B";
		// int k = 2;
		// System.out.println(removeKZeros(str, k));

		// String str = "i am Tom";
		// rotateWord(str.toCharArray());
		// String str = "ABCDEFG";
		// rotate1(str.toCharArray(), 3);

		// char[] match = { 1, 2, 3, 1, 2, 3, 1, 4, 3 };
		// cf.getNextArr(match);

		// String a = "cdab";
		// String b = "abcd";
		// System.out.println(cf.isRotation(a, b));

		// String str = "aaaaaaaaaaaaaab";
		// String match = "aaaab";
		// System.out.println(cf.getIndexOf(str, match));

		cf.convert("2147483648");
		
		
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
			if (cur < 0 || cur > 9) {// 此处一开始写成了'0' '9'
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

	/**
	 * 去掉字符串中连续出现k个0的子串
	 * 
	 * @param str
	 * @param k
	 * @return
	 */
	public static String removeKZeros(String str, int k) {

		if (str == null || k < 1) {
			return str;
		}
		char[] chas = str.toCharArray();
		int count = 0, start = -1;

		for (int i = 0; i < chas.length; i++) {
			if (chas[i] == '0') {
				count++;
				start = start == -1 ? i : start;
			} else {
				if (count == k) {
					while (count-- != 0) {
						chas[start++] = 0;
					}
					count = 0;
					start = -1;
				}
			}

		}
		if (count == k) {
			while (count-- != 0) {
				chas[start++] = 0;
			}
		}
		return String.valueOf(chas);
	}

	/**
	 * 翻转字符串 P262
	 * 
	 * @param chas
	 */
	public static void rotateWord(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		reverse(chas, 0, chas.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ' ') {// 如果当前遍历的字符【i】不是空格，则进入下面的分支
				l = (i == 0 || chas[i - 1] == ' ') ? i : l;// i为头一个或者其前面一个字符为空格，则记下返回i的索引给l，否则返回其本身
				r = (i == chas.length - 1 || chas[i + 1] == ' ') ? i : r;// l为最后一个或者其后面一个字符为空格，则记下返回i的索引给r，否则返回其本身
			}
			if (l != -1 && r != -1) {// 当l r 都不为初始值-1时，l作为start，r作为end，翻转字符
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}
		}
		System.out.println(chas);
	}

	/**
	 * 翻转字符串 P262 子方法
	 * 
	 * @param chas
	 */
	public static void reverse(char[] chas, int start, int end) {
		char tmp;
		while (start < end) {
			tmp = chas[start];
			chas[start] = chas[end];
			chas[end] = tmp;
			start++;
			end--;
		}
		// System.out.println(chas);

	}

	/**
	 * P264 从题目
	 * 
	 * @param chas
	 * @param size
	 */
	public static void rotate1(char[] chas, int size) {
		if (chas == null || chas.length == 0 || size <= 0
				|| size >= chas.length) {
			return;
		}
		reverse(chas, 0, size - 1);
		reverse(chas, size, chas.length - 1);
		reverse(chas, 0, chas.length - 1);
		System.out.println(chas);
	}

	public void exchange(char[] chas, int start, int end, int size) {

	}

	/**
	 * 判断两个字符串是否互为旋转词 P247
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isRotation(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) {
			return false;
		}

		String b2 = b + b;
		return getIndexOf(b2, a) != -1;// kmp算法
	}

	/**
	 * KMP算法 P491 ch9
	 * 
	 * @param s待扫描的数组
	 * @param mmatch数组
	 * @return m匹配到s时，从s的那个位置进行匹配，返回匹配的下标
	 */
	private int getIndexOf(String s, String m) {

		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;// s源字符串位置标记
		int mi = 0;// match字符串标记
		int[] nextArr = getNextArr(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {// str[si]=match[mi]，则二者都自加
				si++;
				mi++;
			} else if (nextArr[mi] == -1) {// 若不相等并且nextArr[mi]=-1说明该位置为不检查区域
				si++;
			} else {// 若不相等并且nextArr[mi]！=-1 kmp提速的操作 match字符串向前跳，继续比对
				mi = nextArr[mi];
			}
		}

		return mi == ms.length ? si - mi : -1;
	}

	/**
	 * next数组 next数组中i位置存储为0-i-1中前缀子串和后缀子串最大匹配长度 求match数组的nextArr值 前缀子串就是
	 * 从0开始不包含i-1的串（必须从0开始，长度小于i-2） 后缀子串就是以i-1结尾，不包含0位置的串（必须以i-1结尾，长度为i-2），
	 * 
	 * @param msmatch数组
	 * @return
	 */
	/*
	 * 首先前两位默认-1 和0 然后从post=2,cn=0开始
	 * 首先它的前一位不等于match[cn=0]，并且cn=0所以next[post]=0，post+1 post=3
	 * match[post-1]!=match[cn=0],并且cn=0，所以next[post=3]=0,post+1 post=4
	 * match[post-1]=match[cn]，故next[post]=1（前一个位置的前缀1，后缀1所以最大匹配为1），post+1 cn+1
	 * post=5 match[post-1]=match[cn]，故next[post]=2（前一个位置的前缀为12，后缀为12，最大匹配为2。
	 * 实际上cn已经记录最大匹配长度），post+ cn+1 post=6 match[post-1]=match[cn]，故next[post]=3
	 * （前一个位置的前缀为123，后缀为123，最大匹配为3）post+ cn+1 post=7
	 * match[post-1]=match[cn]，故next[post]=4 （前一个位置的前缀为1231，后缀为1231，最大匹配为4）post+
	 * cn+1 post=8 match[post-1]!=match[cn]，并且cn>0，故cn前移为cn=next[cn]
	 * （前移的这个位置实际是已匹配最长前缀串的缩减
	 * ，比如该位置前已经匹配最长前缀实际为1231，在下一个位置元素2不匹配，于是把前缀缩小，缩小到该位置之前元素与post之前位置完全匹配
	 * ，cn变为next[cn]（=1）比对。 有点绕口，实际就是
	 * 原本4元素之的前缀1231和后缀的1231匹配了，但是3的后缀12314与前缀的12312不匹配
	 * ，这时候我们不应该从头开始，而是缩减元素3之前的前缀和后缀子串
	 * ，缩减为前缀12与后缀14比较，还是不相等于是继续缩减前缀为1后缀为4，仍不相等(但是cn
	 * =0了)所以next[post=8]的值为0，意思为该位置之前的前缀和后缀无相同的匹配长度）
	 */
	private int[] getNextArr(char[] ms) {

		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;// next第一位没用前缀和后缀，初始化为-1
		next[1] = 0;// 第二位也没有初始化为0.然后从第三位2开始求
		int pos = 2;// post指当前位置
		int cn = 0;// cn为前移标志位
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {// match数组当前位置的前一个下标match[pos-1]==match[cn]，则将next数组的值赋为cn+1
				next[pos++] = ++cn;
			} else if (cn > 0) {// 如果cn>0,则将next[cn]的值赋给cn
				cn = next[cn];
			} else {// cn==0时,说明找不到合适匹配的
				next[pos++] = 0;
			}
		}
		return next;
	}

	/**
	 * 将整数字符串转成整数值 P248 （校验是否可以转换）
	 * 
	 * @param chas
	 * @return
	 */
	public boolean isValid(char[] chas) {
		if (chas[0] != '0' && (chas[0] < '0' || chas[0] > '9')) {
			return false;
		}
		if (chas[0] == '0' && (chas.length == 1 || chas[1] == '0')) {
			return false;
		}
		if (chas[0] == '0' && chas.length > 1) {
			return false;
		}
		for (int i = 1; i < chas.length; i++) {
			if (chas[0] < '0' || chas[0] > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 *  将整数字符串转成整数值 P248
	 * @param str
	 * @return
	 */
	public int convert(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}

		char[] chas = str.toCharArray();
		if (!isValid(chas)) {
			return 0;
		}
		boolean posi = chas[0] == '-' ? false : true;// 判断整数数的正负用
		int minq = Integer.MIN_VALUE / 10;// -214748364（2147483647~-2147483648）
		int minr = Integer.MIN_VALUE % 10;// -8
		int res = 0;//结果
		int cur = 0;//当前值
		for (int i = posi ? 0 : 1; i < chas.length; i++) {
			cur = '0' - chas[i];
			if (res < minq || (res == minq && cur < minr)) {//判断是否越界-2147483648
				return 0;
			}
			res = res * 10 + cur;
		}
		if (posi && res == Integer.MIN_VALUE) {//最小的负数比最大的正数的绝对值大1
			return 0;
		}
		return posi ? -res : res;
	}
}
