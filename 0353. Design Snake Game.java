// Medium
// Queue, HashTable, Design
// Time:O(1),Space:O(width * height)
// https://leetcode.cn/problems/design-snake-game/

// class SnakeGame {
//     // 查找蛇的身体部分
//     Map<Pair<Integer, Integer>, Boolean> snakeMap;
//     // 双端队列存储蛇的身体，每个节点是一个坐标
//     Deque<Pair<Integer, Integer>> snake;

//     int[][] food;
//     int foodIndex, width, height;

//     public SnakeGame(int width, int height, int[][] food) {
//         this.width = width;
//         this.height = height;
//         this.food = food;
//         this.snakeMap = new HashMap<Pair<Integer, Integer>, Boolean>();

//         this.snakeMap.put(new Pair<Integer, Integer>(0, 0), true);
//         this.snake = new LinkedList<Pair<Integer, Integer>>();
//         this.snake.offerLast(new Pair<Integer, Integer>(0, 0));
//     }
    
//     public int move(String direction) {
//         // 获取当前蛇头位置
//         Pair<Integer, Integer> curHead = this.snake.peekFirst();
//         int newHeadRow = curHead.getKey();
//         int newHeadCol = curHead.getValue();

//         switch (direction) {
//             case "U":
//                 newHeadRow--;
//                 break;
//             case "D":
//                 newHeadRow++;
//                 break;
//             case "L":
//                 newHeadCol--;
//                 break;
//             case "R":
//                 newHeadCol++;
//                 break;
//         }
//         // 构造新的蛇头位置
//         Pair<Integer, Integer> newHead = new Pair<>(newHeadRow, newHeadCol);
//         // 获取当前蛇尾位置
//         Pair<Integer, Integer> curTail = this.snake.peekLast();

//         // check新的蛇头是否超出边界
//         if (newHeadRow < 0 || newHeadRow >= this.height || newHeadCol < 0 || newHeadCol >= this.width) {
//             return -1;
//         }

//         // 检查自己身体碰撞：如果新蛇头位置已经存在，新蛇头不是蛇尾
//         if (this.snakeMap.containsKey(newHead) && !(newHead.getKey() == curTail.getKey() && newHead.getValue() == curTail.getValue())) {
//             return -1;
//         }

//         // 判断是否吃到食物：如果当前蛇头与食物位置相同，说明吃到食物，蛇长大
//         if (this.foodIndex < this.food.length && 
//             this.food[this.foodIndex][0] == newHeadRow &&
//             this.food[this.foodIndex][1] == newHeadCol) {
//                 this.foodIndex++;
//         } else {
//             // 没吃到
//             Pair<Integer, Integer> tail = this.snake.pollLast(); // 移除蛇尾
//             this.snakeMap.remove(tail);
//         }

//         this.snake.addFirst(newHead);
//         this.snakeMap.put(newHead, true);
//         return this.snake.size() - 1;
//     }
// }
