# Medium
# Shell
# https://leetcode.com/problems/word-frequency/

# Read from the file words.txt and output the word frequency list to stdout.
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -k1,1nr -k2 | awk '{print $2, $1}'