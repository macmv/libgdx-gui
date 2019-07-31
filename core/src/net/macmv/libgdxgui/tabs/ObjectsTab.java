package net.macmv.libgdxgui.tabs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import net.macmv.libgdxgui.Assets;
import net.macmv.libgdxgui.RenderManager;
import net.macmv.libgdxgui.Tab;
import net.macmv.libgdxgui.Window;
import net.macmv.libgdxgui.editor.GameObject;
import net.macmv.libgdxgui.editor.object.Sprite;
import net.macmv.libgdxgui.editor.util.Tree;

import java.lang.reflect.Method;

public class ObjectsTab extends Tab {
  private final Window window;
  private final RenderManager manager;
  private final Dialog newObjectDialog = Assets.createDialog(this::addGameObject);

  public ObjectsTab(RenderManager manager, Window window) {
    super("Objects");
    this.window = window;
    this.manager = manager;
    Button newButton = Assets.createTextButton("New", false);
    newButton.addCaptureListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        showNewObjectDialog();
      }
    });
    container.add(newButton).align(Align.top);
    ScrollPane itemCol = Assets.createList();
    int i = 0;
    for (GameObject object : manager.getGame().getGameObjects()) {
      ((VerticalGroup) itemCol.getActor()).addActor(Assets.createLabel(object.toString(), i % 2 == 0));
      i++;
    }
    container.add(itemCol);
    container.row();
    container.align(Align.top);
    setupNewObjectDialog();
  }

  private void addGameObject(Object obj) {
    if (obj == null) {
      return;
    }
    GameObject newGameObj;
    try {
      newGameObj = (GameObject) ((Class) obj).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException("Could not create instance of obj " + obj + ", with error:\n" + e);
    }
    System.out.println(newGameObj);
  }

  private void setupNewObjectDialog() {
    newObjectDialog.text(Assets.createLabel("New object", true));
    ScrollPane scroll = Assets.createList();
    VerticalGroup vert = (VerticalGroup) scroll.getChild(0);
    Tree<GameObject.Type> tree = manager.getGame().getObjectTree();
    tree.forEach(node -> {
      vert.addActor(Assets.createLabel(node.getData().toString(), false));
    });
    newObjectDialog.add(scroll);
    newObjectDialog.button(Assets.createTextButton("Accept"), Sprite.class);
    newObjectDialog.button(Assets.createTextButton("Cancel"), null);
    newObjectDialog.key(Input.Keys.ESCAPE, null);
  }

  private void showNewObjectDialog() {
    newObjectDialog.show(window.getStage());
  }
}
