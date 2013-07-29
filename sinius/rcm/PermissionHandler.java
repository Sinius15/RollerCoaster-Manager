package sinius.rcm;

import org.bukkit.command.CommandSender;

public class PermissionHandler {

	public static boolean check(CommandSender sender, String command){
		if(sender.hasPermission("rcm.*") || command.equalsIgnoreCase("help")){
			return true;
		}
		
		for(int i = 0; i< CommandHandler.commands.length; i++){
			if(CommandHandler.commands[i].equalsIgnoreCase(command)){
				if(sender.hasPermission("rcm." + CommandHandler.commands[i])){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean doesCommandExist(String command){
		for(int i = 0; i< CommandHandler.commands.length; i++){
			if(CommandHandler.commands[i].equalsIgnoreCase(command)){
				return true;
			}
		}
		return false;
	}
	
}
