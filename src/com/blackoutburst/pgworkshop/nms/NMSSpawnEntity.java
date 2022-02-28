package com.blackoutburst.pgworkshop.nms;

import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;

public class NMSSpawnEntity {

    public static void send(Player player, NMSEntities entity) {
        try {
            final Class<?> packetClass = NMS.getClass("PacketPlayOutSpawnEntity");
            final Class<?> entityClass = NMS.getClass("Entity");

            final Constructor<?> packetConstructor = packetClass.getConstructor(entityClass, int.class);

            final Object packet = packetConstructor.newInstance(entity.entity, entity.getNetworkID());

            NMS.sendPacket(player, packet);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
