
# Wake On LAN Program

This is a simple Kotlin program to send a Wake-on-LAN (WOL) magic packet to wake up computers on a network.

## Features
- Send WOL packets by specifying the MAC address, broadcast address, and port.
- Easy to use command line interface.
- Written in Kotlin for simplicity and portability.

## Requirements
- **Java Runtime Environment (JRE) 19 or higher**
- **Kotlin Runtime**

## Usage

### Command Line
To run the program, use the following syntax:
```
java -jar WakeOnLan.jar <MAC Address> <Broadcast Address> <Port>
```

### Arguments
- `<MAC Address>`: The target device's MAC address in the format `XX:XX:XX:XX:XX:XX`.
- `<Broadcast Address>`: The broadcast address of the target network (e.g., `192.168.1.255`).
- `<Port>`: The port number (usually `9` for Wake-on-LAN).

### Example
```sh
java -jar WakeOnLan.jar 01:23:45:67:89:AB 192.168.1.255 9
```

This command sends a WOL magic packet to the device with the MAC address `01:23:45:67:89:AB` on the broadcast address `192.168.1.255` using port `9`.

## Error Handling
- If an invalid MAC address, broadcast address, or port is provided, the program will output an error message.
- Example of invalid input:
  ```sh
  java -jar WakeOnLan.jar 01:23:ZZ:67:89:AB 192.168.1.255 9
  ```
  Output:
  ```
  Failed to send WOL Packet: Invalid MAC Address
  ```

## How It Works
1. The MAC address is parsed into bytes.
2. A magic packet is constructed by prepending six `0xFF` bytes followed by the MAC address repeated 16 times.
3. The magic packet is sent as a UDP packet to the specified broadcast address and port.

## Limitations
- Ensure that your device and network support Wake-on-LAN.
- The program requires network permissions to send UDP packets.

## Build and Run
To build the program:
1. Clone the repository.
2. Run using the usage instructions above.
---

