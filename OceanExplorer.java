/* Austin Paul and Aaron Mehrings
 * Final Project
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
	final int dimensions = 20; 
	final int scale = 50;
	final int islandCount = randIslands;
	
	OceanMap oceanMap; 
	boolean[][] islandMap;
	Scene scene;
	Pane root;
	
	ImageView ChristopherColumbusImageView;
	ImageView pirateOneImageView;
	ImageView pirateTwoImageView;
	ImageView pirateVertImageView;
	ImageView pirateHorzImageView;
	ImageView islandImageView;
	ImageView treasureImageView;
	
	ChristopherColumbus ChristopherColumbus;
	RegularPirateFactory regPirateFactory = new RegularPirateFactory();
	DutchmanFactory dutchFactory = new DutchmanFactory();
	PirateShip pirate1;
	PirateShip pirate2;
	static PirateShip pirateHorz;
	static PirateShip pirateVert;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = OceanMap.getInstance();
		islandMap = oceanMap.getMap();
		
		root = new AnchorPane();
		drawMap();
		loadIslandImages();
		
		loadTreasureImage();
				
		ChristopherColumbus = new ChristopherColumbus(oceanMap);
		loadChristopherColumbusImage();
		
		pirate1 = dutchFactory.createPirateShip("Slow");
		pirate2 = dutchFactory.createPirateShip("Fast");
		
		pirateVert = regPirateFactory.createPirateShip("Vertical");
		pirateHorz = regPirateFactory.createPirateShip("Horizontal");

		pirateVert.setStrategy(new VerticalMoveStrategy());
		pirateHorz.setStrategy(new HorizontalMoveStrategy());
		loadPirateImages();
		
		ChristopherColumbus.addObserver(pirate1);
		ChristopherColumbus.addObserver(pirate2);
		scene = new Scene(root, dimensions*scale, dimensions*scale);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean");
		oceanStage.show();
		startSailing();
	}
	
	//draws the Map of the game, no return value
	public void drawMap() {
		islandMap = oceanMap.getMap();
		for(int x = 0; x < dimensions; x++){
		   for(int y = 0; y < dimensions; y++){
		       Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale); 
		       rect.setStroke(Color.BLACK);   
		       rect.setFill(Color.PALETURQUOISE);  
		       root.getChildren().add(rect);
		   } 
		} 
	}
	
	//loads Christopher Columbus's Image to the game, no return value
	private void loadChristopherColumbusImage() {
		Image ChristopherColumbusImage = new Image("images\\ship.png", 50, 50 , true, true);
		ChristopherColumbusImageView = new ImageView(ChristopherColumbusImage);
		ChristopherColumbusImageView.setX(oceanMap.getChristopherColumbusLocation().x*scale);
		ChristopherColumbusImageView.setY(oceanMap.getChristopherColumbusLocation().y*scale);
		root.getChildren().add(ChristopherColumbusImageView);
	}
	
	//loads island images to the game, no return value
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
	
	//loads treasureImage
	private void loadTreasureImage() {
		Image treasureImage = new Image("images\\treasure.png", 50, 50 , true, true);
		treasureImageView = new ImageView(treasureImage);
		treasureImageView.setX(oceanMap.getTreasureLocation().x*scale);
		treasureImageView.setY(oceanMap.getTreasureLocation().y*scale);
		root.getChildren().add(treasureImageView);
	}
	
	//loads pirate images to the game, no return value
	private void loadPirateImages() {
		Image pirateShipImage = new Image("images\\pirateShip.png", 50, 50, true, true);
		Image dutchmanImage = new Image("images\\dutchman.png", 50, 50, true, true);
		pirateOneImageView = new ImageView(dutchmanImage);
		
		pirateOneImageView.setX(pirate1.getPirateShipLocation().x*scale);
		pirateOneImageView.setY(pirate1.getPirateShipLocation().y*scale);
		root.getChildren().add(pirateOneImageView);
		
		
		pirateTwoImageView = new ImageView(dutchmanImage);
		pirateTwoImageView.setX(pirate2.getPirateShipLocation().x*scale);
		pirateTwoImageView.setY(pirate2.getPirateShipLocation().y*scale);
		root.getChildren().add(pirateTwoImageView);
		
		pirateVertImageView = new ImageView(pirateShipImage);
		pirateVertImageView.setX(pirateVert.getPirateShipLocation().x*scale);
		pirateVertImageView.setY(pirateVert.getPirateShipLocation().y*scale);
		root.getChildren().add(pirateVertImageView);
		
		pirateHorzImageView = new ImageView(pirateShipImage);
		pirateHorzImageView.setX(pirateHorz.getPirateShipLocation().x*scale);
		pirateHorzImageView.setY(pirateHorz.getPirateShipLocation().y*scale);
		root.getChildren().add(pirateHorzImageView);
		
	}
	
	//allows the user to move Christopher Columbus, no return value
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent ke) {
				if(pirate1.getPirateShipLocation().x == oceanMap.getChristopherColumbusLocation().x && pirate1.getPirateShipLocation().y == oceanMap.getChristopherColumbusLocation().y 
				|| pirate2.getPirateShipLocation().x == oceanMap.getChristopherColumbusLocation().x && pirate2.getPirateShipLocation().y == oceanMap.getChristopherColumbusLocation().y 
				|| pirateVert.getPirateShipLocation().x == oceanMap.getChristopherColumbusLocation().x && pirateVert.getPirateShipLocation().y == oceanMap.getChristopherColumbusLocation().y 
				|| pirateHorz.getPirateShipLocation().x == oceanMap.getChristopherColumbusLocation().x && pirateHorz.getPirateShipLocation().y == oceanMap.getChristopherColumbusLocation().y)
						{			
							System.out.println("GAME OVER");
							System.exit(0);
						}
				
				if((oceanMap.getChristopherColumbusLocation().x ==oceanMap.getTreasureLocation().x 
					&& oceanMap.getChristopherColumbusLocation().y == oceanMap.getTreasureLocation().y))
					{
						System.out.println(" YOU WIN ");
						System.exit(0);
					}
				
				switch(ke.getCode()) {
					case RIGHT:
						ChristopherColumbus.goEast();
						break;
					case LEFT:
						ChristopherColumbus.goWest();
						break;
					case UP:
						ChristopherColumbus.goNorth();
						break;
					case DOWN:
						ChristopherColumbus.goSouth();

						break;
				default:
					break;
				}
				
				pirateVert.move();
				pirateHorz.move();
				
				ChristopherColumbusImageView.setX(oceanMap.getChristopherColumbusLocation().x*scale);
				ChristopherColumbusImageView.setY(oceanMap.getChristopherColumbusLocation().y*scale);
				
				pirateOneImageView.setX(pirate1.getPirateShipLocation().x*scale);
				pirateOneImageView.setY(pirate1.getPirateShipLocation().y*scale);
				
				pirateTwoImageView.setX(pirate2.getPirateShipLocation().x*scale);
				pirateTwoImageView.setY(pirate2.getPirateShipLocation().y*scale);
				
				pirateVertImageView.setX(pirateVert.getPirateShipLocation().x*scale);
				pirateVertImageView.setY(pirateVert.getPirateShipLocation().y*scale);
				
				pirateHorzImageView.setX(pirateHorz.getPirateShipLocation().x*scale);
				pirateHorzImageView.setY(pirateHorz.getPirateShipLocation().y*scale);
			}
		});
	}
	
	
	public static void main(String[] args) {
        launch(args);
		
    }

}
