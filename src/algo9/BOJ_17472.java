package algo9;

// 17472 다리만들기 2
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {
	static int N;
	static int idx; 
	static int result = Integer.MAX_VALUE;
	static int map[][];
	static int board[][];
	static int dx[] = { 0, 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 0, 1, -1 };
	static ArrayList<Point> ladder = new ArrayList<>();
	static int min[][];
	static int pickNum[];
	static class Location {
		int x;
		int y;
		int d;
		int dir;

		public Location(int x, int y, int d, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer mapSize = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(mapSize.nextToken());
		int M = Integer.parseInt(mapSize.nextToken());

		map = new int[N + 1][M + 1];
		board = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		idx = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (board[i][j] > 0 || map[i][j] == 0)
					continue;
				board[i][j] = ++idx;
				q.add(new Point(i, j));

				while (!q.isEmpty()) {
					Point point = q.poll();

					int x = point.x;
					int y = point.y;

					for (int k = 1; k < 5; k++) {

						int mx = x + dx[k];
						int my = y + dy[k];
						if (mx < 1 || my < 1 || mx > N || my > M)
							continue;

						if (board[mx][my] > 0)
							continue;

						if (map[mx][my] == 0)
							continue;

						board[mx][my] = idx;
						q.add(new Point(mx, my));

					}

				}

			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[idx + 1];
		min = new int[idx + 1][idx + 1];
		for (int i = 0; i < idx + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				arr[board[i][j]].add(new Point(i, j));
			}
		}

		for (int i = 1; i <= idx; i++) {
			Queue<Location> lq = new LinkedList<>();
			int size = arr[i].size();
			boolean chk[][] = new boolean[N + 1][M + 1];
			for (int j = 0; j < size; j++) {
				int tempx = arr[i].get(j).x;
				int tempy = arr[i].get(j).y;
				chk[tempx][tempy] = true;
				lq.add(new Location(tempx, tempy, 0, 0));
			}

			while (!lq.isEmpty()) {
				Location l = lq.poll();

				int x = l.x;
				int y = l.y;
				int d = l.d;
				int dir = l.dir;
				for (int k = 1; k < 5; k++) {
					if (dir > 0 && dir != k)
						continue;
					int mx = x + dx[k];
					int my = y + dy[k];
					int md = d + 1;
					if (mx < 1 || my < 1 || mx > N || my > M)
						continue;
					if (chk[mx][my])
						continue;
					if (board[mx][my] > 0 && board[mx][my] != i) {
						if (min[i][board[mx][my]] == 0 && d > 1) {
							min[i][board[mx][my]] = d;
							min[board[mx][my]][i] = d;
						}
						continue;
					}
					chk[mx][my] = true;
					lq.add(new Location(mx, my, md, k));
				}

			}
		}
		for(int i = 1; i < idx+1; i++) {
			for(int j= i;j < idx+1; j++) {
				if(min[i][j] == 0) continue;
				ladder.add(new Point(i, j));
			}
		}
		
		pickNum = new int[ladder.size()];
		pick(0, 0);
		
		
		if(result == Integer.MAX_VALUE) bw.write("-1");
		else bw.write(result + "");
		br.close();
		bw.close();
	}
	
	static void pick(int n, int m) {
		if(n == idx-1) {
			check();
			return;
		}
		
		for(int i = m;i<ladder.size(); i++) {
			pickNum[n] = i;
			pick(n+1, i+1);
		}
	}
	
	static void check() {
		boolean chk[] = new boolean[idx+1];
		int weight[][] = new int[idx+1][idx+1];
		for(int i = 0; i<idx-1; i++) {
			int tempx = ladder.get(pickNum[i]).x;
			int tempy = ladder.get(pickNum[i]).y;
			weight[tempx][tempy] = weight[tempy][tempx] = min[tempx][tempy];
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		chk[1] = true;
		int cnt = 1; 
		int temp = 0;
		while(!q.isEmpty()) {
			Integer num = q.poll();
			
			for(int i = 1;i<idx+1; i++) {
				if(chk[i] || weight[num][i] == 0 ) continue;
				temp += weight[num][i];
				chk[i] = true;
				q.add(i);
				cnt++;
			}	
		}
		
		if(cnt == idx && temp > 0) {
			result = Math.min(result, temp);
		}
		
	}
	
}