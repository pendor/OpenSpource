package com.pendorbound.openspource.cluster

import org.jupnp.registry.RegistryListener;
import org.jupnp.registry.Registry
import org.jupnp.model.meta.LocalDevice
import org.jupnp.model.meta.RemoteDevice
import org.jupnp.UpnpService
import org.jupnp.UpnpServiceImpl
import org.jupnp.model.message.header.STAllHeader
import org.jupnp.DefaultUpnpServiceConfiguration

object Locator {
  class Listener : RegistryListener {
    override fun localDeviceRemoved(registry: Registry?, device: LocalDevice?) {
      println("LocalDeviceRemoved: ${device?.displayString}")
    }

    override fun remoteDeviceDiscoveryStarted(registry: Registry?, device: RemoteDevice?) {
      println("RemoveDeviceDiscoverStarted: ${device?.displayString}")
    }

    override fun remoteDeviceDiscoveryFailed(registry: Registry?, device: RemoteDevice?, ex: Exception?) {
      println("RemoveDeviceDiscoverFailed: ${device?.displayString} :: ${ex?.message}")
    }

    override fun afterShutdown() {
      println("AfterShutdown")
    }

    override fun remoteDeviceAdded(registry: Registry?, device: RemoteDevice?) {
      println("RemoveDeviceAdded: ${device?.displayString}")
    }

    override fun remoteDeviceUpdated(registry: Registry?, device: RemoteDevice?) {
      println("RemoveDeviceUpdated: ${device?.displayString}")
    }

    override fun beforeShutdown(registry: Registry?) {
      println("BeforeShutdown")
    }

    override fun remoteDeviceRemoved(registry: Registry?, device: RemoteDevice?) {
      println("RemoveDeviceRemoved: ${device?.displayString}")
    }

    override fun localDeviceAdded(registry: Registry?, device: LocalDevice?) {
      println("LocalDeviceAdded: ${device?.displayString}")
    }
  }

  
  // This will create necessary network resources for UPnP right away
  val upnpService = UpnpServiceImpl(DefaultUpnpServiceConfiguration());
  
  fun startBroadcast() {
    println("Starting jUPnP...");
    val listener = Listener()
    
    upnpService.startup();
    upnpService.getRegistry().addListener(listener);
    // Send a search message to all devices and services, they should respond soon
    upnpService.getControlPoint().search(STAllHeader());
  }

  fun stopBroadcast() {
    println("Stopping jUPnP...");
    // Release all resources and advertise BYEBYE to other UPnP devices
    upnpService.shutdown();
  }
}