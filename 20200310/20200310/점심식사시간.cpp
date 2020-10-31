#include <iostream>
#include <cstdio>
#include <queue>
#include <math.h>

using namespace std;

struct person {
	int x;
	int y;
	int t;
	int n;
	int d; 
	person() {
		this->x = 0;
		this->y = 0;
		this->t = 0;
		this->n = 0;
		this->d = 0;
	}
	person(int x, int y, int t, int n, int d) {
		this->x = x;
		this->y = y;
		this->t = t;
		this->n = n;
		this->d = d;
	}
};
person human[10];
person ladder[2];

int hcnt;
int lcnt;

int map[11][11];

void lunch() {
	queue <person> q1;
	queue <person> q2;
	int t = 0;
	for (int i = 0; i < hcnt; i++) {
		int x = abs(human[i].x - ladder[human[i].n].x);
		int y = abs(human[i].y - ladder[human[i].n].y);
		human[i].d = x + y;
	}
	for (int i = 0; i < hcnt; i++) {
		cout << i + 1 << "번째 정보 :  " << human[i].x << " , " << human[i].y << " , " << human[i].t << " , " << human[i].n << " , " << human[i].d << endl;
	}
	while (1) {
		t++;
		for (int i = 0; i < hcnt; i++) {
			human[i].d--;
			if (human[i].d == 0) {
				if (human[i].n == 0 && q1.size()<3) {
					q1.push(person(human[i].x, human[i].y, human[i].t, human[i].n, human[i].d));
				}
				else {
					q1.push(person(human[i].x, human[i].y, human[i].t, human[i].n, human[i].d));
				}
			}
		}
		


		if (q1.empty() && q2.empty()) break;
	}
}


int main(void) {
	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	while (T--) {
		int N;
		cin >> N;
		hcnt = 0;
		lcnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1) {
					human[hcnt].x = i;
					human[hcnt].y = j;
					human[hcnt].t = hcnt;
					human[hcnt].n = 0;
					hcnt++;
				}
				else if (map[i][j] > 1) {
					ladder[lcnt].x = i;
					ladder[lcnt].y = j;
					ladder[lcnt].t = map[i][j];
					lcnt++;
				}
			}
		}
		for (int i = hcnt-1; i>-1; i--) {
			human[i].n = 1;
			lunch();
		}
	}
}
