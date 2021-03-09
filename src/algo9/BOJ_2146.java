package algo9;
// 2146 다리 만들기
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

public class BOJ_2146 {
	static int N;
	static int map[][];
	static int board[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static class Location{
		int x; 
		int y;
		int d;
		public Location(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		board = new int[N+1][N+1];
		for(int i= 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 0;
		Queue<Point> q = new LinkedList<Point>();
		for(int i= 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				if(board[i][j] > 0 || map[i][j] == 0) continue;
				board[i][j] = ++idx;
				q.add(new Point(i, j));
				
				while(!q.isEmpty()) {
					Point point  = q.poll();
					
					int x = point.x;
					int y = point.y;
					
					for(int k = 0; k<4; k++) {
						
						int mx = x + dx[k];
						int my = y + dy[k];
						if(mx < 1 || my < 1 ||mx > N || my > N) continue;

						if(board[mx][my] > 0) continue;

						if(map[mx][my] == 0) continue;

						board[mx][my] = idx;
						q.add(new Point(mx, my));
						
					}
					
					
				}
				
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Point> arr[] = new ArrayList[idx+1];
		int min[][] = new int[idx+1][idx+1];
		for(int i = 0; i<idx+1; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i= 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				arr[board[i][j]].add(new Point(i, j));
			}
		}
		
		for(int i = 1; i<idx; i++) {
			Queue<Location> lq = new LinkedList<>();
			int size = arr[i].size();
			boolean chk[][] = new boolean[N+1][N+1];
			for(int j = 0; j < size; j++) {
				int tempx = arr[i].get(j).x;
				int tempy = arr[i].get(j).y;
				chk[tempx][tempy] = true;
				lq.add(new Location(tempx, tempy, 0));
			}
			
			while(!lq.isEmpty()) {
				Location l = lq.poll();
				
				int x = l.x;
				int y = l.y;
				int d = l.d;
				
				for(int k = 0; k < 4; k++) {
					int mx = x + dx[k];
					int my = y + dy[k];
					int md = d + 1;
					if(mx < 1 || my < 1 ||mx > N || my > N) continue;
					if(chk[mx][my]) continue;
					if(board[mx][my] > 0 && board[mx][my]!=i) {
						if(min[i][board[mx][my]] == 0) {
							min[i][board[mx][my]] = d;
							min[board[mx][my]][i] = d;
						}
						continue;
					}
					chk[mx][my] = true;
					lq.add(new Location(mx, my, md));
				}
				
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 1; i<idx+1; i++) {
			for(int j = 1; j<idx+1; j++) {
				if(min[i][j] == 0) continue;
				result = Math.min(result, min[i][j]);
			}
		}
		
		
		bw.write(result + "");
		br.close();
		bw.close();
	}

}