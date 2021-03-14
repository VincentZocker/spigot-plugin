package net.javaforge.minecraft.spigot.plugin.enchant.enchants;

import net.javaforge.minecraft.spigot.plugin.enchant.Enchant;
import net.javaforge.minecraft.spigot.plugin.enchant.ItemSet;
import net.javaforge.minecraft.spigot.plugin.enchant.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creature;
import org.bukkit.event.entity.EntityDeathEvent;

public class XP extends Enchant {
    public XP() {
        super("XP", 4, Rarity.COMMON, new ItemSet[]{ItemSet.SWORD}, "Gives the player more experience points when killing a mob", 100, 0, false);
    }

    @Override
    public void entityDeathEvent(EntityDeathEvent e) {
        //If the entity killed is a mob (Not a player or another entity such as experience)
        Bukkit.broadcastMessage("" + (e.getEntity() instanceof Creature));
        if(e.getEntity() instanceof Creature) {
            e.setDroppedExp(e.getDroppedExp() + e.getDroppedExp()*(Enchant.getHeldEnchants(e.getEntity().getKiller()).get(this)/2));
        }
        
    }

}
