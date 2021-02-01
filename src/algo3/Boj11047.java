// 스택 수열
package algo3;

import java.util.Scanner;

public class Boj11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int K = sc.nextInt();

		int[] m = new int[N];

		for (int i = 0; i < N; i++) {
			m[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = N; i > 0; i--) {
			int tp = K / m[i - 1];
			cnt += tp;

			K = K % m[i - 1];

		}
		System.out.println(cnt);

		sc.close();

	}

}
