package me.DRIVEmaxx.WorldTeleport;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldTeleport  extends JavaPlugin {
	Logger logger = Logger.getLogger("Minecraft");
	
    public void onDisable(){
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " has Been Disabled!");
    }
 
    public void onEnable(){
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled.");
    }

}
