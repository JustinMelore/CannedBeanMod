package beanmod.datagen;

import beanmod.CannedBeanMod;
import beanmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, CannedBeanMod.MODID, existingFileHelper);
	}

	//TODO Create model builder for throwable beans
	@Override
	protected void registerModels() {
		simpleItem(ModItems.OPENED_BEANS);
		
	}
	
	
	private ItemModelBuilder simpleItem(RegistryObject<net.minecraft.world.item.Item> openedBeans) {
		return withExistingParent(openedBeans.getId().getPath(), 
				new ResourceLocation("item/generated")).texture("layer0", 
						new ResourceLocation(CannedBeanMod.MODID, "item/" + openedBeans.getId().getPath()));
	}
}
