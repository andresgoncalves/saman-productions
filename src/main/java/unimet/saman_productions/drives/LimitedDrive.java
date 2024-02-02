package unimet.saman_productions.drives;

import java.util.concurrent.Semaphore;

public class LimitedDrive extends Drive {

  private Semaphore semaphore;
  private int count = 0;
  private final int size;

  public LimitedDrive(int size) {
    this.size = size;
    semaphore = new Semaphore(size);
  }

  public void upload() {
    semaphore.acquireUninterruptibly();
    count += 1;
  }

  public void upload(int amount) {
    semaphore.acquireUninterruptibly(amount);
    count += amount;
  }

  public void remove() {
    semaphore.release();
    count -= 1;
  }

  public void remove(int amount) {
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
