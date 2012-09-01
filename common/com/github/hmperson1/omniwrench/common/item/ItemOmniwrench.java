/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common.item;

import com.github.hmperson1.omniwrench.common.lib.Reference;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;
import net.minecraft.src.World;

/**
 *
 * @author HMPerson1
 */
public class ItemOmniwrench extends ItemSword {

    /**
     *
     * @param id This item's ID
     */
    public ItemOmniwrench(int id) {
        super(id, EnumToolMaterial.IRON);
        setTextureFile(Reference.SPRITE_SHEET_LOCATION + Reference.ITEM_SPRITE_SHEET);
        setMaxStackSize(1);
        setMaxDamage(0); // This makes it unbreakable
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return Item.shovelSteel.canHarvestBlock(block)
                || Item.pickaxeSteel.canHarvestBlock(block)
                || Item.swordSteel.canHarvestBlock(block)
                || Item.shears.canHarvestBlock(block);
    }

    @Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        return minOfArr(new float[]{
                    Item.swordSteel.getStrVsBlock(par1ItemStack, par2Block),
                    Item.pickaxeSteel.getStrVsBlock(par1ItemStack, par2Block),
                    Item.shovelSteel.getStrVsBlock(par1ItemStack, par2Block),
                    Item.shears.getStrVsBlock(par1ItemStack, par2Block)
                });
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving) {
        return Item.shears.itemInteractionForEntity(par1ItemStack, par2EntityLiving);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
        return Item.shears.onBlockStartBreak(itemstack, X, Y, Z, player);
    }

    @Override
    public int getItemEnchantability() {
        return 0;
    }

    //<editor-fold defaultstate="collapsed" desc="Utility Methods">
    /**
     * Recursively calls {@code Math.max()} on each float in {@code floats}
     *
     * @param floats The array to get the minimum of
     * @return The smallest value in the array
     */
    private static float minOfArr(float[] floats) {
        float min = Float.NEGATIVE_INFINITY;
        for (float f : floats) {
            min = Math.max(min, f);
        }
        return min;
    }
    //</editor-fold>
}
