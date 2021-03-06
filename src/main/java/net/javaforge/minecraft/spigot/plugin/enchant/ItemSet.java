package net.javaforge.minecraft.spigot.plugin.enchant;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

//Possible items an enchant can be enchanted on
public enum ItemSet {
    HELMET(Material.LEATHER_HELMET, Material.IRON_HELMET, Material.CHAINMAIL_HELMET, Material.DIAMOND_HELMET, Material.NETHERITE_HELMET),
    CHESTPLATE(Material.LEATHER_CHESTPLATE, Material.IRON_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.DIAMOND_CHESTPLATE, Material.NETHERITE_CHESTPLATE),
    LEGGINGS(Material.LEATHER_LEGGINGS, Material.IRON_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.DIAMOND_LEGGINGS, Material.NETHERITE_LEGGINGS),
    BOOTS(Material.LEATHER_BOOTS, Material.IRON_BOOTS, Material.CHAINMAIL_BOOTS, Material.DIAMOND_BOOTS, Material.NETHERITE_BOOTS),
    SWORD(Material.IRON_SWORD, Material.STONE_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD),
    BOW(Material.BOW),
    PICKAXE(Material.IRON_PICKAXE, Material.STONE_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE),
    SHOVEL(Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL),
    AXE( Material.IRON_AXE, Material.STONE_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE),
    HOE(Material.IRON_HOE, Material.STONE_HOE, Material.DIAMOND_HOE, Material.NETHERITE_HOE),
    ALL_TOOL(ItemSet.PICKAXE, ItemSet.SHOVEL, ItemSet.AXE, ItemSet.HOE),
    ALL_ARMOUR(ItemSet.HELMET, ItemSet.CHESTPLATE, ItemSet.LEGGINGS, ItemSet.BOOTS),
    ALL_WEAPON(ItemSet.SWORD, ItemSet.AXE);


    private List<Material> items = new ArrayList<>();

    ItemSet(Material... itemss) {
        for (Material item : itemss) {
            items.add(item);
        }
    }

    ItemSet(ItemSet... it) {
        for (ItemSet i : it) {
            items.addAll(i.getItems());
        }
    }

    public List<Material> getItems() {
        return items;
    }
}
