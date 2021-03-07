package net.javaforge.minecraft.spigot.plugin;

import net.javaforge.minecraft.spigot.plugin.enchant.Freeze;
import net.javaforge.minecraft.spigot.plugin.enchant.commands.Enchanter;
import net.javaforge.minecraft.spigot.plugin.enchant.enchants.Savior;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.projectiles.ProjectileSource;

public class NetheriteScrapPlugin extends JavaPlugin {

    private static String prefix = ChatColor.DARK_AQUA + "CrazyEnchants » " + ChatColor.GRAY;
    //  static WGCustomFlagsPlugin wg;

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

    @Deprecated
    public class DragonbogenListener implements Listener {
        @EventHandler
        public void onEvent(ProjectileHitEvent event) {
            Projectile geschoss = event.getEntity();

            if (geschoss.getType() == EntityType.DRAGON_FIREBALL) {

            }
        }
    }

    public void onEnable() {

        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new EnderbogenListener(), this);
        pluginManager.registerEvents(new DragonbogenListener(), this);

        this.getServer().addRecipe(getEnderbogenRezept());

        this.getServer().addRecipe(getShapelessRecipe());

        this.getServer().addRecipe(getEnchantedGoldenAppleRecipe());

        this.getServer().addRecipe(getBlazerodRezept());

        buildEnchants();
        enableWGCustomFlags();
        Freeze.addMain(this);

        Enchanter enchanter = new Enchanter();
        //Bukkit.getPluginCommand("enchanter").setExecutor(enchanter);
        Bukkit.getPluginManager().registerEvents(enchanter, this);
        Bukkit.getPluginManager().registerEvents(new Freeze(), this);
//        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
//        Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
//        Bukkit.getPluginManager().registerEvents(new EntityDamage(), this);
//        Bukkit.getPluginManager().registerEvents(new EnchantAdd(), this);
//        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckEnchants(), 0, 5);
    }

    private boolean enableWGCustomFlags() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WGCustomFlags");

//        if (plugin == null || !(plugin instanceof WGCustomFlagsPlugin)) {
//            getLogger().severe("CrazyEnchants couldn't load as dependency plugins were not enabled");
//            setEnabled(false);
//            return false;
//        }
//
//        wg = (WGCustomFlagsPlugin) plugin;
        return true;
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

    private ShapelessRecipe gitNetherwartRecipe() {
        ItemStack netherwartItem = new ItemStack(Material.NETHER_WART);
        ShapelessRecipe netherwartRecipe = new ShapelessRecipe(netherwartItem);
        netherwartRecipe.addIngredient(8, Material.HAY_BLOCK);
        netherwartRecipe.addIngredient(1, Material.NETHER_BRICKS);
        return netherwartRecipe;
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
    public static String getPrefix() {
        return prefix;
    }

    private void buildEnchants() {
//        new AntiLava();
//        new Blast();
//        new Blind();
//        new Combo();
//        new Confusion();
//        new Enderman();
//        new Featherweight();
        new Freeze();
//        new Guards();
//        new Glow();
//        new Haste();
//        new Humble();
//        new Jump();
//        new LifeSaver();
//        new Lightning();
//        new Lucky();
//        new LuckyOre();
//        new Overworld();
//        new Poison();
//        new Regain();
        new Savior();
//        new Speed();
//        new Strength();
//        new Sturdy();
//        new Toxic();
//        new XP();
    }

}