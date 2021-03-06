package net.javaforge.minecraft.spigot.plugin.enchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    //Converts the given integer into a roman numeral
    public static String intToRomanNumeral(int i) {
        //Max level is 10 so I may as well do it manually. If you (ipodtouch0218) can find a better way then go ahead :)
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
        }
        return Integer.toString(i);
    }

    //Converts the given roman numeral to a integer
    public static int romanNumeralToInt(String i) {
        //Max level is 10 so I may as well do it manually. If you (ipodtouch0218) can find a better way then go ahead :)
        switch (i.toUpperCase()) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        return 0;
    }

    //Splits the string into multiple lines so the lore isn't too long (Retains ChatColor)
    public static List<String> loreLineFormat(String string, ChatColor color) {
        List<String> newString = new ArrayList<>();
        while(string.contains(" ")) {
            StringBuilder sb = new StringBuilder();
            for(String a :string.split(" ", 4)) {
                sb.append(color + a + " ");
            }
            newString.add(sb.toString().trim());
            string = string.split(" ", 5)[string.split(" ", 5).length-1];
        }

        return newString;
    }

    //Mainly for enumerations. Turn all caps message into 1 cap beginning
    public static String camelCase(String string) {
        Character beginning = string.charAt(0);
        return beginning.toString().toUpperCase() + string.split(beginning.toString(), 2)[1].toLowerCase();
    }


    //Used instead of setting each item's meta/name separately
    public static ItemStack createItem(ItemStack inputStack, String customName, String[] lore) {
        ItemMeta itemMeta = inputStack.getItemMeta();
        if (customName != null) {
            itemMeta.setDisplayName(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', customName));
        }
        if (lore != null) {
            ArrayList<String> newLore = new ArrayList<>();
            for (String loreLine : lore) {
                newLore.add(ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', loreLine));
            }
            itemMeta.setLore(newLore);
        }
        inputStack.setItemMeta(itemMeta);
        return inputStack;
    }


    //More convinient as an ItemStack doesn't have to be initialised first
    public static ItemStack createItem(Material inputMaterial, String customName, String[] lore) {
        return createItem(new ItemStack(inputMaterial, 1), customName, lore);
    }

    public static Object pickRandom(Object... objects) {
        if(objects.length == 0) return null;
        return objects[new Random().nextInt(objects.length)];
    }

}
