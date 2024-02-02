package unimet.saman_productions.drives;

import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.Screenwriter;
import unimet.saman_productions.employees.SetDesigner;
import unimet.saman_productions.employees.VoiceActor;

public class DriveManager {
  private Drive scriptsDrive;
  private Drive scenesDrive;
  private Drive animationsDrive;
  private Drive dubsDrive;
  private Drive plotTwistsDrive;

  private Drive standardEpisodeDrive;
  private Drive plotTwistEpisodeDrive;
  private Drive publishedDrive;

  public DriveManager() {
    scriptsDrive = new LimitedDrive(Screenwriter.DRIVE_SIZE);
    scenesDrive = new LimitedDrive(SetDesigner.DRIVE_SIZE);
    animationsDrive = new LimitedDrive(Animator.DRIVE_SIZE);
    dubsDrive = new LimitedDrive(VoiceActor.DRIVE_SIZE);
    plotTwistsDrive = new LimitedDrive(PlotTwistWriter.DRIVE_SIZE);

    standardEpisodeDrive = new Drive();
    plotTwistEpisodeDrive = new Drive();
    publishedDrive = new Drive();
  }

  public Drive getDrive(Class<?> type) {
    if (type == Screenwriter.class) {
      return scriptsDrive;
    } else if (type == SetDesigner.class) {
      return scenesDrive;
    } else if (type == Animator.class) {
      return animationsDrive;
    } else if (type == VoiceActor.class) {
      return dubsDrive;
    } else if (type == PlotTwistWriter.class) {
      return plotTwistsDrive;
    }

    throw new RuntimeException("El drive solicitado no existe");
  }

  public Drive getStandardEpisodeDrive() {
    return standardEpisodeDrive;
  }

  public Drive getPlotTwistEpisodeDrive() {
    return plotTwistEpisodeDrive;
  }

  public Drive getPublishedDrive() {
    return publishedDrive;
  }
}
