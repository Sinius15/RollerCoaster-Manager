package sinius.rcm;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Data d;
	public static CommandHandler command = new CommandHandler();
	public static File configFile;
	public static FileConfiguration config;
	
	@Override
	public void onLoad() {
		configFile = new File(Main.getPlug().getDataFolder() + "//config.yml");
		
	};
	
	
	@Override
	public void onEnable() {
		d = new Data();
		@SuppressWarnings("unused")
		PluginManager pm = getServer().getPluginManager();
		getCommand("rcm").setExecutor(command);
		d.openFile();
		
	}
	
	@Override
	public void onDisable() {
		d.saveFile();
	}
	
    public static Plugin getPlug(){
    	return Bukkit.getPluginManager().getPlugin("RCM");
    }

	
}

//  http://forums.bukkit.org/threads/roller-coaster-plugin.152688/  