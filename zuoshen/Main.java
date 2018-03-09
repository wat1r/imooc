package zuoshen.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(Main.deleteNum(n));
		}

	}

	public static int deleteNum(int n) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int index = 0;
		while (list.size() > 1) {// 每隔2增加，size也在不断递减，index取模可能会为0，增加2 如此往复
			index = (index + 2) % list.size();
			list.remove(index);
		}

		return list.get(0);
	}

}
