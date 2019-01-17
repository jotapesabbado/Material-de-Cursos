package com.joao.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaro;
	private Texture fundo;
	private Texture canobot;
	private Texture canotop;
	private BitmapFont fonte;
	private Texture gameover;
	private BitmapFont mensagem;

	//ESTRUTURAS DE COLISÃO
	private Circle passaroColision;
	private Rectangle canotopoColision;
	private Rectangle canobaixoColision;
	//private ShapeRenderer shapeRenderer;

	//ATRIBUTOS DE EXIBIÇÃO
	private float variacao = 0;
	private float gravidade = 0;
	private float posicaoY = 0;
	private float posicaoXcano = 0;
	private float espacocano = 400;
	private float aluraentrecanos=0;
	private Random random;
	private int estadojogo=0;
	/*ESTADO 0 JOGO PARADO
	* ESTADO 1 JOGO INICIADO
	* ESTADO 2 GAME HOVER*/

	private int pontacao=0;
	private boolean pontouou =false;

	//CAMERA

	private OrthographicCamera camera;
	private Viewport viewport;
	private float VIRTUAL_WIDTH = 720;
	private float VIRTUAL_HEIGHT = 1280;



	
	@Override
	public void create () {
		batch = new SpriteBatch();
		passaro = new Texture[3];
		passaro[0]=new Texture("passaro1.png");
		passaro[1]=new Texture("passaro2.png");
		passaro[2]=new Texture("passaro3.png");
		fundo = new Texture("fundo.png");
		canotop = new Texture("cano_topo_maior1.png");
		canobot = new Texture("cano_baixo_maior1.png");
		gameover = new Texture("game_over.png");

		posicaoY=VIRTUAL_HEIGHT/2;
		posicaoXcano= VIRTUAL_WIDTH;
		random = new Random();
		fonte = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(6);
		mensagem = new BitmapFont();
		mensagem.setColor(Color.WHITE);
		mensagem.getData().setScale(3);
		passaroColision = new Circle();
		//shapeRenderer = new ShapeRenderer();

		//CONFIGURAÇÕES DA CAMERA
		camera = new OrthographicCamera();
		viewport = new StretchViewport(VIRTUAL_WIDTH,VIRTUAL_HEIGHT,camera);
		camera.position.set(VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/2,0);
	}

	@Override
	public void render () {

		camera.update();

		//limpar frames anteriores

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		//delta time é avariação entre as execuções do render() que é varia entre 0.2 e 0.3
		variacao += Gdx.graphics.getDeltaTime() * 6;
		if (variacao > 2) {
			variacao = 0;
		}

		if(estadojogo==0){//JOGO PARADO
			if(Gdx.input.justTouched()){
				estadojogo=1;
			}
		}else {
			gravidade += Gdx.graphics.getDeltaTime() * 50;
			if (posicaoY > 0 || gravidade < 0) {

				posicaoY = posicaoY - gravidade;
			}

			if(estadojogo==1) {//INICIA JOGO

				if (Gdx.input.justTouched()) {
					gravidade = -15;
				}

				//verifica se o cano saiu inteiramente da tela
				posicaoXcano -= Gdx.graphics.getDeltaTime() * 1000;
				if (posicaoXcano < -canobot.getWidth()) {
					posicaoXcano = VIRTUAL_WIDTH;
					aluraentrecanos = random.nextInt((int) VIRTUAL_HEIGHT) - VIRTUAL_HEIGHT / 2;
					if (aluraentrecanos > 0) {
						aluraentrecanos -= espacocano / 2 + 100;

					} else {
						aluraentrecanos += espacocano / 2 + 100;

					}
					pontouou = false;

				}

				//VERIFICA PONUAÇÃO

				if (posicaoXcano < 120 && !pontouou) {
					pontacao++;
					pontouou = true;
				}
			}else {//TELA DE GAME HOVER
				if(Gdx.input.justTouched()){
					estadojogo=0;
					pontacao=0;
					gravidade=0;
					posicaoY=VIRTUAL_HEIGHT/2;
					posicaoXcano=VIRTUAL_WIDTH;
					aluraentrecanos=0;
				}


			}


		}
		//CONFIGURAÇÕES DE DADOS DE PROJEÇÃO DA CAMERA
		batch.setProjectionMatrix(camera.combined);

			batch.begin();
			//propriendades(imagem,posição x, posição y, largura, altura)
			batch.draw(fundo, 0, 0, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);

			batch.draw(canotop, posicaoXcano,VIRTUAL_HEIGHT/2+ (espacocano / 2)+aluraentrecanos);
			batch.draw(canobot, posicaoXcano,VIRTUAL_HEIGHT/2-canobot.getHeight()- (espacocano / 2)+aluraentrecanos);


			batch.draw(passaro[(int) variacao], 120, posicaoY);
			fonte.draw(batch,String.valueOf(pontacao),VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT-50);

			if(estadojogo==2){
				batch.draw(gameover,VIRTUAL_WIDTH/2-gameover.getWidth()/2,VIRTUAL_HEIGHT/2);
				mensagem.draw(batch,"TOQUE PARA REINICIAR" ,VIRTUAL_WIDTH/2-250,VIRTUAL_HEIGHT/2-gameover.getHeight()/2);
			}

			batch.end();

			//CRIAR AS FORMAS
			passaroColision.set(120+passaro[0].getWidth()/2, posicaoY+passaro[0].getHeight()/2,passaro[0].getWidth()/2);
			canobaixoColision =  new Rectangle(posicaoXcano,VIRTUAL_HEIGHT/2-canobot.getHeight()- (espacocano / 2)+aluraentrecanos,canobot.getWidth(),canobot.getHeight());
			canotopoColision =new Rectangle(posicaoXcano,VIRTUAL_HEIGHT/2+ (espacocano / 2)+aluraentrecanos,canotop.getWidth(),canotop.getHeight());

			//DESENHAR FORMAS

			/*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.circle(passaroColision.x,passaroColision.y,passaroColision.radius);
			shapeRenderer.rect(canobaixoColision.x,canobaixoColision.y,canobaixoColision.width,canobaixoColision.height);
			shapeRenderer.rect(canotopoColision.x,canotopoColision.y,canotopoColision.width,canotopoColision.height);

			shapeRenderer.setColor(Color.BLUE);


			shapeRenderer.end();
			*/

			//TESTE DE COLISÃO
			if(Intersector.overlaps(passaroColision,canobaixoColision) || Intersector.overlaps(passaroColision,canotopoColision ) || posicaoY<=0|| posicaoY>VIRTUAL_HEIGHT){
				estadojogo= 2;

			}



	}


	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width,height);
	}
}
