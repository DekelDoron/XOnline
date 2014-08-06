package com.example.xonlinepremium;

import com.example.xonlinepremium.Online.OnlineCustomBoard;
import com.example.xonlinepremium.Online.OnlineGameActivity;
import com.parse.Parse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Animation FadeInAnimatio;
	Animation LeftSideAnimation;
	Animation RightSideAnimation;

	TextView HumanActivityText;
	TextView AndroidActivityText;
	TextView OnlineActivityText;

	ImageView VSImage;
	ImageView XonlineImage;

	private boolean isXplayer;
	private Intent mOnlineIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_to_run);
		HumanActivityText = (TextView) findViewById(R.id.HumanTextView);
		AndroidActivityText = (TextView) findViewById(R.id.AndroidTextView);
		OnlineActivityText = (TextView) findViewById(R.id.OnlineTextView);
		VSImage = (ImageView) findViewById(R.id.VSImage);
		XonlineImage = (ImageView) findViewById(R.id.XOnlineImage);

		Parse.initialize(this, "NWHTeqf2WPzMo17MrBevqYacQcYuw08o6Kd8WcQr",
				"H8aoKoWoaK5UhSuwXgMEFJF6HS4NQ1LmMvxFaIkA");

		startMainAnimation();
		initButtons();

	}

	private void initButtons() {

		HumanActivityText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = null;
				intent = new Intent(MainActivity.this, GameActivity.class);
				GameActivity.humanPlayer = true;
				startActivity(intent);

			}
		});

		AndroidActivityText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = null;
				intent = new Intent(MainActivity.this, GameActivity.class);
				GameActivity.humanPlayer = false;
				startActivity(intent);
			}
		});

		OnlineActivityText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO
				openFragment();

			}
		});

	}

	private void openFragment() {

		mOnlineIntent = new Intent(MainActivity.this, OnlineGameActivity.class);
		GameActivity.humanPlayer = false;

		AlertDialog.Builder alert_box = new AlertDialog.Builder(this);
		alert_box.setMessage("pick player");
		alert_box.setPositiveButton("X", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				OnlineCustomBoard.isXturn = true;
				startActivity(mOnlineIntent);
			}
		});
		alert_box.setNegativeButton("O", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				OnlineCustomBoard.isXturn = false;
				startActivity(mOnlineIntent);
			}
		});

		alert_box.show();

	}

	private void startMainAnimation() {
		HumanActivityText.setAlpha(0);
		AndroidActivityText.setAlpha(0);
		OnlineActivityText.setAlpha(0);

		FadeInAnimatio = new AlphaAnimation(0.0f, 1.0f);
		FadeInAnimatio.setDuration(2000);
		FadeInAnimatio.setFillBefore(false);
		FadeInAnimatio.setFillAfter(true);

		LeftSideAnimation = new TranslateAnimation(-500, 0, 0, 0);
		LeftSideAnimation.setDuration(1500);
		LeftSideAnimation.setFillBefore(true);
		LeftSideAnimation.setFillAfter(false);

		RightSideAnimation = new TranslateAnimation(500, 0, 0, 0);
		RightSideAnimation.setDuration(1500);
		RightSideAnimation.setFillBefore(true);
		RightSideAnimation.setFillAfter(false);

		XonlineImage.startAnimation(RightSideAnimation);
		VSImage.startAnimation(LeftSideAnimation);

		CountDownTimer myCountDown = new CountDownTimer(1000, 1000) {
			public void onTick(long millisUntilFinished) {
			}

			public void onFinish() {

				HumanActivityText.startAnimation(FadeInAnimatio);
				AndroidActivityText.startAnimation(FadeInAnimatio);
				OnlineActivityText.startAnimation(FadeInAnimatio);
				HumanActivityText.setAlpha(80F);
				AndroidActivityText.setAlpha(80);
				OnlineActivityText.setAlpha(80);

			}
		};
		myCountDown.start();

	}

}
