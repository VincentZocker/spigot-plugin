package net.javaforge.minecraft.spigot.plugin.enchant;

import net.javaforge.minecraft.spigot.plugin.NetheriteScrapPlugin;
import net.javaforge.minecraft.spigot.plugin.enchant.customevents.PlayerAttackedEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

public class Freeze extends Enchant implements Listener {

	private static NetheriteScrapPlugin main; //Instance of the main class, used for creating schedulers
	private static ArrayList<UUID> frozenPlayers = new ArrayList<UUID>(); //List of frozen players
	
	public Freeze() {
		super("Freeze", 3, Rarity.RARE, new ItemSet[]{ItemSet.SWORD}, "Chance to make the enemy not able to move", 3, 3);
	}
	
	@Override
	public void playerAttackedEntity(PlayerAttackedEntity e) {
		if (!(e.getAttackedEntity() instanceof Player)) return;
		Player damager = e.getPlayerAttacker();
		Player entity = (Player) e.getAttackedEntity();
		
		int level = Enchant.getHeldEnchants(damager).get(this);
		
		frozenPlayers.add(entity.getUniqueId()); //Set the player to be frozen
		new BukkitRunnable() {
			@Override
			public void run() {
				frozenPlayers.remove(entity.getUniqueId()); //Remove player from the frozen list afte X time
			}
		}.runTaskLater(main, 20L *level);//1 Second per extra level
	}

	@EventHandler
	public void playerMove(PlayerMoveEvent e) {
		if (frozenPlayers.contains(e.getPlayer().getUniqueId())) e.setCancelled(true); //Don't allow the player to move if they are frozen.
	}
	
	public static void addMain(NetheriteScrapPlugin mainClass) {
		main = mainClass;
	}
}
