package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {

    MessageCodesResolver messageCodesResolve = new DefaultMessageCodesResolver();

    @Test
    public void messageCodeResolverObject() {

        String[] messageCodes = messageCodesResolve.resolveMessageCodes("required", "item");
        for (String messageCode : messageCodes) {
            System.out.println(messageCode);
        }

        Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
    }
    
    @Test
    public void messageCodesResolverField() throws Exception{
        String[] messageCodes = messageCodesResolve.resolveMessageCodes("required", "item", "itemName",String.class);
        for (String messageCode : messageCodes) {
            System.out.println(messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required");
    }
}
