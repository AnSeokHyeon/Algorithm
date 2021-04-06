package algo13;

//2234 성곽
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N+1][M+1];
		int board[][] = new int[N+1][M+1];
		int size[] = new int[N*M+1];
		int idx = 1;
		int max = 0;
		
		int dx[]= {0,-1,0,1};
		int dy[] = {-1,0,1,0};
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<M+1; j++) {
				
				if(board[i][j] > 0)	 continue;
				
				int count = 1;
				board[i][j] = idx;
				q.add(new Point(i, j));
				
				while(!q.isEmpty()) {
					Point p = q.poll();
					
					int x = p.x;
					int y = p.y;
					
					for(int k = 0; k<4; k++) {
						if((map[x][y] & 1 << k) > 0) continue;
						int mx = x + dx[k];
						int my = y + dy[k];
						
						if(mx < 1|| my < 1|| mx > N ||my> M) continue;
						if(board[mx][my] > 0) continue;
						board[mx][my] = idx;
						count++;
						q.add(new Point(mx, my));
						
					}
				}// while문 종료
				size[idx] = count;
				idx++;
				max = Math.max(max, count);
			}
		}
		
		sb.append((idx-1) + "\n");
		sb.append(max + "\n");
		int hap = 0;
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<M+1; j++) {
				for(int k = 0; k<4; k++) {
					
					if((map[i][j] & 1 <<k) == 0) continue;
					
					int nexti = i + dx[k];
					int nextj = j + dy[k];
					if(nexti < 1 || nextj < 1 || nexti > N || nextj
							> M ) continue;
					if(board[i][j] == board[nexti][nextj]) continue;
					hap = Math.max(hap, size[board[i][j]] + size[board[nexti][nextj]]);
				}
			}
		}
		sb.append(hap);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}