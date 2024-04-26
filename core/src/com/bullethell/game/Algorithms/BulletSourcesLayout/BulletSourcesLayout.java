package com.bullethell.game.Algorithms.BulletSoucesLayout;

import com.bullethell.game.entities.bullet.BulletSource;
import com.bullethell.game.entities.Enemy.Enemy;

import java.util.List;

public abstract class BulletSourcesLayout {
    protected Enemy enemy;
    protected List<BulletSource> sources;

    public BulletSourcesLayout(Enemy enemy, List<BulletSource> sources)
    {
        this.enemy = enemy;
        this.sources = sources;
    }
    public abstract void applyLayout();

    public abstract void update(float delta);
}
