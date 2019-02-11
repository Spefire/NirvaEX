package skills;

import java.io.File;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;

public class TargetedSkills implements Listener {

    private Nirva plugin;
    private int range = 20;
    private int seconds = 20;

    public TargetedSkills(Nirva plugin) {
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
		LivingEntity entity = getTarget(p, range);
		if (modifi.getString("Class.Three").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Three"))) {
		    if (skill == 1 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * seconds, 2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 2));
			if (entity != null) {
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5 * seconds, 2));
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 2));
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.One"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 3 && canFire == true) {
			// ///
			p.removePotionEffect(PotionEffectType.BLINDNESS);
			p.removePotionEffect(PotionEffectType.CONFUSION);
			p.removePotionEffect(PotionEffectType.HUNGER);
			p.removePotionEffect(PotionEffectType.POISON);
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
			p.removePotionEffect(PotionEffectType.WEAKNESS);
			p.removePotionEffect(PotionEffectType.UNLUCK);
			p.removePotionEffect(PotionEffectType.WITHER);
			if (entity != null) {
			    entity.removePotionEffect(PotionEffectType.BLINDNESS);
			    entity.removePotionEffect(PotionEffectType.CONFUSION);
			    entity.removePotionEffect(PotionEffectType.HUNGER);
			    entity.removePotionEffect(PotionEffectType.POISON);
			    entity.removePotionEffect(PotionEffectType.SLOW);
			    entity.removePotionEffect(PotionEffectType.SLOW_DIGGING);
			    entity.removePotionEffect(PotionEffectType.WEAKNESS);
			    entity.removePotionEffect(PotionEffectType.UNLUCK);
			    entity.removePotionEffect(PotionEffectType.WITHER);
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Two"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		    if (skill == 4 && canFire == true && entity != null) {
			// ///
			entity.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			entity.removePotionEffect(PotionEffectType.LUCK);
			entity.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			entity.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			entity.removePotionEffect(PotionEffectType.JUMP);
			entity.removePotionEffect(PotionEffectType.REGENERATION);
			entity.removePotionEffect(PotionEffectType.SPEED);
			entity.removePotionEffect(PotionEffectType.WATER_BREATHING);
			entity.removePotionEffect(PotionEffectType.INVISIBILITY);
			entity.removePotionEffect(PotionEffectType.NIGHT_VISION);
			entity.removePotionEffect(PotionEffectType.ABSORPTION);
			entity.removePotionEffect(PotionEffectType.HEALTH_BOOST);
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Three"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Four").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Four"))) {
		    if (skill == 1 && canFire == true && entity != null) {
			// ///
			entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10 * seconds, 2));
			entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10 * seconds, 0));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Four"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Six").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Six"))) {
		    if (skill == 3 && canFire == true && entity != null) {
			// ////
			entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10 * seconds, 1));
			entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10 * seconds, 1));
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Five"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Seven").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Seven"))) {
		    if (skill == 1 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 15 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 15 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * seconds, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15 * seconds, 0));
			if (entity != null) {
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 15 * seconds, 0));
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 15 * seconds, 0));
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 15 * seconds, 0));
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15 * seconds, 0));
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Six"));
			config.set(load, false);
			plugin.saveConfig();
			Cooldown rt = new Cooldown(p, plugin);
			rt.start();
		    }
		} else if (modifi.getString("Class.Nine").equalsIgnoreCase(classe) && p.getItemInHand().getType().toString().contains(modifi.getString("Weapons.Nine"))) {
		    if (skill == 2 && canFire == true) {
			// ///
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5 * seconds, 0));
			if (entity != null) {
			    entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10 * seconds, 0));
			}
			// ///
			p.sendMessage(ChatColor.AQUA + modif.getString(language + ".use") + ChatColor.WHITE + modif.getString(language + ".Vis.Seven"));
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

    public LivingEntity getTarget(Player player, int range) {
	BlockIterator iterator = new BlockIterator(player.getWorld(), player.getLocation().toVector(), player.getEyeLocation().getDirection(), 0, range);
	LivingEntity target = null;
	while (iterator.hasNext()) {
	    Block item = iterator.next();
	    for (Entity entity : player.getNearbyEntities(range, range, range)) {
		if (entity instanceof LivingEntity) {
		    int acc = 2;
		    for (int x = -acc; x < acc; x++) {
			for (int z = -acc; z < acc; z++) {
			    for (int y = -acc; y < acc; y++) {
				if (entity.getLocation().getBlock().getRelative(x, y, z).equals(item)) {
				    return target = (LivingEntity) entity;
				}
			    }
			}
		    }
		}
	    }
	}
	return target;
    }
}
