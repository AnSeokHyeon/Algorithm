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
pos apple[100];
pos worm[10000];
int map[101][101];
char timeInf[10000];
int dx[] = { 0,1,0,-1 };
int dy[] = {1,0,-1,0};
int main(void) {
	int cnt = 1, turn = 0;
	int N;
	int ans = 0;
	cin >> N;

	int K;
	cin >> K;

	for (int i = 0; i < K; i++) {
		cin >> apple[i].x >> apple[i].y;
		map[apple[i].x][apple[i].y] = 9;
	}

	int L;
	cin >> L;

	for (int i = 0; i < L; i++) {
		int n;
		cin >> n;
		cin >> timeInf[n];
	}
	worm[0].x = 1;
	worm[0].y = 1;
	int x = worm[0].x;
	int y = worm[0].y;
 	map[x][y] = 1;
 	for (int i = 1; i < 10001; i++) {
		int mx = x + dx[turn];
		int my = y + dy[turn];
		if (mx > N || my > N || mx < 1 || my < 1) {
			cout << i << endl;
			break;
		}
		if (map[mx][my] == 1) {
			cout<< i << endl;
			break;
		}
		if (map[mx][my] == 9) {
			cnt++;
			for (int j = cnt-1; j >0; j--) {
				worm[j].x = worm[j - 1].x;
				worm[j].y = worm[j - 1].y;
			}
		}
		else {
			map[worm[cnt - 1].x][worm[cnt - 1].y] = 0;
			for (int j = cnt - 1; j > 0; j--) {
				worm[j].x = worm[j - 1].x;
				worm[j].y = worm[j - 1].y;
			}
		}
		map[mx][my] = 1;
		worm[0].x = mx; worm[0].y = my;
		x = mx; y = my;
		if (timeInf[i]) {
			if (timeInf[i] == 'D') turn++;
			if (timeInf[i] == 'L') turn--;
			if (turn < 0) turn = 3;
			if (turn > 3 ) turn = 0;
		}
		//cout << i << " ÀÏ¶§ Áö··ÀÌ " << endl;
		//for (int j = 1; j <= N; j++) {
		//	for (int k = 1; k <= N; k++) {
		//		cout << map[j][k] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;
	}
}