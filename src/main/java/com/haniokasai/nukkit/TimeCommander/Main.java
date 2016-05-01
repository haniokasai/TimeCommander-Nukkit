package com.haniokasai.nukkit.TimeCommander;

import cn.nukkit.Server;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;



public class Main extends PluginBase implements Listener{



	public void onEnable() {

		this.getServer().getPluginManager().registerEvents(this, this);
		getDataFolder().mkdir();
		this.saveDefaultConfig();
		String i ="1";
		int t =1200;
		int k =1;
		while(this.getConfig().exists("Command"+i)){
			String ccmmdd =this.getConfig().get("Command"+i).toString();
			int Time = Integer.parseInt(this.getConfig().get("Time"+i).toString());
			 Server.getInstance().getScheduler().scheduleRepeatingTask(new Runnable() {
	                public void run() {
	                	Server.getInstance().getScheduler().scheduleDelayedTask(new Runnable() {
	    	                public void run() {
	    	                	Server.getInstance().dispatchCommand(new ConsoleCommandSender(),ccmmdd);
	    	                }
	    	            }, (Time*t));
	                }
	            }, (Time*t));

			int ii = (Integer.valueOf(i).intValue() + k);
			i = Integer.toString(ii);
		}
}

}
