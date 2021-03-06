package net.javaforge.minecraft.spigot.plugin.enchant;

import org.bukkit.ChatColor;

//Chance of an enchant appearing when you open a book.
public enum Rarity {
    SIMPLE(ChatColor.GRAY), COMMON(ChatColor.GREEN), RARE(ChatColor.BLUE), EPIC(ChatColor.YELLOW), LEGENDARY(ChatColor.GOLD);

    ChatColor rarityColor;

    Rarity(ChatColor rarityColor) {
        this.rarityColor = rarityColor;
    }

    public ChatColor getRarityColor() {
        return rarityColor == null ? ChatColor.GRAY : rarityColor; //If the enchant is null then it will return the chat color gray
    }

    public static Rarity fromString(String rarity) {
        switch(rarity.toLowerCase()) {
            case "simple": return Rarity.SIMPLE;
            case "common": return Rarity.COMMON;
            case "epic": return Rarity.EPIC;
            case "rare": return Rarity.RARE;
            case "legendary": return Rarity.LEGENDARY;
            default: return null;
        }
    }


}
