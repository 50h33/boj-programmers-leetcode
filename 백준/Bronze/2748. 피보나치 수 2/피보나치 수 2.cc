#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n;
vector<ll> v(94);
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	
    cin >> n;
    v[0] = 0; v[1] = 1;
    for (int i = 2; i <= n; i++) {
        v[i] = v[i-1] + v[i-2];
    }
    cout << v[n] << "\n";
}