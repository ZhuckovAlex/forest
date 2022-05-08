package net.magforest.magforest.util;

import net.magforest.magforest.magforest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, magforest.MOD_ID);

    public static final RegistryObject<SoundEvent> CRISTAL_BREAK =
            registerSoundEvent("cristal_break");
    public static final RegistryObject<SoundEvent> MOON_TEAR =
            registerSoundEvent("moon_tear");
    public static final RegistryObject<SoundEvent> CRAFTSTART =
            registerSoundEvent("craftstart");
    public static final RegistryObject<SoundEvent> ALCHEMY =
            registerSoundEvent("alchemy");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(magforest.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
