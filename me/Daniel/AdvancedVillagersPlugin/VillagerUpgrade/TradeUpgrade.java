package me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

	public static ItemStack forgeItem(Material material, Enchantment[] enchants, int[] levels) {
		ItemStack item = new ItemStack(material);
		for (int i = 0; i < enchants.length; i++) {
			item.addEnchantment(enchants[i], levels[i]);
		}
		return item;
	}

	public final static Enchantment[] ARMORENCHANTS = {
			Enchantment.PROTECTION_ENVIRONMENTAL,
			Enchantment.PROTECTION_FALL,
			Enchantment.DURABILITY,
			Enchantment.MENDING,
			Enchantment.THORNS,
			Enchantment.WATER_WORKER,
			Enchantment.OXYGEN,
			Enchantment.DEPTH_STRIDER,
	};
	
	public final static int[] ARMORENCHANTLEVELS = {4,4,3,1,3,1,3,3};
	
	public final static Enchantment[] TOOLENCHANTS = {
			Enchantment.DIG_SPEED,
			Enchantment.MENDING,
			Enchantment.DURABILITY,
			Enchantment.LOOT_BONUS_BLOCKS,
			Enchantment.DAMAGE_ALL
	};
	public final static int[] TOOLENCHANTLEVELS = {5,1,3,3,5};
	
	
	
	public final static ItemStack OPSWORD = forgeItem(Material.NETHERITE_SWORD, 
					new Enchantment[]{
							Enchantment.DAMAGE_ALL, 
							Enchantment.DURABILITY, 
							Enchantment.MENDING, 
							Enchantment.LOOT_BONUS_MOBS, 
							Enchantment.SWEEPING_EDGE},
					new int[]{5,3,1,3,3});

	
	public final static ItemStack OPBOW = forgeItem(Material.BOW, 
					new Enchantment[]{
							Enchantment.ARROW_DAMAGE, 
							Enchantment.DURABILITY, 
							Enchantment.ARROW_INFINITE, 
							Enchantment.ARROW_FIRE,
							Enchantment.ARROW_KNOCKBACK,
							},
					new int[]{5,3,1,1,2});

	public final static ItemStack OPHELMET = forgeItem(Material.NETHERITE_HELMET, ARMORENCHANTS, ARMORENCHANTLEVELS); 
	public final static ItemStack OPCHESTPLATE = forgeItem(Material.NETHERITE_CHESTPLATE, ARMORENCHANTS, ARMORENCHANTLEVELS); 
	public final static ItemStack OPLEGGINGS = forgeItem(Material.NETHERITE_LEGGINGS, ARMORENCHANTS, ARMORENCHANTLEVELS); 
	public final static ItemStack OPBOOTS = forgeItem(Material.NETHERITE_BOOTS, ARMORENCHANTS, ARMORENCHANTLEVELS); 
	public final static ItemStack OPPICK = forgeItem(Material.NETHERITE_PICKAXE, TOOLENCHANTS, TOOLENCHANTLEVELS); 
	public final static ItemStack OPAXE = forgeItem(Material.NETHERITE_AXE, TOOLENCHANTS, TOOLENCHANTLEVELS); 
	public final static ItemStack OPSHOVEL = forgeItem(Material.NETHERITE_SHOVEL, TOOLENCHANTS, TOOLENCHANTLEVELS); 
	public final static ItemStack OPHOE = forgeItem(Material.NETHERITE_HOE, TOOLENCHANTS, TOOLENCHANTLEVELS); 
	
	

	public final static ItemStack[] PRICES = {
			new ItemStack(Material.STICK, 1),
			new ItemStack(Material.STICK, 2),
			new ItemStack(Material.STICK, 3),
			new ItemStack(Material.STICK, 4),
			new ItemStack(Material.STICK, 5),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
			new ItemStack(Material.STICK, 6),
	}; 
	public final static ItemStack[] MERCHES = {
			new ItemStack(Material.COAL_BLOCK, 64),
			new ItemStack(Material.IRON_BLOCK, 64),
			new ItemStack(Material.EMERALD_BLOCK, 64),
			new ItemStack(Material.DIAMOND_BLOCK, 64),
			new ItemStack(Material.NETHERITE_BLOCK, 64),
			OPHELMET,
			OPCHESTPLATE,
			OPLEGGINGS,
			OPBOOTS,
			OPSWORD,
			OPBOW,
			OPPICK,
			OPAXE,
			OPSHOVEL,
			OPHOE
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
