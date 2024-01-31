package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public abstract class StudioEmployee extends Employee {
  public StudioEmployee(Studio studio) {
    super(studio);
  }

  public abstract int getSalary();

  public abstract long getDelay();

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(getDelay());
        getStudio().getDriveManager().getDrive(this.getClass()).acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
