package covers1624.legacyfarms.intermods;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.intermods.IC2.IC2Module;
import covers1624.legacyfarms.intermods.agricraft.AgricraftModule;
import covers1624.legacyfarms.reference.Reference;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

public class IntermodsHandler {

	public static void loadAllModules() {
		LegacyFarms.logger.trace("Loading Modules..");
		if (Loader.isModLoaded("AgriCraft")) {
			LegacyFarms.logger.trace("Agricraft Found!");
			AgricraftModule.init();
		}
		if (Loader.isModLoaded("IC2")) {
			IC2Module.init();
		}
		if (Loader.isModLoaded("Waila")) {
			LegacyFarms.logger.trace("Registering Waila Module.");
			FMLInterModComms.sendMessage("Waila", "register", Reference.WAILA_CALLBACK);
		}
		LegacyFarms.logger.trace("Loading Modules Complete.");
	}

	public static void loadAllModuleRecipes() {
		if (Loader.isModLoaded("AgriCraft")) {
			AgricraftModule.initRecipes();
		}
	}

}
