package net.javaforge.minecraft.spigot.plugin.enchant.customevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

//Turns a EntityDamagedByEntityEvent into two events, one for the attacker, and one for the "defender"
public class PlayerDamaged {

	private Player damaged;
	private Entity attacker;
	private double damage;
	private DamageCause cause;
	
	public PlayerDamaged(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		damaged = (Player) e.getEntity();
		damage = e.getDamage();
		cause = e.getCause();
		attacker = e.getDamager();
	}
	
	public PlayerDamaged(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) return;
		damaged = (Player) e.getEntity();
		damage = e.getDamage();
		cause = e.getCause();
	}
	
	public Player getPlayer() {
		return damaged;
	}
	
	public DamageCause getCause() {
		return cause;
	}
	
	public Entity getAttacker() {
		return attacker;
	}
	
	public double getDamage() {
		return damage;
	}
}
