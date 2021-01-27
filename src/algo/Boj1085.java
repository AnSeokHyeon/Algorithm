// 직사각형에서 탈출
package algo;

import java.util.Scanner;

public class Boj1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int minx = (x > w-x)? w-x:x;
		int miny = (y > h-y)? h-y:y;
		int min = (minx > miny)? miny : minx;
		
		System.out.println(min);
		
	}

}
