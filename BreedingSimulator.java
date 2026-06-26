package com.sleepmod.core;

import net.minecraft.class_1296;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_3218;

public class BreedingSimulator {
   private static final int RADIUS = 128;
   private static final int VERTICAL = 32;

   public static void simulate(class_3218 world, class_1657 ignored, long sleepTick) {
      for (class_1657 p : world.method_18456()) {
         class_2338 center = p.method_24515();
         class_2338 start = center.method_10069(-128, -32, -128);
         class_2338 end = center.method_10069(128, 32, 128);
         class_238 area = new class_238(start.method_46558(), end.method_46558());

         for (class_1296 animal : world.method_8390(class_1296.class, area, e -> true)) {
            int age = animal.method_5618();
            if (age > 0) {
               int reduced = Math.max(0, age - (int)sleepTick);
               animal.method_5614(reduced);
            }
         }
      }
   }
}
