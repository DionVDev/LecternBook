package nl.dionvdev.lecternbook;

import nl.dionvdev.lecternbook.commands.LecternBookCommand;
import nl.dionvdev.lecternbook.listener.LecternClickListener;
import nl.dionvdev.lecternbook.manager.LecternBookManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LecternBook extends JavaPlugin {

    private LecternBookManager lecternBookManager;
    private static LecternBook instance;

    @Override
    public void onEnable() {
        lecternBookManager = new LecternBookManager();
        instance = this;

        getCommand("lb").setExecutor(new LecternBookCommand());
        getServer().getPluginManager().registerEvents(new LecternClickListener(), this);

    }

    @Override
    public void onDisable() {
    }


    public LecternBookManager getLecternBookManager() {
        return lecternBookManager;
    }

    public static LecternBook inst() {
        return instance;
    }

}