package rpg.interact;



import rpg.entity.Entity;
import rpg.entity.creature.Creature;

public class Attack extends Interact {
    public boolean attack(Creature target, Entity source, int damage)
    {
        if(getIntersects(target, source))
        {
            if(target instanceof Creature)
            {
                target.hurt(damage);
            }
        }
        return false;

    }
}
