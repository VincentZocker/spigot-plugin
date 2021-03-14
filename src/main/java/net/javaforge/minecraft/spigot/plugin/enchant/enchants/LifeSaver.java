package net.javaforge.minecraft.spigot.plugin.enchant.enchants;

import net.javaforge.minecraft.spigot.plugin.enchant.Enchant;
import net.javaforge.minecraft.spigot.plugin.enchant.ItemSet;
import net.javaforge.minecraft.spigot.plugin.enchant.Rarity;
import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerAttackedEntity;
import org.bukkit.entity.Player;

public class LifeSaver extends Enchant {

	public LifeSaver() {
		super("Life Saver", 5, Rarity.RARE, new ItemSet[]{ItemSet.SWORD}, "Chance to give your enemies' health to you", 5, 2);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof Player)) return;

		Player damager = e.getPlayerAttacker();
		Player entity = (Player) e.getAttackedEntity();
		
		if (damager.getHealth() < entity.getHealth()) { //If the damager has less health
			double damagerOriginal = damager.getHealth(); //Health to be given to the entity
			double entityOriginal = entity.getHealth(); //Health to be given to the damager
			
			damager.setHealth(entityOriginal);
			entity.setHealth(damagerOriginal);			
		}
	}
	
}
