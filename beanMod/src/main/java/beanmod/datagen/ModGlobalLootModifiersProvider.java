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
		addItemToChest("beans_from_village_butcher1", "village/village_butcher", ModItems.BEANS, 0.9f);
		addItemToChest("beans_from_village_butcher2", "village/village_butcher", ModItems.BEANS, 0.8f);
		addItemToChest("beans_from_village_butcher3", "village/village_butcher", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_desert1", "village/village_desert_house", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_desert2", "village/village_desert_house", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_fisher1", "village/village_fisher", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_fisher2", "village/village_fisher", ModItems.BEANS, 0.7f);
		
		addItemToChest("beans_from_village_plains1", "village/village_plains_house", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_plains2", "village/village_plains_house", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_savanna1", "village/village_savanna_house", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_savanna2", "village/village_savanna_house", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_snowy1", "village/village_snowy_house", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_snowy2", "village/village_snowy_house", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_taiga1", "village/village_taiga_house", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_village_taiga2", "village/village_taiga_house", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_igloo1", "igloo_chest", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_igloo2", "igloo_chest", ModItems.BEANS, 0.5f);
		
		addItemToChest("beans_from_village_weaponsmith", "village/village_weaponsmith", ModItems.BEANS, 0.2f);
		
		//WOODLAND MANSION
		addItemToChest("beans_from_woodland_mansion", "woodland_mansion", ModItems.BEANS, 0.1f);
		
		//DUNGEONS
		addItemToChest("beans_from_dungeon1", "simple_dungeon", ModItems.BEANS, 0.8f);
		addItemToChest("beans_from_dungeon2", "simple_dungeon", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_dungeon3", "simple_dungeon", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_dungeon4", "simple_dungeon", ModItems.BEANS, 0.2f);
		
		//MINESHAFT
		addItemToChest("beans_from_mineshaft1", "abandoned_mineshaft", ModItems.BEANS, 0.8f);
		addItemToChest("beans_from_mineshaft2", "abandoned_mineshaft", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_mineshaft3", "abandoned_mineshaft", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_mineshaft4", "abandoned_mineshaft", ModItems.BEANS, 0.2f);
		
		//PILLAGER OUTPOST
		addItemToChest("beans_from_pillager_outpost1", "pillager_outpost", ModItems.BEANS, 0.4f);
		addItemToChest("beans_from_pillager_outpost2", "pillager_outpost", ModItems.BEANS, 0.4f);
		
		//STRONGHOLDS
		addItemToChest("beans_from_stronghold_corridor1", "stronghold_corridor", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_stronghold_corridor2", "stronghold_corridor", ModItems.BEANS, 0.3f);
		addItemToChest("beans_from_stronghold_crossing1", "stronghold_crossing", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_stronghold_crossing2", "stronghold_crossing", ModItems.BEANS, 0.3f);
		
		//SHIPWRECK
		addItemToChest("beans_from_shipwreck_supply1", "shipwreck_supply", ModItems.BEANS, 0.7f);
		addItemToChest("beans_from_shipwreck_supply2", "shipwreck_supply", ModItems.BEANS, 0.5f);
		addItemToChest("beans_from_shipwreck_supply2", "shipwreck_supply", ModItems.BEANS, 0.3f);
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
