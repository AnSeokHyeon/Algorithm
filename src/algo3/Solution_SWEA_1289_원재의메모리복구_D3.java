//Solution_SWEA_1289_원재의메모리복구_D3
/*
좋으 코드, 효율적인 코드
- 시간 복잡도
- 공간 복잡도 ( 메모리 ) 
256MB = 256,000 KB = 256,000,000B;

int 4Byte
- 정답
- 가독성, 유지보수

1. 입력 60%
2. 출력 30%
3. 알고리즘 1%
4. 수학 9%

************Input************
Scanner 
nextInt()
nextDouble()
next()
데이터 앞쪽 whiteSpace 제거, 데이터 가져감, white space로 구분
========================
nextLine()

쪼개서 사용, 각 타입에 맞게 변환

BufferedReader 버퍼를 사용
String.split(" "); // 정규식을 사용함 -----------------------------------------------1
StringTokenizer st = new StringTokenizer (br.readLine(), " ") // ---------------2
=> 정규화 표현식때문에 느리므로 2번을 사용하는 것으로

안 쪼갤 수 있는 방법 => 나중에 문제가 나오면 설명 해줌

************Output************
BufferedWriter
System.out.println();
StringBuilder를 이용해 한번에 출력

백준
Main_백준_1289_원재의메모리복구_D3.java
정올
Main_정올_1289_원재의메모리복구_D3.java
SWEA
Solution_SWEA_1289_원재의메모리복구_D3.java
 */
package algo3;

import java.util.Scanner;

public class Solution_SWEA_1289_원재의메모리복구_D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int Tcnt = 1;
		while (T-- > 0) {
			String S = sc.next();
			int result = 0;
			char now = '0';
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);

				if (now == c)
					continue;
				else {
					now = c;
					result++;
				}

			}

			System.out.println("#" + (Tcnt++) + " " + result);
		}
		sc.close();
	}

}
