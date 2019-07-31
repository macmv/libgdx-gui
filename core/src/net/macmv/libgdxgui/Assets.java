package net.macmv.libgdxgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.function.Consumer;

public class Assets {
  private static final float marginAmount = 5;
  private static final float padTop = 5;
  private static final float padSide = 10;
  private static final int lineWidth = 5;
  private static Drawable buttonUp;
  private static Drawable buttonOver;
  private static Drawable buttonDown;
  private static Drawable buttonChecked;
  private static Drawable tabButtonUp;
  private static Drawable tabButtonOver;
  private static Drawable tabButtonDown;
  private static Drawable tabButtonChecked;
  private static Drawable backgroundDrawableLight;
  private static Drawable backgroundDrawableDark;
  private static Drawable backgroundDrawablePrimary;
  private static Skin defaultSkin;
  private static BitmapFont font;

  public static void init() {
    buttonUp = createButtonDrawable(new Color(0.9f,
            0.9f,
            0.9f,
            1));
    buttonOver = createButtonDrawable(new Color(0.75f,
            0.75f,
            0.75f,
            1));
    buttonDown = createButtonDrawable(new Color(0.5f,
            0.5f,
            0.5f,
            1));
    buttonChecked = createButtonDrawable(new Color(0.75f,
            0.75f,
            0.75f,
            1));
    tabButtonUp = createTabButtonDrawable(new Color(0.9f,
            0.9f,
            0.9f,
            1));
    tabButtonOver = createTabButtonDrawable(new Color(0.75f,
            0.75f,
            0.75f,
            1));
    tabButtonChecked = createTabButtonDrawable(new Color(0.75f,
            0.75f,
            0.75f,
            1));
    tabButtonDown = createTabButtonDrawable(new Color(0.5f,
            0.5f,
            0.5f,
            1));
    backgroundDrawableLight = createBaseColorDrawable(new Color(0.9f,
                    0.9f,
                    0.9f,
                    1),
            false);
    backgroundDrawableDark = createBaseColorDrawable(new Color(0.8f,
                    0.8f,
                    0.8f,
                    1),
            false);
    backgroundDrawablePrimary = createBaseColorDrawable(new Color(0.9f,
                    0.2f,
                    0.2f,
                    1),
            false);
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Regular.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
    param.size = 24;
    param.color = Color.BLACK;
    font = generator.generateFont(param); // font size 12 pixels
    generator.dispose();
    defaultSkin = new Skin();
    Window.WindowStyle windowStyle = new Window.WindowStyle();
    windowStyle.background = backgroundDrawableLight;
    windowStyle.titleFont = font;
    defaultSkin.add("default",
            windowStyle);
    Label.LabelStyle labelStyle = new Label.LabelStyle();
    labelStyle.background = backgroundDrawableLight;
    labelStyle.font = font;
    defaultSkin.add("default",
            labelStyle);
    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.font = font;
    defaultSkin.add("default",
            textButtonStyle);
  }

  private static Drawable createBaseColorDrawable(Color color, boolean outlined) {
    BaseDrawable drawable = new BaseDrawable();
    Pixmap pixmap = new Pixmap(100,
            100,
            Pixmap.Format.RGBA8888);
    pixmap.setFilter(Pixmap.Filter.BiLinear);
    pixmap.setColor(Color.rgba8888(color));
    pixmap.fillRectangle(0,
            0,
            100,
            100);
    if (outlined) {
      pixmap.setColor(Color.BLACK);
      pixmap.fillRectangle(0,
              0,
              100,
              lineWidth);
      pixmap.fillRectangle(0,
              100 - lineWidth,
              100,
              lineWidth);
      pixmap.fillRectangle(0,
              0,
              lineWidth,
              100);
      pixmap.fillRectangle(100 - lineWidth,
              0,
              lineWidth,
              100);
    }
    drawable.tex = new Texture(pixmap);
    drawable.marginAmount = 0;
    return drawable;
  }

