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
    public ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("Nashorn");

    @Override
    public void onLoad(){
        Bukkit.getLogger().info("Loading scripts.....");
        loadjs("/scripts/bootstrap.js");

    }
    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){
        Bukkit.getLogger().info("Unloading scripts.....");
    }
    public  void loadjs(String path){

        try {
            BufferedReader  reader = new BufferedReader(new InputStreamReader(PluginMain.class.getResourceAsStream(path),"UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            scriptEngine.eval(buffer.toString());
            reader.close();
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
