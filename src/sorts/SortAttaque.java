package sorts;

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

public class SortAttaque implements Listener {

    private Nirva plugin;
    private int secondes = 20;

    public SortAttaque(Nirva plugin) {
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
		String classe = config.getString(path);
		String langages = "languages." + p.getName();
		String langage = config.getString(langages);
		String tirer = "loading." + p.getName();
		boolean peutTirer = config.getBoolean(tirer);
		String arg = "ability." + p.getName();
		int sort = config.getInt(arg);
		if (modifi.getString("Class.One").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.One"))) {
		    if (sort == 4 && peutTirer == true) {
			// ///
			m.damage(2);
			m.setVelocity(p.getEyeLocation().getDirection());
			m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, secondes / 4, 20));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.One"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 1 && peutTirer == true) {
			// ///
			m.damage(2);
			m.getWorld().createExplosion(m.getLocation(), 0);
			m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, secondes / 4, 20));
			p.setVelocity(p.getEyeLocation().getDirection().multiply(5));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Two"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Three").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Three"))) {
		    if (sort == 2 && peutTirer == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5 * secondes, 1));
			m.setVelocity(p.getEyeLocation().getDirection().multiply(4));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Three"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Five").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Five"))) {
		    if (sort == 3 && peutTirer == true) {
			// ///
			m.damage(1);
			m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5 * secondes, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Four"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 4 && peutTirer == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * secondes, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * secondes, 1));
			m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5 * secondes, 1));
			// //
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Five"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Seven").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (sort == 2 && peutTirer == true) {
			// ///
			p.getWorld().strikeLightningEffect(m.getLocation());
			m.setFireTicks(5 * secondes);
			m.damage(4);
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Six"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Eight").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Eight"))) {
		    if (sort == 2 && peutTirer == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5 * secondes, 5));
			m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2 * secondes, 5));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Eleven"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 4 && peutTirer == true) {
			// ////
			m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Twelve"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Nine").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Nine"))) {
		    if (sort == 1 && peutTirer == true) {
			// ///
			m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5 * secondes, 2));
			m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * secondes, 0));
			m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 5 * secondes, 2));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Thirteen"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
			rt.start();
		    }
		    if (sort == 3 && peutTirer == true) {
			// ///
			if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			    m.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 1));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5 * secondes, 0));
			} else {
			    m.damage(2);;
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5 * secondes, 0));
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Fourteen"));
			config.set(tirer, false);
			plugin.saveConfig();
			Recharge rt = new Recharge(p, plugin);
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
		    String classe = config.getString(path);
		    String langages = "languages." + p.getName();
		    String langage = config.getString(langages);
		    String tirer = "loading." + p.getName();
		    boolean peutTirer = config.getBoolean(tirer);
		    String arg = "ability." + p.getName();
		    int sort = config.getInt(arg);
		    if (modifi.getString("Class.Two").equalsIgnoreCase(classe)) {
			if (sort == 1 && peutTirer == true) {
			    // ///
			    m.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 15 * secondes, 2));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15 * secondes, 1));
			    // ///
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Seven"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
			if (sort == 2 && peutTirer == true) {
			    // ////
			    p.getWorld().strikeLightningEffect(m.getLocation());
			    m.setFireTicks(5 * secondes);
			    m.damage(2);
			    // ////
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Eight"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
			if (sort == 3 && peutTirer == true) {
			    // ///
			    m.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10 * secondes, 0));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10 * secondes, 1));
			    m.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 10 * secondes, 1));
			    // ///
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Nine"));
			    config.set(tirer, false);
			    plugin.saveConfig();
			    Recharge rt = new Recharge(p, plugin);
			    rt.start();
			}
			if (sort == 4 && peutTirer == true) {
			    // ///
			    m.setVelocity(m.getLocation().getDirection());
			    m.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, secondes / 4, 15));
			    m.damage(2);
			    m.getWorld().createExplosion(m.getLocation(), 0);
			    // ////
			    p.sendMessage(ChatColor.AQUA + modif.getString(langage + ".use") + ChatColor.WHITE + modif.getString(langage + ".Atk.Ten"));
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