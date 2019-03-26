package net.jrbudda.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Updater
  extends Thread
{
  private int id;
  public static boolean update = false;
  private boolean log = false;
  private boolean enabled = true;
  public static boolean enabledingame = true;
  private URL url;
  private Builder m;
  public Updater(Builder m) {
	  this.m = m;
  }
  
  public Updater(Builder plugin, int resourceID)
    throws IOException
  {
    this(plugin, resourceID, true);
  }
  
  public Updater(Builder plugin, int resourceID, boolean log)
    throws IOException
  {
    if (plugin == null) {
      throw new IllegalArgumentException("Plugin cannot be null");
    }
    if (resourceID == 0) {
      throw new IllegalArgumentException("Resource ID cannot be null (0)");
    }
    m = plugin;
    this.id = resourceID;
    this.log = log;
    this.url = new URL("https://api.inventivetalent.org/spigot/resource-simple/" + resourceID);
    
    File configDir = new File(plugin.getDataFolder().getParentFile(), "SkWaze");
    File config = new File(configDir, "config.yml");
    YamlConfiguration yamlConfig = new YamlConfiguration();
    if (!configDir.exists()) {
      configDir.mkdirs();
    }
    if (!config.exists())
    {
      config.createNewFile();
      yamlConfig.options().header("Configuration for the SkWazeUpdater system\nit will inform you about new versions of all plugins which use this updater\n'enabled' specifies whether the system is enabled (affects all plugins)");
      
      yamlConfig.options().copyDefaults(true);
      yamlConfig.addDefault("enabled", Boolean.valueOf(true));
      yamlConfig.addDefault("enabledingame", Boolean.valueOf(true));
      yamlConfig.save(config);
    }
    try
    {
      yamlConfig.load(config);
    }
    catch (InvalidConfigurationException e)
    {
      e.printStackTrace();
      return;
    }
    this.enabled = yamlConfig.getBoolean("enabled");
    enabledingame = yamlConfig.getBoolean("enabledingame");
    
    super.start();
  }
  
  public synchronized void start() {}
  
  public void run()
  {
    if (!m.isEnabled()) {
      return;
    }
    if (!this.enabled) {
      return;
    }
    if (this.log) {
      m.getLogger().info("[Updater] Searching for updates.");
    }
    HttpURLConnection connection = null;
    try
    {
      connection = (HttpURLConnection)this.url.openConnection();
      connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
      connection.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
      String content = "";
      String line = null;
      while ((line = in.readLine()) != null) {
        content = content + line;
      }
      in.close();
      
      JSONObject json = null;
      try
      {
        json = (JSONObject)new JSONParser().parse(content);
      }
      catch (ParseException e) {}
      String currentVersion = null;
      if ((json != null) && (json.containsKey("version")))
      {
        String version = (String)json.get("version");
        if ((version != null) && (!version.isEmpty())) {
          currentVersion = version;
        }
      }
      if (currentVersion == null)
      {
        if (this.log)
        {
          m.getLogger().warning("[Updater] Invalid response received.");
          m.getLogger().warning("[Updater] Either the author of this plugin has configured the updater wrong, or the API is experiencing some issues.");
        }
        return;
      }
      if (!currentVersion.equals(m.getDescription().getVersion()))
      {
        m.getLogger().info("[Updater] Found new version: " + currentVersion + "! (Your version is " + m.getDescription().getVersion() + ")");
        m.getLogger().info("[Updater] Download here: http://www.spigotmc.org/resources/" + this.id);
        update = true;
        }
    else if (this.log)
      {
        m.getLogger().info("[Updater] Plugin is up-to-date.");
      }
    }
    catch (IOException e)
    {
      if (this.log)
      {
        if (connection != null) {
          try
          {
            int code = connection.getResponseCode();
            m.getLogger().warning("[Updater] API connection returned response code " + code);
          }
          catch (IOException e1) {}
        }
        e.printStackTrace();
      }
    }
  }
}