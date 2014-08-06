package com.example.xonlinepremium.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class AnimationHandler {
	
	//class Declaration
	private Animation MainAnimation;
	private Context context;
	private AttributeSet atts;
	
	public AnimationHandler(Context context, AttributeSet atts){
		this.context = context;
		this.atts = atts;
		
	}
	
	
	/*
	 * TODO
	*  FadeIn Animations 
	*/
	public Animation fadeInAnimation(int Seconds)
	{	
		
		Animation FADEIN;
		
		MainAnimation = new AlphaAnimation(0.0f, 1.0f);
		MainAnimation.setDuration(Seconds);
		MainAnimation.setFillBefore(true);
		MainAnimation.setFillAfter(true);
		
		FADEIN = MainAnimation;
		
		ResetMainAnimation();
		return FADEIN;
	}	
	
	public Animation fadeOutAnimation(int Seconds)
	{	
		
		Animation FADEout;
		
		MainAnimation = new AlphaAnimation(1.0f, 0.0f);
		MainAnimation.setDuration(Seconds);
		MainAnimation.setFillBefore(true);
		MainAnimation.setFillAfter(true);
		
		FADEout = MainAnimation;
		
		ResetMainAnimation();
		return FADEout;
		
	}
	
	/*
	 * TODO
	*  other Animations 
	*/
	
	
	/*
	 * TODO
	*  Settings for Animation
	*/
	private void ResetMainAnimation()
	{	
		
		MainAnimation = null;
		
		MainAnimation = new Animation(context, atts) 
		{
			
		};
	}
	
	
}
