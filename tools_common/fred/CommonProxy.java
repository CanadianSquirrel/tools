package fred;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fred.gui.GuiCrafter;

public class CommonProxy implements IGuiHandler
{
    public static String ITEMS_PNG = "/fred/items.png";
    
    public void registerRenderers()
    {
        
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        // TODO Auto-generated method stub
        switch(ID)
        {
            case 0: return new GuiCrafter(player.inventory);
        }
        return null;
    }
}
