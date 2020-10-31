#include <iostream>
#include <cstdio>


using namespace std;
int magnet[10][10];
int turn[10] = { 0 };

//void swap(int n, int m) {
//	int temp = m;
//	int m = n;
//	int n = temp;
//}

void turning() {
	for (int i = 1; i < 5; i++) {
		if (turn[i] == 0) continue;
		else if (turn[i] == 1) {
			for (int j = 8; j > 1; j--) {
				swap(magnet[i][j-1], magnet[i][j]);
			}
		}
		else if (turn[i] == -1) {
			for (int j = 1; j < 8; j++) {
				swap(magnet[i][j], magnet[i][j + 1]);
			}

		}

	}



}

void chk(int n, int m) {
	
	if (n > 5) return;
	if (n < 1) return;
	if (magnet[n][3] != magnet[n + 1][7] && n+1<5 && turn[n+1]==0) { 
		turn[n + 1] = m * (-1);

		//cout << " 체크 해 " << n + 1 << "  , " << turn[n + 1] << endl;
		chk(n + 1, turn[n + 1]);
	}
	//else {

	//	cout << " 체크 안해 " << n + 1 << "  , " << turn[n + 1] << endl;
	//	return;
	//}
	if (magnet[n][7] != magnet[n - 1][3] && n-1 > 0 && turn[n-1] == 0) {
		turn[n - 1] = m * (-1);

		//cout << " 체크 해 " << n - 1 << "  , " << turn[n - 1] << endl;
		chk(n - 1, turn[n - 1]);
	}
	//else { 
	//	cout << " 체크 안해 " << n - 1 << "  , " << turn[n - 1] << endl;
	//	return;
	//}
}

int main(void) {
	int T, Tcnt = 0;
	freopen("input.txt", "r", stdin);
	cin >> T;
	while (T--) {
		Tcnt++;
		int K;
		cin >> K;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 8; j++) {
				cin >> magnet[i][j];
			}
		}
		//for (int i = 1; i <= 4; i++) {
		//	for (int j = 1; j <= 8; j++) {
		//		cout << magnet[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		while (K--) {

			for (int i = 1; i <= 4; i++) {
				turn[i] = 0;
			}

			int magN, cur;
			cin >> magN >> cur;
			//cout << magN << " " << cur << endl;
			turn[magN] = cur;
			chk(magN, cur);
			//cout << " 체크 완료 " << endl;
			turning();
			//cout << " 터닝 완료 " << endl;

	/*		for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 8; j++) {
					cout << magnet[i][j];
				}
				cout << endl;
			}*/

		}
		int sum = 0;
		for (int i = 1; i < 5; i++) {
			sum = sum + magnet[i][1] * pow(2, i - 1);
		}
		cout<< "#" << Tcnt << " " << sum << endl;
	}

}