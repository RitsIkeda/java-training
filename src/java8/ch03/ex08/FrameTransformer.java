package java8.ch03.ex08;

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
   public static ColorTransformer getFrameTransformer(int width,int height, int frameWeight, Color frameColor ) {
	   return (x, y, c) -> {  if(x >= frameWeight && x < width - frameWeight && y >= frameWeight && y < height - frameWeight ) {
	      	 return c;
	       } else {
	      	 return frameColor;
	       }
	   };
   }

   public void start(Stage stage) {
      Image image = new Image("java8\\ch03\\ex05\\queen-mary.png"); //src\\java8\\ch03\\ex05\\
      Image blueFrameImage = transform(image,
    		  getFrameTransformer((int) image.getWidth(),(int) image.getHeight(),10,Color.BLUE));
      Image redFrameImage = transform(image,
    		  getFrameTransformer((int) image.getWidth(),(int) image.getHeight(),20,Color.RED));

      stage.setScene(new Scene(new HBox(new ImageView(blueFrameImage), new ImageView(redFrameImage))));
      stage.show();
   }
   public static void main(String[] args) {
	   Application.launch(args);
   }
}
