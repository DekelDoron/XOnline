package com.example.xonlinepremium.customGameViews;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xonlinepremium.R;
import com.example.xonlinepremium.customGameViews.CustomCube;

public class CustomViewOfBoard extends LinearLayout {
	
	//CustomCube will change to button with onclick implement
	
	// Package
	private Context context;
	private AttributeSet attrs;

	// game
	private boolean IsXturn;
	private int Xscore = 0;
	private int Oscore = 0;
	private char[] cubesArray;

	
	// settings
	private boolean isTieON;
	private int counterClick;
	private boolean shigidyPlay;
	Animation FadeInAnimation;
	Animation FadeOutAnimation;
	
	//winnersCube
	private int cube1;
	private int cube2;
	private int cube3;
	
	class ViewLayout {
		public ViewLayout() {

			Cube1 = (CustomCube) findViewById(R.id.topLeft);
			Cube2 = (CustomCube) findViewById(R.id.topCenter);
			Cube3 = (CustomCube) findViewById(R.id.topRight);
			Cube4 = (CustomCube) findViewById(R.id.middleLeft);
			Cube5 = (CustomCube) findViewById(R.id.middleCenter);
			Cube6 = (CustomCube) findViewById(R.id.middleRight);
			Cube7 = (CustomCube) findViewById(R.id.bottomLeft);
			Cube8 = (CustomCube) findViewById(R.id.bottomCenter);
			Cube9 = (CustomCube) findViewById(R.id.bottomRight);
			XscoreTextView = (TextView) findViewById(R.id.tvScoreX);
			OscoreTextView = (TextView) findViewById(R.id.tvScoreO);

		}

		CustomCube Cube1, Cube2, Cube3, Cube4, Cube5, Cube6, Cube7, Cube8,
				Cube9;
		TextView XscoreTextView;
		TextView OscoreTextView;
	}

	private class ClicksHandler implements OnClickListener {

		CustomCube cube;
		Animation FadeInAnimation;

		public void onClick(View v) {
			// TODO Auto-generated method stub
			cube.startAnimation(FadeInAnimation);
			cube.SetPlayer(IsXturn);
			counterClick = cube.getID();
			cubesArray[counterClick] = cube.getPlayer();
			IsXturn = !IsXturn;
			cube.setEnabled(false);
			declareWinner(searchForWinner());
			if (shigidyPlay == true) {
				
				shigidyMove();

			}
		}

		public ClicksHandler(CustomCube cube) {
			super();
			this.cube = cube;
			FadeInAnimation = new AlphaAnimation(0, 100);
			FadeInAnimation.setDuration(1500);
			FadeInAnimation.setFillBefore(true);
			FadeInAnimation.setFillAfter(true);
		}

	}

	ViewLayout lv;

	public CustomViewOfBoard(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflator.inflate(R.layout.custom_board_game, this);
		this.context = context;
		this.attrs = attrs;
		// TODO Auto-generated constructor stub
		
		lv = new ViewLayout();
		IsXturn = true;
		isTieON = true;
		shigidyPlay = false;
		counterClick = 1;
		cubesArray = new char[10];
		initiation();
		

	}

	private void initiation() {
		// place Clicks on Cubes Button

		lv.Cube1.setOnClickListener(new ClicksHandler(lv.Cube1));
		lv.Cube2.setOnClickListener(new ClicksHandler(lv.Cube2));
		lv.Cube3.setOnClickListener(new ClicksHandler(lv.Cube3));
		lv.Cube4.setOnClickListener(new ClicksHandler(lv.Cube4));
		lv.Cube5.setOnClickListener(new ClicksHandler(lv.Cube5));
		lv.Cube6.setOnClickListener(new ClicksHandler(lv.Cube6));
		lv.Cube7.setOnClickListener(new ClicksHandler(lv.Cube7));
		lv.Cube8.setOnClickListener(new ClicksHandler(lv.Cube8));
		lv.Cube9.setOnClickListener(new ClicksHandler(lv.Cube9));

		lv.Cube1.setID(1);
		lv.Cube2.setID(2);
		lv.Cube3.setID(3);
		lv.Cube4.setID(4);
		lv.Cube5.setID(5);
		lv.Cube6.setID(6);
		lv.Cube7.setID(7);
		lv.Cube8.setID(8);
		lv.Cube9.setID(9);

		for (int i = 0; i < cubesArray.length; i++) {
			cubesArray[i] = 'e';
		}

	}

	private void cleanBoard() {
		// clean All Board

		lv.Cube1.init();
		lv.Cube1.setEnabled(true);

		lv.Cube2.init();
		lv.Cube2.setEnabled(true);

		lv.Cube3.init();
		lv.Cube3.setEnabled(true);

		lv.Cube4.init();
		lv.Cube4.setEnabled(true);

		lv.Cube5.init();
		lv.Cube5.setEnabled(true);

		lv.Cube6.init();
		lv.Cube6.setEnabled(true);

		lv.Cube7.init();
		lv.Cube7.setEnabled(true);

		lv.Cube8.init();
		lv.Cube8.setEnabled(true);

		lv.Cube9.init();
		lv.Cube9.setEnabled(true);

		initiation();

	}

