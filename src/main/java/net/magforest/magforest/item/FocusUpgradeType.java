package net.magforest.magforest.item;

import com.sun.jna.platform.unix.X11;
import net.magforest.magforest.item.aspect.Aspect;
import net.magforest.magforest.item.aspect.AspectList;
import net.magforest.magforest.magforest;
import net.minecraft.util.ResourceLocation;

public class FocusUpgradeType {

    public static FocusUpgradeType[] types = new FocusUpgradeType[20];
    public short id;
    public ResourceLocation icon;
    public String name;
    public String text;
    public AspectList aspects;

    public static FocusUpgradeType frugal = new FocusUpgradeType(1, new ResourceLocation("thaumcraft", "textures/foci/frugal.png"), "focus.upgrade.frugal.name", "focus.upgrade.frugal.text", (new AspectList()).add(Aspect.HUNGER, 1));

    public FocusUpgradeType(int id, ResourceLocation icon, String name, String text, AspectList aspects) {
        this.id = (short)id;
        this.icon = icon;
        this.name = name;
        this.text = text;
        this.aspects = aspects;
        if(id < types.length && types[id] != null) {
            magforest.LOGGER.fatal("Focus Upgrade id " + id + " already occupied. Ignoring.");
        } else {
            if(id >= types.length) {
                FocusUpgradeType[] temp = new FocusUpgradeType[id + 1];
                System.arraycopy(types, 0, temp, 0, types.length);
                types = temp;
            }

            types[id] = this;
        }
    }



    public boolean equals(Object obj) {
        return obj instanceof FocusUpgradeType?this.id == ((FocusUpgradeType)obj).id:false;
    }
}
