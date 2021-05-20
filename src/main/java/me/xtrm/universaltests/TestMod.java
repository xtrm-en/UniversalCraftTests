package me.xtrm.universaltests;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "testmod", version = "1.0.0")
public class TestMod {

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event){
        System.out.println("Post-Init");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGui(GuiOpenEvent event){
        GuiScreen gui = event.gui;
        if(gui instanceof GuiChat) { // idk mate
            event.gui = new TestScreen();
        }
    }

}
