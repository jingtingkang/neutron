/*
 * Copyright IBM Corporation, 2013.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.spi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "network")
@XmlAccessorType(XmlAccessType.NONE)

public class NeutronNetwork_Segment implements Serializable {
    // See OpenStack Network API v2.0 Reference for description of
    // annotated attributes

    private static final long serialVersionUID = 1L;

    //    @XmlElement (defaultValue="flat", name="provider:network_type")
    @XmlElement (defaultValue="flat", namespace="provider", name="network_type")
    String providerNetworkType;      // provider network type (flat or vlan)

    //    @XmlElement (name="provider:physical_network")
    @XmlElement (namespace="provider", name="physical_network")
    String providerPhysicalNetwork;  // provider physical network (name)

    //    @XmlElement (name="provider:segmentation_id")
    @XmlElement (namespace="provider", name="segmentation_id")
    String providerSegmentationID;   // provide segmentation ID (vlan ID)

    public NeutronNetwork_Segment() {
    }

    public String getProviderNetworkType() {
        return providerNetworkType;
    }

    public void setProviderNetworkType(String providerNetworkType) {
        this.providerNetworkType = providerNetworkType;
    }

    public String getProviderPhysicalNetwork() {
        return providerPhysicalNetwork;
    }

    public void setProviderPhysicalNetwork(String providerPhysicalNetwork) {
        this.providerPhysicalNetwork = providerPhysicalNetwork;
    }

    public String getProviderSegmentationID() {
        return providerSegmentationID;
    }

    public void setProviderSegmentationID(String providerSegmentationID) {
        this.providerSegmentationID = providerSegmentationID;
    }

    @Override
    public String toString() {
        return "NeutronNetwork_Segment [ " +
               ", providerNetworkType=" + providerNetworkType +
               ", providerPhysicalNetwork=" + providerPhysicalNetwork +
               ", providerSegmentationID=" + providerSegmentationID + "]";
    }
}

