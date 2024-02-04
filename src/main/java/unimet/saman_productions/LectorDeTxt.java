/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unimet.saman_productions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class LectorDeTxt {
    private Integer guionistas;
    private Integer designers;
    private Integer animadores;
    private Integer actoresDoblaje;
    private Integer guionistasPlotTwist;
    private Integer ensambladores;
    private Integer segundosDay;
    private Integer deadline;
    
    public void leerArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int contadorLineas = 0;

            while ((linea = reader.readLine()) != null && contadorLineas < 8) {
                if (!linea.isEmpty()) {
                    contadorLineas++;

                    switch (contadorLineas) {
                        case 1:
                            guionistas = Integer.parseInt(linea);
                            break;
                        case 2:
                            designers = Integer.parseInt(linea);
                            break;
                        case 3:
                            animadores = Integer.parseInt(linea);
                            break;
                        case 4:
                            actoresDoblaje = Integer.parseInt(linea);
                            break;
                        case 5:
                            guionistasPlotTwist = Integer.parseInt(linea);
                            break;
                        case 6:
                            ensambladores = Integer.parseInt(linea);
                            break;
                        case 7: 
                            segundosDay = Integer.parseInt(linea);
                            break;
                        case 8: 
                            deadline = Integer.parseInt(linea);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarDatos(String ruta, int guionistas, int designers, int animadores, int actoresDoblaje, int guionistasPlotTwist, int ensambladores, int segundosDay, int deadline) {
        this.guionistas = guionistas;
        this.designers = designers;
        this.animadores = animadores;
        this.actoresDoblaje = actoresDoblaje;
        this.guionistasPlotTwist = guionistasPlotTwist;
        this.ensambladores = ensambladores;
        this.segundosDay = segundosDay;
        this.deadline = deadline;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(guionistas + "\n");
            writer.write(designers + "\n");
            writer.write(animadores + "\n");
            writer.write(actoresDoblaje + "\n");
            writer.write(guionistasPlotTwist + "\n");
            writer.write(ensambladores + "\n");
            writer.write(segundosDay + "\n");
            writer.write(deadline + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Integer getGuionistas() {
        return guionistas;
    }

    public Integer getDesginers() {
        return designers;
    }

    public Integer getAnimadores() {
        return animadores;
    }

    public Integer getActoresDoblaje() {
        return actoresDoblaje;
    }

    public Integer getGuionistasPlotTwist() {
        return guionistasPlotTwist;
    }
    
    public Integer getEnsambladores() {
        return ensambladores;
    }
    
    public Integer getSegundosDay() {
        return segundosDay;
    }
    
    public Integer getDeadline() {
        return deadline;
    }
    
}
