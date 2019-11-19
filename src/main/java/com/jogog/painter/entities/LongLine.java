package com.jogog.painter.entities;

import com.jogog.painter.interfaces.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class LongLine implements Figure {

	private ArrayList<Point>	list;
	private Color				color1;
	private int					width;

	public LongLine(Point p, Color color) {
		list = new ArrayList<Point>();
		list.add(p);
		color1 = color;
		width = 2;
	}

	@Override
	public void draw(GraphicsContext gc) {

		if (list.size() > 1) {
			gc.setStroke(color1);
			gc.setLineWidth(width);
			for (int i = 0; i < list.size() - 1; i++) {
				gc.strokeLine(list.get(i).getX(), list.get(i).getY(), list.get(i + 1).getX(), list.get(i + 1).getY());
			}
		}
	}

	public void addPoint(Point p) {
		list.add(p);
	}
	
	public Point getLast() {
		return list.get(list.size()-1);
	}

	@Override
	public void changeColor1(Color color) {
		color1 = color;
	}

	@Override
	public void changeColor2(Color color) {

	}

	@Override
	public void changeWidth(int width) {
		this.width = width;
	}

	@Override
	public boolean checkPoint(Point p) {
		return false;
	}

}
