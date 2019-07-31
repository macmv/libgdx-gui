package net.macmv.libgdxgui.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import net.macmv.libgdxgui.LibgdxGUI;

public class DesktopLauncher {
  public static void main(String[] arg) {
    Graphics.Monitor monitor = Lwjgl3ApplicationConfiguration.getPrimaryMonitor();
    Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);
    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setWindowedMode((int) (displayMode.width / 1.3), (int) (displayMode.height / 1.3));
    config.setHdpiMode(HdpiMode.Logical);
    new Lwjgl3Application(new LibgdxGUI(), config);
  }
}
