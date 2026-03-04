class Game:
    def __init__(self, player1: str, player2: str):
        self.players = [player1, player2]
        self.scores = {player1: 0, player2: 0}
        # key can win the value
        self.wins = {"rock": "scissors", "scissors": "paper", "paper": "rock"}
        self.last_winner = None
        self.streak = 0

    def play(self, move1: str, move2: str) -> str:
        p1, p2 = self.players
        if move1 == move2:
            if self.last_winner:
                self.scores[self.last_winner] += 1 # followup2 - tie bonus
            self.streak = 0 # followup1
            self.last_winner = None # followup1
            return "tie"
        winner = p1 if self.wins[move1] == move2 else p2
        # self.scores[winner] += 1

        if winner == self.last_winner:
            self.streak += 1
        else:
            self.streak = 1
        
        self.scores[winner] += self.streak
        self.last_winner = winner

        return winner
        
    def getScore(self, player: str) -> int:
        return self.scores[player]
    
if __name__ == "__main__":
    g = Game("renee", "mia")
    print(g.play("rock", "scissors")) # renee wins, streak=1 
    print(g.getScore("renee")) # 1

    print(g.play("paper", "paper")) # tie
    print(g.getScore("renee")) # 2

    g2 = Game("renee", "mia")
    print(g2.play("paper", "paper")) # tie
    print(g2.getScore("renee")) # 0
    print(g2.getScore("mia")) # 0
    

    g3 = Game("renee", "mia")
    print(g3.play("rock", "scissors")) # renee wins, streak=1 
    print(g3.play("rock", "scissors")) # renee wins, streak=2
    print(g3.play("paper", "paper")) # renee +1
    print(g3.getScore("renee")) # 4
    print(g3.play("rock", "scissors")) # streak resets to 1
    print(g3.getScore("renee")) # 5
    
    # print(g.play("scissors", "rock")) # mia wins, streak=1
    # # print(g.getScore("renee")) # 1
    # print(g.getScore("mia")) # 1
