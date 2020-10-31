#include <iostream>
#include <stdio.h> 

using namespace std;

int map[10][10];
int num[10];
int main(void) {
	int T, Tcnt = 0;
	freopen("input (2).txt", "r", stdin);
	cin >> T;
	while (T--)
	{
		Tcnt++;
		int result = 1;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 1; i < 10; i++) {
			int sum = 0;
			for (int j = 1; j < 10; j++) {
				sum = sum + map[i][j];
			}
			if (sum != 45) {
				result = 0;
				break;
			}
		}
		if (result == 1) {

			for (int i = 1; i < 10; i++) {
				int sum = 0;
				for (int j = 1; j < 10; j++) {
					sum = sum + map[j][i];
				}
				if (sum != 45) {
					result = 0;
					break;
				}
			}
		}
		if (result == 1) {
			for (int i = 1; i < 10; i++) {
				if (i % 3 != 1) continue;
				for (int j = 1; j < 10; j++) {
					if (j % 3 != 1)continue;
					int sum = 0;
					sum = sum + map[i][j];
					sum = sum + map[i][j+1];
					sum = sum + map[i][j+2];
					sum = sum + map[i+1][j];
					sum = sum + map[i+1][j+1];
					sum = sum + map[i+1][j+2];
					sum = sum + map[i+2][j];
					sum = sum + map[i+2][j+1];
					sum = sum + map[i+2][j+2];

					if (sum != 45) {
						result = 0;
						break;
					}
				}
			}
		}

		cout << "#" << Tcnt << " " << result << endl;
	}
}