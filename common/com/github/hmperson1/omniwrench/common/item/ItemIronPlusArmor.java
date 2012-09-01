/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common.item;

import com.github.hmperson1.omniwrench.common.lib.Reference;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

/**
 *
 * @author HMPerson1
 */
public class ItemIronPlusArmor extends ItemArmor implements IArmorTextureProvider {

    /**
     * The location of the armor's texture. (Primary)
     */
    private static final String ARMOR_TEXTURE_1 = Reference.ARMOR_TEXTURE_LOCATION + Reference.IRONPL_ARMOR_TEXTURE_1;
    /**
     * The location of the armor's texture. (Secondary)
     */
    private static final String ARMOR_TEXTURE_2 = Reference.ARMOR_TEXTURE_LOCATION + Reference.IRONPL_ARMOR_TEXTURE_2;

    /**
     *
     * @param id This item's ID
     * @param type Which armor part
     */
    public ItemIronPlusArmor(int id, int type) {
        super(id, EnumArmorMaterial.IRON, 2, type);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        setMaxDamage(EnumArmorMaterial.DIAMOND.getDurability(type) * 2);
    }

    @Override
    public String getArmorTextureFile(ItemStack itemstack) {
        return armorType == 2 ? ARMOR_TEXTURE_2 : ARMOR_TEXTURE_1;
    }
}
