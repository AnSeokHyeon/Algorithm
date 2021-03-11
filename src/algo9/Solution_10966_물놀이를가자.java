package algo9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_10966_물놀이를가자 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static class Position{
		int x;
		int y;
		int d;
		public Position(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			Queue<Position> q = new LinkedList<>();

			char board[][] = new char[R+1][C+1];
			boolean chk[][] = new boolean[R+1][C+1];
			for(int i = 1; i<R+1; i++) {
				String s = br.readLine();
				for(int j = 1; j<C+1; j++) {
					board[i][j] = s.charAt(j-1);
					if(board[i][j] == 'W') q.add(new Position(i, j, 0));
				}
			}
			int result = 0;
			while(true) {
				int size = q.size();
				if(size == 0) break;
				
				while(size-- > 0) {
					Position p = q.poll();
					
					int x = p.x;
					int y = p.y;
					int d = p.d;
					
					for(int i = 0; i<4; i++) {
						int mx = x + dx[i];
						int my = y + dy[i];
						int md = d + 1;
						if(mx < 1 || my < 1|| mx > R || my > C) continue;
						if(board[mx][my] == 'W') continue;
						if(chk[mx][my]) continue;
						
						chk[mx][my] = true;
						result += md;
						q.add(new Position(mx, my, md));
						
					}
					
					
				}
				
			}
			
			
			sb.append("#" + (Tcnt++) + " "+ result+ "\n");
		}
		
		
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
