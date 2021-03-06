/**
 * 
 */
package com.uc_mobileapps.seifesample01.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.uc_mobileapps.seifesample01.db.CustomerDB;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.uc_mobileapps.seifesample01.bo.Customer;
import com.uc_mobileapps.seifesample01.bo.Order;
import com.uc_mobileapps.seifesample01.bo.schema.CustomerSchema;
import com.uc_mobileapps.seifesample01.bo.schema.OrderSchema;

/**
 * Content provider implementation for com.uc_mobileapps.seifesample01.bo.Customer, com.uc_mobileapps.seifesample01.bo.Order * @author ${properties.author}
 */
public class CustomerProvider extends ContentProvider {

	/**
	 * Pass a query limit to the provider
	 */
	public static final String QUERY_PARAMETER_LIMIT = "_limit";

	/**
	 * Pass a having clause to the provider
	 */
	public static final String QUERY_PARAMETER_HAVING = "_having";

	/**
	 * Pass a group by to the provider
	 */
	public static final String QUERY_PARAMETER_GROUP_BY = "_groupby";


	/* (non-Javadoc)
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		if (!seifeCreate()) {
			return false;
		}
		return true;
	}

	//[begin seife autogenerated@
	
	/**
	 * Content-Provider Authority for Uris (is in the demo package for historical reasons)
	 */
	public static final String AUTHORITY = "com.uc_mobileapps.seifesample01.provider";

	/**
	 * Better don't use this directly, use {@link #getContentUriCustomer()} instead
	 */
	public static Uri CONTENT_URI_CUSTOMER = Uri.parse("content://" + AUTHORITY + "/" + CustomerSchema.TBL_CUSTOMER);

	/**
	 * Better don't use this directly, use {@link #getContentUriOrder()} instead
	 */
	public static Uri CONTENT_URI_ORDER = Uri.parse("content://" + AUTHORITY + "/" + OrderSchema.TBL_ORDER);

	/**
	 * Uri for com.uc_mobileapps.seifesample01.bo.Customer
	 */
	public static Uri getContentUriCustomer() {
		return CONTENT_URI_CUSTOMER;
	}
	
	/**
	 * Explicit URI configuration
	 */
	public static void setContentUriCustomer(Uri uri) {
		CONTENT_URI_CUSTOMER = uri;
	}

	/**
	 * Uri for com.uc_mobileapps.seifesample01.bo.Order
	 */
	public static Uri getContentUriOrder() {
		return CONTENT_URI_ORDER;
	}
	
	/**
	 * Explicit URI configuration
	 */
	public static void setContentUriOrder(Uri uri) {
		CONTENT_URI_ORDER = uri;
	}


	/**
	 * Code for urimatcher of the content provider
	 */
	protected static final int URI_CODE_CUSTOMER = 0;
	/**
	 * Customer by id uri
	 */
	protected static final int URI_CODE_CUSTOMER_ID = 1;

	/**
	 * Customer for batch updates
	 */
	protected static final int URI_CODE_CUSTOMER_NO_NOTIFY_ID = 2;

	/**
	 * Code for urimatcher of the content provider
	 */
	protected static final int URI_CODE_ORDER = 3;
	/**
	 * Order by id uri
	 */
	protected static final int URI_CODE_ORDER_ID = 4;

	/**
	 * Order for batch updates
	 */
	protected static final int URI_CODE_ORDER_NO_NOTIFY_ID = 5;

	

	/**
	 * The database helper class where the table definitions reside
	 */
	private com.uc_mobileapps.seifesample01.db.CustomerDB dbHelper;

	/**
	 * Autogenerated provider onCreate
	 * @see CustomerProvider#onCreate()
	 */
	public boolean seifeCreate() {
		dbHelper = new com.uc_mobileapps.seifesample01.db.CustomerDB(getContext());
		return true;
	}

	/**
	 * Uri Matcher of the content provider
	 */
	private UriMatcher uriMatcher;

