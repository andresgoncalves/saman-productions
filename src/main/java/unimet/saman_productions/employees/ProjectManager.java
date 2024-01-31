package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class ProjectManager extends Employee {
  public static final double REVIEW_DELAY = 1 / 2;
  public static final double ANIME_DELAY = 1 / 2;
  public static final double DEADLINE_DELAY = 8;
  public static final int REVIEW_COUNT = 16;
  public static final int SALARY = 40;

  private boolean working = false;
  private int reviewCount = 0;

  public ProjectManager(Studio studio) {
    super(studio);
  }

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