  private static Drawable createButtonDrawable(Color color) {
    ButtonDrawable drawable = new ButtonDrawable();
    Pixmap pixmap = new Pixmap(100,
            100,
            Pixmap.Format.RGBA8888);
    pixmap.setFilter(Pixmap.Filter.BiLinear);
    pixmap.setColor(Color.BLACK);
    pixmap.fillCircle(50,
            50,
            50);
    pixmap.setColor(Color.rgba8888(color));
    pixmap.fillCircle(50,
            50,
            50 - lineWidth);
    drawable.sideTexture = new Texture(pixmap,
            true);
    drawable.sideTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest,
            Texture.TextureFilter.MipMapLinearNearest);
    pixmap = new Pixmap(100,
            100,
            Pixmap.Format.RGBA8888);
    pixmap.setFilter(Pixmap.Filter.BiLinear);
    pixmap.setColor(Color.rgba8888(color));
    pixmap.fillRectangle(0,
            0,
            100,
            100);
    pixmap.setColor(Color.BLACK);
    pixmap.fillRectangle(0,
            0,
            100,
            lineWidth - 1);
    pixmap.fillRectangle(0,
            100 - (lineWidth - 1),
            100,
            lineWidth - 1);
    drawable.fillTexture = new Texture(pixmap,
            true);
    drawable.fillTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest,
            Texture.TextureFilter.MipMapLinearNearest);
    drawable.marginAmount = marginAmount;
    return drawable;
  }

  private static Drawable createTabButtonDrawable(Color color) {
    ButtonDrawable drawable = new ButtonDrawable();
    Pixmap pixmap = new Pixmap(100,
            100,
            Pixmap.Format.RGBA8888);
    pixmap.setFilter(Pixmap.Filter.BiLinear);
    pixmap.setColor(Color.BLACK);
    pixmap.fillCircle(50,
            50,
            50);
    pixmap.setColor(Color.rgba8888(color));
    pixmap.fillCircle(50,
            50,
            50 - lineWidth);
    pixmap.fillRectangle(0,
            50,
            100,
            50);
    pixmap.setColor(Color.BLACK);
    pixmap.fillRectangle(0,
            50,
            lineWidth - 1,
            50);
    pixmap.fillRectangle(0,
            100 - (lineWidth - 1),
            100,
            lineWidth - 1);
    pixmap.fillRectangle(100 - (lineWidth - 1),
            50,
            lineWidth - 1,
            50);
    drawable.sideTexture = new Texture(pixmap,
            true);
    drawable.sideTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest,
            Texture.TextureFilter.MipMapLinearNearest);
    pixmap = new Pixmap(100,
            100,
            Pixmap.Format.RGBA8888);
    pixmap.setFilter(Pixmap.Filter.BiLinear);
    pixmap.setColor(Color.rgba8888(color));
    pixmap.fillRectangle(0,
            0,
            100,
            100);
    pixmap.setColor(Color.BLACK);
    pixmap.fillRectangle(0,
            0,
            100,
            lineWidth - 1);
    pixmap.fillRectangle(0,
            100 - (lineWidth - 1),
            100,
            lineWidth - 1);
    drawable.fillTexture = new Texture(pixmap,
            true);
    drawable.fillTexture.setFilter(Texture.TextureFilter.MipMapLinearNearest,
            Texture.TextureFilter.MipMapLinearNearest);
    drawable.marginAmount = 0;
    return drawable;
  }

  public static Button createTextButton(String text) {
    return createTextButton(text,
            false);
  }

  public static Button createTextButton(String text, boolean checkable) {
    TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
    style.font = font;
    style.fontColor = new Color(0.2f,
            0.2f,
            0.2f,
            1);
    style.up = buttonUp;
    style.over = buttonOver;
    style.down = buttonDown;
    if (checkable) {
      style.checked = buttonChecked;
    }
    TextButton button = new TextButton(text,
            style);
    button.pad(marginAmount + padTop,
            marginAmount + padSide,
            marginAmount + padTop,
            marginAmount + padSide);
    return button;
  }

  public static Button createTabButton(String text, boolean checkable) {
    TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
    style.font = font;
    style.fontColor = new Color(0.2f,
            0.2f,
            0.2f,
            1);
    style.up = tabButtonUp;
    style.over = tabButtonOver;
    style.down = tabButtonDown;
    if (checkable) {
      style.checked = tabButtonChecked;
    }
    TextButton button = new TextButton(text,
            style);
    button.pad(marginAmount + padTop,
            padSide,
            padTop,
            padSide);
    return button;
  }

  public static ScrollPane createList() {
    VerticalGroup vert = new VerticalGroup();
    vert.grow();
    ScrollPane.ScrollPaneStyle style = new ScrollPane.ScrollPaneStyle();
    style.vScroll = backgroundDrawableDark;
    ScrollPane scroll = new ScrollPane(vert, style);
    scroll.setFillParent(false);
    return scroll;
  }

  public static Label createLabel(String text, boolean light, int padding) {
    return createLabel(text,
            light,
            padding,
            padding,
            padding,
            padding);
  }

  public static Label createLabel(String text, boolean light, int padTop, int padLeft, int padBottom, int padRight) {
    Label.LabelStyle style = new Label.LabelStyle();
    style.font = font;
    style.fontColor = Color.BLACK;
    if (light) {
      style.background = backgroundDrawableLight;
    } else {
      style.background = backgroundDrawableDark;
    }
    style.background.setTopHeight(padTop);
    style.background.setLeftWidth(padLeft);
    style.background.setBottomHeight(padBottom);
    style.background.setRightWidth(padRight);
    return new Label(text,
            style);
  }

  public static Dialog createDialog(Consumer<Object> func) {
    return new Dialog("", defaultSkin) {
      public void result(Object obj) {
        func.accept(obj);
      }
    };
  }

  public static Label createLabel(String text, boolean light) {
    return createLabel(text,
            light,
            2,
            5,
            2,
            5);
  }

  private static class ButtonDrawable extends BaseDrawable {
    public Texture fillTexture;
    public Texture sideTexture;
    public float marginAmount;

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
      float drawX = x + marginAmount;
      float drawY = y + marginAmount;
      float drawWidth = width - marginAmount * 2;
      float drawHeight = height - marginAmount * 2;
      batch.draw(fillTexture,
              drawX + drawHeight / 2,
              drawY,
              drawWidth - drawHeight,
              drawHeight);
      batch.draw(sideTexture,
              drawX,
              drawY,
              0,
              0,
              drawHeight / 2,
              drawHeight,
              1,
              1,
              0,
              0,
              0,
              50,
              100,
              false,
              false);
      batch.draw(sideTexture,
              drawX + drawWidth - drawHeight / 2,
              drawY,
              0,
              0,
              drawHeight / 2,
              drawHeight,
              1,
              1,
              0,
              50,
              0,
              50,
              100,
              false,
              false);
    }
  }

  private static class BaseDrawable implements Drawable {
    public Texture tex;
    public float marginAmount;
    private float minHeight;
    private float minWidth;
    private float bottomHeight;
    private float topHeight;
    private float rightWidth;
    private float leftWidth;

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
      float drawX = x + marginAmount;
      float drawY = y + marginAmount;
      float drawWidth = width - marginAmount * 2;
      float drawHeight = height - marginAmount * 2;
      batch.draw(tex,
              drawX,
              drawY,
              drawWidth,
              drawHeight);
    }

    @Override
    public float getLeftWidth() {
      return leftWidth;
    }

    @Override
    public void setLeftWidth(float leftWidth) {
      this.leftWidth = leftWidth;
    }

    @Override
    public float getRightWidth() {
      return rightWidth;
    }

    @Override
    public void setRightWidth(float rightWidth) {
      this.rightWidth = rightWidth;
    }

    @Override
    public float getTopHeight() {
      return topHeight;
    }

    @Override
    public void setTopHeight(float topHeight) {
      this.topHeight = topHeight;
    }

    @Override
    public float getBottomHeight() {
      return bottomHeight;
    }

    @Override
    public void setBottomHeight(float bottomHeight) {
      this.bottomHeight = bottomHeight;
    }

    @Override
    public float getMinWidth() {
      return minWidth;
    }

    @Override
    public void setMinWidth(float minWidth) {
      this.minWidth = minWidth;
    }

    @Override
    public float getMinHeight() {
      return minHeight;
    }

    @Override
    public void setMinHeight(float minHeight) {
      this.minHeight = minHeight;
    }
  }
}
