package fred;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fred.items.ItemCrafter;

@Mod(modid = "toolsMod", name="Tools", version="1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Tools
{
    @Instance
    public static Tools instance;
    
    @SidedProxy(clientSide="fred.client.ClientProxy", serverSide="fred.CommonProxy")
    public static CommonProxy proxy;
    //items
        //crafter
        public static Item itemCrafter; 
        //--crafter
    //--items
    
    
    
    /**
     * constructor
     */
    public Tools()
    {

        
        itemCrafter=new ItemCrafter(1000).setUnlocalizedName("CrafterTool").setCreativeTab(CreativeTabs.tabTools).setMaxStackSize(1);
        LanguageRegistry.addName(itemCrafter, "Portable crafter");
    }
    
    @PreInit
    public void preInit(FMLPreInitializationEvent e)
    {
        
    }
    @Init
    public void ini(FMLInitializationEvent e)
    {
        System.out.println("Tools mod ini...");
        GameRegistry.addRecipe(new ItemStack(itemCrafter), "xxx", "xyx","xxx",'x',new ItemStack(Block.planks),'y',new ItemStack(Block.cobblestone));
        
        NetworkRegistry.instance().registerGuiHandler(this, Tools.proxy);
    }
    @PostInit
    public void postInit(FMLPostInitializationEvent e)
    {
        
    }
    
    
}
