package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class PlotTwistWriter extends StudioEmployee {
  public static final double DELAY = 2;
  public static final int SALARY = 34;
  public static final int DRIVE_SIZE = 10;

  public PlotTwistWriter(Studio studio) {
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
