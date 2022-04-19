import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Produtor {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            for (int i=1;i<=5;i++){
                String severity = "fila_1";
                String message = i + "ª Mensagem para '" + severity + "'";
                channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("[+] Enviado para " + severity + ": " + message);
            }

            for (int i=1;i<=5;i++){
                String severity = "fila_2";
                String message = i + "ª Mensagem para '" + severity + "'";
                channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println("[+] Enviado para " + severity + ": " + message);
            }

            String severity = "fila_2";
            String message = "DIEGO FRANKNEY FRAZÃO DA SILVA";
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[+] Enviado para " + severity + ": " + message);
        }
    }

}


