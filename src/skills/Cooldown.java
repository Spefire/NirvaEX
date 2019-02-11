package skills;

import java.io.File;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

class Cooldown extends Thread {

    private Nirva plugin;
    private Player p;

    public Cooldown(Player p, Nirva plugin) {
	this.plugin = plugin;
	this.p = p;
    }

    public void run() {
	try {
	    FileConfiguration config = plugin.getConfig();
	    File f = new File("plugins/NirvaEx/classes.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    File fi = new File("plugins/NirvaEx/skills.yml");
	    FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
	    String langages = "languages." + p.getName();
	    String langage = config.getString(langages);
	    String load = "loading." + p.getName();
	    long waitingTime = modifi.getLong("Types.Cooldown");
	    if ((waitingTime - p.getLevel()) <= 5) {
		waitingTime = 5000;
	    } else {
		waitingTime = (waitingTime - p.getLevel()) * 1000;
	    }
	    p.sendMessage((waitingTime / 1000) + "...");
	    while (waitingTime != 0) {
		if (waitingTime % 5000 == 0) {
		    p.sendMessage((waitingTime / 1000) + "...");
		}
		sleep(1000);
		waitingTime = waitingTime - 1000;
	    }
	    config.set(load, true);
	    plugin.saveConfig();
	    p.getWorld().playEffect(p.getLocation(), Effect.EXTINGUISH, 1000);
	    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".recharge"));
	} catch (InterruptedException e) {

	} finally {
	    this.interrupt();
	}
    }
}
