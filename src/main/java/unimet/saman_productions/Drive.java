package unimet.saman_productions;

import java.util.concurrent.Semaphore;

public class Drive {
  private Semaphore semaphore;
  private int count = 0;
  private final int size;

  public Drive(int size) {
    this.size = size;
    semaphore = new Semaphore(size);
  }

  public void acquire() {
    semaphore.acquireUninterruptibly();
    count += 1;
  }

  public void release() {
    semaphore.release();
    count -= 1;
  }

  public void release(int amount) {
    semaphore.release(amount);
    count -= amount;
  }

  public int getSize() {
    return size;
  }

  public int getCount() {
    return count;
  }

  public Semaphore getSemaphore() {
    return semaphore;
  }
}
