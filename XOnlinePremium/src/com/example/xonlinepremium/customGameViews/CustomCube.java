package com.example.xonlinepremium.customGameViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xonlinepremium.R;

public class CustomCube extends LinearLayout {

	private Context context;
	private LinearLayout layout;
	private char player;
	private int id;
	Animation FadeInAnimation;
	Animation FadeOutAnimation;

	public CustomCube(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflator.inflate(R.layout.custom_cube, this);
		this.context = context;
		// TODO Auto-generated constructor stub
		init();

	}

	public void init() {
		layout = (LinearLayout) findViewById(R.id.cubeLinearLayout);
		layout.setBackgroundResource(R.drawable.empty_player_image);
		player = 'e';
	}

	public void SetPlayer(boolean X) {

		if (X == true) {
			layout.setBackgroundResource(R.drawable.x_player_image);
			player = 'x';
		}
		if (X == false) {
			layout.setBackgroundResource(R.drawable.o_player_image);
			player = 'o';
		}

	}

	public char getPlayer() {

		return player;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return id;
	}

	public void playAnimation(boolean player)
	{
		
		if (player == true)
		{
			layout.setBackgroundResource(R.drawable.x_player_image);
			
			
		}
		if (player == false)
		{
			layout.setBackgroundResource(R.drawable.o_player_image);
		}
		
	}

}
