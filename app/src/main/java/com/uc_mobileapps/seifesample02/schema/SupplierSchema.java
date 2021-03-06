package com.uc_mobileapps.seifesample02.schema;
import android.content.ContentValues;
import android.database.Cursor;

import com.uc_mobileapps.seifesample02.Supplier;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class SupplierSchema { 
	//[begin seife autogenerated@

	/**
	 * Table name of the Supplier table
	 */
	public static String TBL_SUPPLIER = "supplier";
	

	public static String COL_ID = "id";

	public static String COL_ADR_DELIVERYCITY = "adrDeliverycity";

	public static String COL_ADR_DELIVERYHOUSE_NUMBER = "adrDeliveryhouseNumber";

	public static String COL_ADR_DELIVERYSTATE = "adrDeliverystate";

	public static String COL_ADR_DELIVERYSTREET = "adrDeliverystreet";

	public static String COL_ADR_DELIVERYZIPCODE = "adrDeliveryzipcode";

	public static String COL_ADR_SOURCECITY = "adrSourcecity";

	public static String COL_ADR_SOURCEHOUSE_NUMBER = "adrSourcehouseNumber";

	public static String COL_ADR_SOURCESTATE = "adrSourcestate";

	public static String COL_ADR_SOURCESTREET = "adrSourcestreet";

	public static String COL_ADR_SOURCEZIPCODE = "adrSourcezipcode";

	/** Fully qualified column name of {@link #COL_ID */
	public static String COL_ID_FQN = "supplier.id";

	/** Fully qualified column name of {@link #COL_ADR_DELIVERYCITY */
	public static String COL_ADR_DELIVERYCITY_FQN = "supplier.adrDeliverycity";

	/** Fully qualified column name of {@link #COL_ADR_DELIVERYHOUSE_NUMBER */
	public static String COL_ADR_DELIVERYHOUSE_NUMBER_FQN = "supplier.adrDeliveryhouseNumber";

	/** Fully qualified column name of {@link #COL_ADR_DELIVERYSTATE */
	public static String COL_ADR_DELIVERYSTATE_FQN = "supplier.adrDeliverystate";

	/** Fully qualified column name of {@link #COL_ADR_DELIVERYSTREET */
	public static String COL_ADR_DELIVERYSTREET_FQN = "supplier.adrDeliverystreet";

	/** Fully qualified column name of {@link #COL_ADR_DELIVERYZIPCODE */
	public static String COL_ADR_DELIVERYZIPCODE_FQN = "supplier.adrDeliveryzipcode";

	/** Fully qualified column name of {@link #COL_ADR_SOURCECITY */
	public static String COL_ADR_SOURCECITY_FQN = "supplier.adrSourcecity";

	/** Fully qualified column name of {@link #COL_ADR_SOURCEHOUSE_NUMBER */
	public static String COL_ADR_SOURCEHOUSE_NUMBER_FQN = "supplier.adrSourcehouseNumber";

	/** Fully qualified column name of {@link #COL_ADR_SOURCESTATE */
	public static String COL_ADR_SOURCESTATE_FQN = "supplier.adrSourcestate";

	/** Fully qualified column name of {@link #COL_ADR_SOURCESTREET */
	public static String COL_ADR_SOURCESTREET_FQN = "supplier.adrSourcestreet";

	/** Fully qualified column name of {@link #COL_ADR_SOURCEZIPCODE */
	public static String COL_ADR_SOURCEZIPCODE_FQN = "supplier.adrSourcezipcode";
	
	/**
	 * All columns
	 */
	public static String[] COLUMNS = new String[] { COL_ID, COL_ADR_DELIVERYCITY, COL_ADR_DELIVERYHOUSE_NUMBER, COL_ADR_DELIVERYSTATE, COL_ADR_DELIVERYSTREET, COL_ADR_DELIVERYZIPCODE, COL_ADR_SOURCECITY, COL_ADR_SOURCEHOUSE_NUMBER, COL_ADR_SOURCESTATE, COL_ADR_SOURCESTREET, COL_ADR_SOURCEZIPCODE	};

	/**
	 * Table creation script
	 */
	public static final String SQL_CREATE_TABLE_SUPPLIER =
			"create table " + TBL_SUPPLIER + " (" +
					COL_ID + " integer primary key autoincrement," +
					COL_ADR_DELIVERYCITY + " text," +
					COL_ADR_DELIVERYHOUSE_NUMBER + " text," +
					COL_ADR_DELIVERYSTATE + " text," +
					COL_ADR_DELIVERYSTREET + " text," +
					COL_ADR_DELIVERYZIPCODE + " text," +
					COL_ADR_SOURCECITY + " text," +
					COL_ADR_SOURCEHOUSE_NUMBER + " text," +
					COL_ADR_SOURCESTATE + " text," +
					COL_ADR_SOURCESTREET + " text," +
					COL_ADR_SOURCEZIPCODE + " text" +
					")";


 

	private static SupplierSchema schema = new SupplierSchema();
	public static SupplierSchema instance() {
		return schema;
	}

	/**
	 * Checks for mandatory constraints defined on fields
	 */
	public boolean checkConstraints(ContentValues contentValues) {
		return true;
	}
	
	/**
	 * Gets all attribute values of the bo as key value pairs
	 * @param bo may not be null
	 * @return new instance of {@link ContentValues}
	 */
	public ContentValues getContentValues(Supplier bo) {
		ContentValues contentValues = new ContentValues();

		if (bo.getId() != null) {
			contentValues.put(COL_ID, bo.getId());
		}
		contentValues.put(COL_ADR_DELIVERYCITY, bo.getDeliveryAddress().getCity());
		contentValues.put(COL_ADR_DELIVERYHOUSE_NUMBER, bo.getDeliveryAddress().getHouseNumber());
		contentValues.put(COL_ADR_DELIVERYSTATE, bo.getDeliveryAddress().getState());
		contentValues.put(COL_ADR_DELIVERYSTREET, bo.getDeliveryAddress().getStreet());
		contentValues.put(COL_ADR_DELIVERYZIPCODE, bo.getDeliveryAddress().getZipcode());
		contentValues.put(COL_ADR_SOURCECITY, bo.getSourceAddress().getCity());
		contentValues.put(COL_ADR_SOURCEHOUSE_NUMBER, bo.getSourceAddress().getHouseNumber());
		contentValues.put(COL_ADR_SOURCESTATE, bo.getSourceAddress().getState());
		contentValues.put(COL_ADR_SOURCESTREET, bo.getSourceAddress().getStreet());
		contentValues.put(COL_ADR_SOURCEZIPCODE, bo.getSourceAddress().getZipcode());
		return contentValues;
	}

	/**
	 * Sets all attributes from the cursor
	 * @param cursorFrom the cursor to read from
	 * @param bo may be null
	 * @return the bo passed as a parameter or a new instance
	 */
	public Supplier readFromCursor(Cursor cursorFrom, Supplier bo)
	{
		if (bo == null) {
			bo = new Supplier();
		}
		final Cursor c = cursorFrom; 

		bo.setId(c.isNull(c.getColumnIndex(COL_ID)) ? null : c.getLong(c.getColumnIndex(COL_ID)));
		bo.getDeliveryAddress().setCity(c.getString(c.getColumnIndex(COL_ADR_DELIVERYCITY)));
		bo.getDeliveryAddress().setHouseNumber(c.getString(c.getColumnIndex(COL_ADR_DELIVERYHOUSE_NUMBER)));
		bo.getDeliveryAddress().setState(c.getString(c.getColumnIndex(COL_ADR_DELIVERYSTATE)));
		bo.getDeliveryAddress().setStreet(c.getString(c.getColumnIndex(COL_ADR_DELIVERYSTREET)));
		bo.getDeliveryAddress().setZipcode(c.getString(c.getColumnIndex(COL_ADR_DELIVERYZIPCODE)));
		bo.getSourceAddress().setCity(c.getString(c.getColumnIndex(COL_ADR_SOURCECITY)));
		bo.getSourceAddress().setHouseNumber(c.getString(c.getColumnIndex(COL_ADR_SOURCEHOUSE_NUMBER)));
		bo.getSourceAddress().setState(c.getString(c.getColumnIndex(COL_ADR_SOURCESTATE)));
		bo.getSourceAddress().setStreet(c.getString(c.getColumnIndex(COL_ADR_SOURCESTREET)));
		bo.getSourceAddress().setZipcode(c.getString(c.getColumnIndex(COL_ADR_SOURCEZIPCODE)));
		return bo;
	}
	
	
	/**
	 * @return hard-coded table creation and index scripts
	 */
	public List<String> getTableScripts() {
		List<String> result = new ArrayList<String>();
		result.add(SQL_CREATE_TABLE_SUPPLIER); 
		return result;
	}

 
	//@end seife autogenerated]

	
}
