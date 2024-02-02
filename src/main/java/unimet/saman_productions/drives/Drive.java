package unimet.saman_productions.drives;

public class Drive {
  private int count = 0;

  public void upload() {
    count += 1;
  }

  public void upload(int amount) {
    count += amount;
  }

  public void remove() {
    count -= 1;
  }

  public void remove(int amount) {
    count -= amount;
  }

  public int getCount() {
    return count;
  }
}
