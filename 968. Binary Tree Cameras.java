// Hard
// Tree, Greedy
// O(n)
// https://leetcode.com/problems/binary-tree-cameras/

class Solution {
  int res = 0;

  public int minCameraCover(TreeNode root) {
    if (minCam(root) == 0) {
      res++;
    }
    return res;
  }

  // 0: 沒有覆蓋
  // 1: 有攝像頭
  // 2: 有被覆蓋

  public int minCam(TreeNode root) {
    if (root == null) {
      return 2; // 假設null節點是有被覆蓋的狀態，避免把攝像頭放在葉子節點
    }

    int left = minCam(root.left);
    int right = minCam(root.right);

    if (left == 2 && right == 2) {
      return 0;
    } else if (left == 0 || right == 0) {
      res++;
      return 1;
    } else {
      return 2; // 左邊或是右邊有攝像頭，那就是有被覆蓋的狀態
    }
  }
}

/**
 * 給定一個二叉樹，在樹的節點上安裝攝像頭，節點上的每個攝像頭可以監控其父節點、自身以及其子對象，計算樹的所有節點所需最少的攝像頭數量
 * 
 * 思路：攝像頭可以上下都照到，避免放在葉子節點，這樣只能照到它的父節點，所以可以將攝像頭放在葉子節點的父節點上（同理頭節點的情況） => 貪心
 * 那就是從下往上遍歷，使用後序遍歷
 * 
 * 難點：怎麼放攝像頭？？？
 * 可以考慮將每個節點可能有的狀態用數字表示
 * 0: 沒有覆蓋 1: 有攝像頭 2: 有被覆蓋
 * 
 * 遍歷的過程中可能會遇到空節點，那空節點應該是什麼狀態？
 * 空節點不能是沒有覆蓋的狀態（0），這樣就要在葉子節點放空，也不能是有攝像頭的狀態（1），這樣葉子他爹就沒必要放了
 * 結論：空節點只能是有覆蓋的狀態，所以遞歸遍歷的終止條件是if(cur == NULL) return 2;
 * 
 * 單層邏輯為
 * 1. 左右節點都有覆蓋，此時中間節點就是沒有覆蓋的狀態：0
 * 2. 左右至少有一個無覆蓋，以下情況中間應該放camera
 * a. 都無覆蓋 b. 左/右有攝像頭，另一邊沒有覆蓋 c. 其中一邊有覆蓋，另一邊沒有覆蓋
 * if(left == 0 || right == 0){
 *      result ++;
 *      return 1; // set camera
 * }
 * 3. 左右至少有一個攝像頭，並且另一邊有被覆蓋到，那麼中間就是有覆蓋的狀態：2
 * 4. 遍歷到最後的時候發現頭節點沒有被覆蓋：0 ⇒ result ++
 **/