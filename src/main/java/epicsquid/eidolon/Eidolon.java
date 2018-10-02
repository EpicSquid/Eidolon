package epicsquid.eidolon;

import epicsquid.eidolon.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Eidolon.MODID, version = Eidolon.VERSION, name = Eidolon.NAME)
public class Eidolon {
  public static final String MODID = "eidolon-3";
  public static final String DOMAIN = "eidolon";
  public static final String NAME = "Eidolon";
  public static final String VERSION = "@VERSION@";

  public static ModContainer CONTAINER = null;

  @SidedProxy(clientSide = "epicsquid.eidolon.proxy.ClientProxy", serverSide = "epicsquid.eidolon.proxy.CommonProxy")
  public static CommonProxy proxy;

  @Instance(MODID) public static Eidolon instance;

//  public static CreativeTabs tab = new CreativeTabs("eidolon") {
//    @Override
//    public String getTabLabel() {
//      return "eidolon";
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public ItemStack getTabIconItem() {
//      return new ItemStack(ModItems.carapace, 1);
//    }
//  };

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    CONTAINER = Loader.instance().activeModContainer();
    MinecraftForge.EVENT_BUS.register(new RegistryManager());
    proxy.preInit(event);
  }

  public static Eidolon getInstance() {
    return instance;
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
  }
}
