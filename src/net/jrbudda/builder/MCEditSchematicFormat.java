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
	
	
	
	private byte[] blockData;
	private Map<Integer, BlockData> blocks = new HashMap<>();
	private short width = 0;
	private short height = 0;
	private short length = 0;


	public BuilderSchematic load(File path, String filename) throws IOException, Exception {

		File file = new File(path,filename+".schem");

		if(!file.exists()) throw(new java.io.FileNotFoundException("File not found"));
		
		FileInputStream fis = new FileInputStream(file);
		NBTTagCompound nbt = NBTCompressedStreamTools.a(fis);

		Vector origin = new Vector();
		

		
		width = nbt.getShort("Width");
		height = nbt.getShort("Height");
		length = nbt.getShort("Length");


		try {
			int originX = nbt.getInt("WEOriginX");
			int originY = nbt.getInt("WEOriginY");
			int originZ = nbt.getInt("WEOriginZ");
			origin = new org.bukkit.util.Vector(originX, originY, originZ);
		} catch (Exception e) {
			
		}

		blockData = nbt.getByteArray("BlockData");
		





		NBTTagCompound palette = nbt.getCompound("Palette");
		
		palette.getKeys().forEach(rawState -> {
			int id = palette.getInt(rawState);
			BlockData blockData2 = Bukkit.createBlockData(rawState);
			blocks.put(id, blockData2);
		});
		

		BuilderSchematic out = new BuilderSchematic(width, height,length);
		
		  int index = 0;
	        int i = 0;
	        int value = 0;
	        int varint_length = 0;
	        while (i < blockData.length) {
	            value = 0;
	            varint_length = 0;

	            while (true) {
	                value |= (blockData[i] & 127) << (varint_length++ * 7);
	                if (varint_length > 5) {
	                    throw new RuntimeException("VarInt too big (probably corrupted data)");
	                }
	                if ((blockData[i] & 128) != 128) {
	                    i++;
	                    break;
	                }
	                i++;
	            }
	            int y = index / (width * length);
	            int z = (index % (width * length)) / width;
	            int x = (index % (width * length)) % width;
	            BlockData data = blocks.get(value);
	            EmptyBuildBlock M = null;
				

				if(data!=null) {

				
					M = new DataBuildBlock(x,y,z, data);

				}else {
					

					
					M = new EmptyBuildBlock(x,y,z);
					
				}

				out.Blocks[x][y][z] = M;

	            index++;
	        }
		

		out.Name = filename;
		out.SchematicOrigin = origin;
		fis.close();
		return out;
		
	}


}
	
