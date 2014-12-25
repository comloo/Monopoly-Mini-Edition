/*
    Name: Wendy Fu
    Game: Monopoly
    Teacher: Ms. Krasteva
    Date: 07/06/13
    This program will output the game of MONOPOLY!

    To play MONOPOLY, players will take turns going around the board landing on tiles. If a player lands on a property, he or she may
    choose to purchase it. If the property belongs to the other player, the player who landed on it must pay a property fine. There are
    also chance tiles, where landing on it will trigger a random event that may be benificial to the player or negative. The game ends
    when a player goes bankrupt. It is then where the program will ask users if they would like to save their score into a highscore file.


  =========================== || VARIABLE DICTIONARY || ==============================

    NAME:                           TYPE:                       DESCRIPTION:
    c                               reference                   Points to Console
    start                           boolean                     Determines if program has started
    p1Turn                          boolean                     Determines whose turn it is
    menuInput                       char                        Variable used to input
    quit                            char                        Variable used to quit
    fontMenu                        Font                        Typeface used for the bigger fonts
    fontMainText                    Font                        Typeface used for the main text
    title                           Font                        Typeface used to draw the main title/logo
    p1Token / p2Token               int                         The token players chose
    max / min                       int                         Determines dice roll maximum and minimum
    p1Money / p2Money               int                         Keeps tally of how much money in each player's account
    dice                            int                         Dice roll number
    event                           int                         Store event number
    p1Highest / p2Highest           int                         Stores the highest money reached by each player
    p1Total / p2Total               int                         The total score of each player
    p1Earned / p2Earned             int                         The amount of money each player has earned
    p1Moves / p2Moves               int                         The number of spaces each player has moved
    p1Location / p2Location         int                         Where each player is located
    boardBG                         Color                       Creates a background colour for the board
    boardLine                       Color                       Creates a drak brown for the outlines of the board
    boardBlue                       Color                       Creates a blue for property
    boardGreen                      Color                       Creates a green for property
    boardRed                        Color                       Creates a red for property
    boardYellow                     Color                       Creates a yellow for property
    chance                          Color                       Creates a light yellow for chance tiles
    green                           Color                       Creates a green for the logo
    red                             Color                       Creates a red for the logo
    redShadow                       Color                       Creates a dark red for the shadow on the logo
    TOTAL                           final int                   How many tiles there are in total
    EVENTTOTAL                      final int                   How many events there are in total
    SCORETOTAL                      final int                   How many highscores there are in total
    p1GridX / p2GridX               int array                   Determines x position of players
    p1GridY / p2GridY               int array                   Determines y position of players
    housePrice                      int array                   Stores house prices
    houseRentPrice                  int array                   Stores house rent prices
    highscores                      int array                   Stores the highscores in order from high to low
    eventMoney                      int array                   Stores the money change from events
    readGrid                        String array                Reads coordinates
    readEvent                       String array                Reads events
    readEvent2                      String array                Reads secondary events
    houseName                       String array                Reads house name
    houseOwner                      String array                Reads houses' owners to determine if they own or not
    highscorers                     String array                Stores the highscorers in order from high to low
    readScores                      String array                Reads the highscores
    p1Name / p2Name                 String                      Stores the user inputs of the players

    ==================================================================================
*/

// The "Monopoly" class.
//Imports classes
import hsa.*;
import java.io.*;
import java.awt.*;
import java.math.*;
public class Monopoly
{
    static Console c;
    boolean start = true, p1Turn = true;
    char menuInput, quit;
    Font fontMenu = new Font ("Century Gothic", Font.PLAIN, 15);
    Font fontMainText = new Font ("Century Gothic", Font.PLAIN, 10);
    Font title;
    int p1Token, p2Token, max = 3, min = 1, p1Money = 1500, p2Money = 1500, dice, event, p1Highest = 1500, p2Highest = 1500, p1Total = 0, p2Total = 0, p1Earned = 0, p2Earned = 0, p1Moves = 1, p2Moves = 1, p2Location = 1, p1Location = 1;
    Color boardBG = new Color (233, 229, 218);
    Color boardLine = new Color (110, 106, 97);
    Color boardBlue = new Color (116, 184, 197);
    Color boardGreen = new Color (180, 188, 40);
    Color boardRed = new Color (222, 78, 28);
    Color boardYellow = new Color (255, 220, 4);
    Color chance = new Color (255, 231, 141);
    Color green = new Color (147, 183, 122);
    Color red = new Color (197, 0, 9);
    Color redShadow = new Color (33, 16, 22);
    static final int TOTAL = 14, EVENTTOTAL = 25, SCORETOTAL = 10;
    int[] p1GridX = new int [TOTAL];
    int[] p1GridY = new int [TOTAL];
    int[] p2GridX = new int [TOTAL];
    int[] p2GridY = new int [TOTAL];
    int[] housePrice = new int [TOTAL];
    int[] houseRentPrice = new int [TOTAL];
    int[] highscores = new int [SCORETOTAL];
    int[] eventMoney = new int [EVENTTOTAL];
    String[] readGrid = new String [TOTAL];
    String[] readEvent = new String [EVENTTOTAL];
    String[] readEvent2 = new String [EVENTTOTAL];
    String[] houseName = new String [TOTAL];
    String[] houseOwner = new String [TOTAL];
    String[] highscorers = new String [SCORETOTAL];
    String[] readScores = new String [SCORETOTAL];
    String p1Name, p2Name;

    //Class constructor
    public Monopoly ()
    {
	c = new Console (42, 130, "MONOPOLY MINI");
    }


