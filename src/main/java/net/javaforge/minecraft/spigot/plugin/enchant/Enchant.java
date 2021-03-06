package net.javaforge.minecraft.spigot.plugin.enchant;


import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerAttackedEntity;
import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerDamaged;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Each of the plugins enchants will extend this class
public abstract class Enchant {

    //A list of all enchants in the game (mainly for looping through)
    public static List<Enchant> enchants = new ArrayList<>();

    private String name; //Enchants name
    private int maxLevel; //Enchant max level
    private Rarity rarity; //The enchants rarity
    private ItemSet[] itemSet; //Items the enchant can be applied to
    private String description; //What the enchant does
    private int chance; //The chance of the enchant activating
    private boolean isActive; //True if the enchant is always active
    private boolean stackable; //If the enchant is stackable
    private int chanceIncrease; //How much the enchantment chance increases per level


    //Runs for new enchants
    public Enchant(String name, int maxLevel, Rarity rarity, ItemSet[] itemSet, String description, int chance, int chanceIncrease) {
        this(name, maxLevel, rarity, itemSet, description, chance, chanceIncrease, false, false);
    }

    //Runs for new enchants
    public Enchant(String name, int maxLevel, Rarity rarity, ItemSet[] itemSet, String description, int chance, int chanceIncrease, boolean active) {
        this(name, maxLevel, rarity, itemSet, description, chance, chanceIncrease, active, false);
    }

    public Enchant(String name, int maxLevel, Rarity rarity, ItemSet[] itemSet, String description, int chance, int chanceIncrease, boolean active, boolean stackable) {
        //Sets variables
        this.name = name;
        this.maxLevel = maxLevel;
        this.rarity = rarity;
        this.itemSet = itemSet;
        this.description = description;
        this.chance = chance;
        this.isActive = active;
        this.stackable = stackable;
        this.chanceIncrease = chanceIncrease;

        //Adds the enchant to the enchants list
        enchants.add(this);
    }

    //Events (These will not be registered in the enchant, but will be registered in a separate class. When the enchant is found, the method will be called from here):
    
    public static Enchant getEnchantByName(String name) {
        for (Enchant enchant : enchants) {
            if (enchant.getName().equalsIgnoreCase(name)) {
                return enchant;
            }
        }
        return null;
    }

    //Returns a list of all enchants on the item given
    public static Map<Enchant, Integer> getEnchants(ItemStack... items) {
        //TODO: ADD STACKABLE COMPATIBILITY
        Map<Enchant, Integer> enchants = new HashMap<>();
        for (ItemStack item : items) {
            if (item == null) continue;
            if (item.hasItemMeta()) {
                if (!item.getItemMeta().hasLore()) continue;
                List<String> lore = item.getItemMeta().getLore();
                for (String temp : lore) {
                    String loreLine = ChatColor.stripColor(temp).split(" ")[0];
                    if (getEnchantByName(loreLine) != null) {
                        enchants.put(getEnchantByName(loreLine), Utils.romanNumeralToInt(ChatColor.stripColor(temp).split(" ")[1]));
                    }
                }
            }
        }
        if (enchants.isEmpty()) return null;
        return enchants;
    }
    
    public static Map<Enchant, Integer> getHeldEnchants(Player player) {
    	return getEnchants(player.getItemInHand());
    }
    
    public static Map<Enchant, Integer> getArmorEnchants(Player player) {
    	return getEnchants(player.getEquipment().getArmorContents());
    }

    //Gets the enchants on the players armour and currently held item
    public static Map<Enchant, Integer> getEnchantsOnPlayer(Player player) {
        return getEnchants(player.getItemInHand(), player.getInventory().getHelmet(), player.getInventory().getChestplate(), player.getInventory().getLeggings(), player.getInventory().getBoots());
    }


    //If a player is damaged, either naturally or through entities.
    public void playerDamaged(PlayerDamaged e) {
    }

    //When a player attacks an entity
    public void playerAttackedEntity(PlayerAttackedEntity e) {
    }

    //If the enchant is a tool enchant (block broken)
    public void playerBreakBlock(BlockBreakEvent e) {
    }

    //If the enchant is always active
    public void alwaysActive(Player player) {
    }

    //If an entity is killed.
    public void entityDeathEvent(EntityDeathEvent e) {
    }

    //When a projectile hits a block
    public void arrowHit(ProjectileHitEvent e) {
    }


    //Getters
    public String getName() {
        return name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public ItemSet[] getItemSet() {
        return itemSet;
    }

    public String getDescription() {
        return description;
    }

    public int getChance() {
        return chance;
    }

    public boolean isActive() {
        return isActive;
    }
    
    public boolean isStackable() {
    	return stackable;
    }


    //Setters
    public int getChanceIncrease() {
        return chanceIncrease;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

//TODO: KNOWN ISSUE: Can hit player with an item that has enchants (armor) other than a sword, and those enchants may used in a player attack event.
