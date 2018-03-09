package zuoshen.chapter9;

public class ChapterNine {

	public static void main(String[] args) {

		ChapterNine cn = new ChapterNine();

		String str = "bcb";
		System.out.println(cn.manacherString(str));

	}

	public char[] manacherString(String str) {

		char[] chas = str.toCharArray();
		char[] res = new char[chas.length * 2 + 1];
		int index = 0;
		for (int i = 0; i < res.length; i++) {// 偶数&1得0
			res[i] = (i & 1) == 0 ? '#' : chas[index++];
		}

		return res;

	}

}
