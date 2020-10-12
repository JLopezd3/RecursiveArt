package recursionRectangle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class RecursionRectangleGUI extends Application{

	private RadioButton thirdFrac = new RadioButton("1/3");
	private RadioButton fourthFrac = new RadioButton("1/4");
	private RadioButton fifthFrac = new RadioButton("1/5");
	private Button showArt = new Button("Show Art!");
	private Label levelLB = new Label("Subdivision Level: ");
	private TextField levelTF = new TextField();
	ToggleGroup tGroup = new ToggleGroup();

	@Override
	public void start(Stage primaryStage) {
		RecursionRectangle rec = new RecursionRectangle();
		Pane paneWithRectangle = new Pane();
		paneWithRectangle.setPadding(new Insets(0, 50, 50, 50));
		thirdFrac.setToggleGroup(tGroup);
		fourthFrac.setToggleGroup(tGroup);
		fifthFrac.setToggleGroup(tGroup);
		//method that returns list of rectangles will be created and added to the pane
		showArt.setOnAction((e)->{
			paneWithRectangle.getChildren().removeAll(rec.getRectangles());
			if(thirdFrac.isSelected()) {
				rec.recursiveRec(rec.getMainRectangle(), Integer.parseInt(levelTF.getText()),3);
				paneWithRectangle.getChildren().addAll(rec.getRectangles());
			}
			if(fourthFrac.isSelected()){
				rec.recursiveRec(rec.getMainRectangle(), Integer.parseInt(levelTF.getText()), 4);
				paneWithRectangle.getChildren().addAll(rec.getRectangles());
			}
			if(fifthFrac.isSelected()){
				rec.recursiveRec(rec.getMainRectangle(), Integer.parseInt(levelTF.getText()),5);
				paneWithRectangle.getChildren().addAll(rec.getRectangles()); 
			}
			
		});
		
		
		
		BorderPane bPane = new BorderPane();
		bPane.setStyle("-fx-background-color: Beige"); 
		bPane.setTop(getHBox());
		bPane.setCenter(paneWithRectangle);
		
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("RecursionArt");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	 private HBox getHBox() {
		 HBox hBox = new HBox(15);
		 hBox.setPadding(new Insets(10, 15, 5, 15));
		 hBox.setStyle("-fx-background-color: Beige"); 
		 hBox.getChildren().addAll(levelLB, levelTF, thirdFrac, fourthFrac, fifthFrac, showArt);
		 return hBox;
	} 

}