	/**
	 * @return
	 */
	protected UriMatcher getUriMatcher() {
		if (uriMatcher == null) {
			uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
 			uriMatcher.addURI(AUTHORITY, CustomerSchema.TBL_CUSTOMER, URI_CODE_CUSTOMER);
			uriMatcher.addURI(AUTHORITY, CustomerSchema.TBL_CUSTOMER + "/#", URI_CODE_CUSTOMER_ID);
			uriMatcher.addURI(AUTHORITY, CustomerSchema.TBL_CUSTOMER + "/batch/#", URI_CODE_CUSTOMER_NO_NOTIFY_ID);
  			uriMatcher.addURI(AUTHORITY, OrderSchema.TBL_ORDER, URI_CODE_ORDER);
			uriMatcher.addURI(AUTHORITY, OrderSchema.TBL_ORDER + "/#", URI_CODE_ORDER_ID);
			uriMatcher.addURI(AUTHORITY, OrderSchema.TBL_ORDER + "/batch/#", URI_CODE_ORDER_NO_NOTIFY_ID);
  		}
		return uriMatcher;
	}
	
	/**
	 * (non-Javadoc)
	 */
	@Override
	public String getType(Uri uri) {
		switch (getUriMatcher().match(uri)) {
 
		case URI_CODE_CUSTOMER:
			return ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd." + Customer.class.getPackage() + "." + CustomerSchema.TBL_CUSTOMER;
		case URI_CODE_CUSTOMER_ID:
			return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + Customer.class.getPackage() + "." + CustomerSchema.TBL_CUSTOMER;
		case URI_CODE_CUSTOMER_NO_NOTIFY_ID:
			return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + Customer.class.getPackage() + "." + CustomerSchema.TBL_CUSTOMER;
 
		case URI_CODE_ORDER:
			return ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd." + Order.class.getPackage() + "." + OrderSchema.TBL_ORDER;
		case URI_CODE_ORDER_ID:
			return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + Order.class.getPackage() + "." + OrderSchema.TBL_ORDER;
		case URI_CODE_ORDER_NO_NOTIFY_ID:
			return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + Order.class.getPackage() + "." + OrderSchema.TBL_ORDER;
		}
		return null;
	}

