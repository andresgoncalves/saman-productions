package unimet.saman_productions.employees;

import unimet.saman_productions.Drive;

public class VoiceActor extends StudioEmployee {
  private static double DELAY = 1 / 5;
  private static int SALARY = 16;
  private static int DRIVE_SIZE = 35;

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
