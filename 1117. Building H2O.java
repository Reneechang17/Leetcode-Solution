// Medium
// Concurrency, Semaphore
// https://leetcode.cn/problems/building-h2o/

import java.util.concurrent.Semaphore;

class H2O {
  private Semaphore h = new Semaphore(2);
  private Semaphore o = new Semaphore(0);

  public H2O() {
      
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
  h.acquire();
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
      o.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
      o.acquire(2);
      // releaseOxygen.run() outputs "O". Do not change or remove this line.
  releaseOxygen.run();
      h.release(2);
  }
}

/**
 * 模擬水分子的生成過程，每個水分子由兩個氫原子和一個氧原子組成，需要保證每次輸出都是兩個H和一個O，並且以正確的順序組合
 * 而氫和氧原子都是通過多個線程併發運行的，因此需要同步機制來確保每次都是兩個氫原子和一個氧原子一起形成水
 * 題目還存在一個barrier，每個線程必須等候直到一個完整的水分子形成才能繼續運行，分別給予releaseHydrogen和 releaseOxygen來突破屏障
 * 
 * 這題可以用Semaphore來解決，我們可以用兩個Semaphore h和o來分別控制氫和氧原子的數量
 * 初始h的permits為2，允許兩個氫原子線程先執行；o的permits為0，表示氧原子線程需要等待，直到兩個氫原子都完成輸出
 * 
 * 氫原子方法：當氫原子線程調用acquire時，如果信號量h還有許可，則線程繼續執行，否則等待
 *           執行完releaseHydrogen後，線程會給o信號量釋放一個許可，表示處理了一個氫原子
 * 氧原子方法：當氧原子線程調用 o.acquire(2)時，表示它需要等待兩個氫原子線程釋放o的兩個許可才能繼續執行
 *           等待兩個氫原子線程都完成後，執行releaseOxygen，然後給h信號量釋放兩個許可，表示處理了一個氧原子
 **/
