// Hard
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/text-justification/

import java.util.*;

class Solution {
  // 1. Collect words line by line without exceeding the maxWidth.
  // 2. If the line is full, justify it: 
  //    a. Distribute spaces evenly between words (two-end justification).
  //    b. Handle left alignment for the last line.
  // 3. Use a helper function to process the justification for each line.
  public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> res = new ArrayList<>();
      List<String> curLine = new ArrayList<>();
      int curLength = 0;
      
      for (String word : words) {
          // check if add the cur word exceeds maxWidth
          if (curLength + word.length() + curLine.size() > maxWidth) {
              // justify and add the cur line to res
              res.add(helper(curLine, curLength, maxWidth));
              // reset cur line and length for next line
              curLine.clear();
              curLength = 0;
          }
          // or add the cur word to cur line and update its length
          curLine.add(word);
          curLength += word.length();
      }
      // handle the last line(left-aligned)
      StringBuilder last = new StringBuilder(String.join(" ", curLine));
      while (last.length() < maxWidth) {
          last.append(" ");
      }
      res.add(last.toString());
      return res;
  }

  private String helper(List<String> curLine, int curLength, int maxWidth) {
      int space = maxWidth - curLength;
      int gap = curLine.size() - 1;

      // case1: only one word in the line
      if (gap == 0) {
          StringBuilder sb = new StringBuilder(curLine.get(0));
          while (sb.length() < maxWidth) {
              sb.append(" ");
          }
          return sb.toString();
      }

      // case2: distribute spaces evenly
      int spacePerGap = space / gap; // basic space per gap
      int extraSpaces = space % gap; // extra spaces to distribute

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < curLine.size(); i++) {
          sb.append(curLine.get(i)); // add the word
          if (i < gap) {
              // add basic space
              for (int j = 0; j < spacePerGap; j++) {
                  sb.append(" ");
              }
              // update extra space
              if (extraSpaces > 0) {
                  sb.append(" ");
                  extraSpaces--;
              }
          }
      }
      return sb.toString();
  }
}
