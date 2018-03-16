//Write a program that sets the horizontal alignment and conlumn-size properties of a text field dynamically.
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 *
 * @author Kelli
 */
public class TextFieldExample extends Application {

   @Override
   public void start(Stage primaryStage){
       StackPane pane = new StackPane();
       
       HBox mainHBox = new HBox();
       mainHBox.setPadding(new Insets(5,5,5,5));
       mainHBox.setMaxHeight(15);
               
       //text field that will be edited by the radio buttons and the column size control
       TextField text = new TextField("JavaFX");
       text.setEditable(false);
       text.setMaxWidth(300);
       Label labelText = new Label("Text Field",text);
       labelText.setContentDisplay(ContentDisplay.RIGHT);
                      
       //HBox that holds the radio buttons
       HBox BottomHBox = new HBox();
       BottomHBox.setSpacing(10);
       BottomHBox.setPadding(new Insets(5,5,5,5));
              
       mainHBox.getChildren().addAll(text,labelText);
       
       //Creating HBox for Radio Buttons
       RadioButton leftRadBtn = new RadioButton("Left");
       RadioButton centerRadBtn = new RadioButton("Center");
       RadioButton rightRadBtn = new RadioButton("Right");
       
       //text field for column size
       TextField textColumn = new TextField("12");
       textColumn.setEditable(true);
       textColumn.setAlignment(Pos.CENTER);
       textColumn.setPrefColumnCount(3);
       Label labelColumn = new Label("Column Size", textColumn);
       labelColumn.setContentDisplay(ContentDisplay.RIGHT);

       //adding all elements to the bottom Hbox
       BottomHBox.getChildren().addAll(leftRadBtn, centerRadBtn, rightRadBtn, labelColumn, textColumn);
       
       //Event Handler For Radio Buttons
       ToggleGroup group = new ToggleGroup();
       leftRadBtn.setToggleGroup(group);
       centerRadBtn.setToggleGroup(group);
       rightRadBtn.setToggleGroup(group);
       
       leftRadBtn.setOnAction(e -> {
        if (leftRadBtn.isSelected()){
            text.setAlignment(Pos.BASELINE_LEFT);
        }
       });
       
       centerRadBtn.setOnAction(e -> {
        if (centerRadBtn.isSelected()){
            text.setAlignment(Pos.BASELINE_CENTER);
        }
       });
       
       rightRadBtn.setOnAction(e -> {
        if (rightRadBtn.isSelected()){
            text.setAlignment(Pos.BASELINE_RIGHT);
        }
       });
       
       //event handler for textColumn
       textColumn.setOnAction(e -> text.setPrefColumnCount(Integer.parseInt(textColumn.getText())));
    
       //Setting the BorderPane
       BorderPane borderPane = new BorderPane();
       borderPane.setCenter(mainHBox);
       borderPane.setBottom(BottomHBox);
          
       //Creating the scene
       Scene scene = new Scene (borderPane, 325, 100);
       
       primaryStage.setTitle("Text Fields");
       primaryStage.setScene(scene);
       primaryStage.show();  
       
   }

    public static void main(String[] args) {
        launch(args);
    }
    
}
