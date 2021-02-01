// 숨바꼭질
package algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697 {
	static boolean[] chk;

	static class Inf {
		int X;
		int T;

		public Inf() {
		}

		public Inf(int x, int t) {
			X = x;
			T = t;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		chk = new boolean[100001];
		chk[N] = true;
		int result = 0;
		Inf go = new Inf(N, 0);

		Queue<Inf> q = new LinkedList<Inf>();

		q.add(go);
		while (!q.isEmpty()) {
			Inf a = q.poll();

			int X = a.X;
			int T = a.T;
			if (X == K) {
				result = T;
				break;
			}
			for (int i = 0; i < 3; i++) {
				int mx = X;
				if (i == 0) {
					mx = X + 1;
				} else if (i == 1) {
					mx = X - 1;
				} else if (i == 2) {
					mx = X * 2;
				}
				if (mx > 100000 || mx < 0)
					continue;
				if (chk[mx])
					continue;

				chk[mx] = true;
				Inf next = new Inf(mx, T + 1);
				q.add(next);

			}
		}
		System.out.println(result);
		sc.close();

	}

}
