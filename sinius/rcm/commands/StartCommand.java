package sinius.rcm.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;

import sinius.rcm.Main;
import sinius.rcm.RollerPoint;

public class StartCommand{

	public static void Start(CommandSender sender, String name) {

		if(Main.d.getPointByName(name).type == RollerPoint.EMPTY){
			sender.sendMessage(ChatColor.RED + "This point does not exist");
			return;
		}
		RollerPoint p = Main.d.getPointByName(name);
		
		Boolean worldExists = false;
		 List<World> worlds = Bukkit.getWorlds();
		 for(World world : worlds){
			 if(world.getName().equals(p.world)){
				 worldExists = true;
			 }
		 }
		if(!worldExists){
			sender.sendMessage(ChatColor.RED + "The world where the point is defined does not exist.");
			return;
		}
		Location loc = p.getLoc();
		
		if(p.type == RollerPoint.END){
			List<Entity> enty = loc.getWorld().getEntities();
			for(Entity e : enty){
				if(e instanceof Minecart){
					Minecart cart = (Minecart) e;
					if(loc.distance(cart.getLocation()) < 4){
						cart.eject();
						cart.remove();
					}
				}
			}
		}
		
		if(p.type == RollerPoint.START){
				p.spawnCart();
		}
		
		return;
	}

}
