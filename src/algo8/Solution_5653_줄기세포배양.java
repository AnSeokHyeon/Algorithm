package algo8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Cell {
		int x;
		int y;
		int p;
		int addTime;
		int onTime;
		int deathTime;
		int nowTime;

		public Cell(int x, int y, int p, int addTime, int onTime, int deathTime, int nowTime) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.addTime = addTime;
			this.onTime = onTime;
			this.deathTime = deathTime;
			this.nowTime = nowTime;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		int map[][] = new int[900][900];
		PriorityQueue<Cell> q = new PriorityQueue<>(new Comparator<Cell>() {

			@Override
			public int compare(Cell o1, Cell o2) {
				// TODO Auto-generated method stub
				if (o1.nowTime == o2.nowTime) {
					return o2.p - o1.p;
				}
				return o1.nowTime - o2.nowTime;
			}
		});
		while (T-- > 0) {

			q.clear();
			for (int i = 0; i < 800; i++) {
				Arrays.fill(map[i], 0);
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			for (int i = 400; i < 400 + N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 400; j < 400 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0)
						q.add(new Cell(i, j, map[i][j], 0, map[i][j], map[i][j] * 2, 0));
				}
			}
			int time = 0;
			while (time < K + 1) {
				int size = q.size();
				while (size-- > 0) {

					Cell top = q.poll();
					int x = top.x;
					int y = top.y;
					int p = top.p;
					int at = top.addTime;
					int ot = top.onTime;
					int et = top.deathTime;
					int nt = top.nowTime;

					if (ot == time) {
						for (int i = 0; i < 4; i++) {
							int mx = x + dx[i];
							int my = y + dy[i];

							if (map[mx][my] > 0)
								continue;
							map[mx][my] = p;
							q.add(new Cell(mx, my, p, ot + 1, ot + 1 + p, ot + 1 + p * 2, nt + 1));

						}
					}
					if (et != time) {
						q.add(new Cell(x, y, p, at, ot, et, nt + 1));
					}
				}
			}
			int result = 0;
			while (!q.isEmpty()) {
				Cell a = q.poll();
				if (a.addTime <= K)
					result++;
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
