package com.uc_mobileapps.tests.sqlite.bo;

import android.os.Parcel;
import android.os.Parcelable;

import com.weebmeister.seife.anno.GeneratorOption;
import com.weebmeister.seife.anno.SeifeClass;
import com.weebmeister.seife.anno.SeifeField;

import android.content.Context;

/**
 * Created by Klaus on 10.03.2017.
 */
@SeifeClass(
        version=2,
        generatorOptions = {
                GeneratorOption.BOCLASS_PARCELABLE, GeneratorOption.SCHEMA_PEER,
                GeneratorOption.DB_HELPER+"=GeneralTestsDBOpenHelper",
                GeneratorOption.DATA_PROVIDER+"=GeneralTestsProvider"
        })
public class Version2 implements Parcelable {

    @SeifeField(isPrimaryKey = true)
    private Long id;

    @SeifeField(version=3)
    private String addedInV3;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddedInV3() {
        return addedInV3;
    }

    public void setAddedInV3(String addedInV3) {
        this.addedInV3 = addedInV3;
    }
	//[begin seife autogenerated@


	public static final String PARCELABLE_NAME = "com.uc_mobileapps.tests.sqlite.bo.Version2";
	public static final Parcelable.Creator<Version2> CREATOR = new Parcelable.Creator<Version2>() {

		@Override
		public Version2 createFromParcel(Parcel source) 
		{
			Version2 instance = new Version2();
			instance.readFromParcel(source);
			return instance;
		}

		@Override
		public Version2[] newArray(int size) {
			return new Version2[size];
		}	
	};

	@Override
	public int describeContents() { //relevant to parcel filedescriptors only, leave zero
		return 0;
	}
	

	public void readFromParcel(Parcel source) {
		String s;
		s=source.readString(); setId((s!=null) ? Long.parseLong(s) : null);
		setAddedInV3(source.readString());
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString((getId()!=null) ? Long.toString(getId()) : null);
		dest.writeString(getAddedInV3());
	}
		//@end seife autogenerated]


}
