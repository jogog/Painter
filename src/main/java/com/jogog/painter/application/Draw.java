package com.jogog.painter.application;

import com.jogog.painter.entities.*;
import com.jogog.painter.interfaces.Figure;
import com.jogog.painter.interfaces.Rects;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Draw {
	private GraphicsContext gc;
	private ArrayList<Figure> figures;
	private int dx;
	private int dy;

	public Draw(GraphicsContext gc) {
		this.gc = gc;
		figures = new ArrayList<Figure>();
	}

	public void createLine(MouseEvent e, Color color1) {
		dx = (int) e.getX();
		dy = (int) e.getY();
		Figure o = new Line(new Point(dx, dy), new Point(dx, dy), color1);
		figures.add(o);
		render();
	}

	public void changeLine(MouseEvent e) {
		Line l = (Line) figures.get(figures.size() - 1);
		l.setP2(new Point((int) e.getX(), (int) e.getY()));
		render();
	}

	public void createLongLine(MouseEvent e, Color color1) {
		dx = (int) e.getX();
		dy = (int) e.getY();
		Figure o = new LongLine(new Point(dx, dy), color1);
		figures.add(o);
	}

	public void changeLongLine(MouseEvent e) {
		LongLine l = (LongLine) figures.get(figures.size() - 1);
		l.getLast().setPosition((int) e.getX(), (int) e.getY());
		render();
	}

	public void addPointLongLine(MouseEvent e) {
		LongLine l = (LongLine) figures.get(figures.size() - 1);
		l.addPoint(new Point((int) e.getX(), (int) e.getY()));
		render();
		}
	public void createPolygon(MouseEvent e, Color color1, Color color2) {
		dx = (int) e.getX();
		dy = (int) e.getY();
		Figure o = new Polygon(new Point(dx, dy), color1, color2);
		figures.add(o);
	}

	public void addPointPolygon(MouseEvent e) {
		Polygon poly = (Polygon) figures.get(figures.size() - 1);
		poly.addPoint(new Point((int) e.getX(), (int) e.getY()));
		render();
	}

	public void createOval(MouseEvent e, Color color1, Color color2) {
		dx = (int) e.getX();
		dy = (int) e.getY();
		Figure o = new Oval(new Point(dx, dy), color1, color2);
		figures.add(o);
		render();
	}

	public void createRect(MouseEvent e, Color color1, Color color2) {
		dx = (int) e.getX();
		dy = (int) e.getY();
		Figure o = new Rectangle(new Point(dx, dy), color1, color2);
		figures.add(o);
		render();
	}

	public void changeRect(MouseEvent e) {
		Rects o = (Rects) figures.get(figures.size() - 1);
		int dw = (int) e.getX() - dx;
		int dh = (int) e.getY() - dy;
		if (dw >= 0) {
			o.changeW(dw);
		} else {
			o.changeX((int) e.getX());
			o.changeW(Math.abs(dw));
		}
		if (dh >= 0) {
			o.changeH(dh);
		} else {
			o.changeY((int) e.getY());
			o.changeH(Math.abs(dh));
		}
		render();
	}

	public void drawArc() {
		gc.strokeArc(100, 160, 300, 200, 95, 90, ArcType.ROUND);

	}

	public void render() {
		clearCanvas();
		for (Figure item : figures) {
			item.draw(gc);
		}
	}

	public void clear() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		figures.clear();
	}

	private void clearCanvas() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

	public void saveFile() {
		FileChooser fc = new FileChooser();
//		fc.setInitialDirectory(new File("res/maps"));
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
		fc.setTitle("Save Map");
		File file = fc.showSaveDialog(null);
		if (file != null) {
			WritableImage wi = new WritableImage((int) gc.getCanvas().getWidth(), (int) gc.getCanvas().getHeight());
			try {
				ImageIO.write(SwingFXUtils.fromFXImage(gc.getCanvas().snapshot(null, wi), null), "png", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
