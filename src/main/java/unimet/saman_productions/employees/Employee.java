package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public abstract class Employee extends Thread {
  private Studio studio;

  public Employee(Studio studio) {
    this.studio = studio;
  }

  public Studio getStudio() {
    return studio;
  }

  public abstract int getSalary();

  protected long daysToMilliseconds(double days) {
    return (long) (days * 1000);
  }
}
