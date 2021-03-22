package com.mygdx.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

class Blocks extends Image{
	int x_of_block;
	int y_of_block;
	final int BLOCK_WIDTH;
	final int BLOCK_HEIGHT;
	Texture img;
	
	public Blocks(int x_of_block, int y_of_block, int BLOCK_WIDTH, int BLOCK_HEIGHT, Texture img) {
		this.x_of_block = x_of_block;
		this.y_of_block = y_of_block;
		this.BLOCK_WIDTH = BLOCK_WIDTH;
		this.BLOCK_HEIGHT = BLOCK_HEIGHT;
		this.img = img;
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(this.img, this.x_of_block, this.y_of_block, this.BLOCK_WIDTH, this.BLOCK_HEIGHT);
	}
}
class Result{
	final int X_OF_BLOCK;
	final int Y_OF_BLOCK;
	public Result(int X_OF_BLOCK, int Y_OF_BLOCK) {
		this.X_OF_BLOCK = X_OF_BLOCK * 60;
		this.Y_OF_BLOCK = Y_OF_BLOCK * 60;
	}
}
public class Stage1 extends ClickListener implements Screen{

	MyGdxGame my;
	Skin skin;
	Stage stage;
	Sprite sprite;
	
	Blocks[] blocks = { new Blocks(100, 200, 120, 240, new Texture("Stage1-1.png")), new Blocks(300, 500, 120, 240, new Texture("Stage1-2.png")), 
			new Blocks(300, 0, 180, 180, new Texture("Stage1-3.png")), new Blocks(300, 400, 180, 180, new Texture("Stage1-4.png")),
			new Blocks(600, 100, 240, 180, new Texture("Stage1-5.png")), new Blocks(700, 600, 300, 120, new Texture("Stage1-6.png")) };
	
	Result[] block_results = { new Result(7, 4), new Result(0, 4), new Result(4, 4), new Result(1, 3), new Result(2, 4),
			new Result(3, 2) };
	Texture stageBack = new Texture("Stage1-back.png");
	
	static boolean[] checks = {false, false, false, false, false, false};
	static final int ERROR_RANGE = 1;
	static boolean[] correct = { false, false, false, false, false, false };
	
	static final int STAGE_WIDTH = 540;
	static final int STAGE_HEIGHT = 240;
	static final int STAGE_X = MyGdxGame.WIDTH / 2  - STAGE_WIDTH / 2;
	static final int STAGE_Y = MyGdxGame.HEIGHT / 2 - STAGE_HEIGHT / 2;
	static final int BOARD_WIDTH = 9;
	static final int BOARD_HEIGHT = 4;
	static final int BLOCK_SIZE = 60;
	
