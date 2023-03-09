package mc.medveds.net.clan.command;

import com.google.common.reflect.ClassPath;
import mc.medveds.net.clan.Clan;
import mc.medveds.net.clan.entity.ClanEntity;
import mc.medveds.net.clan.entity.ClansEntity;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CreateCMD implements CommandExecutor {

    private Clan plugin = Clan.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //Смотрит что написал игрок
        if (!(commandSender instanceof Player)){
            return false;
        }

        //Смотрит что ты написал имено "create"
        if (!(strings[0].equals("create"))){
            return false;
        }

        //Приравнивает сообщение от игрока
        Player player = (Player) commandSender;

        //Получает список всех кланов
        ArrayList<ClanEntity> listClan = plugin.clans.listClan();

        //Проверяет имена кланов которые уже сущечтвует
        for (int i = 0; i < listClan.size(); i++) {
            if (strings[1].equalsIgnoreCase(listClan.get(i).getName())){
                commandSender.sendMessage(color("&cТакой клан существует!"));
                return true;
            }
        }

        ClanEntity clan = new ClanEntity();

        clan.setName(strings[1]);

        clan.setOwner(player);

        plugin.clans.addClan(clan);

        commandSender.sendMessage(color("&aВы создали клан!"));

        return true;
    }

    //Добовляет возможность писать сообщения с цветом
    private String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
