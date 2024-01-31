package unimet.saman_productions.employees;

import unimet.saman_productions.Drive;

public class SetDesigner extends StudioEmployee {
  private static double DELAY = 4;
  private static int SALARY = 26;
  private static int DRIVE_SIZE = 20;

  private static Drive drive = new Drive(DRIVE_SIZE);

  @Override
  public int getSalary() {
    return SALARY;
  }

  @Override
  public long getDelay() {
    return daysToMilliseconds(DELAY);
  }

  @Override
  public Drive getDrive() {
    return drive;
  }

  public static Drive getSharedDrive() {
    return drive;
  }
}
