package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.crop.providers.entity.CropMushroom;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class CropProviderMushroom implements ICropProvider {
	@Override
	public boolean isGermling(ItemStack germling) {
		return germling.isItemEqual(new ItemStack(Blocks.brown_mushroom)) || germling.isItemEqual(new ItemStack(Blocks.red_mushroom));
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		Block block = blockPos.getBlock(world);
		return block == ForestryProxy.mushroom || block == Blocks.brown_mushroom_block || block == Blocks.red_mushroom_block;
	}

	@Override
	public void addWindfall(ArrayList<ItemStack> windfall) {

	}

	@Override
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		if (blockPos.getBlock(world) != Blocks.air || blockPos.copy().step(ForgeDirection.DOWN).getBlock(world) != Blocks.mycelium) {
			return false;
		}
		if (germling.isItemEqual(new ItemStack(Blocks.brown_mushroom))) {
			blockPos.setBlock(world, ForestryProxy.mushroom, 0);
		} else {
			blockPos.setBlock(world, ForestryProxy.mushroom, 1);
		}
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropMushroom(world, blockPos);
	}
}
