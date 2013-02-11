//* Simple Template for the Big Screens Class, Fall 2011
// * <https://github.com/shiffman/Most-Pixels-Ever>
// * 
// * Note this project uses Processing 1.5.1
// */

package mpe.examples;

import mpe.client.*;
import processing.core.*;
import processing.opengl.*;
import animata.AnimataP5;

public class DrawerTest2 extends PApplet {

	// Set it to 1 for actual size, 0.5 for half size, etc.
	// This is useful for testing MPE locally and scaling it down to fit to your
	// screen
	public static float scale = 0.1f;

	// if this is true, it will use the MPE library, otherwise just run
	// stand-alone
	public static boolean MPE = false;
	public static boolean local = true;

	// Client ID
	// Should be adjusted only for "local" testing
	// --------------------------------------
	int ID = 0;

	TCPClient client;

	// These we'll use for master width and height instead of Processing's
	// built-in variables
	int mWidth;
	int mHeight;

	// //////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////
	// ////////////////////////TONY & MEHAN'S CODE///////////////////////
	// //////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////

	PImage b;

	int[] xpos = new int[16];
	int[] ypos = new int[16];
	PImage img;

	int numSprings = 30;
	Spring2D[] s = new Spring2D[numSprings];
	float gravity = 5.0f;
	float mass = 3.0f;


	AnimataP5 armA, armB, armC, armD, armE, armF;
	int lip1jx;
	int lip1jy;
	int eye1b;

	int hand1jx;
	int hand1jy;

	int fishjx1=1600;
	int fishjy1= 700;
	int fishjx2=2200;
	int fishjy2=700;

	int tonyjx1 = 1040;
	int tonyjy1 = 1030;
	int tonyjx2 = 1050;
	int tonyjy2 = 450;

	int boopjx1 = 1040;
	int boopjy1 = 1030;
	int boopjx2 = 1050;
	int boopjy2 = 450;

	// --------------------------------------
	static public void main(String args[]) {
		// Windowed
		if (local) {
			PApplet.main(new String[] { "mpe.examples.DrawerTest2" });
			// FullScreen Exclusive Mode
		} else {
			PApplet.main(new String[] { "--present", "--exclusive",
			"mpe.examples.DrawerTest2" });
		}
	}

	// --------------------------------------
	public void setup() {

		// If we are using the library set everything up
		if (MPE) {
			// make a new Client using an INI file
			// sketchPath() is used so that the INI file is local to the sketch
			String path = "mpefiles/";
			if (local) {
				path += "local/mpe" + ID + ".ini";
			} else {
				ID = IDGetter.getID();
				path += "6screens/mpe" + ID + ".ini";
			}
			client = new TCPClient(path, this);
			// Not rendering with OPENGL for local testing
			if (local) {
				println("moo");
				size((int) (client.getLWidth() * scale),
						(int) (client.getLHeight() * scale), OPENGL);
				
/***********************************************************************/				
				
				/*client.setLocalDimensions(
						(int) (ID * client.getLWidth() * scale), 0,
						(int) (client.getLWidth() * scale),
						(int) (client.getLHeight() * scale));*/
			} else {

				size(client.getLWidth(), client.getLHeight(), OPENGL);
			}
			// the size is determined by the client's local width and height
			mWidth = client.getMWidth();
			mHeight = client.getMHeight();

		} else {
			// Otherwise with no library, force size

			size(parseInt(11520 * scale), parseInt(1080 * scale),OPENGL);
			mWidth = 11520;
			mHeight = 1080;
		}

		if (MPE) {
			// IMPORTANT, YOU MUST START THE CLIENT!
			client.start();
		}

		//////////////////////////////////////////////////
		//////////////////////////////////////////////////
		///////////////////////SETUP//////////////////////
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////

		armA = new AnimataP5(this, "bathWoman.nmt");

		img = loadImage("fist.png");
		for (int i = 0; i < xpos.length; i++) {
			xpos[i] = 0;
			ypos[i] = 0;

			fill(0);
			for (int t = 0; t < numSprings; t++) {
				s[t] = new Spring2D(this, width / 2, t * (height / numSprings),
						mass, gravity);
			}
		}
		println(g.is3D());
	}

	// --------------------------------------
	// Keep the motor running... draw() needs to be added in auto mode, even if
	// it is empty to keep things rolling.
	public void draw() {

		// If we are on the 6 screens we want to preset the frame's location
		if (MPE && local) {
			frame.setLocation(ID * width, 0);
		}

		// If we're not using the library frameEvent() will not be called
		// automatically
		if (!MPE) {
			frameEvent(null);
		}
	}

	// --------------------------------------
	// Triggered by the client whenever a new frame should be rendered.
	// All synchronized drawing should be done here when in auto mode.
	public void frameEvent(TCPClient c) {


		// Receiving a message for background color
		if (MPE && c.messageAvailable()) {
			String[] msg = c.getDataMessage();
			println("tonton" + lip1jx);

			// ///////////////////////////////////////////////
			// ///////////////////////////////////////////////
			// //////////////PARSE OSC MSGS///////////////////
			// ///////////////////////////////////////////////
			// ///////////////////////////////////////////////

			String[] input = msg[0].split(",");
			//			println(msg);

			lip1jx = parseInt(input[0]);
			//			print("lip1jx: ");
			//			println(lip1jx);
			//			lip1jy = parseInt(input[1]);

			//			eye1b = parseInt(input([2]);
			//			hand1jx = parseInt(input[3]);


		}
/*****************************************************************/
		// clear the screen
		if (!MPE && local) {
			scale(scale);
		}

		// ///////////////////////////////////////////////
		// ///////////////////////////////////////////////
		// /////////////////////DRAW//////////////////////
		// ///////////////////////////////////////////////
		// ///////////////////////////////////////////////
		//  image(b, 0, 0);
		background(255);

		fill(0,0,255);
		rect(frameCount,height/2,100,50);

		armA.moveJointX("lip1", lip1jx);

		armA.moveJointY("lip1", lip1jy); // set y-coordinate of joint "poignee" to 500
		armA.setBoneTempo("eye1", .5f); // set tempo of bone "coude" to .5
		armA.setBoneRange("eye1", .1f, (eye1b/127.0f)); // set the range of bone "coude" between .2 and .6
		armA.setLayerAlpha("bathWoman", 0.7f); // set the alpha value of the layer "arm" to 120 (0=transparent/255=opaque)
		armA.setLayerScale("bathWoman", .6f); // set the scale of the layer "arm" to .6 (in this case, default is 0.5)
		armA.setLayerPos("bathWoman", 0, 70); // set the position of layer "arm" to (0,70)


		armA.draw(100, -50); // draw scene translated of (10,30)
		
		
		armA.draw(5000, -50); // draw scene translated of (10,30)

		armA.draw(9500, -50); // draw scene translated of (10,30)

		
	}
}
