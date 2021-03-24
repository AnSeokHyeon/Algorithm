package algo11;

// 1251. [S/W 문제해결 응용] 4일차 - 하나로
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_1251_하나로 {
	static int p[];

	static int find(int n) {
		if (p[n] == n)
			return n;

		return p[n] = find(p[n]);

	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa == pb)
			return false;

		if (pa > pb)
			p[pa] = pb;
		else
			p[pb] = pa;
		return true;
	}

	static class Node {
		int x;
		int y;
		long w;

		public Node(int x, int y, long w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			p = new int[N + 1];

			int x[] = new int[N + 1];
			int y[] = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N + 1; i++) {

				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N + 1; i++) {

				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());

			for (int i = 0; i < N + 1; i++) {
				p[i] = i;
			}

			PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return Long.compare(o1.w, o2.w);
				}

			});

			for (int i = 1; i < N + 1; i++) {
				for (int j = i + 1; j < N + 1; j++) {
					int X = Math.abs(x[i] - x[j]);
					int Y = Math.abs(y[i] - y[j]);
					long X2 = (long)Math.pow(X, 2);
					long Y2 = (long)Math.pow(Y, 2);
					q.add(new Node(i, j,X2 + Y2));
				}
			}

			double result = 0;
			while (!q.isEmpty()) {
				Node p = q.poll();
				int now = p.x;
				int next = p.y;
				long w = p.w;
				if (!union(now, next))
					continue;
				result += w*E;
			}

			sb.append("#" + (Tcnt++) + " "+ Math.round(result) + "\n");

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}