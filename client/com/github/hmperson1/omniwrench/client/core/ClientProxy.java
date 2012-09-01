/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.client.core;

import com.github.hmperson1.omniwrench.common.core.CommonProxy;
import com.github.hmperson1.omniwrench.common.lib.Reference;

import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Client-side Proxy
 *
 * @author HMPerson1
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerClientHandlers() {
        // TODO: Register sounds n' stuff...
    }

    @Override
    public void preloadTextures() {
        MinecraftForgeClient.preloadTexture(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        MinecraftForgeClient.preloadTexture(Reference.ARMOR_TEXTURE_LOCATION + Reference.IRONPL_ARMOR_TEXTURE_1);
        MinecraftForgeClient.preloadTexture(Reference.ARMOR_TEXTURE_LOCATION + Reference.IRONPL_ARMOR_TEXTURE_2);
    }
}
