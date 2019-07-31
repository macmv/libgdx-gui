package net.macmv.libgdxgui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import net.macmv.libgdxgui.tabs.AssetsTab;
import net.macmv.libgdxgui.tabs.ObjectsTab;

import java.util.ArrayList;

public class Section {
  private ArrayList<Tab> tabs = new ArrayList<>();
  private int currentTab = 0;
  private VerticalGroup container = new VerticalGroup();
  private HorizontalGroup tabButtons = new HorizontalGroup();
  private WidgetGroup tabContent;

  public Section(Window window, RenderManager manager) {
    container.addActor(tabButtons);

    window.getTable().add(container);
    addTab(new AssetsTab(manager, window));
    addTab(new ObjectsTab(manager, window));

    setTab(0);
  }

  private void addTab(Tab tab) {
    tabs.add(tab);
    int index = tabs.size() - 1;
    Button button = Assets.createTabButton(tab.getName(), true);
    button.addCaptureListener(new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        setTab(index);
      }
    });
    tabButtons.addActor(button);
  }

  private void setTab(int i) {
    System.out.println("Setting tab to " + i);
    currentTab = i;
    container.removeActor(tabContent);
    tabContent = tabs.get(currentTab).getContent();
    container.addActor(tabContent);
    int index = 0;
    for (Actor actor : tabButtons.getChildren().items) {
      if (actor == null) {
        index++;
        continue;
      }
      if (!(actor instanceof Button)) {
        throw new RuntimeException("Actor \"" + actor + "\" in tabs is not a button!");
      }
      Button button = (Button) actor;
      ChangeListener listener = (ChangeListener) button.getCaptureListeners().get(0);
      button.getCaptureListeners().clear(); // make the event not trigger recursively
      button.setChecked(index == currentTab);
      button.getCaptureListeners().add(listener); // but make it trigger at other times
      index++;
    }
  }
}
