/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.hmperson1.omniwrench.common.item;

import com.github.hmperson1.omniwrench.common.lib.ItemIds;
import com.sun.org.apache.xml.internal.utils.ObjectPool;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RecipesArmor;
import net.minecraft.src.ShapedRecipes;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 *
 * @author HMPerson1
 */
public class ItemManager {

    public static Item wrenchHead;
    public static Item wrenchCore;
    public static Item wrenchHandle;
    public static Item omniwrench;
    public static Item ironPlus;
    public static Item selfRepairCore;
    public static Item helmetIronPlus;
    public static Item plateIronPlus;
    public static Item legsIronPlus;
    public static Item bootsIronPlus;

    /**
     * Initializes all items, item names, and recipes.
     */
    public static void init() {
        // Try to use generic item classes
        wrenchHead = new ItemWrenchPart(ItemIds.WRENCH_HEAD).setIconCoord(0, 0)
                .setItemName("wrenchHead").setTabToDisplayOn(CreativeTabs.tabMisc);
        wrenchCore = new ItemWrenchPart(ItemIds.WRENCH_CORE).setIconCoord(1, 0)
                .setItemName("wrenchCore").setTabToDisplayOn(CreativeTabs.tabMisc);
        wrenchHandle = new ItemWrenchPart(ItemIds.WRENCH_HANDLE).setIconCoord(2, 0)
                .setItemName("wrenchHandle").setTabToDisplayOn(CreativeTabs.tabMisc);
        omniwrench = new ItemOmniwrench(ItemIds.OMNIWRENCH).setIconCoord(3, 0)
                .setItemName("omniwrench").setTabToDisplayOn(CreativeTabs.tabMisc);
        ironPlus = new ItemIronPlus(ItemIds.IRON_PLUS).setIconCoord(4, 0)
                .setItemName("ironPlus").setTabToDisplayOn(CreativeTabs.tabMaterials);
        // ItemOmniwrench and ItemIronPlus both override methods and must have their own class
        helmetIronPlus = new ItemIronPlusArmor(ItemIds.ARMOR_HELMET, 0).setIconCoord(0, 1)
                .setItemName("helmetIronPlus").setTabToDisplayOn(CreativeTabs.tabCombat);
        plateIronPlus = new ItemIronPlusArmor(ItemIds.ARMOR_PLATE, 1).setIconCoord(1, 1)
                .setItemName("chestplateIronPlus").setTabToDisplayOn(CreativeTabs.tabCombat);
        legsIronPlus = new ItemIronPlusArmor(ItemIds.ARMOR_LEGS, 2).setIconCoord(2, 1)
                .setItemName("leggingsIronPlus").setTabToDisplayOn(CreativeTabs.tabCombat);
        bootsIronPlus = new ItemIronPlusArmor(ItemIds.ARMOR_BOOTS, 3).setIconCoord(3, 1)
                .setItemName("bootsIronPlus").setTabToDisplayOn(CreativeTabs.tabCombat);
        selfRepairCore = new ItemWrenchPart(ItemIds.SELF_REPAIR_CORE).setIconCoord(5, 0)
                .setItemName("selfRepairCore").setTabToDisplayOn(CreativeTabs.tabMisc);

        LanguageRegistry.addName(omniwrench, "Omniwrench 9000");
        LanguageRegistry.addName(wrenchHead, "Wrench Head");
        LanguageRegistry.addName(wrenchCore, "Wrench Core");
        LanguageRegistry.addName(wrenchHandle, "Wrench Handle");
        LanguageRegistry.addName(ironPlus, "Super Iron");
        LanguageRegistry.addName(selfRepairCore, "Self-Repairing Core");
        LanguageRegistry.addName(helmetIronPlus, "Super Iron Helmet");
        LanguageRegistry.addName(plateIronPlus, "Super Iron Chestplate");
        LanguageRegistry.addName(legsIronPlus, "Super Iron Leggings");
        LanguageRegistry.addName(bootsIronPlus, "Super Iron Boots");

        addCraftingRecipes();
    }

    /**
     * Adds in all the crafting recipes.
     */
    private static void addCraftingRecipes() {
        CraftingManager instance = CraftingManager.getInstance();
        instance.addRecipe(new ItemStack(wrenchHead),
                           new Object[]{RECIPE_WRENCH_HEAD, 'I', Item.ingotIron, 'S', ironPlus, 'D', Item.diamond});
        instance.addRecipe(new ItemStack(wrenchCore),
                           new Object[]{RECIPE_WRENCH_CORE, 'C', selfRepairCore, 'S', ironPlus});
        instance.addRecipe(new ItemStack(wrenchHandle),
                           new Object[]{RECIPE_WRENCH_HANDLE, 'I', Item.ingotIron, 'S', ironPlus});
        instance.addRecipe(new ItemStack(omniwrench),
                           new Object[]{RECIPE_OMNIWRENCH, 'H', wrenchHead, 'C', wrenchCore, 'h', wrenchHandle});
        instance.addRecipe(new ItemStack(ironPlus),
                           new Object[]{RECIPE_IRON_PLUS, 'I', Item.ingotIron, 'D', Item.diamond});
        instance.addRecipe(new ItemStack(selfRepairCore),
                           new Object[]{RECIPE_SELF_REPAIR_CORE, 'I', ironPlus, 'R', Item.redstone, 'D', Block.blockDiamond});
        instance.addRecipe(new ItemStack(helmetIronPlus),
                           new Object[]{RECIPE_ARMOR_HELMET, 'X', ironPlus});
        instance.addRecipe(new ItemStack(plateIronPlus),
                           new Object[]{RECIPE_ARMOR_PLATE, 'X', ironPlus});
        instance.addRecipe(new ItemStack(legsIronPlus),
                           new Object[]{RECIPE_ARMOR_LEGS, 'X', ironPlus});
        instance.addRecipe(new ItemStack(bootsIronPlus),
                           new Object[]{RECIPE_ARMOR_BOOTS, 'X', ironPlus});
    }
    private static final String[] RECIPE_WRENCH_HEAD = {
        "I I",
        "S S",
        "SDS"
    };
    private static final String[] RECIPE_WRENCH_CORE = {
        "SCS",
        "CSC",
        "SCS"
    };
    private static final String[] RECIPE_WRENCH_HANDLE = {
        " II",
        "I I",
        " IS"
    };
    private static final String[] RECIPE_OMNIWRENCH = {
        "H",
        "C",
        "h"
    };
    private static final String[] RECIPE_IRON_PLUS = {
        "III",
        "IDI",
        "III"
    };
    private static final String[] RECIPE_SELF_REPAIR_CORE = {
        "RIR",
        "IDI",
        "RIR"
    };
    private static final String[] RECIPE_ARMOR_HELMET = {
        "XXX",
        "X X"
    };
    private static final String[] RECIPE_ARMOR_PLATE = {
        "X X",
        "XXX",
        "XXX"
    };
    private static final String[] RECIPE_ARMOR_LEGS = {
        "XXX",
        "X X",
        "X X"
    };
    private static final String[] RECIPE_ARMOR_BOOTS = {
        "X X",
        "X X"
    };
}
