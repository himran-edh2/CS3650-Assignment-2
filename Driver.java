package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application{
	private TreeView<String> treeView;
	private TextField textField;
	private TextField textField2;
	
	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		GridPane gridPane2 = new GridPane();
		textField = new TextField();
		textField2 = new TextField();
		Button button1 = new Button("Add User");
		Button button2 = new Button("Add Group");
		Button button3 = new Button("Open User View");
		Button button4 = new Button("Show User Total");
		Button button5 = new Button("Show Group Total");
		Button button6 = new Button("Show Messages Total");
		Button button7 = new Button("Show Positive Percentage");
		gridPane.add(textField, 0, 0);
		gridPane.add(textField2, 0, 1);
		gridPane.add(button1, 1, 0);
		gridPane.add(button2, 1, 1);
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane2.add(button4, 0, 0);
		gridPane2.add(button6, 0, 1);
		gridPane2.add(button5, 1, 0);
		gridPane2.add(button7, 1, 1);
		gridPane2.setHgap(20);
		gridPane2.setVgap(20);
		TreeItem<String> rootItem = new TreeItem<>("CS3650"/*, new ImageView(new Image(AdminControlPanel.class.getResourceAsStream("folder.png")))*/);
		treeView = new TreeView<>(rootItem);
		TreeItem<String> branchItem = new TreeItem<>("Section 1");
		TreeItem<String> leafItem = new TreeItem<>("Jim");
		TreeItem<String> leafItem2 = new TreeItem<>("Bob");
		TreeItem<String> leafItem3 = new TreeItem<>("Steve");
		rootItem.getChildren().addAll(branchItem);
		branchItem.getChildren().addAll(leafItem, leafItem2, leafItem3);
		treeView.setShowRoot(true);
		button1.setOnAction(event -> {
			String user = textField.getText();
			TreeItem<String> branch = new TreeItem<>(user);
			branchItem.getChildren().addAll(branch);	
		});
		button2.setOnAction(event -> {
			String group = textField2.getText();
			TreeItem<String> branch2 = new TreeItem<>(group);
			rootItem.getChildren().addAll(branch2);
		});
		button3.setOnAction(new newWindow());
		button4.setOnAction(event -> {
			Label label = new Label("Total Users: " + rootItem.getChildren());
			Scene scene2 = new Scene(label, 500, 300);
			Stage stage2 = new Stage();
			stage2.setTitle("User Total");
			stage2.setScene(scene2);
			stage2.show();
		});
		button5.setOnAction(event -> {
			Label label = new Label("Group Total: " + branchItem.getChildren());
			Scene scene2 = new Scene(label, 500, 300);
			Stage stage2 = new Stage();
			stage2.setTitle("Group Total");
			stage2.setScene(scene2);
			stage2.show();
		});
		button6.setOnAction(event -> {
			Label label = new Label("Message Total: 2");
			Scene scene2 = new Scene(label, 500, 300);
			Stage stage2 = new Stage();
			stage2.setTitle("Message Total");
			stage2.setScene(scene2);
			stage2.show();
		});
		button7.setOnAction(event -> {
			Label label = new Label("Positivity Percentage: 50%");
			Scene scene2 = new Scene(label, 500, 300);
			Stage stage2 = new Stage();
			stage2.setTitle("Positivty Percentage");
			stage2.setScene(scene2);
			stage2.show();
		});
		VBox vbox = new VBox(50, gridPane, button3, gridPane2);
		HBox hbox = new HBox (20, treeView, vbox);
		vbox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox, 650, 400);
		primaryStage.setTitle("CS3560 Project 2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void selectItem() {
		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
	}
	
	class newWindow implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			Label label = new Label(textField.getText());
			Button followButton = new Button("Follow User");
			ListView<String> followerView = new ListView<>();
			TextField tweetField = new TextField();
			Button postButton = new Button("Post Tweet");
			ListView<String> tweetView = new ListView<>();
			postButton.setOnAction(event -> {
				String tweet = tweetField.getText();
				tweetView.getItems().addAll(tweet);
			});
			HBox h1 = new HBox(20, label, followButton);
			HBox h2 = new HBox(20, tweetField, postButton);
			VBox v1 = new VBox(h1, followerView, h2, tweetView);
			v1.setAlignment(Pos.CENTER);
			h1.setAlignment(Pos.CENTER);
			h2.setAlignment(Pos.CENTER);
			Scene scene2 = new Scene(v1, 500, 300);
			Stage stage2 = new Stage();
			stage2.setTitle("User View");
			stage2.setScene(scene2);
			stage2.show();
			
		}
	}
}
	