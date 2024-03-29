package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Director extends Employee {
  public static final double CHECK_DURATION = (double) 35 / 60 / 24;
  public static final int SALARY = 60;

  public static final int STATUS_IDLE = 0;
  public static final int STATUS_PUBLISHING = 1;
  public static final int STATUS_SUPERVISING = 2;

  private int status = STATUS_IDLE;

  public Director(Studio studio) {
    super(studio);
  }

  @Override
  public int getSalary() {
    return SALARY;
  }

  @Override
  public void run() {
    try {
      while (!isInterrupted()) {
        if (getStudio().getDeadlineCounter() == 0) {
          status = STATUS_PUBLISHING;
          int standardEpisodeCount = getStudio().publishStandardEpisodes();
          int plotTwistEpisodeCount = getStudio().publishPlotTwistEpisodes();
          getStudio().registerEarning(
              standardEpisodeCount * getStudio().getStandardProfit()
                  + plotTwistEpisodeCount * getStudio().getPlotTwistProfit());
          getStudio().resetDeadlineCounter();

          System.out.println("Deadline encontrada. Se publicaron %d episodios estándar y %d plot twist. %s"
              .formatted(standardEpisodeCount, plotTwistEpisodeCount, getStudio().getName()));

          notifyFinalDay();
          notifyAndSleep(daysToMilliseconds(1));
        } else {
          status = STATUS_IDLE;
          boolean isWatchingAnime = false;
          double randomCheckDelay = Math.random() * (1 - CHECK_DURATION);
          ProjectManager projectManager = getStudio().getEmployeeManager().getProjectManager();

          notifyAndSleep(daysToMilliseconds(randomCheckDelay));
          status = STATUS_SUPERVISING;
          if (projectManager.getStatus() == ProjectManager.STATUS_WATCHING_ANIME) {
            isWatchingAnime = true;
          }

          notifyAndSleep(daysToMilliseconds(CHECK_DURATION / 2));
          if (projectManager.getStatus() == ProjectManager.STATUS_WATCHING_ANIME) {
            isWatchingAnime = true;
          }

          notifyAndSleep(daysToMilliseconds(CHECK_DURATION / 2));
          if (projectManager.getStatus() == ProjectManager.STATUS_WATCHING_ANIME) {
            isWatchingAnime = true;
          }

          if (isWatchingAnime) {
            System.out
                .println("Project Manager observado viendo Anime. Penalización aplicada. " + getStudio().getName());
            projectManager.registerFault();
          }

          status = STATUS_IDLE;
          notifyAndSleep(daysToMilliseconds(1 - randomCheckDelay + CHECK_DURATION));
        }
        getStudio().payEmployees();
        notifyFinalDay();
      }
    } catch (InterruptedException e) {
    }
  }

  public int getStatus() {
    return status;
  }

  public void notifyAndSleep(long time) throws InterruptedException {
    getStudio().getStudioView().actualizeDirectorStatus();
    Thread.sleep(time);
  }

  public void notifyFinalDay() {
    getStudio().getStudioView().actualizeFinances();
  }
}
