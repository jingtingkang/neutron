/*
 * Copyright (C) 2014 Red Hat, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.northbound.api;

import org.opendaylight.neutron.spi.NeutronFirewallRule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class NeutronFirewallRuleRequest {
    /**
     * See OpenStack Network API v2.0 Reference for description of
     * http://docs.openstack.org/api/openstack-network/2.0/content/
     *
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     */

    @XmlElement(name="firewall_rule")
    NeutronFirewallRule singletonFirewallRule;

    @XmlElement(name="firewall_rules")
    List<NeutronFirewallRule> bulkRequest;

    NeutronFirewallRuleRequest() {
    }

    NeutronFirewallRuleRequest(List<NeutronFirewallRule> bulk) {
        bulkRequest = bulk;
        singletonFirewallRule = null;
    }

    NeutronFirewallRuleRequest(NeutronFirewallRule group) {
        singletonFirewallRule = group;
    }

    public List<NeutronFirewallRule> getBulk() {
        return bulkRequest;
    }

    public NeutronFirewallRule getSingleton() {
        return singletonFirewallRule;
    }

    public boolean isSingleton() {
        return (singletonFirewallRule != null);
    }
}
