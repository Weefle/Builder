package net.jrbudda.builder;

import java.util.EnumSet;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;

import net.citizensnpcs.api.jnbt.Tag;

//Todo, add extended data.
class EmptyBuildBlock{
	public int X, Y, Z;
	EmptyBuildBlock(){
	}

	EmptyBuildBlock(int x, int y, int z){
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	public BlockData getMat(){
		return new MaterialData(Material.AIR).getItemType().createBlockData();
	}

}

class DataBuildBlock extends EmptyBuildBlock{
	private BlockData data;
	
	DataBuildBlock(int x, int y, int z, BlockData data){
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.data = data;
		//this.newdata = data;
	}
	
	@Override
	public BlockData getMat(){
		return data;
	}

	
	public static MaterialData convertMaterial(int ID, byte Data) {
	    for(Material i : EnumSet.allOf(Material.class)) if(Bukkit.getUnsafe().toLegacy(i).getId() == ID) return new MaterialData(Bukkit.getUnsafe().fromLegacy(new MaterialData(Bukkit.getUnsafe().toLegacy(i), Data)));
	    return new MaterialData(Material.AIR);
	}
	
}

class TileBuildBlock extends DataBuildBlock{
	
	TileBuildBlock(int x, int y, int z, BlockData data) {
		super(x, y, z, data);
	}

	public  Map<String, Tag> tiles = null;
	
}

