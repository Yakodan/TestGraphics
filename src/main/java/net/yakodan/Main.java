package net.yakodan;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        XYSeries series = new XYSeries("sin(a)");

        for(double i=0;i<=Math.PI*2;i=i+0.01){
            series.add(i, Math.sin(i));
        }

        XYDataset dataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart("y=sin(x)",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,true,true);
        chart.setBorderPaint(new Color(0xFFFEBF));
        JFrame frame = new JFrame("Graphic");
        ChartPanel panel = new ChartPanel(chart);
        frame.getContentPane().add(panel);
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}