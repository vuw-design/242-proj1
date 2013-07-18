import processing.core.*;
import ddf.minim.*;

public class SoundFaceUtil {
	private static PApplet parent;
	private static SoundFaceUtil util;

	private Minim minim;
	private AudioInput in;
	private float s_volume;
	private float volume;
	private float gainEasing;
	private float gain;


	static SoundFaceUtil setup(PApplet pa) {
		if( SoundFaceUtil.parent == null ) {
			SoundFaceUtil.parent = pa;
		}

		if(util == null ) {
			util = new SoundFaceUtil();
		}		
		return util;
	}

	 /**
	 *	@param g this controls the loudness of your music; the higher the number the louder the volume
	 *  
	 */
	public void setGain(float g) {
		gain = g;
	}

	/**
	 *	@param g a number between 0 and 1; the higher the number the more sharp changes in volume will be. The smaller the nummber
	 *  the smoother the changes in volume.
	 */
	public void setGainEasing(float g) {
		gainEasing = g;
	}


	public float getVolume() {
	  s_volume = in.right.level() * gain;

	  float d_volume = s_volume - volume;

	  if (parent.abs(d_volume) > 1) {
	    volume += d_volume * gainEasing;
	  }
	  
	  return volume;
	}


	private SoundFaceUtil() {
		minim = new Minim(parent);
  		in = minim.getLineIn(Minim.MONO, 512);
		gain = 100.0f;
		gainEasing = 1.0f;		
	}



	public void stop() {
	  in.close();
	  minim.stop();
	}	

}