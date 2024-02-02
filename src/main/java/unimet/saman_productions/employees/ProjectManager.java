package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class ProjectManager extends Employee {
  public static final double REVIEW_DELAY = (double) 30 / 60 / 24;
  public static final double ANIME_DELAY = (double) 30 / 60 / 24;
  public static final double DEADLINE_DELAY = (double) 8 / 24;
  public static final int REVIEW_COUNT = 16;
  public static final int SALARY = 40;

  public static final int STATUS_WATCHING_ANIME = 0;
  public static final int STATUS_REVIEWING_WORK = 1;
  public static final int STATUS_CHECKING_DEADLINE = 2;

  private int status = STATUS_WATCHING_ANIME;
  private int reviewCount = 0;
  private int totalFaults = 0;
  private int currentFaults = 0;

  public ProjectManager(Studio studio) {
    super(studio);
  }

  @Override
  public int getSalary() {
    return SALARY;
  }

  public void registerFault() {
    currentFaults += 1;
    totalFaults += 1;
  }

  public void clearFaults() {
    currentFaults = 0;
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

  public int getStatus() {
    return status;
  }

  public int getTotalFaults() {
    return totalFaults;
  }

  public int getCurrentFaults() {
    return currentFaults;
  }

  @Override
  public void run() {
    while (!isInterrupted()) {
      try {
        if (reviewCount < getReviewCount()) {
          status = STATUS_WATCHING_ANIME;
          Thread.sleep(getAnimeDelay());
          status = STATUS_REVIEWING_WORK;
          Thread.sleep(getReviewDelay());
          reviewCount += 1;
        } else {
          if (getStudio().getDeadlineCounter() > 0) {
            getStudio().decreaseDeadlineCounter();
          }
          Thread.sleep(getDeadlineDelay());
          reviewCount = 0;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
