/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common;

import com.github.hmperson1.omniwrench.common.core.CommonProxy;
import com.github.hmperson1.omniwrench.common.core.handlers.ConfigurationHandler;
import com.github.hmperson1.omniwrench.common.core.handlers.PacketHandler;
import com.github.hmperson1.omniwrench.common.item.ItemManager;
import com.github.hmperson1.omniwrench.common.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * The Omniwrench 9000 Mod! <br/><br/> Idea by Combine_Kegan.
 *
 * @author HMPerson1
 */
@Mod(modid = Reference.MOD_ID,
     name = Reference.MOD_NAME,
     version = Reference.VERSION)
@NetworkMod(channels = {Reference.CHANNEL_NAME},
            packetHandler = PacketHandler.class,
            clientSideRequired = true,
            serverSideRequired = false)
public class Omniwrench9000 {

    /**
     * The one and only instance of this mod.
     */
    @Mod.Instance
    public static Omniwrench9000 instance;
    /**
     * The proxy. This will be set (by Forge) to different classes depending on
     * whether this is running on a server or client.
     */
    @SidedProxy(clientSide = "com.github.hmperson1.omniwrench.client.core.ClientProxy",
                serverSide = "com.github.hmperson1.omniwrench.common.core.CommonProxy")
    public static CommonProxy proxy;

    /**
     * Called by FML before {@code load()}.
     *
     * @param evt The pre-init event
     */
    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent evt) {
        // Initialize the config handler
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());

        // Register client-side handlers
        proxy.registerClientHandlers();
    }

    /**
     * Called by FML to do the bulk of our initialization
     *
     * @param evt The init event
     */
    @Mod.Init
    public void load(FMLInitializationEvent evt) {

        // Load textures (client only)
        proxy.preloadTextures();

        // Initialize items/recipes
        ItemManager.init();
    }
}
