#include <iostream>
#include <math.h>
#include <cstdio>
using namespace std;

struct bat {
	int x;
	int y;
	int n;
	int bc;
	bat() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
		this->bc = 0;
	}
	bat(int x, int y, int n, int bc) {
		this->x = x;
		this->y = y;
		this->n = n;
		this->bc = bc;
	}
};
bat AP[10];
int map[11][11];
int MA[101] = { 0 }, MB[101] = { 0 };
int chkA[10] = { 0 };
int chkB[10] = { 0 };
int dx[] = { 0,-1,0,1,0 };
int dy[] = { 0,0,1,0,-1 };


int main(void) {
	int T;
	freopen("sample_input.txt", "r", stdin);
	cin >> T;
	int M, A;
	int Tcnt = 0;
	while (T--) {
		cin >> M >> A;
		cout << M << " " << A << endl;
		Tcnt++;
		int ax = 1;
		int ay = 1;
		int bx = 10;
		int by = 10;
		int sum = 0;
		for (int i = 1; i <= M; i++) {
			cin >> MA[i];
			//cout << MA[i] << " ";
		}
		cout << endl;
		for (int i = 1; i <= M; i++) {
			cin >> MB[i];
			//cout << MB[i] << " ";
		}
		cout << endl;
		for (int i = 0; i < A; i++) {
			cin >> AP[i].y;
			cin >> AP[i].x;
			cin >> AP[i].n;
			cin >> AP[i].bc;

			//cout << AP[i].x << " " << AP[i].y << " " << AP[i].n << " " << AP[i].bc << endl;
		}


		for (int t = 0; t <= 20; t++) {
			int amx = ax + dx[MA[t]];
			int amy = ay + dy[MA[t]];

			int bmx = bx + dx[MB[t]];
			int bmy = by + dy[MB[t]];
			int tempMax = 0;
			for (int i = 0; i < A; i++) {
				//cout << amx<< " " << AP[i].x << " " << abs(amx - AP[i].x) << " : " << amy << " " << AP[i].y << " " << abs(amy - AP[i].y) << endl;
				//cout << bmx << " " << AP[i].x << " " << abs(bmx - AP[i].x) << " : " << bmy << " " << AP[i].y << " " << abs(bmy - AP[i].y) << endl;
				int da = abs(amx - AP[i].x) + abs(amy - AP[i].y);
				int db = abs(bmx - AP[i].x) + abs(bmy - AP[i].y);
				//cout<< i+1 << "번째 : "  << da << ", " << db << endl;
				if (da <= AP[i].n) {
					chkA[i] = 1;
				}
				if (db <= AP[i].n) {
					chkB[i] = 1;
				}
			}
			if(Tcnt == 2){
			cout << "A와 B의 " << t << " 시간에서의 기지국 " << endl;
			for (int i = 0; i < A; i++) {
				cout << chkA[i] << " ";
			}
			cout << endl;
			for (int i = 0; i < A; i++) {
				cout << chkB[i] << " ";
			}
			cout << endl;
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j < 11; j++) {
					if (i == amx && j == amy) cout << "*";
					else if (i == bmx && j == bmy)cout << "*";
					else cout << map[i][j];
				}
				cout << endl;
			}
			}
			for (int i = 0; i < A; i++) {
				int tempA = 0;
				if (chkA[i] == 1) tempA = AP[i].bc;
				if (t > 0 && MA[t] == 0) tempA = 0;
				for (int j = 0; j < A; j++) {
					int tempB = 0;
					if (i == j && chkA[i] == 1 && chkB[j] == 1) tempB = 0;
					else if (chkB[j] == 1) tempB = AP[j].bc;
					else tempB = 0;
					if (t > 0 && MB[t] == 0) tempB = 0;
					int tempC = tempA + tempB;
					if (tempC > tempMax) tempMax = tempC;
				}
			}
			cout << " @@@@@@@@@@ " << tempMax << endl;
			sum = sum + tempMax;

			ax = amx; ay = amy;
			bx = bmx; by = bmy;
			for (int i = 0; i < A; i++) {
				chkA[i] = 0;
				chkB[i] = 0;
			}
		}

		cout << "#" << Tcnt << " " << sum << endl;
	}
}