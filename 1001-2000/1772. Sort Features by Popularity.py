# Time:O(n * m), Space:O(n)

from typing import List

class Solution:
    def sortFeatures(self, features: List[str], responses: List[str]) -> List[str]:
        count = {feature: 0 for feature in features}

        for res in responses:
            words = set(res.split())
            for word in words:
                if word in count:
                    count[word] += 1

        idx_feature = [(feature, i) for i, feature in enumerate(features)]
        idx_feature.sort(key=lambda x: (-count[x[0]], x[1]))

        return [feature for feature, _ in idx_feature]
