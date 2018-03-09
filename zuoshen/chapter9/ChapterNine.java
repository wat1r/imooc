package zuoshen.chapter9;

public class ChapterNine {

	public static void main(String[] args) {
		ChapterNine cn = new ChapterNine();

		int[] arr1 = { 1, 2, 3, 4 };

		System.out.println(arr1.length);

		int offset = ((arr1.length - 0 + 1) & 1) ^ 1;

		System.out.println((arr1.length - 0 + 1) & 1);
		System.out.println(offset);

	}

	/**
	 * 在两个长度相等的排序数组中找到上中位数 P465
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int getUpMedian(int[] arr1, int[] arr2) {

		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			return -1;
		}
		int start1 = 0;
		int end1 = arr1.length - 1;
		int start2 = 0;
		int end2 = arr2.length - 1;
		int mid1 = 0;
		int mid2 = 0;
		int offset = 0;

		while (start1 < end1) {
			mid1 = (start1 + end1) / 2;
			mid2 = (start2 + end2) / 2;
			offset = ((end1 - start1 + 1) & 1) ^ 1;
			if (arr1[mid1] > arr2[mid2]) {
				end1 = mid1;
				start2 = mid2 + offset;
			} else if (arr1[mid1] < arr2[mid2]) {
				start1 = mid1 + offset;
				end2 = mid2;
			} else {
				return arr1[mid1];
			}
		}

		return Math.min(arr1[start1], arr2[start2]);
	}

}
