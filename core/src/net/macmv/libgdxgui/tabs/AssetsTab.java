package net.macmv.libgdxgui.tabs;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import net.macmv.libgdxgui.Assets;
import net.macmv.libgdxgui.RenderManager;
import net.macmv.libgdxgui.Tab;
import net.macmv.libgdxgui.Window;

import java.util.ArrayList;

public class AssetsTab extends Tab {
  private final ArrayList<FileHandle> assets;

  public AssetsTab(RenderManager manager, Window window) {
    super("Assets");
    Button newButton = Assets.createTextButton("New", false);
    newButton.addCaptureListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        System.out.println("Adding asset");
      }
    });
    container.add(newButton).align(Align.top);
    ScrollPane itemCol = Assets.createList();
    assets = manager.getGame().getFiles().getAssets();
    int i = 0;
    for (FileHandle file : assets) {
      ((VerticalGroup) itemCol.getActor()).addActor(Assets.createLabel(file.toString(), i % 2 == 0, 2, 5, 2, 5));
      i++;
    }
    container.add(itemCol);
    container.row();
    container.align(Align.top);
  }
}
