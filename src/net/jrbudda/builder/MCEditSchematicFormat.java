package net.jrbudda.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.block.data.BlockData;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_13_R2.NBTCompressedStreamTools;
import net.minecraft.server.v1_13_R2.NBTTagCompound;



public class MCEditSchematicFormat {
	
	
	
	private static byte[] blockData;
	private static Map<Integer, BlockData> blocks = new HashMap<>();

	public static  BuilderSchematic load(File path, String filename) throws IOException, Exception {

		File file = new File(path,filename+".schem");

		if(!file.exists()) throw(new java.io.FileNotFoundException("File not found"));
		
		FileInputStream fis = new FileInputStream(file);
		NBTTagCompound nbt = NBTCompressedStreamTools.a(fis);

		Vector origin = new Vector();
		

		// Get information
		short width = nbt.getShort("Width");
		short height = nbt.getShort("Height");
		short length = nbt.getShort("Length");


		try {
			int originX = nbt.getInt("WEOriginX");
			int originY = nbt.getInt("WEOriginY");
			int originZ = nbt.getInt("WEOriginZ");
			origin = new org.bukkit.util.Vector(originX, originY, originZ);
		} catch (Exception e) {
			// No origin data
		}

		blockData = nbt.getByteArray("BlockData");





		NBTTagCompound palette = nbt.getCompound("Palette");
		
		palette.getKeys().forEach(rawState -> {
			int id = palette.getInt(rawState);
			BlockData blockData2 = Bukkit.createBlockData(rawState);
			blocks.put(id, blockData2);
		});


		
		

		BuilderSchematic out = new BuilderSchematic(width, height,length);
		

		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				for (int z = 0; z < length; ++z) {
					int index = y * width * length + z * width + x;
					
					BlockData data = blocks.get((int) blockData[index]);
					

					EmptyBuildBlock M = null;
					

					if(data!=null) {

					
						M = new DataBuildBlock(x,y,z, data);
					}else {
						
						M = new EmptyBuildBlock(x,y,z);
						
					}

					out.Blocks[x][y][z] = M;
				}
			}
		}
		out.Name = filename;
		out.SchematicOrigin = origin;
		fis.close();
		return out;
		
	}


}
	
