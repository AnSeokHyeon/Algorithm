// 분수 찾기
package algo;

import java.util.Scanner;

public class Boj1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int cnt = 0;
		for(int i = 1; ; i++) {
			int x=0;
			int y=0;
			
			if(i%2 == 0) {
				x = 1;
				y = i;	
			}
			else {
				x = i;
				y = 1;
			}
			for(int j = 0; j <i;j++) {
				int mx = 0;
				int my = 0;

				if(i%2 == 0) {
					mx = x + j;
					my = y - j;
				}
				else {
					mx = x - j;
					my = y + j;
				}
				cnt++;
				if(cnt == X) {				
					System.out.println(mx + "/" + my);
					break;
				}
			}
			if(cnt == X) break;
		}
		

	}

}