	/**
	 * Inserts a new object to the database
	 * @return the uri of the created object, null if the mandatory check failed 
	 * @see android.content.ContentProvider\#insert(android.net.Uri, android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long rowId;
		switch (getUriMatcher().match(uri))
		{
		case URI_CODE_CUSTOMER:
			if (!CustomerSchema.instance().checkConstraints(values)) {
				return null;
			}
			rowId = db.insert(CustomerSchema.TBL_CUSTOMER, null, values);
			if (rowId > 0) {
				Uri resUri = ContentUris.withAppendedId(uri, rowId);
				getContext().getContentResolver().notifyChange(resUri, null);
				return resUri;
			}
			break;
		case URI_CODE_CUSTOMER_ID: //unimplemented since id is generated
			break;
		case URI_CODE_ORDER:
			if (!OrderSchema.instance().checkConstraints(values)) {
				return null;
			}
			rowId = db.insert(OrderSchema.TBL_ORDER, null, values);
			if (rowId > 0) {
				Uri resUri = ContentUris.withAppendedId(uri, rowId);
				getContext().getContentResolver().notifyChange(resUri, null);
				return resUri;
			}
			break;
		case URI_CODE_ORDER_ID: //unimplemented since id is generated
			break;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider\#update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) 
	{
		int rowsAffected = 0;
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int matchId = getUriMatcher().match(uri);
		String[] primaryKey;
		switch (matchId)
		{
		case URI_CODE_CUSTOMER_ID:
		case URI_CODE_CUSTOMER_NO_NOTIFY_ID:
			primaryKey = new String[] { uri.getQueryParameter(CustomerSchema.COL_ID) };
			rowsAffected = db.update(CustomerSchema.TBL_CUSTOMER, values,  CustomerSchema.COL_ID + " = ?" , primaryKey);
			break;
		case URI_CODE_ORDER_ID:
		case URI_CODE_ORDER_NO_NOTIFY_ID:
			primaryKey = new String[] { uri.getQueryParameter(OrderSchema.COL_ID) };
			rowsAffected = db.update(OrderSchema.TBL_ORDER, values,  OrderSchema.COL_ID + " = ?" , primaryKey);
			break;
		default:
			break;
		}
		if (rowsAffected > 0) {
			switch (matchId) {
			case URI_CODE_CUSTOMER_ID:
			case URI_CODE_ORDER_ID:
				getContext().getContentResolver().notifyChange(uri, null);			
				break;
			default: 
				break;
			}
		}	
		return rowsAffected;
	}
	
	/* (non-Javadoc)
	 * @see android.content.ContentProvider\#delete(android.net.Uri, java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int rowsAffected = 0;

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] primaryKey;
		int matchId = getUriMatcher().match(uri);
		switch (matchId)
		{
		case URI_CODE_CUSTOMER_ID:
		case URI_CODE_CUSTOMER_NO_NOTIFY_ID:
			primaryKey = new String[] { uri.getQueryParameter(CustomerSchema.COL_ID) };
			rowsAffected = db.delete(CustomerSchema.TBL_CUSTOMER,CustomerSchema.COL_ID + " = ?" , primaryKey);
			if (rowsAffected > 0) {
				getContext().getContentResolver().notifyChange(uri, null);			
			}
			break;
		case URI_CODE_ORDER_ID:
		case URI_CODE_ORDER_NO_NOTIFY_ID:
			primaryKey = new String[] { uri.getQueryParameter(OrderSchema.COL_ID) };
			rowsAffected = db.delete(OrderSchema.TBL_ORDER,OrderSchema.COL_ID + " = ?" , primaryKey);
			if (rowsAffected > 0) {
				getContext().getContentResolver().notifyChange(uri, null);			
			}
			break;
		default:
			break;
		}

		if (rowsAffected > 0) {
			switch (matchId) {
			case URI_CODE_CUSTOMER_ID:
			case URI_CODE_ORDER_ID:
				getContext().getContentResolver().notifyChange(uri, null);			
				break;
			default: 
				break;
			}
		}
		return rowsAffected;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider\#query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selectionParam,
			String[] selectionParamArgs, String sortOrder) {
		StringBuilder selection = new StringBuilder();;
		List<String> selectionArgs = new ArrayList<String>();
		
		String groupBy = uri.getQueryParameter(QUERY_PARAMETER_GROUP_BY);
		String having = uri.getQueryParameter(QUERY_PARAMETER_HAVING);
		String limit = uri.getQueryParameter(QUERY_PARAMETER_LIMIT);
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		int matchId = getUriMatcher().match(uri);
		switch (matchId) {
		case URI_CODE_CUSTOMER:
			qb.setTables(CustomerSchema.TBL_CUSTOMER);
			if (selectionParam != null) {
				selection.append(selectionParam);
			}
			if (selectionParamArgs != null) {
				selectionArgs = Arrays.asList(selectionParamArgs);
			}
					break;
		case URI_CODE_CUSTOMER_ID:
		case URI_CODE_CUSTOMER_NO_NOTIFY_ID:
			qb.setTables(CustomerSchema.TBL_CUSTOMER);
			selection
			.append(CustomerSchema.COL_ID + " = ?");
						selectionArgs.add(uri.getQueryParameter(CustomerSchema.COL_ID));
		break;
		case URI_CODE_ORDER:
			qb.setTables(OrderSchema.TBL_ORDER);
			if (selectionParam != null) {
				selection.append(selectionParam);
			}
			if (selectionParamArgs != null) {
				selectionArgs = Arrays.asList(selectionParamArgs);
			}
					break;
		case URI_CODE_ORDER_ID:
		case URI_CODE_ORDER_NO_NOTIFY_ID:
			qb.setTables(OrderSchema.TBL_ORDER);
			selection
			.append(OrderSchema.COL_ID + " = ?");
						selectionArgs.add(uri.getQueryParameter(OrderSchema.COL_ID));
		break;
		default:
			return null;
		}
				Cursor c = qb.query(dbHelper.getReadableDatabase(), projection, selection.toString(), selectionArgs.toArray(new String[selectionArgs.size()]), groupBy, having, sortOrder, limit);

		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}
	//@end seife autogenerated]



}
