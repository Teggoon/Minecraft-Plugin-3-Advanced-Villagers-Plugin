package me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade;


import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import me.Daniel.AdvancedVillagersPlugin.Master;

public class CombatUpgrade implements Listener {
	private static Master plugin;

	
	public CombatUpgrade(Master plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	
	@EventHandler
	public void targetedEvent(EntityTargetEvent event) {
		/*if (event.getTarget() instanceof Villager) {
			Villager villager = (Villager) event.getTarget();
			
		}
		*/
	}
	
}