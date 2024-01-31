package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class SetDesigner extends StudioEmployee {
  public static final double DELAY = 4;
  public static final int SALARY = 26;
  public static final int DRIVE_SIZE = 20;

  public SetDesigner(Studio studio) {
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
