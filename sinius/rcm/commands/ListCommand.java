package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import sinius.rcm.Main;
import sinius.rcm.RollerPoint;

public class ListCommand{

	public static void Start(CommandSender sender) {
		if(Main.d.points.size() == 0){
			sender.sendMessage(ChatColor.RED + "There are no Roller coaster points defined.");
			return;
		}
		String s = "";
		for(RollerPoint p : Main.d.points){
			s = s + p.name + ", ";
		}
		s = s.substring(0, s.length()-2);
		s = ChatColor.YELLOW + s;
		sender.sendMessage(s);
		return;
	}

}
