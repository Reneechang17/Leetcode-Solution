# Design a desk of poker card and impl shuffle and draw features

from collections import deque
import random

class Card:
    def __init__(self, suit, rank):
        self.suit = suit # Spade, Heart, Club, Diamond
        self.rank = rank
    
class Deck:
    def __init__(self):
        # assume we draw the card from top
        # popleft() is O(1)
        self.cards = deque()
        self.drawn = [] # the card we took
        self.build() # generate 52 cards

    def build(self):
        suits = ['S', 'H', 'C', 'D']
        ranks = ['A', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
        for s in suits:
            for r in ranks:
                self.cards.append(Card(s, r))
        
    def shuffle(self):
        # Fisher-Yates, iterate from end to make sure every time we fix a place
        cards_ls = list(self.cards)
        for i in range(len(cards_ls) - 1, 0, -1):
            j = random.randint(0, i) # random from [0,i]
            cards_ls[i], cards_ls[j] = cards_ls[j], cards_ls[i]
        self.cards = deque(cards_ls)
    
    def draw(self):
        if not self.cards:
            return None
        card = self.cards.popleft()
        self.drawn.append(card)
        return card

    def reset(self):
        # card: original order + drawn order
        self.cards.extend(self.drawn)
        self.drawn = []
    
    def remaining(self):
        return len(self.cards)
    