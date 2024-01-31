package unimet.saman_productions.employees;

import unimet.saman_productions.Drive;

public abstract class StudioEmployee extends Employee {
  public abstract int getSalary();

  public abstract long getDelay();

  public abstract Drive getDrive();

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(getDelay());
        getDrive().acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
