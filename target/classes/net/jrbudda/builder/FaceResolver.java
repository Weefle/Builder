package net.jrbudda.builder;

import org.bukkit.block.BlockFace;

public class FaceResolver {

	public static BlockFace resolveFace(EmptyBuildBlock block) {
		

		/*if(block.getMat().getItemType().toString().contains("STAIRS")) {
		
		 switch (block.getData()) {
		
		case 0:  return BlockFace.EAST;

		case 1: return BlockFace.WEST;

		case 2: return BlockFace.SOUTH;

		case 3: return BlockFace.NORTH;
		
		case 4:  return BlockFace.EAST;

		case 5: return BlockFace.WEST;

		case 6: return BlockFace.SOUTH;

		case 7: return BlockFace.NORTH;

		default: return BlockFace.EAST;
		
		}
		 
		}else*/ if(block.getMat().getItemType().toString().contains("TORCH")) {
		
		 switch (block.getData()) {
		
		case 0:  return BlockFace.UP;

		case 1: return BlockFace.EAST;

		case 2: return BlockFace.WEST;

		case 3: return BlockFace.SOUTH;
		
		case 4:  return BlockFace.NORTH;

		default: return BlockFace.UP;
		
		}
		 
		}else if(block.getMat().getItemType().toString().contains("CHEST") || block.getMat().getItemType().toString().contains("LADDER") || block.getMat().getItemType().toString().contains("FURNACE") || block.getMat().getItemType().toString().contains("BANNER")) {
			
			 switch (block.getData()) {
				
				case 0:  return BlockFace.NORTH;

				case 1: return BlockFace.NORTH;

				case 2: return BlockFace.NORTH;

				case 3: return BlockFace.SOUTH;
				
				case 4:  return BlockFace.WEST;
				
				case 5:  return BlockFace.EAST;

				default: return BlockFace.NORTH;
				
				}
			
		}/*else if(block.getMat().getItemType().toString().contains("BED")){
			
			switch (block.getData()) {
			
			case 0:  return BlockFace.SOUTH;

			case 1: return BlockFace.WEST;

			case 2: return BlockFace.NORTH;

			case 3: return BlockFace.EAST;
			
			case 8:  return BlockFace.SOUTH;

			case 9: return BlockFace.WEST;

			case 10: return BlockFace.NORTH;

			case 11: return BlockFace.EAST;

			default: return BlockFace.EAST;
			
			
		}
		}else if(block.getMat().getItemType().toString().contains("DOOR")){
			
			switch (block.getData()) {
			
			case 0:  return BlockFace.EAST;

			case 1: return BlockFace.SOUTH;

			case 2: return BlockFace.WEST;

			case 3: return BlockFace.NORTH;

			default: return BlockFace.EAST;
			
			
		}
		}*/else if(block.getMat().getItemType().toString().contains("PISTON")){
			
			switch (block.getData()) {
			
			case 0:  return BlockFace.DOWN;

			case 1: return BlockFace.UP;

			case 2: return BlockFace.NORTH;

			case 3: return BlockFace.SOUTH;
			
			case 4: return BlockFace.WEST;
			
			case 5: return BlockFace.EAST;

			default: return BlockFace.EAST;
			
			
		}
		}
		
		
		return BlockFace.EAST;
		}
	}