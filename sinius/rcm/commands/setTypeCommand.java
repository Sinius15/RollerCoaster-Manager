package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import sinius.rcm.Main;
import sinius.rcm.RollerPoint;

public class setTypeCommand {

	public static boolean Start(CommandSender sender, String name, String type){
		RollerPoint p = Main.d.getPointByName(name);
		if(p.type == RollerPoint.EMPTY){
			sender.sendMessage(ChatColor.RED + "This point does not exist");
			return true;
		}
		
		if(type.equalsIgnoreCase("start") || type.equals("Start")){
			p.type = RollerPoint.START;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " is now a start point");
			return true;
		}
		if(type.equalsIgnoreCase("end")|| type.equals("End")){
			p.type = RollerPoint.END;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " is now a end point");
			return true;
		}
		
		return false;
	}
	
}