    //Main Menu Method - initiates program
    public void mainMenu ()
    {
	fileIO (); //Calls fileIO method to read all data in files and store in arrays
	menuInput = start ();
	start = true;
	//Loop to repeat menu
	do
	{

	    if (menuInput == 'i' || menuInput == 'I')
	    {
		instructions ();
		start ();
	    }

	    else if (menuInput == 'a' || menuInput == 'A')
	    {
		reset ();
		c.setFont (fontMainText);
		askData ();
		start = false;

	    }
	    else if (menuInput == 'h' || menuInput == 'H')
	    {
		displayHighscores ();
		start ();
	    }
	    else if (menuInput == 'q' || menuInput == 'Q')
	    {

		start = false;


	    }
	    else
		start ();
	}
	while (start == true);
    }


    //Logo method
    private void title ()
    {
	InputStream is = this.getClass ().getResourceAsStream ("Kabel-Heavy.ttf");
	try
	{
	    title = Font.createFont (Font.TRUETYPE_FONT, is);
	}
	catch (Exception e)
	{
	}
	Font mainTitle = title.deriveFont (Font.TRUETYPE_FONT, 140);
	c.setFont (mainTitle);
	//Draws bg
	c.setColor (boardBG);
	c.fillRect (0, 0, 1060, 850);
	//Draws buildings
	c.setColor (green);
	c.fillRect (400, 75, 40, 60);
	c.fillRect (440, 50, 45, 85);
	c.fillRect (450, 40, 25, 20);
	c.fillRect (475, 60, 40, 75);
	c.fillRect (515, 40, 20, 95);
	c.fillOval (505, 25, 40, 20);
	c.fillRect (535, 90, 40, 45);
	c.fillRect (575, 60, 50, 75);
	c.fillRect (625, 30, 20, 105);
	c.fillRect (645, 80, 30, 55);
	//Draws logo
	c.setColor (redShadow);
	c.fillRoundRect (106, 153, 880, 190, 35, 35);
	c.setColor (red);
	c.fillRoundRect (110, 150, 880, 190, 35, 35);
	c.setColor (Color.white);
	c.fillRoundRect (125, 165, 850, 160, 25, 25);
	c.setColor (red);
	c.fillRoundRect (135, 175, 830, 140, 20, 20);
	c.setColor (redShadow);
	c.drawString ("MONOPOLY", 146, 300);
	c.setColor (Color.white);
	c.drawString ("MONOPOLY", 150, 297);
    }


    //Display Highscore method - outputs 10 high scores from high to low
    private void displayHighscores ()
    {
	char highscoreInput; //temperary variable to exit high score
	title ();
	c.setFont (fontMainText);
	c.setColor (Color.white);
	c.fillRoundRect (300, 400, 480, 350, 25, 25);
	c.setColor (Color.black);
	c.drawString ("Name", 370, 430);
	c.drawString ("Score", 590, 430);

	for (int x = 0 ; x < 10 ; x++) //for loop to draw highscores
	{
	    c.drawString (highscorers [x], 370, 470 + x * 20);
	    c.drawString (Integer.toString (highscores [x]), 590, 470 + x * 20);

	}
	c.drawString ("Press 'x' to go back to the main menu.", 450, 730);

	highscoreInput = c.getChar ();
	if (highscoreInput == 'x' || highscoreInput == 'X')
	    start ();
	else
	    displayHighscores ();
    }


    //Display start method
    private char start ()
    {
	c.clear ();
	title ();
	Font subTitle = title.deriveFont (Font.TRUETYPE_FONT, 60);
	c.setFont (subTitle);
	c.setColor (Color.black);
	c.drawString ("Play (a)", 400, 440);
	c.drawString ("Instructions (i)", 400, 540);
	c.drawString ("Highscores (h)", 400, 640);
	c.drawString ("Quit (q)", 400, 740);
	menuInput = c.getChar ();
	return (menuInput);
    }


    //Display instructions method
    private void instructions ()
    {
	char instructionInput; //Temporary variable to determine whether to quit
	title ();
	c.setColor (Color.white);
	c.fillRoundRect (250, 400, 600, 350, 25, 25);
	c.setColor (Color.black);
	c.setFont (fontMenu);
	c.drawString ("Instructions", 500, 430);
	c.setFont (fontMainText);
	//Displays instructions
	c.drawString ("1. At the input screen, enter a username followed by a token selection. Both players must have different tokens.", 270, 470);
	c.drawString ("2. Roll dice to move your piece. You can roll a 1, 2 or 3.", 270, 490);
	c.drawString ("3. A tile with a coloured rectangle represents property, while a yellow tile represents a chance tile.", 270, 510);
	c.drawString ("4. If you land on a property tile, you may choose to purchase the land or leave it. Player 1 will have", 270, 530);
	c.drawString ("     red houses, while player 2 will have green houses.", 270, 550);
	c.drawString ("5. If you land on a chance tile, a random event will occur that can either be good or bad.", 270, 570);
	c.drawString ("6. If the other player lands on your property, then you will receive their 'rented' money.", 270, 590);
	c.drawString ("7. The game ends when one player goes bankrupt. You may then choose to save your score.", 270, 610);
	c.drawString ("8. You will be taken back to the main screen where you may choose to either play again, view highscores, view", 270, 630);
	c.drawString ("     instructions, or quit the game.", 270, 650);
	c.drawString ("Press 'x' to go back to the main menu.", 450, 730);
	instructionInput = c.getChar ();
	if (instructionInput == 'x' || instructionInput == 'X')
	    start ();
	else
	    instructions ();
    }


