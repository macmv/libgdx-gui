package net.macmv.libgdxgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import net.macmv.libgdxgui.editor.Game;

import java.util.HashSet;

public class RenderManager {
  private HashSet<Window> windows = new HashSet<>();
  private Game game;

  public RenderManager() {
    Assets.init();
    game = new Game();
    windows.add(new Window(this));
  }

  public void render() {
    Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    for (Window window : windows) {
      window.render();
    }
  }

  public void dispose() {

  }

  public Game getGame() {
    return game;
  }

  public void resize(int width, int height) {
    for (Window window : windows) {
      window.resize(width, height);
    }
  }
}
