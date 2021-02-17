package algo6;

// 15558 점프게임

import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj15558 {

	static int N, K;
	static int line[][];
	static boolean lineChk[][];

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		line = new int[2][N + 1];
		lineChk = new boolean[2][N + 1];

		for (int i = 0; i < 2; i++) {
			String S = br.readLine();
			for (int j = 1; j < N + 1; j++) {
				line[i][j] = S.charAt(j - 1) - '0';
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 1));
		lineChk[0][1] = true;
		int time = 1;
		int result = 0;
		boolean chk = false;
		while (true) {
			int size = q.size();
			if(size == 0 || chk) break;
			while (size-- > 0) {
				Point top = q.poll();
				int x = top.x;
				int y = top.y;
				if(line[x][y] == 0 ) continue;
				int mx, my;
				for(int i = 0; i<3; i++) {
					mx = 0;
					my = 0;
					
					if(i == 0) {
						mx = x;
						my = y+1;
						
					}
					
					else if(i == 1) {
						mx = x ;
						my = y-1;
						
					}
					
					else if(i == 2) {
						mx = (x+1)%2;
						my = y+K;
						
					}
					if(mx > 1 || mx < 0 || my < 1) continue;
					if(my > N) {
						result = 1;
						chk = true;
						break;
						
					}
					if(line[mx][my] == 0) continue;
					if(lineChk[mx][my]) continue;
					q.add(new Point(mx, my));
					lineChk[mx][my] = true;
					
				}
				if(chk) break;
			}
			line[0][time] = 0;
			line[1][time++] = 0; 

		}
		bw.write(result + "");

		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료
}// 프로그램 종료 ㅃㅇ
