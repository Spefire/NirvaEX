package commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.protection.flags.DefaultFlag;

import main.Nirva;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerCommands implements Listener {

    private Nirva plugin;

    public PlayerCommands(Nirva plugin) {
	this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR) public void PlayerConnected(PlayerLoginEvent e) {
	Player p = e.getPlayer();
	FileConfiguration config = plugin.getConfig();
	String load = "loading." + p.getName();
	config.set(load, true);
	String languages = "languages." + p.getName();
	String language = config.getString(languages);
	String ldefaut = "languages." + "Default";
	String defaut = config.getString(ldefaut);
	if (language == null) {
	    if (defaut == null) {
		config.set(ldefaut, "English");
		plugin.saveConfig();
		defaut = config.getString(ldefaut);
	    }
	    config.set(languages, defaut);
	}
	plugin.saveConfig();
    }

    @EventHandler(priority = EventPriority.MONITOR) public void onPluginEnable(PluginEnableEvent e) {
	if (plugin.pManager == null && Bukkit.getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
	    plugin.pManager = PermissionsEx.getPermissionManager();
	}
    }

    @EventHandler(priority = EventPriority.LOWEST) public void demandeClasse(PlayerCommandPreprocessEvent e) {

	Player p = e.getPlayer();
	String message = e.getMessage();
	String[] params = message.split(" ");
	if (params[0].equalsIgnoreCase("/nclass")) {
	    e.setCancelled(true);
	    File f = new File("plugins/NirvaEx/classes.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    FileConfiguration config = plugin.getConfig();
	    String languages = "languages." + p.getName();
	    String language = config.getString(languages);
	    String path = "class." + p.getName();
	    String category = config.getString(path);
	    if (params.length == 2) {
		p.sendMessage(ChatColor.RED + modif.getString(language + ".warning"));
		if (category == null || plugin.hasPermission(p, "nirva.change.class") || plugin.hasPermission(p, "nirva.admin")) {
		    if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.One"))) {
			if (plugin.hasPermission(p, "nirva.class.one") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.One"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.One"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.One"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Two"))) {
			if (plugin.hasPermission(p, "nirva.class.two") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Two"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Two"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Two"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Three"))) {
			if (plugin.hasPermission(p, "nirva.class.three") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Three"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Three"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Three"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Four"))) {
			if (plugin.hasPermission(p, "nirva.class.four") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Four"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Four"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Four"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Five"))) {
			if (plugin.hasPermission(p, "nirva.class.five") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Five"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Five"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Five"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Six"))) {
			if (plugin.hasPermission(p, "nirva.class.six") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Six"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Six"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Six"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Seven"))) {
			if (plugin.hasPermission(p, "nirva.class.seven") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Seven"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Seven"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Seven"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Eight"))) {
			if (plugin.hasPermission(p, "nirva.class.eight") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Eight"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Eight"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Eight"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Nine"))) {
			if (plugin.hasPermission(p, "nirva.class.nine") || plugin.hasPermission(p, "nirva.class.all") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, modif.getString("Class.Nine"));
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Nine"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Nine"));
			}
		    } else if (params[1].toLowerCase().equalsIgnoreCase(modif.getString("Class.Deleted"))) {
			if (plugin.hasPermission(p, "nirva.delete.class") || plugin.hasPermission(p, "nirva.admin")) {
			    config.set(path, "Deleted");
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".be") + modif.getString("Class.Deleted"));
			} else {
			    p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittobe") + modif.getString("Class.Deleted"));
			}
		    }
		} else {
		    p.sendMessage(ChatColor.RED + modif.getString(language + ".alreadyclass"));
		}
	    } else {
		p.sendMessage(ChatColor.RED + "/nclass " + modif.getString("Class.List"));

	    }
	}
	if (params[0].equalsIgnoreCase("/n") || params[0].equalsIgnoreCase("/nhelp")) {
	    e.setCancelled(true);
	    FileConfiguration config = plugin.getConfig();
	    String languages = "languages." + p.getName();
	    String language = config.getString(languages);
	    if ("French".equalsIgnoreCase(language)) {
		p.sendMessage(ChatColor.AQUA + "---------" + ChatColor.WHITE + "Aide: NirvaEx" + ChatColor.AQUA + "--------------");
		p.sendMessage(ChatColor.AQUA + "                          ");
		p.sendMessage(ChatColor.AQUA + "/nclass: " + ChatColor.WHITE + "Choisir sa classe");
		p.sendMessage(ChatColor.AQUA + "/nlevel: " + ChatColor.WHITE + "Savoir sa classe et son niveau");
		p.sendMessage(ChatColor.AQUA + "/nlanguage: " + ChatColor.WHITE + "Choisir sa langue");
		p.sendMessage(ChatColor.AQUA + "/nsetworld: " + ChatColor.WHITE + "Activer ou non le plugin dans ce monde");
		p.sendMessage(ChatColor.AQUA + "/nlocation: " + ChatColor.WHITE + "Savoir si le plugin est actif");
		p.sendMessage(ChatColor.AQUA + "/nstuff: " + ChatColor.WHITE + "Avoir son équipement");
	    } else {
		p.sendMessage(ChatColor.AQUA + "---------" + ChatColor.WHITE + "Help: NirvaEx" + ChatColor.AQUA + "--------------");
		p.sendMessage(ChatColor.AQUA + "                          ");
		p.sendMessage(ChatColor.AQUA + "/nclass: " + ChatColor.WHITE + "To choice your class");
		p.sendMessage(ChatColor.AQUA + "/nlevel: " + ChatColor.WHITE + "To know your class and level");
		p.sendMessage(ChatColor.AQUA + "/nlanguage: " + ChatColor.WHITE + "To choice your language");
		p.sendMessage(ChatColor.AQUA + "/nsetworld: " + ChatColor.WHITE + "To set the plugin, enabled or disabled in this world");
		p.sendMessage(ChatColor.AQUA + "/nlocation: " + ChatColor.WHITE + "To know if the plugin is actived at your location");
		p.sendMessage(ChatColor.AQUA + "/nstuff: " + ChatColor.WHITE + "To get your stuff");
	    }
	}
	if (params[0].equalsIgnoreCase("/nstuff")) {
	    e.setCancelled(true);
	    File f = new File("plugins/NirvaEx/classes.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    FileConfiguration config = plugin.getConfig();
	    String languages = "languages." + p.getName();
	    String language = config.getString(languages);
	    if (plugin.hasPermission(p, "nirva.have.stuff") || plugin.hasPermission(p, "nirva.admin")) {
		String arg = "class." + p.getName();
		String category = config.getString(arg);
		Player player = p;
		ItemStack weapon;
		if (category == null) {
		    p.sendMessage(ChatColor.RED + modif.getString(language + ".nohaveclass"));
		} else if (category.equalsIgnoreCase(modif.getString("Class.Five"))) {
		    weapon = new ItemStack(Material.STONE_HOE);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.One"))) {
		    weapon = new ItemStack(Material.STONE_SWORD);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Seven"))) {
		    weapon = new ItemStack(Material.YELLOW_FLOWER);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Three"))) {
		    weapon = new ItemStack(Material.RED_ROSE);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Two"))) {
		    weapon = new ItemStack(Material.BOW);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.ARROW);
		    weapon.setAmount(64);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Four"))) {
		    weapon = new ItemStack(Material.PAPER);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Six"))) {
		    weapon = new ItemStack(Material.FLINT);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Eight"))) {
		    weapon = new ItemStack(Material.STONE_AXE);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		} else if (category.equalsIgnoreCase(modif.getString("Class.Nine"))) {
		    weapon = new ItemStack(Material.STONE_SWORD);
		    player.getInventory().addItem(weapon);
		    weapon = new ItemStack(Material.SLIME_BALL);
		    player.getInventory().addItem(weapon);
		}
	    } else {
		p.sendMessage(ChatColor.RED + modif.getString(language + ".nopermittostuff"));
	    }
	}

	if (params[0].equalsIgnoreCase("/nlevel")) {
	    e.setCancelled(true);
	    FileConfiguration config = plugin.getConfig();
	    String path = "class." + p.getName();
	    String category = config.getString(path);
	    String languages = "languages." + p.getName();
	    String language = config.getString(languages);
	    if (category != null && !category.equalsIgnoreCase(" ")) {
		if ("French".equalsIgnoreCase(language)) {
		    p.sendMessage(ChatColor.AQUA + "Votre classe est " + ChatColor.WHITE + category);
		    int xp = (int) (p.getExp() * 100);
		    p.sendMessage(ChatColor.AQUA + "Vous êtes Level " + p.getLevel() + " avec " + xp + "%");
		} else {
		    p.sendMessage(ChatColor.AQUA + "Your class is " + ChatColor.WHITE + category);
		    int xp = (int) (p.getExp() * 100);
		    p.sendMessage(ChatColor.AQUA + "You are Level " + p.getLevel() + " with " + xp + "%");
		}
	    } else {
		if ("French".equalsIgnoreCase(language)) {
		    p.sendMessage(ChatColor.AQUA + "Vous n'avez pas de classe.");
		    int xp = (int) (p.getExp() * 100);
		    p.sendMessage(ChatColor.AQUA + "Vous êtes niveau " + p.getLevel() + " avec " + xp + "%");
		} else {
		    p.sendMessage(ChatColor.AQUA + "You don't have any class.");
		    int xp = (int) (p.getExp() * 100);
		    p.sendMessage(ChatColor.AQUA + "You are level " + p.getLevel() + " with " + xp + "%");
		}
	    }
	}
	if (params[0].equalsIgnoreCase("/nsetworld")) {
	    e.setCancelled(true);
	    if (plugin.hasPermission(p, "nirva.set.world") || plugin.hasPermission(p, "nirva.admin")) {
		if (params.length == 2 && params[1].toLowerCase().startsWith("tr")) {
		    File f = new File("plugins/NirvaEx/worlds.yml");
		    try {
			if (!f.exists()) {
			    f.createNewFile();
			}
			FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
			ConfigurationSection World = modif.createSection(p.getWorld().toString());
			World.set("NirvaEx actived", true);
			modif.save(f);
		    } catch (Exception except) {
		    }
		    File fi = new File("plugins/NirvaEx/classes.yml");
		    FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		    FileConfiguration config = plugin.getConfig();
		    String languages = "languages." + p.getName();
		    String language = config.getString(languages);
		    p.sendMessage(ChatColor.AQUA + modifi.getString(language + ".worldtrue"));
		} else if (params.length == 2 && params[1].toLowerCase().startsWith("fa")) {
		    File f = new File("plugins/NirvaEx/worlds.yml");
		    try {
			if (!f.exists()) {
			    f.createNewFile();
			}
			FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
			ConfigurationSection World = modif.createSection(p.getWorld().toString());
			World.set("NirvaEx actived", false);
			modif.save(f);
		    } catch (Exception except) {
		    }
		    File fi = new File("plugins/NirvaEx/classes.yml");
		    FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		    FileConfiguration config = plugin.getConfig();
		    String languages = "languages." + p.getName();
		    String language = config.getString(languages);
		    p.sendMessage(ChatColor.AQUA + modifi.getString(language + ".worldfalse"));
		}
	    }
	}
	if (params[0].equalsIgnoreCase("/nlocation")) {
	    e.setCancelled(true);
	    if (NirvaExActived(p)) {
		File fi = new File("plugins/NirvaEx/classes.yml");
		FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		FileConfiguration config = plugin.getConfig();
		String languages = "languages." + p.getName();
		String language = config.getString(languages);
		p.sendMessage(ChatColor.AQUA + modifi.getString(language + ".locationtrue"));
	    } else {
		File fi = new File("plugins/NirvaEx/classes.yml");
		FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
		FileConfiguration config = plugin.getConfig();
		String languages = "languages." + p.getName();
		String language = config.getString(languages);
		p.sendMessage(ChatColor.AQUA + modifi.getString(language + ".locationfalse"));
	    }
	}
	if (params[0].equalsIgnoreCase("/nlanguage")) {
	    e.setCancelled(true);
	    if (params.length == 2 && params[1].toLowerCase().startsWith("en")) {
		FileConfiguration config = plugin.getConfig();
		String path = "languages." + p.getName();
		config.set(path, "English");
		plugin.saveConfig();
		p.sendMessage(ChatColor.AQUA + "Now Nirva is in English");
	    } else if (params.length == 2 && params[1].toLowerCase().startsWith("fr")) {
		FileConfiguration config = plugin.getConfig();
		String path = "languages." + p.getName();
		config.set(path, "French");
		plugin.saveConfig();
		p.sendMessage(ChatColor.AQUA + "Nirva est en Français maintenant");
	    } else {
		p.sendMessage(ChatColor.RED + "/nlanguage <English|French>");
	    }
	}
    }

    @SuppressWarnings("deprecation") public boolean NirvaExActived(Player p) {
	if (plugin.getWorldGuard() == null) {
	    File f = new File("plugins/NirvaEx/worlds.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    String path = p.getWorld().toString() + ".NirvaEx actived";
	    boolean isActivated = modif.getBoolean(path);
	    if (isActivated == false) {
		return false;
	    } else {
		return true;
	    }
	} else {
	    File f = new File("plugins/NirvaEx/worlds.yml");
	    FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	    String path = p.getWorld().toString() + ".NirvaEx actived";
	    boolean isActivated = modif.getBoolean(path);
	    if (isActivated == false || !plugin.getWorldGuard().getGlobalRegionManager().allows(DefaultFlag.PVP, p.getLocation())) {
		return false;
	    } else {
		return true;
	    }
	}
    }
}