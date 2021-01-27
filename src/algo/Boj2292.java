// 벌집
package algo;

import java.util.Scanner;

public class Boj2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int n = 0;
		
		int temp = 1;
		for (int i = 0; ; i++){
			n = 6 * i;
			temp += n;
			if (N <= temp) { 
				System.out.println(i+1);
			break;
			}
		}

	}

}
