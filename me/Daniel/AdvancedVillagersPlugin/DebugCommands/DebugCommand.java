package me.Daniel.AdvancedVillagersPlugin.DebugCommands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Daniel.AdvancedVillagersPlugin.Master;

/**
 * Class that helps do the basic debug commands
 * @author Haocheng Li / Daniel
 * @version 0.9	
 * @since 2020-9-8
 * */
public class DebugCommand implements CommandExecutor {

	private static Master plugin;
	

	/**
	 * Constructor
	 * @param parent class object
	 * */
	public DebugCommand(Master plugin) {
		this.plugin = plugin;

		// connect "hello" to this class
		plugin.getCommand("hello").setExecutor(this);
		
		// connect "villager" to this class
		plugin.getCommand("villager").setExecutor(this);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// check if command is hello
		if (label.equalsIgnoreCase("hello")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				//
				Player p = (Player) sender;
				p.sendMessage("Hello there!");
				
				return true;
			} 
		}
		

		// check if command is villager
		if (label.equalsIgnoreCase("villager")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage("Villager spawned!");
				Villager villager = (Villager) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.VILLAGER);
				LivingEntity villagerLE = (LivingEntity) villager;
				villagerLE.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
				PotionEffect regen = new PotionEffect(PotionEffectType.HEALTH_BOOST, 90000, 2);
				villager.addPotionEffect(regen);
				return true;
			} 
		}
		return false;
	}
}
