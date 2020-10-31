#include <iostream>
#include <cstdio>

using namespace std;

struct number {
	int NO; //����ȣ
	int AT; //�����ð�
	int Nnum; //���� â�� ��ȣ
	int Mnum; //���� â�� ��ȣ
	bool Ntf; // ���� �Ϸ� ����
	bool Mtf; // ���� �Ϸ� ����
	int timer; // ����ð�

	number() {
		this->NO = 0;
		this->AT = 0;
		this->Nnum = 0;
		this->Mnum = 0;
		this->Ntf = false;
		this->Mtf = false;
		this->timer = 0;
	}

};
number person[1001];
int N, M, K, A, B;
int a[10][10], b[10][10];
int t[1001];
int clientnum;

int main(void) {
	int T; // �׽�Ʈ ���̽�
	freopen("sample_input.txt", "r", stdin);
	cin >> T; // �׽�Ʈ ���̽� ���� �Է�
	while (T--) {
		clientnum = 0;
		cin >> N >> M >> K >> A >> B;
		// ���� â�� N, ���� â�� M, ���� K, �н� ���� A ,�н� ���� B;

		for (int i = 1; i <= N; i++) {
			cin >> a[i][0];
			a[i][1] = false;
		}

		for (int i = 1; i <= M; i++) {
			cin >> b[i][0];
			b[i][1] = false;
		}

		for (int i = 1; i <= K; i++) {
			cin >> t[i];
			person[i].NO = i;
			person[i].AT = t[i]; 
			person[i].Nnum = 0;
			person[i].Mnum = 0;
			person[i].Ntf = false;
			person[i].Mtf = false;
			person[i].timer = 0;
		}

		for (int i = 0; i < 2000; i++) {
			for (int j = 1; j <= K; j++) {
				if(person[j].AT > i) continue; // ���� �ð����� �����ð��� ���� ��� pass
				if (person[j].Ntf && person[j].Mtf) continue;

				if (!person[j].Ntf) {
					if (person[j].timer > 0) {
						person[j].timer--;
						if (person[j].timer == 0) {
							person[j].Ntf = true;
							a[person[j].Nnum][1] = false;
						}
					}

					for (int x = 1; x <= N; x++) {
						if (person[j].Nnum > 0) continue;
						if (a[x][1]) continue;
						person[j].Nnum = x;
						person[j].timer = a[x][0];
						a[x][1] = true;
					}
				}

				if(!person[j].Mtf && person[j].Ntf)  {
					if (person[j].timer > 0) {
						person[j].timer--;
						if (person[j].timer == 0) {
							person[j].Mtf = true;
							b[person[j].Mnum][1] = false;
							if (person[j].Nnum == A && person[j].Mnum == B)
								clientnum = clientnum + person[j].NO;
						}
					}

					for (int x = 1; x <= N; x++) {
						if (person[j].Mnum > 0) continue;
						if (b[x][1]) continue;
						person[j].Mnum = x;
						person[j].timer = b[x][0];
						b[x][1] = true;
					}
				}
			}
			/*cout << i << "�϶�"<<endl;
			for (int a = 1; a <= K; a++) {
				cout << person[a].NO << " ";
				cout << person[a].AT << " ";
				cout << person[a].Nnum << " ";
				cout << person[a].Mnum << " ";
				cout << person[a].Ntf << " ";
				cout << person[a].Mtf << " ";
				cout << person[a].timer << endl;
			}*/
		}
		if (clientnum == 0) cout << -1;
		cout << clientnum << endl;
	}
}