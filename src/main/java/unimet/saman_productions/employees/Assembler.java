package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Assembler extends Employee {
  public static final double DELAY = 2;
  public static final int SALARY = 50;

  private int plotTwistGapCount = 0;

  public Assembler(Studio studio) {
    super(studio);
  }

  @Override
  public int getSalary() {
    return SALARY;
  }

  public long getDelay() {
    return daysToMilliseconds(DELAY);
  }

  @Override
  public void run() {
    while (!isInterrupted()) {
      try {
        notifyAndSleep(getDelay());
        if (plotTwistGapCount == getStudio().getPlotTwistGap()) {
          if (getStudio().assemblePlotTwistEpisode()) {
            System.out.println("PlotTwist Creado");
            plotTwistGapCount = 0;
          }
        } else {
          if (getStudio().assembleStandardEpisode()) {
            System.out.println("Episodio Creado");
            plotTwistGapCount += 1;
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void notifyAndSleep(long time) throws InterruptedException {
    getStudio().getStudioView().actualizeFinances();
    Thread.sleep(time);
  }
}
