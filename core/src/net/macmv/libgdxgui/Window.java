package net.macmv.libgdxgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

import java.util.HashSet;

public class Window {
  private HashSet<Section> sections = new HashSet<>();
  private Stage stage;
  private Table table;
  private static final boolean debug = false;

  public Window(RenderManager manager) {
    stage = new Stage();
    table = new Table();
    table.setFillParent(true);
    stage.addActor(table);

    sections.add(new Section(this, manager));
  }

  public Table getTable() {
    return table;
  }

  public void render() {
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
  }

  public void resize(int width, int height) {
    System.out.println("Resizing");
    Array<Actor> actors = stage.getActors();
    stage = new Stage();
    for (Actor actor : actors) {
      stage.addActor(actor);
    }
    stage.setDebugAll(debug);
    Gdx.input.setInputProcessor(stage);
  }

  public Stage getStage() {
    return stage;
  }
}
