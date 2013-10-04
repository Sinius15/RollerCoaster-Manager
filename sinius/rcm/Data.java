package sinius.rcm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import fileHandling.LFile;

public class Data {

	public List<RollerPoint> points = new ArrayList<RollerPoint>();
	LFile oldFile;
	File dir, dataFile;
	YAMLFile data = new YAMLFile(true);
	
	public Data(){
		dir = new File(Main.getPlug().getDataFolder().getAbsolutePath());
		oldFile = new LFile(new File(dir.getAbsolutePath() + "//data.txt"));
		dataFile = new File(dir.getAbsolutePath() + "//data.yml");
	}
	
	void openFile(){
		if(oldFile.exist()){
			String[] s;
			try {
				s = oldFile.open(true);
				if(s.length <1){
					return;
				}
				for(int i = 0; i < s.length; i++){
					String[] t = s[i].split(",");
					points.add(new RollerPoint(t[3], t[4], t[5], t[2], t[0], t[1], t[6]));
				}			
			} catch (IOException e) {
				e.printStackTrace();
			}
			oldFile.getFile().delete();
		}else{
			if(!dataFile.exists()) return;
			data = new YAMLFile(true);
			data.Load(dataFile);
			for(int i =0 ; i< data.getInt("rollerPointAmount"); i++){
				points.add(new RollerPoint(
						data.getInt("point." + i + ".x"), 
						data.getInt("point." + i + ".y"), 
						data.getInt("point." + i + ".z"), 
						data.getString("point." + i + ".world"), 
						data.getString("point." + i + ".name"), 
						data.getInt("point." + i + ".type"), 
						data.getInt("point." + i + ".whatToSpawn")));
			}
		}
		
	}
	
	void saveFile(){
		data = new YAMLFile(true);
		data.addInt("rollerPointAmount", points.size());
		int i = 0;
		for(RollerPoint p : points){
			data.addString("point." + i + ".name", p.name);
			data.addInt("point." + i + ".type", p.type);
			data.addString("point." + i + ".world", p.world);
			data.addInt("point." + i + ".x", p.x);
			data.addInt("point." + i + ".y", p.y);
			data.addInt("point." + i + ".z", p.z);
			data.addInt("point." + i + ".whatToSpawn", p.whatToSpawn);
			i++;
		}
		
		try {
			dir.mkdirs();
			dataFile.createNewFile();
			data.Save(dataFile);
		} catch (Exception e) {
			System.err.println("The data file could not be saved!  Please report this problem to sinius15. I am verry sory for the inconvenience.");
			e.printStackTrace();
		}
			
	}
	
	public boolean addPoint(Location loc, String name, int type){
		for(RollerPoint p : points){
			if(p.name.equals(name)){
				return false;
			}
		}
		RollerPoint p = new RollerPoint((int)loc.getX(), (int)loc.getY(), (int)loc.getZ(), loc.getWorld().getName(), name, type, RollerPoint.CART_NORMAL);
		p.v = loc.getDirection();
		points.add(p);
		
		return true;
	}
	
	public boolean removePoint(String name){
		int i = 0;
		for(RollerPoint p : points){
			if(p.name.equals(name)){
				points.remove(i);
				return true;
			}
			i++;
		}
		return false;
	}
	
	public RollerPoint getPointByName(String name){
		for(RollerPoint p : points){
			if(p.name.equals(name)){
				return p;
			}
		}
		return new RollerPoint(0,0,0,"a","EMPTY",RollerPoint.EMPTY, 0);
	}
	
}
