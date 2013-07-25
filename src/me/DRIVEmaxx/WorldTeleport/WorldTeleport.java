package me.DRIVEmaxx.WorldTeleport;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

    public boolean onCommand(CommandSender sender, Command cmd, String cL, String args[])
    {
    	Player player = (Player) sender;
    	
    	if(!player.hasPermission("worldteleport.port") || !player.hasPermission("worldteleport.list")){
    		player.sendMessage(ChatColor.RED + "Nemas potrebna opravneni pro tento prikaz!");
    		return true;
    	}
 
    	
        if(cmd.getName().equalsIgnoreCase("worldtp") && player.hasPermission("worldteleport.port"))
        {  


        	
        	
        	
        }
        
        if(cmd.getName().equalsIgnoreCase("worldlist") && player.hasPermission("worldteleport.list"))
        {


        	
        	
        }
        return true;
    }
}
