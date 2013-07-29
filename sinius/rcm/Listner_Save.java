package sinius.rcm;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

public class Listner_Save implements Listener{

	@EventHandler
	public void onWorldSave(WorldSaveEvent event){
		Main.d.saveFile();
	}
}
