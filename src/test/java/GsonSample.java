import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GsonSample {

    @Test
    public void null値をシリアライズ()
            throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(null);
        assertThat(json, is(""));
        
        Gson gsonNulls = new GsonBuilder().serializeNulls().create();
        String jsonNulls = gsonNulls.toJson(null);
        assertThat(jsonNulls, is("null"));
    }

    @Test
    public void JsonNull要素をnullにシリアライズ()
            throws Exception {
        Gson gson = new Gson();
        Address address = gson.fromJson("{id:1, name:test, address:null}", Address.class);
        assertThat(address.getId(), is(1));
        assertThat(address.getName(), is("test"));
        assertThat(address.getAddress(), is(nullValue()));
    }
}

class Address {
    int id;
    
    String name;
    
    String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
