package zuoshen.company;

import java.util.*;

import com.sort.TotalSort;

public class Company18 {

	public static void main(String[] args) {
		Company18 cb = new Company18();
		// cb.countScanner();
		// cb.staggered01Scanner();
		// cb.operationSequence();
		cb.crazySequence();

	}

	/**
	 * 2018网易内推编程题：独立的小易 7/8 
	 *************
	 */
	public void crazySequence() {
		Scanner in = new Scanner(System.in);

		// while (in.hasNext()) {
		// int n = in.nextInt();
		int n = 8;
		// int[] nums = new int[n];
		int[] nums = { 7, 11, 17, 13, 2, 3, 5, 19 };
		// for (int i = 0; i < n; i++) {
		// nums[i] = in.nextInt();
		// }
		TotalSort.sortSmallToBig(nums, 0, n - 1);
		int min = nums[0];// 上一次加入疯狂队列的那个最小值
		int max = nums[n - 1];// 上一次加入疯狂队列的那个最大值
		int diff = max - min;// 第一次最大值减去最小值
		int minIndex = 1; // 未加入疯狂队列的最小值索引
		int maxIndex = n - 2; // 未加入疯狂队列的最大值索引
		while (minIndex < maxIndex) {
			diff += max - nums[minIndex];
			diff += nums[maxIndex] - min;
			min = nums[minIndex++];
			max = nums[maxIndex--];
		}
		// 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
		diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
		System.out.println(diff);

		// }

	}

	/**
	 * * * 2018网易内推编程题：独立的小易 7/8 参考C写的，运行不出来
	 ****** 
	 * 具体解析过程： http://blog.csdn.net/he_shuai20/article/details/77200568
	 * 
	 */
	public void crazySequence1() {
		// System.out.println("Input:");
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		int n = 8;
		Vector<Integer> v1 = new Vector<>();
		// int[] arr = new int[n];
		int[] arr = { 7, 11, 17, 13, 2, 3, 5, 19 };
		for (int i = 0; i < n; i++) {
			// arr[i] = sc.nextInt();
			v1.add(arr[i]);
		}

		TotalSort.sortSmallToBig(arr, 0, n - 1);

		Vector<Integer> v2 = new Vector<>();

		int flag = 1;
		int left = -1;
		int right = n - 1;

		v2.add(v1.get(n - 1));

		while (left + 1 < right) {
			if (flag == 1) {
				v2.add(v2.firstElement(), v1.get(++left));
				if (left + 1 < right) {
					v2.add(v1.get(++left));
				}
			} else {
				v2.add(v2.firstElement(), v1.get(--right));
				if (left + 1 < right) {
					v2.add(v1.get(--right));
				}
			}
			flag ^= 1;// 保证一左一右
		}
		if (Math.abs(v2.get(n - 1) - v2.get(n - 2)) < Math.abs(v2.get(n - 1)
				- v2.get(0))) {
			int temp = v2.get(n - 1);
			v2.remove(v2.lastElement() - 1);
			v2.add(v2.firstElement(), temp);
		}
		int count = 0;
		for (int i = 1; i < v2.size(); i++) {
			count += Math.abs(v2.get(i) - v2.get(i - 1));
		}
		System.out.println("count:" + count);
	}

	/**
	 * * 2018网易内推编程题：独立的小易 5/8
	 ****** 
	 * 思路： 房租每天x元，初始金钱是d元，这些钱全部用来付房租，则可以付day=d/x天的房租，如果一开始带的水果数f大于等于day，
	 * 说明不用为水果发愁，此时最大住的天数dayMax=day。（钱全部用来付房租）
	 * 
	 * 如过f<day,则钱不仅要用来付房租，还可能要用来买水果。 事实上小易每天的花费为一个水果价钱加上房租 即 cost=p+x;
	 * 取巧的思路是，我们将一开始带的水果全部看成钱
	 * ,则此时相当于小易一开始带的钱数为money=d+f*p。然后除以每天的花费，就可以得到最大住的天数。 即dayMax=money/cost ;
	 * 
	 * @return小易可以独立生活的天数
	 */
	public long independentXiaoYi() {
		System.out.println("Input:");
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();// 每日的房租 x元
		long f = sc.nextLong();// 水果的个数 f个
		long d = sc.nextLong();// 拥有的钱数 d元
		long p = sc.nextLong();// 每个水果的价格 p元
		long day = d / x;
		if (f >= day) {
			return day;
		}
		long money = d + f * p;
		long cost = x + p;
		return money / cost;

	}

