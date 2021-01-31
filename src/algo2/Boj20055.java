package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj20055 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] S = br.readLine().split(" ");

		int N = Integer.parseInt(S[0]);
		int K = Integer.parseInt(S[1]);
		
		int[][] belt = new int[2][N];
		int[][] robot = new int[2][N];

		String[] S2 = br.readLine().split(" ");
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			belt[1][N - i - 1] = Integer.parseInt(S2[S2.length - N + cnt]);
			belt[0][i] = Integer.parseInt(S2[cnt++]);
		}
		
		int Tcnt = 0;

		while (true) {
			Tcnt++;
			//System.out.println("------------------------------------------");
			//System.out.println(Tcnt + "단계 시작");
			//벨트 회전 			
			//System.out.println("벨트 회전");

			int temp = belt[0][N-1];
			int temp2 = belt[1][0];
			
			for(int i = N-1; i>0;i--) {
				belt[0][i] = belt[0][i-1];
				robot[0][i] = robot[0][i-1];
				robot[0][i-1] = 0;
			}

			for(int i = 0; i < N-1; i++) {
				belt[1][i] = belt[1][i+1];

			}
			belt[0][0] = temp2;
			belt[1][N-1] = temp;
			if(robot[0][N-1]== 1) robot[0][N-1]--;

			
			// 올라가는 벨트 회전

			for (int i = N - 2; i > -1; i--) {
				if (robot[0][i] == 0)
					continue; // 현재 위치에 로봇 없으면 pass
				if (belt[0][i + 1] == 0)
					continue; // 앞에 컨베이어 벨트에 내구도 0이면 pas
				if (robot[0][i + 1] == 1)
					continue; // 앞에 로봇 있으면 pass
				robot[0][i]--; // 현재 로봇 삭제
				robot[0][i + 1]++; // 현재 로봇 다음 베릍 추가
				belt[0][i + 1]--; // 다음 벨트 내구도 삭제
			}

			//System.out.println("올라가는 벨트 종료");
			if(robot[0][N-1]== 1) robot[0][N-1]--;
			// 벨트 이동 후 내려가는 위치 로봇 추가
			if (robot[0][N - 1] == 1 && robot[1][N - 1] == 0 && belt[1][N - 1] > 0) {
				robot[0][N - 1]--;
				robot[1][N - 1]++;
				belt[1][N - 1]--;
			}
			// 올라가는 위치 로봇 추가
			if (robot[0][0] == 0 && belt[0][0] > 0) {
				robot[0][0]++;
				belt[0][0]--;

			}

			int zero = 0;
			
			//System.out.println("현재 벨트 내구도 상황");
			for (int i = 0; i < 2; i++) {
				for(int j = 0;j <N;j++) {
					if(belt[i][j] == 0) zero++;
					//System.out.print(belt[i][j] + " ");
				}
				//System.out.println();
			}
			

			
			if(!(zero < K)) break;
		}
		
		System.out.println(Tcnt);;
		
		bw.close();
		br.close();
	}

}
