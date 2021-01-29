// 영화감독 숌
package algo2;

import java.util.Scanner;

public class Boj1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i<3000000; i++) {
			if(String.valueOf(i).contains("666")){
				cnt++;
				if(cnt == n) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}
