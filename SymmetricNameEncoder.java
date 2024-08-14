// Amazon ng oa

public class SymmetricNameEncoder {
    public static String computeEncodedProductName(String nameString) {
        int[] counts = new int[26];
        for (char c : nameString.toCharArray()) {
            counts[c - 'a']++;
        }
 
        StringBuilder left = new StringBuilder();
        char center = 0;

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 1) {
                char ch = (char) (i + 'a');
                int pair = counts[i] / 2;
                for (int j = 0; j < pair; j++) {
                    left.append(ch);
                }
                counts[i] %= 2;
            }
            if (counts[i] == 1 && center == 0) {
                center = (char) (i + 'a');
            }
        }
        String leftStr = left.toString();
        String rightStr = left.reverse().toString();
        if (nameString.length() % 2 == 1) {
            return leftStr + center + rightStr;
        }
        return leftStr + rightStr;
    }

    public static void main(String[] args) {
        String nameString = "ded";
        System.out.println(computeEncodedProductName(nameString)); 
    }
}
