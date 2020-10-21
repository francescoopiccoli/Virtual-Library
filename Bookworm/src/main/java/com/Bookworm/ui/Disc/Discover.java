package com.Bookworm.ui.Disc;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class Discover extends BorderPane {

    BorderPane layout;
    ScrollPane scrollPane;

    public Discover() {
        //Create an instance of Discover to fill the borderpane with its functions
        setTop(createTopDisc());
        setCenter(getCenterDisc());
        //Sets css to the discover scene
        //
    }

    public Node getCenterDisc() {
        //Temporary image to replace covers
        Image image = new Image(getClass().getResourceAsStream("/Images/placeholder.png"));
        //Create vertical box will align all elements one under the other
        VBox vb = new VBox();

        vb.getStyleClass().add("vbrect");
        vb.setSpacing(50);
        //Create horizontal box will align all elements one next to the other
        HBox hb = new HBox();

        //Button for all single books to be created
        Button rect = new Button();


        //Add a scroll pane so scrolling is made possible
        ScrollPane scrollPane;


        Label label  = new Label("Discover new books!");
        label.getStyleClass().add("discoverLabel");
        vb.getChildren().add(label);
        //will create (currently 3) rows with at most 5 books on each row
        for (int i = 0; i<3;i++){
            hb = new HBox();

            for (int j = 0; j<5;j++){
                //This will be replaced with the function giving us the cover of the book and also setting the reaction to clicking the "button"
                ImageView imageView = new ImageView(image);
                rect = new Button("Title placeholder 11111111111111111111111111111jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",imageView);
                rect.getStyleClass().add("rect");
                hb.getChildren().add(rect);

            }
            vb.getChildren().add(hb);
        }
        scrollPane = new ScrollPane(vb);
        scrollPane.getStyleClass().add("scrollpane");

        return  scrollPane;



    }

    public Node createTopDisc() {
        VBox vb = new VBox();
        HBox hb = new HBox();
        //VBox v = new VBox();


        TextField search = new TextField();
        TextField filters = new TextField();


        Button apply = new Button("Filter");
        apply.setOnAction(event -> {filter();});
        hb.getChildren().addAll(filters,apply);
        vb.getChildren().addAll(search,hb);
        vb.setSpacing(5.5);
        return  vb;
    }
    private void filter() {
        DiscoverStart.layout.setCenter(centersearch());
    }

    private Node centersearch() {
        VBox vb = new VBox();
        Text resulttext = new Text("THIS WILL BE YOUR RESULTS");
        vb.getChildren().add(resulttext);
        return vb;
    }

}
