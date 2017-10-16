package com.uc_mobileapps.seifesample02.delivery;

import android.os.Parcel;
import android.os.Parcelable;

import com.weebmeister.seife.anno.GeneratorOption;
import com.weebmeister.seife.anno.SeifeClass;
import com.weebmeister.seife.anno.SeifeEmbedded;
import com.weebmeister.seife.anno.SeifeField;

import android.content.Context;

/**
 * Created by Klaus on 04.04.2017.
 */
@SeifeClass(
        generatorOptions = {
                GeneratorOption.BOCLASS_PARCELABLE, GeneratorOption.SCHEMA_PEER,
                GeneratorOption.DB_HELPER+"=com.uc_mobileapps.seifesample02.db.SupplierDB",
                GeneratorOption.DATA_PROVIDER+"=com.uc_mobileapps.seifesample02.provider.SupplierProvider"
        })
public class Product implements Parcelable {

    @SeifeField(isPrimaryKey = true)
    private Long id;

    @SeifeEmbedded
    private ProductData data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductData getData() {
        if (data == null) {
            data = new ProductData();
        }
        return data;
    }

    public void setData(ProductData data) {
        this.data = data;
    }
	//[begin seife autogenerated@


	public static final String PARCELABLE_NAME = "com.uc_mobileapps.seifesample02.delivery.Product";
	public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {

		@Override
		public Product createFromParcel(Parcel source) 
		{
			Product instance = new Product();
			instance.readFromParcel(source);
			return instance;
		}

		@Override
		public Product[] newArray(int size) {
			return new Product[size];
		}	
	};

	@Override
	public int describeContents() { //relevant to parcel filedescriptors only, leave zero
		return 0;
	}
	

	public void readFromParcel(Parcel source) {
		String s;
		s=source.readString(); id = (s!=null) ? Long.parseLong(s) : null;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString((id!=null) ? Long.toString(id) : null);
	}
		//@end seife autogenerated]

}