/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unimet.saman_productions;
import unimet.saman_productions.drives.DriveManager;
import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.Screenwriter;
import unimet.saman_productions.employees.SetDesigner;
import unimet.saman_productions.employees.VoiceActor;
import unimet.saman_productions.studios.Studio;

/**
 *
 * @author USUARIO
 */
public class StudioView {
    
    private MainFrame mainFrame;
    private Studio studio;
    
    public StudioView(Studio studio, MainFrame mainFrame) {
        this.studio = studio;
        studio.setStudioView(this);
        this.mainFrame = mainFrame;
    }
    
    public void notifyUpload(){
        DriveManager driveManager = studio.getDriveManager();
        Integer countScreenWriter = driveManager.getDrive(Screenwriter.class).getCount();
        Integer countScene = driveManager.getDrive(SetDesigner.class).getCount();
        Integer countAnimator = driveManager.getDrive(Animator.class).getCount();
        Integer countVoiceActor = driveManager.getDrive(VoiceActor.class).getCount();
        Integer countPlotTwistWriter = driveManager.getDrive(PlotTwistWriter.class).getCount();
        mainFrame.setCapitulosStar(countScreenWriter.toString());
        mainFrame.setSceneChapters(countScene.toString());
        mainFrame.setAnimatorChapters(countAnimator.toString());
        mainFrame.setDoblajeChapters(countVoiceActor.toString());
        mainFrame.setPlotTwistChapters(countPlotTwistWriter.toString());
        
    }
        
}
