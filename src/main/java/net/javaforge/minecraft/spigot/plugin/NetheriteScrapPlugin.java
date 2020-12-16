package net.javaforge.minecraft.spigot.plugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class NetheriteScrapPlugin extends JavaPlugin {
    public void onEnable() {
        ItemStack blume = new ItemStack(Material.NETHERITE_SCRAP);
        ShapelessRecipe blumeRezept = new ShapelessRecipe(blume);
        blumeRezept.addIngredient(Material.EGG);
        this.getServer().addRecipe(blumeRezept);
    }

    public void onDisable() {
    }
}