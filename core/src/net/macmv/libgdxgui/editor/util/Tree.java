package net.macmv.libgdxgui.editor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Tree<T> {
  private T data;
  private List<Tree<T>> children = new ArrayList<>();
  private Tree<T> parent = null;

  public Tree(T data) {
    this.data = data;
  }

  public Tree<T> addChild(Tree<T> child) {
    child.setParent(this);
    this.children.add(child);
    return child;
  }

  public Tree<T> addChild(T child) {
    Tree<T> childTree = new Tree<>(child);
    addChild(childTree);
    return childTree;
  }

  public void addChildren(List<Tree<T>> children) {
    children.forEach(each -> each.setParent(this));
    this.children.addAll(children);
  }

  public List<Tree<T>> getChildren() {
    return children;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Tree<T> getParent() {
    return parent;
  }

  private void setParent(Tree<T> parent) {
    this.parent = parent;
  }

  @Override
  public String toString() { // recursively loops through all elements of children
    StringBuilder string = new StringBuilder();
    string.append(data.toString()).append("\n");
    for (Tree<T> child : children) {
      for (String line : child.toString().split("\n")) {
        string.append("--").append(line).append("\n");
      }
    }
    return string.toString();
  }

  public void forEach(Consumer<Tree<T>> consumer) {
    consumer.accept(this);
    children.forEach((child) -> {
      child.forEach(consumer);
    });
  }
}
