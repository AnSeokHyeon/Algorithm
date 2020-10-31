#include <iostream>
#include <queue>
#include <vector>
#include <functional>

using namespace std;

struct inf {
	int idx; // 고객 번호
	int tk; // 도착 시간
	int Ast; // A 접수 시작 시간
	int Aet; // A 접수 종료 시간
	int An; // A 창구 번호
	int Bst; // B 정비 시작 시간
	int Bet; // B 정비 종료 시간
	int Bn; // B 창구 번호
	inf() {
		this->idx = 0;
		this->tk = 0;
		this->Ast = 0;
		this->Aet = 0;
		this->An = 0;
		this->Bst = 0;
		this->Bet = 0;
		this->Bn = 0;
	}
	inf(int idx, int tk, int Ast, int Aet, int An, int Bst, int Bet, int Bn) {
		this->idx = idx;
		this->tk = tk;
		this->Ast = Ast;
		this->Aet = Aet;
		this->An = An;
		this->Bst = Bst;
		this->Bet = Bet;
		this->Bn = Bn;
	}
};

inf client[1001];
int boxA[10];
int chkA[10];
int boxB[10];
int chkB[10];

struct cmp {
	bool operator()(inf a, inf b) {
		if (a.tk == b.tk)
			return a.idx > b.idx;
		return a.tk > b.tk;
	}
};

struct cmp2 {
	bool operator()(inf a, inf b) {
		if (a.Aet == b.Aet)
			return a.An > b.An;
		return a.Aet > b.Aet;
	}
};

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		int N, M, K, A, B;
		int result = 0;
		priority_queue <inf, vector<inf>, cmp> pq;
		priority_queue <inf, vector<inf>, cmp2> pq2;
		cin >> N >> M >> K >> A >> B;

		for (int i = 1; i <= N; i++) {
			cin >> boxA[i];
		}
		for (int i = 1; i <= M; i++) {
			cin >> boxB[i];
		}

		for (int i = 1; i <= K; i++) {
			cin >> client[i].tk;
			client[i].idx = i;
			client[i].Ast = 0;
			client[i].Aet = 0;
			client[i].An = 0;
			client[i].Bst = 0;
			client[i].Bet = 0;
			client[i].Bn = 0;
			pq.push(inf(client[i].idx, client[i].tk, client[i].Ast, client[i].Aet, client[i].An, client[i].Bst, client[i].Bet, client[i].Bn));

		}

		int timer = 0;
		while (1) {
			int emptyA = 0;
			//cout << timer << " 초 " << endl;
			for (int i = 1; i <= N; i++) {
				if (chkA[i] != 0) {
					int n = chkA[i];
					if (client[n].Aet == timer) {
						pq2.push(inf(client[n].idx, client[n].tk, client[n].Ast, client[n].Aet, client[n].An, client[n].Bst, client[n].Bet, client[n].Bn));
						chkA[i] = 0;
						emptyA++;
					
						client[n].Ast = 0;
						client[n].Aet = 0;
					}
				}
				else {
					emptyA++;
				}
			}
			while (!pq.empty()) {
				inf f = pq.top();
				if (emptyA == 0) break;
				if (f.tk > timer) break;
				for (int i = 1; i <= N; i++) {
					if (chkA[i] != 0) continue;
					chkA[i] = f.idx;
					client[f.idx].Ast = timer;
					client[f.idx].Aet = timer + boxA[i];
					client[f.idx].An = i;
					emptyA--;
					pq.pop();
					break;
				}
			}

			int emptyB = 0;

			for (int i = 1; i <= M; i++) {
				if (chkB[i] != 0) {
					int n = chkB[i];
					if (client[n].Bet == timer) {
						chkB[i] = 0;
						emptyB++;
						if (A == client[n].An && B == client[n].Bn) {

							result = result + client[n].idx;
						}
						client[n].Bst = 0;
						client[n].Bet = 0;
					}
				}
				else emptyB++;
			}

			while (!pq2.empty()) {
				if (emptyB == 0) break;

				inf f = pq2.top();

				for (int i = 1; i <= M; i++) {
					if (chkB[i] > 0) continue;
					chkB[i] = f.idx;
					client[f.idx].Bn = i;
					client[f.idx].Bst = timer;
					client[f.idx].Bet = timer + boxB[i];
					pq2.pop();
					emptyB--;
					break;
				}
			}
			timer++;
			int cnt = 0;
			for (int i = 1; i <= K; i++) {
				if (client[i].Aet == 0 && client[i].Bet == 0 && client[i].Bn != 0) cnt++;
			}
			if (cnt == K) break;
		}
		if (result == 0) result = -1;
		cout << "#" << Tcnt++ << " " << result << endl;
	}

}