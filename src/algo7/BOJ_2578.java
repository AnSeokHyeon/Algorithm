package algo7;

// 2578 빙고
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2578 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		int board[][] = new int[7][7];
		int input[] = new int[26];
		boolean chkBoard[][] = new boolean[7][7];
		for (int i = 1; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 6; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 5 * (i - 1) + 1; j < 5 * i + 1; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 1;
		while (idx < 26) {
			boolean chk = false;
			int result = 0;
			for (int i = 1; i < 6; i++) {
				for (int j = 1; j < 6; j++) {
					if (board[i][j] != input[idx])
						continue;
					chkBoard[i][j] = true;
					chk = true;
					break;
				}
				if (chk)
					break;
			}

			boolean chkSame = true;
			boolean chkDif = true;
			for (int i = 1; i < 6; i++) {
				boolean chkX = true;
				boolean chkY = true;

				for (int j = 1; j < 6; j++) {
					if (chkBoard[i][j])
						continue;
					chkX = false;
					break;
				}

				for (int j = 1; j < 6; j++) {
					if (chkBoard[j][i])
						continue;
					chkY = false;
					break;
				}

				if (!chkBoard[i][i])
					chkSame = false;
				if (!chkBoard[6 - i][i])
					chkDif = false;

				if (chkX)
					result++;
				if (chkY)
					result++;
			}

			if (chkSame)
				result++;
			if (chkDif)
				result++;

			if (result > 2)
				break;
			idx++;
		}

		bw.write(idx + "");
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
