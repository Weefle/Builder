package net.jrbudda.builder;

import org.bukkit.block.BlockFace;

public class FaceResolver {

	public static BlockFace resolveFace(byte data) {
		
	/*	Block b = Bukkit.getServer().getWorld("world").getBlockAt(new Location(Bukkit.getServer().getWorld("world"), 1000, 1000, 1000));
		
		b.setBlockData(data);*/

		switch (data) {
		case 0:  return BlockFace.EAST;

		case 1: return BlockFace.WEST;

		case 2: return BlockFace.SOUTH;

		
		case 3: return BlockFace.NORTH;
		
		case 4:  return BlockFace.EAST;

		case 5: return BlockFace.WEST;

		case 6: return BlockFace.SOUTH;

		
		case 7: return BlockFace.NORTH;



		default:

			return BlockFace.EAST;
		}
	}
}