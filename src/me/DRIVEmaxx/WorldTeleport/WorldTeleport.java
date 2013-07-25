package me.DRIVEmaxx.WorldTeleport;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
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

        	String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        	int count = 0;
        	for(World w : Bukkit.getServer().getWorlds()){
        		worldNames[count] = w.getName();
        		count++;
        	}
        	for(String list : worldNames){
        		player.sendMessage(ChatColor.YELLOW + "Seznam svetu: ");
        		player.sendMessage(list);
        	}
        }
        return true;
    }
}
