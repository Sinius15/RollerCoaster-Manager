package sinius.rcm;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.util.Vector;

public class RollerPoint {
	
	public static final int START = 0;
	public static final int END = 1;
	public static final int EMPTY = 9999;
	public static final int CART_NORMAL = 0;
	public static final int CART_CHEST = 1;
	public static final int CART_FURNACE = 2;
	public static final int CART_TNT = 3;
	public static final int CART_HOPPER = 4;
	
	public int x, y, z;
	public String world;
	public String name;
	public int type;
	public int whatToSpawn = CART_NORMAL;
	
	public Vector v;
	
	public RollerPoint(int x, int y, int z, String world, String name, int type, int whatToSpawn){
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
		this.name = name;
		this.type = type;
		this.whatToSpawn = whatToSpawn;
	}
	
	public RollerPoint(String x, String y, String z, String world, String name, String type, String whatToSpawn){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.z = Integer.parseInt(z);
		this.world = world;
		this.name = name;
		this.type = Integer.parseInt(type);
		this.whatToSpawn = Integer.parseInt(whatToSpawn);
	}
	/*
	public Boolean sameLoc(Location otherLoc, int type){
		Location myLoc = new Location(Bukkit.getServer().getWorld(world), x + 0.5, y + 0.5, z + 0.5);
		if(myLoc.equals(otherLoc) && this.type == type){
			return true;
		}
		return false;
	}
	*/
	public Location getLoc(){
		return new Location(Bukkit.getServer().getWorld(world), x + 0.5, y + 0.5, z + 0.5);
	}
	
	public Minecart spawnCart(){
		Location loc = this.getLoc();
		Minecart m;
		switch(whatToSpawn){
			case CART_NORMAL: m = loc.getWorld().spawn(loc, Minecart.class); break;
			case CART_CHEST: m = loc.getWorld().spawn(loc, StorageMinecart.class); break;
			case CART_FURNACE: m = loc.getWorld().spawn(loc, PoweredMinecart.class); break;
			case CART_TNT: m = loc.getWorld().spawn(loc, ExplosiveMinecart.class); break;
			case CART_HOPPER: m = loc.getWorld().spawn(loc, HopperMinecart.class); break;
			default : m = loc.getWorld().spawn(loc, Minecart.class); break;
		}
		return m;
	}
	
	
	
}
