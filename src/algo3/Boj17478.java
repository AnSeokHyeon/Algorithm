// 재귀 함수가 뭔가요?
package algo3;

import java.util.Scanner;

public class Boj17478 {
	static int N;
	static String[] S;

	static void f(int n) {
		if (n == N) {

			for (int i = 0; i < 6; i++) {
				if (i == 1 || i == 2|| i == 3) continue;
				for (int j = 0; j < n; j++) {
					System.out.print("____");
				}
				System.out.println(S[i]);
				if (i == 3)
					f(n + 1);

			}

			return;
		}

		for (int i = 0; i < 6; i++) {
			if (i == 4)
				continue;
			for (int j = 0; j < n; j++) {
				System.out.print("____");
			}
			System.out.println(S[i]);
			if (i == 3)
				f(n + 1);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = new String[6];
		S[0] = "\"재귀함수가 뭔가요?\"";
		S[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		S[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		S[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		S[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		S[5] = "라고 답변하였지.";

		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		f(0);
		sc.close();
		

	}

}
