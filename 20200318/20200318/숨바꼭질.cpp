#include <iostream>
#include <queue>

struct pos {
	int x;
	int t;
	pos(int x, int t) {
		this->x = x;
		this->t = t;
	}
};


using namespace std;
int chk[100001];

int main(void) {
	int N, K, findTime = 0;
	cin >> N >> K;
	queue <pos> q;
	q.push(pos(N,0));
	chk[N] = 1;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int t = f.t;
		//cout<< "ÁÂÇ¥ : " << x <<" / ½Ã°£ : " << t << endl;
		if (x == K) { findTime = t; break; }
		
		for (int i = 0; i < 3; i++) {
			int mx;
			if (i == 0) mx = x - 1;
			else if (i == 1) mx = x + 1;
			else mx = x * 2;

			if (mx < 0 || mx > 100000) continue;
			if (chk[mx] == 1) continue;
			chk[mx] = 1;
			q.push(pos(mx, t + 1));
		}
	}
	cout << findTime;
	
}