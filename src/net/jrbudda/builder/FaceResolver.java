package net.jrbudda.builder;

import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.material.MaterialData;

public class FaceResolver {
	
	public static BlockFace resolveFace(MaterialData material) {
		
		
		BlockData block = material.getItemType().createBlockData();
		
		Directional direction = (Directional) block;
		
		switch (material.getData()) {
		case 1:  return BlockFace.EAST;
			
			
		case 2: 
			
			

		default:
			
			return null;
		}
		
		
	}

}
