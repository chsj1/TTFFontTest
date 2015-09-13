package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	FreeTypeFontGenerator generator;//TTF���巢���������𱣴�ͽ���.ttf�ļ�
	FreeTypeBitmapFontData fontData;//������FreeTypeFontGenerator�е�����
	BitmapFont font;
	SpriteBatch batch;
	
	TextureAtlas atlas;
	TextureRegion bgRegion;//����ͼƬ
	
	@Override
	public void create() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/test.ttf"));//FreeTypeFontGenerator�ĳ�ʼ��
		/**
		 * FreeTypeBitmapFontData�ĳ�ʼ��
		 * ��3�������ĺ���Ϊ:
		 * �ֺŴ�С�������ַ������Ƿ�ת
		 */
		fontData = generator.generateData(35, generator.DEFAULT_CHARS + "��������", false);
		font = new BitmapFont(fontData, fontData.getTextureRegion(), false);
		font.setColor(Color.BLACK);
		batch = new SpriteBatch();
		
		atlas = new TextureAtlas(Gdx.files.internal("data/loading.atlas"));
		bgRegion = atlas.findRegion("bg");
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.draw(bgRegion, 0, 0, 480, 800);
		font.draw(batch, "��������",100,  Gdx.graphics.getHeight()/2);
//		font.drawMultiLine(batch, "��������", 0,  Gdx.graphics.getHeight()/2);
		batch.end();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
