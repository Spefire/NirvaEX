package skills;

import java.io.File;

import main.Nirva;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SkillsNames implements Listener {

    private Nirva plugin;

    public SkillsNames(Nirva plugin) {
	this.plugin = plugin;
    }

    @SuppressWarnings("deprecation") @EventHandler(priority = EventPriority.NORMAL) public void onPlayerInteract(PlayerInteractEvent event) {
	Player p = event.getPlayer();
	File f = new File("plugins/NirvaEx/skills.yml");
	FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
	File fi = new File("plugins/NirvaEx/classes.yml");
	FileConfiguration modifi = YamlConfiguration.loadConfiguration(fi);
	if (NirvaExActived(p)) {
	    if (p.getItemInHand().getType().toString().equalsIgnoreCase(modifi.getString("Weapons.Select"))) {
		if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
		    FileConfiguration config = plugin.getConfig();
		    String path = "class." + p.getName();
		    String category = config.getString(path);
		    String languages = "languages." + p.getName();
		    String language = config.getString(languages);
		    String arg = "ability." + p.getName();
		    int skill = config.getInt(arg);
		    if (modifi.getString("Class.Two").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Seven"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Eight"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Nine"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Ten"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Seven").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefVis") + ChatColor.WHITE + modif.getString(language + ".Vis.Six"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Six"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Zon") + ChatColor.WHITE + modif.getString(language + ".Zon.Two"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Two"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.One").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Two"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Three"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Four"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.One"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Four").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Vis") + ChatColor.WHITE + modif.getString(language + ".Vis.Four"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Zon") + ChatColor.WHITE + modif.getString(language + ".Zon.Four"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Zon") + ChatColor.WHITE + modif.getString(language + ".Zon.Three"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Six"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Six").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefZon") + ChatColor.WHITE + modif.getString(language + ".Zon.Six"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Zon") + ChatColor.WHITE + modif.getString(language + ".Zon.Nine"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Vis") + ChatColor.WHITE + modif.getString(language + ".Vis.Five"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Zon") + ChatColor.WHITE + modif.getString(language + ".Zon.Seven"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Three").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefVis") + ChatColor.WHITE + modif.getString(language + ".Vis.One"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Three"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefVis") + ChatColor.WHITE + modif.getString(language + ".Vis.Two"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Vis") + ChatColor.WHITE + modif.getString(language + ".Vis.Three"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Five").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Seven"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefZon") + ChatColor.WHITE + modif.getString(language + ".Zon.One"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Four"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Five"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Eight").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Eight"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Eleven"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Nine"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Twelve"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
			}
		    }
		    if (modifi.getString("Class.Nine").equalsIgnoreCase(category)) {
			if (skill == 0 || skill >= 5) {
			    config.set(arg, 1);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Thirteen"));
			} else if (skill == 1) {
			    config.set(arg, 2);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.DefVis") + ChatColor.WHITE + modif.getString(language + ".Vis.Seven"));
			} else if (skill == 2) {
			    config.set(arg, 3);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Atk") + ChatColor.WHITE + modif.getString(language + ".Atk.Fourteen"));
			} else if (skill == 3) {
			    config.set(arg, 4);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString("Types.Def") + ChatColor.WHITE + modif.getString(language + ".Def.Ten"));
			} else if (skill == 4) {
			    config.set(arg, 5);
			    plugin.saveConfig();
			    p.sendMessage(ChatColor.AQUA + modif.getString(language + ".Pass.Nothing"));
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
