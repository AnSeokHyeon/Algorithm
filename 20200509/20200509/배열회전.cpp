#include <iostream>

using namespace std;

int map[8][8];
int chk1[8][8];
int chk2[8][8];
int chk3[8][8];
int main(void) {
	int T, Tcnt = 0;
	cin >> T;
	while (T--) {
		Tcnt++;
		int N;
		cin >> N;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk1[j][N + 1 - i] = map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk2[j][N + 1 - i] = chk1[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk3[j][N + 1 - i] = chk2[i][j];
			}
		}
		cout << "#" << Tcnt << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cout << chk1[i][j];
			}
			cout << " ";
			for (int j = 1; j <= N; j++) {
				cout << chk2[i][j];
			}
			cout << " ";

			for (int j = 1; j <= N; j++) {
				cout << chk3[i][j];
			}
			cout << endl;
		}
	}
}