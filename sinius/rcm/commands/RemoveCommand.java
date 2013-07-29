package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import sinius.rcm.Main;

public class RemoveCommand{

	public static void Start(CommandSender sender, String name) {
		
		Boolean b =  Main.d.removePoint(name);
		if(b){
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " removed");
		}else{
			sender.sendMessage(ChatColor.RED + "Point " + name + " does not exist");
		}
		return;
	}

}