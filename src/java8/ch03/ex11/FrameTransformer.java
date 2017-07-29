package java8.ch03.ex11;

import java.util.function.UnaryOperator;

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

	public static ColorTransformer merge(ColorTransformer first, ColorTransformer second ) {
		  return (x, y, c) -> second.apply(x, y, first.apply(x, y, c));
	}
	public static ColorTransformer transformeWhole(UnaryOperator<Color> operator) {
		  return (x, y, c) -> operator.apply(c);
	}

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

      ColorTransformer frameMaker = (x, y, c) -> {  if(x >= 10 && x < image.getWidth() - 10 && y >= 10 && y < image.getHeight() - 10 ) {
     	 return c;
      } else {
     	 return Color.GRAY;
      }};
      ColorTransformer lightUp = transformeWhole(c -> c.deriveColor(0, 1, 2.0, 1));

      Image grayFrameImage = transform(image,
        merge(lightUp, frameMaker));

      stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(grayFrameImage))));
      stage.show();
   }
   public static void main(String[] args) {
	   Application.launch(args);
   }
}
