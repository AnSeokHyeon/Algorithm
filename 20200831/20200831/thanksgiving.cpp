#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;
struct pos {
    int st;
    int et;
    pos(int st, int et) {
        this->st = st;
        this->et = et;
    }

    pos() {
        this->st = 0;
        this->et = 0;
    }
};


vector <pos> t;

int find(int n) {
    int cnt = 0;
    int st = t[n].st;
    int et = t[n].et;
    //cout << n + 1<< "번째 @@@@@@@@@@@@@@@@@@@@" << endl;
    for (int i = n; i < t.size(); i++) {
        if (t[i].st > et + 999) continue;
        cnt++;
        //cout << i << " ";

    }
    //cout << endl;
   // cout <<"겹치는거 : " <<cnt << endl;
    return cnt;


}

void transform(vector<string> lines) {
    for (int i = 0; i < lines.size(); i++) {
        //cout << lines[i] << endl;
        int H;
        H = (lines[i][0] - '0')*10 + lines[i][1] - '0';
        int M;
        M = (lines[i][3] - '0') * 10 + lines[i][4] - '0';
        int S;
        S = (lines[i][6] - '0') * 10 + lines[i][7] - '0';
        int MS;
        MS = (lines[i][9] - '0') * 100 + (lines[i][10] - '0') * 10 + lines[i][11] - '0';
        //cout << "시간 변환" << endl;
        //cout << H << ":" << M << ":" << S << ":" << MS << endl;
        int K = H * 3600 * 1000 + M * 60 * 1000 + S * 1000 + MS;

        int mMS = 0;
        int cnt = 0;
        for (int j = 13;j < lines[i].size(); j++) {
            char temp = lines[i][j];
            if (temp == '.') continue;
            if (temp == 's') break;
            temp = temp - '0';
            mMS = mMS + temp * pow(10, 3-cnt++);
        }
        t.push_back(pos(K - mMS+1, K));

    }

}

int solution(vector<string> lines) {
    int answer = 0;

    int n = lines.size();

    vector<string> lines2;
    for (int i = 0; i < lines.size(); i++) {
        lines2.push_back(lines[i].substr(11));
        //cout << lines2[i] << endl;
    }
    transform(lines2);
    for (int i = 0; i < t.size(); i++) {
        answer = max(answer, find(i));
    }
    //for (int i = 0; i < lines.size(); i++) {
    //    cout << lines2[i] << endl;
    //}
    return answer;
}
int main(void) {

    vector<string> v = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
    cout << solution(v);
}