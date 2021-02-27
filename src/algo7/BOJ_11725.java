package algo7;

// 11725 트리의 부모 찾기
/*
 *
 */

import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr[] = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		int parent[] = new int[N + 1];
		boolean chk[] = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);

		}
		Queue<Integer> q = new LinkedList<Integer>();
		chk[1] = true;
		parent[1] = 0;
		q.add(1);
		while (!q.isEmpty()) {
			Integer head = q.poll();
			int size = arr[head].size();
			for (int i = 0; i < size; i++) {
				if (chk[arr[head].get(i)])
					continue;
				parent[arr[head].get(i)] = head;
				chk[arr[head].get(i)] = true;
				q.add(arr[head].get(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			sb.append(parent[i] + "\n");
		}
		bw.write(sb.toString());

		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
