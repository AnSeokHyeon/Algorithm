//이모티콘
package algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj14226 {
	static int S, result;
	static boolean[][] chk;

	static class Inf {
		int e;
		int c;
		int t;

		public Inf() {

		}

		public Inf(int e, int c, int t) {
			this.e = e;
			this.c = c;
			this.t = t;
		}

	}

	static void bfs() {

		Queue<Inf> q = new LinkedList<Inf>();
		Inf start = new Inf(2, 1, 2);

		q.add(start);
		chk[start.e][start.c] = true;

		while (!q.isEmpty()) {
			Inf a = q.poll();
			int t = a.t;
			int c = a.c;
			int e = a.e;
			if (e == S) {
				result = t;
				break;
			}

			for (int i = 0; i < 3; i++) {
				// System.out.println(" i : " + i);
				Inf next = new Inf();
				if (i == 0) {
					next.e = e;
					next.c = e;
				} else if (i == 1) {
					next.e = e + c;
					next.c = c;

				} else {
					next.e = e - 1;
					next.c = c;

				}
				if (next.e < 2)
					continue;
				if (chk[next.e][next.c])
					continue;
				chk[next.e][next.c] = true;
				next.t = t + 1;
				q.add(next);

				// System.out.println(e + " / " + " / " + c + " / "+ t + " | " + i);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		S = sc.nextInt();
		chk = new boolean[10000][10000];

		bfs();

		System.out.println(result);

		sc.close();

	}

}
