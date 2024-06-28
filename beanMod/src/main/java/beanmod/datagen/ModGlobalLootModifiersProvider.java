package beanmod.datagen;

import java.util.concurrent.CompletableFuture;

import beanmod.CannedBeanMod;
import beanmod.item.ModItems;
import beanmod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import net.minecraftforge.registries.RegistryObject;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

	public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, CannedBeanMod.MODID, registries);
	}

	@Override
	protected void start() {
		//VILLAGE CHESTS
		addItemToChest("beans_from_village_butcher1", "village/village_butcher", ModItems.BEANS, 0.75f);
		addItemToChest("beans_from_village_butcher2", "village/village_butcher", ModItems.BEANS, 0.3f);
		addItemToChest("beans_from_village_butcher3", "village/village_butcher", ModItems.BEANS, 0.05f);
		
		addItemToChest("beans_from_village_desert", "village/village_desert_house", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_village_fisher", "village/village_fisher", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_village_plains", "village/village_plains_house", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_village_savanna", "village/village_savanna_house", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_village_snowy", "village/village_snowy_house", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_village_taiga", "village/village_taiga_house", ModItems.BEANS, 0.6f);
		addItemToChest("beans_from_igloo", "igloo_chest", ModItems.BEANS, 0.6f);
		
		addItemToChest("beans_from_village_weaponsmith", "village/village_weaponsmith", ModItems.BEANS, 0.2f);
		
		//WOODLAND MANSION
		addItemToChest("beans_from_woodland_mansion", "woodland_mansion", ModItems.BEANS, 0.05f);
		
		//DUNGEONS
		addItemToChest("beans_from_dungeon", "simple_dungeon", ModItems.BEANS, 0.4f);
		
		//MINESHAFT
		addItemToChest("beans_from_mineshaft", "abandoned_mineshaft", ModItems.BEANS, 0.4f);
		
		//PILLAGER OUTPOST
		addItemToChest("beans_from_pillager_outpost", "pillager_outpost", ModItems.BEANS, 0.4f);
		
		//STRONGHOLDS
		addItemToChest("beans_from_stronghold_corridor", "stronghold_corridor", ModItems.BEANS, 0.3f);
		addItemToChest("beans_from_stronghold_crossing", "stronghold_crossing", ModItems.BEANS, 0.3f);
		
		//SHIPWRECK
		addItemToChest("beans_from_shipwreck_supply1", "shipwreck_supply", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_shipwreck_supply2", "shipwreck_supply", ModItems.BEANS, 0.5f);
	}
	
	/**
	 * Adds a specific item to the loot table of a chest
	 * @param modifierName
	 * @param resourceLocationPath
	 * @param item
	 * @param probability
	 */
	private void addItemToChest(String modifierName, String resourceLocationPath, RegistryObject<Item> item, float probability) {
		add(modifierName, new AddItemModifier(new LootItemCondition[] {
				new LootTableIdCondition.Builder(new ResourceLocation("chests/"+resourceLocationPath)).build(),
				LootItemRandomChanceCondition.randomChance(probability).build()
		}, item.get()));
	}

}
