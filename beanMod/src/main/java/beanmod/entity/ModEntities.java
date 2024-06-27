package beanmod.entity;

import beanmod.CannedBeanMod;
import beanmod.entity.custom.BeanCanProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CannedBeanMod.MODID);
	
	
    public static final RegistryObject<EntityType<BeanCanProjectileEntity>> BEANS_PROJECTILE =
            ENTITY_TYPES.register("beans_projectile", () -> EntityType.Builder.
            		<BeanCanProjectileEntity>of(BeanCanProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("beans_projectile"));
	
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
}