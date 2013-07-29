package sinius.rcm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import sinius.rcm.Main;
import sinius.rcm.RollerPoint;

public class setCartCommand {

	public static boolean Start(CommandSender sender, String name, String type){
		RollerPoint p = Main.d.getPointByName(name);
		if(p.type == RollerPoint.EMPTY){
			sender.sendMessage(ChatColor.RED + "This point does not exist");
			return true;
		}
		if(type.equalsIgnoreCase("minecart")){
			p.whatToSpawn = RollerPoint.CART_NORMAL;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " now spawns " + type + "s");
			return true;
		}
		else if(type.equalsIgnoreCase("chestCart")){
			p.whatToSpawn = RollerPoint.CART_CHEST;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " now spawns " + type + "s");
			return true;
		}
		else if(type.equalsIgnoreCase("furnaceCart")){
			p.whatToSpawn = RollerPoint.CART_FURNACE;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " now spawns " + type + "s");
			return true;
		}
		else if(type.equalsIgnoreCase("tntCart")){
			p.whatToSpawn = RollerPoint.CART_TNT;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " now spawns " + type + "s");
			return true;
		}
		else if(type.equalsIgnoreCase("hopperCart")){
			p.whatToSpawn = RollerPoint.CART_HOPPER;
			sender.sendMessage(ChatColor.YELLOW + "Point " + name + " now spawns " + type + "s");
			return true;
		}else{
			return false;
		}
	}
}
