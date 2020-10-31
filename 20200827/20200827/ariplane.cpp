#include <iostream>
#include <math.h>

using namespace std;
int N, X;
int map[21][21];
int arr[21];
int result;

void find(int n, int m) {
	bool line = true;
	//cout << " 시작 " << endl;
	if (m == 0) {
		for (int i = 1; i <= N; i++) {
			arr[i] = map[n][i];
		}
	}

	if (m == 1) {
		for (int i = 1; i <= N; i++) {
			arr[i] = map[i][n];
		}
	}

	for (int i = 1; i <= N; i++) {
		//cout << arr[i] << " ";
	}

	//cout << endl;

	for (int i = 1; i < N; i++) {
		if (abs(arr[i] - arr[i + 1]) > 10 + 10 * 1/(X+1)) {
			//cout << "0" << endl;
			line = false;
			break;
		}
		if ((arr[i] - arr[i + 1]) >= 10 ) {
			if ((i + X) > N) {
				//cout << "1" << endl;
				line = false;
				break;
			}
			for (int j = i + 1; j < X + i; j++) {
				if (arr[j] != arr[j + 1]) {
					//cout << "2" << endl;
					line = false;
					break;
				}
				if (j == X + i - 1) {
					for (int k = 0; k < X; k++) {
						arr[i+1 + k] = arr[i+1 + k] + 10 * (X - k) / (X + 1);
					}
				}
			}
			if (arr[X + i] < arr[X + i+1] && (i + X + 1) != N) {
				//cout << "3" << endl;
				line = false;
				break;
			}
		}
		else if ((arr[i] - arr[i + 1])<=-10) {
			if ((i - X+1) < 1) {
				//cout << "4" << endl;
				line = false;
				break;
			}

			for (int j = i; j > i - X +1; j--) {
				if (!(arr[j-1] == arr[j])) {
					//cout << "5" << endl;
					line = false;
					break;
				}
				if (j == i - X + 2) {

					for (int k = 0; k < X; k++) {
						arr[i - k] = arr[i - k] + 10 * (X - k) / (X + 1);
					}
				}
			}

		}
	}

	for (int i = 1; i <= N; i++) {
		//cout << arr[i] << " ";
	}

	//cout << endl;

	if (line == true) { 
		//cout << " 성공 ##" << endl;
		result++; 
	}
}


int main(void) {

	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N >> X;
		//if (Tcnt == 7) cout << N << " " << X << endl;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int temp;
				cin >> temp;
				map[i][j] = temp * 10;
				//if(Tcnt == 7) cout << temp << " ";
			}
			//if(Tcnt == 7)	cout << endl;
		}
		result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				find(i, j);
				//cout << endl;
			}
		}

		cout << "#" << Tcnt++ << " " << result << endl;
	}
}