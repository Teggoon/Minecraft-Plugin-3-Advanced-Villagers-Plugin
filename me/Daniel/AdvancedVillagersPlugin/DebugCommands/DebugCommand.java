package me.Daniel.AdvancedVillagersPlugin.DebugCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		return false;
	}
}
