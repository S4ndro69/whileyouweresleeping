package com.sleepmod.core;

import net.minecraft.class_1657;
import net.minecraft.class_2302;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_3218;

public class CropSimulator {
   private static final int RADIUS = 128;
   private static final int VERTICAL = 32;

   public static void simulate(class_3218 world, class_1657 ignored, long sleepTick) {
      for (class_1657 p : world.method_18456()) {
         class_2338 center = p.method_24515();

         for (class_2338 pos : class_2338.method_10097(center.method_10069(-128, -32, -128), center.method_10069(128, 32, 128))) {
            class_2680 state = world.method_8320(pos);
            if (state.method_26204() instanceof class_2302 crop) {
               class_2758 ageProperty = crop.method_9595().method_11663("age") instanceof class_2758 prop ? prop : null;
               if (ageProperty != null) {
                  int maxAge = crop.method_9827();

                  for (int i = 0; i < sleepTick; i++) {
                     int age = (Integer)state.method_11654(ageProperty);
                     if (age >= maxAge) {
                        break;
                     }

                     int newAge = Math.min(age + 1, maxAge);
                     state = (class_2680)state.method_11657(ageProperty, newAge);
                     world.method_8652(pos, state, 2);
                  }
               }
            }
         }
      }
   }
}
