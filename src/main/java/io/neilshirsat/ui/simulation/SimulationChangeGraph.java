package io.neilshirsat.ui.simulation;

import org.knowm.xchart.*;
import org.knowm.xchart.internal.ChartBuilder;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class SimulationChangeGraph extends JFrame {

    private ArrayList<Integer> WinnerArrays;

    private ArrayList<Integer> Rolls;

    private XChartPanel<XYChart> ChartPanel;

    private XYChart Graph;

    SimulationChangeGraph() {
        super();
        Rolls = new ArrayList<>();
        WinnerArrays = new ArrayList<>();
        Rolls.add(0);
        WinnerArrays.add(0);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();


        Graph = new XYChartBuilder()
            .width((int)WindowDimension.getHeight() * 15/16 * 5/6)
            .height((int)WindowDimension.getHeight() * 15/16)
            .title("Winners vs Rolls")
            .xAxisTitle("Rolls")
            .yAxisTitle("Winners")
            .theme(Styler.ChartTheme.Matlab)
            .build();

        Graph.addSeries("f(x)", null, WinnerArrays);

        ChartPanel = new XChartPanel<>(Graph);
        super.add(ChartPanel);

        super.pack();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

    public void add( int x, int y ) {
        Rolls.add(x);
        WinnerArrays.add(y);
        Graph.updateXYSeries("f(x)", null, WinnerArrays, null);
        ChartPanel.revalidate();
        ChartPanel.repaint();
    }

}
