package com.example.xonlinepremium;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xonlinepremium.customGameViews.CustomViewOfBoard;

public class GameActivity extends Activity {

	Button TieBtn;
	Button SoundBtn;
	TextView TvScoreX;
	TextView TvScoreO;

	FrameLayout gameLayout;
	CustomViewOfBoard Board;

	boolean tieIsOn = true;
	boolean soundIsOn = true;
	public static boolean humanPlayer;

	class MainButtonsClick {

		Animation FadeInAnimatio;
		Animation FadeOutAnimatio;

		public MainButtonsClick() {

			TieBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					initAnimations();
					tieIsOn = !tieIsOn;
					TieClick();
				}

			});

			SoundBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					initAnimations();
					soundIsOn = !soundIsOn;
					SoundClick();
				}
			});
		}

		private void initAnimations() {
			FadeInAnimatio = new AlphaAnimation(0, 100);
			FadeInAnimatio.setDuration(1500);
			FadeInAnimatio.setFillBefore(true);
			FadeInAnimatio.setFillAfter(false);

			FadeOutAnimatio = new AlphaAnimation(100, 0);
			FadeOutAnimatio.setDuration(1000);
			FadeOutAnimatio.setFillBefore(true);
			FadeOutAnimatio.setFillAfter(false);

		}

		private void TieClick() {
			if (tieIsOn == true) {
				TieBtn.startAnimation(FadeOutAnimatio);
				TieBtn.setBackgroundResource(R.drawable.tie_on_btn_image);
				TieBtn.startAnimation(FadeInAnimatio);
				Board.setTie(true);
			}
			if (tieIsOn == false) {
				TieBtn.startAnimation(FadeOutAnimatio);
				TieBtn.setBackgroundResource(R.drawable.tie_off_btn_image);
				TieBtn.startAnimation(FadeInAnimatio);
				Board.setTie(false);
			}
		}

		private void SoundClick() {

			if (soundIsOn == true) {
				SoundBtn.startAnimation(FadeOutAnimatio);
				SoundBtn.setBackgroundResource(R.drawable.sound_on_btn_image);
				SoundBtn.startAnimation(FadeInAnimatio);
				// Board.setPlayer(true);

			}
			if (soundIsOn == false) {
				SoundBtn.startAnimation(FadeOutAnimatio);
				SoundBtn.setBackgroundResource(R.drawable.sound_off_btn_image);
				SoundBtn.startAnimation(FadeInAnimatio);
				// Board.setPlayer(false);

			}
		}
	}

	MainButtonsClick BtnEnebts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TieBtn = (Button) findViewById(R.id.button1);
		SoundBtn = (Button) findViewById(R.id.button2);
		gameLayout = (FrameLayout) findViewById(R.id.frameGameLayout);
		Board = new CustomViewOfBoard(this, null);
		initThisClass();
		BtnEnebts = new MainButtonsClick();

	}

	private void initThisClass() {

		TieBtn.setBackgroundResource(R.drawable.tie_on_btn_image);
		SoundBtn.setBackgroundResource(R.drawable.sound_on_btn_image);
		gameLayout.removeAllViews();
		Board = new CustomViewOfBoard(this, null);
		gameLayout.addView(Board);

	}
	
	

}
