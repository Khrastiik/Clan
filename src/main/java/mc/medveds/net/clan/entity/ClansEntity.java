package mc.medveds.net.clan.entity;

import java.util.ArrayList;

public class ClansEntity {

    //Списко кланов
    private ArrayList<ClanEntity> clans = new ArrayList<>();

    //Добавление клана
    public void addClan(ClanEntity clan){
        clans.add(clan);
    }

}

