// 상수
package algo;

import java.util.Scanner;

public class Boj2908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int c = (a%10) * 100 + ((a/10)%10)*10 + (a/100);
		int d = (b%10) * 100 + ((b/10)%10)*10 + (b/100);
	
		int max = (c > d ? c : d);
		System.out.println(max);
		
		
		
		
	}

}
