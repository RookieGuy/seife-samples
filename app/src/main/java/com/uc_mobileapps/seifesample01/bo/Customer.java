package com.uc_mobileapps.seifesample01.bo;

import com.weebmeister.seife.anno.GeneratorOption;
import com.weebmeister.seife.anno.SeifeClass;
import com.weebmeister.seife.anno.SeifeField;

import android.content.Context;

/**
 * Created by Klaus on 10.03.2017.
 */
@SeifeClass(
        generatorOptions = {
                GeneratorOption.BOCLASS, GeneratorOption.SCHEMA_PEER,
                GeneratorOption.DB_HELPER+"=CustomerDB",
                GeneratorOption.DATA_PROVIDER+"=CustomerProvider"
        },
        description = "A customer object, since this is a source annotation it won't occur in " +
        "the final class and has no runtime dependencies")
public class Customer {

    @SeifeField(isPrimaryKey = true,
        description="a simple primary key field")
    private Long id;

    @SeifeField(mandatory = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	//[begin seife autogenerated@

	//@end seife autogenerated]


}
