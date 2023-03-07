package mc.medveds.net.clan;

import mc.medveds.net.clan.command.CreateClan;
import mc.medveds.net.clan.entity.ClansEntity;
import mc.medveds.net.clan.placeholders.ClanName;
import org.bukkit.plugin.java.JavaPlugin;

public final class Clan extends JavaPlugin {

    //Хранение главного плагина
    private static Clan plugin;

    //Подключение библиотеки кланов
    public ClansEntity clans;

    @Override
    public void onEnable() {
        //Присвоение главного объекта плагина
        plugin = this;
        //Создание объекта с кланами
        clans = new ClansEntity();

        //Подключение команды
        getPlugin().getCommand("clan").setExecutor(new CreateClan());

        //Зарегистрировали PlaceholderAPI
        new ClanName().register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Clan getPlugin() {
        return plugin;
    }

}
