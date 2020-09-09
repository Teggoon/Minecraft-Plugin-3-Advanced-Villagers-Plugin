package me.Daniel.AdvancedVillagersPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.Daniel.AdvancedVillagersPlugin.DebugCommands.DebugCommand;
import me.Daniel.AdvancedVillagersPlugin.VillagerTradeUpgrade.TradeUpgrade;


public class Master extends JavaPlugin {

	@Override
	public void onEnable() {
		// runs on startups, reloads, plugin reloads

		// Connect different event handlers to the parent class

		// Connecting debug command
		new DebugCommand(this);
		new TradeUpgrade(this);
	}
}
