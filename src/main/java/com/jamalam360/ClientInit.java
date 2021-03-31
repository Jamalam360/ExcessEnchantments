package com.jamalam360;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.Text;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if(!ExcessEnchantmentsInit.versionCorrect) {
                client.player.sendMessage(Text.of("Excess Enchantments is out of date, please update it to the latest version"), false);
            }
        });
    }
}
