package com.jogog.painter.entities;

import com.jogog.painter.interfaces.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line implements Figure {
	private Point	p1;
	private Point	p2;
	private Color	color1;
	private int		width;

	public Line() {
		color1 = Color.BLACK;
		width = 2;
	}

	public Line(Point p1, Point p2, Color color1) {
		this.p1 = p1;
		this.p2 = p2;
		this.color1 = color1;
		width = 2;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(color1);
		gc.setLineWidth(width);
		gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	@Override
	public void changeColor1(Color color) {
		this.color1 = color;
	}

	@Override
	public void changeColor2(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeWidth(int width) {
		this.width = width;
	}

	@Override
	public boolean checkPoint(Point p) {
		return false;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

}
