package mc.medveds.net.clan.entity;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClanEntity {

    private Player owner; //Влделец клана
    private Map<UUID, Player> players; //Список игроков, кто состоит в клане

    private String name; //Название клана

    //Получение владельца
    public Player getOwner() {
        return owner;
    }

    //Присваивание владельца
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    //Получение название клана
    public String getName() {
        return name;
    }

    //Присваивание название клана
    public void setName(String name) {
        this.name = name;
    }
}
