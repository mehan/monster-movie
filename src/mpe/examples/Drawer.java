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

public class Drawer extends PApplet {

	// Set it to 1 for actual size, 0.5 for half size, etc.
	// This is useful for testing MPE locally and scaling it down to fit to your
	// screen
	public static float scale = .5f;

	// if this is true, it will use the MPE library, otherwise just run
	// stand-alone
	public static boolean MPE = true;
	public static boolean local = true;

	// Client ID
	// Should be adjusted only for "local" testing
	// --------------------------------------
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
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

	public static PImage bg0;
	public static PImage bg1;
	public static PImage bg2;
    PImage b;
//	int[] xpos = new int[16];
//	int[] ypos = new int[16];
	PImage img;



	AnimataP5 squid, buildings, ufo, octu, armH ;
	AnimataP5 armA ;
	AnimataP5 armB ;
	AnimataP5 body1 ;
	AnimataP5 body2 ;
	AnimataP5 body3 ;



	AnimataP5 neck1 ;
	AnimataP5 neck2 ;
	AnimataP5 head1 ;
	
	AnimataP5 armRight ;
	AnimataP5 armRight2 ;
	AnimataP5 armRight3 ;
	AnimataP5 armLeft ;
	AnimataP5 armLeft2 ;
	AnimataP5 armLeft3 ;

	AnimataP5 Sbody1 ;
	AnimataP5 Sbody2 ;
	AnimataP5 Sbody3 ;
	
	float vol;
//	float i;
	Neck1[] neckA1 = new Neck1[40];
	float movex2, movey2 ;
	boolean toggle2x, toggle2y;
	int t3=0, t4;
	int moveX = 0;
	int moveY = 0;

	//worm
	int b1;
	int bA;
	int wormjx1 = 1297;
	int wormjy1 = 489;
	float wormb1;
	float wormb2;
	float wormb3;
	float wormA;


// squid 1 + legs	

	int leg1;
	int leg2;
	int leg3;
	int leg4;
	int sAlpha = 0;

//buildings
	int building1, buildingA;
	int buildingx, buildingy;


//UFOs
	int ufoUp;
	int ufoAlpha = 0;

//octupus + legs
	int arm1;
	int arm2;
	int arm3;
	int head;
	int oAlpha = 0;
/////////////////////dancer/////
	Centi[] centi = new Centi[26];

	Centitwo[] centitwo = new Centitwo[26];

	float movex, movey ;
	

	boolean togglex, toggley;
	int t=0, t2;
	////////////////////////////////////////Spider/////
	float Smovex , Smovey ;
	boolean Stogglex, Stoggley;
	int St=0, St2;
	Spide leftarm;
	float Svol;

	// --------------------------------------
	static public void main(String args[]) {
		// Windowed
		if (local) {
			PApplet.main(new String[] { "mpe.examples.Drawer" });
			// FullScreen Exclusive Mode
		} else {
			// PApplet.main(new String[] { "--present", "--exclusive","mpe.examples.Drawer" });
			PApplet.main(new String[] {"mpe.examples.Drawer"});
		}
	}


