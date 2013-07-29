package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand {

	public static void Start(CommandSender sender){
		String[] s = new String[8];
		
		s[0] = ChatColor.YELLOW + "Commands:";
		s[1] = ChatColor.YELLOW + "/rcm add [start/end] [name]";
		s[2] = ChatColor.YELLOW + "/rcm remove [name]";
		s[3] = ChatColor.YELLOW + "/rcm start [name]";
		s[4] = ChatColor.YELLOW + "/rcm list";
		s[5] = ChatColor.YELLOW + "/rcm setCart [name] [minecart/ chestCart/ furnaceCart/ tntCart/ hopperCart]";
		s[6] = ChatColor.YELLOW + "/rcm setType [name] [start/end]";
		s[7] = ChatColor.YELLOW + "/rcm teleport [name] [player]";
		sender.sendMessage(s);
	}
	
}
