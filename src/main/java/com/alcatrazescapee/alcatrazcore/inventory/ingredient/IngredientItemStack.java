/*
 * Part of the AlcatrazCore mod by AlcatrazEscapee
 * Work under Copyright. Licensed under the GPL-3.0.
 * See the project LICENSE.md for more information.
 */

package com.alcatrazescapee.alcatrazcore.inventory.ingredient;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

import com.alcatrazescapee.alcatrazcore.util.CoreHelpers;

/**
 * An ingredient wrapper for an {@link ItemStack}
 *
 * @author AlcatrazEscapee
 */
public class IngredientItemStack implements IRecipeIngredient
{
    private final ItemStack stack;
    private final List<ItemStack> stacks;

    IngredientItemStack(@Nonnull ItemStack stack)
    {
        this.stack = stack;

        stacks = new ArrayList<>(1);
        stacks.add(stack);
    }

    @Nonnull
    @Override
    public String getName()
    {
        return stack.getTranslationKey();
    }

    @Nonnull
    @Override
    public List<ItemStack> getStacks()
    {
        return stacks;
    }

    @Override
    public boolean test(Object obj)
    {
        return obj instanceof ItemStack && CoreHelpers.doStacksMatch(stack, (ItemStack) obj) && ((ItemStack) obj).getCount() >= stack.getCount();
    }

    @Override
    public boolean matches(IRecipeIngredient other)
    {
        return other instanceof IngredientItemStack && CoreHelpers.doStacksMatch(stack, ((IngredientItemStack) other).stack);
    }
}