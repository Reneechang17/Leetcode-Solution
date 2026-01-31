# Time:O(S*logA), Space:O(logA)
# Time depends on the number of ships, with pruning, it could be ships*tree height

# """
# This is Sea's API interface.
# You should not implement it, or speculate about its implementation
# """
class Sea:
   def hasShips(self, topRight: 'Point', bottomLeft: 'Point') -> bool:
        return True # placeholder~

class Point:
	def __init__(self, x: int, y: int):
		self.x = x
		self.y = y

class Solution:
    def countShips(self, sea: 'Sea', topRight: 'Point', bottomLeft: 'Point') -> int:
        
        # helper to count ships inside rectangle [x1...x2]*[y1...y2]
        def dfs(x1: int, y1: int, x2: int, y2: int) -> int:
            if x1 > x2 or y1 > y2:
                return 0
            
            # if no ship in this rectangle -> pruning 
            if not sea.hasShips(Point(x2, y2), Point(x1, y1)):
                return 0
            
            # rectangle is a single point and hasShip==True
            if x1 == x2 and y1 == y2:
                return 1
            
            # then split into 4 sub-rectangles by midpoints
            mx = (x1 + x2) // 2
            my = (y1 + y2) // 2

            # bottom-left:[x1..mx]*[y1..my]
            # bottom-right:[mx+1..x2]*[y1..my]
            # top-left:[x1..mx]*[my+1..y2]
            # top-right:[mx+1..x2]*[my+1..y2]
            return (dfs(x1, y1, mx, my) + 
                    dfs(mx + 1, y1, x2, my) + 
                    dfs(x1, my + 1, mx, y2) + 
                    dfs(mx + 1, my + 1, x2, y2))

        return dfs(bottomLeft.x, bottomLeft.y, topRight.x, topRight.y)
    