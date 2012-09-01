/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common.core.handlers;

import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 *
 * @author HMPerson1
 */
public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player) {
        // TODO: Handle the packet
    }
}
