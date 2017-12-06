package zuoshen.chapter1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 栈与队列
 * @author FrankCooper
 *
 */
public class ChapterOne {

	public static void main(String[] args) {

		// int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		// getMaxWindow(arr, 3);

		int[] arr_test = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int num_test = 4;
		int res_test;
		res_test = getNum(arr_test, num_test);
		System.out.printf("res = %d", res_test);

	}
	
	
	
	 
	
	
	
	
	
	
	

	/**
	 * 生成窗口最大值数 P19
	 * 
	 * @param arr整形数组
	 * @param w窗口大小
	 * @return 一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
	 */
	public static int[] getMaxWindow(int[] arr, int w) {

		if (arr == null || w < 1 || arr.length < w) { // 参数为数组，和窗口的大小
			return null;// 返回null表示get结束
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>(); // 用一个链表来模拟双端数组，用来存放符合标准的数组下标
		int[] res = new int[arr.length - w + 1];// 新建一个int类型的数组用于存放每个窗口中的最大值
		int index = 0;// 这个是用来res数组计数
		for (int i = 0; i < arr.length; i++) {// 遍历数组 注意此处的数组为arr而非res
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {// 当qmax不为空并且qmax存放的第一个下标数组对应值（最大值）小于新值
				qmax.pollLast();// 将qmax中最后一个值弹出
			}
			qmax.addLast(i);// 每次遍历都将i放入qmax的队尾
			if (qmax.peekFirst() == i - w) {// 这个用来防止qmax里面存的数过期，过期即指qmax队列的第一个下标不能等于遍历i-w，因为每次只能在窗口的范围内取值
				qmax.pollFirst();// 过期就将qmax队首元素弹出
			}
			if (i >= w - 1) {// 如果i>w-1，即满足窗口大小，就将qmax队首下标数组对应的值放入res（此时对应的值为最大值）
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	/*
	 * 扩展： // 返回第一个节点 282 // 若LinkedList的大小为0,则返回null 283 public E peekFirst() {
	 * 284 if (size==0) 285 return null; 286 return getFirst(); 287 } 288 289 //
	 * 返回最后一个节点 290 // 若LinkedList的大小为0,则返回null 291 public E peekLast() { 292 if
	 * (size==0) 293 return null; 294 return getLast(); 295 } 296 297 //
	 * 删除并返回第一个节点 298 // 若LinkedList的大小为0,则返回null 299 public E pollFirst() { 300
	 * if (size==0) 301 return null; 302 return removeFirst(); 303 } 304 305 //
	 * 删除并返回最后一个节点 306 // 若LinkedList的大小为0,则返回null 307 public E pollLast() { 308
	 * if (size==0) 309 return null; 310 return removeLast(); 311 } // 返回第一个节点
	 * 243 // 若LinkedList的大小为0,则返回null 244 public E peek() { 245 if (size==0)
	 * 246 return null; 247 return getFirst(); 248 }
	 */

	/**
	 * 最大值减去最小值小于或是等于num的子数组数量 P31
	 * 
	 * @param arr给定的数组
	 * @param num给定的整数
	 * @return
	 */
	public static int getNum(int[] arr, int num) {

		if (arr == null || arr.length == 0) {
			return 0;
		}

		LinkedList<Integer> qmax = new LinkedList<Integer>();
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		int i = 0, j = 0;
		int res = 0;
		while (i < arr.length) {
			while (j < arr.length) {

				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);

				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			res += j - i;
			i++;
		}
		return res;

	}
}
