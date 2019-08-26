package net.jrbudda.builder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;


public class BuilderSchematic {
	public EmptyBuildBlock[][][] Blocks = new EmptyBuildBlock[1][1][1]; 

	public String Name = ""; 
	public Vector SchematicOrigin = null;

	public Location getSchematicOrigin(BuilderTrait Builder){	
		if (SchematicOrigin == null)return null;

		World W = Builder.getNPC().getEntity().getWorld();

		return	SchematicOrigin.clone().toLocation(W).add(dwidth/2,0,dlength/2);
	}

	public Queue<EmptyBuildBlock> CreateMarks(double i, double j, double k, int mat){
		dwidth = i;
		dlength = k;
		Queue<EmptyBuildBlock> Q = new LinkedList<EmptyBuildBlock>();
		Q.clear();
		Q.add(new DataBuildBlock(0,0,0, DataBuildBlock.convertMaterial(mat, (byte)0).getItemType().createBlockData()));
		Q.add(new DataBuildBlock((int) (i-1),0,0,DataBuildBlock.convertMaterial(mat, (byte)0).getItemType().createBlockData()));
		Q.add(new DataBuildBlock(0,0,(int)k-1,DataBuildBlock.convertMaterial(mat, (byte)0).getItemType().createBlockData()));
		Q.add(new DataBuildBlock((int)i-1,0,(int)k-1,DataBuildBlock.convertMaterial(mat, (byte)0).getItemType().createBlockData()));
		return Q;
	}


	public Location offset(EmptyBuildBlock block, Location origin){

		return new Location(origin.getWorld(),block.X - this.dwidth/2 + origin.getBlockX() + 1,block.Y - yoffset +useryoffset + origin.getBlockY()+.5,block.Z - this.dlength/2 + origin.getBlockZ() + 1 );
	}


	int yoffset = 0;
	int useryoffset = 0;

