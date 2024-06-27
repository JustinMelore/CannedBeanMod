package beanmod.item;

import beanmod.CannedBeanMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registers all of the mod's items and stores all of those items' registry objects
 */
//TODO Register the throwable beans
public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, CannedBeanMod.MODID);
	
	public static final FoodProperties OPENED_BEANS_PROPS = new FoodProperties.Builder()
			.nutrition(4).saturationModifier(1.2f).build();
	
	public static final RegistryObject<Item> OPENED_BEANS = ITEMS.register("opened_beans",
			() -> new Item(new Item.Properties().food(OPENED_BEANS_PROPS)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
