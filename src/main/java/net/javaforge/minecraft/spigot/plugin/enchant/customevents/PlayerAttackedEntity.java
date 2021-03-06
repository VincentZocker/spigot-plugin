package net.javaforge.minecraft.spigot.plugin.enchant.customevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackedEntity {

	private Player attacker;
	private Entity attacked;
	
	private EntityDamageByEntityEvent event;
	
	public PlayerAttackedEntity(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) return;
		attacker = (Player) e.getDamager();
		attacked = e.getEntity();
		
		event = e;
	}
	
	public Player getPlayerAttacker() {
		return attacker;
	}
	
	public Entity getAttackedEntity() {
		return attacked;
	}
	
	public double getDamage() {
		return event.getDamage();
	}
	
	public void setDamage(double dam) {
		event.setDamage(dam);
	}
}
