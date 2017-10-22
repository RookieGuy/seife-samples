package com.uc_mobileapps.seifesample02.delivery.schema;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.uc_mobileapps.seifesample02.delivery.Delivery;
import com.uc_mobileapps.seifesample02.delivery.Product;

import java.util.ArrayList;
import java.util.List;

import com.uc_mobileapps.seifesample02.delivery.schema.DeliverySchema;

public class DeliverySchema { 
	//[begin seife autogenerated@

	/**
	 * Table name of the Delivery table
	 */
	public static String TBL_DELIVERY = "delivery";
	

	public static String COL_ID = "id";

	public static String COL_FK_PRODUCT_PRODUCT_ID = "productId";

	public static String COL_PRODUCT_DESCRIPTION = "product_description";

	public static String COL_PRODUCT_NAME = "product_name";

	public static String COL_PRODUCT_PRICE = "product_price";

	/** Fully qualified column name of {@link #COL_ID */
	public static String COL_ID_FQN = "delivery.id";

	/** Fully qualified column name of {@link #COL_FK_PRODUCT_PRODUCT_ID */
	public static String COL_FK_PRODUCT_PRODUCT_ID_FQN = "delivery.productId";

	/** Fully qualified column name of {@link #COL_PRODUCT_DESCRIPTION */
	public static String COL_PRODUCT_DESCRIPTION_FQN = "delivery.product_description";

	/** Fully qualified column name of {@link #COL_PRODUCT_NAME */
	public static String COL_PRODUCT_NAME_FQN = "delivery.product_name";

	/** Fully qualified column name of {@link #COL_PRODUCT_PRICE */
	public static String COL_PRODUCT_PRICE_FQN = "delivery.product_price";
	
	/**
	 * All columns
	 */
	public static String[] COLUMNS = new String[] { COL_ID, COL_FK_PRODUCT_PRODUCT_ID, COL_PRODUCT_DESCRIPTION, COL_PRODUCT_NAME, COL_PRODUCT_PRICE	};

	/**
	 * Table creation script
	 */
	public static final String SQL_CREATE_TABLE_DELIVERY =
			"create table " + TBL_DELIVERY + " (" +
					COL_ID + " integer primary key autoincrement," +
					COL_FK_PRODUCT_PRODUCT_ID + " integer," +
					COL_PRODUCT_DESCRIPTION + " text," +
					COL_PRODUCT_NAME + " text," +
					COL_PRODUCT_PRICE + " text" +
					", " +
					" FOREIGN KEY(" + COL_FK_PRODUCT_PRODUCT_ID  + ")" +
					" REFERENCES " + ProductSchema.TBL_PRODUCT 
					+"(" + ProductSchema.COL_ID  + ")" +			 		
					")";


	public static final String JOIN_PRODUCT =	
		"JOIN " + ProductSchema.TBL_PRODUCT + 
		" ON (" + COL_FK_PRODUCT_PRODUCT_ID_FQN + " = " + ProductSchema.COL_ID_FQN  + ")";  

	private static DeliverySchema schema = new DeliverySchema();
	public static DeliverySchema instance() {
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
	public ContentValues getContentValues(Delivery bo) {
		ContentValues contentValues = new ContentValues();

		if (bo.getId() != null) {
			contentValues.put(COL_ID, bo.getId());
		}
		contentValues.put(COL_FK_PRODUCT_PRODUCT_ID, bo.getProductId());
		contentValues.put(COL_PRODUCT_DESCRIPTION, bo.getProductAtOrderTime().getDescription());
		contentValues.put(COL_PRODUCT_NAME, bo.getProductAtOrderTime().getName());
		contentValues.put(COL_PRODUCT_PRICE, (bo.getProductAtOrderTime().getPrice()!=null) ?  bo.getProductAtOrderTime().getPrice().toString() : null);
		return contentValues;
	}

	/**
	 * Sets all attributes from the cursor
	 * @param cursorFrom the cursor to read from
	 * @param bo may be null
	 * @return the bo passed as a parameter or a new instance
	 */
	public Delivery readFromCursor(Cursor cursorFrom, Delivery bo)
	{
		if (bo == null) {
			bo = new Delivery();
		}
		final Cursor c = cursorFrom; 

		bo.setId(c.isNull(c.getColumnIndex(COL_ID)) ? null : c.getLong(c.getColumnIndex(COL_ID)));
		bo.setProductId(c.isNull(c.getColumnIndex(COL_FK_PRODUCT_PRODUCT_ID)) ? null : c.getLong(c.getColumnIndex(COL_FK_PRODUCT_PRODUCT_ID)));
		bo.getProductAtOrderTime().setDescription(c.getString(c.getColumnIndex(COL_PRODUCT_DESCRIPTION)));
		bo.getProductAtOrderTime().setName(c.getString(c.getColumnIndex(COL_PRODUCT_NAME)));
		bo.getProductAtOrderTime().setPrice(c.isNull(c.getColumnIndex(COL_PRODUCT_PRICE)) ? null : new java.math.BigDecimal(c.getString(c.getColumnIndex(COL_PRODUCT_PRICE))));
		return bo;
	}
	
	
	/**
	 * @return hard-coded table creation and index scripts
	 */
	public List<String> getTableScripts() {
		List<String> result = new ArrayList<String>();
		result.add(SQL_CREATE_TABLE_DELIVERY); 
		return result;
	}

	/** 
	 * Resolves the Product instance for the Delivery#product field
	 * @param context the ContentResolver is obtained from there
	 * @param bo the business object to get the foreign key reference from
	 * @return
	 */
	public Product resolveProductField(Context context, Delivery bo) {
		ContentResolver contentResolver = context.getContentResolver();
		String selection = null;
		String[] selectionArgs = null;

		Uri uri = com.uc_mobileapps.seifesample02.provider.SupplierProvider.getContentUriProduct().buildUpon()
				.appendQueryParameter(ProductSchema.COL_ID, String.valueOf(bo.getId()))
				.build();
		Cursor cursor = contentResolver.query(uri, ProductSchema.COLUMNS, selection, selectionArgs, null);
		try {
			Product foreignInstance = 
					ProductSchema.instance().readFromCursor(cursor, new Product());
			//bo.setProduct(foreignInstance);
			return foreignInstance;
		} finally {
			cursor.close();
		}
	}
  
	//@end seife autogenerated]

	
}
