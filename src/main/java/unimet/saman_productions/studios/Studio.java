package unimet.saman_productions.studios;

import unimet.saman_productions.DriveManager;
import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.Screenwriter;
import unimet.saman_productions.employees.SetDesigner;
import unimet.saman_productions.employees.VoiceActor;

public abstract class Studio {

  private int totalEarnings = 0;
  private int totalExpenses = 0;

  private int standardEpisodeCount = 0;
  private int plotTwistEpisodeCount = 0;

  private DriveManager driveManager = new DriveManager();

  public Studio() {
    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            Thread.sleep(1000);
            System.out.println("Reporte diario:" + "\n> Gastos: " + totalExpenses + "\n> Ingresos: " + totalEarnings);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }

  public abstract int getScripts();

  public abstract int getScenes();

  public abstract int getAnimations();

  public abstract int getDubs();

  public abstract int getProfit();

  public abstract int getPlotTwistGap();

  public abstract int getPlotTwistAmount();

  public abstract int getPlotTwistProfit();

  public DriveManager getDriveManager() {

    return driveManager;
  }

  public boolean makeStandardEpisode() {
    if (getDriveManager().getDrive(Screenwriter.class).getCount() >= getScripts()
        && getDriveManager().getDrive(SetDesigner.class).getCount() >= getScenes()
        && getDriveManager().getDrive(Animator.class).getCount() >= getAnimations()
        && getDriveManager().getDrive(VoiceActor.class).getCount() >= getDubs()) {

      getDriveManager().getDrive(Screenwriter.class).release(getScripts());
      getDriveManager().getDrive(SetDesigner.class).release(getScenes());
      getDriveManager().getDrive(Animator.class).release(getAnimations());
      getDriveManager().getDrive(VoiceActor.class).release(getDubs());

      standardEpisodeCount += 1;
      totalEarnings += getProfit();

      return true;
    }

    return false;
  }

  public boolean makePlotTwistEpisode() {
    if (driveManager.getDrive(Screenwriter.class).getCount() >= getScripts()
        && driveManager.getDrive(SetDesigner.class).getCount() >= getScenes()
        && driveManager.getDrive(Animator.class).getCount() >= getAnimations()
        && driveManager.getDrive(VoiceActor.class).getCount() >= getDubs()
        && driveManager.getDrive(PlotTwistWriter.class).getCount() >= getPlotTwistAmount()) {

      driveManager.getDrive(Screenwriter.class).release(getScripts());
      driveManager.getDrive(SetDesigner.class).release(getScenes());
      driveManager.getDrive(Animator.class).release(getAnimations());
      driveManager.getDrive(VoiceActor.class).release(getDubs());
      driveManager.getDrive(PlotTwistWriter.class).release(getPlotTwistAmount());

      plotTwistEpisodeCount += 1;
      totalEarnings += getPlotTwistProfit();

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

  public int getTotalEarnings() {
    return totalEarnings;
  }

  public int getTotalExpenses() {
    return totalExpenses;
  }
}
