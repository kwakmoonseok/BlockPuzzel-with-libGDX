package com.mygdx.game.setting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.menu.Menu;

public class Setting implements Screen{

	MyGdxGame my;
	
	public final int ARROW_BUTTON_WIDTH = 100;
	public final int ARROW_BUTTON_HEIGHT = 100;
	public final int ARROW_BUTTON_X = 0;
	public final int ARROW_BUTTON_Y = 620;
	public final int SETTINGSCREEN_BUTTON_WIDTH = 990;
	public final int SETTINGSCREEN_BUTTON_HEIGHT = 660;
	public final int SETTINGSCREEN_BUTTON_X = my.WIDTH / 2 - SETTINGSCREEN_BUTTON_WIDTH / 2;
	public final int SETTINGSCREEN_BUTTON_Y = my.HEIGHT / 2 - SETTINGSCREEN_BUTTON_HEIGHT / 2;
	Texture arrow = new Texture("backarrow.png");


	public Setting(MyGdxGame my) {
		this.my = my;
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		my.batch.begin();
		my.batch.draw(new Texture(Menu.BACKGROUND), 0, 0, my.WIDTH, my.HEIGHT);
		my.batch.draw(arrow, ARROW_BUTTON_X, ARROW_BUTTON_Y, ARROW_BUTTON_WIDTH, ARROW_BUTTON_HEIGHT);
		if (Gdx.input.getX() < SETTINGSCREEN_BUTTON_X + SETTINGSCREEN_BUTTON_WIDTH && Gdx.input.getX() > SETTINGSCREEN_BUTTON_X && my.HEIGHT - Gdx.input.getY() < SETTINGSCREEN_BUTTON_Y + SETTINGSCREEN_BUTTON_HEIGHT && my.HEIGHT - Gdx.input.getY() > GITHUB_BUTTON_Y) {			
			if(Gdx.input.isTouched()) {
				this.dispose();
			}
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
