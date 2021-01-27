// 소인수분해
package algo;

import java.util.Scanner;

public class Boj11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = n;
		for(int i = 2; i<=n;i++) {
			if(temp % i == 0) {
				temp = temp / i;
				System.out.println(i);
				i--;
			}
		}
		
	}

}
