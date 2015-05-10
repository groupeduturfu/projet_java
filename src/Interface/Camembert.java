/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author mathieuchebassier
 */
public class Camembert {

    public Camembert(JFrame f, int rea, int chg, int orl) {

        
        

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("REA = "+rea, rea);
        pieDataset.setValue("CHG = "+chg, chg);
        pieDataset.setValue("ORL = "+orl, orl);

        JFreeChart pieChart = ChartFactory.createPieChart("Nombre de patients par service",pieDataset, true, true, true);

        ChartPanel cPanel = new ChartPanel(pieChart);

        f.getContentPane().add(cPanel);
        f.setVisible(true);
    }
}

