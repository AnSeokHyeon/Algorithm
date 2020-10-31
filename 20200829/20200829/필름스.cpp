#include <iostream>

using namespace std;

int d[] = {0, 1,2,3,4,5,6,7,8,9,10,11,12,13 };
int chk[14];
int chk2[14];
int D, W, K;
int film[14][21];
int temp[14];
int tempA[14];
int tempB[14];
int result;
bool safety = true;
int cnt;

void dfs2(int s, int t, int next, int l) {
	if (t == s) {
		int Bcnt = 0;
		int copy[14][21];
		for (int i = 1; i <= D; i++) {
			for (int j = 1; j <= W; j++) {
				copy[i][j] = film[i][j];
			}
		}
		for (int i = 0; i < l; i++) {
			int tempcnt = 0;
			for (int j = 0; j < t; j++) {
				if (temp[i] == tempA[j]) tempcnt = 1;
			}
			if (tempcnt == 0) tempB[Bcnt++] = temp[i];
		}
		/*cout << "temp 값 : ";
		for (int i = 0; i < l; i++) {
			cout << temp[i] << " ";
		}
		cout << endl;
		cout << "tempA 값 :  ";*/
		for (int i = 0; i < t; i++) {
			//cout << tempA[i] << " ";
			for (int j = 1; j <=W; j++) {
				copy[tempA[i]][j] = 0;
			}
		}
		/*cout << endl;
		cout << "tempB 값  : ";*/
		for (int i = 0; i <Bcnt; i++) {
			//cout << tempB[i] << " ";
			for (int j = 1; j <= W; j++) {
				copy[tempB[i]][j] = 1;
			}
		}
		//cout << endl;

		//for (int i = 1; i <= D; i++) {
		//	for (int j = 1; j <= W; j++) {
		//		cout << copy[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		safety = true;
		for (int j = 1; j <= W; j++) {
			int tp = 1;
			int tp2 = 0;
			for (int i = 1; i < D; i++) {
				if (copy[i][j] == copy[i + 1][j]) tp++;
				else tp = 1;
				if (tp > tp2) tp2 = tp;
			}
			if (tp2 < K) {
				safety = false;
				break;
			}
		}
		if (safety == true && l < result) result = l;
		//cout<< " 안전도 : " << safety << endl;
		return;
	}

	for (int i = next; i <l; i++) {
		if (chk2[i] == 1) continue;
		tempA[s] = temp[i];
		chk2[i] = 1;
		dfs2(s + 1, t, i + 1, l);
		chk2[i] = 0;
		tempA[s] = 0;
		if (safety == true) break;
	}
}

void dfs(int s, int t, int next) {
	if (t == s) {
		for (int i = 0; i <= t; i++) {
			dfs2(0, i, 0, t);
		}
		return;
	}

	for (int i = next; i <= D; i++) {
		if (chk[i] == 1) continue;
		temp[s] = d[i];
		chk[i] = 1;
		dfs(s + 1, t, i+1);
		chk[i] = 0;
		if (safety == true) break;
	}


}

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> D >> W >> K;
		for (int i = 1; i <= D; i++) {
			for (int j = 1; j <= W; j++) {
				cin >> film[i][j];
				//if (Tcnt == 4 || Tcnt == 7) cout << film[i][j]<< " ";
			}
			//if (Tcnt == 4 || Tcnt == 7) cout <<endl;
		}
		safety = true;
		result = 987654321;
		for (int j = 1; j <= W; j++) {
			int temp = 1;
			int temp2 = 0;
			for (int i = 1; i <D; i++) {
				if (film[i][j] == film[i + 1][j]) temp++;
				else temp = 1;
				if (temp > temp2) temp2 = temp;
			}
			if (temp2 < K) {
				safety = false;
				break;
			}
		}
		if (safety == false) {
			for (int i = 1; i <= K; i++) {
				//cout << i << " 개 색칠 공부 시작 @@@@@@@@@@@@@ " << endl;
				dfs(0, i, 1);
				if (safety == true) {
					//cout << "들어옴" << endl;
					break;
				}
			}
		}
		else result = 0;

		cout << "#" << Tcnt << " " << result <<endl;
		Tcnt++;
	}
}