package algo14;
// [S/W 문제해결 응용] 4일차 - 보급로
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_SWEA_1249_보급로 {

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static class Position{
		int x;
		int y;
		int d;
		public Position(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			
			int N = Integer.parseInt(br.readLine());
			
			int board[][] =  new int[N+1][N+1];
			int min[][] = new int[N+1][N+1];
			
			for(int i = 1; i<N+1; i++) {
				String s = br.readLine();
				for(int j = 1;j<N+1; j++) {
					board[i][j] = s.charAt(j-1) - '0';
				}
				Arrays.fill(min[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<Position> q = new PriorityQueue<>(new Comparator<Position>() {
				@Override
				public int compare(Position o1, Position o2) {
					// TODO Auto-generated method stub
					return o1.d - o2.d;
				}
			});
			
			q.add(new Position(1, 1, 0));
			
			while(!q.isEmpty()) {
				Position p = q.poll();
				
				int x = p.x;
				int y = p.y;
				int d = p.d;
				
				for(int i = 0; i<4; i++) {
					int mx = x + dx[i];
					int my = y + dy[i];
					
					if(mx < 1 || my < 1 || mx > N || my > N )continue;
					int md = d + board[mx][my];
					if(md >= min[mx][my]) continue;
					min[mx][my] = md;
					q.add(new Position(mx, my, md));
					
				}
			}
			
			sb.append("#" + (Tcnt++) + " "+ min[N][N] + "\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}