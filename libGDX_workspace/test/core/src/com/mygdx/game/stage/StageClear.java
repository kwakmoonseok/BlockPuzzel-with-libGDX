package com.mygdx.game.stage;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class StageClear implements Screen{
	MyGdxGame my;
	Texture clear = new Texture("ClearStage.png");
	Texture back = new Texture("Stage1-back.png");
	final int CLEAR_WIDTH = 422;
	final int CLEAR_HEIGHT = 90;

	public StageClear(MyGdxGame my) {
		this.my = my;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		my.batch.begin();
		my.batch.draw(back, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
		my.batch.draw(clear, MyGdxGame.WIDTH / 2 - CLEAR_WIDTH / 2, MyGdxGame.HEIGHT / 2 - CLEAR_HEIGHT / 2, CLEAR_WIDTH, CLEAR_HEIGHT);
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
