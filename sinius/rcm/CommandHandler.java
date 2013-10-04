package sinius.rcm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sinius.rcm.commands.AddCommand;
import sinius.rcm.commands.HelpCommand;
import sinius.rcm.commands.ListCommand;
import sinius.rcm.commands.RemoveCommand;
import sinius.rcm.commands.StartCommand;
import sinius.rcm.commands.setCartCommand;
import sinius.rcm.commands.setTypeCommand;

public class CommandHandler implements CommandExecutor {

	public static String[] commands = new String[]{
		"add",
		"remove",
		"start",
		"list",
		"setCart",
		"setType",
		"teleport",
		"help",
		"setSpeed"
	};
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "Do /rcm help for all teh avalable commands.1");
		}
		if(!PermissionHandler.doesCommandExist(args[0])){
			sender.sendMessage(ChatColor.RED + "Do /rcm help for all the avalable commands.2");
			return true;
		}
		
		if(!PermissionHandler.check(sender, args[0])){
			sender.sendMessage(ChatColor.RED + "You have not enough permissions for this command.");
			return true;
		}
		
		if(args.equals(null) || args.length == 0){
			sender.sendMessage(ChatColor.RED + "Do /rcm help for all the avalable commands.");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("add")){
			if(args.length != 3){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm add [start/end] [name]");
			}
			else if(!AddCommand.Start(sender, args[1], args[2])){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm add [start/end] [name]");
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("list")){
			ListCommand.Start(sender);
			return true;
		}
		else if(args[0].equalsIgnoreCase("remove")){
			if(args.length != 2){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm remove [name]");
			}else{
				RemoveCommand.Start(sender, args[1]);
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("start")){
			if(args.length != 2){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm start [name]");
			}else{
				StartCommand.Start(sender, args[1]);
			}
			return true;
		}
		else if(args[0].equalsIgnoreCase("help")){
			HelpCommand.Start(sender);
			return true;
		}
		
		else if(args[0].equalsIgnoreCase("setCart")){
			if(args.length !=3){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm setCart [name] [minecart/ chestCart/ furnaceCart/ tntCart/ hopperCart]");
				return true;
			}
			if(!setCartCommand.Start(sender, args[1], args[2])){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm setCart [name] [minecart/ chestCart/ furnaceCart/ tntCart/ hopperCart]");
				return true;
			}
			return true;
		}
		
		else if(args[0].equalsIgnoreCase("setType")){
			System.out.println("yolo");
			if(args.length != 3){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm setType [name] [start/end]3");
				return true;
			}
			if(!setTypeCommand.Start(sender, args[1], args[2])){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm setType [name] [start/end]4");
				return true;
			}
			return true;
		}
		
		else if(args[0].equalsIgnoreCase("teleport")){
			if(args.length != 3){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm teleport [name] [player]");
				return true;
			}
			RollerPoint p = Main.d.getPointByName(args[1]);
			if(p.type == RollerPoint.EMPTY){
				sender.sendMessage(ChatColor.RED + "This point does not exist.");
			}else{
				Player q = Bukkit.getPlayer(args[2]);
				if(q != null){
					q.teleport(p.getLoc());
				}else{
					sender.sendMessage(ChatColor.RED + "The player is not online.");
				}
			}
			return true;
		}
		else{
			sender.sendMessage(ChatColor.RED + "Do /rcm help for all the avalable commands.");
		}
		/*
		if(args[0].equalsIgnoreCase("setSpeed")){
			if(args.length != 3){
				sender.sendMessage(ChatColor.RED + "Usage: /rcm setSpeed [name] [speed]");
				return true;
			}
			RollerPoint p = Main.d.getPointByName(args[1]);
			if(p.type == RollerPoint.EMPTY){
				sender.sendMessage(ChatColor.RED + "This point does not exist.");
				return true;
			}
			try { 
		        int speed = Integer.parseInt(args[3]);
		        p.speed = speed;
		    } catch(NumberFormatException e) { 
		    	sender.sendMessage(ChatColor.RED + "Usage: /rcm setSpeed [name] [speed[");
		        return true; 
		    }
			return true;
		}
		*/
		
		
		return true;
	}

}