	public void init(){
//RE-ADD THIS STUFF
		frame.removeNotify();
		frame.setUndecorated(true);
		frame.addNotify();
		super.init();
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



		//////////////////////////////////////////////////
		//////////////////////////////////////////////////
		///////////////////////SETUP//////////////////////
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////


		  armH = new AnimataP5(this, "worm4.nmt");
		  squid = new AnimataP5(this, "squidfinal.nmt");
		  ufo = new AnimataP5(this, "ufo.nmt");
		  octu = new AnimataP5(this, "octu4.nmt");
		  buildings= new AnimataP5(this, "buildings.nmt");

		  movex= width/2 ; 
		  movey= height/2;
		  armA = new AnimataP5(this, "arm1.nmt");
		  armB = new AnimataP5(this, "arm1.nmt");
		  body1 = new AnimataP5(this, "body1.nmt");
		  body2 = new AnimataP5(this, "body2.nmt");
		  body3 = new AnimataP5(this, "body1.nmt");

		  for (int i = 0; i < centi.length; i ++ ) {   
			    centi[i] = new Centi();
			  }  

			  for (int i = 0; i < centitwo.length; i ++ ) {   
			    centitwo[i] = new Centitwo();
			  } 

		  bg0 = loadImage("background_1.1.png");
		  bg1 = loadImage("background_1.1.png");
		  bg2 = loadImage("background_1.1.png");
		  /////////////////////////////////////////DragonWorm///
		  movex2= mWidth/2+300 ; 
		  movey2= mHeight/2;
		  
		  

		  neck1 = new AnimataP5(this, "snakeNeck.nmt");

		  head1 = new AnimataP5(this, "snakeHead.nmt");



		  for (int i = 0; i < neckA1.length; i ++ ) {   
		    neckA1[i] = new Neck1();
		  }  
		  
		  
		  ////////////Spider////////////////////////////
		  
		  Smovex= mWidth/3 ; 
		  Smovey= mHeight/3;
		  armRight = new AnimataP5(this,"forearm_right4.nmt");
		  armRight2 = new AnimataP5(this,"forearm_right4.nmt");
		    armRight3 = new AnimataP5(this,"forearm_right4.nmt");
		  armLeft= new AnimataP5(this,"forearm_left3.nmt");
		  armLeft2= new AnimataP5(this,"forearm_left3.nmt");
		  armLeft3= new AnimataP5(this,"forearm_left3.nmt");
		  

		   Sbody2 = new AnimataP5(this,"spiderbody1.nmt");

		 
		   leftarm = new Spide(); 
	
		  





		if (MPE) {
			// IMPORTANT, YOU MUST START THE CLIENT!
			client.start();
		}
	}

