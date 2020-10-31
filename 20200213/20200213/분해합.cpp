#include <iostream>

using namespace std;

int main(void) {
	int N;
	cin >> N;
	int temp = 0;
	for (int i = 0; i < N; i++) {
		int a = i / 1000000;
		int b = (i / 100000) % 10;
		int c = (i / 10000) % 10;
		int d = (i / 1000) % 10;
		int e = (i / 100) % 10;
		int f = (i / 10) % 10;
		int g = i % 10;
		int sum = a + b + c + d + e + f + g + i;
		if (sum == N) {
			temp = i;
			break;
		}
	}
	cout << temp;
}