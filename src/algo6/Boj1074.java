package algo6;

// 1074 Z

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.StringTokenizer;

public class Boj1074 {
	static int N, R, C;
	static int size, idx;

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		idx = size * size;

		z(0, 0, N, N, N, 0, size);

		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

	static void z(int stx, int sty, int ex, int ey, int d, int i, int size) {
		if (d == 0) {
			System.out.println(i);
			return;
		}
		int cutR = stx + size / 2;
		int cutC = sty + size / 2;
		int index = size * size;
		if (R < cutR) {
			if (C < cutC) {
				z(stx, sty, cutR, cutC, d - 1, i + index * 0, size / 2);

			} else {
				z(stx, cutC, cutR, size, d - 1, i + index / 4 * 1, size / 2);
			}

		} else {
			if (C < cutC) {
				z(cutR, sty, size, cutC, d - 1, i + index / 4 * 2, size / 2);
			} else {
				z(cutR, cutC, size, size, d - 1, i + index / 4 * 3, size / 2);
			}

		}

	}

}// 프로그램 종료 ㅃㅇ
