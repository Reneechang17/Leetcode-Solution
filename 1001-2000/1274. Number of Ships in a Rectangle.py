# Time:O(S*logA), Space:O(logA)

# class Solution:
#     def countShips(self, sea: 'Sea', topRight: 'Point', bottomLeft: 'Point') -> int:
#         def divide_and_conquer(x1, y1, x2, y2):
#             if x1 > x2 or y1 > y2:
#                 return 0
#             if not sea.hasShips(Point(x2, y2), Point(x1, y1)):
#                 return 0
#             if x1 == x2 and y1 == y2:
#                 return 1
            
#             mid_x = (x1 + x2) // 2
#             mid_y = (y1 + y2) // 2

#             count = 0
#             count += divide_and_conquer(x1, y1, mid_x, mid_y) # bottom-left
#             count += divide_and_conquer(mid_x + 1, y1, x2, mid_y) # bottom-right
#             count += divide_and_conquer(x1, mid_y + 1, mid_x, y2) # top-left
#             count += divide_and_conquer(mid_x + 1, mid_y + 1, x2, y2)
#             return count
        
#         return divide_and_conquer(bottomLeft.x, bottomLeft.y, topRight.x, topRight.y)
    