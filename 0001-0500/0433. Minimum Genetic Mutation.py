# Time:O(n*m*4), Space:O(n)

from collections import deque
from typing import List

class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        gene_set = set(bank)
        if endGene not in gene_set:
            return -1

        que = deque([(startGene, 0)])
        vis = {startGene}

        while que:
            gene, steps = que.popleft()

            if gene == endGene:
                return steps

            for i in range(len(gene)):
                for c in "ACGT":
                    new_gene = gene[:i] + c + gene[i + 1 :]

                    if new_gene in gene_set and new_gene not in vis:
                        vis.add(new_gene)
                        que.append((new_gene, steps + 1))

        return -1
