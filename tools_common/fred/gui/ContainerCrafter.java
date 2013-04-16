package fred.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerCrafter extends Container
{
    public ContainerCrafter(InventoryPlayer invPlayer)
    {
        bindPlayerInventory(invPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        
        Slot slot = (Slot)this.inventorySlots.get(par2);
        ItemStack itemstack = null;
        
        if (slot != null && slot.getHasStack())
        {
            itemstack=slot.getStack();
            ItemStack tStack=itemstack.copy();
            if(par2>=0 && par2<27)
            {
               if(! this.mergeItemStack( slot.getStack(), 27,36, true))
               {
                   return null;
               }
               slot.onSlotChange(itemstack, tStack);
            }else if ( par2>=27 && par2<36)
            {
                if(!this.mergeItemStack( slot.getStack(), 0,26, true))
                {
                    return null;
                }
                slot.onSlotChange(itemstack, tStack);
            }
            if (itemstack.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack);
        }

        return itemstack;
        }
    
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) 
    {
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9+9,
                                        8 + j * 18, 84 + i * 18));
                }
        }

        for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        // TODO Auto-generated method stub
        return true;
    }

}
