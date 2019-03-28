package org.anhcraft.spaciouslib.mojang;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.anhcraft.spaciouslib.utils.CommonUtils;
import org.anhcraft.spaciouslib.utils.Group;
import org.anhcraft.spaciouslib.utils.IOUtils;
import org.anhcraft.spaciouslib.utils.ProxyUtils;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.UUID;

/**
 * A class contains useful methods to using the Mojang API
 */
public class MojangAPI {
    /**
     * Gets the unique id of the given player
     * @param user the name of the player
     * @return the unique id
     */
    public static Group<String, UUID> getUniqueId(String user) throws Exception {
        String url = "https://api.mojang.com/users/profiles/minecraft/"+user;
        String json = IOUtils.toString(new URL(url).openStream());
        JsonObject obj = new Gson().fromJson(json, new TypeToken<JsonObject>(){}.getType());
        return new Group<>(obj.get("name").getAsString(),
                CommonUtils.getUUIDWithoutDashes(obj.get("id").getAsString()));
    }

    /**
     * Gets the unique id of the given player at a specific time.<br>
     * The time must be the UNIX timestamp (milliseconds/1000)
     * @param user the name of the player
     * @return the unique id
     */
    public static Group<String, UUID> getUniqueId(String user, long timestamp) throws Exception {
        String url = "https://api.mojang.com/users/profiles/minecraft/"+user
                +"/?at="+Long.toString(timestamp);
        String json = IOUtils.toString(new URL(url).openStream());
        JsonObject obj = new Gson().fromJson(json, new TypeToken<JsonObject>(){}.getType());
        return new Group<>(obj.get("name").getAsString(),
                CommonUtils.getUUIDWithoutDashes(obj.get("id").getAsString()));
    }


    /**
     * Gets the skin data of a player.<br>
     * SpaciousLib will use a random HTTPS proxy to bypass the limit rate.<br>
     * <b>Please use SkinAPI instead</b>
     * @param player the unique id of the player
     * @return a group of two string objects. The first is the skin value, and the second is the skin signature
     */
    public static Group<String, String> getSkin(UUID player) throws Exception {
        return getSkin(player, true);
    }

    /**
     * Gets the skin data of a player.<br>
     * <b>Please use SkinAPI instead</b>
     * @param player the unique id of the player
     * @param proxy uses a random proxy to get or not?
     * @return a group of two string objects. The first is the skin value, and the second is the skin signature
     */
    public static Group<String, String> getSkin(UUID player, boolean proxy) throws Exception {
        String url = "https://sessionserver.mojang.com/session/minecraft/profile/"+player.toString().replace("-", "")+"?unsigned=false";
        HttpURLConnection connection;
        if(proxy){
            connection = (HttpURLConnection) new URL(url).openConnection(ProxyUtils.getRandom(Proxy.Type.HTTP));
        } else {
            connection = (HttpURLConnection) new URL(url).openConnection();
        }
        connection.setConnectTimeout(3000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        connection.setRequestMethod("GET");
        String json = IOUtils.toString(connection.getInputStream());
        JsonObject obj = new Gson().fromJson(json, new TypeToken<JsonObject>(){}.getType());
        if(obj.has("properties")){
            JsonArray properties = obj.get("properties").getAsJsonArray();
            if(0 < properties.size()){
                JsonObject property = properties.get(0).getAsJsonObject();
                if(property.get("name").getAsString().equals("textures")){
                    return new Group<>(property.get("value").getAsString(),
                            property.get("signature").getAsString());
                }
            }
        }
        return null;
    }
}
