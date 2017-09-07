package java8.ch04.ex08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* 練習問題 8回答
 * javafx.scene.Node.setStyle() により、スタイルを直接指定する。
 * または、javafx.scene.layout.Region.setBorder()によりパラメータし、生成する。
 */
public class ControlBorderDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(3);

        HBox blackBorderd = new HBox();
        blackBorderd.getChildren().add(new Text("Black"));
        blackBorderd.setStyle("-fx-border-color: black;");

        HBox redBorderd= new HBox();
        redBorderd.getChildren().add(new Text("Red"));
        redBorderd.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));

        HBox noBorderd= new HBox();
        noBorderd.getChildren().add(new Text("White"));

        root.getChildren().addAll(
        		blackBorderd, redBorderd, noBorderd
        );

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}