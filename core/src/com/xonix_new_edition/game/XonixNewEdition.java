package com.xonix_new_edition.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.xonix_new_edition.game.menu.MainWindow;

public class XonixNewEdition extends Game {

	@Override
	public void create () {
		setScreen(new MainWindow(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}