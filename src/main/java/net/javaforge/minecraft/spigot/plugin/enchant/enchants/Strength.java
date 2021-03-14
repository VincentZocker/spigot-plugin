package net.javaforge.minecraft.spigot.plugin.enchant.enchants;

import net.javaforge.minecraft.spigot.plugin.enchant.Enchant;
import net.javaforge.minecraft.spigot.plugin.enchant.ItemSet;
import net.javaforge.minecraft.spigot.plugin.enchant.Rarity;
import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerAttackedEntity;

public class Strength extends Enchant {

	public Strength() {
		super("Strength", 3, Rarity.COMMON, new ItemSet[]{ItemSet.ALL_ARMOUR}, "Chance to do more damage", 50, 10, false, true);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		e.setDamage(e.getDamage() * 2.0);
	}
}
