package me.Daniel.AdvancedVillagersPlugin.VillagerUpgrade;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class GenerateHouse {

	public static final Material[] BLOCKTYPES = {
			Material.AIR, 					// 0
			Material.SMOOTH_QUARTZ, 		// 1
			Material.DARK_OAK_WOOD, 		// 2
			Material.GLASS, 				// 3
			Material.LANTERN,				// 4
			Material.DARK_OAK_DOOR,			// 5
			Material.BLUE_BED,				// 6
			Material.BLAST_FURNACE,			// 7
			};
	public static final int[][][] HOUSE = {
			{
				{2,1,1,1,2},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{2,1,1,1,2}
			},
			{
				{2,1,5,1,2},
				{1,0,0,0,1},
				{1,0,0,6,1},
				{1,7,0,6,1},
				{2,1,1,1,2}
			},
			{
				{2,1,0,1,2},
				{3,0,0,0,3},
				{3,0,0,0,3},
				{3,0,0,0,3},
				{2,3,3,3,2}
			},
			{
				{2,1,1,1,2},
				{1,0,0,0,1},
				{1,0,0,0,1},
				{1,0,0,0,1},
				{2,1,1,1,2}
			},
			{
				{2,1,0,1,2},
				{1,4,0,4,1},
				{1,0,0,0,1},
				{1,4,0,4,1},
				{2,1,1,1,2}
			},
			{
				{1,1,1,1,1},
				{1,2,1,2,1},
				{1,1,2,1,1},
				{1,2,1,2,1},
				{1,1,1,1,1}
			},
	}; 
	public static void buildHouse(Entity e) {
		int ex = e.getLocation().getBlockX();
		int ey = e.getLocation().getBlockY();
		int ez = e.getLocation().getBlockZ();
		System.out.println("ex: " + ex + "\n ey:" + ey + "\nez:" + ez);
		World w = e.getWorld();
		for (int y = ey - 1; y < ey + HOUSE.length - 1; y++) {
			int iy = y - ey + 1;
			int layerXLength = HOUSE[iy][0].length;  
			int layerZLength = HOUSE[iy].length;  
			for (int z = ez - layerZLength / 2; z <= ez + layerZLength/2; z++) {
				int iz = z - ez + layerZLength / 2;
				for (int x = ex - layerXLength / 2; x <= ex + layerXLength/2; x++) {
					Location buildLoc = new Location(w,x,y,z);
					System.out.println("Building block at:" + x + ", " + y + ", " + z);
					int ix = x - ex + layerXLength / 2;
					w.getBlockAt(buildLoc).setType(BLOCKTYPES[HOUSE[iy][iz][ix]]);
				}
			}
		}
	}
}
