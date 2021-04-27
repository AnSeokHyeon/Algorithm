package algo16;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
	static int dx[] = { 1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char board[][] = new char[N+1][M+1];
		boolean chk[][] = new boolean[N+1][M+1];
		for(int i = 1; i<=N; i++) {
			String s = br.readLine();
			for(int j = 1; j<=M;j++) {
				board[i][j] = s.charAt(j-1);
			}
		}
		int sheep = 0;
		int fox = 0;
		Queue<Point> q = new LinkedList<Point>();
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M;j++) {
				if(board[i][j]== '#') continue;
				if(chk[i][j]) continue;
				
				int sheeptemp= 0;
				int foxtemp = 0;
				
				q.add(new Point(i, j));
				chk[i][j] = true;
				if(board[i][j] == 'v') foxtemp++;
				else if(board[i][j] == 'o') sheeptemp++;
				
				while(q.size() > 0) {
					Point p = q.poll();
					
					int x = p.x;
					int y = p.y;
					
					for(int k = 0; k < 4; k++) {
						
						int mx = x + dx[k];
						int my = y + dy[k];
						
						if(mx < 1 || my < 1|| mx > N || my >M) continue;
						if(board[mx][my] == '#') continue;
						if(chk[mx][my]) continue;

						if(board[mx][my] == 'v') foxtemp++;
						else if(board[mx][my] == 'o') sheeptemp++;
						q.add(new Point(mx, my));
						chk[mx][my] = true;
					}
				}
				
				if(sheeptemp > foxtemp) {
					sheep += sheeptemp;
				}
				else {
					fox += foxtemp;
				}
				
			}
		}
		System.out.println(sheep + " " + fox);
		br.close();
		bw.close();
	}
}