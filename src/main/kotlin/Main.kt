package com.wol

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun main(args: Array<String>){
    if(args.size < 3){
        println("Usage: java -jar WakeOnLan.jar <MAC Address> <Broadcast Address> <Port>")
        return
    }

    val macAddress = args[0]
    val broadcastAddress = args[1]
    val port = args[2].toIntOrNull() ?: run {
        println("Invalid Port Number: ${args[2]}")
        return
    }

    try {
        sendWakeOnLanPacket(macAddress, broadcastAddress, port)
        println("WOL Packet sent to $macAddress via $broadcastAddress on port $port")
    } catch (exception: Exception) {
        println("Failed to send WOL Packet: ${exception.message}")
    }

}

fun sendWakeOnLanPacket(macAddress: String, broadcastAddress: String, port: Int) {
    // convert mac to bytes
    val macBytes = macAddress.split(":").map { it.toInt(16).toByte() }.toByteArray()

    // create magic packet
    val packetData = ByteArray(102)
    for (i in 0 until 6) packetData[i] = 0xFF.toByte() // First 6 bytes are 0xFF
    for (i in 6 until packetData.size) packetData[i] = macBytes[i % 6] // Repeat MAC 16 times

    // Send the packet
    val address = InetAddress.getByName(broadcastAddress)
    val packet = DatagramPacket(packetData, packetData.size, address, port)
    DatagramSocket().use { socket -> socket.send(packet)}
}
