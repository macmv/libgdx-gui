package net.macmv.libgdxgui.editor;

import net.macmv.libgdxgui.editor.object.Sprite;
import net.macmv.libgdxgui.editor.util.Tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class Game {
  private final Files files;
  private ArrayList<GameObject> gameObjects;
  private Tree<GameObject.Type> gameObjectTree;

  public Game() {
    files = new Files();
    gameObjects = new ArrayList<>();
    gameObjectTree = createGameObjectTree();
  }

  private Tree<GameObject.Type> createGameObjectTree() {
    Tree<GameObject.Type> tree = new Tree<>(GameObject.Type.OBJECT);
    tree.addChild(GameObject.Type.CAT_2D).
            addChild(GameObject.Type.OBJ_SPRITE);
    return tree;
  }

  public Files getFiles() {
    return files;
  }

  public ArrayList<GameObject> getGameObjects() {
    return gameObjects;
  }

  public void addObject(GameObject newObj) {
    gameObjects.add(newObj);
  }

  public Tree<GameObject.Type> getObjectTree() {
    return gameObjectTree;
  }
}
