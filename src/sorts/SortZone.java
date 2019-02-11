package sorts;

import java.io.File;
import java.util.List;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SortZone implements Listener {

    private Nirva plugin;
    private int range = 7;
    private int secondes = 20;

    public SortZone(Nirva plugin) {
	this.plugin = plugin;
    }

    @SuppressWarnings("deprecation") @EventHandler(priority = EventPriority.NORMAL) public void onPlayerInteract(PlayerInteractEvent event) throws Exception {
	Player p = event.getPlayer();
	if (NirvaExActived(p)) {
	    File fi = new File("plugins/NirvaEx/classes.yml");
	    FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
	    File f = new File("plugins/NirvaEx/skills.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    FileConfiguration config = plugin.getConfig();
	    String path = "class." + p.getName();
	    String classe = config.getString(path);
	    String langages = "languages." + p.getName();
	    String langage = config.getString(langages);
	    String tirer = "loading." + p.getName();
	    boolean peutTirer = config.getBoolean(tirer);
	    String arg = "ability." + p.getName();
	    int sort = config.getInt(arg);
	    if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
		if (modifi.getString("Class.Five").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Five"))) {
		    if (sort == 2 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range) {
				used = true;
				entity.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * secondes, 0));
				entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10 * secondes, 0));
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * secondes, 2));
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.One"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		} else if (modifi.getString("Class.Seven").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (sort == 3 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range && entity != p) {
				used = true;
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * secondes, 5));
				entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * secondes, 5));
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5 * secondes, 5));
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Two"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		} else if (modifi.getString("Class.Four").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Four"))) {
		    if (sort == 3 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range && entity != p) {
				used = true;
				p.getWorld().strikeLightningEffect(entity.getLocation());
				entity.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
				entity.damage(4);
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Three"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		    if (sort == 2 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range && entity != p) {
				used = true;
				entity.setFireTicks(10 * secondes);
				entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, secondes / 4, 15));
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Four"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		} else if (modifi.getString("Class.Six").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Six"))) {
		    if (sort == 1 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range && entity != p) {
				used = true;
				entity.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 15 * secondes, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15 * secondes, 0));
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Six"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		    if (sort == 2 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    Vector attirance = entity.getLocation().subtract(p.getLocation()).toVector();
			    attirance.setX(-attirance.getX() / 2);
			    attirance.setY(-attirance.getY() / 2);
			    attirance.setZ(-attirance.getZ() / 2);
			    if (distance < range && entity != p) {
				used = true;
				entity.damage(4);
				entity.getWorld().createExplosion(entity.getLocation(), 0);
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * secondes, 2));
				entity.setVelocity(attirance);
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Nine"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		    if (sort == 4 && peutTirer == true) {
			// ///
			List<Player> entites = p.getWorld().getPlayers();
			Location ici = p.getLocation();
			boolean used = false;
			for (Player entity : entites) {
			    double distance = entity.getLocation().distance(ici);
			    if (distance < range && entity != p) {
				used = true;
				entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10 * secondes, 0));
				entity.removePotionEffect(PotionEffectType.INVISIBILITY);
				p.getWorld().playEffect(entity.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
			    }
			}
			// ///
			if (used) {
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Zon.Seven"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
		    }
		}
	    }
	}
    }

    public boolean NirvaExActived(Player p) {
	File f = new File("plugins/NirvaEx/worlds.yml");
	FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	String path = p.getWorld().toString() + ".NirvaEx actived";;
	boolean mondeset = modif.getBoolean(path);
	if (mondeset == false) {
	    return false;
	} else {
	    return true;
	}
    }

}
