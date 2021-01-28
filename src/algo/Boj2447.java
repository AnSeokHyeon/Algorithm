package algo;
import java.util.Arrays;
import java.util.Scanner;

public class Boj2447 {
	//별을 빵꾸 뚫어 보자
	static char[][] star;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		star = new char[size][size];
		// 별찍고 시작
		for(int i = 0; i<size; i++) {
				Arrays.fill(star[i], '*');
		}
		
		staring(0,0, size);
		
		for(int i = 0; i<size; i++) {
			System.out.println(star[i]);
		}

	}
	public static void staring(int a, int b, int k) {
		int num = k /3;
		/*
		3^(k-1)로 나눈 몫이 1이면 빵구 뚫려 있음 고로 그 부분만 빵꾸 뚫는다.
		*/
		for(int i = a+num; i<a + num*2; i++) {
			for(int j = b+num; j<b + num*2;j++) {
					star[i][j] = ' ';
			}
		}
		if(k > 3) {
			for(int i = 0; i<3; i++) {
				for(int j = 0;j<3; j++) {
					if(i == 1 && j == 1) continue;
					// i, j 가 1이다 => 가운데 빵꾸 뚤려 있는 배열은 갈 필요가 없다. 
					staring(a + num*i, b + num*j, num);
				}
			}
		}
	}

}
