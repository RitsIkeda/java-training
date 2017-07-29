package java8.ch03.ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class Main extends Application {
	@Override
	public void start(Stage stage) {
	    Image image = new Image("java8\\ch03\\ex12\\eiffel-tower.jpg");

	    Image finalImage = LatentImage.from(image)
	       .transform(Color::brighter)
	       .transform(LatentImage.getFrameTransformer((int)image.getWidth(), (int)image.getHeight(), 10, Color.RED))
	       .toImage();
	    stage.setScene(new Scene(new HBox(
	       new ImageView(image),
	       new ImageView(finalImage))));
	    stage.show();
	 }
	public static void main(String[] args) {
		   Application.launch(args);
	}
}
