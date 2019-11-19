package com.jogog.painter.application;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MainController {
	@FXML
	Canvas		canvas;
	@FXML
	Button		oval;		// done
	@FXML
	Button		line;		// done
	@FXML
	Button		rect;		// done
	@FXML
	Button		arcLine;
	@FXML
	Button		longLine;	// done
	@FXML
	Button		poly;
	@FXML
	Button		hand;
	@FXML
	Button		connect;
	@FXML
	Button		clear;		// done
	@FXML
	Button		erase;
	@FXML
	Button		savePic;    //done
	@FXML
	Label		stat;
	@FXML
	Label		action;
	@FXML
	ColorPicker	color1;
	@FXML
	ColorPicker	color2;

	public void initialize() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Draw draw = new Draw(gc);
		draw.clear();
		canvas.setCursor(Cursor.CROSSHAIR);
		color1.setValue(Color.BLACK);

		oval.setOnMouseClicked(e -> {
			action.setText("Draw oval");
			stat.setText("");

			canvas.setOnMousePressed(ev -> {
				draw.createOval(ev, color1.getValue(), color2.getValue());
				stat.setText("1");
			});
			canvas.setOnMouseDragged(ev -> {
				draw.changeRect(ev);
				stat.setText("2");
			});
			canvas.setOnMouseReleased(ev -> {
				stat.setText("3");
			});
		});

		rect.setOnMouseClicked(e -> {
			action.setText("Draw rect");
			stat.setText("");

			canvas.setOnMousePressed(ev -> {
				draw.createRect(ev, color1.getValue(), color2.getValue());
				stat.setText("1");
			});
			canvas.setOnMouseDragged(ev -> {
				draw.changeRect(ev);
				stat.setText("2");
			});
			canvas.setOnMouseReleased(ev -> {
				stat.setText("3");
			});
		});

		line.setOnMouseClicked(e -> {
			action.setText("Draw line");
			stat.setText("");
			canvas.setOnMousePressed(ev -> {
				draw.createLine(ev, color1.getValue());
				stat.setText("1");
			});
			canvas.setOnMouseDragged(ev -> {
				draw.changeLine(ev);
				stat.setText("2");
			});
			canvas.setOnMouseReleased(ev -> {
				stat.setText("3");
			});
		});

		longLine.setOnMouseClicked(e -> {
			action.setText("Draw Longline");
			canvas.setOnMousePressed(ev -> {
				draw.createLongLine(ev, color1.getValue());
				draw.addPointLongLine(ev);
			});
			canvas.setOnMouseDragged(ev -> {
				draw.changeLongLine(ev);
			});
			canvas.setOnMouseReleased(ev -> {
				canvas.setOnMousePressed(event -> {
					draw.addPointLongLine(event);
				});
				canvas.setOnMouseReleased(event -> {
					stat.setText("3");
				});
				stat.setText("3");
			});

		});
		poly.setOnMouseClicked(e->{
			aband();
			action.setText("Draw Polygon");
			canvas.setOnMouseClicked(ev->{
				draw.createPolygon(ev, color1.getValue(), color2.getValue());
				canvas.setOnMouseClicked(event->{
					draw.addPointPolygon(event);
				});
			});
		});

		arcLine.setOnMouseClicked(e -> {
			draw.drawArc();
		});

		clear.setOnMouseClicked(e -> {
			aband();
			action.setText("Cleared!");
			stat.setText("");
			draw.clear();
		});
		savePic.setOnMouseClicked(e->{
			draw.saveFile();
		});


	}
	private void aband() {
		canvas.setOnMouseClicked(null);
		canvas.setOnMousePressed(null);
		canvas.setOnMouseDragged(null);
		canvas.setOnMouseReleased(null);
	}
}
