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
    try {
      while (!isInterrupted()) {
        NotifyAndSleep(getDelay());
        getStudio().getDriveManager().getDrive(this.getClass()).upload();
      }
    } catch (InterruptedException e) {
    }
  };

  protected void NotifyAndSleep(long time) throws InterruptedException {
    super.getStudio().getStudioView().notifyUpload();
    Thread.sleep(time);
  }
}
