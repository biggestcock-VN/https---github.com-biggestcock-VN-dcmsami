package  src.com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import src.com.mygdx.Spritess.testPlayer;
import src.tools.B2WorldCreator;


public class GameScreen implements Screen{
	//some element for spritte
    MyGame mygame;
    OrthographicCamera camera;
    SpriteBatch batch;
    //Player player;
    TileMap tileMap;
    testPlayer test;
    //Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;
 //   private B2WorldCreator creator;

    
//    TmxMapLoader maploader;
//    TiledMap map;
//    OrthogonalTiledMapRenderer renderer;
    
  
    
    public GameScreen(MyGame mygame)
    {
    	this.mygame = mygame;
    	this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	//TRUE = VE CHUAN, FALSE = VE NGUOC
    	camera.setToOrtho(false, 1670, 900);
    	batch = new SpriteBatch();	
    //	player = new Player();
    	tileMap = new TileMap();
    	//test = new testPlayer(world);
//    	maploader = new TmxMapLoader();
//    	map = maploader.load("map.tmx");
//    	renderer = new OrthogonalTiledMapRenderer(map);
    	
    	tileMap.init();
    	world = new World(new Vector2(0,0), true);
    	b2dr = new Box2DDebugRenderer();
    	
    	new B2WorldCreator(world, tileMap);
    	test = new testPlayer(world);
    	
    }
	


	@Override
	public void render(float delta) {
		world.step(1/60f, 6, 2);
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		//FULL PROCESS OF RENDER
		//batch.setProjectionMatrix(camera.combined);
		tileMap.renderer.setView(camera);
		tileMap.renderer.render();
	//	test.updatePos();
		HandleInput();
		
		//	player.updatePos();
		b2dr.render(world, camera.combined);
		batch.begin();
	//	test.b2body.setLinearVelocity(0f, 0f);
	
		//Rendering code
		//batch.draw(Player.sprite_player, player.posX, player.posY);// two last element for posistion of image
	//	batch.draw(test, test.PosX, test.PosY);
		batch.end();
		}	
	
	public void HandleInput()
	{
		

		// apply left impulse, but only if max velocity is not reached yet
		if (Gdx.input.isKeyPressed(Input.Keys.W) ) {	
			if(test.b2body.getLinearVelocity().y <=99)
			
		    this.test.b2body.applyLinearImpulse(new Vector2(0, 10f), test.b2body.getWorldCenter(), true);
			
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.S) ) {	
			if(test.b2body.getLinearVelocity().y >= -99)
				
			    this.test.b2body.applyLinearImpulse(new Vector2(0, -10f), test.b2body.getWorldCenter(), true);
		}
		
		else if(Gdx.input.isKeyPressed(Input.Keys.A) ) {	
			if(test.b2body.getLinearVelocity().x >= -99)
				
			    this.test.b2body.applyLinearImpulse(new Vector2(-10f, 0), test.b2body.getWorldCenter(), true);
		}
		
		else if(Gdx.input.isKeyPressed(Input.Keys.D) ) {	
			if(test.b2body.getLinearVelocity().y >= -99)
				
			    this.test.b2body.applyLinearImpulse(new Vector2(10f, 0), test.b2body.getWorldCenter(), true);
		}
		else			
		{
			test.b2body.setLinearVelocity(0f, 0f);
		}

		// apply right impulse, but only if max velocity is not reached yet
		
		
		
		
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		
		tileMap.map.dispose();
		world.dispose();
		b2dr.dispose();
	}
	

}
