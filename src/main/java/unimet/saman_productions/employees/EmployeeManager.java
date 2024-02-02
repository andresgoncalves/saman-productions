package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class EmployeeManager {
  private Director director;
  private ProjectManager projectManager;
  private Employee[] employees;

  public EmployeeManager(Studio studio, int screewriters, int setDesigners, int animators, int voiceActors,
      int plotTwistWriters, int assemblers) {
    employees = new Employee[screewriters + setDesigners + animators + voiceActors + plotTwistWriters + assemblers];
    int i = 0;

    for (int j = 0; j < screewriters; j += 1, i += 1) {
      employees[i] = new Screenwriter(studio);
    }
    for (int j = 0; j < setDesigners; j += 1, i += 1) {
      employees[i] = new SetDesigner(studio);
    }
    for (int j = 0; j < animators; j += 1, i += 1) {
      employees[i] = new Animator(studio);
    }
    for (int j = 0; j < voiceActors; j += 1, i += 1) {
      employees[i] = new VoiceActor(studio);
    }
    for (int j = 0; j < plotTwistWriters; j += 1, i += 1) {
      employees[i] = new PlotTwistWriter(studio);
    }
    for (int j = 0; j < assemblers; j += 1, i += 1) {
      employees[i] = new Assembler(studio);
    }

    director = new Director(studio);
    projectManager = new ProjectManager(studio);
  }

  public void startAll() {
    director.start();
    projectManager.start();
    for (Employee employee : employees) {
      employee.start();
    }
  }

  public void stopAll() {
    director.interrupt();
    projectManager.interrupt();
    for (Employee employee : employees) {
      employee.interrupt();
    }
  }

  public Director getDirector() {
    return director;
  }

  public ProjectManager getProjectManager() {
    return projectManager;
  }

  public Employee[] getEmployees() {
    return employees;
  }

}
