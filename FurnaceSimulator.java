package com.sleepmod.core;

import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_2363;
import net.minecraft.class_2609;
import net.minecraft.class_2680;
import net.minecraft.class_3218;

public class FurnaceSimulator {
   private static final int RADIUS = 128;
   private static final int VERTICAL = 32;

   public static void simulate(class_3218 world, class_1657 ignored, long sleepTick) {
      for (class_1657 p : world.method_18456()) {
         class_2338 center = p.method_24515();

         for (class_2338 pos : class_2338.method_10097(center.method_10069(-128, -32, -128), center.method_10069(128, 32, 128))) {
            class_2680 state = world.method_8320(pos);
            if (state.method_26204() instanceof class_2363 && world.method_8321(pos) instanceof class_2609 furnace) {
               for (int i = 0; i < sleepTick; i++) {
                  class_2609.method_31651(world, pos, state, furnace);
               }
            }
         }
      }
   }
}
