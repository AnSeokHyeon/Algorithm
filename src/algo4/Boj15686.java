// 치킨배달
package algo4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15686 {
	static int[][] map;
	static int N, M, result;
	static ArrayList<Point> shop;
	static ArrayList<Point> home;
	static boolean[] chk;

	static void cal(int n, int m) {
		if (n == M) {
			func();
			return;
		}
		for (int i = m; i < shop.size(); i++) {
			if (chk[i])
				continue;
			chk[i] = true;
			cal(n + 1, i + 1);
			chk[i] = false;

		}

	}

	static void func() {
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int hx = home.get(i).x;
			int hy = home.get(i).y;
			int dis = 987654321;

			for (int j = 0; j < shop.size(); j++) {
				if (!chk[j])
					continue;
				int sx = shop.get(j).x;
				int sy = shop.get(j).y;

				int distemp = Math.abs(hx - sx) + Math.abs(hy - sy);
				if (dis > distemp)
					dis = distemp;

			}
			sum += dis;
		}

		if (result > sum)
			result = sum;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		shop = new ArrayList<>();
		home = new ArrayList<>();
		result = 987654321;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					shop.add(new Point(i, j));
				}
			}

		}

		chk = new boolean[shop.size()];
		cal(0, 0);
		bw.write(result + "");
		bw.close();
		br.close();

	}

}
