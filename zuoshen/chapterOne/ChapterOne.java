package zuoshen.chapter1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ջ�����
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
	 * ���ɴ������ֵ�� P19
	 * 
	 * @param arr��������
	 * @param w���ڴ�С
	 * @return һ������Ϊn-w+1������res��res[i]��ʾÿһ�ִ���״̬�µ����ֵ
	 */
	public static int[] getMaxWindow(int[] arr, int w) {

		if (arr == null || w < 1 || arr.length < w) { // ����Ϊ���飬�ʹ��ڵĴ�С
			return null;// ����null��ʾget����
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>(); // ��һ��������ģ��˫�����飬������ŷ��ϱ�׼�������±�
		int[] res = new int[arr.length - w + 1];// �½�һ��int���͵��������ڴ��ÿ�������е����ֵ
		int index = 0;// ���������res�������
		for (int i = 0; i < arr.length; i++) {// �������� ע��˴�������Ϊarr����res
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {// ��qmax��Ϊ�ղ���qmax��ŵĵ�һ���±������Ӧֵ�����ֵ��С����ֵ
				qmax.pollLast();// ��qmax�����һ��ֵ����
			}
			qmax.addLast(i);// ÿ�α�������i����qmax�Ķ�β
			if (qmax.peekFirst() == i - w) {// ���������ֹqmax�����������ڣ����ڼ�ָqmax���еĵ�һ���±겻�ܵ��ڱ���i-w����Ϊÿ��ֻ���ڴ��ڵķ�Χ��ȡֵ
				qmax.pollFirst();// ���ھͽ�qmax����Ԫ�ص���
			}
			if (i >= w - 1) {// ���i>w-1�������㴰�ڴ�С���ͽ�qmax�����±������Ӧ��ֵ����res����ʱ��Ӧ��ֵΪ���ֵ��
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	/*
	 * ��չ�� // ���ص�һ���ڵ� 282 // ��LinkedList�Ĵ�СΪ0,�򷵻�null 283 public E peekFirst() {
	 * 284 if (size==0) 285 return null; 286 return getFirst(); 287 } 288 289 //
	 * �������һ���ڵ� 290 // ��LinkedList�Ĵ�СΪ0,�򷵻�null 291 public E peekLast() { 292 if
	 * (size==0) 293 return null; 294 return getLast(); 295 } 296 297 //
	 * ɾ�������ص�һ���ڵ� 298 // ��LinkedList�Ĵ�СΪ0,�򷵻�null 299 public E pollFirst() { 300
	 * if (size==0) 301 return null; 302 return removeFirst(); 303 } 304 305 //
	 * ɾ�����������һ���ڵ� 306 // ��LinkedList�Ĵ�СΪ0,�򷵻�null 307 public E pollLast() { 308
	 * if (size==0) 309 return null; 310 return removeLast(); 311 } // ���ص�һ���ڵ�
	 * 243 // ��LinkedList�Ĵ�СΪ0,�򷵻�null 244 public E peek() { 245 if (size==0)
	 * 246 return null; 247 return getFirst(); 248 }
	 */

	/**
	 * ���ֵ��ȥ��СֵС�ڻ��ǵ���num������������ P31
	 * 
	 * @param arr����������
	 * @param num����������
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
