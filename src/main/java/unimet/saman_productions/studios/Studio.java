package unimet.saman_productions.studios;

import unimet.saman_productions.StudioView;
import unimet.saman_productions.drives.DriveManager;
import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.Employee;
import unimet.saman_productions.employees.EmployeeManager;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.Screenwriter;
import unimet.saman_productions.employees.SetDesigner;
import unimet.saman_productions.employees.VoiceActor;

public abstract class Studio {
  private int totalEarnings = 0;
  private int totalExpenses = 0;
  private StudioView studioView;

  private int standardEpisodeCount = 0;
  private int plotTwistEpisodeCount = 0;

  private int deadlineCounter = 0;
  private final int deadline;
  private final String name;
  private final int secondsDay;

  private DriveManager driveManager = new DriveManager();
  private EmployeeManager employeeManager;

  private Object assemblerMutex = new Object();

  public Studio(int deadline, String name, int secondsDay) {
    this.name = name;
    this.deadline = deadlineCounter = deadline;
    this.secondsDay = secondsDay;
  }

  public abstract int getScripts();

  public abstract int getScenes();

  public abstract int getAnimations();

  public abstract int getDubs();

  public abstract int getStandardProfit();

  public abstract int getPlotTwistGap();

  public abstract int getPlotTwistAmount();

  public abstract int getPlotTwistProfit();

  public int getSecondsDay() {
    return secondsDay;
  }

  public void setStudioView(StudioView studioView) {
    this.studioView = studioView;
  }

  public String getName() {
    return name;
  }

  public StudioView getStudioView() {
    return studioView;
  }

  public DriveManager getDriveManager() {
    return driveManager;
  }

  public EmployeeManager getEmployeeManager() {
    return employeeManager;
  }

  public void start(EmployeeManager employeeManager) {
    this.employeeManager = employeeManager;
    employeeManager.startAll();
  }

  public void stop() {
    employeeManager.stopAll();
  }

  public boolean assembleStandardEpisode() {
    synchronized (assemblerMutex) {
      if (getDriveManager().getDrive(Screenwriter.class).getCount() >= getScripts()
          && getDriveManager().getDrive(SetDesigner.class).getCount() >= getScenes()
          && getDriveManager().getDrive(Animator.class).getCount() >= getAnimations()
          && getDriveManager().getDrive(VoiceActor.class).getCount() >= getDubs()) {

        getDriveManager().getDrive(Screenwriter.class).remove(getScripts());
        getDriveManager().getDrive(SetDesigner.class).remove(getScenes());
        getDriveManager().getDrive(Animator.class).remove(getAnimations());
        getDriveManager().getDrive(VoiceActor.class).remove(getDubs());

        driveManager.getStandardEpisodeDrive().upload();

        return true;
      }

      return false;
    }
  }

  public boolean assemblePlotTwistEpisode() {
    synchronized (assemblerMutex) {
      if (driveManager.getDrive(Screenwriter.class).getCount() >= getScripts()
          && driveManager.getDrive(SetDesigner.class).getCount() >= getScenes()
          && driveManager.getDrive(Animator.class).getCount() >= getAnimations()
          && driveManager.getDrive(VoiceActor.class).getCount() >= getDubs()
          && driveManager.getDrive(PlotTwistWriter.class).getCount() >= getPlotTwistAmount()) {

        driveManager.getDrive(Screenwriter.class).remove(getScripts());
        driveManager.getDrive(SetDesigner.class).remove(getScenes());
        driveManager.getDrive(Animator.class).remove(getAnimations());
        driveManager.getDrive(VoiceActor.class).remove(getDubs());
        driveManager.getDrive(PlotTwistWriter.class).remove(getPlotTwistAmount());

        driveManager.getPlotTwistEpisodeDrive().upload();

        return true;
      }

      return false;
    }
  }

  public int publishStandardEpisodes() {
    int count = driveManager.getStandardEpisodeDrive().getCount();
    driveManager.getStandardEpisodeDrive().remove(count);
    driveManager.getPublishedDrive().upload(count);
    registerEarning(count * getStandardProfit());
    return count;
  }

  public int publishPlotTwistEpisodes() {
    int count = driveManager.getPlotTwistEpisodeDrive().getCount();
    driveManager.getPlotTwistEpisodeDrive().remove(count);
    driveManager.getPublishedDrive().upload(count);
    registerEarning(count * getPlotTwistProfit());
    return count;
  }

  public void payEmployees() {
    for (Employee employee : employeeManager.getEmployees()) {
      registerExpense(employee.getSalary());
    }
    registerExpense(employeeManager.getDirector().getSalary());
    registerExpense(employeeManager.getProjectManager().getSalary());
    employeeManager.getProjectManager().clearFaults();
  }

  public void registerEarning(int amount) {
    totalEarnings += amount;
  }

  public void registerExpense(int amount) {
    totalExpenses += amount;
  }

  public void decreaseDeadlineCounter() {
    deadlineCounter -= 1;
  }

  public void resetDeadlineCounter() {
    deadlineCounter = deadline;
  }

  public int getStandardEpisodeCount() {
    return standardEpisodeCount;
  }

  public int getPlotTwistEpisodeCount() {
    return plotTwistEpisodeCount;
  }

  public int getTotalEarnings() {
    return totalEarnings;
  }

  public int getTotalExpenses() {
    return totalExpenses;
  }

  public int getTotalUtility() {
    return totalEarnings - totalExpenses;
  }

  public int getDeadline() {
    return deadline;
  }

  public int getDeadlineCounter() {
    return deadlineCounter;
  }
}
