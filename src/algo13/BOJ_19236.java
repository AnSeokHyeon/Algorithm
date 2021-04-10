package algo13;

// 19236 청소년 상어 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19236 {
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,-1,-1,-1,0,1,1,1};
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int board[][] = new int[4][4];
		int fish[][] = new int[17][3];
		
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<4; j++) {
				int temp = Integer.parseInt(st.nextToken());
				board[i][j] = temp;
				fish[temp][0] = i;
				fish[temp][1] = j;
				fish[temp][2] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
	
		move(0, 0, 0, fish, board,  0, 0);
		
		bw.write(result + "");
		br.close();
		bw.close();
	}
	private static void move(int sx, int sy, int sd, int[][] info, int[][] board, int eat, int depth) {

		int next = eat;
		int map[][] = new int[4][4];
		int fish[][] = new int[17][3];
		for(int i = 1; i<17; i++) {
			for(int j = 0;j<3; j++) {
				fish[i][j] = info[i][j];
			}
		}
		for(int i = 0; i<4; i++) {
			for(int j = 0;j<4; j++) {
				map[i][j] = board[i][j];
			}
		}
		
		int temp = map[sx][sy];
		sd = fish[temp][2];
		next += map[sx][sy];
		fish[temp][0] = -1;
		fish[temp][1] = -1;
		fish[temp][2] = -1;
		map[sx][sy] = 0;
		
		if(next > result) result = next;

		
		for(int i = 1; i<17; i++) {
			if(fish[i][0] == -1) continue;
			
			int x = fish[i][0];
			int y = fish[i][1];
			int d = fish[i][2];
			for(int j = 0; j<8; j++) {
				int md = (d + j)%8;
				int mx = x + dx[md];
				int my = y + dy[md];
				
				if(mx < 0 || my < 0 || mx > 3 || my > 3) continue;
				if(mx == sx && my == sy) continue;
				
				if(map[mx][my] > 0) {
					map[x][y] = map[mx][my];
					fish[map[mx][my]][0] = x;
					fish[map[mx][my]][1] = y;
				}else {
					map[x][y] = 0;
				}
				map[mx][my] = i;
				fish[i][0] = mx;
				fish[i][1] = my;
				fish[i][2] = md;
				break;
			}	
		}

		for(int i = 1; i<4; i++) {
			int mx = sx + dx[sd]*i;
			int my = sy + dy[sd]*i;
			
			if(mx < 0 || my < 0 || mx > 3|| my > 3) continue;
			if(map[mx][my] == 0) continue;
			move(mx, my, sd, fish, map, next, depth+1);
		}
	}

}