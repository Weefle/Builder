package net.jrbudda.builder;

import java.util.EnumSet;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import net.citizensnpcs.api.jnbt.Tag;

//Todo, add extended data.
class EmptyBuildBlock{
	public int X, Y, Z;
	EmptyBuildBlock(){
	}
	public byte getData() {
		// TODO Auto-generated method stub
		return 0;
	}
	EmptyBuildBlock(int x, int y, int z){
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	public MaterialData getMat(){
		return Util.Air;
	}

}

class DataBuildBlock extends EmptyBuildBlock{
	private MaterialData mat;
	private byte newdata;
	
	DataBuildBlock(int x, int y, int z, int id, byte data){
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.mat = convertMaterial(id, data);
		this.newdata = data;
	}
	
	@Override
	public MaterialData getMat(){
		return mat;
	}
	
	@Override
	public byte getData(){
		return newdata;
	}
	
	public static MaterialData convertMaterial(int ID, byte Data) {
	    for(Material i : EnumSet.allOf(Material.class)) if(i.getId() == ID) return new MaterialData(Bukkit.getUnsafe().fromLegacy(new MaterialData(i, Data)));
	    return new MaterialData(Material.AIR);
	}
	
}

class TileBuildBlock extends DataBuildBlock{
	
	TileBuildBlock(int x, int y, int z, int id, byte data) {
		super(x, y, z, id, data);
	}

	public  Map<String, Tag> tiles = null;
	
}

