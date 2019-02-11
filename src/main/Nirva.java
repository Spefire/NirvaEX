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

import commands.ConsoleCommands;
import commands.PlayerCommands;
import ru.tehkode.permissions.PermissionManager;
import skills.AttackSkills;
import skills.DefenceSkills;
import skills.TargetedSkills;
import skills.AreaSkills;
import skills.SkillsNames;

public class Nirva extends JavaPlugin {

    private Nirva plugin;
    private AttackSkills atkSkills;
    private DefenceSkills defSkills;
    private AreaSkills areSkills;
    private TargetedSkills tgtSkills;
    private SkillsNames skillsNames;
    private ConsoleCommands consoleCmds;
    private PlayerCommands playerCmds;
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
	consoleCmds = new ConsoleCommands(this);
	pm.registerEvents(consoleCmds, this);
	playerCmds = new PlayerCommands(this);
	pm.registerEvents(playerCmds, this);
	atkSkills = new AttackSkills(this);
	pm.registerEvents(atkSkills, this);
	defSkills = new DefenceSkills(this);
	pm.registerEvents(defSkills, this);
	areSkills = new AreaSkills(this);
	pm.registerEvents(areSkills, this);
	tgtSkills = new TargetedSkills(this);
	pm.registerEvents(tgtSkills, this);
	skillsNames = new SkillsNames(this);
	pm.registerEvents(skillsNames, this);
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
		ConfigurationSection Francais = modif.createSection("French");
		Francais.set("change", " est devenu ");
		Francais.set("be", "Maintenant vous êtes un ");
		Francais.set("nopermittobe", "Vous n'avez pas la permission de devenir un ");
		Francais.set("nopermittostuff", "Vous n'avez pas la permission d'avoir votre équipement.");
		Francais.set("nohaveclass", "Vous n'avez pas de classe.");
		Francais.set("alreadyclass", "Vous avez déjà une classe !");
		Francais.set("recharge", "Chargé !");
		Francais.set("warning", "Vous ne pourrez plus changer de classe après.");
		Francais.set("worldtrue", "Dans le monde dans lequel vous êtes, le plugin NirvaEx est actif.");
		Francais.set("worldfalse", "Dans le monde dans lequel vous êtes, le plugin NirvaEx est inactif.");
		Francais.set("locationtrue", "Là où vous êtes situé, le plugin NirvaEx est actif.");
		Francais.set("locationfalse", "Là où vous êtes situé, le plugin NirvaEx est inactif.");
		ConfigurationSection English = modif.createSection("English");
		English.set("change", " become ");
		English.set("be", "Now you are a ");
		English.set("nopermittobe", "You don't have any permission to be a ");
		English.set("nopermittostuff", "You don't have any permission to have your stuff.");
		English.set("nohaveclass", "You don't have any class.");
		English.set("alreadyclass", "You have already a class !");
		English.set("recharge", "Loaded !");
		English.set("warning", "You won't to change your class after.");
		English.set("worldtrue", "In this world, the plugin NirvaEx is actived.");
		English.set("worldfalse", "In this world, the plugin NirvaEx is disactived.");
		English.set("locationtrue", "At your location, the plugin NirvaEx is actived.");
		English.set("locationfalse", "At your location, the plugin NirvaEx is disactived.");
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
		ConfigurationSection Francais = modif.createSection("French");
		Francais.set("use", "Vous utilisez ");
		ConfigurationSection Attaques = Francais.createSection("Atk");
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
		ConfigurationSection Defenses = Francais.createSection("Def");
		Defenses.set("Two", "Saut Titanesque");
		Defenses.set("Three", "Vol du Jaguar");
		Defenses.set("Four", "Berseker");
		Defenses.set("Six", "Saut Eclair");
		Defenses.set("Seven", "ChauveSouris");
		Defenses.set("Eight", "Rage");
		Defenses.set("Nine", "Dopage");
		Defenses.set("Ten", "Invisibilité");
		ConfigurationSection Passives = Francais.createSection("Pass");
		Passives.set("Nothing", "Aucune capacité");
		ConfigurationSection Zones = Francais.createSection("Zon");
		Zones.set("One", "Etres Nocturnes");
		Zones.set("Two", "Prison Temporelle");
		Zones.set("Three", "Orage");
		Zones.set("Four", "Embrasement");
		Zones.set("Six", "Drainage");
		Zones.set("Seven", "Revelation");
		Zones.set("Nine", "Implosion");
		ConfigurationSection Visee = Francais.createSection("Vis");
		Visee.set("One", "Soin");
		Visee.set("Two", "Prière");
		Visee.set("Three", "Dissipation");
		Visee.set("Four", "Luminos");
		Visee.set("Five", "Malédiction");
		Visee.set("Six", "Communion Elémentaire");
		Visee.set("Seven", "Traque");
		ConfigurationSection English = modif.createSection("English");
		English.set("use", "You use ");
		Attaques = English.createSection("Atk");
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
		Defenses = English.createSection("Def");
		Defenses.set("Two", "Titanic Jump");
		Defenses.set("Three", "Flight of Jaguar");
		Defenses.set("Four", "Berserker");
		Defenses.set("Six", "Flash");
		Defenses.set("Seven", "Bat");
		Defenses.set("Eight", "Fury");
		Defenses.set("Nine", "Doping");
		Defenses.set("Ten", "Invisibility");
		Passives = English.createSection("Pass");
		Passives.set("Nothing", "No ability");
		Zones = English.createSection("Zon");
		Zones.set("One", "Nocturnal Being");
		Zones.set("Two", "Temporal Jail");
		Zones.set("Three", "Storm");
		Zones.set("Four", "Burning");
		Zones.set("Six", "Drain");
		Zones.set("Seven", "Revelation");
		Zones.set("Nine", "Implosion");
		Visee = English.createSection("Vis");
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
