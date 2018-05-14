/* Austin Paul
 * Assignment 2
 * SE350
 */


import javafx.stage.Stage;

import java.util.Observer;
import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanExplorer extends Application{
	Random randIsland = new Random();
	int randIslands = randIsland.nextInt(20);
	final int dimensions = 10; 
	final int scale = 50;
	final int islandCount = randIslands;
	
	OceanMap oceanMap; 
	boolean[][] islandMap;
	Scene scene;
	Pane root;
	
	ImageView shipImageView;
	ImageView pirateOneImageView;
	ImageView pirateTwoImageView;
	ImageView islandImageView;
	
	Ship ship;
	PirateShip pirate1;
	PirateShip pirate2;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = new OceanMap(dimensions, islandCount);
		islandMap = oceanMap.getMap();
		
		root = new AnchorPane();
		drawMap();
		loadIslandImages();
		
		ship = new Ship(oceanMap);
		loadShipImage();
		
		pirate1 = new PirateShip(oceanMap, 1);
		pirate2 = new PirateShip(oceanMap, 2);
		loadPirateImages();
		
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);
		
		scene = new Scene(root, 500, 500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean");
		oceanStage.show();
		startSailing();
	}
	
	public void drawMap() {
		islandMap = oceanMap.getMap();
		for(int x = 0; x < dimensions; x++){
		   for(int y = 0; y < dimensions; y++){
		       Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale); 
		       rect.setStroke(Color.BLACK);   // We want the black outline
		       rect.setFill(Color.PALETURQUOISE);  // I like this color better than BLUE
		       root.getChildren().add(rect);
		       // Add to the node tree in the pane
		   } 
		} 
	}
	
	private void loadShipImage() {
		Image shipImage = new Image("images\\ship.png", 50, 50 , true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation().x*scale);
		shipImageView.setY(oceanMap.getShipLocation().y*scale);
		root.getChildren().add(shipImageView);
	}
	
	private void loadIslandImages() {
		for(int x = 0; x < dimensions; x++){
			   for(int y = 0; y < dimensions; y++){
				   if (islandMap[x][y] == true) {
					    Image islandImage = new Image("images\\island.jpg", 50, 50 , true, true);
						islandImageView = new ImageView(islandImage);
						islandImageView.setX(x*scale);
						islandImageView.setY(y*scale);
						root.getChildren().add(islandImageView);
				   }
			   }
		}
	}
	
	private void loadPirateImages() {
		Image pirateShipImage = new Image("images\\pirateShip.png", 50, 50, true, true);
		pirateOneImageView = new ImageView(pirateShipImage);
		pirateOneImageView.setX(oceanMap.getPirateLocation(1).x*scale);
		pirateOneImageView.setY(oceanMap.getPirateLocation(1).y*scale);
		root.getChildren().add(pirateOneImageView);
		
		pirateTwoImageView = new ImageView(pirateShipImage);
		pirateTwoImageView.setX(oceanMap.getPirateLocation(2).x*scale);
		pirateTwoImageView.setY(oceanMap.getPirateLocation(2).y*scale);
		root.getChildren().add(pirateTwoImageView);
	}
	
	
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
					case RIGHT:
						ship.goEast();
						//pirate1.movePirateShip();
						//pirate2.movePirateShip();
						break;
					case LEFT:
						ship.goWest();
						//pirate1.movePirateShip();
						//pirate2.movePirateShip();
						break;
					case UP:
						ship.goNorth();
						//pirate1.movePirateShip();
						//.movePirateShip();
						break;
					case DOWN:
						ship.goSouth();
						//pirate1.movePirateShip();
						//pirate2.movePirateShip();
						break;
				default:
					break;
				}
				shipImageView.setX(oceanMap.getShipLocation().x*scale);
				shipImageView.setY(oceanMap.getShipLocation().y*scale);
				
				pirateOneImageView.setX(oceanMap.getPirateLocation(1).x*scale);
				pirateOneImageView.setY(oceanMap.getPirateLocation(1).y*scale);
				
				pirateTwoImageView.setX(oceanMap.getPirateLocation(2).x*scale);
				pirateTwoImageView.setY(oceanMap.getPirateLocation(2).y*scale);
			}
		});
	}
	
	
	public static void main(String[] args) {
        launch(args);
    }

}
