package fred;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
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

        
        itemCrafter=new ItemCrafter(1000).setUnlocalizedName("CrafterTool").setCreativeTab(CreativeTabs.tabTools).setMaxStackSize(16);
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
        GameRegistry.addRecipe(new ItemStack(itemCrafter,16), "xxx","yyy","zzz",'x',new ItemStack(Item.pickaxeDiamond),'y',new ItemStack(Item.axeDiamond),'z',Item.shovelDiamond);
        
        //silk touch
        addSilkC(Item.pickaxeDiamond);
        addSilkC(Item.axeDiamond);
        addSilkC(Item.shovelDiamond);
        //Fortune
        addFortuneC(Item.pickaxeDiamond);
        addFortuneC(Item.axeDiamond);
        addFortuneC(Item.shovelDiamond);
    }
    private void addSilkC(Item tool)
    {
        ItemStack d=new ItemStack(tool);
        d.addEnchantment(Enchantment.silkTouch, 1);
        GameRegistry.addRecipe(d,"xzx","xyx","xxx",'x',new ItemStack(Block.blockDiamond),'y',new ItemStack(tool),'z',new ItemStack(itemCrafter));
    }
    private void addFortuneC(Item tool)
    {
        ItemStack d=new ItemStack(tool);
        d.addEnchantment(Enchantment.fortune, 1);
        GameRegistry.addRecipe(d,"xzx","xyx","xxx",'x',new ItemStack(Block.blockGold),'y',new ItemStack(tool),'z',new ItemStack(itemCrafter));
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent e)
    {
        
    }
    
    
}
