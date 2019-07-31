package net.macmv.libgdxgui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public abstract class Tab {
  protected final Table container = new Table();
  private String name;

  public Tab(String name) {
    this.name = name;
  }

  public WidgetGroup getContent() {
    return container;
  }

  public String getName() {
    return name;
  }
}
