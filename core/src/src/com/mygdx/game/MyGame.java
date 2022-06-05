package  src.com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


public class MyGame extends Game{
	public static final int PPM = 100;

	public GameScreen gameScreen;
	Music music;
	@Override
	public void create() {
		
		gameScreen = new  GameScreen(this);
		//set screen for game
		setScreen(gameScreen);
		//Player.load();
		music = Gdx.audio.newMusic(Gdx.files.internal("bocbatho.mp3"));
		music.play();
		music.setLooping(true);
	}
	

}

