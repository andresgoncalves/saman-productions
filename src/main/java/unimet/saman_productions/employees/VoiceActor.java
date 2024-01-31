package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class VoiceActor extends StudioEmployee {
  public static final double DELAY = 1 / 5;
  public static final int SALARY = 16;
  public static final int DRIVE_SIZE = 35;

  public VoiceActor(Studio studio) {
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
