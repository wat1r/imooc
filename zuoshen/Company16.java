package zuoshen.company;

import java.util.Scanner;

/**
 * ţ������2016���������
 * 
 * @author FrankCooper
 * 
 */
public class Company16 {

	public static void main(String[] args) {
		Company16 com = new Company16();
		// com.testEnergy();

		com.getStepMain();

	}

	public void getStepMain() {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int r = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			System.out.println(getStep(r, x, y, x1, y1));
		}
	}

	public int getStep(int r, int x, int y, int x1, int y1) {

		double rx = (x1 - x) * (x1 - x);
		double ry = (y1 - y) * (y1 - y);
		double res = Math.sqrt(rx + ry) / (2 * r);
		return (int) Math.ceil(res);
	}

	/*
	 * С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ
	 * a.�ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn.
	 * ��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,��
	 * ��ʹ���Լ�������ֵ����bi;���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi
	 * ��c�����Լ��.��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?
	 */
	public void testEnergy() {
		// ����ÿ������,��һ������������n(1��n<100000)��ʾ�����������a��ʾС�׵ĳ�ʼ����ֵ.
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int[] b = new int[n]; // �ڶ���n������,b1,b2...bn(1��bi��n)��ʾÿ������ķ�����
			for (int i = 0; i < b.length; i++) {
				b[i] = sc.nextInt();
			}
			System.out.println(energy(n, a, b));
		}
	}

	/**
	 * 
	 * @param n�ֵ�����
	 * @param aӢ�۵�����ֵ
	 * @param b�ֵ�����ֵ����
	 * @return
	 */
	public int energy(int n, int a, int[] b) {
		for (int i = 0; i < n; i++) {
			if (a >= b[i]) {
				a += b[i];
			} else {
				a += getMaxCommonDivisor(b[i], a);
			}
		}
		return a;
	}

	/**
	 * �������������Լ��
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int getMaxCommonDivisor(int m, int n) {

		if (m < n) {// ��֤m>n,��m<n,��������ݽ���
			int tmp = m;
			m = n;
			n = tmp;
		}
		if (m % n == 0) {// ������Ϊ0,�������Լ��
			return n;
		} else {// ����������Ǹ�����p��q����q==0,�����Լ��Ϊp������,p��q�����Լ������p����q���õ�������q�����Լ����
			return getMaxCommonDivisor(n, m % n);
		}
	}

}
