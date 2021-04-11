package algo13;

// 1926 그림

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
	static int dx[] = { 1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int board[][] = new int[R+1][C+1];
		boolean chkboard[][] = new boolean[R+1][C+1];
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 1; i<R+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<C+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 0;
		int result = 0;
		for(int i = 1; i<R+1; i++) {
			for(int j = 1; j<C+1; j++) {
				if(board[i][j] == 0 || chkboard[i][j]) continue;
				int cnt = 1;
				q.add(new Point(i, j));
				chkboard[i][j] = true;
				
				while(!q.isEmpty()) {
					Point p = q.poll();
					
					int x = p.x;
					int y = p.y;
					
					for(int k = 0; k < 4; k++) {
						
						int mx = x + dx[k];
						int my = y + dy[k];
						
						if(mx < 1 || my < 1 || mx > R || my > C) continue;
						if(chkboard[mx][my]) continue;
						if(board[mx][my] == 0 ) continue;
						
						q.add(new Point(mx, my));
						chkboard[mx][my] = true;
						cnt++;
						
					}
					
				}
				idx++;
				result = Math.max(result, cnt);
			}
		}
		
		bw.write(idx + "\n" + result);
		
		
		br.close();
		bw.close();
	}
}