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
    try {
      while (!isInterrupted()) {
        notifyAndSleep(getDelay());
        if (plotTwistGapCount == getStudio().getPlotTwistGap()) {
          if (getStudio().assemblePlotTwistEpisode()) {
            System.out.println("PlotTwist Creado. " + getStudio().getName());
            plotTwistGapCount = 0;
          }
        } else {
          if (getStudio().assembleStandardEpisode()) {
            System.out.println("Episodio Creado. " + getStudio().getName());
            plotTwistGapCount += 1;
          }
        }
      }
    } catch (InterruptedException e) {
    }
  }

  public void notifyAndSleep(long time) throws InterruptedException {
    getStudio().getStudioView().actualizeFinances();
    Thread.sleep(time);
  }
}
