//소수찾기
package algo;

import java.util.Scanner;

public class Boj1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N];
		for(int i = 0; i<N;i++) {
			num[i] = sc.nextInt();
		}
		int cnt = 0;
		for(int i = 0; i<N;i++) {
			int n = num[i];
			if(n == 1) continue;
			if(n == 2 || n== 3) {
				cnt++;
				continue;
			}
			boolean chk = true;
			for(int j = 2
					; j<=n/2;j++) {
				if(n % j == 0) {
					chk = false;
					break;
				}
			}
			if(chk) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
	
	}

}
