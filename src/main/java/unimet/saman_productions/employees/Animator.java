package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Animator extends StudioEmployee {
  public static final double DELAY = 1;
  public static final int SALARY = 40;
  public static final int DRIVE_SIZE = 55;

  public Animator(Studio studio) {
    super(studio);
  }

  @Override
  public int getSalary() {
    return SALARY;
  }

  @Override
  public long getDelay() {
    return daysToMilliseconds(DELAY);
  }
}
