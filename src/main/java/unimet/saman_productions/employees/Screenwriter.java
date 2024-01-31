package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Screenwriter extends StudioEmployee {
  public static final double DELAY = 4;
  public static final int SALARY = 20;
  public static final int DRIVE_SIZE = 25;

  public Screenwriter(Studio studio) {
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
