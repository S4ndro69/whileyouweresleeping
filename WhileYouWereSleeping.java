package com.sleepmod.core;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.server.MinecraftServer;

public class WhileYouWereSleeping implements ModInitializer {
   public static final String MOD_ID = "while_you_were_sleeping";
   private final Set<UUID> sleepingPlayers = new HashSet<>();

   public void onInitialize() {
      ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
   }

   private void onServerTick(MinecraftServer server) {
      for (class_3218 world : server.method_3738()) {
         for (class_3222 player : world.method_18456()) {
            UUID id = player.method_5667();
            boolean isSleeping = player.method_6113();
            boolean wasSleeping = this.sleepingPlayers.contains(id);
            if (wasSleeping && !isSleeping) {
               long sleepDuration = 5900L;
               long tick = sleepDuration;
               CropSimulator.simulate(world, player, tick);
               FurnaceSimulator.simulate(world, player, tick);
               BreedingSimulator.simulate(world, player, tick);
               this.sleepingPlayers.remove(id);
            } else if (isSleeping && !wasSleeping) {
               this.sleepingPlayers.add(id);
            }
         }
      }
   }
}
