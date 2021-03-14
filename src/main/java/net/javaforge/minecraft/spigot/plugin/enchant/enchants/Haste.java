package net.javaforge.minecraft.spigot.plugin.enchant.enchants;

import net.javaforge.minecraft.spigot.plugin.enchant.Enchant;
import net.javaforge.minecraft.spigot.plugin.enchant.ItemSet;
import net.javaforge.minecraft.spigot.plugin.enchant.Rarity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Haste extends Enchant {

    public Haste() {
        super("Haste", 3, Rarity.SIMPLE, new ItemSet[]{ItemSet.ALL_TOOL}, "Gives the haste effect to the player", 100, 0, true);
    }

    @Override
    public void alwaysActive(Player player) {
        PotionEffect haste = new PotionEffect(PotionEffectType.FAST_DIGGING, 60, Enchant.getEnchantsOnPlayer(player).get(this)-1);
        player.addPotionEffect(haste);
    }

}
