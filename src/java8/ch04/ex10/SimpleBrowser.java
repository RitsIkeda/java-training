package java8.ch04.ex10;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SimpleBrowser extends Application {

	private Button backButton = new Button("戻る");
	private TextField urlField = new TextField();
	private WebEngine webEngine;
	private WebView browser;


	/* プロキシを経由するときは、下記を編集 */
	final boolean USE_PROXY = false;
	final String PROXY_SET = "proxy.mycompany.co.jp";
	final String PROXY_USER = "myname";
	final String PROXY_PASS = "mypassword";
	final String PROXY_PORT = "9999";


	public void start(Stage stage) throws Exception {
		browser = new WebView();
		webEngine = browser.getEngine();
		setAction();
		webEngine.load("https://www.amazon.co.jp/Effective-Java-3rd-Joshua-Bloch/dp/0134685997");
		load(stage);
	}
	 private void load(Stage stage) {
		 if(USE_PROXY) {
			 setProxy();
		 }
		 HBox box = new HBox(backButton, urlField);
		 HBox.setHgrow(urlField, Priority.ALWAYS);
		 BorderPane pane = new BorderPane();
		 pane.setTop(box);
		 pane.setCenter(browser);


		 stage.setScene(new Scene(pane, 1000, 600));
		 stage.setTitle("Simple Browser");
		 stage.show();
	}

	private void setProxy() {
		 System.setProperty("https.proxyHost", PROXY_SET);
		 System.setProperty("https.proxyUser", PROXY_USER);
		 System.setProperty("https.proxyproxyPassword", PROXY_PASS);
		 System.setProperty("https.proxyPort", PROXY_PORT);
		 System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
		 Authenticator.setDefault(new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(PROXY_USER, PROXY_PASS.toCharArray());
				}
			});
	}

	private void setAction() {
		 backButton.setOnAction(
				 e -> {
					 if(webEngine.getHistory().getCurrentIndex() >= 1) {
						 webEngine.getHistory().go(-1);
					 }
				 });
		 urlField.setOnAction(
			        e -> {
			        	webEngine.load(urlField.getText());
			        	System.out.println(urlField.getText());
			        	}
				    );

		 webEngine.locationProperty().addListener(
			        (location, oldLocation, newLocation) -> { urlField.setText(newLocation); }
			        );
	}
	public static void main(String[] args) {
	       launch(args);
	}
}