    //AskData method - asks user for name and token selection
    private void askData ()
    {
	String input; //Temporary variable to convert user input into an integer
	drawBoard ();
	c.setColor (Color.black);
	c.setColor (Color.white);
	c.fillRoundRect (300, 280, 300, 75, 25, 25);
	c.fillRoundRect (0, 280, 1060, 265, 25, 25);
	c.setFont (fontMainText);
	c.setColor (Color.black);
	c.drawString ("Player 1", 320, 295);
	c.drawString ("Name:", 330, 315);
	c.setCursor (16, 48);
	p1Name = c.readLine ();
	tokenHat (100, 330);
	c.drawString ("1", 117, 400);
	tokenShoe (100, 430);
	c.drawString ("2", 117, 478);
	tokenBarrel (210, 330);
	c.drawString ("3", 222, 400);
	tokenMelon (210, 420);
	c.drawString ("4", 222, 478);

	while (true) //Breaks loop once the user inputs 1, 2, 3 or 4
	{
	    c.setCursor (17, 55);
	    try //Errortraps input in case user types in String
	    {
		c.setColor (Color.black);
		c.drawString ("Choose your token: ", 330, 335);
		input = c.readLine ();
		p1Token = Integer.parseInt (input);
		if (p1Token == 1 || p1Token == 2 || p1Token == 3 || p1Token == 4)
		    break;
		else
		{
		    new Message ("Please enter 1-4!", "Error!");
		    c.setCursor (17, 55);
		    c.setColor (Color.white);
		    c.fillRect (430, 319, 400, 20);
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Please enter 1-4!", "Error!");
		c.setCursor (17, 55);
		c.setColor (Color.white);
		c.fillRect (430, 319, 400, 20);
	    }
	}
	c.drawString ("You chose: ", 530, 335);
	//Draws token according to what user chose
	if (p1Token == 1)
	    tokenHat (620, 300);
	if (p1Token == 2)
	    tokenShoe (620, 300);
	if (p1Token == 3)
	    tokenBarrel (620, 300);
	if (p1Token == 4)
	    tokenMelon (620, 300);

	c.drawString ("Player 2", 320, 375);
	c.drawString ("Name:", 330, 395);
	c.setCursor (20, 48);
	p2Name = c.readLine ();

	while (true) //Breaks loop once the user inputs 1, 2, 3 or 4
	{
	    try //Errortraps input in case user types in String
	    {
		c.setCursor (21, 55);
		c.setColor (Color.black);
		c.drawString ("Choose your token: ", 330, 415);
		input = c.readLine ();
		p2Token = Integer.parseInt (input);
		if (p2Token != p1Token && (p2Token == 1 || p2Token == 2 || p2Token == 3 || p2Token == 4))
		    break;
		if (p2Token == p1Token)
		{
		    c.setCursor (20, 42);
		    c.drawString ("That token is already selected!", 330, 430);
		}
		else
		{
		    new Message ("Please enter 1-4!", "Error!");
		    c.setCursor (17, 55);
		    c.setColor (Color.white);
		    c.fillRect (430, 399, 400, 20);
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("Please enter 1-4!", "Error!");
		c.setCursor (17, 55);
		c.setColor (Color.white);
		c.fillRect (430, 399, 400, 20);
	    }
	}
	c.drawString ("You chose: ", 530, 415);
	//Draws token according to what user chose
	if (p2Token == 1)
	    tokenHat (620, 420);
	if (p2Token == 2)
	    tokenShoe (620, 420);
	if (p2Token == 3)
	    tokenBarrel (620, 420);
	if (p2Token == 4)
	    tokenMelon (620, 420);
	c.setCursor (26, 20);
	c.println ("Press any key to continue.");
	c.getChar ();

    }


    //FileIO method that runs and reads info from text files. It then stores info into respective arrays.
    private void fileIO ()
    {
	try //BufferedReader errortrap
	{
	    BufferedReader br = new BufferedReader (new FileReader ("p1GridX.txt"));
	    BufferedReader br2 = new BufferedReader (new FileReader ("p1GridY.txt"));
	    BufferedReader br3 = new BufferedReader (new FileReader ("p2GridX.txt"));
	    BufferedReader br4 = new BufferedReader (new FileReader ("p2GridY.txt"));
	    BufferedReader br5 = new BufferedReader (new FileReader ("event.txt"));
	    BufferedReader br6 = new BufferedReader (new FileReader ("EventMoney.txt"));
	    BufferedReader br7 = new BufferedReader (new FileReader ("House Names.txt"));
	    BufferedReader br8 = new BufferedReader (new FileReader ("House Prices.txt"));
	    BufferedReader br9 = new BufferedReader (new FileReader ("House Rent Prices.txt"));
	    BufferedReader br10 = new BufferedReader (new FileReader ("Highscorers.txt"));
	    BufferedReader br11 = new BufferedReader (new FileReader ("Highscores.txt"));

	    for (int i = 0 ; i < TOTAL ; i++) //Loop to read every file with TOTAL lines
	    {
		readGrid [i] = br2.readLine ();
		p1GridY [i] = Integer.parseInt (readGrid [i]);
		readGrid [i] = br3.readLine ();
		p2GridX [i] = Integer.parseInt (readGrid [i]);
		readGrid [i] = br.readLine ();
		p1GridX [i] = Integer.parseInt (readGrid [i]);
		readGrid [i] = br4.readLine ();
		p2GridY [i] = Integer.parseInt (readGrid [i]);
		houseName [i] = br7.readLine ();
		houseOwner [i] = " ";
		readGrid [i] = br8.readLine ();
		housePrice [i] = Integer.parseInt (readGrid [i]);
		readGrid [i] = br9.readLine ();
		houseRentPrice [i] = Integer.parseInt (readGrid [i]);

	    }

	    for (int i = 0 ; i < EVENTTOTAL ; i++) //Loops to read every file with EVENTTOTAL lines
	    {
		readEvent [i] = br5.readLine ();

	    }
	    for (int i = 0 ; i < EVENTTOTAL ; i++) //Loops to read every file with EVENTTOTAL2 lines
	    {
		readEvent2 [i] = br6.readLine ();
		eventMoney [i] = Integer.parseInt (readEvent2 [i]);

	    }

	    for (int i = 0 ; i < SCORETOTAL ; i++)  //Loops to read every file with SCORETOTAL lines
	    {
		highscorers [i] = br10.readLine ();
		readScores [i] = br11.readLine ();
		highscores [i] = Integer.parseInt (readScores [i]);


	    }
	}
	catch (IOException e)
	{
	}
    }


    //Method to output an animation for 'next turn'
    private void nextTurn (int x)
    {
	c.setColor (boardBG);
	c.fillRect (400, 253, 400, 20);
	if (x == 1) //If player 1's turn, draws player 1's name
	{
	    for (int i = 1 ; i < 219 ; i++)
	    {
		c.setColor (new Color (233 - i, 229 - i, 218 - i));
		c.drawString (p1Name + "'s turn! Press any key to roll dice.", 400, 270);
		try
		{
		    Thread.sleep (4);
		}
		catch (Exception e)
		{
		}
	    }
	}
	if (x == 2) //If player 2's turn, draws player 2's name
	{
	    for (int i = 1 ; i < 219 ; i++)
	    {
		c.setColor (new Color (233 - i, 229 - i, 218 - i));
		c.drawString (p2Name + "'s turn! Press any key to roll dice.", 400, 270);
		try
		{
		    Thread.sleep (4);
		}
		catch (Exception e)
		{
		}
	    }
	}
    }


    //Display method - displays board and the gameplay
    public void display ()
    {
	drawBoard (); //Draws board
	c.setColor (Color.black);
	drawToken (p1GridX [0], p1GridY [0], p1Token);
	drawToken (p2GridX [0], p2GridY [0], p2Token);
	displayMoney (p1Money, p2Money);

	while (true) //Game breaks when any player's money reaches 0
	{
	    p1Turn = true;
	    rollDice ();
	    p1Moves += dice;
	    if (p1Location == 3 || p1Location == 9 || p1Location == 14) //Erases token
		c.setColor (chance);
	    else
		c.setColor (boardBG);
	    drawToken (p1GridX [p1Location - 1], p1GridY [p1Location - 1], p1Token);
	    c.setColor (boardBG);
	    c.fillRect (380, 315, 400, 20);
	    p1Location = ((p1Moves - 1) % 14) + 1;
	    c.setColor (Color.black);
	    drawToken (p1GridX [p1Location - 1], p1GridY [p1Location - 1], p1Token);
	    event ();
	    if (p1Money <= 0 || p2Money <= 0) //Breaks when player's money reaches 0
		break;
	    house ();
	    if (p1Money <= 0 || p2Money <= 0)
		break;
	    displayMoney (p1Money, p2Money);
	    p1Turn = false; //Player 2's turn
	    c.setColor (boardBG);
	    c.fillRect (400, 290, 100, 12);
	    nextTurn (2);
	    c.getChar ();
	    rollDice ();
	    p2Moves += dice;
	    if (p2Location == 3 || p2Location == 9 || p2Location == 14) //Erases token
		c.setColor (chance);
	    else
		c.setColor (boardBG);
	    drawToken (p2GridX [p2Location - 1], p2GridY [p2Location - 1], p2Token);
	    c.setColor (boardBG);
	    c.fillRect (380, 315, 400, 20);
	    p2Location = ((p2Moves - 1) % 14) + 1;
	    c.setColor (Color.black);
	    drawToken (p2GridX [p2Location - 1], p2GridY [p2Location - 1], p2Token);
	    event ();
	    if (p1Money <= 0 || p2Money <= 0) //Breaks when player's money reaches 0
		break;
	    house ();
	    if (p1Money <= 0 || p2Money <= 0)
		break;
	    displayMoney (p1Money, p2Money);
	    c.setColor (boardBG);
	    c.fillRect (400, 290, 100, 12);
	    nextTurn (1);
	    c.getChar ();
	}
    }


    //drawBoard method to draw main game board
    private void drawBoard ()
    {
	c.clear ();
	c.setColor (boardBG);
	c.fillRoundRect (10, 10, 1030, 830, 25, 25);
	c.setColor (chance);
	c.fillRect (225, 10, 200, 210);
	c.fillRect (425, 605, 200, 250);
	c.fillRect (825, 413, 230, 195);
	c.setColor (boardRed);
	c.fillRect (420, 180, 405, 40);
	c.setColor (boardGreen);
	c.fillRect (225, 605, 200, 40);
	c.fillRect (625, 605, 200, 40);
	c.setFont (fontMenu);
	c.setColor (boardLine);
	c.drawString ("Mediterranean Avenue", 636, 820);
	c.drawString ("Oriential Avenue", 256, 820);
	c.drawString ("St. Charles Place", 20, 600);
	c.drawString ("Tennesse Avenue", 20, 400);
	c.drawString ("Kentucky Avenue", 446, 30);
	c.drawString ("Marvin Gardens", 656, 30);
	c.drawString ("Boardwalk", 900, 400);
	c.setColor (boardBlue);
	c.fillRect (825, 225, 40, 193);
	c.setColor (boardYellow);
	c.fillRect (185, 225, 40, 385);
	//Main horizontal lines
	c.setColor (boardLine);
	c.fillRect (10, 220, 1030, 5);
	c.fillRect (10, 605, 1030, 5);
	c.fillRect (10, 413, 1030, 5);
	//Main vertical lines
	c.fillRect (220, 10, 5, 830);
	c.fillRect (825, 10, 5, 830);
	c.fillRect (420, 10, 5, 830);
	c.fillRect (620, 10, 5, 830);
	//Subvertical lines
	c.fillRect (180, 220, 5, 385);
	c.fillRect (865, 220, 5, 193);
	//Subhorizontal lines
	c.fillRect (420, 180, 405, 5);
	c.fillRect (225, 645, 200, 5);
	c.fillRect (625, 645, 200, 5);
	c.setColor (boardBG);
	c.fillRoundRect (225, 225, 600, 380, 25, 25);
	c.setFont (fontMainText);
    }


    //Draws hat token
    private void tokenHat (int x, int y)
    {

	c.fillRoundRect (x, y, 40, 50, 10, 10);
	c.fillRoundRect (x - 8, y + 45, 55, 12, 5, 5);
    }


    //Draws shoe token
    private void tokenShoe (int x, int y)
    {
	c.fillOval (x - 5, y + 20, 50, 15);
	c.fillRoundRect (x - 5, y + 30, 50, 5, 5, 5);
	c.fillRect (x + 27, y, 17, 30);
    }


    //Draws barrel token
    private void tokenBarrel (int x, int y)
    {
	c.fillOval (x - 10, y, 50, 15);
	c.fillOval (x - 10, y + 40, 50, 15);
	c.fillOval (x - 13, y + 3, 20, 47);
	c.fillOval (x + 22, y + 3, 20, 47);
	c.fillRect (x + 5, y + 11, 22, 32);

    }


    //Draws house token
    private void tokenHouse (int x, int y)
    {
	int xpoint[] = {x, x + 30, x + 60};
	int ypoint[] = {y + 10, y - 20, y + 10};
	int npoint = 3;
	c.fillPolygon (xpoint, ypoint, npoint);
	c.fillRect (x + 10, y, 40, 30);
    }


    //Draws melon token
    private void tokenMelon (int x, int y)
    {
	c.fillArc (x - 15, y - 10, 60, 50, 0, -180);

    }


    //Rolls dice - randomly generates number between 1 and 3
    private void rollDice ()
    {
	dice = (int) (Math.random () * (max + 1 - min) + min);
	c.setColor (boardBG);
	c.fillRect (400, 290, 100, 12);
	c.setColor (Color.black);
	if (p1Turn == true)
	{
	    c.drawString (p1Name + " rolled:" + Integer.toString (dice), 400, 300);
	}

	if (p1Turn == false)
	{
	    c.drawString (p2Name + " rolled:" + Integer.toString (dice), 400, 300);
	}
	c.drawString ("Press any key to move your piece.", 400, 330);
	c.getChar ();
    }


    //Event method - calls a random event from an array
    private void event ()
    {
	char input; //Temporary variable to continue or not
	int eventNum; //Stores the event number to call the info from the file
	if (p1Turn == true) //Player 1 event trigger
	{
	    eventNum = (int) (Math.random () * (25 + 1 - 1) + 1);
	    if (p1Location == 3 || p1Location == 9 || p1Location == 14) //If they land on chance, it triggers an event
	    {
		c.setColor (Color.black);
		c.drawString (readEvent [eventNum - 1], 400, 330);
		if (eventNum == 1 || eventNum == 3 || eventNum == 7 || eventNum == 8 || eventNum == 11 || eventNum == 12 || eventNum == 13 || eventNum == 14 || eventNum == 15 || eventNum == 16 || eventNum == 20 || eventNum == 21)
		{
		    p1Money += eventMoney [eventNum - 1];
		    p1Earned += eventMoney [eventNum - 1];
		}
		if (eventNum == 2 || eventNum == 4 || eventNum == 9 || eventNum == 10 || eventNum == 17 || eventNum == 18 || eventNum == 22 || eventNum == 23)
		{
		    p1Money += eventMoney [eventNum - 1];
		}
		if (eventNum == 5 || eventNum == 6)
		{
		    p1Money += eventMoney [eventNum - 1];
		    p1Earned += eventMoney [eventNum - 1];
		    p2Money -= eventMoney [eventNum - 1];
		}
		if (eventNum == 19)
		{
		    p1Money += eventMoney [eventNum - 1];
		    p2Money -= eventMoney [eventNum - 1];
		    p2Earned -= eventMoney [eventNum - 1];
		}
		if (eventNum == 24)
		{
		    int num = (int) (Math.random () * (p2Money + 1 - 1) + 1);
		    p1Money += num;
		    p2Money -= num;
		    p1Earned -= num;
		}
		if (eventNum == 25)
		{
		    p1Money *= (int) 0.9;
		}
		do //Continues once c is entered
		{
		    c.drawString ("Press 'c' to continue", 400, 550);
		    input = c.getChar ();

		}
		while (input != 'c' || input != 'C');
		c.setColor (boardBG);
		c.fillRect (380, 515, 440, 40);
		c.fillRect (380, 315, 440, 20);

	    }

	    else if (p1Location == 1) //If player landed on 'Go', collects $200
	    {
		c.drawString ("You landed on go! Collect $200.", 400, 330);
		p1Money += 200;
		p1Earned += 200;
		do //Repeats until c is entered
		{
		    c.drawString ("Press 'c' to continue", 400, 550);
		    input = c.getChar ();
		}
		while (input != 'c' || input != 'C');
		c.setColor (boardBG);
		c.fillRect (380, 515, 400, 40);
		c.fillRect (380, 315, 400, 20);
	    }
	    if (p1Money > p1Highest)
		p1Highest = p1Money;
	}

	//Player 2's turn
	if (p1Turn == false)
	{

	    eventNum = (int) (Math.random () * (21 + 1 - 1) + 1);

	    if (p2Location == 3 || p2Location == 9 || p2Location == 14) //If they land on chance, it triggers an event
	    {

		c.setColor (Color.black);
		c.drawString (readEvent [eventNum - 1], 400, 330);

		if (p2Location == 3 || p2Location == 9 || p2Location == 14)
		{
		    if (eventNum == 1 || eventNum == 3 || eventNum == 7 || eventNum == 8 || eventNum == 11 || eventNum == 12 || eventNum == 13 || eventNum == 14 || eventNum == 15 || eventNum == 16 || eventNum == 20 || eventNum == 21)
		    {
			p2Money += eventMoney [eventNum - 1];
			p2Earned += eventMoney [eventNum - 1];
		    }

		    if (eventNum == 2 || eventNum == 4 || eventNum == 9 || eventNum == 10 || eventNum == 17 || eventNum == 18 || eventNum == 22 || eventNum == 23)
		    {
			p2Money += eventMoney [eventNum - 1];
		    }

		    if (eventNum == 5 || eventNum == 6)
		    {
			p2Money += eventMoney [eventNum - 1];
			p2Earned += eventMoney [eventNum - 1];
			p1Money -= (eventMoney [eventNum - 1]);
		    }
		    if (eventNum == 19)
		    {
			p2Money += eventMoney [eventNum - 1];
			p1Money -= eventMoney [eventNum - 1];
			p1Earned -= eventMoney [eventNum - 1];
		    }
		    if (eventNum == 24)
		    {
			int num = (int) (Math.random () * (p1Money + 1 - 1) + 1);
			p2Money += num;
			p1Money -= num;
			p2Earned -= num;
		    }
		    if (eventNum == 25)
		    {
			p2Money = (int) (p2Money * 90) / 100;
		    }
		}
		do //Continues once c is entered
		{
		    c.drawString ("Press 'c' to continue", 400, 550);
		    input = c.getChar ();
		}
		while (input != 'c');
		c.setColor (boardBG);
		c.fillRect (380, 515, 440, 40);
		c.fillRect (380, 315, 440, 20);
	    }
	    else if (p2Location == 1) //If player landed on 'Go', collects $200
	    {
		c.drawString ("You landed on go! Collect $200.", 400, 330);
		p2Money += 200;
		p2Earned += 200;

		do //Repeats until c is entered
		{
		    c.drawString ("Press 'c' to continue", 400, 550);
		    input = c.getChar ();
		}
		while (input != 'c' || input != 'C');
		c.setColor (boardBG);
		c.fillRect (380, 515, 400, 40);
		c.fillRect (380, 315, 400, 20);
	    }
	}
	if (p2Money > p2Highest)
	    p2Highest = p2Money;
    }


    //House event method - Allows users to choose between buying or passing, as well as paying a loan
    private void house ()
    {
	char houseBuy, input; //Temporary variables
	houseBuy = ' ';
	if (p1Turn == true) //Player 1 house event trigger
	{
	    if (p1Location == 2 || p1Location == 4 || p1Location == 6 || p1Location == 7 || p1Location == 10 || p1Location == 11 || p1Location == 13)
	    {
		c.drawString (p1Name + " has landed on " + houseName [p1Location - 1] + ".", 400, 400);
		if (houseOwner [p1Location - 1] == " ") //If there is no name connected to the house, you may buy it
		{
		    do //Repeats until user input y or n
		    {
			c.drawString ("Would you like to purchase this house for $" + Integer.toString (housePrice [p1Location - 1]) + "?", 400, 420);
			c.drawString ("Press 'y' to buy. Press 'n' to cancel.", 400, 440);
			houseBuy = c.getChar ();
		    }
		    while (houseBuy != 'y' && houseBuy != 'n');

		    if (houseBuy == 'y') //If user inputs y, the house is bought
		    {
			if (p1Money < housePrice [p1Location - 1]) //If money is not enough, then displays string below
			    c.drawString ("I'm sorry, but you do not have enough money to buy this property.", 400, 460);
			else
			{
			    houseOwner [p1Location - 1] = p1Name;
			    c.drawString (p1Name + " has just purchased " + houseName [p1Location - 1] + ".", 400, 460);
			    p1Money -= housePrice [p1Location - 1];
			    drawHouse (p1Location, 1);
			}
			do
			{
			    c.setColor (Color.black);
			    c.drawString ("Press 'c' to continue", 400, 550);
			    input = c.getChar ();
			}
			while (input != 'c' || input != 'C');
		    }
		}
		if (houseOwner [p1Location - 1] == p2Name) //If the other player's name is connected to the house, then player pays other player
		{
		    p1Money -= houseRentPrice [p1Location - 1];
		    p2Money += houseRentPrice [p1Location - 1];
		    p2Earned += houseRentPrice [p1Location - 1];
		    if (p2Money > p2Highest)
			p2Highest = p2Money;
		    do
		    {
			c.drawString (p1Name + " has landed on " + p2Name + "'s property. Pay $" + houseRentPrice [p1Location - 1] + ".", 400, 420);
			c.drawString ("Press 'c' to continue", 400, 550);
			input = c.getChar ();
		    }
		    while (input != 'c' || input != 'C');
		}
		c.setColor (boardBG);
		c.fillRect (400, 390, 400, 80);
	    }
	}
	if (p1Turn == false) //Player 2 house event trigger - same comments as above
	{

	    if (p2Location == 2 || p2Location == 4 || p2Location == 6 || p2Location == 7 || p2Location == 10 || p2Location == 11 || p2Location == 13)
	    {
		c.drawString (p2Name + " has landed on " + houseName [p2Location - 1], 400, 400);
		if (houseOwner [p2Location - 1] == " ")
		{
		    do
		    {
			c.drawString ("Would you like to purchase this house for $" + Integer.toString (housePrice [p2Location - 1]) + "?", 400, 420);
			c.drawString ("Press 'y' to buy. Press 'n' to cancel.", 400, 440);
			houseBuy = c.getChar ();
		    }
		    while (houseBuy != 'y' && houseBuy != 'n');
		    if (houseBuy == 'y')
		    {
			if (p2Money < housePrice [p2Location - 1])
			    c.drawString ("I'm sorry, but you do not have enough money to buy this property.", 400, 460);
			else
			{
			    houseOwner [p2Location - 1] = p2Name;
			    c.drawString (p2Name + " has just purchased " + houseName [p2Location - 1] + ".", 400, 460);
			    p2Money -= housePrice [p2Location - 1];
			    drawHouse (p2Location, 2);
			}
			do
			{
			    c.setColor (Color.black);
			    c.drawString ("Press 'c' to continue", 400, 550);
			    input = c.getChar ();
			}
			while (input != 'c' || input != 'C');
		    }
		}
		if (houseOwner [p2Location - 1] == p1Name)
		{
		    p2Money -= houseRentPrice [p2Location - 1];
		    p1Money += houseRentPrice [p2Location - 1];
		    p1Earned += houseRentPrice [p2Location - 1];
		    if (p1Money > p1Highest)
			p1Highest = p1Money;
		    do
		    {
			c.drawString (p2Name + " has landed on " + p1Name + "'s property. Pay $" + houseRentPrice [p2Location - 1] + ".", 400, 420);
			c.drawString ("Press 'c' to continue", 400, 550);

			input = c.getChar ();
		    }
		    while (input != 'c' || input != 'C');
		}
		c.setColor (boardBG);
		c.fillRect (400, 390, 400, 80);
	    }
	}
	input = ' ';
	c.setColor (boardBG);
	c.fillRect (380, 515, 400, 40);
	c.fillRect (380, 315, 400, 20);
    }


    //Displays Money Method - Draws the current amount of money in each player's account on screen
    private void displayMoney (int x, int y)
    {
	c.setColor (boardBG);
	c.fillRect (250, 470, 360, 35);
	c.fillRect (250, 490, 360, 35);
	c.setColor (Color.black);
	c.drawString (p1Name + "'s money: " + Integer.toString (x), 250, 500);
	c.drawString (p2Name + "'s money: " + Integer.toString (y), 250, 520);
    }


    //Draw token method that calls individual tokens to be drawn
    private void drawToken (int x, int y, int z)
    {
	if (z == 1)
	    tokenHat (x, y);
	if (z == 2)
	    tokenShoe (x, y);
	if (z == 3)
	    tokenBarrel (x, y);
	if (z == 4)
	    tokenMelon (x, y);
    }


    //Draw house method that calls houses and displays them on the board according to which owner bought it as well as where to draw the house
    private void drawHouse (int x, int y)
    {
	if (y == 1)
	    c.setColor (Color.red);
	else
	    c.setColor (Color.green);
	if (x == 2)
	{
	    tokenHouse (695, 610);
	}
	else if (x == 4)
	{
	    tokenHouse (295, 610);
	}
	else if (x == 6)
	{
	    tokenHouse (172, 490);
	}
	else if (x == 7)
	{
	    tokenHouse (172, 300);
	}
	else if (x == 10)
	{
	    tokenHouse (495, 185);
	}
	else if (x == 11)
	{
	    tokenHouse (695, 185);
	}
	else if (x == 13)
	{
	    tokenHouse (817, 300);
	}
    }


    //Ending screen that displays final score and asks user if they wish to save their score
    public void bankrupt ()
    {
	int p1HousesOwned = 0, p2HousesOwned = 0; //Resets houses owned
	char input = ' '; //Temporary variable that allows users to save score or not
	c.setColor (Color.white);
	c.fillRoundRect (0, 280, 1060, 265, 25, 25);
	c.setFont (fontMainText);
	c.setColor (Color.black);
	//Displays which player is bankrupt
	if (p1Money <= 0)
	{
	    c.drawString (p1Name + " is bankrupt! " + p2Name + " wins!", 320, 300);
	    c.drawString ("Congratulations!", 320, 320);
	}
	if (p2Money <= 0)
	{
	    c.drawString (p2Name + " is bankrupt! " + p1Name + " wins!", 320, 300);
	    c.drawString ("Congratulations!", 320, 320);
	}
	c.drawString ("Press any key to view scores.", 390, 340);
	c.getChar ();
	c.drawString (p1Name, 300, 360);
	c.drawString ("Most money in account: " + Integer.toString (p1Highest), 300, 380);
	//Loop to add up total number of houses players own
	for (int i = 0 ; i < TOTAL ; i++)
	{
	    if (houseOwner [i] == p1Name)
		p1HousesOwned++;
	}
	c.drawString ("Amount of houses owned: " + Integer.toString (p1HousesOwned), 300, 400);
	//Adds bonus money to whichever player won
	if (p2Money <= 0)
	    p1Total = (p1HousesOwned + 1) * p1Highest + 2000 + p1Earned;
	else
	    p1Total = (p1HousesOwned + 1) * p1Highest + p1Earned;
	c.drawString ("Total score: " + Integer.toString (p1Total), 300, 420);
	c.drawString (p2Name, 550, 360);
	c.drawString ("Most money in account: " + Integer.toString (p2Highest), 550, 380);
	for (int i = 0 ; i < TOTAL ; i++)
	{
	    if (houseOwner [i] == p2Name)
		p2HousesOwned++;
	}
	c.drawString ("Amount of houses owned: " + Integer.toString (p2HousesOwned), 550, 400);
	if (p1Money <= 0)
	    p2Total = (p2HousesOwned + 1) * p2Highest + 2000 + p2Earned;
	else
	    p2Total = (p2HousesOwned + 1) * p2Highest + p2Earned;
	c.drawString ("Total score: " + Integer.toString (p2Total), 550, 420);
	c.drawString (p1Name + ", would you like to save your score? (Press 'y' to save, press 'n' to quit without saving.)", 310, 440);
	//Repeats until user types y or n
	do
	{
	    input = c.getChar ();

	}
	while (input != 'y' && input != 'n');
	if (input == 'y') //Saves
	{
	    saveHighscore (1);
	    for (int x = 255 ; x > -1 ; x--) //Small animation
	    {
		c.setColor (new Color (x, x, x));
		c.drawString ("Saved!", 330, 460);
		try
		{
		    Thread.sleep (4);
		}
		catch (Exception e)
		{
		}
	    }
	}
	input = ' '; //Resets input
	c.drawString (p2Name + ", would you like to save your score? (Press 'y' to save, press 'n' to quit without saving.)", 310, 480);
	do
	{
	    input = c.getChar ();
	}
	while (input != 'y' && input != 'n');
	if (input == 'y') //Saves
	{
	    saveHighscore (2);
	    for (int x = 255 ; x > -1 ; x--) //Small animation
	    {
		c.setColor (new Color (x, x, x));
		c.drawString ("Saved!", 330, 500);
		try
		{
		    Thread.sleep (4);
		}
		catch (Exception e)
		{
		}
	    }

	}
	c.drawString ("Press any key to go back to the menu.", 330, 520);
	c.getChar ();
    }


    //Saves highscores into array - pseudo bubble sort
    private void saveHighscore (int x)
    {
	try
	{
	    PrintWriter pw = new PrintWriter (new FileWriter ("Highscorers.txt"));
	    PrintWriter pw2 = new PrintWriter (new FileWriter ("Highscores.txt"));
	    if (x == 1) //Player 1's save
	    {
		for (int i = 0 ; i < SCORETOTAL ; i++)
		{
		    if (highscores [i] < p1Total)
		    {
			for (int j = SCORETOTAL - 1 ; j > i ; j--)
			{
			    highscores [j] = highscores [j - 1];
			    highscorers [j] = highscorers [j - 1];
			}
			highscores [i] = p1Total;
			highscorers [i] = p1Name;
			i = SCORETOTAL;
		    }
		}
		for (int i = 0 ; i < SCORETOTAL ; i++)
		{
		    pw2.println (highscores [i]);
		    pw.println (highscorers [i]);
		}
	    }
	    if (x == 2) //Player 2's save
	    {
		for (int i = 0 ; i < SCORETOTAL ; i++)
		{
		    if (highscores [i] < p2Total)
		    {
			for (int j = SCORETOTAL - 1 ; j > i ; j--)
			{
			    highscores [j] = highscores [j - 1];
			    highscorers [j] = highscorers [j - 1];
			}
			highscores [i] = p2Total;
			highscorers [i] = p2Name;
			i = SCORETOTAL;
		    }
		}
		for (int i = 0 ; i < SCORETOTAL ; i++)
		{
		    pw2.println (highscores [i]);
		    pw.println (highscorers [i]);
		}
	    }
	    pw2.close ();
	    pw.close ();
	}
	catch (IOException e)
	{
	}
    }


    //Resets every stored user data back to its original
    private void reset ()
    {
	p1Name = " ";
	p2Name = " ";
	p1Money = 1500;
	p2Money = 1500;
	p1Highest = 1500;
	p2Highest = 1500;
	p1Total = 0;
	p2Total = 0;
	p1Earned = 0;
	p2Earned = 0;
	for (int i = 0 ; i < TOTAL ; i++)
	{
	    houseOwner [i] = " ";
	}
    }


    //Pauses program
    private void pauseProgram ()
    {
	c.setFont (fontMenu);
	c.drawString ("Press any key to close.", 260, 590);
	c.getChar ();
    }


    //Goodbye screen
    public void goodbye ()
    {
	c.clear ();
	title ();
	c.setColor (Color.black);
	Font subTitle = title.deriveFont (Font.TRUETYPE_FONT, 60);
	c.setFont (subTitle);
	c.drawString ("Thank you playing Monopoly!", 250, 440);
	c.setFont (fontMenu);
	c.drawString ("By Wendy Fu", 260, 480);
	pauseProgram ();
	c.close ();
    }


    //Calls splashscreen method from another file
    public void splashScreen ()
    {
	//creates splashscreen thread
	SplashScreen ss = new SplashScreen (c);
	//starts thread
	ss.run ();
    }


    //Main method - calls the public methods
    public static void main (String[] args)
    {
	Monopoly m = new Monopoly ();
	m.splashScreen ();
	while (true) //Breaks if user inputs 'q' at the main menu screen
	{
	    m.mainMenu ();
	    if (m.menuInput == 'q' || m.menuInput == 'Q')
		break;
	    m.display ();
	    m.bankrupt ();
	}
	m.goodbye ();
    }
}
//Ends 'Monopoly' class
