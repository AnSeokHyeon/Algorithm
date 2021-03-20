package algo10;

// 2887 행성터널
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2887 {
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
	
	static class Position{
		int idx;
		int x;
		int y;
		int z;
		public Position(int idx, int x, int y, int z) {
			super();
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		ArrayList<Position> arr = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			arr.add(new Position(i, x, y, z));
		}

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
		
		Collections.sort(arr, new Comparator<Position>() {

			@Override
			public int compare(Position o1, Position o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		for(int i = 0; i<N-1; i++) {
			int x = arr.get(i).x;
			int idx = arr.get(i).idx;
			int x2 = arr.get(i+1).x;
			int idx2 = arr.get(i+1).idx;
			q.add(new Node(idx, idx2, Math.abs(x - x2)));
		}
		Collections.sort(arr, new Comparator<Position>() {

			@Override
			public int compare(Position o1, Position o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		for(int i = 0; i<N-1; i++) {

			int x = arr.get(i).y;
			int idx = arr.get(i).idx;
			int x2 = arr.get(i+1).y;
			int idx2 = arr.get(i+1).idx;
			q.add(new Node(idx, idx2, Math.abs(x - x2)));
		}
		Collections.sort(arr, new Comparator<Position>() {

			@Override
			public int compare(Position o1, Position o2) {
				// TODO Auto-generated method stub
				return o1.z- o2.z;
			}
		});
		for(int i = 0; i<N-1; i++) {

			int x = arr.get(i).z;
			int idx = arr.get(i).idx;
			int x2 = arr.get(i+1).z;
			int idx2 = arr.get(i+1).idx;
			q.add(new Node(idx, idx2, Math.abs(x - x2)));
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