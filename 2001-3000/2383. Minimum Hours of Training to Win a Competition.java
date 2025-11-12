// Easy
// Simulate
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/

class Solution {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
      int totalTraining = 0, curEnergy = initialEnergy, curExp = initialExperience;
      for (int i = 0; i < energy.length; i++) {
          int opponentEnergy = energy[i];
          int opponentExp = experience[i];
          // check if the energy is enough
          if (curEnergy <= opponentEnergy) {
              int needed = opponentEnergy - curEnergy + 1;
              totalTraining += needed;
              curEnergy += needed;
          }
          // check if the exp is enough
          if (curExp <= opponentExp) {
              int needed = opponentExp - curExp + 1;
              totalTraining += needed;
              curExp += needed;
          }
          // update the status after beating the opponent
          curEnergy -= opponentEnergy;
          curExp += opponentExp;
      }
      return totalTraining;
  }
}
