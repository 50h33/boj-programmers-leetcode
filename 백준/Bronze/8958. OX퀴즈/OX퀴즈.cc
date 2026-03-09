#include <bits/stdc++.h>
using namespace std;
int t;
string s;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> t;
    while (t--) {
        cin >> s;
        int ans = 0, cnt = 0;
        for (char ch : s) {
            if (ch == 'O') {
                cnt++; ans += cnt;
            } else {
                cnt = 0;
            }
        }
        cout << ans << "\n";
    }
}