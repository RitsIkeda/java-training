package java8.ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
      Label message = new Label("Hello, JavaFX!");
      message.setFont(new Font(100));

      TextField field = new TextField();
      field.textProperty().addListener(e -> message.setText(field.getText()));

      VBox root = new VBox();
      root.getChildren().addAll(field, message);

      stage.setScene(new Scene(root));
      stage.setTitle("Hello");
      stage.show();
   }
}
