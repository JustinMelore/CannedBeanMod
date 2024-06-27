package beanmod.entity.custom;

import beanmod.entity.ModEntities;
import beanmod.item.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class BeanCanProjectileEntity extends ThrowableItemProjectile{

	public BeanCanProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public BeanCanProjectileEntity(Level pLevel) {
		super(ModEntities.BEANS_PROJECTILE.get(), pLevel);
	}
	
    public BeanCanProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.BEANS_PROJECTILE.get(), livingEntity, pLevel);
    }
	
	@Override
	protected Item getDefaultItem() {
		return ModItems.BEANS.get();
	}

	
    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte)3);
            //TODO Add sound effect
            this.discard();
        }
    }
    
    @Override
    protected void onHitBlock(BlockHitResult pResult) {
    	super.onHitBlock(pResult);
    	Direction projectileDirection = pResult.getDirection();
    	int x = pResult.getBlockPos().getX() + projectileDirection.getStepX();
;    	int y =  pResult.getBlockPos().getY() + projectileDirection.getStepY();
    	int z =  pResult.getBlockPos().getZ() + projectileDirection.getStepZ();
    	ItemEntity droppedItem = new ItemEntity(this.level(), x, y, z, 
    			new ItemStack(ModItems.OPENED_BEANS.get()));
    	this.level().addFreshEntity(droppedItem);
    }
    
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
    	super.onHitEntity(pResult);
        this.level().broadcastEntityEvent(this, (byte)3);
        Entity entity = pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 3f);
    	int x = pResult.getEntity().getBlockX();
;    	int y =  pResult.getEntity().getBlockY();
    	int z =  pResult.getEntity().getBlockZ();
    	ItemEntity droppedItem = new ItemEntity(this.level(), x, y, z, 
    			new ItemStack(ModItems.OPENED_BEANS.get()));
    	this.level().addFreshEntity(droppedItem);
    }
}
