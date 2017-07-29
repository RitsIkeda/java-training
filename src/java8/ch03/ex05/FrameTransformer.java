package java8.ch03.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@FunctionalInterface
interface ColorTransformer {
   Color apply(int x, int y, Color colorAtXY);
}

public class FrameTransformer extends Application {

   public static Image transform(Image in, ColorTransformer f) {
      int width = (int) in.getWidth();
      int height = (int) in.getHeight();
      WritableImage out = new WritableImage(
         width, height);
      for (int x = 0; x < width; x++)
         for (int y = 0; y < height; y++)
            out.getPixelWriter().setColor(x, y,
               f.apply(x, y, in.getPixelReader().getColor(x, y)));
      return out;
   }

   public void start(Stage stage) {
      Image image = new Image("java8\\ch03\\ex05\\queen-mary.png"); //src\\java8\\ch03\\ex05\\
      Image grayFrameImage = transform(image,
         (x, y, c) -> {  if(x >= 10 && x < image.getWidth() - 10 && y >= 10 && y < image.getHeight() - 10 ) {
        	 return c;
         } else {
        	 return Color.GRAY;
         }});

      stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(grayFrameImage))));
      stage.show();
   }
   public static void main(String[] args) {
	   Application.launch(args);
   }
}