	private void updateScoreView() {
		// Score View

		String scoreOfX = String.valueOf(Xscore);
		String scoreOfO = String.valueOf(Oscore);

		lv.XscoreTextView.setText(String.valueOf(scoreOfX));
		lv.OscoreTextView.setText(String.valueOf(scoreOfO));

		SpannableString X = new SpannableString(scoreOfX);
		SpannableString O = new SpannableString(scoreOfO);

		X.setSpan(new UnderlineSpan(), 0, scoreOfX.length(), 0);
		O.setSpan(new UnderlineSpan(), 0, scoreOfO.length(), 0);

		if (IsXturn == true) {
			lv.OscoreTextView.setText(String.valueOf(scoreOfO));
			lv.XscoreTextView.setText(X);

		} else {

			lv.XscoreTextView.setText(String.valueOf(scoreOfX));
			lv.OscoreTextView.setText(O);

		}

	}

	private void declareWinner(boolean winner) {

		FadeOutAnimation = new AlphaAnimation(100, 0);
		FadeOutAnimation.setDuration(1000);
		FadeOutAnimation.setFillBefore(true);
		FadeOutAnimation.setFillAfter(false);

		if (lv.Cube1.getPlayer() != 'e' && lv.Cube2.getPlayer() != 'e'
				&& lv.Cube3.getPlayer() != 'e' && lv.Cube4.getPlayer() != 'e'
				&& lv.Cube5.getPlayer() != 'e' && lv.Cube6.getPlayer() != 'e'
				&& lv.Cube7.getPlayer() != 'e' && lv.Cube8.getPlayer() != 'e'
				&& lv.Cube9.getPlayer() != 'e') {
			// TODO Filled Board
			cleanBoard();
			// IsXturn =! IsXturn;

			if (isTieON == true) {
				IsXturn = !IsXturn;
				performLastClick(counterClick);
			}

		}

		if (winner == true) {
			// TODO when winner
			callWiner();
			
			CountDownTimer myCountDown = new CountDownTimer(500, 1500) {
				public void onTick(long millisUntilFinished) {
				}

				public void onFinish() {
					// code:
					cleanBoard();
					if (isTieON == true) {
						performLastClick(counterClick);
					}

				}
			};
			myCountDown.start();

		}

	}

	private boolean searchForWinner() {
		// DONE
		boolean winner = false;

		// 1 - 2 - 3
		if (lv.Cube1.getPlayer() == lv.Cube2.getPlayer()
				&& lv.Cube2.getPlayer() == lv.Cube3.getPlayer()) {
			if (lv.Cube1.getPlayer() != 'e') {
				scoreHandler(lv.Cube1.getPlayer());
				winner = true;
				
				cube1 = 1;  cube2 = 2;  cube3 = 3;
			}
		}

		// 4 - 5 - 6
		if (lv.Cube4.getPlayer() == lv.Cube5.getPlayer()
				&& lv.Cube5.getPlayer() == lv.Cube6.getPlayer()) {
			if (lv.Cube4.getPlayer() != 'e') {
				scoreHandler(lv.Cube4.getPlayer());
				winner = true;
				cube1 = 4;  cube2 = 5;  cube3 = 6;

			}
		}

		// 7 - 8 - 9
		if (lv.Cube7.getPlayer() == lv.Cube8.getPlayer()
				&& lv.Cube8.getPlayer() == lv.Cube9.getPlayer()) {
			if (lv.Cube7.getPlayer() != 'e') {
				scoreHandler(lv.Cube7.getPlayer());
				winner = true;
				cube1 = 7;  cube2 = 8;  cube3 = 9;

			}
		}

		// 1 - 4 - 7
		if (lv.Cube1.getPlayer() == lv.Cube4.getPlayer()
				&& lv.Cube4.getPlayer() == lv.Cube7.getPlayer()) {
			if (lv.Cube1.getPlayer() != 'e') {
				scoreHandler(lv.Cube1.getPlayer());
				winner = true;
				cube1 = 1;  cube2 = 4;  cube3 = 7;

			}
		}

		// 2 - 5 - 8
		if (lv.Cube2.getPlayer() == lv.Cube5.getPlayer()
				&& lv.Cube5.getPlayer() == lv.Cube8.getPlayer()) {
			if (lv.Cube2.getPlayer() != 'e') {
				scoreHandler(lv.Cube2.getPlayer());
				winner = true;
				cube1 = 2;  cube2 = 5;  cube3 = 8;

			}
		}

		// 3 - 6 - 9
		if (lv.Cube3.getPlayer() == lv.Cube6.getPlayer()
				&& lv.Cube6.getPlayer() == lv.Cube9.getPlayer()) {
			if (lv.Cube3.getPlayer() != 'e') {
				scoreHandler(lv.Cube3.getPlayer());
				winner = true;
				cube1 = 3;  cube2 = 6;  cube3 = 9;

			}
		}

		// 1 - 5 - 9
		if (lv.Cube1.getPlayer() == lv.Cube5.getPlayer()
				&& lv.Cube5.getPlayer() == lv.Cube9.getPlayer()) {
			if (lv.Cube1.getPlayer() != 'e') {
				scoreHandler(lv.Cube1.getPlayer());
				winner = true;
				cube1 = 1;  cube2 = 5;  cube3 = 9;

			}
		}

		// 3 - 5 - 7
		if (lv.Cube3.getPlayer() == lv.Cube5.getPlayer()
				&& lv.Cube5.getPlayer() == lv.Cube7.getPlayer()) {
			if (lv.Cube3.getPlayer() != 'e') {
				scoreHandler(lv.Cube3.getPlayer());
				winner = true;
				cube1 = 3;  cube2 = 5;  cube3 = 7;

			}
		}

		updateScoreView();
		return winner;

	}

