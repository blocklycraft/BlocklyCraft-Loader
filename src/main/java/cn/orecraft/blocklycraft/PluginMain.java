package cn.orecraft.blocklycraft;
/*
 * Created on 2019/5/26
 * Author: MaHua_A
 * Copyright 2019 by OreCraft Studio
 * DO NOT MODIFY THESE WORDS
 */


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class PluginMain extends JavaPlugin {

    @Override
    public void onLoad(){
        Bukkit.getLogger().info("Loading scripts.....");
    }
    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){
        Bukkit.getLogger().info("Unloading scripts.....");
    }
}
