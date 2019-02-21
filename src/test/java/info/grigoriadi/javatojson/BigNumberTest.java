package info.grigoriadi.javatojson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.owlike.genson.Genson;
import org.apache.johnzon.jsonb.JohnzonBuilder;
import org.eclipse.yasson.internal.JsonBindingBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.json.bind.Jsonb;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Tests how mappers handle {@link Long}, {@link BigDecimal} and {@link BigInteger} types.
 */
public class BigNumberTest {

    private BigNumberPojo pojo;

    @Before
    public void setUp() {
        pojo = new BigNumberPojo();
        pojo.setId(Long.MAX_VALUE);
        pojo.setAmount(new BigDecimal("850006245121695744.1"));
        pojo.setCount(new BigInteger("9007199254740993"));
    }

    @Test
    public void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        String value = mapper.writeValueAsString(pojo);
        System.out.println("Jackson: " + value);
    }

    @Test
    public void testGson() {
        GsonBuilder builder = new GsonBuilder();//.setLongSerializationPolicy(LongSerializationPolicy.STRING);
        Gson gson = builder.create();
        String json = gson.toJson(pojo);
        System.out.println("Gson: " + json);
    }

    @Test
    public void testGenson() {
        String json = new Genson().serialize(pojo);
        System.out.println("Genson: " + json);
    }

    @Test
    public void testJohnzon() {
        Jsonb jsonb = new JohnzonBuilder().build();
        String json = jsonb.toJson(pojo);
        System.out.println("Johnzon: " + json);
    }

    @Test
    public void testYasson() {
        Jsonb jsonb = new JsonBindingBuilder().build();
        String json = jsonb.toJson(pojo);
        System.out.println("Yasson: " + json);
    }

}
