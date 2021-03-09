package algo9;

// 2583 영역구하기
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int board[][] = new int[N][M];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			
			for(int k = x; k<dx; k++) {
				for(int j = y;j<dy;j++) {
					board[k][j] = -1;
				}
			}
		}
		Queue<Point> q = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		int idx =0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] != 0) continue;
				q.add(new Point(i, j));
				board[i][j] = ++idx;
				int cnt = 1;
				while(!q.isEmpty()) {
					Point p = q.poll();
					
					int x = p.x;
					int y = p.y;
					for(int k = 0; k<4; k++) {
						int mx = x+dx[k];
						int my = y + dy[k];
						if(mx < 0 || my < 0 || mx >N-1 || my > M-1) continue;
						if(board[mx][my] != 0 )continue;
						
						board[mx][my] = idx;
						cnt++;
						q.add(new Point(mx, my));
					}
				} // while 종료
				
				arr.add(cnt);
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(idx + "\n");
		Collections.sort(arr);
		int size = arr.size();
		for(int i = 0; i<size; i++) {
			sb.append(arr.get(i) + " ");
		}
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
