var Bukkit = Java.type("org.bukkit.Bukkit");
var Plugin = Bukkit.getPluginManager().getPlugin("${env.PLUGIN_NAME}");
print("§2This is bootstrap");
Plugin.loadjs("/scripts/hello.js");
