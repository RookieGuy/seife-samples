package com.uc_mobileapps.seifesample01.bo;

import android.content.Context;

import com.uc_mobileapps.seifesample01.bo.schema.OrderSchema;
import com.weebmeister.seife.anno.ForeignkeyDef;
import com.weebmeister.seife.anno.GeneratorOption;
import com.weebmeister.seife.anno.SeifeClass;
import com.weebmeister.seife.anno.SeifeField;
import com.weebmeister.seife.anno.SqlFieldOptions;

import java.util.Date;

/**
 * Created by Klaus on 10.03.2017.
 */
@SeifeClass(
        generatorOptions = {
				GeneratorOption.BOCLASS, GeneratorOption.SCHEMA_PEER,
				GeneratorOption.DB_HELPER+"=CustomerDB",
				GeneratorOption.DATA_PROVIDER+"=CustomerProvider"
		},
		sqlTablename = "purchaseOrder",
        description="Defines a simple many to one relation")
public class Order {
    @SeifeField(isPrimaryKey = true)
    private Long id;

    @SeifeField(mandatory = true, sqlOptions = @SqlFieldOptions(sqlIndex = "idxOrderDate"))
    private Date orderDate;

	/**
	 * The foreign key field 'fkField' refers to {@link #customer},
	 * it will be set via {@link #setCustomer(Customer)}.
	 */
    @SeifeField(foreignKey = @ForeignkeyDef(fkField = "customer", refKeyField="id", refClass=Customer.class))
    private Long customerId;

	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	//[begin seife autogenerated@
	/** 
	 * Resolve the field via the foreign key and the provider. 
	 * By not caching the reference to the foreign object this can also be passed through IPC 
	 * @param context
	 * @return
	 */	public Customer getCustomer(Context context) {						
		return OrderSchema.instance().resolveCustomerField(context, this);	
	}

 	/**
	 * Setter for the java reference.
	 * Also sets the technical foreign key reference fields based on the instance 
	 * @param fk if null the foreign key reference is cleared
	 */
	public void setCustomer(Customer fk) {
		this.customer = fk;
		if (fk == null) {
			setCustomerId(null);
			return;
		}
		setCustomerId(fk.getId());
	}


	//@end seife autogenerated]




}