	public 	 Queue<EmptyBuildBlock> BuildQueue(Location origin, boolean ignoreLiquids, boolean ignoreAir, boolean excavate, net.jrbudda.builder.BuilderTrait.BuildPatternsXZ pattern, boolean GroupByLayer, int ylayers, int useryoffset){
		dwidth = width();
		dlength = length();
		yoffset = 0;
		this.useryoffset = useryoffset;
		Queue<EmptyBuildBlock> Q = new LinkedList<EmptyBuildBlock>();

		//clear out empty planes on the bottom.
		boolean ok =false;
		for (int tmpy = 0;tmpy< this.height();tmpy++){
			for (int tmpx = 0;tmpx< this.width();tmpx++){
				for (int tmpz = 0;tmpz< this.length();tmpz++){
					if (Bukkit.getUnsafe().toLegacy(this.Blocks[tmpx][tmpy][tmpz].getMat().getMaterial()).getId() > 0) {
						ok = true;
					}
				}
			}		
			if (ok) break;
			else yoffset++;
		}

		Queue<EmptyBuildBlock> exair = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> air = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> base = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> furniture = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> redstone = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> Liq = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> Decor = new LinkedList<EmptyBuildBlock>();
		Queue<EmptyBuildBlock> buildQ = new LinkedList<EmptyBuildBlock>();

		//	long count = 0;

		for(int y = yoffset;y<height();y+=ylayers){

			List<EmptyBuildBlock> thisLayer;
			switch (pattern){
			case linear:
				thisLayer = Util.LinearPrintLayer(y,ylayers, Blocks, false);
				break;
			case reverselinear:
				thisLayer = Util.LinearPrintLayer(y,ylayers, Blocks, true);
				break;
			case reversespiral:
				thisLayer = Util.spiralPrintLayer(y,ylayers, Blocks, true);
				break;
			case spiral:
				thisLayer = Util.spiralPrintLayer(y,ylayers, Blocks, false);
				break;
			default:
				thisLayer = Util.spiralPrintLayer(y,ylayers, Blocks, false);
				break;
			}

			//	count+=thisLayer.size();

			for(EmptyBuildBlock b:thisLayer){
				//check if it needs to be placed.
				org.bukkit.block.Block pending = origin.getWorld().getBlockAt(offset(b,origin));

				if (excavate && pending.isEmpty()==false) exair.add(new EmptyBuildBlock(b.X, b.Y, b.Z));

				if(!excavate){	//wont be nuffing there, lol
					
					/*if (Bukkit.getUnsafe().toLegacy(pending.getType()).getId() == Bukkit.getUnsafe().toLegacy(b.getMat().getMaterial()).getId() ) continue;
					else if (Bukkit.getUnsafe().toLegacy(pending.getType()).getId() == 3 && Bukkit.getUnsafe().toLegacy(b.getMat().getMaterial()).getId() ==2)  continue;*/


				}

				org.bukkit.Material m = b.getMat().getMaterial();

				if (m==null) continue;

				switch (m) {
				case AIR:
					//first
					if (!ignoreAir && !excavate) air.add(b);
					break;
				case WATER:	case LEGACY_STATIONARY_WATER:	case LAVA:	case LEGACY_STATIONARY_LAVA:
					//5th
					if (!ignoreLiquids) Liq.add(b);
					break;	
				case SAND: case GRAVEL:
					Liq.add(b);
					break;
				case TORCH:	case PAINTING:	case SNOW: 	case LEGACY_WATER_LILY: case CACTUS: case LEGACY_SUGAR_CANE_BLOCK: case PUMPKIN: case PUMPKIN_STEM: case LEGACY_PORTAL: case LEGACY_CAKE_BLOCK: case VINE: case LEGACY_NETHER_WARTS: case LEGACY_LEAVES:
				case LEGACY_SAPLING :case DEAD_BUSH: case LEGACY_WEB: case LEGACY_LONG_GRASS: case LEGACY_RED_ROSE: case LEGACY_YELLOW_FLOWER: case RED_MUSHROOM: case BROWN_MUSHROOM: case FIRE: case LEGACY_CROPS: case LEGACY_MELON_BLOCK: case MELON_STEM: case LEGACY_ENDER_PORTAL:
				case JACK_O_LANTERN: case CARROT: case POTATO: case LEGACY_SKULL: case LEGACY_CARPET:
					//very last
					Decor.add(b);
					break;
				case LEGACY_REDSTONE_TORCH_ON:	case LEGACY_REDSTONE_TORCH_OFF: case REDSTONE_WIRE: case LEGACY_REDSTONE_LAMP_OFF: case LEGACY_REDSTONE_LAMP_ON: case LEVER: case TRIPWIRE_HOOK: case TRIPWIRE: case STONE_BUTTON: case LEGACY_DIODE_BLOCK_OFF:
				case LEGACY_DIODE_BLOCK_ON: case DAYLIGHT_DETECTOR: case LEGACY_DIODE: case LEGACY_RAILS: case LEGACY_REDSTONE_COMPARATOR_ON: case LEGACY_REDSTONE_COMPARATOR_OFF: case POWERED_RAIL: case DETECTOR_RAIL: case ACTIVATOR_RAIL: case LEGACY_PISTON_BASE: 
				case LEGACY_PISTON_EXTENSION: case LEGACY_PISTON_MOVING_PIECE: case LEGACY_PISTON_STICKY_BASE: case TNT: case LEGACY_STONE_PLATE: case LEGACY_WOOD_PLATE: case GLOWSTONE:	case HOPPER: case REDSTONE_BLOCK:  case LEGACY_GOLD_PLATE: case LEGACY_IRON_PLATE:
				case LEGACY_WOOD_BUTTON: 
					//4th
					redstone.add(b);
					break;
				case FURNACE:case LEGACY_BURNING_FURNACE:	case BREWING_STAND: case CHEST: case JUKEBOX: case CAULDRON: case LEGACY_WOOD_DOOR: case LEGACY_WOODEN_DOOR: case IRON_DOOR: case LEGACY_TRAP_DOOR: case LEGACY_ENCHANTMENT_TABLE:
				case DISPENSER: case LEGACY_WORKBENCH: case LEGACY_SOIL: case LEGACY_SIGN_POST: case LEGACY_WALL_SIGN: case LADDER: case LEGACY_FENCE: case LEGACY_FENCE_GATE: case LEGACY_IRON_FENCE: case LEGACY_THIN_GLASS: case LEGACY_NETHER_FENCE: case DRAGON_EGG: case LEGACY_BED_BLOCK: case GLASS:
				case LEGACY_BIRCH_WOOD_STAIRS: case LEGACY_JUNGLE_WOOD_STAIRS: case LEGACY_WOOD_STAIRS: case LEGACY_SPRUCE_WOOD_STAIRS: case QUARTZ_STAIRS: case TRAPPED_CHEST: case ANVIL: case FLOWER_POT: 
					//3rd
					furniture.add(b);
					break;
				default:
					//second
					base.add(b);
					break;
				} 	

			}

			thisLayer.clear();

			if(GroupByLayer){
				buildQ.addAll(air);
				buildQ.addAll(base);
				buildQ.addAll(furniture);
				buildQ.addAll(redstone);
				buildQ.addAll(Liq);
				buildQ.addAll(Decor);

				air.clear();
				base.clear();
				furniture.clear();
				redstone.clear();
				Liq.clear();
				Decor.clear();		
			}	

		}


		if(!GroupByLayer){
			buildQ.addAll(air);
			buildQ.addAll(base);
			buildQ.addAll(furniture);
			buildQ.addAll(redstone);
			buildQ.addAll(Liq);
			buildQ.addAll(Decor);

			air.clear();
			base.clear();
			furniture.clear();
			redstone.clear();
			Liq.clear();
			Decor.clear();		
		}	

		java.util.Collections.reverse((List<?>) exair);

		Q.addAll(exair);
		Q.addAll(buildQ);

		exair.clear();
		buildQ.clear();

		return Q;
	}

	BuilderSchematic(int w, int h, int l){
		Blocks = new EmptyBuildBlock[w][h][l]; 
		dwidth = w;
		dlength = l;
	}

	public BuilderSchematic() {

	}

	public double dwidth, dlength;

	public int width(){
		return Blocks.length;
	}

	public int height(){
		return Blocks[0].length;
	}

	public int length(){
		return Blocks[0][0].length;
	}

	public String GetInfo(){
		return ChatColor.GREEN + "Name: "+ ChatColor.WHITE + Name + ChatColor.GREEN + " size: " + ChatColor.WHITE + width() + " wide, " + length() +  " long, " + height() + " tall"; 
	}


}


