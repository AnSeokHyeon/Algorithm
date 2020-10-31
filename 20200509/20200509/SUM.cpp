#include <iostream>
#include <stdio.h>

using namespace std;

int map[101][101];

int main(void) {
	int T = 10;
	while (T--) {
		int Tcnt;
		cin >> Tcnt;
		int temp = 0;


		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++)
			{
				cin >> map[i][j];
			}
		}

		for (int i = 1; i <= 100; i++) {
			int sum = 0;
			for (int j = 1; j <= 100; j++)
			{
				sum = sum + map[i][j];
			}
			if (sum > temp) temp = sum;
		}

		for (int i = 1; i <= 100; i++) {
			int sum = 0;
			for (int j = 1; j <= 100; j++)
			{
				sum = sum + map[j][i];
			}
			if (sum > temp) temp = sum;
		}
		int tempsum = 0;
		for (int i = 1; i <= 100; i++) {
			tempsum = tempsum + map[i][i];

		}
		if (tempsum > temp) temp = tempsum;
		int tempsum2 = 0;
		for (int i = 1; i <= 100; i++) {
			tempsum2 = tempsum2 + map[i][101 - i];

		}
		if (tempsum2 > temp) temp = tempsum2;

		cout << "#" << Tcnt << " " << temp << endl;
	}
}