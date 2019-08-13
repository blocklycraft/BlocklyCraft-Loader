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
import javax.script.SimpleBindings;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PluginMain extends JavaPlugin {
    private ScriptEngine scriptEngine = new ScriptEngineManager(null).getEngineByName("Nashorn");

    @Override
    public void onEnable() {
        try {
            String scriptPath = "/bundle.js";
            BufferedReader reader = new BufferedReader(new InputStreamReader(PluginMain.class.getResourceAsStream(scriptPath), "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            SimpleBindings bindings = new SimpleBindings();
            bindings.put("__plugin",this);
            scriptEngine.eval(buffer.toString(),bindings);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("Oops!We have serious problems.This plugin was accidentally modified?");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Unloading scripts.....");
    }
}
