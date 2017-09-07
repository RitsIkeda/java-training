package java8.ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public final class Planet extends Application {


   public void start(Stage stage) {

	     Ellipse  orbit  = new Ellipse( 200, 100 );
	     orbit.setFill( null );
	     orbit.setLayoutX( 200 );
	     orbit.setLayoutY( 100 );
	     orbit.setStroke(Color.BLACK);

	     Circle earth = new Circle(10, Color.BLUE);
	     Circle sun = new Circle(16, Color.ORANGE);
	     sun.setCenterX(200);
	     sun.setCenterY(100);

	     PathTransition pathTransition = new PathTransition();
	     pathTransition.setDuration(Duration.millis(800));
	     pathTransition.setNode(earth);
	     pathTransition.setPath(orbit);
	     //pathTransition.setInterpolator(Interpolator.LINEAR);
	     pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
	     pathTransition.setCycleCount(Animation.INDEFINITE);

	     Group group = new Group(earth, orbit, sun);
	     stage.setScene(new Scene(group));
	     stage.show();
	     pathTransition.play();
   }

   public static void main(String[] args) {
       launch(args);
   }
}