	public Stage1(MyGdxGame my) {
		this.my = my;
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		my.batch.begin();
		my.batch.draw(stageBack, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
		my.batch.draw(new Texture("Stage1.png"), STAGE_X, STAGE_Y, STAGE_WIDTH, STAGE_HEIGHT);
		if (checks[0]) {
			blocks[0].x_of_block = Gdx.input.getX();
			blocks[0].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[0] = false;
				if ((blocks[0].x_of_block + ERROR_RANGE >= STAGE_X + block_results[0].X_OF_BLOCK || blocks[0].x_of_block - ERROR_RANGE <= STAGE_X + block_results[0].X_OF_BLOCK) &&
					 blocks[0].y_of_block + ERROR_RANGE >= MyGdxGame.HEIGHT - (STAGE_Y + block_results[0].Y_OF_BLOCK) || blocks[0].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[0].Y_OF_BLOCK)){
					blocks[0].x_of_block = STAGE_X + block_results[0].X_OF_BLOCK;
					blocks[0].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[0].Y_OF_BLOCK);
					correct[0] = true;
					System.out.println(correct[0]);
				}
			}	
		}
		if (Gdx.input.getX() < blocks[0].x_of_block + blocks[0].BLOCK_WIDTH && Gdx.input.getX() > blocks[0].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[0].y_of_block + blocks[0].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[0].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[0] = true;
				this.dispose();
			}
		}
		if (checks[1]) {
			blocks[1].x_of_block = Gdx.input.getX();
			blocks[1].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[1] = false;
				if ((blocks[1].x_of_block + ERROR_RANGE >= STAGE_X + block_results[1].X_OF_BLOCK || blocks[1].x_of_block - ERROR_RANGE <= STAGE_X + block_results[1].X_OF_BLOCK) &&
						blocks[1].y_of_block + ERROR_RANGE >= MyGdxGame.HEIGHT - (STAGE_Y + block_results[1].Y_OF_BLOCK) || blocks[1].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[1].Y_OF_BLOCK)){
					blocks[1].x_of_block = STAGE_X + block_results[1].X_OF_BLOCK;
					blocks[1].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[1].Y_OF_BLOCK);
					correct[1] = true;
					System.out.println(correct[1]);
				}
			}
			
		}
		if (checks[2]) {
			blocks[2].x_of_block = Gdx.input.getX();
			blocks[2].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[2] = false;
				if ((blocks[2].x_of_block + ERROR_RANGE >= STAGE_X + block_results[2].X_OF_BLOCK || blocks[2].x_of_block - ERROR_RANGE <= STAGE_X + block_results[2].X_OF_BLOCK) &&
						blocks[2].y_of_block + ERROR_RANGE >= MyGdxGame.HEIGHT - (STAGE_Y + block_results[2].Y_OF_BLOCK) || blocks[2].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[2].Y_OF_BLOCK)){
					blocks[2].x_of_block = STAGE_X + block_results[2].X_OF_BLOCK;
					blocks[2].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[2].Y_OF_BLOCK);
					correct[2] = true;
					System.out.println(correct[2]);
				}
			}
			
		}
		if (checks[3]) {
			blocks[3].x_of_block = Gdx.input.getX();
			blocks[3].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[3] = false;
				if ((blocks[3].x_of_block + ERROR_RANGE >= STAGE_X + block_results[3].X_OF_BLOCK || blocks[3].x_of_block - ERROR_RANGE <= STAGE_X + block_results[3].X_OF_BLOCK) &&
						blocks[3].y_of_block + ERROR_RANGE >= MyGdxGame.HEIGHT - (STAGE_Y + block_results[3].Y_OF_BLOCK) || blocks[3].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[3].Y_OF_BLOCK)){
					blocks[3].x_of_block = STAGE_X + block_results[3].X_OF_BLOCK;
					blocks[3].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[3].Y_OF_BLOCK);
					correct[3] = true;
					System.out.println(correct[3]);
				}
			}
			
		}
		if (checks[4]) {
			blocks[4].x_of_block = Gdx.input.getX();
			blocks[4].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[4] = false;
				if ((blocks[4].x_of_block + ERROR_RANGE >= STAGE_X + block_results[4].X_OF_BLOCK || blocks[4].x_of_block - ERROR_RANGE <= STAGE_X + block_results[4].X_OF_BLOCK) &&
						blocks[4].y_of_block + ERROR_RANGE >= STAGE_Y + MyGdxGame.HEIGHT - (block_results[4].Y_OF_BLOCK) || blocks[4].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[4].Y_OF_BLOCK)){
					blocks[4].x_of_block = STAGE_X + block_results[4].X_OF_BLOCK;
					blocks[4].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[4].Y_OF_BLOCK);
					correct[4] = true;
					System.out.println(correct[4]);
				}
			
			}
		}
		if (checks[5]) {
			blocks[5].x_of_block = Gdx.input.getX();
			blocks[5].y_of_block = MyGdxGame.HEIGHT - Gdx.input.getY();
			if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
				checks[5] = false;
				if ((blocks[5].x_of_block + ERROR_RANGE >= STAGE_X + block_results[5].X_OF_BLOCK || blocks[5].x_of_block - ERROR_RANGE <= STAGE_X + block_results[5].X_OF_BLOCK) &&
					 blocks[5].y_of_block + ERROR_RANGE >= MyGdxGame.HEIGHT - (STAGE_Y + block_results[5].Y_OF_BLOCK) || blocks[5].y_of_block - ERROR_RANGE <= MyGdxGame.HEIGHT - (STAGE_Y + block_results[5].Y_OF_BLOCK)){
					blocks[5].x_of_block = STAGE_X + block_results[5].X_OF_BLOCK;
					blocks[5].y_of_block = MyGdxGame.HEIGHT - (STAGE_Y + block_results[5].Y_OF_BLOCK);
					correct[5] = true;
					System.out.println(correct[5]);
				}
			}
			
		}
		
		if (Gdx.input.getX() < blocks[1].x_of_block + blocks[1].BLOCK_WIDTH && Gdx.input.getX() > blocks[1].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[1].y_of_block + blocks[1].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[1].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[1] = true;
				this.dispose();
			}
		}
		if (Gdx.input.getX() < blocks[2].x_of_block + blocks[2].BLOCK_WIDTH && Gdx.input.getX() > blocks[2].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[2].y_of_block + blocks[2].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[2].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[2] = true;
				this.dispose();
			}
		}
		if (Gdx.input.getX() < blocks[3].x_of_block + blocks[3].BLOCK_WIDTH && Gdx.input.getX() > blocks[3].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[3].y_of_block + blocks[3].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[3].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[3] = true;
				this.dispose();
			}
		}
		if (Gdx.input.getX() < blocks[4].x_of_block + blocks[4].BLOCK_WIDTH && Gdx.input.getX() > blocks[4].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[4].y_of_block + blocks[4].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[4].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[4] = true;
				this.dispose();
			}
		}
		if (Gdx.input.getX() < blocks[5].x_of_block + blocks[5].BLOCK_WIDTH && Gdx.input.getX() > blocks[5].x_of_block && my.HEIGHT - Gdx.input.getY() < blocks[5].y_of_block + blocks[5].BLOCK_HEIGHT && my.HEIGHT - Gdx.input.getY() > blocks[5].y_of_block) {			
			if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
				checks[5] = true;
				this.dispose();
			}
		}
		if (correct[0] && correct[1] && correct[2] && correct[3] && correct[4] && correct[5])
			my.setScreen(new com.mygdx.game.stage.StageClear(my));
		for (Blocks b : blocks) {
			b.draw(my.batch);
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
