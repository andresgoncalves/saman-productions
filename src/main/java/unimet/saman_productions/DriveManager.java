package unimet.saman_productions;

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

  public DriveManager() {
    scriptsDrive = new Drive(Screenwriter.DRIVE_SIZE);
    scenesDrive = new Drive(SetDesigner.DRIVE_SIZE);
    animationsDrive = new Drive(Animator.DRIVE_SIZE);
    dubsDrive = new Drive(VoiceActor.DRIVE_SIZE);
    plotTwistsDrive = new Drive(PlotTwistWriter.DRIVE_SIZE);
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
}
