package me.DRIVEmaxx.WorldTeleport;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
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
    	Server server = player.getServer();
    	
    	if(!player.hasPermission("worldteleport.port") || !player.hasPermission("worldteleport.list")){
    		player.sendMessage(ChatColor.RED + "Nemas potrebna opravneni pro tento prikaz!");
    		return true;
    	}
 
    	
        if(cmd.getName().equalsIgnoreCase("worldtp") && args.length==1 && player.hasPermission("worldteleport.port"))
        {
        	World world = server.getWorld(args[0]);
        	if (world == null)
        		player.sendMessage(ChatColor.YELLOW + "Tento svet neexistuje pro seznam svetu pouzi" + ChatColor.RED + " /worldlist");
        	
       		if (world != null)
       			player.teleport(world.getSpawnLocation());   
       			
       		return true;      			
        }
        
        if(cmd.getName().equalsIgnoreCase("worldlist") && player.hasPermission("worldteleport.list"))
        {
        	String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        	int count = 0;
        	for(World w : Bukkit.getServer().getWorlds()){
        		worldNames[count] = w.getName();
        		count++;
        	}
    		player.sendMessage(ChatColor.YELLOW + "Seznam svetu: ");
        	for(String list : worldNames){
        		player.sendMessage(list);
        	}
        }
        return true;
    }
}
