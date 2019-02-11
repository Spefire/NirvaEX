package sorts;

import java.io.File;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SortDefence implements Listener {

    private Nirva plugin;
    private int secondes = 20;

    public SortDefence(Nirva plugin) {
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
		if (modifi.getString("Class.Seven").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (sort == 4 && peutTirer == true) {
			// ///
			Vector dessus = p.getEyeLocation().getDirection().multiply(3);
			dessus.setY(2);
			p.setVelocity(dessus);
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * secondes, 4));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Two"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.One").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.One"))) {
		    if (sort == 2 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 15 * secondes, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * secondes, 1));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Three"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 3 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 15 * secondes, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15 * secondes, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Four"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Four").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Four"))) {
		    if (sort == 4 && peutTirer == true) {
			// ///
			Vector v = p.getEyeLocation().getDirection().setY(0).multiply(9);
			p.setVelocity(v);
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Six"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Five").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Five"))) {
		    if (sort == 1 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * secondes, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * secondes, 0));
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.sendMessage("I'M BATMMMMAAAANNNNNN !");
			System.out.println("I'M BATMAN !");
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Seven"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Eight").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Eight"))) {
		    if (sort == 1 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10 * secondes, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10 * secondes, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Eight"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 3 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 15 * secondes, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 15 * secondes, 0));
			// //
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Nine"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Nine").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Nine"))) {
		    if (sort == 4 && peutTirer == true) {
			// ///
			p.getWorld().playEffect(p.getEyeLocation(), Effect.ENDEREYE_LAUNCH, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * secondes, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * secondes, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Def.Ten"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
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