	private void scoreHandler(char winner) {

		FadeInAnimation = new ScaleAnimation(0, 1, -5, 1);
		FadeInAnimation.setDuration(500);
		FadeInAnimation.setFillBefore(true);
		FadeInAnimation.setFillAfter(true);

		FadeOutAnimation = new AlphaAnimation(95, 20);
		FadeOutAnimation.setDuration(1000);
		FadeOutAnimation.setFillBefore(true);
		FadeOutAnimation.setFillAfter(false);

		if (winner == 'x' || winner == 'X') {

			lv.XscoreTextView.startAnimation(FadeOutAnimation);
			lv.XscoreTextView.startAnimation(FadeInAnimation);
			Xscore++;
		}

		if (winner == 'o' || winner == 'O') {
			lv.OscoreTextView.startAnimation(FadeOutAnimation);
			lv.OscoreTextView.startAnimation(FadeInAnimation);
			Oscore++;
		}

	}

	private void callWiner() {

		IsXturn = !IsXturn;

		lv.Cube1.playAnimation(IsXturn);
		lv.Cube2.playAnimation(IsXturn);
		lv.Cube3.playAnimation(IsXturn);
		lv.Cube4.playAnimation(IsXturn);
		lv.Cube5.playAnimation(IsXturn);
		lv.Cube6.playAnimation(IsXturn);
		lv.Cube7.playAnimation(IsXturn);
		lv.Cube8.playAnimation(IsXturn);
		lv.Cube9.playAnimation(IsXturn);


	}

	private void performLastClick(int Click) {

		switch (Click) {

		case 1:
			lv.Cube1.performClick();

			break;

		case 2:
			lv.Cube2.performClick();

			break;

		case 3:
			lv.Cube3.performClick();

			break;

		case 4:
			lv.Cube4.performClick();

			break;

		case 5:
			lv.Cube5.performClick();

			break;

		case 6:
			lv.Cube6.performClick();

			break;

		case 7:
			lv.Cube7.performClick();

			break;

		case 8:
			lv.Cube8.performClick();

			break;

		case 9:
			lv.Cube9.performClick();

			break;
		}

	}

	private void shigidyMove() {

		if (IsXturn == false) {

			int[] i = { 0, 0, 0, 0, 0, 0, 0, 0, 0, };
			
			i[0] = searchWinningOp(1, 9, 7);
			i[1] = searchWinningOp(1, 2, 3);
			i[2] = searchWinningOp(4, 5, 6);
			i[3] = searchWinningOp(7, 8, 9);
			i[4] = searchWinningOp(1, 4, 7);
			i[5] = searchWinningOp(2, 5, 8);
			i[6] = searchWinningOp(3, 6, 9);
			i[7] = searchWinningOp(1, 5, 9);
			i[8] = searchWinningOp(3, 5, 7);

			for (int j = 1; j < i.length; j++) {

				if (i[j] > 0) {

					performLastClick(i[j]);
					// Toast.makeText(context, "Smart turn",
					// Toast.LENGTH_SHORT).show();
					return;
				}

			}

			for (int j = 1; j <= i.length; j++) {
				
				
				if (cubesArray[j] == 'e') {
					
					
					performLastClick(j);
					
					
					// Toast.makeText(context, "AI turn",
					// Toast.LENGTH_SHORT).show();

					return;
				}

			}

		}

	}

	private int searchWinningOp(int a, int b, int c) {

		if ((cubesArray[a] == 'e') && (cubesArray[b] != 'e')
				&& (cubesArray[c] != 'e') && (cubesArray[b] == cubesArray[c])) {
			return a;
		}

		else if ((cubesArray[b] == 'e') && (cubesArray[a] != 'e')
				&& (cubesArray[c] != 'e') && (cubesArray[a] == cubesArray[c])) {
			return b;
		}

		else if ((cubesArray[c] == 'e') && (cubesArray[a] != 'e')
				&& (cubesArray[b] != 'e') && (cubesArray[a] == cubesArray[b])) {
			return c;
		}

		return 0;

	}

	// SETTERS!

	public void setTie(boolean tie) {
		isTieON = tie;
	}

	public void setHuman(boolean Human) {
		if (Human == true) {
			shigidyPlay = false;
		}
		if (Human == false) {
			shigidyPlay = true;
		}
	}

}
