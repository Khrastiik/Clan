package mc.medveds.net.clan.command;

import mc.medveds.net.clan.Clan;
import mc.medveds.net.clan.entity.ClanEntity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CreateClan implements CommandExecutor {

    private Clan plugin = Clan.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)){
            return false;
        }

        if (!(strings[0].equals("create"))){
            return false;
        }

        Player player = (Player) commandSender;

        ClanEntity clan = new ClanEntity();

        clan.setName(strings[1]);

        clan.setOwner(player);

        plugin.clans.addClan(clan);

        return true;
    }

}
