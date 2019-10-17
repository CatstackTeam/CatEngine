package ru.catstack.catengine.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Arrays;

public class Animation {
    private Texture animation;
    private ArrayList<TextureRegion> textures = new ArrayList<>();
    private int currentFrame = 0;
    private int frames = 0;
    private int width = 0;
    private int height = 0;
    private int frameWidth = 0;
    private int frameHeight = 0;
    private float time = 0;
    private float frameTime = 0;
    private float animationTime = 0;

    public Animation(Texture animation, int frames, int frameWidth, int frameHeight, float frameTime) {
        this.animation = animation;
        this.frames = frames;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frameTime = frameTime;

        animationTime = frameTime * frames;

        TextureRegion[][] textures = TextureRegion.split(animation, frameWidth, frameHeight);

        for (TextureRegion[] texture : textures) {
            this.textures.addAll(Arrays.asList(texture));
        }
    }

    public int getCurrentFrame() {
        int frame;

        frame = (int) (time / frameTime);

        return frame;
    }

    public void update(float delta) {
        time += delta;
        if (time > animationTime) {
            time -= animationTime;
        }
    }

    public TextureRegion getCurrentFrameRegion() {
        return textures.get(getCurrentFrame());
    }
}
