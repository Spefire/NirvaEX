package skills;

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

public class DefenceSkills implements Listener {

    private Nirva plugin;
    private int seconds = 20;

    public DefenceSkills(Nirva plugin) {
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
	    String languages = "languages." + p.getName();
	    String language = config.getString(languages);
	    String load = "loading." + p.getName();
	    boolean canFire = config.getBoolean(load);
	    String arg = "ability." + p.getName();
	    int skill = config.getInt(arg);
	    if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
		if (modifi.getString("Class.Seven").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (skill == 4 && canFire == true) {
			// ///
			Vector dessus = p.getEyeLocation().getDirection().multiply(3);
			dessus.setY(2);
			p.setVelocity(dessus);
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * seconds, 4));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Two"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.One").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.One"))) {
		    if (skill == 2 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 15 * seconds, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * seconds, 1));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Three"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 3 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 15 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15 * seconds, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Four"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Four").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Four"))) {
		    if (skill == 4 && canFire == true) {
			// ///
			Vector v = p.getEyeLocation().getDirection().setY(0).multiply(9);
			p.setVelocity(v);
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Six"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Five").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Five"))) {
		    if (skill == 1 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * seconds, 0));
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			p.sendMessage("I'M BATMMMMAAAANNNNNN !");
			System.out.println("I'M BATMAN !");
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Seven"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Eight").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Eight"))) {
		    if (skill == 1 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10 * seconds, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Eight"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 3 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 15 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 15 * seconds, 0));
			// //
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Nine"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Nine").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Nine"))) {
		    if (skill == 4 && canFire == true) {
			// ///
			p.getWorld().playEffect(p.getEyeLocation(), Effect.ENDEREYE_LAUNCH, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * seconds, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Def.Ten"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
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
	boolean isActivated = modif.getBoolean(path);
	if (isActivated == false) {
	    return false;
	} else {
	    return true;
	}
    }
}
