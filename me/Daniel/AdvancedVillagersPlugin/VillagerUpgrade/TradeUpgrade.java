package me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade;

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
	
	public TradeUpgrade(Master plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	
	
	public static void upgradeTrade(Villager villager) {
		villager.setProfession(Villager.Profession.ARMORER);
		villager.setVillagerLevel(2);
		villager.setVillagerExperience(20);

		Merchant merchant = (Merchant) villager;
		List<MerchantRecipe> trades = new ArrayList<MerchantRecipe>();
		for (int i = 0; i < MERCHES.length; i++) {
			MerchantRecipe recipe = new MerchantRecipe(MERCHES[i],999999);
			recipe.addIngredient(PRICES[i]);
			trades.add(recipe);
			
		}
		
		
		merchant.setRecipes(trades);
		
	}
	
	@EventHandler
	public void acquireTradeEvent(VillagerAcquireTradeEvent event) {
		Villager villager = (Villager) event.getEntity();
		upgradeTrade(villager);
	}
	
}
