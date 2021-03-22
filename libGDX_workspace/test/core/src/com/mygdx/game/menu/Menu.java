package com.mygdx.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class Menu implements Screen{

	MyGdxGame my;
	
	public final static String BACKGROUND = "back.png";
	public final int TITLE_WIDTH = 1000;
	public final int TITLE_HEIGHT = 110;
	public final int TITLE_Y = 200 + (my.HEIGHT / 2 - TITLE_HEIGHT / 2);
	public final int START_BUTTON_WIDTH = 400;
	public final int START_BUTTON_HEIGHT = 132;
	public final int TUTORIAL_BUTTON_WIDTH = 400;
	public final int TUTORIAL_BUTTON_HEIGHT = 132;
	public final int START_BUTTON_Y = 100;
	public final int TUTORIAL_BUTTON_Y = 0;
	public final int SETTING_BUTTON_WIDTH = 129;
	public final int SETTING_BUTTON_HEIGHT = 127;
	public final int SETTING_BUTTON_X = 950;
	public final int SETTING_BUTTON_Y = 0;
	public final int GITHUB_BUTTON_WIDTH = 101;
	public final int GITHUB_BUTTON_HEIGHT = 102;
	public final int GITHUB_BUTTON_X = 0;
	public final int GITHUB_BUTTON_Y = 630;
	public final int X_OF_BUTTON = my.WIDTH / 2 - START_BUTTON_WIDTH / 2;
	Texture unactiveStartButton = new Texture("StartButton_unactivated.png");
	Texture activeStartButton = new Texture("StartButton_activated.png");
	Texture unactiveTutorialButton = new Texture("TutorialButton_unactivated.png");
	Texture activeTutorialButton = new Texture("TutorialButton_activated.png");
	Texture Title = new Texture("Title.png");
	Texture Setting = new Texture("Setting.png");
	Texture Github = new Texture("github.png");
	
	public Menu(MyGdxGame my) {
		this.my = my;
	}

	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		my.batch.begin();
		my.batch.draw(new Texture(Menu.BACKGROUND), 0, 0, my.WIDTH, my.HEIGHT);
		my.batch.draw(Title, my.WIDTH / 2 - TITLE_WIDTH / 2 , TITLE_Y , TITLE_WIDTH, TITLE_HEIGHT);
		my.batch.draw(Setting, 950, 0);
		my.batch.draw(Github, GITHUB_BUTTON_X, GITHUB_BUTTON_Y, GITHUB_BUTTON_WIDTH, GITHUB_BUTTON_HEIGHT);
		
		if (Gdx.input.getX() < GITHUB_BUTTON_X + GITHUB_BUTTON_WIDTH && Gdx.input.getX() > GITHUB_BUTTON_X && my.HEIGHT - Gdx.input.getY() < GITHUB_BUTTON_Y + GITHUB_BUTTON_HEIGHT && my.HEIGHT - Gdx.input.getY() > GITHUB_BUTTON_Y) {			
			if(Gdx.input.isTouched()) {
				Gdx.net.openURI("https://github.com/kwakmoonseok/BlockPuzzel-with-libGDX");
				this.dispose();
			}
		}
		if (Gdx.input.getX() < SETTING_BUTTON_X + SETTING_BUTTON_WIDTH && Gdx.input.getX() > SETTING_BUTTON_X && my.HEIGHT - Gdx.input.getY() < SETTING_BUTTON_Y + SETTING_BUTTON_HEIGHT && my.HEIGHT - Gdx.input.getY() > SETTING_BUTTON_Y) {			
			if(Gdx.input.isTouched()) {
				this.dispose();
				my.setScreen(new com.mygdx.game.setting.Setting(my));
				
			}
		}
		if (Gdx.input.getX() < X_OF_BUTTON + START_BUTTON_WIDTH && Gdx.input.getX() > X_OF_BUTTON && my.HEIGHT - Gdx.input.getY() < START_BUTTON_Y + START_BUTTON_HEIGHT && my.HEIGHT - Gdx.input.getY() > START_BUTTON_Y) {			
			my.batch.draw(activeStartButton, my.WIDTH / 2 - START_BUTTON_WIDTH / 2 , START_BUTTON_Y , START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
			if(Gdx.input.isTouched()) {
				this.dispose();
				my.setScreen(new com.mygdx.game.stage.Stage1(my));
			}
		}
		else {
			my.batch.draw(unactiveStartButton, my.WIDTH / 2 - START_BUTTON_WIDTH / 2 , START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
		}
		
		if (Gdx.input.getX() < X_OF_BUTTON + TUTORIAL_BUTTON_WIDTH && Gdx.input.getX() > X_OF_BUTTON && my.HEIGHT - Gdx.input.getY() < TUTORIAL_BUTTON_Y + TUTORIAL_BUTTON_HEIGHT && my.HEIGHT - Gdx.input.getY() > TUTORIAL_BUTTON_Y) {			
			my.batch.draw(activeTutorialButton, my.WIDTH / 2 - TUTORIAL_BUTTON_WIDTH / 2 , TUTORIAL_BUTTON_Y , TUTORIAL_BUTTON_WIDTH, TUTORIAL_BUTTON_HEIGHT);
			if(Gdx.input.isTouched()) {
				this.dispose();
				
			}
		}
		else {
			my.batch.draw(unactiveTutorialButton, my.WIDTH / 2 - TUTORIAL_BUTTON_WIDTH / 2 , TUTORIAL_BUTTON_Y, TUTORIAL_BUTTON_WIDTH, TUTORIAL_BUTTON_HEIGHT);
		}
		my.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
