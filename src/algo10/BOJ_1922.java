package algo10;

// 1922 네트워크 연결
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
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
		int w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		p = new int[N + 1];
	

		for (int i = 0; i < N + 1; i++) {
			p[i] = i;
		}

		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			q.add(new Node(x,  y, w));
		}
		
		int result = 0;
		while (!q.isEmpty()) {
			Node p = q.poll();
			int now = p.x;
			int next = p.y;
			int w = p.w;
			if (!union(now, next))
				continue;
			result += w;
		}

		bw.write(result + "");
		br.close();
		bw.close();
	}

}