package java8.ch03.ex06;


import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class BrightendTransformer extends Application {

   public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
      int width = (int) in.getWidth();
      int height = (int) in.getHeight();
      WritableImage out = new WritableImage(
         width, height);
      for (int x = 0; x < width; x++)
         for (int y = 0; y < height; y++)
            out.getPixelWriter().setColor(x, y,
               f.apply(in.getPixelReader().getColor(x, y),arg));
      return out;
   }

   public void start(Stage stage) {
      Image image = new Image("java8\\ch03\\ex05\\queen-mary.png"); //src\\java8\\ch03\\ex05\\
      Image imageBright = transform(image,
         (c, factor) -> c.deriveColor(0.0, 1.0,  factor, 1.0),
         2.0);
      Image imageDark = transform(image,
    	         (c, factor) -> c.deriveColor(0.0, 1.0,  factor, 1.0),
    	         0.2);

      stage.setScene(new Scene(new HBox( new ImageView(imageBright),new ImageView(imageDark))));
      stage.show();
   }
   public static void main(String[] args) {
	   Application.launch(args);
   }
}
