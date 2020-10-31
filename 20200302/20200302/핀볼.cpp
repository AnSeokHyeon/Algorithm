#include <iostream>
#include <cstdio>
using namespace std;
int map[102][102];
int N;
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int temp;
int maxPin;
void pinball(int a, int b) {
	int x = a, y = b;
	//cout << "½ÃÀÛ ÁÂÇ¥ " << x << "," << y << " : " << map[x][y] << endl;
	for (int i = 0; i < 4; i++) {
		temp = 0;
		int j = i;
		x = a;
		y = b;
		while (1) {
			bool warf = false;
			//cout << " ÇöÀç ÁÂÇ¥ : " << x << " , " << y << "ÇÉº¼ ÇöÈ² : " << temp << " ¹æÇâ : " <<j << endl;

			int mx = x + dx[j];
			int my = y + dy[j];
			if (mx < 1) { j = 0;	temp++; }
			else if (my < 1) { j = 1; temp++; }
			else if (mx > N) { j = 2; temp++; }
			else if (my > N) { j = 3; temp++; }
			else if (map[mx][my] == -1) {
				//cout << "Á¾·á" << endl;
				if (temp > maxPin) maxPin = temp;
				break;
			}
			else if (mx == a && my == b) {
				//cout << "Á¾·á" << endl;
				if (temp > maxPin) maxPin = temp;
				break;
			}
			else if (map[mx][my] == 1) {
				if (j == 0) j = 1;
				else if (j == 3) j = 2;
				else j = (j + 2) % 4;
				temp++;
			}
			else if (map[mx][my] == 2) {
				if (j == 2) j = 1;
				else if (j == 3) j = 0;
				else j = (j + 2) % 4;
				temp++;
			}
			else if (map[mx][my] == 3) {
				if (j == 1) j = 0;
				else if (j == 2) j = 3;
				else j = (j + 2) % 4;
				temp++;
			}
			else if (map[mx][my] == 4) {
				if (j == 0) j = 3;
				else if (j == 1) j = 2;
				else j = (j + 2) % 4;
				temp++;
			}
			else if (map[mx][my] == 5) {
				j = (j + 2) % 4;
				temp++;
			}
			else if (map[mx][my] > 5) {
				for (int n = 1; n <= N; n++) {
					for (int m = 1; m <= N; m++) {
						if (map[mx][my] == map[n][m]) {
							if (mx == n && my == m) {
								//cout << "¾ÈÇØ" << endl;
								//cout << "¿úÈ¦ Á¤º¸" << endl;
								//cout << n << " , " << m << " // " << mx << " ," << my << endl;
							}
							else {
								//cout << " ¿öÇÁ " << endl;
								mx = n;
								my = m;

								//cout << "¿úÈ¦ Á¤º¸" << endl;
								//cout << n << " , " << m << " // " << mx << " ," << my << endl;
								warf = true;
							}
						}
						if (warf == true) break;
					}

					if (warf == true) break;
				}
			}
			x = mx;
			y = my;
		}
	}
}

int main(void) {
	int T;
	//freopen("sample_input.txt", "r", stdin);
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		Tcnt++;
		cin >> N;
		maxPin = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) continue;
				pinball(i, j);
			}
		}
		cout << "#" << Tcnt << " " << maxPin << endl;
	}
}