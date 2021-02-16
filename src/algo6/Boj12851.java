// 12851 숨바꼭질 2
package algo6;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj12851 {
	static int N, K;
	static int chk[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		chk = new int[200000];
		Arrays.fill(chk, -1);
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(N, 0));
		for (int i = 0; i < 200000; i++) {

		}
		chk[N] = 0;
		int limit = 0;
		int result = 0;
		while (!q.isEmpty()) {
			Point top = q.poll();
			int x = top.x;
			int d = top.y;
			if (x == K) {
				limit = d;
				result++;
			}
			if (limit > 0 && d > limit) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int mx = 0;
				int md = d + 1;
				if (i == 0) {
					mx = x + 1;

				} else if (i == 1) {
					mx = x - 1;
				} else if (i == 2) {
					mx = x * 2;
				}

				if (mx > 100000 || mx < 0)
					continue;
				if (chk[mx] != -1 && md > chk[mx])
					continue;
				chk[mx] = md;
				q.add(new Point(mx, md));

			}

		}
		bw.write(limit + "\n");
		bw.write(result + "\n");
		bw.close();
		br.close();
	}

}