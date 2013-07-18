import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class your_name extends PApplet {

/*
	Example demonstrating the use of the 
		SoundFace Utility

	prof. rhazes spell, 
	victoria university of wellingtion
	school of design
	2013
*/


SoundFaceUtil util;

public void setup(){
	size(512,512);
	util = SoundFaceUtil.setup(this);	

	// use this to scale the input Volume up. (the input values are between [0,1] )
	util.setGain(height * 5.0f);
	// use this to smooth the transition between different volume reads. 
	// (acceptable values between [0,1] - the lower the value the smoother the transition )
	util.setGainEasing(0.05f);
}

public void draw(){
	background(0);
	strokeWeight(5);
	stroke(255,0,0);

	//draw a line that gets taller the louder the volume )
	line(width/2, height, width/2, height - util.getVolume());
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "your_name" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
