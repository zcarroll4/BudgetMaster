package de.deadlocker8.budgetmaster.logic.chartGenerators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import de.deadlocker8.budgetmaster.logic.Helpers;
import de.deadlocker8.budgetmaster.logic.MonthInOutSum;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class LineChartGenerator
{
	private ArrayList<MonthInOutSum> monthInOutSums;
	private String currency;

	public LineChartGenerator(ArrayList<MonthInOutSum> monthInOutSums, String currency)
	{
		this.monthInOutSums = monthInOutSums;
		this.currency = currency;
	}

	public LineChart<String, Number> generate()
	{
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final LineChart<String, Number> generatedChart = new LineChart<>(xAxis, yAxis);
		generatedChart.setTitle(null);

		xAxis.setLabel("");
		yAxis.setLabel("Summe in " + currency);

		XYChart.Series<String, Number> seriesIN = new XYChart.Series<String, Number>();
		seriesIN.setName("Einnahmen");
		XYChart.Series<String, Number> seriesOUT = new XYChart.Series<String, Number>();
		seriesOUT.setName("Ausgaben");

		for(MonthInOutSum currentItem : monthInOutSums)
		{
			String label = currentItem.getDate().toString("MMMM YY");

			seriesIN.getData().add(new XYChart.Data<String, Number>(label, currentItem.getBudgetIN() / 100.0));
			seriesOUT.getData().add(new XYChart.Data<String, Number>(label, -currentItem.getBudgetOUT() / 100.0));
		}

		generatedChart.getData().add(seriesIN);
		generatedChart.getData().add(seriesOUT);

		generatedChart.setLegendVisible(true);

		// add tooltip to every segment
		generatedChart.getData().stream().forEach(tool -> {
			for(XYChart.Data<String, Number> data : tool.getData())
			{
				Tooltip tooltip = new Tooltip();

				tooltip.setText(Helpers.NUMBER_FORMAT.format(data.getYValue()).replace(".", ",") + currency);
				Tooltip.install(tool.getNode(), tooltip);
				Node node = data.getNode();
				node.setOnMouseEntered(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						Point2D p = node.localToScreen(event.getX() + 5, event.getY() + 7);
						tooltip.show(node, p.getX(), p.getY());
					}
				});
				node.setOnMouseExited(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent event)
					{
						tooltip.hide();
					}
				});
			}
		});

		// style line for incomes
		for(Node n : generatedChart.lookupAll(".default-color0.chart-series-line"))
		{
			n.setStyle("-fx-stroke: " + Helpers.COLOR_INCOME + ";");
		}
		
		// style line dots for incomes
		for(Node n : generatedChart.lookupAll(".default-color0.chart-line-symbol"))
		{
			n.setStyle("-fx-background-color: " + Helpers.COLOR_INCOME + ", white;");
		}

		// style line for payments
		for(Node n : generatedChart.lookupAll(".default-color1.chart-series-line"))
		{
			n.setStyle("-fx-stroke: " + Helpers.COLOR_PAYMENT + ";");
		}
		
		// style line dots for payments
		for(Node n : generatedChart.lookupAll(".default-color1.chart-line-symbol"))
		{
			n.setStyle("-fx-background-color: " + Helpers.COLOR_PAYMENT + ", white;");
		}

		// style legend item according to color
		Set<Node> nodes = generatedChart.lookupAll(".chart-legend-item");
		if(nodes.size() > 0)
		{
			Iterator<Node> iterator = nodes.iterator();
			int counter = 0;
			while(iterator.hasNext())
			{
				Node node = iterator.next();
				if(node instanceof Label)
				{
					Label labelLegendItem = (Label)node;
					if(counter == 0)
					{
						labelLegendItem.getGraphic().setStyle("-fx-background-color: " + Helpers.COLOR_INCOME + ";");
					}
					else
					{
						labelLegendItem.getGraphic().setStyle("-fx-background-color: " + Helpers.COLOR_PAYMENT + ";");
					}
				}
				counter++;
			}
		}

		return generatedChart;
	}
}