/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common.item;

import com.github.hmperson1.omniwrench.common.lib.Reference;

import net.minecraft.src.Item;

/**
 *
 * @author HMPerson1
 */
public class ItemWrenchHead extends Item {

    /**
     * 
     * @param id This item's ID
     */
    public ItemWrenchHead(int id) {
        super(id);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
    }
    
}
