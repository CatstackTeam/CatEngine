package ru.catstack.catengine.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.catstack.catengine.assets.Textures;
import ru.catstack.catengine.ecs.World;
import ru.catstack.catengine.ecs.components.*;
import ru.catstack.catengine.objects.tween.FadeTween;
import ru.catstack.catengine.objects.tween.MovingTween;

import java.util.Random;

public class MainGame {
    public void create(SpriteBatch batch) {

        Runnable action = new Runnable() {
            @Override
            public void run() {
                System.out.println(new Random().nextInt(100));
            }
        };

        Entity entity = World.createEntity();
        entity.add(new TransformComponent());
        entity.add(new ParentComponent());
        entity.add(new BoundsComponent());
        entity.add(new BoundsToTextureComponent());
        entity.add(new TextureComponent(Textures.RBUTTON1.get()));
        entity.add(new TweenComponent());
        entity.add(new RoundButtonComponent(Textures.RBUTTON1.get(), Textures.RBUTTON2.get(), action, 100));

        entity.getComponent(TransformComponent.class).position.set(-500, 0, 0);
        entity.getComponent(TweenComponent.class).tweens.add(new FadeTween(true, 2f));
        entity.getComponent(TweenComponent.class).tweens.add(new MovingTween(0, 0, 2f));
    }

    float time = 0;
    public void update(float delta) {
        time += delta;
        if (time > 1) {
            time -= 1;
            Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond()+"");
        }
    }
}
