package java8.ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;



class LatentImage {
	@FunctionalInterface
	interface ColorTransformer {
	   Color apply(int x, int y, Color colorAtXY);
	}
	public static ColorTransformer transformeWhole(UnaryOperator<Color> operator) {
		  return (x, y, c) -> operator.apply(c);
	}

   private Image in;
   private List<ColorTransformer> pendingOperations;

   public static LatentImage from(Image in) {
      LatentImage result = new LatentImage();
      result.in = in;
      result.pendingOperations = new ArrayList<>();
      return result;
   }
   public static ColorTransformer getFrameTransformer(int width,int height, int frameWeight, Color frameColor ) {
	   return (x, y, c) -> {  if(x >= frameWeight && x < width - frameWeight && y >= frameWeight && y < height - frameWeight ) {
	      	 return c;
	       } else {
	      	 return frameColor;
	       }
	   };
   }

   LatentImage transform(UnaryOperator<Color> f) {
      pendingOperations.add(transformeWhole(f));
      return this;
   }
   LatentImage transform(ColorTransformer f) {
	      pendingOperations.add(f);
	      return this;
	   }

   public Image toImage() {
      int width = (int) in.getWidth();
      int height = (int) in.getHeight();
      WritableImage out = new WritableImage(width, height);
      for (int x = 0; x < width; x++)
         for (int y = 0; y < height; y++) {
            Color c = in.getPixelReader().getColor(x, y);
            for (ColorTransformer f : pendingOperations) c = f.apply(x,y,c);
            out.getPixelWriter().setColor(x, y, c);
         }
      return out;
   }


}
