package net.macmv.libgdxgui.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Files {
  private final ArrayList<FileHandle> assets;

  public Files() {
    assets = loadAssets();
  }

  private ArrayList<FileHandle> loadAssets() {
    ArrayList<FileHandle> files = new ArrayList<>();
    try {
      Stream<Path> walk = java.nio.file.Files.walk(Gdx.files.internal("").file().toPath());

      walk.forEach(file -> {
        if (java.nio.file.Files.isRegularFile(file) && !file.toString().startsWith(".")) {
          files.add(Gdx.files.internal(file.toString()));
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return files;
  }

  public ArrayList<FileHandle> getAssets() {
    return assets;
  }
}
