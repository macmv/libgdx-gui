package net.macmv.libgdxgui.editor;

import net.macmv.libgdxgui.editor.object.Sprite;

public abstract class GameObject {

  public enum Type {
    OBJECT,
    CAT_2D,
    OBJ_SPRITE;

    GameObject createGameObject() {
      GameObject newObj = null;
      switch (this) {
        case OBJ_SPRITE: newObj = new Sprite(); break;
      }
      if (newObj == null) {
        throw new RuntimeException("Could not create new game object from type " + this);
      }
      return newObj;
    }
  }
}
