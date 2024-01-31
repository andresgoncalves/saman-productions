package unimet.saman_productions.employees;

import unimet.saman_productions.studios.Studio;

public class Assembler extends Employee {
  private static double DELAY = 2;
  private static int SALARY = 50;

  private Studio studio;

  private int standardEpisodeCount = 0;
  private int plotTwistEpisodeCount = 0;

  private int plotTwistGapCount = 0;

  public Assembler(Studio studio) {
    this.studio = studio;
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
    while (true) {
      try {
        Thread.sleep(getDelay());
        if (plotTwistGapCount == studio.getPlotTwistGap()) {
          if (assemblePlotTwistEpisode()) {
            System.out.println("PlotTwist Creado");
            plotTwistGapCount = 0;
          }
        } else {
          if (assembleStandardEpisode()) {
            System.out.println("Episodio Creado");
            plotTwistGapCount += 1;
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private boolean assembleStandardEpisode() {
    if (Screenwriter.getSharedDrive().getCount() >= studio.getScripts()
        && SetDesigner.getSharedDrive().getCount() >= studio.getScenes()
        && Animator.getSharedDrive().getCount() >= studio.getAnimations()
        && VoiceActor.getSharedDrive().getCount() >= studio.getDubs()) {

      Screenwriter.getSharedDrive().release(studio.getScripts());
      SetDesigner.getSharedDrive().release(studio.getScenes());
      Animator.getSharedDrive().release(studio.getAnimations());
      VoiceActor.getSharedDrive().release(studio.getDubs());

      standardEpisodeCount += 1;

      return true;
    }

    return false;
  }

  private boolean assemblePlotTwistEpisode() {
    if (Screenwriter.getSharedDrive().getCount() >= studio.getScripts()
        && SetDesigner.getSharedDrive().getCount() >= studio.getScenes()
        && Animator.getSharedDrive().getCount() >= studio.getAnimations()
        && VoiceActor.getSharedDrive().getCount() >= studio.getDubs()
        && PlotTwistWriter.getSharedDrive().getCount() >= studio.getPlotTwistAmount()) {

      Screenwriter.getSharedDrive().release(studio.getScripts());
      SetDesigner.getSharedDrive().release(studio.getScenes());
      Animator.getSharedDrive().release(studio.getAnimations());
      VoiceActor.getSharedDrive().release(studio.getDubs());
      PlotTwistWriter.getSharedDrive().release(studio.getPlotTwistAmount());

      plotTwistEpisodeCount += 1;

      return true;
    }

    return false;
  }

  public int getStandardEpisodeCount() {
    return standardEpisodeCount;
  }

  public int getPlotTwistEpisodeCount() {
    return plotTwistEpisodeCount;
  }
}
