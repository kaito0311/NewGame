package rpg.entity.items;


import java.util.LinkedList;
import java.util.List;

import rpg.api.Animation;
import rpg.entity.Entity;
import rpg.entity.creature.Player;
import rpg.game.Game;
import rpg.interact.Attack;
import rpg.interact.Interact;

public class ManageItems
{
    private BuffHP bottleHP;
    private BuffDamage bottleDamage;

    private List<Item> listItems; 
    private Game game;
    public ManageItems(Game game)
    {
        bottleHP = new BuffHP(game, 0, 0, 16, 16);
        bottleDamage = new BuffDamage(game, 0, 0, 16, 16);
        listItems = new LinkedList<>();
        listItems.add(bottleHP);
        listItems.add(bottleDamage);
    }

    public Item getItem(int id)
    {
        return listItems.get(id);
    }
    public int getSizeListItems()
    {
        return listItems.size();
    }
}