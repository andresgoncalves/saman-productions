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
import unimet.saman_productions.studios.Studio;

public class Main {
    public static void main(String[] args) {
        Studio cartoonNetwork = new CartoonNetwork();
        new Screenwriter(cartoonNetwork).start();
        new SetDesigner(cartoonNetwork).start();
        new Animator(cartoonNetwork).start();
        new VoiceActor(cartoonNetwork).start();
        new PlotTwistWriter(cartoonNetwork).start();
        new Assembler(cartoonNetwork).start();
        new ProjectManager(cartoonNetwork).start();
        new Director(cartoonNetwork).start();
    }
}