package unimet.saman_productions;

import unimet.saman_productions.employees.Animator;
import unimet.saman_productions.employees.Assembler;
import unimet.saman_productions.employees.Director;
import unimet.saman_productions.employees.PlotTwistWriter;
import unimet.saman_productions.employees.ProjectManager;
import unimet.saman_productions.employees.Screenwriter;
import unimet.saman_productions.employees.SetDesigner;
import unimet.saman_productions.employees.VoiceActor;
import unimet.saman_productions.studios.CartoonNetwork;

public class Main {
    public static void main(String[] args) {
        new Screenwriter().start();
        new SetDesigner().start();
        new Animator().start();
        new VoiceActor().start();
        new PlotTwistWriter().start();
        new Assembler(new CartoonNetwork()).start();
        new ProjectManager().start();
        new Director().start();
    }
}