	/**
	 * 
	 * 2018网易内推编程题：操作序列 4/8
	 ****** 
	 * * 思路: 序列a:0 1 2 3 4 5 6 7 8 9 长度为10 序列b的变化过程: ****** 一、 0
	 ****** 
	 * 二、 1 0
	 ******* 
	 * 三、 2 0 1
	 ******* 
	 * 四、 3 1 0 2
	 ******* 
	 * 五、 4 2 0 1 3
	 ******* 
	 * 六、 5 3 1 0 2 4
	 ******* 
	 * 七、 6 4 2 0 1 3 5
	 ******* 
	 * 八、 7 5 3 1 0 2 4 6
	 ******** 
	 * 九、 8 6 4 2 0 1 3 5 7
	 ******** 
	 * 十、 9 7 5 3 1 0 2 4 6 8
	 * 
	 * 很明显，若经过奇数次的变化，a序列的偶数序号是以递减的顺序排在b序列的左侧，a序列的奇数序号是以递增的顺序排列在b序列的右侧。
	 * 反之，若经过偶数次的变化，a序列的奇数数序号是以递减的顺序排在b序列的左侧，a序列的偶数序号是以递增的顺序排列在b序列的右侧。
	 * 只需要将偶数序号和奇数序号分开生各成一个数组，按照递减或递增的规律先后输出即可。
	 */
	public void operationSequence() {

		int[] oddArr;// 奇数列
		int[] evenArr;// 偶数列
		System.out.println("Input:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0) {
			oddArr = new int[n / 2];
			evenArr = new int[n / 2];
			for (int i = 0; i < n; i++) {
				int sub = i / 2;
				if (i % 2 == 0) {
					System.out.println("evenArr Input:");
					evenArr[sub] = sc.nextInt();
				} else {
					System.out.println("oddArr Input:");
					oddArr[sub] = sc.nextInt();
				}
			}
			for (int i = oddArr.length - 1; i >= 0; i--) {
				System.out.print(oddArr[i] + " ");
			}
			for (int i = 0; i < evenArr.length; i++) {
				System.out.print(evenArr[i] + " ");
			}

		} else {
			oddArr = new int[n / 2];
			evenArr = new int[n / 2 + 1];
			for (int i = 0; i < n; i++) {
				int sub = i / 2;
				if (i % 2 == 0) {
					evenArr[sub] = sc.nextInt();
				} else {
					oddArr[sub] = sc.nextInt();
				}
			}

			for (int i = evenArr.length - 1; i >= 0; i--) {
				System.out.print(evenArr[i] + " ");
			}
			for (int i = 0; i < oddArr.length; i++) {
				System.out.print(oddArr[i] + " ");
			}

		}

	}

	public void staggered01Scanner() {
		System.out.println("输入：");
		// Scanner sc = new Scanner(System.in);
		// String str = sc.nextLine();
		String str = "100111000101010110";

		System.out.println(staggered01(str));

	}

	/**
	 * 牛客网 网易内推2018年 3/8
	 ************************* 
	 * * 思路： 示例：100111000101010110
	 * 根据题目可知，交错01串要求相邻字符不相同。所以凡是相邻字符相同的地方，一定是两个子串的分割点。如011
	 * 因为11相邻相同，则视为要分割部分，将字符串分为01和1；
	 * 如示例01串，则可划分为10、01、1、10、0、01010101、10（将示例字符串相邻又相同字符中间加个顿号，就能得到这些子串）
	 * 所以，我们只需要找到每个与前面字符相同的字符的位置
	 * ，并记录下来。这些位置都是分割点，是新子串的开始位置。（最开始的字符前面没有字符，但因为也是子串开始点，即分割点，也需要记录下来。） 如示例
	 * 可以得到分割点数组
	 * 0、2、4、5、7、8、16、18（最后一个字符是最后一个子串的结尾，相当于是分割点前面的字符，需要将他下一个位置也设成分割点。）
	 * 分割点之间的差即是每个子串的长度。2、2、1、2、1、8、2 取最大值即可。
	 */
	public int staggered01(String str) {

		char[] chas = str.toCharArray();
		if (chas.length == 1) {// 如果01串长度为1，直接输出1并结束即可。
			return 1;
		}
		List<Integer> list = new ArrayList<>();// list用来装分割点之差，即每个子串的长度。
		int local = 0;// local代表当前分割点的位置。一开始是0；
		for (int i = 1; i < chas.length; i++) {// 让i从1开始，去c[i]和前面的字符比较（c[i-1]），如相同，则说明当前i是分割点，将当前i与local做差，即是i分割点前面子串的长度。
			// 再将i赋给local 标记成新的分割点。如果i已经是最后一个，还需要将i+1设置成分割点，与当前local做差。
			if (chas[i] == chas[i - 1]) {
				list.add(i - local);
				local = i;
			}
			if (i == chas.length - 1) {
				list.add(i + 1 - local);
			}
		}
		// 取最大值
		int max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}

		}
		return max;

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