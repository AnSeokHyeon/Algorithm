#include <iostream>
#include <vector>
#include <queue>
#include <functional>
#include <cstdio>

using namespace std;

struct custom {
	int no;
	int at;
	int a;
	int b;
	int t;
	int qt;

	custom() {
		this->no = 0;
		this->at = 0;
		this->a = 0;
		this->b = 0;
		this->t = 0;
		this->qt = 0;
	}
	custom(int no, int at, int a, int b, int t, int qt) {
		this->no = no;
		this->at = at;
		this->a = a;
		this->b = b;
		this->t = t;
		this->qt = qt;
	}
};
custom cus[1001];


struct cmp {
	bool operator()(custom t, custom u) {
		if (t.qt == u.qt) {
			return t.a > u.a;
		}
		return t.qt > u.qt;
	}
};

int main(void) {
	int T;
	freopen("sample_input.txt", "r", stdin);
	cin >> T;
	queue <custom> q;
	int cnt = 0;
	priority_queue< custom, vector<custom>, cmp > pq;
	while (T--) {
		int N, M, K, A, B;
		int a[3][10];
		int b[3][10];
		cnt++;
		cin >> N >> M >> K >> A >> B;
		if (cnt == 4) {
			cout << N << " " << M << " " << K << " " << A << " " << B << endl;
		}
		int sum = 0;
		int temp = 3000;
		int finish = 0;
		int nfull = 0;
		int mfull = 0;
		for (int i = 1; i <= N; i++) {
			int num;
			cin >> num;
			cout << num << " ";
			a[0][i] = i;
			a[1][i] = num;
			a[2][i] = 0;
		}
		cout << endl;
		for (int i = 1; i <= M; i++) {
			int num;
			cin >> num;
			cout << num << " ";
			b[0][i] = i;
			b[1][i] = num;
			b[2][i] = 0;
		}
		cout << endl;
		for (int i = 1; i <= K; i++) {
			int num;
			cin >> num;
			cus[i].no = i;
			cus[i].at = num;
			cus[i].qt = 0;
		}
		for (int t = 0; t < temp; t++) {
			for (int j = 1; j <= K; j++) {
				if (cus[j].at == t) {
					q.push(custom(cus[j].no, cus[j].at, cus[j].a, cus[j].b, cus[j].t, 0));
					//cout << "손님 입장 : " << cus[j].no << endl;
				}
				if (cus[j].at < t) continue;
				if (cus[j].at > t) break;
			}
			for (int j = 1; j <= K; j++) {
				if (cus[j].t > 0) cus[j].t--;
				else continue;

				if (cus[j].t == 0 && cus[j].a != 0 && cus[j].b == 0) {
					a[2][cus[j].a] = 0;
					nfull--;
					cus[j].qt = t;
					//cout<< " 1번 창구 확인 : " << a[2][1] << endl;
					pq.push(custom(cus[j].no, cus[j].at, cus[j].a, cus[j].b, cus[j].t, cus[j].qt));
				}
				if (cus[j].t == 0 && cus[j].b != 0) {
					b[2][cus[j].b] = 0;
					mfull--;
					if (cus[j].a == A && cus[j].b == B) {
						sum += cus[j].no;
					}
					cus[j].a = 0;
					cus[j].b = 0;
					finish++;
					if (finish == K) temp = 0;
				}
			}
			while (!q.empty()) {

				if (nfull == N) break;

				custom fc = q.front();

				//cout<< "현재 큐 손님 : " << fc.no << endl;
				for (int j = 1; j <= N; j++) {
					if (a[2][j] == 0) {
						a[2][j] = 1;
						cus[fc.no].a = j;
						cus[fc.no].t = a[1][j];
						nfull++;
						if(cnt == 4) cout << cus[fc.no].a << "번 창구에 들어온 현재 손님 : " << fc.no << " 소요시간 : " << cus[fc.no].t << endl;
						q.pop();
						break;
					}
					else { 
						continue;
					}
				}
			}

			while (!pq.empty()) {

				if (mfull == M) break;

				custom fc = pq.top();

				//cout<< "현재 큐 손님 : " << fc.no << endl;
				for (int j = 1; j <= M; j++) {
					if (b[2][j] == 0) {
						b[2][j] = 1;
						cus[fc.no].b = j;
						cus[fc.no].t = b[1][j];
						mfull++;
						pq.pop();
						break;
					}
					else { continue; }
				}
			}
			if(cnt == 4 ){
				cout << t << "일때" << endl;
				for (int a = 1; a <= K; a++) {
					cout << cus[a].no <<" ";
					cout << cus[a].at << " ";
					cout << cus[a].a << " ";
					cout << cus[a].b << " ";
					cout << cus[a].t << " ";
					cout << cus[a].qt << endl;
				}
			}
			
		}
		if (sum == 0) {
			cout << "#" << cnt << " " << -1 << endl;
		}
		else cout<<"#" << cnt << " " << sum <<  endl;
	}
}