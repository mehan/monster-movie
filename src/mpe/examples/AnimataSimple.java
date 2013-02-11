package mpe.examples;
import animata.*;
import processing.opengl.*;
import processing.core.*;

public class AnimataSimple extends PApplet {


	AnimataP5 armA,armB;
	float i = 0;

	public void setup() {
		size(400,400,OPENGL);
		frameRate(25);

		armA = new AnimataP5(this,"arm.nmt");
		armB = new AnimataP5(this,"arm.nmt");
	}

	public void draw() {
		//translate(-mouseX,0);

		float s = map(mouseY,0,height,0,2);
		scale(s);

		background(0,0,120);
		armB.moveJointX("poignee",10); // set x-coordinate of joint "poignee" to 10
		armB.moveJointY("poignee",800); // set y-coordinate of joint "poignee" to 500
		println();

		armB.setBoneTempo("coude",i); // set tempo of bone "coude" to .5
		armA.setBoneRange("coude",.2f,.6f); // set the range of bone "coude" between .2 and .6
		armA.setLayerAlpha("arm",20); // set the alpha value of the layer "arm" to 120 (0=transparent/255=opaque)
		armA.setLayerScale("arm",.6f); // set the scale of the layer "arm" to .6 (in this case, default is 0.5)
		armA.setLayerPos("arm",0,70); // set the position of layer "arm" to (0,70)
		armB.draw(10,30); // draw scene translated of (10,30)
		armA.draw(10,30); // draw scene translated of (10,30)



		armB.draw(400,30); // draw scene translated of (10,30)
		armA.draw(400,30); // draw scene translated of (10,30)


	}

	void keypressed() {

		if (key == ' '){
			i = 255;
		}
	}
	
	static public void main(String args[]) {
			PApplet.main(new String[] { "mpe.examples.AnimataSimple" });
	}

}
