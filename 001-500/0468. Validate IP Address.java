// Easy
// String
// Time:O(1),Space:O(1)
// https://leetcode.cn/problems/validate-ip-address/

class Solution {
  public String validIPAddress(String queryIP) {
      if (queryIP.contains(".")) {
          return isIPv4(queryIP) ? "IPv4" : "Neither";
      } else if (queryIP.contains(":")) {
          return isIPv6(queryIP) ? "IPv6" : "Neither";
      }
      return "Neither";
  }
  private boolean isIPv4(String IP) {
      String[] parts = IP.split("\\.", -1); // -1确保不会miss空字符串
      if (parts.length != 4) return false;
      for (String part : parts) {
          if (part.length() == 0 || part.length() > 3) return false;
          if (part.charAt(0) == '0' && part.length() > 1) return false;
          if (!part.matches("\\d+")) return false;
          int num = Integer.parseInt(part);
          if (num < 0 || num > 255) return false;
      }
      return true;
  }
  private boolean isIPv6(String IP) {
      String[] parts = IP.split(":", -1);
      if (parts.length != 8) return false;
      for (String part : parts) {
          if (part.length() == 0 || part.length() > 4) return false;
          if (!part.matches("[0-9a-fA-F]+")) return false;
      }
      return true;
  }
}

// IPv4规则：1. 四个部分组成，使用"."分隔
//          2. 每个部分是0-255的整数，不能有前导0
//          3. 只能包含数字0-9
// IPv6规则：1. 八个部分组成，使用":"分隔
//          2. 每个部分是1-4位的16进位数（0-9/A-F/a-f）
//          3. 不能超过4位
