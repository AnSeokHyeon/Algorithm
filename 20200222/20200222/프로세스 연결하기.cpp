#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

pos core[12];
int coreN;
int N;
int map[13][13];
int chk[13][13];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int maxCore;
int minLine;
void pro(int n, int m) {
	if (n == coreN) {
		if (m > maxCore) {
			maxCore = m;
			int cnt = 0;
			//cout << "연결된 프로세스 : " << m << " 들어 왔어용 " << endl;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//cout << chk[i][j];
					if (chk[i][j] == 1) cnt++;
				}
			//	cout << endl;
			}
			minLine = cnt;
			//cout << " 이번 프로세스 간선은 : " << cnt << "최소 간선은 : " << minLine << endl;
		}
		else if (m == maxCore) {
			int cnt = 0;
			//cout << "연결된 프로세스 : " << m << " 들어 왔어용 " << endl;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
				//	cout << chk[i][j];
					if (chk[i][j] == 1) cnt++;
				}
			//	cout << endl;
			}
			if (cnt < minLine) minLine = cnt;
			//cout << " 이번 프로세스 간선은 : " << cnt << "최소 간선은 : " << minLine << endl;
		}
		return;
	}
	int cx = core[n].x;
	int cy = core[n].y;
	if (cx == 1 || cy == 1 || cx == N || cy == N) {
		pro(n + 1, m + 1);
	}
	else {
		for (int i = 0; i < 4; i++) {
			int x = cx;
			int y = cy;
			if (i == 0) {
				for (int j = 0; j < N - cx; j++) {
					int mx = cx + dx[i] * (j + 1);
					int my = cy + dy[i] * (j + 1);
					if (chk[mx][my] != 0) {
						for (int k = 0; k < j; k++) {
							int mmx = cx + dx[i] * (k + 1);
							int mmy = cy + dy[i] * (k + 1);
							chk[mmx][mmy] = 0;
						}
						break;
					}
					chk[mx][my] = 1;
					if (mx == N) {
						pro(n + 1, m + 1);
						for (int k = 0; k <= j; k++) {
							int mmx = cx + dx[i] * (k + 1);
							int mmy = cy + dy[i] * (k + 1);
							chk[mmx][mmy] = 0;
						}

					}
				}
			}
			else if (i == 1) {
				for (int j = 1; j < cx; j++) {
					int mx = cx + dx[i] * (j);
					int my = cy + dy[i] * (j);
					if (chk[mx][my] != 0) {
						for (int k = 1; k < j; k++) {
							int mmx = cx + dx[i] * (k);
							int mmy = cy + dy[i] * (k);
							chk[mmx][mmy] = 0;
						}
						break;
					}
					chk[mx][my] = 1;
					if (mx == 1) {
						pro(n + 1, m + 1);
						for (int k = 1; k <= j; k++) {
							int mmx = cx + dx[i] * (k);
							int mmy = cy + dy[i] * (k);
							chk[mmx][mmy] = 0;
						}

					}
				}

			}
			else if (i == 2) {
				for (int j = 0; j < N - cy; j++) {
					int mx = cx + dx[i] * (j + 1);
					int my = cy + dy[i] * (j + 1);
					if (chk[mx][my] != 0) {
						for (int k = 0; k < j; k++) {
							int mmx = cx + dx[i] * (k + 1);
							int mmy = cy + dy[i] * (k + 1);
							chk[mmx][mmy] = 0;
						}
						break;
					}
					chk[mx][my] = 1;
					if (my == N) {
						pro(n + 1, m + 1);
						for (int k = 0; k <= j; k++) {
							int mmx = cx + dx[i] * (k + 1);
							int mmy = cy + dy[i] * (k + 1);
							chk[mmx][mmy] = 0;
						}
					}
				}

			}
			else if (i == 3) {
				for (int j = 1; j < cy; j++) {
					int mx = cx + dx[i] * (j);
					int my = cy + dy[i] * (j);
					if (chk[mx][my] != 0) {
						for (int k = 1; k < j; k++) {
							int mmx = cx + dx[i] * (k);
							int mmy = cy + dy[i] * (k);
							chk[mmx][mmy] = 0;
						}
						break;
					}
					chk[mx][my] = 1;
					if (my == 1) {
						pro(n + 1, m + 1);
						for (int k = 1; k <= j; k++) {
							int mmx = cx + dx[i] * (k);
							int mmy = cy + dy[i] * (k);
							chk[mmx][mmy] = 0;
						}

					}
				}

			}

		}
		pro(n + 1, m);
	}
}


int main(void) {
	int T;
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		cin >> N;
		Tcnt++;
		maxCore = 0;
		minLine = 300;
		coreN = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				chk[i][j] = 0;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1) {
					chk[i][j] = 2;
					core[coreN].x = i;
					core[coreN].y = j;
					coreN++;
				}
			}
		}
		pro(0, 0);
		cout << "#" <<Tcnt << " "<< minLine << endl;
	}
}