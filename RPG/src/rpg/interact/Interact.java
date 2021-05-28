package rpg.interact;

import rpg.entity.Entity;

public class Interact {
    
    public boolean getIntersects(Entity target, Entity source)
    {
        if(target.getRectForAttack().intersects(source.getRectForAttack()))
        {
            return true;
        }
        return false;

    }
}
