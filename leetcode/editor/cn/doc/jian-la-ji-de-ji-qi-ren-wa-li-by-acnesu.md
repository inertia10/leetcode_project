#************ 解题思路
哈哈，瓦力从0,0出发，每个格子上有一个东西，比如，一个魔方，一个灯泡，一个打火机，瓦力每走到一个地方，就把东西收藏起来

### 代码

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        for(int i = 0; i<m; i++) Arrays.fill(map[i], 1);
        return f(map, 0, 0, k);
    }

    
    int f(int[][] map, int i, int j, int k){
        //递归停止条件就是达到了边界，或者已经访问过的点，如果不这样的话，递归就会无穷无尽，stackoverflow了！
        if(i < 0 || i >= map.length || j < 0 || j >= map[0].length || digitsum(i,j) > k || map[i][j] == 0)
            return 0;

        // 记得要将点设置成已访问，否则程序溢出
        int temp = map[i][j];
        map[i][j] = 0;
        return temp + f(map, i+1, j, k) + f(map, i-1, j, k) + f(map, i, j+1, k) + f(map, i, j-1, k);
    }

    // 计算所谓的数字和
    int digitsum(int i, int j){
        int ans = 0;
        while(i > 0){
            ans += i % 10;
            i/=10;
        }
        while(j > 0){
            ans += j % 10;
            j/=10;
        }
        return ans;
    }
}
```