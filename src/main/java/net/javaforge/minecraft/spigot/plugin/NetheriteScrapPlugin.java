package net.javaforge.minecraft.spigot.plugin;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.projectiles.ProjectileSource;

public class NetheriteScrapPlugin extends JavaPlugin {

    public class EnderbogenListener implements Listener {
        @EventHandler
        public void onEvent(ProjectileHitEvent event) {
            Projectile geschoss = event.getEntity();

            if (geschoss.getType() == EntityType.ARROW) {
                ProjectileSource schuetze = geschoss.getShooter();

                if (schuetze instanceof Player) {
                    Player spieler = (Player) schuetze;
                    ItemStack gegenstand = spieler.getInventory().getItemInMainHand();
                    ItemMeta metaData = gegenstand.getItemMeta();

                    if (metaData.getDisplayName().equals("Enderbogen")) {
                        spieler.teleport(geschoss.getLocation());
                    }
                }
            }
        }
    }

    public void onEnable() {

        PluginManager pluginManager = this.getServer().getPluginManager();
        EnderbogenListener listener = new EnderbogenListener();
        pluginManager.registerEvents(listener, this);

        this.getServer().addRecipe(getEnderbogenRezept());

        this.getServer().addRecipe(getShapelessRecipe());

        this.getServer().addRecipe(getEnchantedGoldenAppleRecipe());

        this.getServer().addRecipe(getBlazerodRezept());
    }

    private ShapedRecipe getEnderbogenRezept() {
        ItemStack enderbogen = new ItemStack(Material.BOW);
        ItemMeta metaData = enderbogen.getItemMeta();
        metaData.setDisplayName("Enderbogen");
        enderbogen.setItemMeta(metaData);
        enderbogen.addUnsafeEnchantment(Enchantment.LUCK, 1);

        ShapedRecipe enderbogenRezept = new ShapedRecipe(enderbogen);
        enderbogenRezept.shape("*S/", "S*/", "*S/");
        enderbogenRezept.setIngredient('/', Material.STICK);
        enderbogenRezept.setIngredient('S', Material.STRING);
        enderbogenRezept.setIngredient('*', Material.ENDER_PEARL);
        return enderbogenRezept;
    }

    private ShapelessRecipe getShapelessRecipe() {
        ItemStack netheriteScrap = new ItemStack(Material.NETHERITE_SCRAP);
        ShapelessRecipe netheriteScrapRecipe = new ShapelessRecipe(netheriteScrap);
        netheriteScrapRecipe.addIngredient(Material.EGG);
        return netheriteScrapRecipe;
    }

    private ShapelessRecipe getEnchantedGoldenAppleRecipe() {
        ItemStack enchantedGoldenAppleItem = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ShapelessRecipe enchantedGoldenAppleRecipe = new ShapelessRecipe(enchantedGoldenAppleItem);
        enchantedGoldenAppleRecipe.addIngredient(8, Material.GOLD_BLOCK);
        enchantedGoldenAppleRecipe.addIngredient(1, Material.APPLE);
        return enchantedGoldenAppleRecipe;
    }

    private ShapelessRecipe getBlazerodRezept() {
        ItemStack blazerod = new ItemStack(Material.BLAZE_ROD);
        ShapelessRecipe blazerodRezept = new ShapelessRecipe(blazerod);
        blazerodRezept.addIngredient(Material.GOLD_INGOT);
        blazerodRezept.addIngredient(2, Material.STICK);
        return blazerodRezept;
    }

    public void onDisable() {
    }
}