package ru.catstack.catengine.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

import java.util.ArrayList;

public class ParentComponent implements Component {
    public Entity parent = null;
    public ArrayList<Entity> children = new ArrayList<>();

    public ParentComponent() {}

    public ParentComponent(Entity parent) {
        this.parent = parent;
//        CatMappers.parent.get(parent).children.add(child);
    }
}
