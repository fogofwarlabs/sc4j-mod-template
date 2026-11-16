package com.example.mymod;

import org.fogofwarlabs.sc4j.engine.client.app.ClientScene;
import org.fogofwarlabs.sc4j.engine.client.app.SceneClient;
import org.fogofwarlabs.sc4j.engine.client.input.InputEvent;
import org.fogofwarlabs.sc4j.engine.client.input.Key;
import org.fogofwarlabs.sc4j.engine.client.render.Canvas;

/**
 * The first screen: one colour (0xAARRGGBB) with a square in the middle; Escape ends the run.
 */
final class FirstScene implements ClientScene {
    private static final int BACKGROUND = 0xFF204060;
    private static final int SQUARE = 0xFFE0A030;
    private static final float SQUARE_SIZE = 128;

    private final SceneClient client;

    FirstScene(SceneClient client) {
        this.client = client;
    }

    @Override
    public void open(SceneClient context) {
    }

    @Override
    public void update(long time) {
    }

    @Override
    public void draw(Canvas surface) {
        float x = (surface.getWidth() - SQUARE_SIZE) / 2;
        float y = (surface.getHeight() - SQUARE_SIZE) / 2;

        surface.fillRectangle(0, 0, surface.getWidth(), surface.getHeight(), BACKGROUND);
        surface.fillRectangle(x, y, SQUARE_SIZE, SQUARE_SIZE, SQUARE);
    }

    @Override
    public boolean handleInput(InputEvent event) {
        if (event.getType() == InputEvent.Type.KEY_PRESSED && event.getKey() == Key.ESCAPE) {
            this.client.requestQuit();

            return true;
        }

        return false;
    }

    @Override
    public void close() {
    }
}
