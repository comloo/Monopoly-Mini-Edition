/*
    Name: Wendy Fu
    Teacher: Ms. Krasteva
    Date: 07/06/13
    Assignment: A complex animation created using draw and fill commands in
    threading formation. This animation includes an overloaded constructor
    enabing the programmer to create only one class but alter its parameters
    in many ways.
*/

import java.awt.*;
import hsa.Console;
import java.lang.*; // to access Thread class
import java.io.*;

//The "SplashScreen" class.
public class SplashScreen extends Thread
{
    private Console c;
    Color red = new Color (197, 0, 9);
    Color redShadow = new Color (33, 16, 22);
    Color green = new Color (147, 183, 122);
    Color boardBG = new Color (233, 229, 218);
    Color skin = new Color (255, 194, 150);
    Color cane = new Color (199, 130, 51);
    Font title;
    
    //splashScreen method
    public void splashScreen ()
    {
	//loop to animate first sentence
	InputStream is = this.getClass ().getResourceAsStream ("Kabel-Heavy.ttf");
	try
	{
	    title = Font.createFont (Font.TRUETYPE_FONT, is);
	}
	catch (Exception e)
	{
	}
	Font mainTitle = title.deriveFont (Font.TRUETYPE_FONT, 140);
	Font subTitle = title.deriveFont (Font.TRUETYPE_FONT, 60);

	c.setFont (mainTitle);
	c.setColor (boardBG);
	c.fillRect (0, 0, 1060, 850);

	for (int x = 0 ; x < 800 ; x++)
	{
	    c.setColor (boardBG);
	    c.fillRect (400, 825 - x, 300, 510);

	    c.setColor (green);
	    c.fillRect (400, 875 - x, 40, 60);
	    c.fillRect (440, 850 - x, 45, 85);
	    c.fillRect (450, 840 - x, 25, 20);
	    c.fillRect (475, 860 - x, 40, 75);
	    c.fillRect (515, 840 - x, 20, 95);
	    c.fillOval (505, 825 - x, 40, 20);
	    c.fillRect (535, 890 - x, 40, 45);
	    c.fillRect (575, 860 - x, 50, 75);
	    c.fillRect (625, 830 - x, 20, 105);
	    c.fillRect (645, 880 - x, 30, 55);
	    try
	    {
		sleep (1);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 0 ; x < 600 ; x++)
	{
	    c.setColor (boardBG);
	    c.fillRect (106, 750 - x, 900, 200);

	    c.setColor (redShadow);
	    c.fillRoundRect (106, 753 - x, 880, 190, 35, 35);
	    c.setColor (red);
	    c.fillRoundRect (110, 750 - x, 880, 190, 35, 35);
	    c.setColor (Color.white);
	    c.fillRoundRect (125, 765 - x, 850, 160, 25, 25);
	    c.setColor (red);
	    c.fillRoundRect (135, 775 - x, 830, 140, 20, 20);
	    c.setColor (redShadow);
	    c.drawString ("MONOPOLY", 146, 900 - x);
	    c.setColor (Color.white);
	    c.drawString ("MONOPOLY", 150, 897 - x);
	    try
	    {
		sleep (1);
	    }
	    catch (Exception e)
	    {
	    }

	}

	for (int x = 0 ; x < 500 ; x++)
	{
	    c.setColor (boardBG);
	    c.fillRect (-400 + x, 377, 350, 390);

	    c.setColor (skin);
	    c.fillRoundRect (-360 + x, 505, 45, 33, 10, 10);
	    c.fillOval (-335 + x, 490, 15, 30);

	    c.fillRoundRect (-60 + x, 505, 45, 33, 10, 10);
	    c.fillOval (-60 + x, 490, 15, 30);

	    c.setColor (Color.white);
	    c.fillRect (-320 + x, 505, 260, 30);

	    c.setColor (Color.black);
	    c.fillOval (-250 + x, 430, 120, 40);
	    c.fillRoundRect (-235 + x, 377, 90, 80, 25, 25);
	    c.fillRect (-310 + x, 500, 240, 40);
	    c.setColor (Color.gray);
	    c.fillRect (-240 + x, 610, 100, 30);
	    c.fillRect (-240 + x, 610, 45, 120);
	    c.fillRect (-185 + x, 610, 45, 120);

	    c.setColor (Color.white);
	    c.fillRect (-230 + x, 520, 80, 90);
	    c.setColor (Color.black);
	    c.fillArc (-170 + x, 500, 70, 130, 90, 180);
	    c.fillArc (-280 + x, 500, 70, 130, -90, 180);

	    c.setColor (red);
	    int xpoint[] = { - 191 + x, -210 + x, -210 + x, -191 + x, -172 + x, -172 + x};
	    int ypoint[] = {530, 520, 540, 530, 520, 540};
	    int npoint = 6;
	    c.fillPolygon (xpoint, ypoint, npoint);
	    c.setColor (Color.black);
	    c.fillRoundRect (-275 + x, 727, 85, 30, 25, 20);
	    c.fillRoundRect (-188 + x, 727, 85, 30, 20, 20);

	    c.setColor (skin);
	    c.fillOval (-236 + x, 449, 85, 80);
	    c.setColor (Color.black);
	    c.fillOval (-213 + x, 476, 8, 8);
	    c.fillOval (-183 + x, 476, 8, 8);
	    c.fillOval (-198 + x, 505, 10, 10);
	    c.setColor (Color.white);
	    c.fillOval (-221 + x, 497, 30, 15);
	    c.fillOval (-196 + x, 497, 30, 15);
	    c.setColor (Color.black);
	    c.drawArc (-202 + x, 490, 15, 10, 0, -180);
	    c.drawArc (-218 + x, 460, 15, 10, 40, 180);
	    c.drawArc (-188 + x, 460, 15, 10, -40, 180);
	    // c.drawLine(270,470,275,472);
	    c.setColor (cane);
	    c.fillRoundRect (-45 + x, 420, 20, 180, 10, 10);
	    c.fillArc (-45 + x, 401, 70, 60, 0, 180);
	    c.setColor (boardBG);
	    c.fillArc (-25 + x, 418, 33, 36, 0, 180);


	    try
	    {
		sleep (1);
	    }
	    catch (Exception e)
	    {
	    }
	}


	for (int i = 1 ; i < 219 ; i++)
	{
	    c.setFont (subTitle);

	    c.setColor (new Color (233 - i, 229 - i, 218 - i));
	    c.drawString ("MINI EDITION", 600, 430);
	    try
	    {
		Thread.sleep (4);
	    }
	    catch (Exception e)
	    {
	    }
	}
	
	try
	{
	    Thread.sleep (2500);
	}
	catch (Exception e)
	{
	}
    }


    //constructor
    public SplashScreen (Console con)
    {
	c = con;
    }


    //runs the text method
    public void run ()
    {
	splashScreen ();

    }
}
