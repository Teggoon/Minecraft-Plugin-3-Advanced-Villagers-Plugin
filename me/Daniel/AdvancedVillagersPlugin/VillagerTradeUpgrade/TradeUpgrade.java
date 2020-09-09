package me.Daniel.AdvancedVillagersPlugin.VillagerTradeUpgrade;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import me.Daniel.AdvancedVillagersPlugin.Master;

public class TradeUpgrade implements Listener {
	private static Master plugin;
	
	public TradeUpgrade(Master plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	
	@EventHandler
	public void acquireTradeEvent(VillagerAcquireTradeEvent event) {
		Villager villager = (Villager) event.getEntity();
		Merchant merchant = (Merchant) villager;
		MerchantRecipe trade1 = new MerchantRecipe(new ItemStack(Material.IRON_BLOCK, 64), 64); 
		trade1.addIngredient(new ItemStack(Material.STICK, 1));
		MerchantRecipe trade2 = new MerchantRecipe(new ItemStack(Material.DIAMOND_BLOCK, 64), 64); 
		trade2.addIngredient(new ItemStack(Material.STICK, 2));
		
		List<MerchantRecipe> trades = new ArrayList<MerchantRecipe>();
		trades.add(trade1);
		trades.add(trade2);
		
		merchant.setRecipes(trades);
	}
	
}
