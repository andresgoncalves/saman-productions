/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unimet.saman_productions;
import unimet.saman_productions.drives.DriveManager;
import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.Director;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.ProjectManager;
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
    
    public synchronized void notifyUpload(){
        DriveManager driveManager = studio.getDriveManager();
        Integer countScreenWriter = driveManager.getDrive(Screenwriter.class).getCount();
        Integer countScene = driveManager.getDrive(SetDesigner.class).getCount();
        Integer countAnimator = driveManager.getDrive(Animator.class).getCount();
        Integer countVoiceActor = driveManager.getDrive(VoiceActor.class).getCount();
        Integer countPlotTwistWriter = driveManager.getDrive(PlotTwistWriter.class).getCount();
        Integer counterDeadline = studio.getDeadlineCounter();
        Integer countReviewChapters = studio.getEmployeeManager().getProjectManager().getReviewCount();
        
        
        if("SC".equals(studio.getName())){
            mainFrame.setCapitulosStar(countScreenWriter.toString());
            mainFrame.setSceneChapters(countScene.toString());
            mainFrame.setAnimatorChapters(countAnimator.toString());
            mainFrame.setDoblajeChapters(countVoiceActor.toString());
            mainFrame.setPlotTwistChapters(countPlotTwistWriter.toString());
            mainFrame.setDeadLineSC(counterDeadline.toString());
            mainFrame.setReviewChaptersSC(countReviewChapters.toString());
        } else if ("CN".equals(studio.getName())){
            mainFrame.setScreenWriterCN(countScreenWriter.toString());
            mainFrame.setSceneChaptersCN(countScene.toString());
            mainFrame.setAnimatorChapCN(countAnimator.toString());
            mainFrame.setChaptersVACN(countVoiceActor.toString());
            mainFrame.setChaptersPTWCN(countPlotTwistWriter.toString());
            mainFrame.setDeadLineCN(counterDeadline.toString());
        }
    }
    
    public synchronized void actualizePMStatus(Studio studio){
        ProjectManager projectManager = studio.getEmployeeManager().getProjectManager();
        Integer countFaults = projectManager.getTotalFaults();
        Integer salaryDiscount = projectManager.getTotalSalaryDiscount();
        if("SC".equals(studio.getName())){
            switch (projectManager.getStatus()) {
                case ProjectManager.STATUS_WATCHING_ANIME -> mainFrame.setPmStatusSC("Viendo Anime");
                case ProjectManager.STATUS_REVIEWING_WORK -> mainFrame.setPmStatusSC("Revisando el trabajo");
                case ProjectManager.STATUS_CHECKING_DEADLINE -> mainFrame.setPmStatusSC("Revisando Deadline");
                default -> {
                }
            }
            mainFrame.setFaultsPMSC(countFaults.toString());
            mainFrame.setDiscountMoneyPMSC(salaryDiscount.toString());
        } else if ("CN".equals(studio.getName())){
            switch (projectManager.getStatus()) {
                case ProjectManager.STATUS_WATCHING_ANIME -> mainFrame.setPMStatusCN("Viendo Anime");
                case ProjectManager.STATUS_REVIEWING_WORK -> mainFrame.setPMStatusCN("Revisando el trabajo");
                case ProjectManager.STATUS_CHECKING_DEADLINE -> mainFrame.setPMStatusCN("Revisando Deadline");
                default -> {
                }
            }
            mainFrame.setFaultsPMCN(countFaults.toString());
            mainFrame.setDiscountMoneyPMCN(salaryDiscount.toString());
        }
        
        
        
    }
    
    public synchronized void actualizeDirectorStatus(Studio studio){
        Director director = studio.getEmployeeManager().getDirector();
        if("SC".equals(studio.getName())){
            switch (director.getStatus()) {
                case Director.STATUS_IDLE -> mainFrame.setDirectorStatusSC("Inactivo");
                case Director.STATUS_PUBLISHING -> mainFrame.setDirectorStatusSC("Publicando");
                case Director.STATUS_SUPERVISING -> mainFrame.setDirectorStatusSC("Supervisando");
                default -> {
                }
            }
            
        } else if ("CN".equals(studio.getName())){
            switch (director.getStatus()) {
                case Director.STATUS_IDLE -> mainFrame.setDirectorStatusCN("Inactivo");
                case Director.STATUS_PUBLISHING -> mainFrame.setDirectorStatusCN("Publicando");
                case Director.STATUS_SUPERVISING -> mainFrame.setDirectorStatusCN("Supervisando");
                default -> {
                }
            }
        }
        
    }
    
    public synchronized void actualizeInfoFinalDay(Studio studio){
        Integer publishedChapters = studio.publishPlotTwistEpisodes() + studio.publishStandardEpisodes();
        Integer totalEarnings = studio.getTotalEarnings();
        Integer costos = studio.getTotalExpenses();
        Integer utilidades = studio.getTotalUtility();
        
        if("SC".equals(studio.getName())){
           mainFrame.setPublishedChaptersSC(publishedChapters.toString());
           mainFrame.setIngresosSC(totalEarnings.toString());
           mainFrame.setCostosSC(costos.toString());
           mainFrame.setUtilidadesSC(utilidades.toString());
           
        } else if ("CN".equals(studio.getName())){
           mainFrame.setPublishedChaptersCN(publishedChapters.toString());
           mainFrame.setIngresosCN(totalEarnings.toString());
           mainFrame.setCostosCN(costos.toString());
           mainFrame.setUtilidadesCN(utilidades.toString());
        }
    }
        
}
