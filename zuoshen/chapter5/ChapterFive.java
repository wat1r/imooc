package zuoshen.chapter5;

import com.google.gson.Gson;

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

		// cf.convert("2147483648");

		// String str = "a b   c";
		// cf.replace(str.toCharArray());

		// char[] chas = { 'a', 'b', 'c', '1', '2', '3', '4' };
		// System.out.println(new Gson().toJson(chas));
		// cf.clear(chas, 3, 2);
		// System.out.println(new Gson().toJson(chas));

		String str = "babcyabc123";
		String from = "abc";
		String to = "4567";
		cf.replace1(str, from, to);

	}

	/**
	 * 最小包含子串的长度 P288
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int minLength(String str1, String str2) {
		if (str1 == null || str1 == null || str1.length() < str2.length()) {
			return 0;
		}
		char[] chas1 = str1.toCharArray();
		char[] chas2 = str2.toCharArray();
		int[] map = new int[256];

		for (int i = 0; i < chas2.length; i++) {
			map[chas2[i]]++;
		}

		int left = 0;
		int right = 0;
		int match = chas2.length;
		int minLen = Integer.MAX_VALUE;

		while (right != chas1.length) {
			map[chas1[right]]--;
			if (map[chas1[right]] >= 0) {
				match--;
			}

			if (match == 0) {
				while (map[chas1[left]] < 0) {
					map[chas1[left++]]++;
				}
				minLen = Math.min(minLen, right - left + 1);
				match++;
				map[chas1[left++]]++;
			}
			right++;

		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	/**
	 * �滻�ַ������������ֵ�ָ���ַ��� P251
	 * 
	 * @param str
	 *            ԭʼ�ַ���
	 * @param fromҪƥ
	 *            ����ַ���
	 * @param to
	 *            �����滻�ɵ��ַ���
	 * @return
	 */
	public String replace1(String str, String from, String to) {
		if (str == null || from == null || str.equals("") || from.equals("")) {
			return str;
		}
		char[] chas = str.toCharArray();
		char[] chaf = from.toCharArray();
		int match = 0;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] == chaf[match++]) {
				if (match == chaf.length) {
					clear(chas, i, chaf.length);
					match = 0;
				}
			} else {
				if (chas[i] == chaf[0]) {
					i--;
				}
				match = 0;
			}
		}
		String res = "";
		String cur = "";
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != 0) {
				cur = cur + String.valueOf(chas[i]);
			}
			if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
				res = res + cur + to;
				cur = "";
			}
		}
		if (!cur.equals("")) {
			res = res + cur;
		}
		System.out.println(res);
		return res;
	}

	/**
	 * �滻�ַ������������ֵ�ָ���ַ��� P251 2nd
	 * 
	 * @param chasҪ
	 *            �����е�ĳЩchar�滻��0
	 * @param end
	 *            ��ĳ��λ�ÿ�ʼ��ǰ�����滻
	 * @param len
	 *            �滻���ٸ�char �ٸ����� { 'a', 'b', 'c', '1', '2', '3', '4' }
	 *            end=3 len=2���滻��ʱ���'1'��ǰ�滻2�� ����� { 'a', 'b', 0, 0, '2',
	 *            '3', '4' }
	 */
	public void clear(char[] chas, int end, int len) {
		while (len-- != 0) {
			chas[end--] = 0;
		}

	}

	public void replace(char[] chas) {
		// System.out.println(new Gson().toJson(chas));
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (len = 0; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + 2 * num - 1;
		char[] res = new char[j + 1];
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				res[j--] = chas[i];
			} else {
				res[j--] = '0';
				res[j--] = '2';
				res[j--] = '%';

			}
		}
		System.out.println(new Gson().toJson(res));

	}

	/**
	 * �ж������ַ����Ƿ�Ϊ���δ� P242
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
	 * �ַ����������Ӵ������ P243
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
			if (cur < 0 || cur > 9) {// �˴�һ��ʼд����'0' '9'
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
	 * ȥ���ַ�������������k��0���Ӵ�
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
	 * ��ת�ַ��� P262
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
			if (chas[i] != ' ') {// �����ǰ�������ַ���i�����ǿո����������ķ�֧
				l = (i == 0 || chas[i - 1] == ' ') ? i : l;// iΪͷһ��������ǰ��һ���ַ�Ϊ�ո�����·���i��������l�����򷵻��䱾��
				r = (i == chas.length - 1 || chas[i + 1] == ' ') ? i : r;// lΪ���һ�����������һ���ַ�Ϊ�ո�����·���i��������r�����򷵻��䱾��
			}
			if (l != -1 && r != -1) {// ��l r
										// ����Ϊ��ʼֵ-1ʱ��l��Ϊstart��r��Ϊend����ת�ַ�
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}
		}
		System.out.println(chas);
	}

	/**
	 * ��ת�ַ��� P262 �ӷ���
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
	 * P264 ����Ŀ
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
	 * �ж������ַ����Ƿ�Ϊ��ת�� P247
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
		return getIndexOf(b2, a) != -1;// kmp�㷨
	}

	/**
	 * KMP�㷨 P491 ch9
	 * 
	 * @param s
	 *            ��ɨ�������
	 * @param mmatch
	 *            ����
	 * @return mƥ�䵽sʱ����s���Ǹ�λ�ý���ƥ�䣬����ƥ����±�
	 */
	private int getIndexOf(String s, String m) {

		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;// sԴ�ַ���λ�ñ��
		int mi = 0;// match�ַ������
		int[] nextArr = getNextArr(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {// str[si]=match[mi]������߶��Լ�
				si++;
				mi++;
			} else if (nextArr[mi] == -1) {// ������Ȳ���nextArr[mi]=-1˵����λ��Ϊ���������
				si++;
			} else {// ������Ȳ���nextArr[mi]��=-1 kmp���ٵĲ���
					// match�ַ�����ǰ���������ȶ�
				mi = nextArr[mi];
			}
		}

		return mi == ms.length ? si - mi : -1;
	}

	/**
	 * next���� next������iλ�ô洢Ϊ0-i-1��ǰ׺�Ӵ��ͺ�׺�Ӵ����ƥ�䳤�� ��match�����nextArrֵ
	 * ǰ׺�Ӵ����� ��0��ʼ������i-1�Ĵ��������0��ʼ������С��i-2��
	 * ��׺�Ӵ�������i-1��β��������0λ�õĴ���������i-1��β������Ϊi-2����
	 * 
	 * @param msmatch
	 *            ����
	 * @return
	 */
	/*
	 * ����ǰ��λĬ��-1 ��0 Ȼ���post=2,cn=0��ʼ
	 * ��������ǰһλ������match[cn=0]������cn=0����next[post]=0��post+1 post=3
	 * match[post-1]!=match[cn=0],����cn=0������next[post=3]=0,post+1 post=4
	 * match
	 * [post-1]=match[cn]����next[post]=1��ǰһ��λ�õ�ǰ׺1����׺1�������ƥ��Ϊ1����
	 * post+1 cn+1 post=5
	 * match[post-1]=match[cn]����next[post]=2��ǰһ��λ�õ�ǰ׺Ϊ12�
	 * ���׺Ϊ12�����ƥ��Ϊ2�� ʵ����cn�Ѿ���¼���ƥ�䳤�ȣ���post+ cn+1 post=6
	 * match[post-1]=match[cn]����next[post]=3
	 * ��ǰһ��λ�õ�ǰ׺Ϊ123����׺Ϊ123�����ƥ��Ϊ3��post+ cn+1 post=7
	 * match[post-1]=match[cn]����next[post]=4
	 * ��ǰһ��λ�õ�ǰ׺Ϊ1231����׺Ϊ1231�����ƥ��Ϊ4��post+ cn+1 post=8
	 * match[post-1]!=match[cn]������cn>0����cnǰ��Ϊcn=next[cn]
	 * ��ǰ�Ƶ����λ��ʵ������ƥ���ǰ׺��������
	 * �������λ��ǰ�Ѿ�ƥ���ǰ׺ʵ��Ϊ1231������һ��λ
	 * ��Ԫ��2��ƥ�䣬���ǰ�ǰ׺��С����С����λ��֮ǰԪ����post֮ǰλ����ȫƥ��
	 * ��cn��Ϊnext[cn]��=1���ȶԡ� �е��ƿڣ�ʵ�ʾ���
	 * ԭ��4Ԫ��֮��ǰ׺1231�ͺ�׺��1231ƥ���ˣ�����3�ĺ�׺12314��ǰ׺��12312��ƥ��
	 * ����ʱ�����ǲ�Ӧ�ô�ͷ��ʼ����������Ԫ��3֮ǰ��ǰ׺�ͺ�׺�Ӵ�
	 * ������Ϊǰ׺12���׺14�Ƚϣ����ǲ�������Ǽ�������ǰ׺Ϊ1��׺Ϊ4���Բ����(����cn
	 * =0��)����next[post=8]��ֵΪ0����˼Ϊ��λ��֮ǰ��ǰ׺�ͺ�׺����ͬ��ƥ�䳤�ȣ�
	 */
	private int[] getNextArr(char[] ms) {

		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;// next��һλû��ǰ׺�ͺ�׺����ʼ��Ϊ-1
		next[1] = 0;// �ڶ�λҲû�г�ʼ��Ϊ0.Ȼ��ӵ���λ2��ʼ��
		int pos = 2;// postָ��ǰλ��
		int cn = 0;// cnΪǰ�Ʊ�־λ
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {// match���鵱ǰλ�õ�ǰһ���±�match[pos-1]==match[cn]����next�����ֵ��Ϊcn+1
				next[pos++] = ++cn;
			} else if (cn > 0) {// ���cn>0,��next[cn]��ֵ����cn
				cn = next[cn];
			} else {// cn==0ʱ,˵���Ҳ�������ƥ���
				next[pos++] = 0;
			}
		}
		return next;
	}

	/**
	 * �������ַ���ת������ֵ P248 ��У���Ƿ����ת����
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
	 * �������ַ���ת������ֵ P248
	 * 
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
		boolean posi = chas[0] == '-' ? false : true;// �ж���������������
		int minq = Integer.MIN_VALUE / 10;// -214748364��2147483647~-2147483648��
		int minr = Integer.MIN_VALUE % 10;// -8
		int res = 0;// ���
		int cur = 0;// ��ǰֵ
		for (int i = posi ? 0 : 1; i < chas.length; i++) {
			cur = '0' - chas[i];
			if (res < minq || (res == minq && cur < minr)) {// �ж��Ƿ�Խ��-2147483648
				return 0;
			}
			res = res * 10 + cur;
		}
		if (posi && res == Integer.MIN_VALUE) {// ��С�ĸ��������������ľ���ֵ��1
			return 0;
		}
		return posi ? -res : res;
	}

}
