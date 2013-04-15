package fred.client;

import net.minecraftforge.client.MinecraftForgeClient;
import fred.CommonProxy;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderers()
    {
        MinecraftForgeClient.preloadTexture(ITEMS_PNG);
    }

}
