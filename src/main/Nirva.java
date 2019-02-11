package main;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import ru.tehkode.permissions.PermissionManager;
import sorts.SortAttaque;
import sorts.SortDefence;
import sorts.SortVisee;
import sorts.SortZone;
import sorts.Sortileges;

public class Nirva extends JavaPlugin {

    private Nirva plugin;
    private SortAttaque sortatt;
    private SortDefence sortdef;
    private SortZone sortzon;
    private SortVisee sortvis;
    private Sortileges sortilege;
    private ConsoleCommand concommand;
    private PlayerCommand placommand;
    public PermissionManager pManager;
    public WorldGuardPlugin wgPlugin;
    Logger log;

    public Nirva() {
	plugin = this;
    }

    public void onEnable() {
	System.out.println("[NirvaEx] Plugin connected");
	PluginManager pm = getServer().getPluginManager();
	
	wgPlugin = getWorldGuard();
	concommand = new ConsoleCommand(this);
	pm.registerEvents(concommand, this);
	placommand = new PlayerCommand(this);
	pm.registerEvents(placommand, this);
	sortatt = new SortAttaque(this);
	pm.registerEvents(sortatt, this);
	sortdef = new SortDefence(this);
	pm.registerEvents(sortdef, this);
	sortzon = new SortZone(this);
	pm.registerEvents(sortzon, this);
	sortvis = new SortVisee(this);
	pm.registerEvents(sortvis, this);
	sortilege = new Sortileges(this);
	pm.registerEvents(sortilege, this);
	plugin.saveConfig();
	try {
	    File f = new File("plugins/NirvaEx/classes.yml");
	    if (!f.exists()) {
		f.createNewFile();
		FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
		ConfigurationSection Weapons = modif.createSection("Weapons");
		Weapons.set("One", "SWORD");
		Weapons.set("Two", "BOW");
		Weapons.set("Three", "RED_ROSE");
		Weapons.set("Four", "PAPER");
		Weapons.set("Five", "HOE");
		Weapons.set("Six", "FLINT");
		Weapons.set("Seven", "YELLOW_FLOWER");
		Weapons.set("Eight", "AXE");
		Weapons.set("Nine", "SWORD");
		Weapons.set("Select", "SLIME_BALL");
		ConfigurationSection Classes = modif.createSection("Class");
		Classes.set("One", "Warrior");
		Classes.set("Two", "Archer");
		Classes.set("Three", "Priest");
		Classes.set("Four", "Wizard");
		Classes.set("Five", "Vampire");
		Classes.set("Six", "Necromancer");
		Classes.set("Seven", "Druid");
		Classes.set("Eight", "Butcher");
		Classes.set("Nine", "Assassin");
		Classes.set("Deleted", "Deleted");
		Classes.set("List", modif.getString("Class.One") + " | " + modif.getString("Class.Two") + " | " + modif.getString("Class.Three") + " | " + modif.getString("Class.Four") + " | "
				+ modif.getString("Class.Five") + " | " + modif.getString("Class.Six") + " | " + modif.getString("Class.Seven") + " | " + modif.getString("Class.Eight") + " | "
				+ modif.getString("Class.Nine") + " | " + modif.getString("Class.Deleted"));
		ConfigurationSection Frances = modif.createSection("French");
		Frances.set("change", " est devenu ");
		Frances.set("be", "Maintenant vous êtes un ");
		Frances.set("nopermittobe", "Vous n'avez pas la permission de devenir un ");
		Frances.set("nopermittostuff", "Vous n'avez pas la permission d'avoir votre équipement.");
		Frances.set("nohaveclass", "Vous n'avez pas de classe.");
		Frances.set("alreadyclass", "Vous avez déjà une classe !");
		Frances.set("recharge", "Chargé !");
		Frances.set("warning", "Vous ne pourrez plus changer de classe après.");
		Frances.set("worldtrue", "Dans le monde dans lequel vous êtes, le plugin NirvaEx est actif.");
		Frances.set("worldfalse", "Dans le monde dans lequel vous êtes, le plugin NirvaEx est inactif.");
		Frances.set("locationtrue", "Là où vous êtes situé, le plugin NirvaEx est actif.");
		Frances.set("locationfalse", "Là où vous êtes situé, le plugin NirvaEx est inactif.");
		ConfigurationSection Anglais = modif.createSection("English");
		Anglais.set("change", " become ");
		Anglais.set("be", "Now you are a ");
		Anglais.set("nopermittobe", "You don't have any permission to be a ");
		Anglais.set("nopermittostuff", "You don't have any permission to have your stuff.");
		Anglais.set("nohaveclass", "You don't have any class.");
		Anglais.set("alreadyclass", "You have already a class !");
		Anglais.set("recharge", "Loaded !");
		Anglais.set("warning", "You won't to change your class after.");
		Anglais.set("worldtrue", "In this world, the plugin NirvaEx is actived.");
		Anglais.set("worldfalse", "In this world, the plugin NirvaEx is disactived.");
		Anglais.set("locationtrue", "At your location, the plugin NirvaEx is actived.");
		Anglais.set("locationfalse", "At your location, the plugin NirvaEx is disactived.");
		modif.save(f);
	    }
	} catch (Exception e) {
	}
	try {
	    File f = new File("plugins/NirvaEx/skills.yml");
	    if (!f.exists()) {
		f.createNewFile();
		FileConfiguration modif = YamlConfiguration.loadConfiguration(f);
		ConfigurationSection Modes = modif.createSection("Types");
		Modes.set("Atk", "[ATK] ");
		Modes.set("Def", "[DEF] ");
		Modes.set("Vis", "[VIS] ");
		Modes.set("Zon", "[ZON] ");
		Modes.set("DefVis", "[DEF/VIS] ");
		Modes.set("DefZon", "[DEF/ZON] ");
		Modes.set("Cooldown", 20);
		ConfigurationSection Frances = modif.createSection("French");
		Frances.set("use", "Vous utilisez ");
		ConfigurationSection Attaques = Frances.createSection("Atk");
		Attaques.set("One", "Coup Puissant");
		Attaques.set("Two", "Tranché Explosif");
		Attaques.set("Three", "Renvoi");
		Attaques.set("Four", "Faucheuse Obscure");
		Attaques.set("Five", "Baiser Vampirique");
		Attaques.set("Six", "Jugement Dernier");
		Attaques.set("Seven", "Flèche Confuse");
		Attaques.set("Eight", "Flèche de Foudre");
		Attaques.set("Nine", "Flèche Dégénérative");
		Attaques.set("Ten", "Flèche Explosive");
		Attaques.set("Eleven", "Coup Etourdissant");
		Attaques.set("Twelve", "Vol de Vie");
		Attaques.set("Thirteen", "Lame Empoisonnée");
		Attaques.set("Fourteen", "Coup Traitre");
		ConfigurationSection Defences = Frances.createSection("Def");
		Defences.set("Two", "Saut Titanesque");
		Defences.set("Three", "Vol du Jaguar");
		Defences.set("Four", "Berseker");
		Defences.set("Six", "Saut Eclair");
		Defences.set("Seven", "ChauveSouris");
		Defences.set("Eight", "Rage");
		Defences.set("Nine", "Dopage");
		Defences.set("Ten", "Invisibilité");
		ConfigurationSection Passives = Frances.createSection("Pass");
		Passives.set("Nothing", "Aucune capacité");
		ConfigurationSection Zones = Frances.createSection("Zon");
		Zones.set("One", "Etres Nocturnes");
		Zones.set("Two", "Prison Temporelle");
		Zones.set("Three", "Orage");
		Zones.set("Four", "Embrasement");
		Zones.set("Six", "Drainage");
		Zones.set("Seven", "Revelation");
		Zones.set("Nine", "Implosion");
		ConfigurationSection Visee = Frances.createSection("Vis");
		Visee.set("One", "Soin");
		Visee.set("Two", "Prière");
		Visee.set("Three", "Dissipation");
		Visee.set("Four", "Luminos");
		Visee.set("Five", "Malédiction");
		Visee.set("Six", "Communion Elémentaire");
		Visee.set("Seven", "Traque");
		ConfigurationSection Anglais = modif.createSection("English");
		Anglais.set("use", "You use ");
		Attaques = Anglais.createSection("Atk");
		Attaques.set("One", "Powerful Blow");
		Attaques.set("Two", "Explode Sharp");
		Attaques.set("Three", "Poke");
		Attaques.set("Four", "Dark Reaper");
		Attaques.set("Five", "Vampire Kiss");
		Attaques.set("Six", "Last Judgment");
		Attaques.set("Seven", "Confused Arrow");
		Attaques.set("Eight", "Lightning Arrow");
		Attaques.set("Nine", "Degenerated Arrow");
		Attaques.set("Ten", "Explosive Arrow");
		Attaques.set("Eleven", "Stunning Punch");
		Attaques.set("Twelve", "Life Drain");
		Attaques.set("Thirteen", "Poisoned Blade");
		Attaques.set("Fourteen", "Treachery");
		Defences = Anglais.createSection("Def");
		Defences.set("Two", "Titanic Jump");
		Defences.set("Three", "Flight of Jaguar");
		Defences.set("Four", "Berserker");
		Defences.set("Six", "Flash");
		Defences.set("Seven", "Bat");
		Defences.set("Eight", "Fury");
		Defences.set("Nine", "Doping");
		Defences.set("Ten", "Invisibility");
		Passives = Anglais.createSection("Pass");
		Passives.set("Nothing", "No ability");
		Zones = Anglais.createSection("Zon");
		Zones.set("One", "Nocturnal Being");
		Zones.set("Two", "Temporal Jail");
		Zones.set("Three", "Storm");
		Zones.set("Four", "Burning");
		Zones.set("Six", "Drain");
		Zones.set("Seven", "Revelation");
		Zones.set("Nine", "Implosion");
		Visee = Anglais.createSection("Vis");
		Visee.set("One", "Heal");
		Visee.set("Two", "Prayer");
		Visee.set("Three", "Total Dispersion");
		Visee.set("Four", "Lighty");
		Visee.set("Five", "Curse");
		Visee.set("Six", "Elementary Communion");
		Visee.set("Seven", "Track Down");
		modif.save(f);
	    }
	} catch (Exception e) {
	}
    }

    public void onDisable() {
	System.out.println("[NirvaEx] Plugin disconnected");
    }

    public boolean hasPermission(Player p, String perm) {
	if (!p.isOp() && !(pManager != null && pManager.has(p, perm))) {
	    return false;
	} else {
	    return true;
	}
    }
    
    public WorldGuardPlugin getWorldGuard(){
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))){
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }

}
