package net.macmv.libgdxgui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LibgdxGUI extends ApplicationAdapter {
  private RenderManager render;

  @Override
  public void create() {
    render = new RenderManager();
  }

  @Override
  public void render() {
    render.render();
  }

  @Override
  public void dispose() {
    render.dispose();
  }

  @Override
  public void resize(int width, int height) {
    render.resize(width, height);
  }
}
