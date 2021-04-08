package algo13;

//6593 상범빌딩
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
	
	static class Position{
		
		int x;
		int y;
		int z;
		int d;
		public Position(int x, int y, int z, int d) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}
	}
	
	static int dx[] = {1,-1,0,0,0,0};
	static int dy[] = {0,0,1,-1,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			
			char board[][][] = new char[L+1][R+1][C+1];
			boolean chkBoard[][][] = new boolean[L+1][R+1][C+1];
			Queue<Position> q = new LinkedList<>();
			
			for(int i = 1; i<L+1; i++) {
				
				for(int j = 1; j<R+1; j++) {
					String s = br.readLine();
					for(int k = 1; k<C+1; k++) {
						board[i][j][k] = s.charAt(k-1);
						if(board[i][j][k] == 'S') {

							q.add(new Position(j, k, i, 0));
							chkBoard[i][j][k] = true;
						}
						
					}
					
				}
				br.readLine();
			}
			int result = 0;
			boolean chk = false;
			while(!q.isEmpty()) {
				
				Position p = q.poll();
				
				int x = p.x;
				int y = p.y;
				int z = p.z;
				int d = p.d;
				
				if(board[z][x][y] == 'E') {
					chk = true;
					result = d;
					break;
				}
				
				for(int i = 0; i<6; i++) {
					
					int mx = x + dx[i];
					int my = y + dy[i];
					int mz = z + dz[i];
					int md = d + 1;
					if(mx < 1 || my < 1 || mz < 1 || mx > R || my > C || mz > L) continue;
					if(board[mz][mx][my] == '#') continue;
					if(chkBoard[mz][mx][my]) continue;
					
					chkBoard[mz][mx][my] = true;
					q.add(new Position(mx, my, mz, md));
					
				}
			}
			
			if(chk) {
				sb.append("Escaped in " + result + " minute(s).\n");
			}
			else {
				sb.append("Trapped!\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}