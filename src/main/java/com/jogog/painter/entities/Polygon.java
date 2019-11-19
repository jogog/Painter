package com.jogog.painter.entities;

import com.jogog.painter.interfaces.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Polygon implements Figure {
	private ArrayList<Point>	list;
	private Color				color1;
	private Color				color2;
	private int					width;

	public Polygon(Point p, Color color1, Color color2) {
		list = new ArrayList<Point>();
		list.add(p);
		this.color1 = color1;
		this.color2 = color2;
		width = 2;
	}

	public void addPoint(Point p) {
		list.add(p);
	}

	@Override
	public void draw(GraphicsContext gc) {
		double[] x = new double[list.size()];
		double[] y = new double[list.size()];
		for (int i = 0; i < x.length; i++) {
			x[i] = list.get(i).getX();
			y[i] = list.get(i).getY();
		}
		gc.setStroke(color1);
		gc.setFill(color2);
		gc.setLineWidth(width);
		gc.fillPolygon(x, y, x.length);
		gc.strokePolygon(x, y, x.length);
	}

	@Override
	public void changeColor1(Color color) {
		color1 = color;
	}

	@Override
	public void changeColor2(Color color) {
		color2 = color;
	}

	@Override
	public void changeWidth(int width) {
		this.width = width;
	}

	@Override
	public boolean checkPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
}
