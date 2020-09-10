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
import me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade.TradeUpgrade;
import me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade.GenerateHouse;

/**
 * Class that helps do the basic debug commands
 * @author Haocheng Li / Daniel
 * @version 0.9	
 * @since 2020-9-8
 * */
public class DebugCommand implements CommandExecutor {

	private static Master plugin;

	public final static ItemStack[] PRICES = {
			new ItemStack(Material.STICK, 1),
			new ItemStack(Material.STICK, 2),
			new ItemStack(Material.STICK, 3),
			new ItemStack(Material.STICK, 4),
			new ItemStack(Material.STICK, 5),
			new ItemStack(Material.STICK, 5),
	}; 
	public final static ItemStack[] MERCHES = {
			new ItemStack(Material.COAL_BLOCK, 64),
			new ItemStack(Material.IRON_BLOCK, 64),
			new ItemStack(Material.EMERALD_BLOCK, 64),
			new ItemStack(Material.DIAMOND_BLOCK, 64),
			new ItemStack(Material.NETHERITE_BLOCK, 64),
			new ItemStack(Material.EXPERIENCE_BOTTLE, 64)
	}; 
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
		
		// connect "block" to this class
		plugin.getCommand("house").setExecutor(this);
		
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

		// check if command is hello
		if (label.equalsIgnoreCase("house")) {
			// check if command came from player, not console
			if (sender instanceof Player) {
				//
				Player p = (Player) sender;
				Entity ent = (Entity) p;
				GenerateHouse.buildHouse(ent);
				
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
				
				TradeUpgrade.upgradeTrade(villager);
				
				return true;
			} 
		}
		return false;
	}
}
