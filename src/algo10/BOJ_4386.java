package algo10;


// 4386 별자리 만들기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386 {
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
	
	static class Node{
		int x;
		int y;
		double w;
		public Node(int x, int y, double w) {
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

		p = new int[N + 1];
		
		double x[] = new double[N+1];
		double y[] = new double[N+1];
		for(int i= 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}

		for (int i = 0; i < N + 1; i++) {
			p[i] = i;
		}

		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return (int)((o1.w - o2.w)*100);
			}
		});
		
		for(int i = 1; i<N+1; i++) {
			for(int j = i+1; j<N+1;j++) {
				double X = Math.abs(x[i] - x[j]);
				double Y = Math.abs(y[i] - y[j]);
				double X2 = Math.pow(X, 2);
				double Y2 = Math.pow(Y, 2);
				double w = Math.sqrt(X2 + Y2);
				q.add(new Node(i, j, w));
			}
		}

		
		
		
		
		double result = 0;
		while (!q.isEmpty()) {
			Node p = q.poll();
			int now = p.x;
			int next = p.y;
			double w = p.w;
			if (!union(now, next)) continue;
			result += w;
		}	

		System.out.printf("%.2f", result);
		br.close();
		bw.close();
	}

}