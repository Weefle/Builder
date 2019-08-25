package org.anhcraft.spaciouslib.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;

public class UpdateChecker {
    /**
     * Using Spiget to get the latest version number
     * @param resourceId the id of the resource on spigotmc.org
     * @return the latest version number
     */
    public static String viaSpiget(String resourceId) throws IOException {
        return new Gson().fromJson(IOUtils.toString(new URL("https://api.spiget.org/v2/resources/"+resourceId+"/versions?size=1&sort=-releaseDate&fields=name")), JsonArray.class).get(0).getAsJsonObject().getAsJsonPrimitive("name").getAsString();
    }

    /**
     * Using Spiget to get the latest version details
     * @param resourceId the id of the resource on spigotmc.org
     * @param fields list of fields, separated by commas (more info: https://spiget.org/documentation/#!/resources/get_resources_resource_versions)
     * @return the latest version number
     */
    public static JsonObject viaSpiget(String resourceId, String fields) throws IOException {
        return new Gson().fromJson(IOUtils.toString(new URL("https://api.spiget.org/v2/resources/"+resourceId+"/versions?size=1&sort=-releaseDate&fields="+fields)), JsonArray.class).get(0).getAsJsonObject();
    }

    /**
     * Predict whether the current version is the latest one or not.<br>
     * If the current version is in development, this method still believes that it is latest
     * @param currentVersion the current version
     * @param releasedVersion the released version
     * @return true if yes
     */
    public static boolean predictLatest(String currentVersion, String releasedVersion) {
        return currentVersion.chars().sum() >= releasedVersion.chars().sum();
    }
}
