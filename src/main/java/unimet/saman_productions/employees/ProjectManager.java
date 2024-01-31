package unimet.saman_productions.employees;

public class ProjectManager extends Employee {
  private static double REVIEW_DELAY = 1 / 2;
  private static double ANIME_DELAY = 1 / 2;
  private static double DEADLINE_DELAY = 8;
  private static int REVIEW_COUNT = 16;
  private static int SALARY = 40;

  private boolean working = false;
  private int reviewCount = 0;

  @Override
  public int getSalary() {
    return SALARY;
  }

  public long getReviewDelay() {
    return daysToMilliseconds(REVIEW_DELAY);
  }

  public long getAnimeDelay() {
    return daysToMilliseconds(ANIME_DELAY);
  }

  public long getDeadlineDelay() {
    return daysToMilliseconds(DEADLINE_DELAY);
  }

  public int getReviewCount() {
    return REVIEW_COUNT;
  }

  public boolean isWorking() {
    return working;
  }

  @Override
  public void run() {
    while (true) {
      try {
        if (reviewCount < getReviewCount()) {
          working = false;
          Thread.sleep(getAnimeDelay());
          working = true;
          Thread.sleep(getReviewDelay());
        } else {
          working = true;
          Thread.sleep(getDeadlineDelay());
          reviewCount = 0;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
