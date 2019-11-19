package com.jogog.painter.entities;

import com.jogog.painter.interfaces.Figure;
import com.jogog.painter.interfaces.Rects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Figure, Rects {
	private Point	center;
	private Color	color1;
	private Color	color2;
	private int		w;
	private int		h;
	private int		width;

	public Rectangle(Point p, Color color1, Color color2) {
		this.center = p;
		this.color1 = color1;
		this.color2 = color2;
		w=1;
		h=1;
		width = 2;
	}

	@Override
	public void changeW(int w) {
		this.w = w;
	}

	@Override
	public void changeH(int h) {
		this.h = h;
	}

	@Override
	public void changeX(int x) {
		center.setX(x);
	}

	@Override
	public void changeY(int y) {
		center.setY(y);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(color2);
		gc.setStroke(color1);
		gc.setLineWidth(width);
		gc.fillRect(center.getX(), center.getY(), w, h);
		gc.strokeRect(center.getX(), center.getY(), w, h);
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
		return false;
	}

}
