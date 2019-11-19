package com.jogog.painter.interfaces;

import com.jogog.painter.entities.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Figure {
	void draw(GraphicsContext gc);

	void changeColor1(Color color);

	void changeColor2(Color color);

	void changeWidth(int width);
	public boolean checkPoint(Point p);
}
