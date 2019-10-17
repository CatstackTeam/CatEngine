package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import ru.catstack.catengine.objects.TweenBehavior;

import java.util.ArrayList;

public class TweenComponent implements Component {
    public ArrayList<TweenBehavior> tweens = new ArrayList<>();
}
