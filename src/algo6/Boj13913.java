
//  숨바꼭질4
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

public class Boj13913 {
	static int chk[];
	static int pick[];
	static int result, N, K;
	static StringBuilder sb = new StringBuilder();

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
		result = 0;
		while (!q.isEmpty()) {
			Point top = q.poll();

			int x = top.x;
			int d = top.y;
			if (x == K) {
				result = d;
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
				if (mx < 0 || mx > 100000)
					continue;
				if (chk[mx] > -1)
					continue;
				chk[mx] = x;
				q.add(new Point(mx, md));
			}

		}
		pick = new int[result];
		dfs(0, K);
		bw.write(result + "\n");

		bw.write(sb.toString());
		br.close();
		bw.close();

	}

	static void dfs(int n, int now) {
		if (n == result) {
			for (int i = n - 1; i > -1; i--) {
				sb.append(pick[i] + " ");
			}
			sb.append(K + " ");
			return;
		}

		pick[n] = chk[now];
		dfs(n + 1, chk[now]);

	}

}