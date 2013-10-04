package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import sinius.rcm.Main;
import sinius.rcm.RollerPoint;

public class AddCommand{

	public static boolean Start(CommandSender sender, String type, String name) {
		if(!(sender instanceof Player)){
			return false;
		}
		
		Player who = (Player) sender;
		Block b = who.getTargetBlock(null, 100);
	
		Location loc = b.getLocation();
		
		if(type.equalsIgnoreCase("start")){
			Boolean c = Main.d.addPoint(loc, name, RollerPoint.START);
			if(c){
				sender.sendMessage(ChatColor.YELLOW + "Point " + name + " added");
			}else{
				sender.sendMessage(ChatColor.RED + "The name " + name + " is already in use.");
			}
			return true;
		}
		if(type.equalsIgnoreCase("end")){
			Boolean c = Main.d.addPoint(loc, name, RollerPoint.END);
			if(c){
				sender.sendMessage(ChatColor.YELLOW + "Point " + name + " added");
			}else{
				sender.sendMessage(ChatColor.RED + "The name " + name + " is already in use.");
			}
			return true;
		}
		return false;
	}
	
	public static Block getTargetBlock(Player player, int range) {
	    Location loc = player.getEyeLocation();
	    Vector dir = loc.getDirection().normalize();
	    Block b = null;
	    for (int i = 0; i <= range; i++) {
	        b = loc.add(dir).getBlock();
	    }
	 
	    return b;
	}

}


