package mc.medveds.net.clan.command;

import mc.medveds.net.clan.Clan;
import mc.medveds.net.clan.entity.ClanEntity;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ClanCMD implements CommandExecutor {

    private Clan plugin = Clan.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        //Смотрит что написал игрок
        if (!(commandSender instanceof Player)){
            return false;
        }

//        //Смотрит что ты написал имено "create"
//        if (!(strings[0].equals("create"))){
//            return false;
//        }


        //Приравнивает сообщение от игрока
        Player player = (Player) commandSender;

        //Получает список всех кланов
        ArrayList<ClanEntity> listClan = plugin.clans.listClan();

        switch (strings[0]) {
            case "create":
                if (createClan(listClan, strings[1], player)) {
                    commandSender.sendMessage(color("&aВы создали клан!"));
                } else {
                    commandSender.sendMessage(color("&cТакой клан существует!"));
                }

                break;
            case "delete":
                if (deleteClan(listClan, player)) {
                    commandSender.sendMessage(color("&aКлан удален!"));
                } else {
                    commandSender.sendMessage(color("&aНе удалось удалить клан!"));
                }
                break;
            default:
                return false;

        }

        return true;
    }

    //Добовляет возможность писать сообщения с цветом
    private String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    private boolean createClan(ArrayList<ClanEntity> listClan, String nameClan, Player player) {
        //Проверяет имена кланов которые уже сущечтвует
        for (int i = 0; i < listClan.size(); i++) {
            if (nameClan.equalsIgnoreCase(listClan.get(i).getName())){
                return false;
            }
        }

        ClanEntity clan = new ClanEntity();

        clan.setName(nameClan);

        clan.setOwner(player);

        plugin.clans.addClan(clan);

        return true;
    }

    private boolean deleteClan(ArrayList<ClanEntity> listClan, Player player) {
        //Проверяет имена кланов которые уже сущечтвует
        for (int i = 0; i < listClan.size(); i++) {
            if (player.equals(listClan.get(i).getOwner())) {
                plugin.clans.removeClan(i);
                return true;
            }
        }

        return false;
    }
}
