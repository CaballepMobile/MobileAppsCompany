package com.example.admin.daily1week3.models;

public class Champion {
    private int ChampionId;
    private String Name;
    private String Role;
    private byte Level;
    private String PictureFile;

    public Champion(int championId, String name, String role, byte level, String pictureFile) {
        ChampionId = championId;
        Name = name;
        Role = role;
        Level = level;
        PictureFile = pictureFile;
    }

    public int getChampionId() {
        return ChampionId;
    }

    public void setChampionId(int championId) {
        ChampionId = championId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public byte getLevel() {
        return Level;
    }

    public void setLevel(byte level) {
        Level = level;
    }

    public String getPictureFile() {
        return PictureFile;
    }

    public void setPictureFile(String pictureFile) {
        PictureFile = pictureFile;
    }
}
