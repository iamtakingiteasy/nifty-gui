package de.lessvoid.nifty.render;

import java.nio.FloatBuffer;

import org.lwjgl.util.vector.Matrix4f;

import de.lessvoid.coregl.VBO;
import de.lessvoid.nifty.tools.Color;

public class RenderBuffer {
  private FloatBuffer transformData;
  private VBO transformVBO;
  private int renderCount;

  public RenderBuffer(final int count, final int size) {
    transformVBO = VBO.createDynamic(new float[count * size]);
    transformData = transformVBO.getBuffer();
  }

  public void begin() {
    transformData.rewind();
    renderCount = 0;
  }

  public int commit() {
    transformVBO.update();
    return renderCount;
  }

  public void append(final Color color, final Matrix4f local) {
    transformData.put(color.getRed());
    transformData.put(color.getGreen());
    transformData.put(color.getBlue());
    transformData.put(color.getAlpha());

    local.store(transformData);

    renderCount++;
  }

}
