package unimet.saman_productions.employees;

public class Director extends Employee {
  private static double DELAY = 2;
  private static int SALARY = 50;

  @Override
  public int getSalary() {
    return SALARY;
  }
}
