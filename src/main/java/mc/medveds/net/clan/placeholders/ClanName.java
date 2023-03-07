package mc.medveds.net.clan.placeholders;

import mc.medveds.net.clan.Clan;
import mc.medveds.net.clan.entity.ClanEntity;
import mc.medveds.net.clan.entity.ClansEntity;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ClanName extends PlaceholderExpansion {

    private Clan plugin = Clan.getPlugin();

    @Override
    public @NotNull String getIdentifier() {
        return "owner";
    }

    @Override
    public @NotNull String getAuthor() {
        return null;
    }

    @Override
    public @NotNull String getVersion() {
        return null;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {

        //Проверка что пишет игрок
        if (player == null){
            return "";
        }

        //Проверка какой игрок является владельцев клана
        if (params.equals("player")){
            ArrayList<ClanEntity> allClans = plugin.clans.listClan();

            ClanEntity clan;

            //Цикл проверки сколько кланов существует выводит владельца и имя клана
            for (int i = 0; i < allClans.size(); i++){
                if (player.equals(allClans.get(i).getOwner())){
                    clan = allClans.get(i);
                    return clan.getName();
                }
            }
        }
        return "";
    }
}
