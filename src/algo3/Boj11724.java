// 연결 요소의 개수
package algo3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11724 {
	static boolean[] chk;
	static boolean[][] map;

	static void BFS(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		chk[n] = true;

		while (!q.isEmpty()) {

			int a = q.poll();
			for (int i = 1; i < map.length; i++) {

				if (map[a][i] && !chk[i]) {
					chk[i] = true;
					q.add(i);
				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			map[x][y] = map[y][x] = true;

		}

		chk = new boolean[N + 1];
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (chk[i])
				continue;
			BFS(i);
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

}
