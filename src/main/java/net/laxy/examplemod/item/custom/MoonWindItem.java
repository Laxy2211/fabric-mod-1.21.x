package net.laxy.examplemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.security.Key;
import java.util.List;
import java.util.Map;

public class MoonWindItem extends Item {
    private static final Map<Block,Block> MOON_WIND_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.DIAMOND_BLOCK, Blocks.COPPER_BLOCK,
                    Blocks.SAND, Blocks.SANDSTONE,
                    Blocks.OBSIDIAN, Blocks.NETHERITE_BLOCK


            );
    public MoonWindItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(MOON_WIND_MAP.containsKey(clickedBlock)){
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(),MOON_WIND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1,((ServerWorld) world ), ((ServerPlayerEntity) context.getPlayer()),
                       item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND) );

                world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.examplemod.moon_wind.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
