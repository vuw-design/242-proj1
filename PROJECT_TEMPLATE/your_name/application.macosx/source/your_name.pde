/*
	Example demonstrating the use of the 
		SoundFace Utility

	prof. rhazes spell, 
	victoria university of wellingtion
	school of design
	2013
*/

import ddf.minim.*;
SoundFaceUtil util;

void setup(){
	size(512,512);
	util = SoundFaceUtil.setup(this);	

	// use this to scale the input Volume up. (the input values are between [0,1] )
	util.setGain(height * 5.0);
	// use this to smooth the transition between different volume reads. 
	// (acceptable values between [0,1] - the lower the value the smoother the transition )
	util.setGainEasing(0.05);
}

void draw(){
	background(0);
	strokeWeight(5);
	stroke(255,0,0);

	//draw a line that gets taller the louder the volume )
	line(width/2, height, width/2, height - util.getVolume());
}
