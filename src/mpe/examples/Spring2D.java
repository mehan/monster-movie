package mpe.examples;
import processing.core.*;

public class Spring2D {
	float vx, vy; // The x- and y-axis velocities
	float x, y; // The x- and y-coordinates
	float gravity;
	float mass;
	float radius = 10;
	float stiffness = 0.2f;
	float damping = 0.7f;
	PImage img;
	PApplet parent;

	Spring2D(PApplet p, float xpos, float ypos, float m, float g) {
		parent = p;
		x = xpos;
		y = ypos;
		mass = m;
		gravity = g;
		img = parent.loadImage("snakeHead.png");
	}

	void update(float targetX, float targetY) {
		float forceX = (targetX - x) * stiffness;
		float ax = forceX / mass;
		vx = damping * (vx + ax);
		x += vx;
		float forceY = (targetY - y) * stiffness;
		forceY += gravity;
		float ay = forceY / mass;
		vy = damping * (vy + ay);
		y += vy;
	}

	void display(float nx, float ny) {
		parent.noStroke();
		parent.ellipse(x, y, radius * 2, radius * 2);
		parent.stroke(255);
		parent.line(x, y, nx, ny);
	}
}