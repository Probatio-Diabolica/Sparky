package com.SPARKY.sparky.Entity.Spawner;

import com.SPARKY.sparky.Entity.Particle.Particle;
import com.SPARKY.sparky.Stage.BaseLevel;

public class ParticleSpawner extends EntitySpawner{
    private int life;
    public ParticleSpawner(int x, int y,int life ,int amt, BaseLevel level) {
        super(x, y, Type.PARTICLE, amt, level);
        this.life=life;
        for(int i=0;i<amt;i++){
            level.add(new Particle(x, y, life));
        }
        
    }

}