	// --------------------------------------
	// Keep the motor running... draw() needs to be added in auto mode, even if
	// it is empty to keep things rolling.
	public void draw() {
		frame.setLocation(0,0);

		// If we are on the 6 screens we want to preset the frame's location
		if (MPE && local) {
			//frame.setLocation(ID * width, 0);
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

		String show = "";

		// Receiving a message for background color
		if (MPE && c.messageAvailable()) {
			String[] msg = c.getDataMessage();

			// //////////////PARSE OSC MSGS///////////////////


			println("MESSAGE RECEIVED: " + msg[0]);
			show = "MESSAGE RECEIVED: " + msg[0];
			String[] input = msg[0].split(",");
			show += "\n total values: " + input.length;
			if (input.length > 1) {

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
				int tempx = parseInt(input[0]);
				if (tempx != 0) b1 = tempx;

				 tempx = parseInt(input[1]);
				if (tempx != 0) bA = tempx;

		         tempx = parseInt(input[2]);
				if (tempx != 0) wormjx1 = tempx;

				 tempx = parseInt(input[3]);
				if (tempx != 0) wormjy1 = tempx;

				 tempx = parseInt(input[4]);
				if (tempx != 0) wormb1 = tempx;

				int tempy = parseInt(input[5]);
				if (tempy != 0) wormb2 = tempy;


				 tempx = parseInt(input[6]);
				if (tempx != 0) wormb3 = tempx;

				 tempx = parseInt(input[7]);
				if (tempx != 0) wormA = tempx;

				 tempx = parseInt(input[8]);
				if (tempx != 0) leg1 = tempx;

				 tempx = parseInt(input[9]);
				if (tempx != 0) leg2 = tempx;

				 tempx = parseInt(input[10]);
				if (tempx != 0) leg3 = tempx;

				 tempx = parseInt(input[11]);
				if (tempx != 0) leg4 = tempx;

				 tempx = parseInt(input[12]);
				if (tempx != 0) sAlpha = tempx;

				tempx = parseInt(input[13]);
				if (tempx != 0) ufoUp = tempx;

				tempx = parseInt(input[14]);
				if (tempx != 0) ufoAlpha = tempx;

				tempx = parseInt(input[15]);
				if (tempx != 0) arm1 = tempx;

				tempx = parseInt(input[16]);
				if (tempx != 0) arm2 = tempx;

				tempx = parseInt(input[17]);
				if (tempx != 0) arm3 = tempx;

				tempx = parseInt(input[18]);
				if (tempx != 0) head = tempx;

				tempx = parseInt(input[19]);
				if (tempx != 0) oAlpha = tempx;


			}
		}

		// clear the screen
		if (!MPE || local) {
			scale(scale);
		}

		// ///////////////////////////////////////////////
		// ///////////////////////////////////////////////
		// ///////////////////// //////////////////////
		// ///////////////////////////////////////////////


//		if (ID == 0)
			image(bg0,0,0);
//		if (ID == 1)
			image(bg1,3840,0);
//		if (ID == 2)
			image(bg2,3840*2,0);




          //worm
		  armH.moveJointX("backbone", wormjx1); // set x-coordinate of joint "poignee" to 10
		  armH.moveJointY("backbone", wormjy1); // set y-coordinate of joint "poignee" to 500
		  armH.setBoneTempo("righteye", .5f); // set tempo of bone "coude" to .5
		  armH.setBoneTempo("lefteye", .7f); // set tempo of bone "coude" to .5
		  armH.setBoneTempo("teeth", .3f); // set tempo of bone "coude" to .5
		  armH.setBoneRange("worm", .1f, .8f); // set the range of bone "coude" between .2 and .6
		  armH.setLayerAlpha("worm", wormA); // set the alpha value of the layer "arm" to 120 (0=transparent/255=opaque)
		  armH.setLayerScale("worm", 1f); // set the scale of the layer "arm" to .6 (in this case, default is 0.5)
		  armH.setLayerPos("worm", 0, 0); // set the position of layer "arm" to (0,70)

		  //squid

		  squid.moveJointY("leg1", leg1);
		  squid.moveJointY("leg2", leg2);
		  squid.moveJointX("leg3", leg3);
		  squid.moveJointX("leg4", leg4);
		  squid.setBoneRange("coude", .2f, .6f);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
		  squid.setLayerAlpha("squid", 20);
		  squid.setLayerScale("squid", .9f); 

		  //octopus

		  octu.moveJointY("arm1", arm1);
		  octu.moveJointY("arm2", arm2);
		  octu.moveJointX("arm3", arm3);
		  octu.moveJointY("head", head);
		  octu.setLayerScale("octu", .4f); 


          //UFO
		  ufo.setLayerPos("ufo", 0, 0f); 
		  ufo.setLayerScale("ufo", 0.7f); 


          //buildings
		  buildings.setLayerAlpha("buildings", 0f);
		  buildings.setLayerScale("buildings", .7f);


  //dancer/////////////////////////

		  body2.setBoneTempo("body2bone1", 0.001f*leg1); 
		  body2.setBoneRange("body2bone1", 1.3f, 2.3f); 
//dancerXY///

		  movex+= leg1*.0001 ;
		  float xpos = noise(movex) * width;
		  movey+= leg2*.0001 ;
		  float ypos = noise(movey) * height+sAlpha*5; 
		  if (centi[0].x-centi[1].x>0 ) {    
		    togglex=true;
		    t=1;
		  }
		  if (centi[0].x-centi[1].x<0 ) {    
		    togglex=false;
		    t=0;
		  }
		  if (centi[0].x-centi[1].x==0 && t==1) {
		    togglex=true;
		  }
		  if (centi[0].x-centi[1].x==0 && t==0) {
		    togglex=false;
		  }

		  if (centi[0].y-centi[1].y>0) { 
		    toggley=true;
		    t2=1;
		  }
		  if (centi[0].y-centi[1].y<0 ) {    
		    toggley=false;
		    t2=0;
		  }
		  if (centi[0].y-centi[1].y==0 && t2==1) {
		    toggley=true;
		  }
		  if (centi[0].y-centi[1].y==0 && t2==0) {
		    toggley=false;
		  } 

		  body1.setBoneTempo("body1bone1", 0.07f); 
		  body1.setBoneRange("body1bone1", 0.3f, 2.5f); 
		  
		  
		  
		  //////////////////////////snakeXY//////
		  //////main XY control for snake////
		  
		  movex2+= vol*.01 ;
		  
		  float xpos2 = noise(movex2) * width+leg2;
		
		  movey2+= vol*.01 ;
		  float ypos2 = noise(movey2) * height+leg1-500; 



		  if (neckA1[0].x-neckA1[1].x>0 ) {    
		    toggle2x=true;
		    t3=1;
		  }
		  if (neckA1[0].x-neckA1[1].x<0 ) {    
		    toggle2x=false;
		    t3=0;
		  }
		  if (neckA1[0].x-neckA1[1].x==0 && t3==1) {
		    toggle2x=true;
		  }
		  if (neckA1[0].x-neckA1[1].x==0 && t3==0) {
		    toggle2x=false;
		  }

		  ///////

		  if (neckA1[0].y-neckA1[1].y>0) { 
		    toggle2y=true;
		    t4=1;
		  }
		  if (neckA1[0].y-neckA1[1].y<0 ) {    
		    toggle2y=false;
		    t4=0;
		  }
		  if (neckA1[0].y-neckA1[1].y==0 && t4==1) {
		    toggle2y=true;
		  }
		  if (neckA1[0].y-neckA1[1].y==0 && t4==0) {
		    toggle2y=false;
		  } 


		  neckA1[0].offsetx= xpos2-8;
		  neckA1[0].offsety= ypos2-5;





		  //***DRAWING ON SCREEN***



		

//		  armH.draw(9500-moveX, -200);
		  armH.draw(16000-moveX, -200);

		  buildings.draw(300+buildingx+moveX, 1270+buildingy-sAlpha*3); 
		  buildings.draw(3300+buildingx+moveX, 1270+buildingy-sAlpha*4); 
		  buildings.draw(5300+buildingx+moveX, 1270+buildingy-sAlpha*5); 


//		  squid.draw(leg4+1000+moveX, 600);
		  squid.draw(-1000+moveX+leg2, 600);
		  buildings.draw(1500+buildingx, 600+buildingy); 



		  buildings.draw(6700+buildingx, 600+buildingy);
		  buildings.draw(8700+buildingx, 600+buildingy);
		  buildings.draw(10000+buildingx, 600+buildingy);
///ufodraw
		  ufo.draw(ufoUp+2400, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+3500, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+5000, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+300, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+5000, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+7000, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+8300, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+11000, random(-120, -100)+ufoAlpha*2);
		  ufo.draw(ufoUp+9500, random(-120, -100)+ufoAlpha*2);


//		  octu.draw(7700-moveX, 1300);
		  octu.draw(15000+leg4-moveX, 1300);



		//draw dancing eyeball

		  body1.draw(centi[centi.length-1].x-80, centi[centi.length-1].y-162);  
		  body1.draw(centi[centi.length-1].x+2920, centi[centi.length-1].y-162); 
		  body1.draw(centi[centi.length-1].x+5920, centi[centi.length-1].y-162);

		  body2.draw(centi[0].x-80, centi[0].y-162);  
	      body2.draw(centi[0].x+2920, centi[0].y-162);  
	      body2.draw(centi[0].x+5920, centi[0].y-162);  

		  body3.draw(centitwo[centitwo.length-1].x+130, centitwo[centitwo.length-1].y-130);
	      body3.draw(centitwo[centitwo.length-1].x+3130, centitwo[centitwo.length-1].y-130);
	      body3.draw(centitwo[centitwo.length-1].x+6130, centitwo[centitwo.length-1].y-130);

		    centi[0].offsetx= xpos;
		    centi[0].offsety= ypos;

		    centi[0].display();


		    for (int i = 1; i < centi.length; i ++ ) {   
		      centi[i].offsetx=centi[i-1].x ;
		      centi[i].offsety=centi[i-1].y ;

		      centi[i].display();
		    }


		    /////////centitwo////////

		    centitwo[0].offsetx= xpos;
		    centitwo[0].offsety= ypos;
		    centitwo[0].display();

		    for (int i = 1; i < centitwo.length; i ++ ) {   
		      centitwo[i].offsetx=centitwo[i-1].x+5 ;
		      centitwo[i].offsety=centitwo[i-1].y ;

		      centitwo[i].display();
		    }
		    ////////////////////snake
		    neckA1[0].display();


		    for (int i = 1; i < neckA1.length; i ++ ) {   
		      neckA1[i].offsetx=neckA1[i-1].x-10 ;
		      neckA1[i].offsety=neckA1[i-1].y+10 ;

		      neckA1[i].display();
		    }
//////////////Snakedraw/////////
		    head1.setLayerScale("snakeHead", 1.f);
		   head1.setBoneTempo("body1bone1", 0.07f); 
		   head1.setBoneRange("body1bone1", 0.3f, 2.5f); 
		   head1.draw(neckA1[neckA1.length-1].x+200, neckA1[neckA1.length-1].y+100);
//		   head1.draw(neckA1[neckA1.length-1].x+mouse, neckA1[neckA1.length-1].y+500);
//		   head1.draw(neckA1[neckA1.length-1].x+1280, neckA1[neckA1.length-1].y+750); 

		//////////////////Spider////////
		   leftarm.offset1=Svol;


		   Smovex+= Svol*.01 ;
		   float Sxpos = 300+noise(Smovex) * (width/2);
		   //movey+= Svol*.01 ;
		   float Sypos = 400-noise(Smovex) * (height/2); 
		   println(Svol);
		    

		   leftarm.x= Sxpos;
		   leftarm.y= Sypos;

		   leftarm.display();
		    
		   Sbody2.setBoneTempo("body2bone1", 0.1f*Svol); 
		   Sbody2.setBoneRange("body2bone1",1.3f,2.3f); 
		   Sbody2.draw(leftarm.x-80,leftarm.y-162); 
///////////////////////////////////
		   



///globalmove//////
//FOR LOCAL
		   
		   moveX += 10;
		   
		   
//FOR IAC
//		    moveX +=3.5;
		   
		   


	}





	class Centi{

		  float offset1, offset2 ;
		  float offsetx;
		float offsety;
		float followx, followy;
		  //****NEED TO REPLACE leg1 WITH OUR OWN VARIABLE BELOW***
		float easing = 0.76f*(1-vol);
		float x=width/2; 
		float y=height/2;
		//boolean togglex, toggley;
		//int t=0, t2;
		float body1=5;
		float body2=7 ; 


		 Centi( ) {


		      armA.setBoneTempo("arm1bone1", 0.01f); 
		    armA.setBoneRange("arm1bone1",0.01f,0.1f); 
		 } 


		  void display() {

		  if(togglex==true  )  {

		    x += ((offsetx+random(-body2,-body1)) - x) * easing ; 

		  }


		   if(togglex==false  )  {

		    x += ((offsetx+random(body1,body2)) - x) * easing ; 
		  }

		    if(toggley==true  )  {
		   y += ((offsety+random(-body2,-body1)) - y ) * easing ;
		  }

		      if(toggley==false  )  {
		       y += ((offsety+random(body1,body2)) - y ) * easing ;

		  }


		   armA.draw(x-30,y-40);
		   armA.draw(x+2970, y-40);
		   armA.draw(x+5970, y-40);
		  }

		}


	class Centitwo {

		  float offset1, offset2 ;
		  float offsetx;
		  float offsety;
		  float followx, followy;
		  //****NEED TO REPLACE leg1 WITH OUR OWN VARIABLE BELOW***
		  float easing = 0.76f*(1-vol);
		  float x=width/2; 
		  float y=height/2;
		  float body1=5;
		  float body2=7 ; 


		  Centitwo( ) {


		    armB.setBoneTempo("arm1bone1", 0.01f); 
		    armB.setBoneRange("arm1bone1", 0.01f, 0.1f);
		  } 


		  void display() {


		    if (togglex==true  ) {

		      x += ((offsetx+random(-body2, -body1)) - x) * easing ;
		    }


		    if (togglex==false  ) {

		      x += ((offsetx+random(body1, body2)) - x) * easing ;
		    }

		    if (toggley==true  ) {
		      y += ((offsety+random(-body2, -body1)) - y ) * easing ;
		    }

		    if (toggley==false  ) {
		      y += ((offsety+random(body1, body2)) - y ) * easing ;
		    }


		    armB.draw(x+150, y);
		    
		    armB.draw(x+3150, y);
		    
		    armB.draw(x+6150, y);
		  }
		}
	//////////////snakeclass//////////////////
	class Neck1{
		 
		  float offset1, offset2 ;
		  float offsetx;
		float offsety;
		float followx, followy;
		float easing = 0.76f*(1-vol);
         float x=width/2f; 
		float y=height/2f;
		//boolean togglex, toggley;
		//int t=0, t2;
		float body1=5;
		float body2=7 ; 


		 Neck1( ) {
		      neck1.setBoneTempo("arm1bone1", 0.01f); 
		      neck1.setBoneRange("arm1bone1",0.01f,0.1f); 
		   } 
		  void display() {
			  if(toggle2x==true  )  {
				   
				    x += ((offsetx+random(-body2,-body1)) - x) * easing ; 

				  }
				 
				  
				   if(toggle2x==false  )  {
				   
				    x += ((offsetx+random(body1,body2)) - x) * easing ; 
				  }
				  
				    if(toggle2y==true  )  {
				   y += ((offsety+random(-body2,-body1)) - y ) * easing ;
				  }
				  
				      if(toggle2y==false  )  {
				       y += ((offsety+random(body1,body2)) - y ) * easing ;
				       
				  }
				  
				  neck1.setLayerScale("snakeNeck", 1f);
				  //rect(x-10, y-10, 20 ,20);
				   neck1.draw(x,y);
//				   neck1.draw(x+600,y+240);
//				   neck1.draw(x+900,y+490); //relative position for the neck class
				  }
				}
	/////////spiderclass//////////////
	class Spide{
		 
		  float offset1, offset2 ;
		  float offsetx;
		float offsety;
		float followx, followy;
		float easing = 0.76f; //*(1-vol);
		float x=width; 
		float y=height+500;
		//boolean togglex, toggley;
		//int t=0, t2;
		float Sbody1=5;
		float Sbody2=7 ; 


		 Spide( ) {
		     
		 
		    armRight.setBoneRange("rightbone1",0.85f,1.5f); 
		        armRight2.setBoneRange("rightbone1",0.85f,1.4f); 

		    armRight3.setBoneRange("rightbone1",0.85f,1.4f); 
		  
		   // println(offset1);
		    armLeft.setBoneRange("leftbone1",0.40f,1.25f); 
		      armLeft2.setBoneRange("leftbone1",0.40f,1.25f); 
		       armLeft3.setBoneRange("leftbone1",0.60f,1.25f); 
		       
		       


		        
		        

		 } 
		  

		 
		  void display() {

	
		  
		  ///////spidertempo////
			  if (Svol>0.5) {

		       armRight.setBoneTempo("rightbone1", 0.2f);
		      
		       armRight2.setBoneTempo("rightbone1", 0.3f);
		       armRight3.setBoneTempo("rightbone1", 0.34f); 
		       armLeft.setBoneTempo("leftbone1", 0.19f);
		       armLeft2.setBoneTempo("leftbone1", 0.18f);
		       armLeft3.setBoneTempo("leftbone1", 0.28f); 
		  } else{
		    
		           armRight.setBoneTempo("rightbone1", 0.01f);
		       armRight2.setBoneTempo("rightbone1", 0.01f);
		       armRight3.setBoneTempo("rightbone1", 0.01f); 
		       armLeft.setBoneTempo("leftbone1", 0.01f);
		       armLeft2.setBoneTempo("leftbone1", 0.01f);
		       armLeft3.setBoneTempo("leftbone1", 0.01f); 
		  }
			  /////spiderArmDraw///
		  pushMatrix();
		   // rotate(PI*.02);
		    scale(0.95f);
		   armLeft3.draw(x-430,y);
		   popMatrix(); 
		   
		   pushMatrix();  
		   // rotate(PI*.02);
		    scale(0.9f);
		    armLeft2.draw(x-400,y+50);
		    popMatrix();
		    
		    
		    //scale(0.85);
		    armLeft.draw(x-390,y+65);
		    
		    armRight3.draw(x-105,y-156);
		    armRight2.draw(x-65,y-130);  
		    armRight.draw(x-55,y-100); 
		  }
		}
		






}