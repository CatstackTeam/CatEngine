package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import ru.catstack.catengine.objects.Animation;

public class AnimationComponent implements Component {
    public Animation animation;

    public AnimationComponent(Animation animation) {
        this.animation = animation;
    }
}
