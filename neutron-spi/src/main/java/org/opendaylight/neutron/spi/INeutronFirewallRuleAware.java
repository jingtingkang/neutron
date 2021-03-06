/*
 * Copyright (C) 2014 Red Hat, Inc.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.spi;

/**
 * This interface defines the methods a service that wishes to be aware of Firewall Rules needs to implement
 * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
 * the scope of neutron northbound
 *
 * @deprecated
 *
 */

public interface INeutronFirewallRuleAware {

    /**
     * Services provide this interface method to indicate if the specified firewallRule can be created
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param firewallRule
     *            instance of proposed new Firewall Rule object
     * @return integer
     *            the return value is understood to be a HTTP status code.  A return value outside of 200 through 299
     *            results in the create operation being interrupted and the returned status value reflected in the
     *            HTTP response.
     */
    public int canCreateNeutronFirewallRule(NeutronFirewallRule firewallRule);

    /**
     * Services provide this interface method for taking action after a firewallRule has been created
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param firewallRule
     *            instance of new Firewall Rule object
     */
    public void neutronFirewallRuleCreated(NeutronFirewallRule firewallRule);

    /**
     * Services provide this interface method to indicate if the specified firewallRule can be changed using the specified
     * delta
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param delta
     *            updates to the firewallRule object using patch semantics
     * @param original
     *            instance of the Firewall Rule object to be updated
     * @return integer
     *            the return value is understood to be a HTTP status code.  A return value outside of 200 through 299
     *            results in the update operation being interrupted and the returned status value reflected in the
     *            HTTP response.
     */
    public int canUpdateNeutronFirewallRule(NeutronFirewallRule delta, NeutronFirewallRule original);

    /**
     * Services provide this interface method for taking action after a firewallRule has been updated
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param firewallRule
     *            instance of modified Firewall Rule object
     */
    public void neutronFirewallRuleUpdated(NeutronFirewallRule firewallRule);

    /**
     * Services provide this interface method to indicate if the specified firewallRule can be deleted
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param firewallRule
     *            instance of the Firewall Rule object to be deleted
     * @return integer
     *            the return value is understood to be a HTTP status code.  A return value outside of 200 through 299
     *            results in the delete operation being interrupted and the returned status value reflected in the
     *            HTTP response.
     */
    public int canDeleteNeutronFirewallRule(NeutronFirewallRule firewallRule);

    /**
     * Services provide this interface method for taking action after a firewallRule has been deleted
     * Deprecated as all Neutron FWaaS is experimental and so doesn't meet 
     * the scope of neutron northbound
     *
     * @deprecated
     *
     * @param firewallRule
     *            instance of deleted Firewall Rule object
     */
    public void neutronFirewallRuleDeleted(NeutronFirewallRule firewallRule);
}
