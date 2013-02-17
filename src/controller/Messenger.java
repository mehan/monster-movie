
package controller;

import mpe.client.*;
import processing.core.*;

import oscP5.*;
import netP5.*;

public class Messenger extends PApplet {


	// --------------------------------------
	AsyncClient client;
	PFont font;

	boolean message = true;
	
	int b1, bA;
	int wormjx1, wormjy1, wormb1, wormb2, wormb3, wormA;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
	int  leg1, leg2, leg3, leg4, sA;
	
	int ufoUp, ufoAlpha;
	
	int arm1;
	int arm2;
	int arm3;
	int head;
	int oAlpha;
	int neck1;
	int neck2;
	int head1;
	
	

	
	// --------------------------------------
	public void setup() {
		// set up the client
		// For testing locally
		client = new AsyncClient("localhost",9003);
		client.DEBUG = false;

		// At NYU
//		client = new AsyncClient("128.122.151.65", 9003);
//		client.DEBUG = false;

		// At IAC
		//client = new AsyncClient("192.168.130.241",9003);

		OscP5 oscP5;
	  //NetAddress myRemoteLocation;

		size(600,240);
		frameRate(30);
		smooth();
		// b = loadImage("background_3840.png");

		oscP5 = new OscP5(this, 12000);
		//myRemoteLocation = new NetAddress("127.0.0.1", 12000);
		  
		 //buildings
		  oscP5.plug(this, "building1", "/b1");
		  oscP5.plug(this, "buildingA", "/bA");
		
		  //worm
		  oscP5.plug(this, "worm1", "/wr1");
		  oscP5.plug(this, "worm2", "/wr2");
		  oscP5.plug(this, "worm3", "/wr3");
		  oscP5.plug(this, "worm4", "/wr4");
		  oscP5.plug(this, "worm5", "/wr5");
		  oscP5.plug(this, "wormA", "/wrA");
		  
		  //squid 1
		  oscP5.plug(this, "squid1", "/s1");
		  oscP5.plug(this, "squid2", "/s2");
		  oscP5.plug(this, "squid3", "/s3");
		  oscP5.plug(this, "squid4", "/s4");
		  oscP5.plug(this, "squidA", "/sA");
	
		  //UFOs
		  oscP5.plug(this, "ufo1", "/u1");
		  oscP5.plug(this, "ufoA", "/uA");
		  
		  //squid 2
		  oscP5.plug(this, "octu1", "/o1");
		  oscP5.plug(this, "octu2", "/o2");
		  oscP5.plug(this, "octu3", "/o3");
		  oscP5.plug(this, "octu4", "/o4");
		  oscP5.plug(this, "octuA", "/oA");
		  
		  
		  
		
		font = createFont("Arial",12,true);

	}

	// --------------------------------------
	public void draw() {
		background(255);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
		String msg = b1+ "," +bA+"," +wormjx1+ "," +wormjy1+ "," +wormb1+ "," +wormb2+ "," +wormb3+ 
		"," +wormA+ "," +leg1+ "," +leg2+ "," +leg3+ "," +leg4+ "," +sA+ "," +ufoUp+ "," +ufoAlpha+ "," +arm1+ "," +arm2+ "," +arm3+ 
		"," +head+ "," +oAlpha;
		client.broadcast(msg);
		textFont(font);
		fill(0);
//		text("testing",25,height/2);
		text("Broadcasting: " + msg, 25, height / 2);
	}

	// --------------------------------------
	static public void main(String args[]) {
		PApplet.main(new String[] { "controller.Messenger" });
	}
	
	public void building1(int building1) {
		b1 = building1;
	}

	public void buildingA(int buildingA) {
		bA = buildingA;

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????	
	public void worm1(int worm1) {
		  wormjx1 = worm1;
		}
	public void worm2(int worm2) {
		  wormjy1 = worm2;
		}
	public void worm3(int worm3) {
		  wormb1 = worm3;
		}
	public void worm4(int worm4) {
		  wormb2 = worm4;
		}
	public void worm5(int worm5) {
		  wormb3 = worm5;
		}
	public void worm6(int worm6) {
		  wormA = worm6;
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////?????????
		public void squid1(int squid1) {
			  leg1 = squid1;
		}
		public void squid2(int squid2) {
			  leg2 = squid2;
			}
		public void squid3(int squid3) {
			  leg3 = squid3;
			}
		public void squid4(int squid4) {
			  leg4 = squid4;
			}
		public void squid5(int squid5) {
			  sA = squid5;
			}
		// UFO ===================================== 
		public void ufo1(int ufo1) {
		  ufoUp = ufo1;
		}

	
		public void ufoA(int ufoA) {
		   ufoAlpha = ufoA;
		}
		
		public void octu1(int octu1) {
		 arm1 = octu1;
		}
		public void octu2(int octu2) {
		  arm2 = octu2;
		}
		public void octu3(int octu3) {
		  arm3 = octu3;
		}
		public void octu4(int octu4) {
			  head = octu4;
			}
		
		public void octuA(int octuA) {
			  oAlpha = octuA;
			}
		
		
		
}
