package algo10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int board[][];
	static ArrayList<Position> core;
	static int coreDir[];
	static int N, size, noLine, resultCore, resultLine;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static class Position{
		int x; 
		int y ;
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			core = new ArrayList<>();
			resultCore = 0;
			resultLine = Integer.MAX_VALUE;
			noLine = 0;
			N = Integer.parseInt(br.readLine());
			board = new int[N+1][N+1];
			for(int i = 1; i<N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j<N+1; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] == 1) {
						if(i == 1 || j == 1 || i == N || j == N) {
							noLine++;
						}
						else {
							core.add(new Position(i, j));
						}
					}
				}
			}
			size = core.size();
			coreDir = new int[size];
			pick(0, board, 0,noLine);
			sb.append("#" + (Tcnt++) + " "+ resultLine + "\n");
			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	static void pick(int n, int[][] map, int lineCnt, int coreCnt) {
		int copy[][] = new int[N+1][N+1];
		if(n == size) {
			if(coreCnt > resultCore) {
				resultCore = coreCnt;
				resultLine = lineCnt;
			}
			else if(coreCnt == resultCore) {
				resultLine = Math.min(lineCnt, resultLine);
			}
			System.out.println("결과*************");
	         for(int i = 1; i<=N; i++) {
	        	 for(int j = 1; j<=N; j++) {
	        		 System.out.print(map[i][j] + " ");
	        	 }
	        	 System.out.println();
	         }
	         System.out.println();
	         
			return;
		}
		boolean possible = false;
		for(int i = 0; i<4; i++) {

			for(int k = 0; k<N+1; k++) {
				System.arraycopy(map[k],0, copy[k], 0, N+1);
			}
			int x = core.get(n).x;
			int y = core.get(n).y;
			int cnt = 0;
			boolean chk = true;
			while(true) {
				int mx = x + dx[i] * (cnt+1);
				int my = y + dy[i] * (cnt+1);
				
				if(mx < 1 || my< 1|| mx > N || my > N ) {
					break;
				}
				if(copy[mx][my] > 0) {
					while(cnt > 0) {
						mx = x + dx[i]*cnt;
						my = y + dy[i]*cnt;
						copy[mx][my] = 0;
						cnt--;
					}
					chk = false;
					break;
				}
				copy[mx][my] = 2;
				cnt++;
			}
			if(chk) {
				possible = true;
				pick(n + 1, copy, lineCnt+cnt, coreCnt +1 );
			}

		}
		if(!possible) {
			pick(n + 1, copy, lineCnt, coreCnt);
		}
	}
}
