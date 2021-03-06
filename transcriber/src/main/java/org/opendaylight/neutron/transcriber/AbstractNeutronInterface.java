package org.opendaylight.neutron.transcriber;

import java.util.concurrent.ExecutionException;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.TransactionCommitFailedException;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev130715.Uuid;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.util.concurrent.CheckedFuture;

public abstract class AbstractNeutronInterface<T extends DataObject,S> implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(AbstractNeutronInterface.class);

    private ProviderContext providerContext;
    private DataBroker db;

    AbstractNeutronInterface(ProviderContext providerContext) {
        this.providerContext = providerContext;
        this.db = providerContext.getSALService(DataBroker.class);
    }

    public DataBroker getDataBroker() {
        return db;
    }

    protected abstract InstanceIdentifier<T> createInstanceIdentifier(T item);

    protected abstract T toMd(S neutronObject);

    protected abstract T toMd(String uuid);

    protected boolean addMd(S neutronObject) {
        // TODO think about adding existence logic
        WriteTransaction transaction = getDataBroker().newWriteOnlyTransaction();
        T item = toMd(neutronObject);
        InstanceIdentifier<T> iid = createInstanceIdentifier(item);
        transaction.put(LogicalDatastoreType.CONFIGURATION, iid, item,true);
        CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            logger.warn("Transation failed ",e);
            return false;
        }
        return true;
    }

    protected boolean updateMd(S neutronObject) {
        WriteTransaction transaction = getDataBroker().newWriteOnlyTransaction();
        T item = toMd(neutronObject);
        InstanceIdentifier<T> iid = createInstanceIdentifier(item);
        transaction.put(LogicalDatastoreType.CONFIGURATION, iid, item,true);
        CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            logger.warn("Transation failed ",e);
            return false;
        }
        return true;
    }

    protected boolean removeMd(T item) {
        WriteTransaction transaction = getDataBroker().newWriteOnlyTransaction();
        InstanceIdentifier<T> iid = createInstanceIdentifier(item);
        transaction.delete(LogicalDatastoreType.CONFIGURATION, iid);
        CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
        return true;
    }

    protected Uuid toUuid(String uuid) {
        Preconditions.checkNotNull(uuid);
        Uuid result;
        try {
            result = new Uuid(uuid);
        } catch(IllegalArgumentException e) {
            // OK... someone didn't follow RFC 4122... lets try this the hard way
            String dedashed = uuid.replace("-", "");
            if(dedashed.length() == 32) {
                String redashed = dedashed.substring(0, 8) // 8 chars
                        + "-"
                        + dedashed.substring(8, 12) // 4 chars
                        + "-"
                        + dedashed.substring(12, 16) // 4 chars
                        + "-"
                        + dedashed.substring(16, 20) // 4 chars
                        + "-"
                        + dedashed.substring(20, 32); // 12 chars
                result = new Uuid(redashed);
            } else {
                throw e;
            }
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub

    }

}
