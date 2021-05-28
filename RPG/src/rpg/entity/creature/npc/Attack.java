package rpg.entity.creature.npc;



import rpg.entity.Entity;
import rpg.entity.creature.Creature;

public class Attack {
    public boolean attack(Creature target, Entity attackObject, int damage)
    {
        if(target.getRectForAttack().intersects(attackObject.getRectForAttack()))
        {
            target.hurt(damage);
            return true;
        }
        return false;
    }
}
