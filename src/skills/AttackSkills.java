package skills;

import java.io.File;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AttackSkills implements Listener {

    private Nirva plugin;
    private int seconds = 20;

    public AttackSkills(Nirva plugin) {
	this.plugin = plugin;
    }

    @SuppressWarnings("deprecation") @EventHandler(priority = EventPriority.NORMAL) public void onPlayerDamageAtt(EntityDamageByEntityEvent event) {
	Entity e = event.getDamager();
	Entity d = event.getEntity();
	if (e instanceof Player && d instanceof LivingEntity) {
	    Player p = (Player) e;
	    if (NirvaExActived(p)) {
		LivingEntity m = (LivingEntity) d;
		File fi = new File("plugins/NirvaEx/classes.yml");
		FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		File f = new File("plugins/NirvaEx/skills.yml");
		FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
		FileConfiguration config = plugin.getConfig();
		String path = "class." + p.getName();
		String category = config.getString(path);
		String languages = "languages." + p.getName();
		String language = config.getString(languages);
		String load = "loading." + p.getName();
		boolean canFire = config.getBoolean(load);
		String arg = "ability." + p.getName();
		int skill = config.getInt(arg);
		if (modifi.getString("Class.One").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.One"))) {
		    if (skill == 4 && canFire == true) {
			// ///
			m.damage(2);
			m.setVelocity(p.getEyeLocation().getDirection());
			m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, seconds / 4, 20));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.One"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 1 && canFire == true) {
			// ///
			m.damage(2);
			m.getWorld().createExplosion(m.getLocation(), 0);
			m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, seconds / 4, 20));
			p.setVelocity(p.getEyeLocation().getDirection().multiply(5));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Two"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Three").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Three"))) {
		    if (skill == 2 && canFire == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * seconds, 1));
			m.setVelocity(p.getEyeLocation().getDirection().multiply(4));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Three"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Five").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Five"))) {
		    if (skill == 3 && canFire == true) {
			// ///
			m.damage(1);
			m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5 * seconds, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Four"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 4 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * seconds, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * seconds, 1));
			m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5 * seconds, 1));
			// //
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Five"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Seven").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (skill == 2 && canFire == true) {
			// ///
			p.getWorld().strikeLightningEffect(m.getLocation());
			m.setFireTicks(5 * seconds);
			m.damage(4);
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Six"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Eight").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Eight"))) {
		    if (skill == 2 && canFire == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5 * seconds, 5));
			m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2 * seconds, 5));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Eleven"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 4 && canFire == true) {
			// ////
			m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Twelve"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Nine").equalsIgnoreCase(category) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Nine"))) {
		    if (skill == 1 && canFire == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5 * seconds, 2));
			m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * seconds, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5 * seconds, 2));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Thirteen"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 3 && canFire == true) {
			// ///
			if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			    m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 1));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5 * seconds, 0));
			} else {
			    m.damage(2);;
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5 * seconds, 0));
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Fourteen"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		}
	    }
	}
    }

    @EventHandler(priority = EventPriority.NORMAL) public void onPlayer(EntityDamageByEntityEvent event) {
	Entity e = event.getEntity();
	Entity d = event.getDamager();
	if (d instanceof Arrow) {
	    Arrow a = (Arrow) d;
	    if (e instanceof LivingEntity && a.getShooter() instanceof Player) {
		LivingEntity m = (LivingEntity) e;
		Player p = (Player) a.getShooter();
		if (NirvaExActived(p)) {
		    File fi = new File("plugins/NirvaEx/classes.yml");
		    FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		    File f = new File("plugins/NirvaEx/skills.yml");
		    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
		    FileConfiguration config = plugin.getConfig();
		    String path = "class." + p.getName();
		    String category = config.getString(path);
		    String languages = "languages." + p.getName();
		    String language = config.getString(languages);
		    String load = "loading." + p.getName();
		    boolean canFire = config.getBoolean(load);
		    String arg = "ability." + p.getName();
		    int skill = config.getInt(arg);
		    if (modifi.getString("Class.Two").equalsIgnoreCase(category)) {
			if (skill == 1 && canFire == true) {
			    // ///
			    m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 15 * seconds, 2));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15 * seconds, 1));
			    // ///
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Seven"));
			    config.set(load, false);
			    plugin.saveConfig();
			    Cooldown rt = new Cooldown(p, plugin);
			    rt.start();
			}
			if (skill == 2 && canFire == true) {
			    // ////
			    p.getWorld().strikeLightningEffect(m.getLocation());
			    m.setFireTicks(5 * seconds);
			    m.damage(2);
			    // ////
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Eight"));
			    config.set(load, false);
			    plugin.saveConfig();
			    Cooldown rt = new Cooldown(p, plugin);
			    rt.start();
			}
			if (skill == 3 && canFire == true) {
			    // ///
			    m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10 * seconds, 0));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10 * seconds, 1));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 10 * seconds, 1));
			    // ///
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Nine"));
			    config.set(load, false);
			    plugin.saveConfig();
			    Cooldown rt = new Cooldown(p, plugin);
			    rt.start();
			}
			if (skill == 4 && canFire == true) {
			    // ///
			    m.setVelocity(m.getLocation().getDirection());
			    m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, seconds / 4, 15));
			    m.damage(2);
			    m.getWorld().createExplosion(m.getLocation(), 0);
			    // ////
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Atk.Ten"));
			    config.set(load, false);
			    plugin.saveConfig();
			    Cooldown rt = new Cooldown(p, plugin);
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
	boolean isActivated = modif.getBoolean(path);
	if (isActivated == false) {
	    return false;
	} else {
	    return true;
	}
    }
}
