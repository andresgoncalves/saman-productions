package unimet.saman_productions.employees;

public abstract class Employee extends Thread {
  public abstract int getSalary();

  protected long daysToMilliseconds(double days) {
    return (long) (days * 1000);
  }
}
