package beanmod.datagen;

import java.util.concurrent.CompletableFuture;

import beanmod.CannedBeanMod;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CannedBeanMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		
		generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
//		generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
//		
//		generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput, lookupProvider));
//		generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
//		generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput, lookupProvider));
	}
}
