package algo11;

// 10217 KCM Travel
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10217 {

	static class Position {
		int n;
		int c;
		int d;

		public Position(int n, int c, int d) {
			super();
			this.n = n;
			this.c = c;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int min[][] = new int[N + 1][M + 1];

			@SuppressWarnings("unchecked")
			ArrayList<Position> arr[] = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				arr[i] = new ArrayList<>();
				Arrays.fill(min[i], Integer.MAX_VALUE);
			}

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				arr[a].add(new Position(b, c, d));

			}

			PriorityQueue<Position> q = new PriorityQueue<>(new Comparator<Position>() {

				@Override
				public int compare(Position o1, Position o2) {
					// TODO Auto-generated method stub
					return o1.d- o2.d;
				}
			});
			

			q.add(new Position(1, 0, 0));

			min[1][0] = 0;

			while (!q.isEmpty()) {

				Position p = q.poll();

				int now = p.n;
				if(now == N) break;
				int nowc = p.c;
				int nowd = p.d;
				if(nowd > min[now][nowc]) continue;

				int size = arr[now].size();

				for (int i = 0; i < size; i++) {
					int next = arr[now].get(i).n;
					int nextc = arr[now].get(i).c;
					int nextd = arr[now].get(i).d;

					if (nowc + nextc > M)
						continue; // 예산을 초과하면 bye

					if (nowd + nextd >= min[next][nowc + nextc])
						continue;
					min[next][nowc + nextc] = nowd + nextd;
					q.add(new Position(next, nowc + nextc, nowd + nextd));
				}

			}// 큐 종료
			
			int result = Integer.MAX_VALUE;
			for(int i= 0; i<M+1; i++) {
				if(min[N][i] == Integer.MAX_VALUE) continue;
				result = Math.min(result, min[N][i]);
				
			}
			
			if(result == Integer.MAX_VALUE) {
				sb.append("Poor KCM\n");
			}
			else {
				sb.append(result + "\n");
			}
			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}