package com.jamalam360;

import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CrowdinTranslate.downloadTranslations("excess-enchantments-fabric", ExcessEnchantmentsInit.MOD_ID);

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if(!ExcessEnchantmentsInit.versionCorrect) {
                Text outOfDateMessage = new LiteralText("Excess Enchantments is out of date, please update it to v" + ExcessEnchantmentsInit.remoteModVersion).styled(s -> s.withColor(TextColor.parse("#00cc00")).withBold(true).withItalic(true));

                if (client.player != null) {
                    client.player.sendMessage(outOfDateMessage, false);
                }
            }
        });
    }
}
