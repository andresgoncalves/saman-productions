package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Director extends Employee {
  public static final double DELAY = 2;
  public static final int SALARY = 50;

  public Director(Studio studio) {
    super(studio);
  }

  @Override
  public int getSalary() {
    return SALARY;
  }
}
