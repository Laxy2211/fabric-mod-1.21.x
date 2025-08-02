package net.laxy.examplemod.block.custom;

import com.ibm.icu.impl.StaticUnicodeSets;
import net.laxy.examplemod.item.ModItems;
import net.laxy.examplemod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerConfigurationTask;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;
import java.util.Stack;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player,pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_HIT, SoundCategory.BLOCKS,1f,1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity){
           if (isValidItem(itemEntity.getStack())){
               itemEntity.setStack(new ItemStack(Items.DIAMOND,itemEntity.getStack().getCount()));
           }

        }
        super.onSteppedOn(world, pos, state, entity);
    }
    private boolean isValidItem(ItemStack stack){
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEM);

    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
