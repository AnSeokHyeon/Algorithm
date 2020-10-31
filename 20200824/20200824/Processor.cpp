#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};

pos cell[13];
int map[14][14];
int N, Ccnt = 0;
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int cmax = 0;
int lmax = 987654321;
void dfs(int n, int m, int copy[][14]) {
	if (n == Ccnt) {
		if (m >= cmax) {
			if (m > cmax) lmax = 98765432;
			cmax = m;
			int temp = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//cout << copy[i][j] << " ";
					if (copy[i][j] != 0) temp++;
				}
				//cout << endl;
			}
			temp -= Ccnt-1;
			//cout << n << " / " << m << " / " << temp << " ";
			if (temp < lmax) lmax = temp;
			//cout << lmax << endl;
		}
		return;
	}

	int x = cell[n].x;
	int y = cell[n].y;

	if (x == 1 || y == 1 || y == N || x == N) {
		dfs(n + 1, m + 1, copy);
	}

	for (int i = 0; i < 4; i++) {

		if (i % 2 == 0) {
			if (i / 2 == 1) {
				for (int j = x + 1; j <= N; j++) {
					if (copy[j][y] != 0) break;
					if (j == N && copy[j][y] == 0) {
						for (int k = x + 1; k <= N; k++) {
							copy[k][y] = n;
						}
						dfs(n + 1, m + 1, copy);

						for (int k = x + 1; k <= N; k++) {
							copy[k][y] = 0;
						}
					}
				}
			}
			else {
				for (int j = x - 1; j > 0; j--) {
					if (copy[j][y] != 0) break;
					if (j == 1 && copy[j][y] == 0) {
						for (int k = x - 1; k > 0; k--) {
							copy[k][y] = n;
						}
						dfs(n + 1, m + 1, copy);

						for (int k = x - 1; k > 0; k--) {
							copy[k][y] = 0;
						}
					}
				}
			}

		}
		else {
			if (i / 2 == 1) {

				for (int j = y + 1; j <= N; j++) {
					if (copy[x][j] != 0) break;
					if (j == N && copy[x][j] == 0) {
						for (int k = y + 1; k <= N; k++) {
							copy[x][k] = n;
						}
						dfs(n + 1, m + 1, copy);
						for (int k = y + 1; k <= N; k++) {
							copy[x][k] = 0;
						}
					}
				}
			}
			else {

				for (int j = y - 1; j > 0; j--) {
					if (copy[x][j] != 0) break;
					if (j == 1 && copy[x][j] == 0) {
						for (int k = y - 1; k > 0; k--) {
							copy[x][k] = n;
						}
						dfs(n + 1, m + 1, copy);
						for (int k = y - 1; k > 0; k--) {
							copy[x][k] = 0;
						}
					}
				}
			}

		}
	}
	dfs(n + 1, m, copy);
}

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {

		cin >> N;
		Ccnt = 1;  
		cmax = 0;
		lmax = 987654321;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1) {
					cell[Ccnt].x = i;
					cell[Ccnt].y = j;
					Ccnt++;
				}
			}
		}

		dfs(1, 0, map);
		cout << "#" << Tcnt++ << " "<< lmax << endl;
	}
}