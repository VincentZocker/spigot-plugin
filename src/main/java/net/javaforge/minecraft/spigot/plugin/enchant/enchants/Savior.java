package net.javaforge.minecraft.spigot.plugin.enchant.enchants;

import net.javaforge.minecraft.spigot.plugin.enchant.Enchant;
import net.javaforge.minecraft.spigot.plugin.enchant.ItemSet;
import net.javaforge.minecraft.spigot.plugin.enchant.Rarity;
import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerDamaged;
import org.bukkit.entity.Player;

public class Savior extends Enchant {

	public Savior() {
		super("Savior", 4, Rarity.LEGENDARY, new ItemSet[]{ItemSet.HELMET}, "Chance to heal when low on health", 10, 5, false, true);

	}
	
	@Override
	public void playerDamaged(PlayerDamaged e) {
		Player pl = e.getPlayer();
		
		if (pl.getHealth()/pl.getMaxHealth() <= .20) { //Less than 20% health remaining, <= 2 full hearts.
			pl.setHealth(pl.getMaxHealth());
		}
	}
}
