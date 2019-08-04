package cn.orecraft.blocklycraft;
/*
 * Created on 2019/5/26
 * Author: MaHua_A
 * Copyright 2019 by OreCraft Studio
 * DO NOT MODIFY THESE WORDS
 */


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class PluginMain extends JavaPlugin {
    private ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("Nashorn");

    @Override
    public void onEnable(){
        try {
            String scriptPath = "/bundle.js";
            BufferedReader  reader = new BufferedReader(new InputStreamReader(PluginMain.class.getResourceAsStream(scriptPath),"UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            scriptEngine.eval(buffer.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("Oops!We have serious problems.This plugin was accidentally modified?");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    @Override
    public void onDisable(){
        Bukkit.getLogger().info("Unloading scripts.....");
    }
}
