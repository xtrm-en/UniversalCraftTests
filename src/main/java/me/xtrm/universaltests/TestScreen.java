package me.xtrm.universaltests;

import gg.essential.universal.*;
import gg.essential.universal.wrappers.message.UMessage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ChatComponentText;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class TestScreen extends UScreen {

    public TestScreen(){
        super(true, GuiScale.Auto);
    }

    @Override
    public void initScreen(int width, int height) {
        super.initScreen(width, height);

        System.out.println("yes");
        this.buttonList.add(new GuiButton(-1, 10, 12, "Test button"));
        this.buttonList.add(new GuiButton(534681652, 10, 35, "Test but better"));
    }

    @Override
    public void onDrawScreen(int mouseX, int mouseY, float partialTicks) {
        UGraphics.drawString("gayming ayyy", 2, 2, -1, true); // who doesn't use shadows eww

        //TODO: make code that actually works, idk how to use the tessellator lmao

        UGraphics graphics = UGraphics.getFromTessellator(); // useless in 1.7 since Tessellator is a singleton, but should do the trick
        graphics.begin(GL11.GL_LINES);
        graphics.color(1F, 1F, 1F, 1F);
        graphics.pos(0, 0, 0);
        graphics.pos(3, 0, 0);
        graphics.pos(3, 3, 0);
        graphics.pos(0, 3, 0);
        UGraphics.draw(); // this isn't very nice, should we make it non-static?

        super.onDrawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void onKeyPressed(int keyCode, char typedChar, @Nullable UKeyboard.Modifiers modifiers) {
        System.out.println("Key pressed: " + Keyboard.getKeyName(keyCode) + " / " + typedChar);
        System.out.println("Modifiers: " + (modifiers != null ? modifiers.toString() : "null"));

        super.onKeyPressed(keyCode, typedChar, modifiers);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == -1) {
            UChat.actionBar("This shouldn't do anything");
            UChat.chat("helo");
        }
        if (button.id == 534681652){
            new UMessage("Hello", " yes ", new ChatComponentText(ChatColor.BLUE + "indeed")).chat();
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
